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

import org.cocktail.groupescol.client.eof.ScolGroupeCollection;

import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.eointerface.swing.EOTable;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;

public class GroupeInclusion extends EOInterfaceController {

	public EODisplayGroup eodGroupeGrp;
	public EOTable tableGroupeGrp;

	private CreationController owner;

	public GroupeInclusion(CreationController owner) {
		super(owner.editingContext());
		this.owner = owner;
	}

	protected void controllerDidLoadArchive(NSDictionary objects) {
		super.controllerDidLoadArchive(objects);
		WidgetHandler.setTableNotEditable(tableGroupeGrp);
		EOSortOrdering sortCode = EOSortOrdering.sortOrderingWithKey("ggrpCode", EOSortOrdering.CompareCaseInsensitiveAscending);
		EOSortOrdering sortCapa = EOSortOrdering.sortOrderingWithKey("ggrpMaxCapacite", EOSortOrdering.CompareAscending);
		eodGroupeGrp.setSortOrderings(new NSArray(new Object[] { sortCode, sortCapa }));
		NSArray collections = owner.getDisplayedCollections();
		NSMutableArray groupes = new NSMutableArray();
		for (int i = 0; i < collections.count(); i++) {
			groupes.addObjectsFromArray(((ScolGroupeCollection) collections.objectAtIndex(i)).scolGroupeGrps());
		}
		eodGroupeGrp.setObjectArray(groupes);
	}

	/** valider l'inclusion */
	public void validerInclusion(Object sender) {
		NSArray groupeAInclure = eodGroupeGrp.selectedObjects();
		if (owner.inclureDansGroupeSelectionne(groupeAInclure)) {
			WindowHandler.showInfo("L'inclusion s'est bien déroulée");
			WindowHandler.closeModal(this);
		}
		else {
			WindowHandler.showError("Echec de l'inclusion");
		}
	}

	public void annuler(Object sender) {
		editingContext().revert();
		WindowHandler.closeModal(this);
	}

}
