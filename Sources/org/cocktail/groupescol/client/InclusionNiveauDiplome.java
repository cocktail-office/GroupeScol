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
import javax.swing.JComboBox;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolFormationHabilitation;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;

import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class InclusionNiveauDiplome extends EOInterfaceController {

	public JButton bAnnuler, bValider;
	public JComboBox comboParcours, comboSemestre;
	public EODisplayGroup eodGroupeCollection, eodGroupeGrp;
	public EOTable tableGroupeCollection, tableGroupeGrp;

	private CreationController owner;
	private EOEditingContext eContext;

	public InclusionNiveauDiplome(CreationController owner) {
		super(owner.editingContext());
		this.owner = owner;
		eContext = owner.editingContext();
	}

	protected void connectionWasEstablished() {
		NSArray parcours = owner.mainInterface().getDisplayedParcours();
		NSArray semestres = owner.mainInterface().getDisplayedSemestres();
		WidgetHandler.setObjectsToComboBox(parcours, comboParcours);
		WidgetHandler.setObjectsToComboBox(semestres, comboSemestre);
		comboSemestre.addItem("(Tous)");

		JComboListener comboListener = new JComboListener();
		comboParcours.addActionListener(comboListener);
		comboSemestre.addActionListener(comboListener);

		eodGroupeCollection.setDelegate(this);
		eodGroupeGrp.setDelegate(this);
		semestreSelectionChanged();
	}

	protected void componentDidBecomeVisible() {
		WidgetHandler.decorateButton("Renoncer a l'inclusion", null, "cancel", bAnnuler);
		WidgetHandler.decorateButton("Inclure les groupes selectionn\u00e9s", null, "ok", bValider);
		WidgetHandler.setTableNotEditable(tableGroupeCollection);
		WidgetHandler.setTableNotEditable(tableGroupeGrp);
	}

	public void annuler(Object sender) {
		WindowHandler.closeModal(this);
	}

	public void valider(Object sender) {
		NSArray groupeAInclure = eodGroupeGrp.selectedObjects();
		if (owner.inclureDansGroupeSelectionne(groupeAInclure)) {
			WindowHandler.showInfo("L'inclusion s'est bien déroulée");
			WindowHandler.closeModal(this);
		}
		else {
			WindowHandler.showError("Echec de l'inclusion");
		}
	}

	private void parcoursSelectionChanged() {
		ScolFormationHabilitation hab = owner.mainInterface().getSelectedHabilitation();
		ScolMaquetteParcours parc = (ScolMaquetteParcours) comboParcours.getSelectedItem();
		ScolFormationAnnee annee = owner.mainInterface().getSelectedAnnee();

		if (hab == null || parc == null || annee == null) {
			return;
		}

		NSArray semestres = ScolariteHandler.semestresFromHabilitationParcours(eContext, hab, parc, annee.fannKey());
		WidgetHandler.setObjectsToComboBox(semestres, comboSemestre);
		comboSemestre.addItem("(Tous)");
		semestreSelectionChanged();
	}

	/** reaction au changement de semestre dans le combobox semestres : affichage des collections */
	private void semestreSelectionChanged() {
		Object semestre = comboSemestre.getSelectedItem();
		ScolFormationAnnee annee = owner.mainInterface().getSelectedAnnee();
		if ((semestre instanceof String) && comboSemestre.getItemCount() > 1) {
			NSMutableArray tousSemestres = WidgetHandler.getAllComboBoxItems(comboSemestre).mutableClone();
			Object obj;
			for (int i = 0; i < tousSemestres.count(); i++) {
				obj = tousSemestres.objectAtIndex(i);
				if (!(obj instanceof ScolMaquetteSemestre)) {
					tousSemestres.removeObject(obj);
				}
			}
			afficherCollections(tousSemestres, annee.fannKey());
		}
		else
			if (semestre instanceof ScolMaquetteSemestre) {
				afficherCollections((ScolMaquetteSemestre) semestre, annee.fannKey());
			}
			else {
				return;
			}
	}

	/** affiche les collection du seul semestre 'semestre' passe en parametre */
	private void afficherCollections(ScolMaquetteSemestre semestre, Number fannKey) {
		WindowHandler.setWaitCursor(component());
		EOQualifier qualColSem = null;
		if (semestre != null) {
			qualColSem = DBHandler.getSimpleQualifier("scolMaquetteSemestre", semestre);
		}
		NSArray collSemestre = DBHandler.fetchData(eContext, "VCollectionSemestre", qualColSem);
		eodGroupeCollection.setObjectArray((NSArray) collSemestre.valueForKey("scolGroupeCollection"));
		WidgetHandler.informObservingAssociation(eodGroupeCollection);
		displayGroupDidChangeSelection(eodGroupeCollection); // forcer l'affichage des groupes...
		WindowHandler.setDefaultCursor(component());
	}

	/** affiche les collections de plusieurs semestres passes dans semestres */
	private void afficherCollections(NSArray semestres, Number fannKey) {
		WindowHandler.setWaitCursor(component());

		NSMutableArray sumQual = new NSMutableArray();
		for (int i = 0; i < semestres.count(); i++) {
			sumQual.addObject(DBHandler.getSimpleQualifier("scolMaquetteSemestre", semestres.objectAtIndex(i)));
		}
		NSArray collSemestre = DBHandler.fetchData(eContext, "VCollectionSemestre", new EOOrQualifier(sumQual));
		eodGroupeCollection.setObjectArray((NSArray) collSemestre.valueForKey("scolGroupeCollection"));
		WidgetHandler.informObservingAssociation(eodGroupeCollection);
		displayGroupDidChangeSelection(eodGroupeCollection); // forcer l'affichage des groupes...
		WindowHandler.setDefaultCursor(component());
	}

	public void displayGroupDidChangeSelection(EODisplayGroup grp) {
		if (grp == eodGroupeCollection) {
			ScolGroupeCollection selectCollection = (ScolGroupeCollection) eodGroupeCollection.selectedObject();
			NSArray selectColls = eodGroupeCollection.selectedObjects();
			NSMutableArray groupes = new NSMutableArray();
			for (int i = 0; i < selectColls.count(); i++) {
				groupes.addObjectsFromArray(selectCollection.scolGroupeGrps());
			}

			groupes = DBHandler.retirerMultiples(groupes);
			eodGroupeGrp.setObjectArray(groupes);
			WidgetHandler.informObservingAssociation(eodGroupeGrp);
		}
	}

	private class JComboListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == comboParcours) {
				parcoursSelectionChanged();
			}
			else
				if (e.getSource() == comboSemestre) {
					semestreSelectionChanged();
				}
		}
	}

}
