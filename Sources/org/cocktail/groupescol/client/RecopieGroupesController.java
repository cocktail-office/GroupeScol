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
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolFormationHabilitation;
import org.cocktail.groupescol.client.eof.ScolFormationSpecialisation;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOArchive;
import com.webobjects.eoapplication.EOModalDialogController;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

public class RecopieGroupesController extends EOModalDialogController {

	private MainClient app = (MainClient) EOApplication.sharedApplication();

	public JComboBox comboAnneeDest, comboParcoursDest, comboSemDest, comboParcoursSrc, comboSemSrc;
	public EODisplayGroup eodCollectionDest, eodHabilitationDest;
	public EOTable tableCollectionDst, tableHabilitationDest;
	public JButton bRecopier, bModifierLibelle;
	public JTextField tGrade, tDiplome;
	public JTextArea taDiplomeSrc;
	public JProgressBar progressBar;

	ScolFormationHabilitation habilitation;
	ScolFormationAnnee formAnnee;
	ScolMaquetteParcours parcours;
	ScolMaquetteSemestre semestre;
	NSArray allParcours;

	private EOEditingContext eContext;
	private GroupeCopier groupeCopier;

	public RecopieGroupesController(EOEditingContext eContext) {
		super();
		this.eContext = eContext;
		groupeCopier = new GroupeCopier(eContext);
		EOEditingContext.setSubstitutionEditingContext(eContext);
		EOArchive.loadArchiveNamed("RecopieGroupesController", this, "org.cocktail.groupescol.client", this.disposableRegistry());
		establishConnection();
	}

	protected void connectionWasEstablished() {
		init();
	}

	protected void componentDidBecomeVisible() {
		setWindowTitle(window(), "Recopie de collections/groupes");
	}

	public void setVisibleWithInfos(NSDictionary infos) {

		habilitation = (ScolFormationHabilitation) infos.objectForKey("habilitation");
		parcours = (ScolMaquetteParcours) infos.objectForKey("parcours");
		semestre = (ScolMaquetteSemestre) infos.objectForKey("semestre");
		formAnnee = (ScolFormationAnnee) infos.objectForKey("annee");
		allParcours = (NSArray) infos.objectForKey("allParcours");

		ScolFormationSpecialisation spe = habilitation.scolFormationSpecialisation();

		StringBuffer dipSrc = new StringBuffer((String) spe.valueForKeyPath("scolFormationDiplome.fdipAbreviation"));
		if (spe.fspnLibelle() != null) {
			dipSrc.append(" - ");
			dipSrc.append(spe.fspnLibelle());
		}
		taDiplomeSrc.setText(dipSrc.toString());
		taDiplomeSrc.setEditable(false);
		WidgetHandler.setObjectsToComboBox(allParcours, comboParcoursSrc);
		comboParcoursSrc.setSelectedItem(parcours);
		comboSemSrc.setSelectedItem(semestre);

		WidgetHandler.flushDisplayGroup(eodCollectionDest);
		progressBar.setValue(0);
		activateWindow();
	}

	private void init() {
		WidgetHandler.setTableNotEditable(tableHabilitationDest);

		comboAnneeDest.removeAllItems();
		comboParcoursDest.removeAllItems();
		comboSemDest.removeAllItems();
		comboSemSrc.removeAllItems();
		comboParcoursSrc.removeAllItems();

		NSArray formationAnnee = app.getFormationAnnees();
		if (formationAnnee.count() == 0) {
			WindowHandler.showError("Pas d'annee scolaire disponible");
			return;
		}
		// les formationsAnnees.
		for (int i = 0; i < formationAnnee.count(); i++) {
			ScolFormationAnnee fAnnee = (ScolFormationAnnee) formationAnnee.objectAtIndex(i);
			comboAnneeDest.addItem(fAnnee);
			if (fAnnee.fannCourante().equals("O")) {
				fAnnee.fannKey();
				comboAnneeDest.setSelectedItem(fAnnee);
			}
		}

		JComboListener comboListener = new JComboListener();
		comboParcoursSrc.addActionListener(comboListener);
		comboParcoursDest.addActionListener(comboListener);
		comboAnneeDest.addActionListener(comboListener);

		eodHabilitationDest.setDelegate(this);

	}

	/** recherche le diplome destination de la recopie */
	public void rechercherDiplome(Object sender) {
		WindowHandler.setWaitCursor(this);
		String grade = tGrade.getText();
		String diplome = tDiplome.getText();
		Number droits = (Number) app.userInfo("droits");
		ScolFormationAnnee fAnnee = (ScolFormationAnnee) comboAnneeDest.getSelectedItem();
		if (droits != null && fAnnee != null) {
			NSArray habs = ScolariteHandler.getHabilitations(eContext, diplome, grade, fAnnee.fannKey(), droits);
			eodHabilitationDest.setObjectArray(habs);
			WidgetHandler.informObservingAssociation(eodHabilitationDest);
		}
		WindowHandler.setDefaultCursor(this);
	}

	/** charge les parcours de destination par rapport a l'habilitation selectionnee */
	private void afficherParcoursDest(ScolFormationSpecialisation specialisation) {

		comboParcoursDest.removeAllItems();
		EOQualifier qParcours = DBHandler.getSimpleQualifier("scolFormationSpecialisation", specialisation);
		EOSortOrdering sortParcours = EOSortOrdering.sortOrderingWithKey("mparLibelle", EOSortOrdering.CompareCaseInsensitiveAscending);
		NSArray parcours = DBHandler.fetchData(eContext, "ScolMaquetteParcours", qParcours, sortParcours);
		WidgetHandler.setObjectsToComboBox(parcours, comboParcoursDest);

		afficherSemestresDest();
	}

	public void afficherSemestresDest() {
		ScolFormationHabilitation habilitation = (ScolFormationHabilitation) eodHabilitationDest.selectedObject();
		ScolFormationAnnee fAnnee = (ScolFormationAnnee) comboAnneeDest.getSelectedItem();
		ScolMaquetteParcours parcours = (ScolMaquetteParcours) comboParcoursDest.getSelectedItem();
		if (habilitation == null || fAnnee == null || parcours == null) {
			return;
		}
		NSArray semestres = ScolariteHandler.semestresFromHabilitationParcours(eContext, habilitation, parcours, fAnnee.fannKey());
		WidgetHandler.setObjectsToComboBox(semestres, comboSemDest);
	}

	public void displayGroupDidChangeSelection(EODisplayGroup eod) {

		if (eod == eodHabilitationDest) {
			ScolFormationHabilitation selectHabilitation = (ScolFormationHabilitation) eodHabilitationDest.selectedObject();
			if (selectHabilitation != null) {
				afficherParcoursDest(selectHabilitation.scolFormationSpecialisation());
			}
		}

	}

	/** parcoursSrcChanged */
	public void parcoursSrcChanged(ScolMaquetteParcours parcours) {
		if (parcours == null) {
			WidgetHandler.setObjectsToComboBox(null, comboSemSrc);
		}
		else {
			NSArray semestres = ScolariteHandler.semestresFromHabilitationParcours(eContext, habilitation, parcours, formAnnee.fannKey());
			WidgetHandler.setObjectsToComboBox(semestres, comboSemSrc);
		}
	}

	public void recopier(Object sender) {

		Thread thread = new Thread() {
			public void run() {
				try {
					RecopieAction action = new RecopieAction();
					action.lancerRecopie();
					throw new InterruptedException();
				}
				catch (InterruptedException e) {
				}
			}
		};
		thread.start();
	}

	public void fermer() {
		deactivateWindow();
	}

	private class JComboListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if (src == comboParcoursSrc) {
				parcoursSrcChanged((ScolMaquetteParcours) comboParcoursSrc.getSelectedItem());
			}
			else
				if (src == comboAnneeDest) {
					rechercherDiplome(comboAnneeDest);
				}
				else
					if (src == comboParcoursDest) {
						afficherSemestresDest();
					}
		}
	}

	private class RecopieAction {

		/** effectue la recopie des collections du semestre source vers le semestre destination, + remplissage de ScolTransfertGrp */
		public synchronized void lancerRecopie() {
			NSArray collections = ScolGroupeCollection.getCollectionsForSemestre(eContext, semestre);

			progressBar.setMinimum(0);
			progressBar.setMaximum(collections.count());

			groupeCopier.setSemestreSrc((ScolMaquetteSemestre) comboSemSrc.getSelectedItem());
			groupeCopier.setSemestreDst((ScolMaquetteSemestre) comboSemDest.getSelectedItem());
			groupeCopier.setFormAnneeDst(formAnnee);

			for (int i = 0; i < collections.count(); i++) {
				progressBar.setValue(i + 1);
				ScolGroupeCollection oldCollection = (ScolGroupeCollection) collections.objectAtIndex(i);
				ScolGroupeCollection newCollection = groupeCopier.recopierCollection(oldCollection);
				if (newCollection != null) {
					eodCollectionDest.insertObjectAtIndex(newCollection, 0);
					WidgetHandler.informObservingAssociation(eodCollectionDest);
				}

				NSArray groupes = oldCollection.scolGroupeGrps();
				for (int j = 0; j < groupes.count(); j++) {
					groupeCopier.recopierGroupe((ScolGroupeGrp) groupes.objectAtIndex(j), newCollection);
				}
			}

			if (saveChanges()) {
				groupeCopier.remplirTransfertGrp();
				saveChanges();
			}
		}
	}

	public boolean saveChanges() {
		boolean status = true;
		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception e) {
			status = false;
			eContext.revert();
			e.printStackTrace();
			WindowHandler.showError(e.getMessage());
		}
		finally {
			eContext.unlock();
		}
		return status;
	}

}
