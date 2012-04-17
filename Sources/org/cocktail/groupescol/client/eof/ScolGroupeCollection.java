/*
 * Copyright Cocktail, 2001-2008
 * 
 * This software is governed by the CeCILL license under French law and abiding by the rules of distribution of free software. You can use,
 * modify and/or redistribute the software under the terms of the CeCILL license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * 
 * As a counterpart to the access to the source code and rights to copy, modify and redistribute granted by the license, users are provided
 * only with a limited warranty and the software's author, the holder of the economic rights, and the successive licensors have only limited
 * liability.
 * 
 * In this respect, the user's attention is drawn to the risks associated with loading, using, modifying and/or developing or reproducing
 * the software by the user in light of its specific status of free software, that may mean that it is complicated to manipulate, and that
 * also therefore means that it is reserved for developers and experienced professionals having in-depth computer knowledge. Users are
 * therefore encouraged to load and test the software's suitability as regards their requirements in conditions enabling the security of
 * their systems and/or data to be ensured and, more generally, to use and operate it in the same conditions as regards security.
 * 
 * The fact that you are presently reading this means that you have had knowledge of the CeCILL license and that you accept its terms.
 */

package org.cocktail.groupescol.client.eof;

import org.cocktail.groupescol.client.DBHandler;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation;

public class ScolGroupeCollection extends _ScolGroupeCollection {

	public ScolGroupeCollection() {
		super();
	}

	public String toString() {
		return gcolLibelle();
	}

	public static NSArray getCollectionsForSemestre(EOEditingContext ec, ScolMaquetteSemestre semestre) {
		NSMutableArray collections = new NSMutableArray();
		EOQualifier qual = new EOKeyValueQualifier(VCollectionSemestre.SCOL_GROUPE_COLLECTION_KEY + "." + ScolGroupeCollection.SCOL_GROUPE_GRPS_KEY
				+ "." + ScolGroupeGrp.SCOL_GROUPE_OBJETS_KEY + "." + ScolGroupeObjet.SCOL_MAQUETTE_AP_KEY + "."
				+ ScolMaquetteAp.SCOL_MAQUETTE_REPARTITION_APS_KEY + "." + ScolMaquetteRepartitionAp.SCOL_MAQUETTE_EC_KEY + "."
				+ ScolMaquetteEc.SCOL_MAQUETTE_REPARTITION_ECS_KEY + "." + ScolMaquetteRepartitionEc.SCOL_MAQUETTE_UE_KEY + "."
				+ ScolMaquetteUe.SCOL_MAQUETTE_REPARTITION_UES_KEY + "." + ScolMaquetteRepartitionUe.SCOL_MAQUETTE_SEMESTRE_KEY,
				EOKeyValueQualifier.QualifierOperatorEqual, semestre);
		NSArray collSemestre = DBHandler.fetchData(ec, VCollectionSemestre.ENTITY_NAME, qual);
		collections.addObjectsFromArray((NSArray) collSemestre.valueForKey(VCollectionSemestre.SCOL_GROUPE_COLLECTION_KEY));

		qual = new EOKeyValueQualifier(VCollectionSemestre.SCOL_MAQUETTE_SEMESTRE_KEY, EOKeyValueQualifier.QualifierOperatorEqual, semestre);
		collSemestre = DBHandler.fetchData(ec, VCollectionSemestre.ENTITY_NAME, qual);
		collections.addObjectsFromArray((NSArray) collSemestre.valueForKey(VCollectionSemestre.SCOL_GROUPE_COLLECTION_KEY));

		return DBHandler.retirerMultiples(collections);
	}

	public void validateForInsert() throws NSValidation.ValidationException {
		this.validateObjectMetier();
		validateBeforeTransactionSave();
		super.validateForInsert();
	}

	public void validateForUpdate() throws NSValidation.ValidationException {
		this.validateObjectMetier();
		validateBeforeTransactionSave();
		super.validateForUpdate();
	}

	public void validateForDelete() throws NSValidation.ValidationException {
		super.validateForDelete();
	}

	/**
	 * Apparemment cette methode n'est pas appelée.
	 * 
	 * @see com.webobjects.eocontrol.EOValidation#validateForUpdate()
	 */
	public void validateForSave() throws NSValidation.ValidationException {
		validateObjectMetier();
		validateBeforeTransactionSave();
		super.validateForSave();

	}

	/**
	 * Peut etre appele à partir des factories.
	 * 
	 * @throws NSValidation.ValidationException
	 */
	public void validateObjectMetier() throws NSValidation.ValidationException {

	}

	/**
	 * A appeler par les validateforsave, forinsert, forupdate.
	 * 
	 */
	private final void validateBeforeTransactionSave() throws NSValidation.ValidationException {

	}

}
