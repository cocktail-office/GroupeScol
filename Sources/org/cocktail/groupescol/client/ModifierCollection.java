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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolMaquetteAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteHoraireCode;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;
import org.cocktail.groupescol.client.eof.ScolMaquetteTypeEc;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOArchive;
import com.webobjects.eoapplication.EOModalDialogController;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableArray;

public class ModifierCollection extends EOModalDialogController {

	private MainClient app = (MainClient) EOApplication.sharedApplication();
	public JButton bAjouterAp, bRechercher, bRetirerAp, bModifierLibelle;
	public JComboBox comboMHCOCode, comboTypeEc;
	public EODisplayGroup eodApRattaches, eodScolMaquetteAp;
	public EOTable tableApRattaches, tableScolMaquetteAp;
	public JTextField tSeuil, tLibelleCol;
	public JCheckBox cEcLibre;

	private EOSortOrdering sortEc, sortAp;
	private EOEditingContext eContext;

	ScolGroupeCollection collection;
	ScolMaquetteSemestre semestre;
	ScolFormationAnnee annee;

	public ModifierCollection(ScolGroupeCollection collection) {
		super();
		this.collection = collection;
		this.eContext = app.editingContext();
		EOEditingContext.setSubstitutionEditingContext(eContext);
		EOArchive.loadArchiveNamed("ModifierCollection", this, "org.cocktail.groupescol.client", this.disposableRegistry());
		establishConnection();
	}

	protected void connectionWasEstablished() {

		sortAp = EOSortOrdering.sortOrderingWithKey("mapLibelle", EOSortOrdering.CompareCaseInsensitiveAscending);
		sortEc = EOSortOrdering.sortOrderingWithKey("scolMaquetteRepartitionAps.scolMaquetteEc.mecLibelleCourt",
				EOSortOrdering.CompareCaseInsensitiveAscending);

		EOQualifier qualTypeEc = EOQualifier.qualifierWithQualifierFormat("mtecValidite='O'", null);

		NSArray tmp = DBHandler.fetchData(eContext, "ScolMaquetteTypeEc", qualTypeEc);
		comboTypeEc.removeAllItems();
		comboTypeEc.addItem("Tous");
		for (int i = 0; i < tmp.count(); i++) {
			comboTypeEc.addItem(tmp.objectAtIndex(i));
		}

		tmp = app.groupeFactory().getHoraireCode();
		comboMHCOCode.removeAllItems();

		for (int i = 0; i < tmp.count(); i++) {
			comboMHCOCode.addItem(tmp.objectAtIndex(i));
		}
		comboMHCOCode.addItem("Tous");

		NSArray groupes = collection.scolGroupeGrps();
		if (groupes.count() > 0) {
			ScolGroupeGrp groupe = (ScolGroupeGrp) groupes.objectAtIndex(0);
			eodApRattaches.setObjectArray(app.groupeFactory().getApsForGroupe(groupe));
			WidgetHandler.informObservingAssociation(eodApRattaches);
		}

		tLibelleCol.setText(collection.gcolLibelle());
	}

	protected void componentDidBecomeVisible() {
		setWindowTitle(this.window(), "Modification de la collection : \"" + collection + "\"");
		WidgetHandler.setTableNotEditable(tableApRattaches);
		WidgetHandler.setTableNotEditable(tableScolMaquetteAp);
		WidgetHandler.decorateButton("Rechercher les AP", null, "find", bRechercher);
		WidgetHandler.decorateButton("Retirer l'AP de la collection", null, "up", bRetirerAp);
		WidgetHandler.decorateButton("Ajouter l'AP à la collection", null, "down", bAjouterAp);
		WidgetHandler.decorateButton("Enregistrer le nouveau libellé de la collection", "Enregister", "save", bModifierLibelle);
	}

	public void setMaquetteSemestre(ScolMaquetteSemestre semestre) {
		this.semestre = semestre;
		this.annee = semestre.scolFormationAnnee();
	}

	/** ajoute les ap selectionnes a la collection */
	public void ajouterAp(Object sender) {

		WindowHandler.setWaitCursor(this.component());

		NSMutableArray ap = eodScolMaquetteAp.selectedObjects().mutableClone();
		NSArray apAffectes = eodApRattaches.displayedObjects();
		ap.removeObjectsInArray(apAffectes);
		app.groupeFactory().affecterApsPourCollection(collection, ap, annee);
		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception exe) {
			WindowHandler.showError(exe.getMessage());
			exe.printStackTrace();
			eContext.revert();
		}
		finally {
			eContext.unlock();
		}
		WidgetHandler.addObjectsToEOD(ap, eodApRattaches);
		WidgetHandler.removeObjectsFromEOD(ap, eodScolMaquetteAp);

		WindowHandler.setDefaultCursor(this.component());
	}

	/** permet d'effectuer une recherche d'AP */
	public void rechercherAp(Object sender) {

		WindowHandler.setWaitCursor(this.component());

		Number fannKey = annee.fannKey();
		String mhcoCode = null;

		Object selectedMHCO = comboMHCOCode.getSelectedItem();
		if (selectedMHCO instanceof ScolMaquetteHoraireCode) {
			mhcoCode = ((ScolMaquetteHoraireCode) selectedMHCO).mhcoCode();
		}

		String sseuil = tSeuil.getText();
		Number seuil = null;
		if (!sseuil.equals("")) {
			seuil = FormatHandler.strToInteger(sseuil);
		}

		NSMutableArray sumQuals = new NSMutableArray();

		if (annee != null && semestre != null) {
			sumQuals.addObject(EOQualifier.qualifierWithQualifierFormat("vSemestreAp.fannKey=%@ and vSemestreAp.semestre=%@", new NSArray(
					new Object[] { fannKey, semestre })));

			if (mhcoCode != null) {
				sumQuals.addObject(DBHandler.getSimpleQualifier("vSemestreAp.ap.mhcoCode", mhcoCode));
			}

			if (seuil != null) {
				sumQuals.addObject(DBHandler.getSimpleQualifier("vSemestreAp.ap.mapSeuil", seuil));
			}

			eodScolMaquetteAp.setSortOrderings(new NSArray(new Object[] { sortEc, sortAp }));

			Object selectedTypeEc = comboTypeEc.getSelectedItem();
			if (selectedTypeEc instanceof ScolMaquetteTypeEc) {
				String mtecCode = ((ScolMaquetteTypeEc) selectedTypeEc).mtecCode();
				sumQuals.addObject(EOQualifier.qualifierWithQualifierFormat("vSemestreAp.repartitionEc.mtecCode = '" + mtecCode + "'", null));
			}

			NSArray arg = new NSArray(NSKeyValueCoding.NullValue);
			if (cEcLibre.isSelected()) {
				sumQuals.addObject(EOQualifier.qualifierWithQualifierFormat("vSemestreAp.ecLibre.mecKey <> %@", arg));
			}
			else {
				sumQuals.addObject(EOQualifier.qualifierWithQualifierFormat("vSemestreAp.ecLibre.mecKey = %@", arg));
			}

			NSMutableArray aps = DBHandler.fetchData(eContext, "ScolMaquetteAp", new EOAndQualifier(sumQuals)).mutableClone();
			aps.removeObjectsInArray(eodApRattaches.displayedObjects());
			eodScolMaquetteAp.setObjectArray(aps);
			WidgetHandler.selectNoneInDisplayGroup(eodScolMaquetteAp);
			WidgetHandler.informObservingAssociation(eodScolMaquetteAp);
		}
		WindowHandler.setDefaultCursor(this.component());

	}

	public void retirerAp(Object sender) {

		NSArray apARetirer = eodApRattaches.selectedObjects();
		if (apARetirer.count() > 0 && WindowHandler.showConfirmation("Vous confirmez le retrait des AP selectionnés du groupe ?")) {

			WindowHandler.setWaitCursor(this.component());

			ScolMaquetteAp currentAp;
			for (int i = 0; i < apARetirer.count(); i++) {
				currentAp = (ScolMaquetteAp) apARetirer.objectAtIndex(i);
				app.groupeFactory().retirerApPourCollection(collection, currentAp);
			}
			boolean succes = true;
			eContext.lock();
			try {
				eContext.saveChanges();
			}
			catch (Exception exe) {
				WindowHandler.showError(exe.getMessage());
				exe.printStackTrace();
				eContext.revert();
				succes = false;
			}
			finally {
				eContext.unlock();
			}

			if (succes) {
				WidgetHandler.addObjectsToEOD(apARetirer, eodScolMaquetteAp);
				WidgetHandler.removeObjectsFromEOD(apARetirer, eodApRattaches);
			}

			WindowHandler.setDefaultCursor(this.component());

		}
	}

	public void modifierLibelle() {
		String libelle = tLibelleCol.getText();
		if (libelle.equals(collection.gcolLibelle())) {
			return;
		}

		if (libelle.equals("")) {
			WindowHandler.showError("Il faut un libellé pour la collection");
		}
		else {
			WindowHandler.setWaitCursor(this.component());
			if (!WindowHandler.showConfirmation("Confirmez-vous les modifications sur la collection selectionnée ?")) {
				return;
			}

			try {
				collection.setGcolLibelle(libelle);
				collection.editingContext().saveChanges();
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			WindowHandler.setDefaultCursor(this.component());
		}
	}

}
