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

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolGroupeInclusion;
import org.cocktail.groupescol.client.eof.ScolGroupeObjet;
import org.cocktail.groupescol.client.eof.ScolInscriptionAp;
import org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant;
import org.cocktail.groupescol.client.eof.ScolInscriptionGrp;
import org.cocktail.groupescol.client.eof.ScolInscriptionSemestre;
import org.cocktail.groupescol.client.eof.ScolMaquetteAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteEc;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc;
import org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem;
import org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;
import org.cocktail.groupescol.client.eof.ScolMaquetteUe;
import org.cocktail.groupescol.client.swing.TableSorter;
import org.cocktail.groupescol.client.swing.ZEOTable;
import org.cocktail.groupescol.client.swing.ZEOTable.ZEOTableListener;
import org.cocktail.groupescol.client.swing.ZEOTableModel;
import org.cocktail.groupescol.client.swing.ZEOTableModelColumn;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableArray;

/**
 * 
 * @author pdemeyer
 */
public class Ventilation extends javax.swing.JPanel {

	private MainClient app = (MainClient) EOApplication.sharedApplication();
	private MainInterface owner;
	private EOEditingContext eContext;
	private GroupeFactory groupeFactory;
	private ScolMaquetteSemestre semestre;
	private ScolMaquetteParcours parcours;
	private ScolFormationAnnee annee;
	private EODisplayGroup eodScolGroupeGrp = new EODisplayGroup();
	private EODisplayGroup eodScolInscriptionGrp = new EODisplayGroup();
	private EODisplayGroup eodScolInscriptionSemestre = new EODisplayGroup();
	private ZEOTable tableScolGroupeGrp, tableScolInscriptionGrp, tableScolInscriptionSemestre;

	/** Creates new form Ventilation */
	public Ventilation(MainInterface mainInterface) {
		initComponents();
		this.owner = mainInterface;
		eContext = mainInterface.editingContext();
		groupeFactory = app.groupeFactory();
		init();
	}

	public void init() {
		initWidgets();
		initTables();
	}

	public void imprimer() {
		owner.lancerGestionTrombino();
	}

	/** imprimerEtudiantsAP : imprime les etudiants qui ne sont dans les groupes pour la selection courante */
	public void imprimerEtudiantsAP() {
		WindowHandler.setWaitCursor(app.mainInterface());

		JFrame frame = WindowHandler.getJFrameFromController(app.mainInterface());
		OptionsImpressionCtrl optionImp = new OptionsImpressionCtrl(frame, this);
		optionImp.setVisible(true);

		if (optionImp.isForceClosing()) {
			WindowHandler.setDefaultCursor(app.mainInterface());
			return;
		}
		boolean printAll = optionImp.isPrintAll();
		int fileType = optionImp.getFileType();

		NSArray etudiants;
		if (printAll) {
			etudiants = eodScolInscriptionSemestre.displayedObjects();
		}
		else {
			etudiants = eodScolInscriptionSemestre.selectedObjects();
		}

		if (etudiants == null || etudiants.count() == 0) {
			WindowHandler.showError("Il n'y a pas d'étudiants pour imprimer un trombino !");
			WindowHandler.setDefaultCursor(app.mainInterface());
			return;
		}
		etudiants = (NSArray) etudiants.valueForKey(ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY);
		NSMutableArray etudiantsDistincts = new NSMutableArray();
		for (int i = 0; i < etudiants.count(); i++) {
			ScolInscriptionEtudiant etud = (ScolInscriptionEtudiant) etudiants.objectAtIndex(i);
			if (((NSArray) etudiantsDistincts.valueForKey(ScolInscriptionEtudiant.ETUD_NUMERO_KEY)).containsObject(etud.etudNumero()) == false) {
				etudiantsDistincts.addObject(etud);
			}
		}

		String libelle = JOptionPane.showInputDialog("Donnez un libellé à cette liste d'étudiants");
		if (fileType == OptionsImpressionCtrl.PDF_FILE) {
			owner.imprimerTrombino(etudiantsDistincts, libelle);
		}
		else
			if (fileType == OptionsImpressionCtrl.XLS_FILE) {
				owner.listeExcel(etudiantsDistincts, libelle);
			}

		WindowHandler.setDefaultCursor(app.mainInterface());
	}

	public void semestreSelectionChanged(ScolMaquetteSemestre semestre, ScolMaquetteParcours parcours) {
		this.semestre = semestre;
		this.parcours = parcours;
		clear();
		if (semestre != null) {
			annee = semestre.scolFormationAnnee();
			afficherGroupesPourSemestre();
		}
	}

	private void afficherGroupesPourSemestre() {
		if (semestre == null) {
			return;
		}
		eodScolInscriptionSemestre.setObjectArray(NSArray.EmptyArray);
		tableScolInscriptionSemestre.updateData();
		ScolFormationAnnee annee = semestre.scolFormationAnnee();
		NSMutableArray quals = new NSMutableArray();
		quals.addObject(new EOKeyValueQualifier(ScolGroupeGrp.SCOL_GROUPE_OBJETS_KEY + "." + ScolGroupeObjet.SCOL_FORMATION_ANNEE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, annee));
		// quals.addObject(new EOKeyValueQualifier(ScolGroupeGrp.SCOL_GROUPE_OBJETS_KEY + "." + ScolGroupeObjet.SCOL_MAQUETTE_SEMESTRE_KEY,
		// EOKeyValueQualifier.QualifierOperatorEqual, semestre));
		quals.addObject(new EOKeyValueQualifier(ScolGroupeGrp.SCOL_GROUPE_OBJETS_KEY + "." + ScolGroupeObjet.SCOL_MAQUETTE_AP_KEY + "."
				+ ScolMaquetteAp.SCOL_MAQUETTE_REPARTITION_APS_KEY + "." + ScolMaquetteRepartitionAp.SCOL_MAQUETTE_EC_KEY + "."
				+ ScolMaquetteEc.SCOL_MAQUETTE_REPARTITION_ECS_KEY + "." + ScolMaquetteRepartitionEc.SCOL_MAQUETTE_UE_KEY + "."
				+ ScolMaquetteUe.SCOL_MAQUETTE_REPARTITION_UES_KEY + "." + ScolMaquetteRepartitionUe.SCOL_MAQUETTE_SEMESTRE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, semestre));
		quals.addObject(new EOKeyValueQualifier(ScolGroupeGrp.INCLUS_FILS_KEY + "." + ScolGroupeInclusion.SCOL_GROUPE_GRP_FILS_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, NSKeyValueCoding.NullValue));
		eodScolGroupeGrp.setObjectArray(DBHandler.fetchData(eContext, ScolGroupeGrp.ENTITY_NAME, new EOAndQualifier(quals)));
		tableScolGroupeGrp.updateData();
	}

	/**
	 * les etudiants qui restent a ventiler sont : (les inscripts aux AP du groupe selectionne - les inscrits aux groupes de la collection
	 * du groupe selectionne)
	 */
	public void chargerEtudiantsApsDuGroupe() {
		ScolGroupeGrp selectedGroupe = (ScolGroupeGrp) eodScolGroupeGrp.selectedObject();
		if (selectedGroupe == null || semestre == null) {
			eodScolInscriptionSemestre.setObjectArray(null);
			tableScolInscriptionSemestre.updateData();
			return;
		}

		NSArray aps = groupeFactory.getApsForGroupe(selectedGroupe);

		NSMutableArray sumQualifier = new NSMutableArray();
		for (int i = 0; i < aps.count(); i++) {
			sumQualifier.addObject(new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "."
					+ ScolInscriptionAp.SCOL_MAQUETTE_REPARTITION_AP_KEY + "." + ScolMaquetteRepartitionAp.SCOL_MAQUETTE_AP_KEY,
					EOKeyValueQualifier.QualifierOperatorEqual, aps.objectAtIndex(i)));
		}

		NSMutableArray qualsDispense = new NSMutableArray(4);
		qualsDispense.addObject(new EOKeyValueQualifier(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "." + ScolInscriptionAp.IMRAP_DISPENSE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, new Integer(0)));
		qualsDispense.addObject(new EOKeyValueQualifier(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "." + ScolInscriptionAp.IMRAP_DISPENSE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, new Integer(2)));
		qualsDispense.addObject(new EOKeyValueQualifier(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "." + ScolInscriptionAp.IMRAP_DISPENSE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, new Integer(10)));
		qualsDispense.addObject(new EOKeyValueQualifier(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "." + ScolInscriptionAp.IMRAP_DISPENSE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, new Integer(11)));
		EOQualifier qualDispense = new EOOrQualifier(qualsDispense);

		int parite = (semestre.msemOrdre().intValue() % 2);
		EOQualifier qualParite = new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_INSCRIPTION_APS_KEY + "."
				+ ScolInscriptionAp.IMRAP_SEMESTRE_KEY, EOKeyValueQualifier.QualifierOperatorEqual, new Integer(parite));

		EOQualifier qualifier = new EOOrQualifier(sumQualifier);
		qualifier = new EOAndQualifier(new NSArray(new Object[] { qualDispense, qualifier, qualParite }));

		if (cbFiltreParcours.isSelected()) {
			EOQualifier qualParcours = new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY + "."
					+ ScolMaquetteRepartitionSem.SCOL_MAQUETTE_PARCOURS_KEY, EOKeyValueQualifier.QualifierOperatorEqual, parcours);
			EOQualifier qualSemestre = new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY + "."
					+ ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY, EOKeyValueQualifier.QualifierOperatorEqual, semestre);
			qualifier = new EOAndQualifier(new NSArray(new Object[] { qualParcours, qualSemestre, qualifier }));
		}

		if (cbParcours.getSelectedIndex() > 0) {
			ScolMaquetteRepartitionSem mrsem = (ScolMaquetteRepartitionSem) cbParcours.getSelectedItem();
			EOQualifier qualParcours = new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY,
					EOKeyValueQualifier.QualifierOperatorEqual, mrsem);
			qualifier = new EOAndQualifier(new NSArray(new Object[] { qualParcours, qualifier }));
		}
		EOFetchSpecification fetchSpec = new EOFetchSpecification(ScolInscriptionSemestre.ENTITY_NAME, qualifier, null);
		fetchSpec.setPrefetchingRelationshipKeyPaths(new NSArray(new String[] { ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY,
				ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY,
				ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY + "." + ScolMaquetteRepartitionSem.SCOL_MAQUETTE_PARCOURS_KEY,
				ScolInscriptionSemestre.SCOL_MAQUETTE_REPARTITION_SEM_KEY + "." + ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY }));
		fetchSpec.setIsDeep(true);
		NSArray inscritsAp = eContext.objectsWithFetchSpecification(fetchSpec);
		inscritsAp = FormatHandler.distinctObjects(inscritsAp);

		ScolGroupeCollection collecDuGrp = selectedGroupe.scolGroupeCollection();
		NSArray groupes;
		if (collecDuGrp != null) {
			groupes = collecDuGrp.scolGroupeGrps();
		}
		else {
			groupes = new NSArray();
		}
		sumQualifier.removeAllObjects();
		for (int i = 0; i < groupes.count(); i++) {
			sumQualifier.addObject(new EOKeyValueQualifier(ScolInscriptionSemestre.SCOL_INSCRIPTION_GRPS_KEY + "."
					+ ScolInscriptionGrp.SCOL_GROUPE_GRP_KEY, EOKeyValueQualifier.QualifierOperatorEqual, groupes.objectAtIndex(i)));
		}
		NSArray inscritsGrp = ScolInscriptionSemestre.fetchScolInscriptionSemestres(eContext, new EOOrQualifier(sumQualifier), null);

		NSMutableArray inscriptions = inscritsAp.mutableClone();
		inscriptions.removeObjects(inscritsGrp.objects());

		eodScolInscriptionSemestre.setObjectArray(inscriptions);
		tableScolInscriptionSemestre.updateData();
		updateNbSelectNbInscrits();
	}

	public void updateNbSelectNbInscrits() {
		NSArray etudiantsSelect = (NSArray) eodScolInscriptionSemestre.selectedObjects().valueForKey(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY);
		etudiantsSelect = FormatHandler.distinctObjects(etudiantsSelect);
		NSArray etudiantsInscrits = (NSArray) eodScolInscriptionSemestre.displayedObjects().valueForKey(
				ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY);
		etudiantsInscrits = FormatHandler.distinctObjects(etudiantsInscrits);

		tNbSelectNbInscrits.setText(String.valueOf(eodScolInscriptionSemestre.selectedObjects().count()) + " / "
				+ String.valueOf(eodScolInscriptionSemestre.displayedObjects().count()) + " (" + String.valueOf(etudiantsSelect.count()) + " / "
				+ String.valueOf(etudiantsInscrits.count()) + ")");
	}

	/** permet d'afficher les inscrits au groupe selectionne */
	public void chargerInscritsAuGroupe() {
		ScolGroupeGrp grp = (ScolGroupeGrp) eodScolGroupeGrp.selectedObject();
		if (grp == null) {
			WidgetHandler.flushDisplayGroup(eodScolInscriptionGrp);
			return;
		}
		EOQualifier qualInscGrp = new EOKeyValueQualifier(ScolInscriptionEtudiant.SCOL_INSCRIPTION_GRPS_KEY + "."
				+ ScolInscriptionGrp.SCOL_GROUPE_GRP_KEY, EOKeyValueQualifier.QualifierOperatorEqual, grp);
		NSArray inscritsAll = ScolInscriptionEtudiant.fetchScolInscriptionEtudiants(eContext, qualInscGrp, null);
		NSMutableArray inscrits = new NSMutableArray();
		for (int i = 0; i < inscritsAll.count(); i++) {
			ScolInscriptionEtudiant etud = (ScolInscriptionEtudiant) inscritsAll.objectAtIndex(i);
			if (((NSArray) inscrits.valueForKey(ScolInscriptionEtudiant.ETUD_NUMERO_KEY)).containsObject(etud.etudNumero()) == false) {
				inscrits.addObject(etud);
			}
		}
		eodScolInscriptionGrp.setObjectArray(inscrits);
		tableScolInscriptionGrp.updateData();
		tEtudsGroupe.setText(String.valueOf(eodScolInscriptionGrp.displayedObjects().count()));
	}

	public void clear() {
		eodScolGroupeGrp.setObjectArray(null);
		eodScolInscriptionGrp.setObjectArray(null);
		eodScolInscriptionSemestre.setObjectArray(null);
		updateCbParcours(null);
	}

	/** methode appellee lors de changement de selection dans les onglets */
	public void refresh() {
		if (eContext.hasChanges()) {
			try {
				groupeFactory.doSaveChanges();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		afficherGroupesPourSemestre();
	}

	private void updateCbParcours(NSArray inscriptions) {
		cbParcours.removeAllItems();
		cbParcours.addItem("Tous");
		if (inscriptions != null) {
			NSMutableArray repSems = new NSMutableArray();
			for (int i = 0; i < inscriptions.count(); i++) {
				ScolMaquetteRepartitionSem repSem = ((ScolInscriptionSemestre) inscriptions.objectAtIndex(i)).scolMaquetteRepartitionSem();
				if (repSem != null && repSems.containsObject(repSem) == false) {
					repSems.addObject(repSem);
				}
			}
			try {
				repSems.sortUsingComparator(new NSComparator() {
					public int compare(Object arg0, Object arg1) throws ComparisonException {
						return ((ScolMaquetteRepartitionSem) arg0).toString().compareTo(((ScolMaquetteRepartitionSem) arg1).toString());
					}
				});
			}
			catch (ComparisonException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < repSems.count(); i++) {
				cbParcours.addItem(repSems.objectAtIndex(i));
			}
		}
	}

	public void ajouterEtudiantsGroupe() {
		NSMutableArray etudiants = eodScolInscriptionSemestre.selectedObjects().mutableClone();
		ScolGroupeGrp groupe = (ScolGroupeGrp) eodScolGroupeGrp.selectedObject();

		if (groupe == null) {
			WindowHandler.showError("Veuillez sélectionner un groupe");
			return;
		}
		if (etudiants == null || etudiants.count() == 0) {
			WindowHandler.showError("Aucun étudiant n'est sélectionné");
			return;
		}
		if (annee == null) {
			WindowHandler.showError("Erreur sur l'année scolaire");
			return;
		}

		NSArray inscriptionsGrp = null;
		try {
			etudiants = (NSMutableArray) etudiants.valueForKey(ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY);
			etudiants = FormatHandler.distinctObjects(etudiants);
			if (etudiants != null && etudiants.count() > 0) {
				// ajout des autres inscriptions des étudiants sélectionnés...
				NSArray etudiantsSelectionnes = (NSArray) eodScolInscriptionSemestre.selectedObjects().valueForKey(
						ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY);
				NSMutableArray autresEtudiants = ((NSArray) eodScolInscriptionSemestre.displayedObjects().valueForKey(
						ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY)).mutableClone();
				autresEtudiants.removeObjectsInArray(etudiantsSelectionnes);
				for (int i = 0; i < autresEtudiants.count(); i++) {
					ScolInscriptionEtudiant etudiant = (ScolInscriptionEtudiant) autresEtudiants.objectAtIndex(i);
					if (((NSArray) etudiantsSelectionnes.valueForKey(ScolInscriptionEtudiant.ETUD_NUMERO_KEY)).containsObject(etudiant.etudNumero())) {
						etudiants.addObject(etudiant);
					}
				}

				inscriptionsGrp = groupeFactory.ajouterEtudiantsAuGroupe(etudiants, groupe, annee);
			}
		}
		catch (Exception e) {
			inscriptionsGrp = null;

			if (e instanceof GroupeException) {
				WindowHandler.showError(e.getMessage());
			}
			else {
				e.printStackTrace();
			}
		}
		if (inscriptionsGrp != null && inscriptionsGrp.count() > 0) {
			chargerEtudiantsApsDuGroupe();
			chargerInscritsAuGroupe();
		}
		else {
			WindowHandler.showError("Les étudiants n'ont pas pu être ajoutés au groupe");
		}
	}

	public void retirerEtudiantsGroupe() {
		ScolGroupeGrp grp = (ScolGroupeGrp) eodScolGroupeGrp.selectedObject();
		NSMutableArray inscriptionsGrp = eodScolInscriptionGrp.selectedObjects().mutableClone();
		NSMutableArray scolInscriptionGrps = new NSMutableArray();

		if (grp == null || inscriptionsGrp == null || inscriptionsGrp.count() == 0) {
			return;
		}

		// retrait en même temps des autres inscriptions des étudiants sélectionnés...
		NSMutableArray autresInscritsAuGroupe = ScolInscriptionEtudiant.fetchScolInscriptionEtudiants(
				eContext,
				new EOKeyValueQualifier(ScolInscriptionEtudiant.SCOL_INSCRIPTION_GRPS_KEY + "." + ScolInscriptionGrp.SCOL_GROUPE_GRP_KEY,
						EOKeyValueQualifier.QualifierOperatorEqual, grp), null).mutableClone();
		autresInscritsAuGroupe.removeObjectsInArray(inscriptionsGrp);
		for (int i = 0; i < autresInscritsAuGroupe.count(); i++) {
			ScolInscriptionEtudiant etudiant = (ScolInscriptionEtudiant) autresInscritsAuGroupe.objectAtIndex(i);
			if (((NSArray) inscriptionsGrp.valueForKey(ScolInscriptionEtudiant.ETUD_NUMERO_KEY)).containsObject(etudiant.etudNumero())) {
				inscriptionsGrp.addObject(etudiant);
			}
		}

		for (int i = 0; i < inscriptionsGrp.count(); i++) {
			ScolInscriptionEtudiant inscEtud = (ScolInscriptionEtudiant) inscriptionsGrp.objectAtIndex(i);
			NSMutableArray quals = new NSMutableArray(2);
			quals.addObject(new EOKeyValueQualifier(ScolInscriptionEtudiant.ETUD_NUMERO_KEY, EOKeyValueQualifier.QualifierOperatorEqual, inscEtud));
			quals.addObject(new EOKeyValueQualifier(ScolInscriptionEtudiant.SCOL_FORMATION_ANNEE_KEY, EOKeyValueQualifier.QualifierOperatorEqual,
					inscEtud.scolFormationAnnee()));
			quals.addObject(new EOKeyValueQualifier(ScolInscriptionEtudiant.SCOL_INSCRIPTION_GRPS_KEY, EOKeyValueQualifier.QualifierOperatorEqual,
					grp));
			ScolInscriptionEtudiant.fetchScolInscriptionEtudiants(eContext, new EOAndQualifier(quals), null);
		}

		for (int i = 0; i < inscriptionsGrp.count(); i++) {
			ScolInscriptionEtudiant inscEtud = (ScolInscriptionEtudiant) inscriptionsGrp.objectAtIndex(i);
			scolInscriptionGrps.addObjectsFromArray(inscEtud.scolInscriptionGrps(new EOKeyValueQualifier(ScolInscriptionGrp.SCOL_GROUPE_GRP_KEY,
					EOKeyValueQualifier.QualifierOperatorEqual, grp)));
		}

		if (scolInscriptionGrps.count() == 0) {
			WindowHandler.showError("Aucun inscrit au groupe n'est sélectionné");
			return;
		}
		boolean retour;
		try {
			retour = groupeFactory.retirerEtudiantsDuGroupe(scolInscriptionGrps);
		}
		catch (Exception e) {
			retour = false;
			e.printStackTrace();
			if (e instanceof GroupeException) {
				WindowHandler.showError(e.getMessage());
			}
		}

		if (retour) {
			chargerEtudiantsApsDuGroupe();
			updateCbParcours(eodScolInscriptionSemestre.displayedObjects());
			chargerInscritsAuGroupe();
		}
		else {
			WindowHandler.showError("Les étudiants n'ont pas été retirés du groupe");
		}
	}

	private void initWidgets() {
		WidgetHandler.decorateButton("Ajouter les étudiants sélectionnés au groupe", null, "left", bAjouterEtud);
		WidgetHandler.decorateButton("Retirer les étudiants sélectionnés du groupe", null, "right", bRetirerEtud);
		WidgetHandler.decorateButton("Sortir des trombinos", null, "print", bImprimer);
		WidgetHandler.decorateButton("Sortir trombino des étudiants qui restent à ventiler", null, "smallprint", bPrintStudAp);
		cbFiltreParcours.setToolTipText("N'afficher que les étudiants inscrits à la formation sélectionnée");
		tNbSelectNbInscrits
				.setToolTipText("Nb d'étudiants sélectionnés / nb d'étudiants inscrits (nb étudiants réels sélectionnés / nb étudiants réels inscrits = hors doublons ou +)");
		cbParcours.setRenderer(new WidgetHandler.ComboBoxRendererWithToolTip());
	}

	private void initTables() {
		// ScolGroupeGrp
		Vector<ZEOTableModelColumn> myColsScolGroupeGrp = new Vector<ZEOTableModelColumn>();

		ZEOTableModelColumn col = new ZEOTableModelColumn(eodScolGroupeGrp, ScolGroupeGrp.GGRP_CODE_KEY, "Code", 50);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolGroupeGrp.add(col);
		col = new ZEOTableModelColumn(eodScolGroupeGrp, ScolGroupeGrp.GGRP_MAX_CAPACITE_KEY, "Cap. max", 20);
		col.setAlignment(SwingConstants.CENTER);
		col.setColumnClass(Integer.class);
		myColsScolGroupeGrp.add(col);
		col = new ZEOTableModelColumn(eodScolGroupeGrp, ScolGroupeGrp.SCOL_GROUPE_COLLECTION_KEY + "." + ScolGroupeCollection.GCOL_LIBELLE_KEY,
				"Collection", 50);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolGroupeGrp.add(col);

		ZEOTableModel myTableModel = new ZEOTableModel(eodScolGroupeGrp, myColsScolGroupeGrp);
		TableSorter myTableSorter = new TableSorter(myTableModel);
		tableScolGroupeGrp = new ZEOTable(myTableSorter);
		myTableSorter.setTableHeader(tableScolGroupeGrp.getTableHeader());
		eodScolGroupeGrp.setSortOrderings(new NSArray(EOSortOrdering.sortOrderingWithKey(ScolGroupeGrp.GGRP_CODE_KEY,
				EOSortOrdering.CompareCaseInsensitiveAscending)));

		tableScolGroupeGrp.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableScolGroupeGrp.addListener(new ListenerTableScolGroupeGrp());
		eodScolGroupeGrp.setSelectsFirstObjectAfterFetch(false);

		viewScolGroupeGrp.setLayout(new BorderLayout());
		viewScolGroupeGrp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		viewScolGroupeGrp.removeAll();
		viewScolGroupeGrp.add(new JScrollPane(tableScolGroupeGrp), BorderLayout.CENTER);

		// ScolInscriptionGrp
		Vector<ZEOTableModelColumn> myColsScolInscriptionGrp = new Vector<ZEOTableModelColumn>();

		col = new ZEOTableModelColumn(eodScolInscriptionGrp, ScolInscriptionEtudiant.IDENTITE_KEY, "Identité", 80);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolInscriptionGrp.add(col);
		col = new ZEOTableModelColumn(eodScolInscriptionGrp, ScolInscriptionEtudiant.ETUD_NUMERO_KEY, "No. étud.", 20);
		col.setColumnClass(Integer.class);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolInscriptionGrp.add(col);

		myTableModel = new ZEOTableModel(eodScolInscriptionGrp, myColsScolInscriptionGrp);
		myTableSorter = new TableSorter(myTableModel);
		tableScolInscriptionGrp = new ZEOTable(myTableSorter);
		myTableSorter.setTableHeader(tableScolInscriptionGrp.getTableHeader());
		eodScolInscriptionGrp.setSortOrderings(new NSArray(EOSortOrdering.sortOrderingWithKey(ScolInscriptionEtudiant.IDENTITE_KEY,
				EOSortOrdering.CompareCaseInsensitiveAscending)));

		tableScolInscriptionGrp.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableScolInscriptionGrp.addListener(new ListenerTableScolInscriptionGrp());

		viewScolInscriptionGrp.setLayout(new BorderLayout());
		viewScolInscriptionGrp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		viewScolInscriptionGrp.removeAll();
		viewScolInscriptionGrp.add(new JScrollPane(tableScolInscriptionGrp), BorderLayout.CENTER);

		// ScolInscriptionSemestre
		Vector<ZEOTableModelColumn> myColsScolInscriptionSemestre = new Vector<ZEOTableModelColumn>();

		col = new ZEOTableModelColumn(eodScolInscriptionSemestre, ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY + "."
				+ ScolInscriptionEtudiant.IDENTITE_KEY, "Identité", 140);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolInscriptionSemestre.add(col);
		col = new ZEOTableModelColumn(eodScolInscriptionSemestre, ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY + "."
				+ ScolInscriptionEtudiant.ETUD_NUMERO_KEY, "No. étud.", 60);
		col.setColumnClass(Integer.class);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolInscriptionSemestre.add(col);
		col = new ZEOTableModelColumn(eodScolInscriptionSemestre, ScolInscriptionSemestre.TO_STRING, "Formation", 300);
		col.setAlignment(SwingConstants.LEFT);
		myColsScolInscriptionSemestre.add(col);

		myTableModel = new ZEOTableModel(eodScolInscriptionSemestre, myColsScolInscriptionSemestre);
		myTableSorter = new TableSorter(myTableModel);
		tableScolInscriptionSemestre = new ZEOTable(myTableSorter);
		tableScolInscriptionSemestre.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		myTableSorter.setTableHeader(tableScolInscriptionSemestre.getTableHeader());
		EOSortOrdering sortOrdering1 = EOSortOrdering.sortOrderingWithKey(ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY + "."
				+ ScolInscriptionEtudiant.IDENTITE_KEY, EOSortOrdering.CompareCaseInsensitiveAscending);
		EOSortOrdering sortOrdering2 = EOSortOrdering.sortOrderingWithKey(ScolInscriptionSemestre.TO_STRING,
				EOSortOrdering.CompareCaseInsensitiveAscending);
		eodScolInscriptionSemestre.setSortOrderings(new NSArray(new EOSortOrdering[] { sortOrdering1, sortOrdering2 }));

		tableScolInscriptionSemestre.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableScolInscriptionSemestre.addListener(new ListenerTableScolInscriptionSemestre());

		viewScolInscriptionSemestre.setLayout(new BorderLayout());
		viewScolInscriptionSemestre.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		viewScolInscriptionSemestre.removeAll();
		viewScolInscriptionSemestre.add(new JScrollPane(tableScolInscriptionSemestre), BorderLayout.CENTER);
	}

	private class ListenerTableScolGroupeGrp implements ZEOTableListener {
		public void onDbClick() {
		}

		public void onSelectionChanged() {
			chargerEtudiantsApsDuGroupe();
			updateCbParcours(eodScolInscriptionSemestre.displayedObjects());
			chargerInscritsAuGroupe();
		}
	}

	private class ListenerTableScolInscriptionSemestre implements ZEOTableListener {
		public void onDbClick() {
			ajouterEtudiantsGroupe();
		}

		public void onSelectionChanged() {
			updateNbSelectNbInscrits();
		}
	}

	private class ListenerTableScolInscriptionGrp implements ZEOTableListener {
		public void onDbClick() {
			retirerEtudiantsGroupe();
		}

		public void onSelectionChanged() {
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
	 * method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		viewScolGroupeGrp = new javax.swing.JPanel();
		bImprimer = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		tEtudsGroupe = new javax.swing.JLabel();
		bRetirerEtud = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		viewScolInscriptionGrp = new javax.swing.JPanel();
		bAjouterEtud = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		bPrintStudAp = new javax.swing.JButton();
		cbParcours = new javax.swing.JComboBox();
		tNbSelectNbInscrits = new javax.swing.JLabel();
		viewScolInscriptionSemestre = new javax.swing.JPanel();
		cbFiltreParcours = new javax.swing.JCheckBox();

		setPreferredSize(new java.awt.Dimension(820, 420));
		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

		jPanel1.setPreferredSize(new java.awt.Dimension(408, 425));
		jPanel1.setLayout(new java.awt.GridLayout(2, 0));

		viewScolGroupeGrp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		org.jdesktop.layout.GroupLayout viewScolGroupeGrpLayout = new org.jdesktop.layout.GroupLayout(viewScolGroupeGrp);
		viewScolGroupeGrp.setLayout(viewScolGroupeGrpLayout);
		viewScolGroupeGrpLayout.setHorizontalGroup(viewScolGroupeGrpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(0, 386,
				Short.MAX_VALUE));
		viewScolGroupeGrpLayout.setVerticalGroup(viewScolGroupeGrpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(0, 159,
				Short.MAX_VALUE));

		bImprimer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bImprimerActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.add(jPanel3Layout
								.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(jPanel3Layout
										.createSequentialGroup()
										.add(viewScolGroupeGrp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap())
								.add(jPanel3Layout
										.createSequentialGroup()
										.add(bImprimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(359, 359, 359)))));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel3Layout
						.createSequentialGroup()
						.addContainerGap()
						.add(bImprimer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(viewScolGroupeGrp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		jPanel1.add(jPanel3);

		tEtudsGroupe.setText(" ");

		bRetirerEtud.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bRetirerEtudActionPerformed(evt);
			}
		});

		jLabel1.setText("Etudiants du groupe sélectionné :");

		viewScolInscriptionGrp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		org.jdesktop.layout.GroupLayout viewScolInscriptionGrpLayout = new org.jdesktop.layout.GroupLayout(viewScolInscriptionGrp);
		viewScolInscriptionGrp.setLayout(viewScolInscriptionGrpLayout);
		viewScolInscriptionGrpLayout.setHorizontalGroup(viewScolInscriptionGrpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(0, 347, Short.MAX_VALUE));
		viewScolInscriptionGrpLayout.setVerticalGroup(viewScolInscriptionGrpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				0, 171, Short.MAX_VALUE));

		bAjouterEtud.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bAjouterEtudActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel4Layout
						.createSequentialGroup()
						.addContainerGap()
						.add(jPanel4Layout
								.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(org.jdesktop.layout.GroupLayout.TRAILING,
										jPanel4Layout
												.createSequentialGroup()
												.add(viewScolInscriptionGrp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(bRetirerEtud)
														.add(bAjouterEtud)).addContainerGap())
								.add(jPanel4Layout
										.createSequentialGroup()
										.add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
										.add(tEtudsGroupe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE).add(53, 53, 53)))));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel4Layout
						.createSequentialGroup()
						.add(jPanel4Layout
								.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
								.add(org.jdesktop.layout.GroupLayout.TRAILING,
										jPanel4Layout
												.createSequentialGroup()
												.addContainerGap()
												.add(viewScolInscriptionGrp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
														org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel1)
														.add(tEtudsGroupe)))
								.add(jPanel4Layout
										.createSequentialGroup()
										.add(79, 79, 79)
										.add(jPanel4Layout
												.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
												.add(jPanel4Layout
														.createSequentialGroup()
														.add(42, 42, 42)
														.add(bRetirerEtud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
												.add(bAjouterEtud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))).addContainerGap()));

		jPanel1.add(jPanel4);

		add(jPanel1);

		jLabel2.setText("Nombre d'étudiants sélectionnés / d'inscrits aux APs :");

		bPrintStudAp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bPrintStudApActionPerformed(evt);
			}
		});

		cbParcours.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		cbParcours.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbParcoursActionPerformed(evt);
			}
		});

		tNbSelectNbInscrits.setText(" ");

		viewScolInscriptionSemestre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		org.jdesktop.layout.GroupLayout viewScolInscriptionSemestreLayout = new org.jdesktop.layout.GroupLayout(viewScolInscriptionSemestre);
		viewScolInscriptionSemestre.setLayout(viewScolInscriptionSemestreLayout);
		viewScolInscriptionSemestreLayout.setHorizontalGroup(viewScolInscriptionSemestreLayout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 386, Short.MAX_VALUE));
		viewScolInscriptionSemestreLayout.setVerticalGroup(viewScolInscriptionSemestreLayout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(0, 354, Short.MAX_VALUE));

		cbFiltreParcours.setText("/ formation");
		cbFiltreParcours.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbFiltreParcoursActionPerformed(evt);
			}
		});

		org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				org.jdesktop.layout.GroupLayout.TRAILING,
				jPanel2Layout
						.createSequentialGroup()
						.addContainerGap()
						.add(jPanel2Layout
								.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
								.add(org.jdesktop.layout.GroupLayout.LEADING, viewScolInscriptionSemestre,
										org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.add(org.jdesktop.layout.GroupLayout.LEADING,
										jPanel2Layout
												.createSequentialGroup()
												.add(cbFiltreParcours)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(cbParcours, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 278,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(bPrintStudAp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
								.add(org.jdesktop.layout.GroupLayout.LEADING,
										jPanel2Layout
												.createSequentialGroup()
												.add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268,
														org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
												.add(tNbSelectNbInscrits, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
				jPanel2Layout
						.createSequentialGroup()
						.add(14, 14, 14)
						.add(jPanel2Layout
								.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
								.add(jPanel2Layout
										.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
										.add(cbFiltreParcours, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.add(cbParcours, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
								.add(bPrintStudAp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(viewScolInscriptionSemestre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
						.add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(tNbSelectNbInscrits).add(jLabel2))
						.addContainerGap()));

		add(jPanel2);
	}// </editor-fold>//GEN-END:initComponents

	private void bImprimerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bImprimerActionPerformed
		imprimer();
	}// GEN-LAST:event_bImprimerActionPerformed

	private void cbFiltreParcoursActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbFiltreParcoursActionPerformed
		chargerEtudiantsApsDuGroupe();
		cbParcours.setSelectedIndex(0);
		updateCbParcours(eodScolInscriptionSemestre.displayedObjects());
	}// GEN-LAST:event_cbFiltreParcoursActionPerformed

	private void bPrintStudApActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bPrintStudApActionPerformed
		imprimerEtudiantsAP();
	}// GEN-LAST:event_bPrintStudApActionPerformed

	private void bAjouterEtudActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bAjouterEtudActionPerformed
		ajouterEtudiantsGroupe();
	}// GEN-LAST:event_bAjouterEtudActionPerformed

	private void bRetirerEtudActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bRetirerEtudActionPerformed
		retirerEtudiantsGroupe();
	}// GEN-LAST:event_bRetirerEtudActionPerformed

	private void cbParcoursActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbParcoursActionPerformed
		chargerEtudiantsApsDuGroupe();
	}// GEN-LAST:event_cbParcoursActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton bAjouterEtud;
	private javax.swing.JButton bImprimer;
	private javax.swing.JButton bPrintStudAp;
	private javax.swing.JButton bRetirerEtud;
	private javax.swing.JCheckBox cbFiltreParcours;
	private javax.swing.JComboBox cbParcours;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JLabel tEtudsGroupe;
	private javax.swing.JLabel tNbSelectNbInscrits;
	private javax.swing.JPanel viewScolGroupeGrp;
	private javax.swing.JPanel viewScolInscriptionGrp;
	private javax.swing.JPanel viewScolInscriptionSemestre;
	// End of variables declaration//GEN-END:variables

}
