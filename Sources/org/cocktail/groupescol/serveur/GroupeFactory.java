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
package org.cocktail.groupescol.serveur;

import java.util.HashMap;

import org.cocktail.groupescol.serveur.eof.GenericFactory;
import org.cocktail.groupescol.serveur.eof.ScolFormationAnnee;
import org.cocktail.groupescol.serveur.eof.ScolGroupeCollection;
import org.cocktail.groupescol.serveur.eof.ScolGroupeGrp;
import org.cocktail.groupescol.serveur.eof.ScolGroupeInclusion;
import org.cocktail.groupescol.serveur.eof.ScolGroupeIncompatibilite;
import org.cocktail.groupescol.serveur.eof.ScolGroupeObjet;
import org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant;
import org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp;
import org.cocktail.groupescol.serveur.eof.ScolMaquetteAp;
import org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre;
import org.cocktail.groupescol.serveur.exception.GroupeException;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;

public class GroupeFactory {

	private EOEditingContext eContext;

	public GroupeFactory(EOEditingContext eContext) {
		this.eContext = eContext;
	}

	/** renvoie true si la collection existe, false sinon */
	public boolean collectionExiste(String libelle, Number debutValidite) {
		EOQualifier qColl = EOQualifier.qualifierWithQualifierFormat("gcolLibelle=%@ and gcolDateDebut=%@", new NSArray(new Object[] { libelle,
				debutValidite }));
		return (DBHandler.fetchData(eContext, "ScolGroupeCollection", qColl).count() > 0);
	}

	/** permet de creer les groupes de la collection */
	public NSArray creerGroupesPourCollection(ScolGroupeCollection collection, HashMap colMap) throws GroupeException {

		Integer nombreGroupes = (Integer) colMap.get("nombreGroupes");
		String prefixeGroupe = (String) colMap.get("prefixeGroupe");
		Integer debutValidite = (Integer) colMap.get("debutValidite");
		Integer finValidite = (Integer) colMap.get("finValidite");
		Integer capacite = (Integer) colMap.get("capacite");
		Integer capaciteInt = (Integer) colMap.get("capaciteInt");
		String maxTem = (String) colMap.get("maxTem");

		// rattachement au semestre et eventuellement aux aps du semestre.
		ScolMaquetteSemestre semestre = (ScolMaquetteSemestre) colMap.get("semestre");
		NSArray aps = (NSArray) colMap.get("aps");
		// creation des groupes
		for (int i = 0; i < nombreGroupes.intValue(); i++) {
			ScolGroupeGrp groupe = (ScolGroupeGrp) GenericFactory.getInstance(eContext, "ScolGroupeGrp");
			groupe.setGgrpDateDebut(debutValidite);
			groupe.setGgrpDateFin(finValidite);
			groupe.setGgrpIntCapacite(capaciteInt);
			String ggrpCode = prefixeGroupe + String.valueOf(i + 1);

			groupe.setGgrpCode(ggrpCode);
			groupe.setGgrpLibelle(ggrpCode);
			groupe.setGgrpMaxCapacite(capacite);
			groupe.setGgrpMaxTemoin(maxTem);
			collection.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrps");

			groupe.addObjectToBothSidesOfRelationshipWithKey(collection, "scolGroupeCollection");

			// rattachement au semestre
			ScolGroupeObjet groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
			groupeObjet.setGobjType("VDI");
			groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semestre.scolFormationAnnee(), "scolFormationAnnee");
			groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
			groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semestre, "scolMaquetteSemestre");

			// rattachement aux aps
			for (int iap = 0; iap < aps.count(); iap++) {
				ScolMaquetteAp currentAp = (ScolMaquetteAp) aps.objectAtIndex(iap);
				groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
				groupeObjet.setGobjType("ELP");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(semestre.scolFormationAnnee(), "scolFormationAnnee");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(currentAp, "scolMaquetteAp");
			}

		}

		// creation des incompatibilites
		NSArray groupes = (NSArray) collection.valueForKey("scolGroupeGrps");
		for (int i = 0; i < groupes.count(); i++) {
			ScolGroupeGrp grp1 = (ScolGroupeGrp) groupes.objectAtIndex(i);
			for (int j = 0; j < groupes.count(); j++) {
				if (i != j) {
					ScolGroupeGrp grp2 = (ScolGroupeGrp) groupes.objectAtIndex(j);
					ScolGroupeIncompatibilite incomp;
					incomp = (ScolGroupeIncompatibilite) GenericFactory.getInstance(eContext, "ScolGroupeIncompatibilite");
					incomp.addObjectToBothSidesOfRelationshipWithKey(grp1, "scolGroupeGrp1");
					incomp.addObjectToBothSidesOfRelationshipWithKey(grp2, "scolGroupeGrp2");
				}
			}
		}

		return groupes;
	}

	/** supprime correctement un groupe */
	public void supprimerGroupe(ScolGroupeGrp groupe, ScolFormationAnnee annee) throws GroupeException {
		/*
		 * NSArray incompatibilites = groupe.groupeIncompatibilite1();
		 * 
		 * for(int i=0;i<incompatibilites.count();i++) { ScolGroupeIncompatibilite incomp =
		 * (ScolGroupeIncompatibilite)incompatibilites.objectAtIndex(i);
		 * incomp.removeObjectFromBothSidesOfRelationshipWithKey(incomp.scolGroupeGrp2(),"scolGroupeGrp2");
		 * incomp.removeObjectFromBothSidesOfRelationshipWithKey(incomp.scolGroupeGrp1(),"scolGroupeGrp1"); eContext.deleteObject(incomp); }
		 * 
		 * // inclusions NSMutableArray inclus = new NSMutableArray();
		 * inclus.addObjectsFromArray((NSArray)groupe.valueForKey("inclusFils"));
		 * inclus.addObjectsFromArray((NSArray)groupe.valueForKey("inclusPere")); EOGenericRecord inclu, pere, fils;
		 * 
		 * for (int i = 0; i < inclus.count(); i++) { inclu = (EOGenericRecord)inclus.objectAtIndex(i); pere =
		 * (EOGenericRecord)inclu.valueForKey("scolGroupeGrpPere"); fils = (EOGenericRecord)inclu.valueForKey("scolGroupeGrpFils");
		 * inclu.removeObjectFromBothSidesOfRelationshipWithKey(pere, "scolGroupeGrpPere");
		 * inclu.removeObjectFromBothSidesOfRelationshipWithKey(fils, "scolGroupeGrpFils"); eContext.deleteObject(inclu); }
		 * 
		 * NSArray affs = (NSArray)groupe.valueForKey("scolInscriptionGrps"); ScolInscriptionEtudiant etudiant; ScolInscriptionGrp aff;
		 * 
		 * while (affs.count() != 0) { aff = (ScolInscriptionGrp)affs.lastObject(); etudiant =
		 * (ScolInscriptionEtudiant)aff.valueForKey("scolInscriptionEtudiant"); aff.removeObjectFromBothSidesOfRelationshipWithKey(groupe,
		 * "scolGroupeGrp"); aff.removeObjectFromBothSidesOfRelationshipWithKey(etudiant, "scolInscriptionEtudiant");
		 * eContext.deleteObject(aff); }
		 */
		NSArray groupeObjets = (NSArray) groupe.valueForKey("scolGroupeObjets");
		for (int j = 0; j < groupeObjets.count(); j++) {
			ScolGroupeObjet grpObjet = (ScolGroupeObjet) groupeObjets.objectAtIndex(j);
			eContext.deleteObject(grpObjet);
		}
		ScolGroupeCollection collection = groupe.scolGroupeCollection();
		groupe.removeObjectFromBothSidesOfRelationshipWithKey(collection, "scolGroupeCollection");
		eContext.deleteObject(groupe);
	}

	/** permet de creer une collection de groupes */
	public ScolGroupeCollection creerCollection(HashMap colMap) throws GroupeException {

		String libelleCollection = (String) colMap.get("libelleCollection");
		colMap.get("nombreGroupes");
		colMap.get("prefixeGroupe");
		Integer debutValidite = (Integer) colMap.get("debutValidite");
		Integer finValidite = (Integer) colMap.get("finValidite");
		colMap.get("capacite");
		colMap.get("capaciteInt");

		if (collectionExiste(libelleCollection, debutValidite)) {
			throw new GroupeException("La collection " + libelleCollection + " existe deja pour " + debutValidite);
		}

		ScolGroupeCollection collection = (ScolGroupeCollection) GenericFactory.getInstance(eContext, "ScolGroupeCollection");
		collection.setGcolDateDebut(debutValidite);
		collection.setGcolDateFin(finValidite);
		collection.setGcolLibelle(libelleCollection);

		this.creerGroupesPourCollection(collection, colMap);

		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception exe) {
			exe.printStackTrace();
			eContext.revert();
			collection = null;
		}
		finally {
			eContext.unlock();
		}
		return collection;
	}

	/**
	 * permet de supprimer une collection, en supprimant tous ses groupes
	 * 
	 * @deprecated
	 */
	public boolean supprimerCollection(ScolGroupeCollection collection) throws GroupeException {

		NSArray groupes = collection.scolGroupeGrps();
		// suppression du rattachement au semestre et aux ap et les incompatibilites
		for (int i = 0; i < groupes.count(); i++) {
			this.supprimerGroupe((ScolGroupeGrp) groupes.objectAtIndex(i), collection.scolFormationAnnee());
		}
		eContext.deleteObject(collection);

		return doSaveChanges();
	}

	/** permet de supprimer un ensemble de collections */
	public boolean supprimerCollections(NSArray collections) throws GroupeException {

		for (int ic = 0; ic < collections.count(); ic++) {
			ScolGroupeCollection collection = (ScolGroupeCollection) collections.objectAtIndex(ic);
			NSArray groupes = collection.scolGroupeGrps();
			// suppression du rattachement au semestre et aux ap et les incompatibilites
			for (int i = 0; i < groupes.count(); i++) {
				this.supprimerGroupe((ScolGroupeGrp) groupes.objectAtIndex(i), collection.scolFormationAnnee());
			}
			eContext.deleteObject(collection);
		}
		return doSaveChanges();
	}

	/** modifier la collection donnee avec les nouveaux parametres contenus dans colMap */
	public boolean modifierApsPourCollection(ScolGroupeCollection collection, NSArray aps) throws GroupeException {
		NSMutableArray apsDemandes = aps.mutableClone();

		NSArray groupes = collection.scolGroupeGrps();
		NSArray apsExistants = getApsForGroupe((ScolGroupeGrp) groupes.objectAtIndex(0));

		NSLog.out.appendln("apsExistants=" + apsExistants);
		NSLog.out.appendln("apsDemandes=" + apsDemandes);

		for (int i = 0; i < apsExistants.count(); i++) {
			ScolMaquetteAp currentAp = (ScolMaquetteAp) apsExistants.objectAtIndex(i);
			if (!apsDemandes.containsObject(currentAp)) {
				NSLog.out.appendln("retirer=" + currentAp);
				retirerApPourCollection(collection, currentAp);
			}
			else {
				apsDemandes.removeObject(currentAp);
			}
		}

		NSLog.out.appendln("reste a affecter=" + apsDemandes);
		affecterApsPourCollection(collection, apsDemandes);

		return doSaveChanges();
	}

	/** permet de detacher l'ap de tous les groupes de la collection en parametre /!\ sans faire de saveChanges */
	private void retirerApPourCollection(ScolGroupeCollection collection, ScolMaquetteAp ap) {
		NSArray groupes = collection.scolGroupeGrps();
		ScolGroupeObjet groupeObjet = null;

		for (int i = 0; i < groupes.count(); i++) {
			ScolGroupeGrp grp = (ScolGroupeGrp) groupes.objectAtIndex(i);
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolGroupeGrp=%@ and scolMaquetteAp=%@ gobjType='ELP'", new NSArray(
					new Object[] { grp, ap }));

			NSArray tmpArray = DBHandler.fetchData(eContext, "ScolGroupeObjet", qualObj);
			for (int j = 0; j < tmpArray.count(); j++) {
				groupeObjet = (ScolGroupeObjet) tmpArray.objectAtIndex(j);
				groupeObjet.removeObjectFromBothSidesOfRelationshipWithKey(ap.scolFormationAnnee(), "scolFormationAnnee");
				groupeObjet.removeObjectFromBothSidesOfRelationshipWithKey(grp, "scolGroupeGrp");
				groupeObjet.removeObjectFromBothSidesOfRelationshipWithKey(ap, "scolMaquetteAp");
				eContext.deleteObject(groupeObjet);
			}
		}
	}

	/** affecte les Aps a tous les groupes de la collection, /!\ sans faire de saveChanges */
	private void affecterApsPourCollection(ScolGroupeCollection collection, NSArray aps) {
		NSArray groupes = collection.scolGroupeGrps();
		ScolGroupeObjet groupeObjet = null;
		for (int i = 0; i < groupes.count(); i++) {
			ScolGroupeGrp groupe = (ScolGroupeGrp) groupes.objectAtIndex(i);
			// rattachement aux aps
			for (int iap = 0; iap < aps.count(); iap++) {
				ScolMaquetteAp currentAp = (ScolMaquetteAp) aps.objectAtIndex(iap);
				groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
				groupeObjet.setGobjType("ELP");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(currentAp.scolFormationAnnee(), "scolFormationAnnee");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(currentAp, "scolMaquetteAp");
			}
		}
	}

	/** renvoie true si l'etudiant est inscrit au groupe, false sinon */
	public boolean etudiantInscritDansGroupe(ScolInscriptionEtudiant etudiant, ScolGroupeGrp groupe) throws GroupeException {
		EOQualifier qualifEtudiant = DBHandler.getSimpleQualifier("scolInscriptionEtudiant", etudiant);
		return (DBHandler.fetchData(eContext, "ScolInscriptionGrp", qualifEtudiant).count() > 0);
	}

	/** permet d'inscrire les etudiants du semestre (SCOL_INSCRIPTION_ETUDIANT) au groupe (SCOL_INSCRIPTION_GRP) */
	public NSArray ajouterEtudiantsAuGroupe(NSArray etudiants, ScolGroupeGrp groupe, ScolFormationAnnee annee) throws GroupeException {

		NSMutableArray inscriptionsGrp = new NSMutableArray();

		// NSMutableArray totalGroupes = new NSMutableArray();
		// totalGroupes.addObject(groupe);
		// totalGroupes.addObjectsFromArray( parentsPourGroupe(groupe) );

		// for(int ig=0;ig<totalGroupes.count();ig++) {
		// ScolGroupeGrp currentGroupe = (ScolGroupeGrp)totalGroupes.objectAtIndex(ig);

		for (int i = 0; i < etudiants.count(); i++) {
			ScolInscriptionEtudiant etudiant = (ScolInscriptionEtudiant) etudiants.objectAtIndex(i);

			if (etudiantInscritDansGroupe(etudiant, groupe)) {
				throw new GroupeException("L'etudiant " + etudiant + " est deja dans le groupe " + groupe);
			}
			else {
				ScolInscriptionGrp incriptionGrp = (ScolInscriptionGrp) GenericFactory.getInstance(eContext, "ScolInscriptionGrp");
				incriptionGrp.setIggrpTemoinSelection("N");
				incriptionGrp.addObjectToBothSidesOfRelationshipWithKey(etudiant, "scolInscriptionEtudiant");
				incriptionGrp.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
				incriptionGrp.addObjectToBothSidesOfRelationshipWithKey(annee, "scolFormationAnnee");
				inscriptionsGrp.addObject(incriptionGrp);
			}
		}
		// }

		eContext.insertedObjects();
		eContext.updatedObjects();

		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception exe) {
			exe.printStackTrace();
			eContext.revert();
			inscriptionsGrp.removeAllObjects();
		}
		finally {
			eContext.unlock();
		}
		return inscriptionsGrp;
	}

	/** supprime les inscriptions au groupe passees en parametre (SCOL_INSCRIPTION_GRP) */
	public boolean retirerEtudiantsDuGroupe(NSArray inscriptionsGrp) throws GroupeException {

		for (int i = 0; i < inscriptionsGrp.count(); i++) {
			ScolInscriptionGrp incriptionGrp = (ScolInscriptionGrp) inscriptionsGrp.objectAtIndex(i);
			incriptionGrp.removeObjectFromBothSidesOfRelationshipWithKey(incriptionGrp.scolInscriptionEtudiant(), "scolInscriptionEtudiant");
			incriptionGrp.removeObjectFromBothSidesOfRelationshipWithKey(incriptionGrp.scolGroupeGrp(), "scolGroupeGrp");
			incriptionGrp.removeObjectFromBothSidesOfRelationshipWithKey(incriptionGrp.scolFormationAnnee(), "scolFormationAnnee");
			eContext.deleteObject(incriptionGrp);
		}

		return doSaveChanges();
	}

	/**
	 * permet d'inclure un ensemble de groupes dans un autre groupe (SCOL_GROUPE_INCLUSION) dans cette table ggrp_key1 est le pere et
	 * ggrp_key2 est le fils
	 */
	public boolean inclureGroupesDansGroupe(NSArray groupesAInclure, ScolGroupeGrp selectedGroupe) throws GroupeException {

		if (selectedGroupe == null || groupesAInclure.count() == 0) {
			return false;
		}

		NSArray dejaInclus = (NSArray) selectedGroupe.valueForKeyPath("inclusFils.scolGroupeGrpFils");

		// test si pas deja inclus
		for (int i = 0; i < groupesAInclure.count(); i++) {
			ScolGroupeGrp filsAInclure = (ScolGroupeGrp) groupesAInclure.objectAtIndex(i);

			if (dejaInclus.containsObject(filsAInclure)) {
				throw new GroupeException("le groupe " + filsAInclure + " est deja inclus dans le groupe " + selectedGroupe);
			}

			NSArray inclusDansFils = (NSArray) filsAInclure.valueForKeyPath("inclusFils.scolGroupeGrpFils");

			if (inclusDansFils.containsObject(selectedGroupe)) {
				StringBuffer msg = new StringBuffer();
				msg.append("le groupe ");
				msg.append(selectedGroupe.toString());
				msg.append(" est deja inclus dans le groupe ");
				msg.append(filsAInclure.toString());
				msg.append("\nImpossible d'inclure un groupe pere dans un groupe fils");
				throw new GroupeException(msg.toString());
			}
			ScolGroupeInclusion inclusion = (ScolGroupeInclusion) GenericFactory.getInstance(eContext, "ScolGroupeInclusion");
			inclusion.addObjectToBothSidesOfRelationshipWithKey(selectedGroupe, "scolGroupeGrpPere");
			inclusion.addObjectToBothSidesOfRelationshipWithKey(filsAInclure, "scolGroupeGrpFils");
		}

		boolean retour = true;
		try {
			eContext.lock();
			eContext.saveChanges();
		}
		catch (Exception exe) {
			exe.printStackTrace();
			eContext.revert();
			retour = false;
		}
		finally {
			eContext.unlock();
		}
		return retour;
	}

	/** supprime proprement une inclusion */
	public boolean supprimerInclusion(ScolGroupeInclusion inclusion) throws GroupeException {

		inclusion.removeObjectFromBothSidesOfRelationshipWithKey(inclusion.scolGroupeGrpFils(), "scolGroupeGrpFils");
		inclusion.removeObjectFromBothSidesOfRelationshipWithKey(inclusion.scolGroupeGrpPere(), "scolGroupeGrpPere");
		eContext.deleteObject(inclusion);
		return doSaveChanges();
	}

	/** retourne les ancetres du groupe */
	public NSArray parentsPourGroupe(ScolGroupeGrp groupe) {

		NSArray ascendants = new NSArray();
		NSArray peres = (NSArray) groupe.valueForKey("inclusPere");

		for (int i = 0; i < peres.count(); i++) {
			ScolGroupeInclusion inclusion = (ScolGroupeInclusion) peres.objectAtIndex(i);
			ScolGroupeGrp unPere = inclusion.scolGroupeGrpPere();
			if (unPere != null) {
				ascendants = ascendants.arrayByAddingObject(unPere);
				ascendants = ascendants.arrayByAddingObjectsFromArray(parentsPourGroupe(unPere));
			}
		}
		return ascendants;
	}

	/** effectue un save changes et renvoie true si ok, false si erreur */
	public boolean doSaveChanges() throws GroupeException {
		boolean retour = true;
		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception exe) {
			exe.printStackTrace();
			eContext.revert();
			retour = false;
		}
		finally {
			eContext.unlock();
		}
		return retour;
	}

	// methodes souvent utilisees.
	public NSArray getApsForGroupe(ScolGroupeGrp grp) {
		if (grp != null) {
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolGroupeGrp=%@ and gobjType='ELP'", new NSArray(grp));

			NSArray tmpArray = DBHandler.fetchData(eContext, "ScolGroupeObjet", qualObj);
			return (NSArray) tmpArray.valueForKey("scolMaquetteAp");
		}
		else {
			return new NSArray();
		}
	}

	public NSArray getGroupesForAp(ScolMaquetteAp ap) {
		if (ap != null) {
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolMaquetteAp=%@ and gobjType='ELP'", new NSArray(ap));

			NSArray tmpArray = DBHandler.fetchData(eContext, "ScolGroupeObjet", qualObj);
			return (NSArray) tmpArray.valueForKey("scolGroupeGrp");
		}
		else {
			return new NSArray();
		}
	}

	/** permet de recuperer les groupes enfants du dernier niveau (qui n'ont pas de fils) du groupe en parametres */
	public NSArray enfantsVentiles(ScolGroupeGrp groupe) {
		NSMutableArray children = new NSMutableArray();
		NSArray fils = (NSArray) groupe.valueForKeyPath("inclusFils.scolGroupeGrpFils");

		if (fils.count() > 0) {
			for (int i = 0; i < fils.count(); i++) {
				children.addObjectsFromArray(enfantsVentiles((ScolGroupeGrp) fils.objectAtIndex(i)));
			}
		}
		else {
			children.addObject(groupe);
		}
		return children;
	}

}
