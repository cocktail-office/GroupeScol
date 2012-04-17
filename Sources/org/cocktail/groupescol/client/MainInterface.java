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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.cocktail.groupescol.client.eof.PrefScol;
import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolFormationDiplome;
import org.cocktail.groupescol.client.eof.ScolFormationHabilitation;
import org.cocktail.groupescol.client.eof.ScolFormationSpecialisation;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;

import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eodistribution.client.EODistributedObjectStore;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import fr.univlr.cri.util.SystemCtrl;

public class MainInterface extends EOInterfaceController {

	private static final int CREATION = 0;
	private static final int VENTILATION = 1;

	public JComboBox comboAnnees, comboParcours, comboSemestres;
	public EODisplayGroup eodHabilitation;
	public JTabbedPane ongletModifCreat;
	public EOTable tableHabilitation;
	public JTextField tDiplome, tGrade;
	public JButton bSearchDiplome;

	private MainClient app;
	private EOEditingContext eContext;

	private EOSortOrdering sortDiplome, sortNiveau;
	private CreationController creationController;
	private Ventilation ventilation;
	private RecopieGroupesController recopieGroupesCtrl;

	private JComboListener comboListener;
	private boolean groupeActif = false;

	public MainInterface(EOEditingContext eContext, MainClient app) {
		super(eContext);
		this.app = app;
	}

	protected void controllerDidLoadArchive(NSDictionary namedObjects) {
		super.controllerDidLoadArchive(namedObjects);
		eContext = editingContext();
		this.init();
		this.createSubComponents();
		this.initWidget();
		app.waitingHandler().close();

	}

	protected void componentDidBecomeVisible() {
		new MenuHandler(this);
		affichePreferencesHabilitations();
	}

	private void init() {

		comboListener = new JComboListener();
		ongletModifCreat.addChangeListener(new TabListener());

		sortDiplome = EOSortOrdering.sortOrderingWithKey("scolFormationSpecialisation.scolFormationDiplome.fdipLibelle",
				EOSortOrdering.CompareCaseInsensitiveAscending);

		sortNiveau = EOSortOrdering.sortOrderingWithKey("fhabNiveau", EOSortOrdering.CompareAscending);

		comboAnnees.removeAllItems();
		comboParcours.removeAllItems();
		comboSemestres.removeAllItems();

		NSArray formationAnnee = app.getFormationAnnees();
		if (formationAnnee.count() == 0) {
			WindowHandler.showError("Pas d'annee scolaire disponible");
			return;
		}
		for (int i = 0; i < formationAnnee.count(); i++) {
			ScolFormationAnnee fAnnee = (ScolFormationAnnee) formationAnnee.objectAtIndex(i);
			comboAnnees.addItem(fAnnee);
			if (fAnnee.fannCourante().equals("O")) {
				fAnnee.fannKey();
				comboAnnees.setSelectedItem(fAnnee);
			}
		}

		comboAnnees.addActionListener(comboListener);
		comboParcours.addActionListener(comboListener);
		comboSemestres.addActionListener(comboListener);

		eodHabilitation.setDelegate(this);

		WidgetHandler.setTableNotEditable(tableHabilitation);
	}

	private void createSubComponents() {
		// Onglet 1
		creationController = new CreationController(this);
		ongletModifCreat.setComponentAt(CREATION, creationController.component());
		// Onglet 2
		ventilation = new Ventilation(this);
		ongletModifCreat.setComponentAt(VENTILATION, ventilation);
	}

	private void affichePreferencesHabilitations() {
		if (eodHabilitation.displayedObjects() == null || eodHabilitation.displayedObjects().count() == 0) {
			eodHabilitation.setObjectArray(getPreferencesHabilitations(getSelectedAnnee()));
		}
	}

	public ScolMaquetteParcours getSelectedParcours() {
		return (ScolMaquetteParcours) comboParcours.getSelectedItem();
	}

	public ScolFormationHabilitation getSelectedHabilitation() {
		return (ScolFormationHabilitation) eodHabilitation.selectedObject();
	}

	public ScolFormationSpecialisation getSelectedFormationSpecialisation() {
		if (eodHabilitation.selectedObject() != null) {
			return ((ScolFormationHabilitation) eodHabilitation.selectedObject()).scolFormationSpecialisation();
		}
		else {
			return null;
		}
	}

	/** retourne le semestre actuellement selectionne */
	public ScolMaquetteSemestre getSelectedSemestre() {
		return (ScolMaquetteSemestre) comboSemestres.getSelectedItem();
	}

	/** retourne le FormationAnnee selectionne dans le JComboBox */
	public ScolFormationAnnee getSelectedAnnee() {
		return (ScolFormationAnnee) comboAnnees.getSelectedItem();
	}

	/** retourne tous les parcours affiches # voir : InclusionNiveauDiplome.java */
	public NSArray getDisplayedParcours() {
		return WidgetHandler.getAllComboBoxItems(comboParcours);
	}

	/** retourne tous les semestres affiches # voir : InclusionNiveauDiplome.java */
	public NSArray getDisplayedSemestres() {
		return WidgetHandler.getAllComboBoxItems(comboSemestres);
	}

	/** chercherDiplome */
	public void chercherDiplome() {
		if (eodHabilitation.displayedObjects().count() > 0) {
			WidgetHandler.selectNoneInDisplayGroup(eodHabilitation);
		}

		WindowHandler.setWaitCursor(this.component());
		clear();
		eodHabilitation.setDelegate(null);
		String grade = tGrade.getText();
		String diplome = tDiplome.getText();

		NSMutableArray sumQualifiers = new NSMutableArray();

		if (!diplome.equals("")) {
			sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat(
					"scolFormationSpecialisation.scolFormationDiplome.fdipAbreviation caseInsensitiveLike '*" + diplome + "*'"
							+ " or scolFormationSpecialisation.scolFormationDiplome.fdipAbreviation caseInsensitiveLike '*" + diplome + "*'", null));
		}

		if (!grade.equals("")) {
			sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat(
					"scolFormationSpecialisation.scolFormationDiplome.fgraCode caseInsensitiveLike '*" + grade + "*'", null));
		}

		sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat("fannKey=%@",
				new NSArray(((ScolFormationAnnee) comboAnnees.getSelectedItem()).fannKey())));

		Number droits = (Number) app.userInfo("droits");
		if (droits.intValue() != -1) {
			EOQualifier qualDroits = EOQualifier.qualifierWithQualifierFormat("scolDroitDiplomes.dlogKey=%@ and scolDroitDiplomes.ddipGroupes='A'",
					new NSArray(droits));
			sumQualifiers.addObject(qualDroits);
		}
		else {
			WindowHandler.setDefaultCursor(this.component());
			return;
		}

		eodHabilitation.setSortOrderings(new NSArray(new Object[] { sortDiplome, sortNiveau }));
		EOQualifier totalQualifier = new EOAndQualifier(sumQualifiers);

		DBHandler.fetchDisplayGroup(eodHabilitation, totalQualifier, null, false);

		if (eodHabilitation.displayedObjects().count() == 0) {
			clear();
		}

		WidgetHandler.informObservingAssociation(eodHabilitation);
		eodHabilitation.setDelegate(this);
		WindowHandler.setDefaultCursor(this.component());

	}

	public boolean groupeActif() {
		return this.groupeActif;
	}

	/** reaction a un changement de selection dans la table des diplomes */
	public void displayGroupDidChangeSelection(EODisplayGroup grp) {
		WindowHandler.setWaitCursor(this.component());
		if (grp == eodHabilitation) {
			ScolFormationHabilitation selectedHabilitation = (ScolFormationHabilitation) eodHabilitation.selectedObject();
			if (selectedHabilitation != null && selectedHabilitation.scolFormationSpecialisation() != null) {
				this.afficherParcours(selectedHabilitation);
				PrefScol prefScol = getPrefScolForHabilitation(selectedHabilitation);
				if (prefScol != null && prefScol.scolMaquetteRepartitionSem() != null) {
					comboParcours.setSelectedItem(prefScol.scolMaquetteRepartitionSem().scolMaquetteParcours());
					comboSemestres.setSelectedItem(prefScol.scolMaquetteRepartitionSem().scolMaquetteSemestre());
				}
			}
			else {
				clear();
			}
		}
		WindowHandler.setDefaultCursor(this.component());
	}

	private NSArray getPreferencesHabilitations(ScolFormationAnnee fa) {
		NSMutableArray quals = new NSMutableArray();
		quals.addObject(new EOKeyValueQualifier(PrefScol.INDIVIDU_ULR_KEY, EOKeyValueQualifier.QualifierOperatorEqual, app.userInfo("individu")));
		if (fa != null) {
			quals.addObject(new EOKeyValueQualifier(PrefScol.SCOL_FORMATION_ANNEE_KEY, EOKeyValueQualifier.QualifierOperatorEqual, fa));
		}
		NSArray preferences = PrefScol.fetchPrefScols(eContext, new EOAndQualifier(quals), null);
		return (NSArray) preferences.valueForKey(PrefScol.SCOL_FORMATION_HABILITATION_KEY);
	}

	private PrefScol getPrefScolForHabilitation(ScolFormationHabilitation habilitation) {
		try {
			if (habilitation == null) {
				return null;
			}
			NSMutableArray quals = new NSMutableArray(2);
			quals.addObject(new EOKeyValueQualifier(PrefScol.INDIVIDU_ULR_KEY, EOKeyValueQualifier.QualifierOperatorEqual, app.userInfo("individu")));
			quals.addObject(new EOKeyValueQualifier(PrefScol.SCOL_FORMATION_ANNEE_KEY, EOKeyValueQualifier.QualifierOperatorEqual, habilitation
					.scolFormationAnnee()));
			NSArray prefScols = habilitation.prefScols(new EOAndQualifier(quals));
			if (prefScols != null && prefScols.count() > 0) {
				return (PrefScol) prefScols.objectAtIndex(0);
			}
		}
		catch (Exception e) {
		}
		return null;
	}

	private void afficherParcours(ScolFormationHabilitation habilitation) {
		comboParcours.removeAllItems();

		EOQualifier qParcours = DBHandler.getSimpleQualifier(ScolMaquetteParcours.SCOL_FORMATION_SPECIALISATION_KEY,
				habilitation.scolFormationSpecialisation());
		EOSortOrdering sortParcours = EOSortOrdering.sortOrderingWithKey(ScolMaquetteParcours.MPAR_LIBELLE_KEY,
				EOSortOrdering.CompareCaseInsensitiveAscending);
		NSArray parcours = DBHandler.fetchData(eContext, ScolMaquetteParcours.ENTITY_NAME, qParcours, sortParcours);

		for (int i = 0; i < parcours.count(); i++) {
			comboParcours.addItem(parcours.objectAtIndex(i));
		}
		NSArray semestres = null;
		for (int i = 0; i < comboParcours.getItemCount(); i++) {
			ScolMaquetteParcours mp = (ScolMaquetteParcours) comboParcours.getItemAt(i);
			semestres = getSemestresForParcours(mp, habilitation);
			if (semestres != null && semestres.count() > 0) {
				comboParcours.setSelectedItem(mp);
				break;
			}
		}

		afficherSemestres(semestres);
	}

	private NSArray getSemestresForParcours(ScolMaquetteParcours parcours, ScolFormationHabilitation habilitation) {
		if (habilitation == null || parcours == null) {
			return null;
		}
		int niveau = habilitation.fhabNiveau().intValue();
		int ordre1 = niveau * 2 - 1;
		int ordre2 = ordre1 + 1;
		EOQualifier qualSem = EOQualifier.qualifierWithQualifierFormat("(" + ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY + "."
				+ ScolMaquetteSemestre.MSEM_ORDRE_KEY + " = %@ or " + ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY + "."
				+ ScolMaquetteSemestre.MSEM_ORDRE_KEY + " = %@) and " + ScolMaquetteRepartitionSem.SCOL_MAQUETTE_PARCOURS_KEY + " = %@ and "
				+ ScolMaquetteRepartitionSem.SCOL_FORMATION_ANNEE_KEY + " = %@", new NSArray(new Object[] { new Integer(ordre1), new Integer(ordre2),
				parcours, habilitation.scolFormationAnnee() }));
		EOSortOrdering sortSemestre = EOSortOrdering.sortOrderingWithKey(ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY + "."
				+ ScolMaquetteSemestre.MSEM_ORDRE_KEY, EOSortOrdering.CompareCaseInsensitiveAscending);

		return (NSArray) ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSems(eContext, qualSem, new NSArray(sortSemestre)).valueForKey(
				ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY);
	}

	/** permet d'afficher les semestres du parcours actuellement affiche */
	private void afficherSemestres(NSArray semestres) {

		WindowHandler.setWaitCursor(this.component());

		ScolFormationHabilitation selectedHabilitation = (ScolFormationHabilitation) eodHabilitation.selectedObject();
		ScolMaquetteParcours parcours = (ScolMaquetteParcours) comboParcours.getSelectedItem();

		if (selectedHabilitation == null || parcours == null) {
			return;
		}

		if (semestres == null) {
			semestres = getSemestresForParcours(parcours, selectedHabilitation);
		}

		comboSemestres.removeActionListener(comboListener);
		comboSemestres.removeAllItems();
		for (int i = 0; i < semestres.count(); i++) {
			comboSemestres.addItem(semestres.objectAtIndex(i));
		}

		comboSemestres.getSelectedItem();
		fireSemestreSelectionChanged();
		comboSemestres.addActionListener(comboListener);

		WindowHandler.setDefaultCursor(this.component());
	}

	private void fireSemestreSelectionChanged() {
		ScolMaquetteSemestre selectedSemestre = (ScolMaquetteSemestre) comboSemestres.getSelectedItem();
		ScolMaquetteParcours selectedParcours = (ScolMaquetteParcours) comboParcours.getSelectedItem();
		creationController.semestreSelectionChanged(selectedSemestre);
		ventilation.semestreSelectionChanged(selectedSemestre, selectedParcours);
	}

	private void initWidget() {
		bSearchDiplome.setText("");
		WidgetHandler.decorateButton("Recherche des diplomes", null, "find", bSearchDiplome);
	}

	/** remise a zero des infos affichees */
	private void clear() {
		comboParcours.removeAllItems();
		comboSemestres.removeAllItems();
		creationController.clear();
		ventilation.clear();
	}

	/** listener sur les onglets */
	private class TabListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			int indexOnglet = ongletModifCreat.getSelectedIndex();
			if (indexOnglet == VENTILATION) {
				ventilation.refresh();
			}

		}
	}

	/** Class de listener d'un bouton-menu */
	private class JComboListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == comboAnnees) {
				clear();
				eodHabilitation.setObjectArray(null);
				affichePreferencesHabilitations();
				// chercherDiplome();
			}

			else
				if (e.getSource() == comboParcours) {
					afficherSemestres(null);
				}

				else
					if (e.getSource() == comboSemestres) {
						fireSemestreSelectionChanged();
					}

		}
	}

	/** menu Fichier>Imprimer/Exporter */
	public void lancerGestionTrombino() {
		GestionTrombino gestionTrombino = new GestionTrombino(this);
		WindowHandler.runModal(gestionTrombino, "Imprimer un trombino / exporter un fichier tableur");
	}

	/** imprimerTrombino */
	public void imprimerTrombino(NSArray etudiants, String groupe) {

		NSMutableDictionary infos = new NSMutableDictionary();

		ScolFormationHabilitation habilitation = (ScolFormationHabilitation) eodHabilitation.selectedObject();
		ScolFormationDiplome eoDiplome = habilitation.scolFormationSpecialisation().scolFormationDiplome();
		ScolMaquetteSemestre eoSemestre = (ScolMaquetteSemestre) comboSemestres.getSelectedItem();

		StringBuffer libelleDip = new StringBuffer();

		EOGenericRecord filGrad = DBHandler.fetchUniqueData(eContext, "ScolFormationGrade", "fgraCode", eoDiplome.fgraCode());
		if (filGrad != null) {
			libelleDip.append((String) filGrad.valueForKey("fgraAbreviation"));
			libelleDip.append(" : ");
		}
		else {
			filGrad = DBHandler.fetchUniqueData(eContext, "ScolFormationFiliere", "ffilCode", eoDiplome.fgraCode());
			if (filGrad != null) {
				libelleDip.append((String) filGrad.valueForKey("ffilAbreviation"));
				libelleDip.append(" : ");
			}
		}

		libelleDip.append(eoDiplome.fdipAbreviation());

		ScolFormationAnnee annee = (ScolFormationAnnee) comboAnnees.getSelectedItem();
		String specialite = habilitation.scolFormationSpecialisation().fspnLibelle();

		String fannKey = annee.fannDebut().toString() + "-" + annee.fannFin().toString();
		String semestre = eoSemestre.toString();
		infos.takeValueForKey(libelleDip.toString(), "diplome");
		if (specialite == null) {
			specialite = "";
		}
		infos.takeValueForKey(specialite, "specialite");
		infos.takeValueForKey(fannKey, "annee");
		infos.takeValueForKey(semestre, "semestre");
		infos.takeValueForKey(groupe, "groupe");

		NSData pdfData = null;
		try {
			pdfData = PrintFactory.imprimerTrombino(eContext, etudiants, infos, (NSDictionary) app.userInfo("printParameters"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		FileHandler fileHandler = new FileHandler();
		if (pdfData != null && fileHandler != null) {
			String fname = "Trombino-" + groupe + "-" + fannKey;

			try {
				String filePath = fileHandler.dataToXXX(pdfData, fname, "pdf");
				fileHandler.openFile(filePath);
			}
			catch (Exception e) {
				WindowHandler.showError(e.getMessage());
			}
		}
		else {
			WindowHandler.showError("Erreur de generation du trombino.");
		}

	}

	/** imprimerTrombino */
	public void listeExcel(NSArray etudiants, String groupe) {
		NSMutableDictionary infos = new NSMutableDictionary();

		ScolFormationHabilitation habilitation = (ScolFormationHabilitation) eodHabilitation.selectedObject();
		ScolFormationDiplome eoDiplome = habilitation.scolFormationSpecialisation().scolFormationDiplome();
		ScolMaquetteSemestre eoSemestre = (ScolMaquetteSemestre) comboSemestres.getSelectedItem();

		StringBuffer libelleDip = new StringBuffer();

		EOGenericRecord filGrad = DBHandler.fetchUniqueData(eContext, "ScolFormationGrade", "fgraCode", eoDiplome.fgraCode());
		if (filGrad != null) {
			libelleDip.append((String) filGrad.valueForKey("fgraAbreviation"));
			libelleDip.append(" : ");
		}
		else {
			filGrad = DBHandler.fetchUniqueData(eContext, "ScolFormationFiliere", "ffilCode", eoDiplome.fgraCode());
			if (filGrad != null) {
				libelleDip.append((String) filGrad.valueForKey("ffilAbreviation"));
				libelleDip.append(" : ");
			}
		}

		libelleDip.append(eoDiplome.fdipAbreviation());

		ScolFormationAnnee annee = (ScolFormationAnnee) comboAnnees.getSelectedItem();
		String specialite = habilitation.scolFormationSpecialisation().fspnLibelle();

		String fannKey = annee.fannDebut().toString() + "-" + annee.fannFin().toString();

		infos.takeValueForKey(eoSemestre.toString(), "semestre");

		String ap = "";
		infos.takeValueForKey(libelleDip.toString(), "diplome");
		if (specialite == null) {
			specialite = "";
		}
		infos.takeValueForKey(specialite, "specialite");
		infos.takeValueForKey(fannKey, "annee");
		infos.takeValueForKey(ap, "ap");
		infos.takeValueForKey(groupe, "groupe");

		NSData xlsData = null;
		NSArray idEtudiants = DBHandler.globalIDsForObjects(eContext, etudiants);

		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		xlsData = (NSData) objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestXlsFile", new Class[] { NSArray.class,
				NSDictionary.class }, new Object[] { idEtudiants, infos }, false);

		FileHandler fileHandler = new FileHandler();
		if (xlsData != null && fileHandler != null) {
			String fname = "Liste-" + groupe + "-" + fannKey;
			try {
				String filePath = fileHandler.dataToXXX(xlsData, fname, "xls");
				fileHandler.openFile(filePath);
			}
			catch (Exception e) {
				WindowHandler.showError(e.getMessage());
			}
		}
		else {
			WindowHandler.showError("Erreur de generation du trombino.");
		}

	}

	/** lancerViewlet */
	public void lancerViewlet() {
		WindowHandler.setWaitCursor(this.component());
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		String urlViewlet = (String) objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestGetUrlViewlet", null, null,
				false);
		if (urlViewlet == null) {
			WindowHandler.setDefaultCursor(this.component());
			return;
		}

		String retour = SystemCtrl.openFileInBrowser(urlViewlet);
		if (retour != null) {
			WindowHandler.showError("Erreur d'ouverture");
		}

		WindowHandler.setDefaultCursor(this.component());
	}

	/** affiche la boite a propos */
	public void lancerAPropos() {
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		NSDictionary myInfos = (NSDictionary) objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestGetVersion", null,
				null, false);
		new AProposCtrl(myInfos.hashtable(), WindowHandler.getJFrameFromController(this));
	}

	/** ouvre la fenetre de recopie de groupes */
	public void lancerRecopieGroupe() {
		if (recopieGroupesCtrl == null) {
			recopieGroupesCtrl = new RecopieGroupesController(eContext);
		}

		ScolMaquetteParcours selectedParcours = (ScolMaquetteParcours) comboParcours.getSelectedItem();
		ScolMaquetteSemestre sem = (ScolMaquetteSemestre) comboSemestres.getSelectedItem();
		NSArray parcs = WidgetHandler.getAllComboBoxItems(comboParcours);
		ScolFormationHabilitation habilitation = (ScolFormationHabilitation) eodHabilitation.selectedObject();
		ScolFormationAnnee annee = (ScolFormationAnnee) comboAnnees.getSelectedItem();

		if (selectedParcours == null || sem == null || habilitation == null || annee == null || parcs.count() == 0) {
			WindowHandler.showError("Veuillez selectioner un parcours et un semestre d'abord");
			return;
		}

		NSDictionary infos = new NSDictionary(new Object[] { habilitation, selectedParcours, sem, annee, parcs }, new Object[] { "habilitation",
				"parcours", "semestre", "annee", "allParcours" });

		recopieGroupesCtrl.setVisibleWithInfos(infos);
	}

	public void setWait() {
		WindowHandler.setWaitCursor(this.component());
	}

	public void setDefault() {
		WindowHandler.setDefaultCursor(this.component());
	}

	public void quitter() {
		if (WindowHandler.showConfirmation("Voulez-vous vraiement fermer l'application ?")) {
			app.setCanQuit(true);
			app.quit();
		}
	}

}
