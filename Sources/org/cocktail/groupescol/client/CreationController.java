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

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolFormationSpecialisation;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolGroupeInclusion;
import org.cocktail.groupescol.client.eof.ScolMaquetteAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;
import org.cocktail.groupescol.client.eof.ScolMaquetteTypeEc;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eodistribution.client.EODistributedObjectStore;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSKeyValueCoding;
import com.webobjects.foundation.NSMutableArray;

public class CreationController extends EOInterfaceController {

	/* ,bEnregistrer */
	public JButton bCreerCol, bSupprCol, bModifCol, bFetchAllAp, bSelectAllAp, bInclure, bDesinclure, bGrpAp, bCreerGrp, bModifGrp, bSupprGrp,
			bInclureND;
	public EODisplayGroup eodCollection, eodGrpGroupe, eodMaquetteAp, eodGroupeInclusion;
	public EOTable tableCollection, tableGroupeGrp, tableMaquetteAp, tableGroupeInclusion;
	public Container typeApSeuilContainer;
	public JCheckBox cEcLibre;
	public JComboBox comboTypeEc;

	private ListTypeApSeuil listTypeApSeuil;
	private MainInterface owner;

	private ScolMaquetteSemestre semestre;
	private ScolFormationAnnee annee;

	private EOEditingContext eContext;
	private GroupeFactory groupeFactory;

	private EOSortOrdering sortAp, sortEc;
	private GroupesApController groupesApController;
	boolean allSelected = false;

	public CreationController(MainInterface mainInterface) {
		super(mainInterface.editingContext());
		this.establishConnection();
		this.owner = mainInterface;
		eContext = mainInterface.editingContext();
		groupeFactory = ((MainClient) EOApplication.sharedApplication()).groupeFactory();
		init();
	}

	/** reinitialisation des composants graphiques */
	public void clear() {
		WidgetHandler.flushDisplayGroup(eodGrpGroupe);
		WidgetHandler.flushDisplayGroup(eodCollection);
		WidgetHandler.flushDisplayGroup(eodMaquetteAp);
		WidgetHandler.flushDisplayGroup(eodGroupeInclusion);
		listTypeApSeuil.setObjects(null);
		eodGrpGroupe.setObjectArray(null);
	}

	public GroupeFactory groupeFactory() {
		return groupeFactory;
	}

	public ScolMaquetteSemestre semestre() {
		return semestre;
	}

	/** retourne l'instance d'interface */
	public MainInterface mainInterface() {
		return owner;
	}

	public void semestreSelectionChanged(ScolMaquetteSemestre semestre) {
		this.semestre = semestre;
		clear();
		if (semestre != null) {
			annee = semestre.scolFormationAnnee();
			getTypeSeuilForSemestre();
			afficherApsPourSemestre(true);
			afficherCollectionsPourSemestre();
		}
	}

	/** changement de selection du type ap/seuil dans la liste ... recharger les aps ... */
	public void typeApSeuilChanged(Object aTypeApHolder) {
		afficherApsPourSemestre(true);
		selectionnerApsPourCollection();
	}

	/** une nouvelle collection a inserer dans le displayGroup pour visualisation */
	public void collectionCreated(ScolGroupeCollection uneCollection) {
		eodCollection.insertObjectAtIndex(uneCollection, 0);
	}

	//
	// Quelques accesseurs necessaires aux controlleurs lances par ce controlleur ...
	// semestre courant, collection courante, Aps selectionnnes etc
	//

	/** retourne les aps selectionnes par l'utilisateurs dans la table */
	public NSArray getSelectedAps() {
		return eodMaquetteAp.selectedObjects();
	}

	public ScolMaquetteAp getSelectedAp() {
		return (ScolMaquetteAp) eodMaquetteAp.selectedObject();
	}

	/** retourne la collection selectionnee */
	public ScolGroupeCollection getSelectedCollection() {
		return (ScolGroupeCollection) eodCollection.selectedObject();
	}

	/** retourne toutes les collections du semestre */
	public NSArray getDisplayedCollections() {
		return eodCollection.displayedObjects();
	}

	public void afficherGroupesPourAp() {
		ScolMaquetteAp selectedAp = (ScolMaquetteAp) eodMaquetteAp.selectedObject();
		if (selectedAp != null) {
			groupesApController.afficher(selectedAp);
		}
	}

	private void afficherApsPourSemestre(boolean filtres) {

		WindowHandler.setWaitCursor(this.component());

		Number fannKey = annee.fannKey();
		TypeApSeuilHolder typeApSeuilHolder = listTypeApSeuil.getSelectedItem();
		NSMutableArray sumQuals = new NSMutableArray();

		if (annee != null && semestre != null && typeApSeuilHolder != null) {
			sumQuals.addObject(EOQualifier.qualifierWithQualifierFormat("vSemestreAp.fannKey=%@ and vSemestreAp.semestre=%@", new NSArray(
					new Object[] { fannKey, semestre })));

			if (filtres) {
				if (typeApSeuilHolder.mhcoCode() != null) {
					sumQuals.addObject(DBHandler.getSimpleQualifier("vSemestreAp.ap.mhcoCode", typeApSeuilHolder.mhcoCode()));
				}

				if (typeApSeuilHolder.mapSeuil() != null) {
					sumQuals.addObject(DBHandler.getSimpleQualifier("vSemestreAp.ap.mapSeuil", typeApSeuilHolder.mapSeuil()));
				}

				eodMaquetteAp.setSortOrderings(new NSArray(sortAp));
			}
			// si les Aps ne sont pas filtres par le couple mhcoCode/mapSeuil : ordonner par EC de rattachement ie suite CM,TD,TP ...
			else {
				eodMaquetteAp.setSortOrderings(new NSArray(new Object[] { sortEc, sortAp }));
			}

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

			DBHandler.fetchDisplayGroup(eodMaquetteAp, new EOAndQualifier(sumQuals));

			// eodMaquetteAp.setObjectArray(atomP);
			WidgetHandler.selectNoneInDisplayGroup(eodMaquetteAp);
			WidgetHandler.informObservingAssociation(eodMaquetteAp);
			selectionnerApsPourCollection();
		}
		WindowHandler.setDefaultCursor(this.component());
	}

	/** affiche les collections du semestre selectionne */
	private void afficherCollectionsPourSemestre() {
		WindowHandler.setWaitCursor(this.component());
		eodCollection.setObjectArray(ScolGroupeCollection.getCollectionsForSemestre(eContext, semestre));
		WidgetHandler.informObservingAssociation(eodCollection);
		displayGroupDidChangeSelection(eodCollection);

		WindowHandler.setDefaultCursor(this.component());
	}

	private void getTypeSeuilForSemestre() {

		ScolMaquetteParcours parcours = owner.getSelectedParcours();
		ScolFormationSpecialisation formationSpe = owner.getSelectedFormationSpecialisation();

		if (formationSpe == null || parcours == null || semestre == null) {
			return;
		}

		WindowHandler.setWaitCursor(this.component());

		EOGlobalID idSemestre = eContext.globalIDForObject(semestre);
		EOGlobalID idParcours = eContext.globalIDForObject(parcours);
		EOGlobalID idFormaSpe = eContext.globalIDForObject(formationSpe);

		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		NSArray typeAPSeuils = (NSArray) objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestTypeApSeuil", new Class[] {
				EOGlobalID.class, EOGlobalID.class, EOGlobalID.class }, new Object[] { idFormaSpe, idParcours, idSemestre }, false);

		NSMutableArray objets = new NSMutableArray();
		for (int i = 0; i < typeAPSeuils.count(); i++) {
			NSDictionary dico = (NSDictionary) typeAPSeuils.objectAtIndex(i);
			String mhcoCode = (String) dico.valueForKey("MHCO_CODE");
			Number mapSeuil = (Number) dico.valueForKey("MAP_SEUIL");
			TypeApSeuilHolder typeApSeuilHolder = new TypeApSeuilHolder(mhcoCode, mapSeuil);
			objets.addObject(typeApSeuilHolder);
		}
		listTypeApSeuil.setObjects(objets);

		WindowHandler.setDefaultCursor(this.component());
	}

	/** changement des selections dans les tables */
	public void displayGroupDidChangeSelection(EODisplayGroup group) {
		if (group == eodCollection && eodCollection.selectedObject() != null) {
			ScolGroupeCollection selectCollection = (ScolGroupeCollection) eodCollection.selectedObject();
			eodGrpGroupe.setObjectArray(selectCollection.scolGroupeGrps());
			WidgetHandler.informObservingAssociation(eodGrpGroupe);
			afficherInclus();
			selectionnerApsPourCollection();
		}
		if (group == eodGrpGroupe) {
			ScolGroupeGrp selGroupe = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
			if (selGroupe != null) {
				afficherInclus();
			}
		}
	}

	/** selectionnerApsPourCollection */
	public void selectionnerApsPourCollection() {
		WidgetHandler.selectNoneInDisplayGroup(eodMaquetteAp);
		ScolGroupeCollection selectCollection = (ScolGroupeCollection) eodCollection.selectedObject();
		if (selectCollection == null) {
			return;
		}
		NSArray groupes = selectCollection.scolGroupeGrps();
		if (groupes.count() == 0) {
			return;
		}

		WindowHandler.setWaitCursor(this.component());
		// il suffit de prendre les AP du premier groupe, ce sera les memes pour tous les groupes de la collec.
		ScolGroupeGrp unGroupe = (ScolGroupeGrp) groupes.objectAtIndex(0);
		NSArray aps = groupeFactory().getApsForGroupe(unGroupe);
		eodMaquetteAp.setSelectedObjects(aps);
		// eodMaquetteAp.updateDisplayedObjects();
		WidgetHandler.informObservingAssociation(eodMaquetteAp);
		WindowHandler.setDefaultCursor(this.component());
	}

	/** methode appellee lors de changement de selection dans les onglets */
	public void refresh() {
		// WidgetHandler.flushDisplayGroup(eodGroupeInclusion);
	}

	protected void init() {
		groupesApController = new GroupesApController(this);

		typeApSeuilContainer.setLayout(new GridLayout(1, 1));
		listTypeApSeuil = new ListTypeApSeuil(this, "typeApSeuilChanged");
		typeApSeuilContainer.add(listTypeApSeuil);

		EOSortOrdering sortColl = EOSortOrdering.sortOrderingWithKey("gcolLibelle", EOSortOrdering.CompareCaseInsensitiveAscending);
		eodCollection.setSortOrderings(new NSArray(sortColl));

		eodCollection.setDelegate(this);
		eodGrpGroupe.setDelegate(this);
		// chargement des types d'EC
		EOQualifier qualTypeEc = EOQualifier.qualifierWithQualifierFormat("mtecValidite='O'", null);
		NSArray typeEc = DBHandler.fetchData(eContext, "ScolMaquetteTypeEc", qualTypeEc);

		comboTypeEc.removeAllItems();
		for (int i = 0; i < typeEc.count(); i++) {
			comboTypeEc.addItem(typeEc.objectAtIndex(i));
		}

		comboTypeEc.addItem("(Tous)");
		comboTypeEc.addActionListener(new JComboListener());

		// creation des sortOrderings pour les AP.
		sortAp = EOSortOrdering.sortOrderingWithKey("mapLibelle", EOSortOrdering.CompareCaseInsensitiveAscending);
		sortEc = EOSortOrdering.sortOrderingWithKey("scolMaquetteRepartitionAps.scolMaquetteEc.mecLibelleCourt",
				EOSortOrdering.CompareCaseInsensitiveAscending);
		initWidgets();
	}

	private void initWidgets() {

		WidgetHandler.setTableNotEditable(tableCollection);
		WidgetHandler.setTableNotEditable(tableGroupeGrp);
		WidgetHandler.setTableNotEditable(tableMaquetteAp);
		WidgetHandler.setTableNotEditable(tableGroupeInclusion);

		WidgetHandler.decorateButton(null, "Créer Collection", "plusB", bCreerCol);
		WidgetHandler.decorateButton("Supprimer la collection selectionnée", null, "del", bSupprCol);
		WidgetHandler.decorateButton("Modifier la collection selectionnée", null, "modifier", bModifCol);
		WidgetHandler.decorateButton("Ajouter un groupe", null, "plusB", bCreerGrp);
		WidgetHandler.decorateButton("Modifier le groupe selectionné", null, "modifier", bModifGrp);
		WidgetHandler.decorateButton("Supprimer le groupe selectionné", null, "del", bSupprGrp);

		// WidgetHandler.decorateButton("Enregistrer les modification de selection",null,"save",bEnregistrer);
		WidgetHandler.decorateButton("Choisir des groupes à inclure dans le groupe selectionné", null, "plusB", bInclure);
		WidgetHandler.decorateButton("Exclure le groupe inclus selectionné", null, "moinsB", bDesinclure);
		WidgetHandler.decorateButton("Inclure des groupes venant d'un autre parcours/semestre(PRUDENCE)", null, "plusV", bInclureND);

		WidgetHandler.decorateButton("Afficher tous les AP du semestre...", null, "precis", bFetchAllAp);
		WidgetHandler.decorateButton("Selectionner tous les AP dans la table", null, "ok", bSelectAllAp);
		WidgetHandler.decorateButton("Afficher tous les groupes auxquels est rattaché l'AP", null, "info", bGrpAp);

		SelectApCellRenderer selectApCellRenderer = new SelectApCellRenderer();
		selectApCellRenderer.connectTable(tableMaquetteAp);

	}

	/** affiche tous les aps du semestre, sans filtres */
	public void afficherTousLesAps() {
		this.afficherApsPourSemestre(false);
	}

	/** affiche les inclus du groupe selectionne */
	public void afficherInclus() {
		WindowHandler.setWaitCursor(this.component());
		WidgetHandler.flushDisplayGroup(eodGroupeInclusion);
		ScolGroupeGrp grp = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
		if (grp != null) {
			EOQualifier qualInc = DBHandler.getSimpleQualifier("scolGroupeGrpPere", grp);
			DBHandler.fetchDisplayGroup(eodGroupeInclusion, qualInc);
			WidgetHandler.informObservingAssociation(eodGroupeInclusion);
		}
		WindowHandler.setDefaultCursor(this.component());
	}

	/** permet de semectionner tous les aps */
	public void selectionnerTousLesAps() {
		if (!allSelected) {
			allSelected = true;
			WidgetHandler.selectAllInDisplayGroup(eodMaquetteAp);
		}
		else {
			allSelected = false;
			WidgetHandler.selectNoneInDisplayGroup(eodMaquetteAp);
		}
	}

	/** recharger tous les ap ou seulement les Ap rataches aux EC libres */
	public void rechargerAp() {
		afficherApsPourSemestre(true);
	}

	/** lance la fenetre de selection de groupe a inclure */
	public void inclure() {

		ScolGroupeGrp selectedGroupe = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
		if (selectedGroupe != null && selectedGroupe.scolInscriptionGrps().count() > 0) {
			StringBuffer msg = new StringBuffer();
			msg.append("Ce groupe ne peut avoir de groupe fils en l'état car il contient des étudiants (ventilés)\n");
			msg.append("Voulez-vous désinscrire les inscrits à ce groupe pour pouvoir lui ajouter un groupe fils ?\n");
			msg.append("(dans l'affirmative pensez a réinscrire les étudiants au groupe fils ensuite)");
			if (WindowHandler.showConfirmation(msg.toString())) {
				boolean retour;
				try {
					NSArray inscritsGrp = selectedGroupe.scolInscriptionGrps();
					retour = groupeFactory().retirerEtudiantsDuGroupe(inscritsGrp);
				}
				catch (GroupeException e) {
					retour = false;
					if (e instanceof GroupeException) {
						WindowHandler.showError(e.getMessage());
					}
					else {
						e.printStackTrace();
					}
				}
				if (!retour) {
					return;
				}
			}
			else {
				return;
			}
		}
		GroupeInclusion groupeInclusion = new GroupeInclusion(this);
		WindowHandler.runModal(groupeInclusion, "Inclusion de groupes");
	}

	/** permet de supprimer une inclusion */
	public void exclure() {
		ScolGroupeInclusion inclusionASupprimer = (ScolGroupeInclusion) eodGroupeInclusion.selectedObject();
		if (inclusionASupprimer == null) {
			return;
		}
		StringBuffer msg = new StringBuffer();
		msg.append("Vous confirmez l'exclusion du groupe ");
		msg.append(inclusionASupprimer.scolGroupeGrpFils());
		msg.append(" du groupe ");
		msg.append(inclusionASupprimer.scolGroupeGrpPere());

		if (!WindowHandler.showConfirmation(msg.toString())) {
			return;
		}
		WindowHandler.setWaitCursor(this.component());

		boolean retour;
		try {
			retour = groupeFactory().supprimerInclusion(inclusionASupprimer);
		}
		catch (Exception e) {
			WindowHandler.setDefaultCursor(this.component());
			retour = false;
			if (e instanceof GroupeException) {
				WindowHandler.showError(e.getMessage());
			}
			else {
				e.printStackTrace();
			}
		}
		if (retour) {
			afficherInclus();
		}
		WindowHandler.setDefaultCursor(this.component());
	}

	/** lance la fenetre de selection de groupes a inclure venant d'autres parcours/semestres */
	public void inclureNiveauDiplome() {
		InclusionNiveauDiplome ind = new InclusionNiveauDiplome(this);
		WindowHandler.runModal(ind, "Inclure des groupes d'autres semestres/parcours");
	}

	/** lance l'operation d'inclusion des groupes selectionnes dans la fenetre de selection */
	public boolean inclureDansGroupeSelectionne(NSArray groupesAInclure) {
		ScolGroupeGrp selectedGroupe = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
		if (selectedGroupe == null) {
			return false;
		}

		WindowHandler.setWaitCursor(this.component());

		boolean retour;
		try {
			retour = groupeFactory().inclureGroupesDansGroupe(groupesAInclure, selectedGroupe);
		}
		catch (Exception e) {
			WindowHandler.setDefaultCursor(this.component());
			retour = false;
			if (e instanceof GroupeException) {
				WindowHandler.showError(e.getMessage());
			}
			else {
				e.printStackTrace();
			}
		}
		// reaffichage des groupes inclus
		afficherInclus();
		WindowHandler.setDefaultCursor(this.component());
		return retour;
	}

	/** commence la creation d'une nouvelle collection */
	public void creerCollection() {
		if (listTypeApSeuil.getSelectedItem() == null) {
			return;
		}
		boolean creation = false;
		if (eodMaquetteAp.selectedObjects().count() == 0) {
			StringBuffer msg = new StringBuffer("Aucun AP n'est selectionné dans la table...\n");
			msg.append("Etes-vous certain(e) de ne pas vouloir associer d'AP aux groupes qui seront créés ?");
			creation = WindowHandler.showConfirmation(msg.toString());
		}
		else {
			creation = true;
		}

		if (creation) {
			CreationCollection creationCollection = new CreationCollection(eContext, this, listTypeApSeuil.getSelectedItem());
			WindowHandler.runModal(creationCollection, "Création d'une collection de groupes");
		}
	}

	/* permet de modifier quelques proprietes de la collection selectionnee */
	public void modifierCollection(Object sender) {
		ScolGroupeCollection selectedColl = (ScolGroupeCollection) eodCollection.selectedObject();
		if (selectedColl != null) {
			// ModificationCollController modifCollCtrl = new ModificationCollController(owner,sender,selectedColl);
			// modifCollCtrl.setVisible(true);
			ModifierCollection modificationCollection = new ModifierCollection(selectedColl);
			modificationCollection.setMaquetteSemestre(semestre);
			modificationCollection.activateWindow();
			// reselection pour tenir compte des modifs.
			selectionnerApsPourCollection();
		}
	}

	public void ajouterGroupe(Object sender) {
		ScolGroupeCollection collection = (ScolGroupeCollection) eodCollection.selectedObject();
		if (collection != null) {
			GroupeController grpCtrl = new GroupeController(owner, sender, null, collection);
			grpCtrl.setVisible(true);
			displayGroupDidChangeSelection(eodCollection);
		}
	}

	/** permet de modifier quelques proprietes du groupe */
	public void modifierGroupe(Object sender) {
		ScolGroupeGrp selectedGroupe = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
		if (selectedGroupe != null) {
			GroupeController modifGrpCtrl = new GroupeController(owner, sender, selectedGroupe, (ScolGroupeCollection) eodCollection.selectedObject());
			modifGrpCtrl.setVisible(true);
		}
	}

	public void supprimerGroupe() {
		ScolGroupeGrp selectedGroupe = (ScolGroupeGrp) eodGrpGroupe.selectedObject();
		if (selectedGroupe != null) {
			if (eodGrpGroupe.displayedObjects() == null || eodGrpGroupe.displayedObjects().count() <= 1) {
				WindowHandler.showInfo("Supprimez la collection au lieu du dernier groupe !");
				return;
			}
			if (WindowHandler.showConfirmation("Supprimer ce groupe ?")) {
				try {
					groupeFactory().supprimerGroupe(selectedGroupe, true);
					if (eodCollection.selectedObject() != null) {
						eContext.invalidateObjectsWithGlobalIDs(eContext._globalIDsForObjects(((ScolGroupeCollection) eodCollection.selectedObject())
								.scolGroupeGrps()));
					}
					else {
						eContext.invalidateAllObjects();
					}
					displayGroupDidChangeSelection(eodCollection);
				}
				catch (Exception e) {
					if (e instanceof GroupeException) {
						WindowHandler.showError(e.getMessage());
					}
					else {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/** permet de supprimer une collection */
	public void supprimerCollection() {

		NSArray collections = eodCollection.selectedObjects();
		if (collections == null || collections.count() == 0 || !WindowHandler.showConfirmation("Supprimer les collections selectionnées ?")) {
			return;
		}

		WindowHandler.setWaitCursor(this.component());

		boolean retour = false;
		try {
			retour = groupeFactory().supprimerCollections(collections);
		}
		catch (Exception ex) {
			WindowHandler.setDefaultCursor(this.component());
			if (ex instanceof GroupeException) {
				WindowHandler.showError(ex.getMessage());
			}
			else {
				ex.printStackTrace();
			}
		}
		if (retour) {
			afficherCollectionsPourSemestre();
		}
		WindowHandler.setDefaultCursor(this.component());
	}

	/** Class de listener d'un bouton-menu */
	private class JComboListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			afficherApsPourSemestre(true);
		}
	}

	class SelectApCellRenderer extends DefaultTableCellRenderer {

		public SelectApCellRenderer() {
			super();
		}

		public void connectTable(EOTable laTable) {
			int indexColone;
			for (indexColone = 0; indexColone < laTable.table().getColumnModel().getColumnCount(); indexColone++) {
				laTable.table().getColumnModel().getColumn(indexColone).setCellRenderer(this);
			}
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

			Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			ScolMaquetteAp obj = (ScolMaquetteAp) eodMaquetteAp.displayedObjects().objectAtIndex(row);

			String mhcoCode = obj.mhcoCode();

			if (!isSelected) {
				component.setBackground(Color.WHITE);
			}
			else {
				if (mhcoCode.equals("TP")) {
					component.setBackground(MainClient.JAUNE);
				}
				else
					if (mhcoCode.equals("TD")) {
						component.setBackground(MainClient.VERT);
					}
					else
						if (mhcoCode.equals("CM")) {
							component.setBackground(MainClient.BLEU);
						}
						else {
							component.setBackground(MainClient.VIOLET);
						}
			}

			return component;
		}
	}

}
