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

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eodistribution.client.EODistributedDataSource;
import com.webobjects.eointerface.EODisplayGroup;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class DBHandler {

	public static final int PLUS_BASSE = 0;
	public static final int PLUS_HAUTE = 1;

	/** fait une selection de la derniere valeur d'une sequence */
	public static Number seqValue(String seqName, EOEditingContext eContext) {
		EOFetchSpecification myFetch = new EOFetchSpecification(seqName, null, null);
		myFetch.setUsesDistinct(true);
		NSArray retour = eContext.objectsWithFetchSpecification(myFetch);
		if (retour.count() > 0) {
			return (Number) ((EOGenericRecord) retour.objectAtIndex(0)).valueForKey("nextval");
		}
		else {
			return null;
		}
	}

	/** renvoi un qualifier construit avec l'expression et les valeurs */
	public static EOQualifier getQualifier(String expression, NSArray values) {
		return EOQualifier.qualifierWithQualifierFormat(expression, values);
	}

	/** renvoi un qualifier construit avec l'expression */
	public static EOQualifier getQualifier(String expression) {
		return EOQualifier.qualifierWithQualifierFormat(expression, null);
	}

	/**
	 * renvoi un qualifier construit avec le champs field et la valeur que l'on veut lui associer. exemple :
	 * DBHandler.getSimpleQualifier("individuUlr",eoIndividu)
	 */
	public static EOQualifier getSimpleQualifier(String field, Object value) {
		return EOQualifier.qualifierWithQualifierFormat(field + "=%@", new NSArray(value));
	}

	/** retourne les globalIDs des objets */
	public static NSArray globalIDsForObjects(EOEditingContext eContext, NSArray objects) {
		NSMutableArray gids = new NSMutableArray();
		for (int i = 0; i < objects.count(); i++) {
			gids.addObject(eContext.globalIDForObject((EOEnterpriseObject) objects.objectAtIndex(i)));
		}
		return gids;
	}

	/** retourne les globalIDs des objets */
	public static NSArray objectsForGlobalIDs(EOEditingContext eContext, NSArray ids) {
		NSMutableArray objects = new NSMutableArray();
		for (int i = 0; i < ids.count(); i++) {
			objects.addObject(eContext.objectForGlobalID((EOGlobalID) ids.objectAtIndex(i)));
		}
		return objects;
	}

	/** retourne des faults d'objets à partir des globalIDs */
	public static NSArray faultsForGlobalIDs(EOEditingContext eContext, NSArray ids) {
		NSMutableArray objects = new NSMutableArray();
		for (int i = 0; i < ids.count(); i++) {
			objects.addObject(eContext.faultForGlobalID((EOGlobalID) ids.objectAtIndex(i), eContext));
		}
		return objects;
	}

	/** invalide les objects passes en parametres dans list */
	public static void invalidateObjects(EOEditingContext ec, NSArray list) {
		NSMutableArray listGIDs = new NSMutableArray();
		for (int i = 0; i < list.count(); i++) {
			listGIDs.addObject(ec.globalIDForObject((EOEnterpriseObject) list.objectAtIndex(i)));
		}
		ec.invalidateObjectsWithGlobalIDs(listGIDs);
	}

	/** invalide l'object record passe en parametre */
	public static void invalidateObject(EOEditingContext ec, EOGenericRecord record) {
		NSArray listGIDs = new NSArray(new Object[] { ec.globalIDForObject(record) });
		ec.invalidateObjectsWithGlobalIDs(listGIDs);
	}

	/**
	 * EOEditingContext context, String tableName, String key, Object value
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext context, String tableName, String key, Object value) {
		EOQualifier qualifie = EOQualifier.qualifierWithQualifierFormat(key + "=%@", new NSArray(value));
		NSArray objets = fetchData(context, tableName, qualifie);
		if (objets.count() > 0) {
			return (EOGenericRecord) objets.objectAtIndex(0);
		}
		else {
			return null;
		}
	}

	/**
	 * EOEditingContext eContext, String tableName, EOQualifier leQualifier
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext eContext, String tableName, EOQualifier qualifier) {
		NSArray objets = fetchData(eContext, tableName, qualifier);
		if (objets.count() > 0) {
			return (EOGenericRecord) objets.objectAtIndex(0);
		}
		else {
			return null;
		}
	}

	/**
	 * EOEditingContext context String tableName String key Object value
	 */
	public static NSArray fetchData(EOEditingContext context, String tableName, String key, Object value) {
		EOQualifier qualifie = EOQualifier.qualifierWithQualifierFormat(key + "=%@", new NSArray(value));
		return fetchData(context, tableName, qualifie);
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier) {
		EOFetchSpecification myFetch = new EOFetchSpecification(leNomTable, leQualifier, null);
		myFetch.setUsesDistinct(true);
		return context.objectsWithFetchSpecification(myFetch);
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier, EOSortOrdering sort) {
		if (sort == null) {
			return fetchData(context, leNomTable, leQualifier, (NSArray) null);
		}
		else {
			return fetchData(context, leNomTable, leQualifier, new NSArray(sort));
		}
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier, NSArray sorts) {
		EOFetchSpecification myFetch;
		myFetch = new EOFetchSpecification(leNomTable, leQualifier, sorts);
		myFetch.setUsesDistinct(true);
		return context.objectsWithFetchSpecification(myFetch);
	}

	/** enleve tous les autres pointeurs d'un objet */
	public static NSMutableArray retirerMultiples(NSArray array) {
		NSMutableArray resultat = new NSMutableArray();
		for (int i = 0; i < array.count(); i++) {
			Object obj = array.objectAtIndex(i);
			if (!resultat.containsObject(obj)) {
				resultat.addObject(obj);
			}
		}
		return resultat;
	}

	public static void fetchDisplayGroup(EODisplayGroup table, EOQualifier qualifier) {
		fetchDisplayGroup(table, qualifier, null, true);
	}

	public static void fetchDisplayGroup(EODisplayGroup table, EOQualifier qualifier, EOSortOrdering sort) {
		if (sort != null) {
			fetchDisplayGroup(table, qualifier, new NSArray(sort), true);
		}
		else {
			fetchDisplayGroup(table, qualifier, null, true);
		}
	}

	public static void fetchDisplayGroup(EODisplayGroup table, EOQualifier leQualifier, NSArray leSort, boolean selectsFirst) {
		String entityName = table.dataSource().classDescriptionForObjects().entityName();
		table.setSelectsFirstObjectAfterFetch(selectsFirst);
		EOFetchSpecification leFetch = new EOFetchSpecification(entityName, leQualifier, leSort);
		leFetch.setUsesDistinct(true);
		leFetch.setRefreshesRefetchedObjects(true);
		((EODistributedDataSource) table.dataSource()).setFetchSpecification(leFetch);
		table.fetch();
		// Informer les observers du display pour qu'ils se mettent a jour
		// refreshTable(laTable);
	}

	/** purge le contenu du displayGroup passe en parametre */
	public static void flushDisplayGroup(EODisplayGroup disp) {
		disp.dataSource().editingContext().revert();
		disp.setObjectArray(new NSArray());
	}

}
