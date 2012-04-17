/*
 * Copyright COCKTAIL (www.cocktail.org), 2001, 2012 
 * 
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software. You can use, 
 * modify and/or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading, using, modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also
 * therefore means that it is reserved for developers and experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and, more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package org.cocktail.groupescol.client;

import java.util.ArrayList;
import java.util.Iterator;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolGroupeObjet;
import org.cocktail.groupescol.client.eof.ScolMaquetteAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;
import org.cocktail.groupescol.client.eof.ScolTransfertGrp;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

public class GroupeCopier {

	private EOEditingContext eContext;
	private GroupeFactory grpFactory;
	ScolMaquetteSemestre semSrc, semDst;
	ScolFormationAnnee formAnneeDst;

	private ArrayList lstOldGroupe, lstNewGroupe;

	NSMutableDictionary listeGroupesRecopies;

	public GroupeCopier(EOEditingContext eContext) {
		this.eContext = eContext;
		grpFactory = new GroupeFactory(eContext);
		lstOldGroupe = new ArrayList();
		lstNewGroupe = new ArrayList();
	}

	public void setSemestreSrc(ScolMaquetteSemestre semSrc) {
		this.semSrc = semSrc;
	}

	public void setSemestreDst(ScolMaquetteSemestre semDst) {
		this.semDst = semDst;
	}

	public void setFormAnneeDst(ScolFormationAnnee formAnneeDst) {
		this.formAnneeDst = formAnneeDst;
	}

	public ScolGroupeCollection recopierCollection(ScolGroupeCollection oldCollection) {
		ScolGroupeCollection collection = (ScolGroupeCollection) GenericFactory.getInstance(eContext, "ScolGroupeCollection");
		collection.setGcolDateDebut(oldCollection.gcolDateDebut());
		collection.setGcolDateFin(oldCollection.gcolDateFin());
		collection.setGcolLibelle(oldCollection.gcolLibelle());
		return collection;
	}

	/** fait une copie de 'oldGroupe' et l'attache a la collection 'coll' et au semestre 'semDst' */
	public void recopierGroupe(ScolGroupeGrp oldGroupe, ScolGroupeCollection collection) {

		ScolGroupeGrp groupe = (ScolGroupeGrp) GenericFactory.getInstance(eContext, "ScolGroupeGrp");
		groupe.setGgrpDateDebut(formAnneeDst.fannDebut());
		groupe.setGgrpDateFin(formAnneeDst.fannFin());
		groupe.setGgrpIntCapacite(oldGroupe.ggrpIntCapacite());
		groupe.setGgrpCode(oldGroupe.ggrpCode());
		groupe.setGgrpLibelle(oldGroupe.ggrpLibelle());
		groupe.setGgrpMaxCapacite(oldGroupe.ggrpMaxCapacite());
		groupe.setGgrpMaxTemoin(oldGroupe.ggrpMaxTemoin());
		collection.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrps");
		groupe.addObjectToBothSidesOfRelationshipWithKey(collection, "scolGroupeCollection");

		NSArray aps = grpFactory.getApsForGroupe(oldGroupe);
		ScolMaquetteAp currentOldAp, currentNewAp;
		// rattachement a l'ap
		for (int i = 0; i < aps.count(); i++) {
			currentOldAp = (ScolMaquetteAp) aps.objectAtIndex(i);
			currentNewAp = getApTranfertMap(currentOldAp);

			if (currentNewAp != null) {
				ScolGroupeObjet groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
				groupeObjet.setGobjType("ELP");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semDst.scolFormationAnnee(), "scolFormationAnnee");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(currentNewAp, "scolMaquetteAp");
			}
		}
		// rattachement au semestre
		ScolGroupeObjet groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
		groupeObjet.setGobjType("VDI");
		groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semDst.scolFormationAnnee(), "scolFormationAnnee");
		groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
		groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semDst, "scolMaquetteSemestre");

		if (oldGroupe != null && groupe != null) {
			lstOldGroupe.add(oldGroupe);
			lstNewGroupe.add(groupe);
		}

	}

	/** remplirTransfertGrp : association entre l'ancien groupe et sa recopie : pour etre retrouve lors de la recopie d'Edt */
	public void remplirTransfertGrp() {

		Iterator iOldGrp = lstOldGroupe.iterator();
		Iterator iNewdGrp = lstNewGroupe.iterator();
		ScolGroupeGrp oldGrp, newGrp;

		while (iOldGrp.hasNext() && iNewdGrp.hasNext()) {
			oldGrp = (ScolGroupeGrp) iOldGrp.next();
			newGrp = (ScolGroupeGrp) iNewdGrp.next();
			ScolTransfertGrp transfertGrp = (ScolTransfertGrp) GenericFactory.getInstance(eContext, "ScolTransfertGrp");
			newGrp.addObjectToBothSidesOfRelationshipWithKey(transfertGrp, "newGrp");
			oldGrp.addObjectToBothSidesOfRelationshipWithKey(transfertGrp, "oldGrp");
		}

		lstOldGroupe.clear();
		lstNewGroupe.clear();
	}

	/** retourne l'ap recopie de l'annee precedentes */
	public ScolMaquetteAp getApTranfertMap(ScolMaquetteAp oldAp) {
		EOQualifier qualAp = DBHandler.getSimpleQualifier("oldAp", oldAp);
		EOGenericRecord transfertAp = DBHandler.fetchUniqueData(eContext, "ScolTransfertMap", qualAp);
		if (transfertAp != null) {
			return (ScolMaquetteAp) transfertAp.valueForKey("newAp");
		}
		else {
			return null;
		}
	}

	/** retourne le groupe recopie de l'annee precedentes */
	public ScolGroupeGrp getGrpTranfertGrp(ScolGroupeGrp oldGrp) {
		EOQualifier qualGrp = DBHandler.getSimpleQualifier("oldGrp", oldGrp);
		EOGenericRecord transfertGrp = DBHandler.fetchUniqueData(eContext, "ScolTransfertGrp", qualGrp);
		if (transfertGrp != null) {
			return (ScolGroupeGrp) transfertGrp.valueForKey("newGrp");
		}
		else {
			return null;
		}
	}

}
