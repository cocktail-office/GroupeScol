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

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;

public class GestionTrombino extends EOInterfaceController {

	private MainClient app = (MainClient) EOApplication.sharedApplication();
	public EODisplayGroup eodCollection, eodGroupeGrp, eodInscriptionGrp;
	public EOTable tableCollection, tableGroupeGrp, tableInscriptionGrp;

	private MainInterface owner;
	private PrintController printController;
	private EOEditingContext eContext;

	private final int PDF = 1;
	private final int XLS = 2;

	private int typeSortie;

	public GestionTrombino(MainInterface owner) {
		super(owner.editingContext());
		this.owner = owner;
	}

	protected void controllerDidLoadArchive(NSDictionary namedObjects) {
		super.controllerDidLoadArchive(namedObjects);
		eContext = editingContext();
		eodGroupeGrp.setDelegate(this);
	}

	protected void componentDidBecomeVisible() {
		WidgetHandler.setTableNotEditable(tableGroupeGrp);
		WidgetHandler.setTableNotEditable(tableCollection);
		WidgetHandler.setTableNotEditable(tableInscriptionGrp);
		chargerCollectionSemestre();
	}

	/** chargement des collections */
	private void chargerCollectionSemestre() {
		eodGroupeGrp.setDelegate(null);
		ScolMaquetteSemestre semestre = owner.getSelectedSemestre();
		ScolFormationAnnee annee = owner.getSelectedAnnee();
		if (semestre != null && annee != null) {

			EOQualifier qualColSem = DBHandler.getSimpleQualifier("scolMaquetteSemestre", semestre);
			NSArray collSemestre = DBHandler.fetchData(eContext, "VCollectionSemestre", qualColSem);
			eodCollection.setObjectArray((NSArray) collSemestre.valueForKey("scolGroupeCollection"));

			WidgetHandler.informObservingAssociation(eodCollection);
		}
		eodGroupeGrp.setDelegate(this);
		displayGroupDidChangeSelection(eodGroupeGrp);
	}

	public void displayGroupDidChangeSelection(EODisplayGroup eod) {
		if (eod == eodGroupeGrp) {
			ScolGroupeGrp groupe = (ScolGroupeGrp) eodGroupeGrp.selectedObject();
			if (groupe != null) {
				NSArray enfants = app.groupeFactory().enfantsVentiles(groupe);
				NSMutableArray inscrits = new NSMutableArray();
				for (int i = 0; i < enfants.count(); i++) {
					inscrits.addObjectsFromArray(((ScolGroupeGrp) enfants.objectAtIndex(i)).scolInscriptionGrps());
				}
				eodInscriptionGrp.setObjectArray(inscrits);
				WidgetHandler.informObservingAssociation(eodInscriptionGrp);
			}
		}
	}

	/** lance le choix des impressions des trombinos */
	public void imprimerTrombino(Object sender) {
		typeSortie = PDF;

		if (printController == null) {
			printController = new PrintController(this, sender);
		}

		printController.setVisible(true);

	}

	public void printAll() {
		NSArray etudiants = (NSArray) eodInscriptionGrp.displayedObjects().valueForKey("scolInscriptionEtudiant");
		ScolGroupeGrp groupe = (ScolGroupeGrp) eodGroupeGrp.selectedObject();
		if (groupe != null && etudiants.count() == 0) {
			WindowHandler.showError("Aucun etudiant dans le groupe ou aucun groupe selectionne");
			return;
		}

		if (typeSortie == PDF) {
			app.waitingHandler().setMessage("Cr\u00e9ation d'un fichier PDF en cours ...");
			owner.imprimerTrombino(etudiants, groupe.ggrpCode());
		}
		else {
			app.waitingHandler().setMessage("Cr\u00e9ation d'un fichier XLS en cours ...");
			owner.listeExcel(etudiants, groupe.ggrpCode());
		}
		app.waitingHandler().close();
	}

	public void printSelection() {
		ScolGroupeGrp groupe = (ScolGroupeGrp) eodGroupeGrp.selectedObject();
		NSArray etudiants = (NSArray) eodInscriptionGrp.selectedObjects().valueForKey("scolInscriptionEtudiant");
		if (groupe != null && etudiants.count() == 0) {
			WindowHandler.showError("Aucun etudiant selectionne ou aucun groupe selectionne");
			return;
		}

		if (typeSortie == PDF) {
			app.waitingHandler().setMessage("Cr\u00e9ation d'un fichier PDF en cours ...");
			owner.imprimerTrombino(etudiants, groupe.ggrpCode());
		}
		else {
			app.waitingHandler().setMessage("Cr\u00e9ation d'un fichier XLS en cours ...");
			owner.listeExcel(etudiants, groupe.ggrpCode());
		}
		app.waitingHandler().close();
	}

	public void listeExcel(Object sender) {
		typeSortie = XLS;
		if (printController == null) {
			printController = new PrintController(this, sender);
		}

		printController.setVisible(true);

	}

	public void fermer() {
		WindowHandler.closeModal(this);
	}

}
