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
package org.cocktail.groupescol.serveur;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class DBHandler {

	/** fait une selection de la derniere valeur d'une sequence */
	public static Number seqValue(String seqName, EOEditingContext eContext) {
		EOFetchSpecification myFetch = new EOFetchSpecification(seqName, null, null);
		myFetch.setUsesDistinct(true);
		NSArray retour = eContext.objectsWithFetchSpecification(myFetch);
		if (retour.count() > 0)
			return (Number) ((EOGenericRecord) retour.objectAtIndex(0)).valueForKey("nextval");
		else
			return null;
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

	/**
	 * EOEditingContext context String tableName String key Object value
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext context, String tableName, String key, Object value) {
		EOQualifier qualifie = EOQualifier.qualifierWithQualifierFormat(key + "=%@", new NSArray(value));
		NSArray objets = fetchData(context, tableName, qualifie);
		if (objets.count() > 0)
			return (EOGenericRecord) objets.objectAtIndex(0);
		else
			return null;
	}

	/**
	 * EOEditingContext eContext, String tableName, EOQualifier leQualifier
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext eContext, String tableName, EOQualifier qualifier) {
		NSArray objets = fetchData(eContext, tableName, qualifier);
		if (objets.count() > 0)
			return (EOGenericRecord) objets.objectAtIndex(0);
		else
			return null;
	}

	/** fetch avec une chaine et une valeur correspondante */
	public static NSArray fetchData(EOEditingContext context, String tableName, String key, Object value) {
		EOQualifier qualifie = EOQualifier.qualifierWithQualifierFormat(key + "=%@", new NSArray(value));
		return fetchData(context, tableName, qualifie);
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier) {
		EOFetchSpecification myFetch = new EOFetchSpecification(leNomTable, leQualifier, null);
		myFetch.setUsesDistinct(true);
		return context.objectsWithFetchSpecification(myFetch);
	}

	/** retourne les globalIDs des objets */
	public static NSArray globalIDsForObjects(EOEditingContext eContext, NSArray objects) {
		NSMutableArray gids = new NSMutableArray();
		for (int i = 0; i < objects.count(); i++)
			gids.addObject(eContext.globalIDForObject((EOEnterpriseObject) objects.objectAtIndex(i)));
		return gids;
	}

	/** retourne les globalIDs des objets */
	public static NSArray objectsForGlobalIDs(EOEditingContext eContext, NSArray ids) {
		NSMutableArray objects = new NSMutableArray();
		for (int i = 0; i < ids.count(); i++)
			objects.addObject(eContext.objectForGlobalID((EOGlobalID) ids.objectAtIndex(i)));
		return objects;
	}

	/** retourne les fauls a partir des globalIDs des objets */
	public static NSArray faultsForGlobalIDs(EOEditingContext eContext, NSArray ids) {
		NSMutableArray objects = new NSMutableArray();
		for (int i = 0; i < ids.count(); i++)
			objects.addObject(eContext.faultForGlobalID((EOGlobalID) ids.objectAtIndex(i), eContext));
		return objects;
	}

	/** obtenir la valeur de la cle primaire a partir d'un Object quand celle-ci est cachee */
	public static Object primaryKeyForObject(EOEditingContext eContext, EOEnterpriseObject record, String primaryKeyName) {
		try {
			return EOUtilities.primaryKeyForObject(eContext, record).objectForKey(primaryKeyName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** cree une instance de l'enregistrement d'entite entity et avec l'editingContext eContext */
	public static EOGenericRecord getInstance(EOEditingContext eContext, String entity) {
		EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(entity);
		EOGenericRecord instance = (EOGenericRecord) descriptionClass.createInstanceWithEditingContext(eContext, null);
		eContext.insertObject(instance);
		return instance;
	}

	// / TEMPORAIRE
	public static String stackTraceToString(Throwable e, boolean useHtml) {
		String tagCR = "\n";
		if (useHtml)
			tagCR = "<br>";
		String stackStr = e.getMessage() + tagCR + tagCR;
		StackTraceElement[] stack = e.getStackTrace();
		for (int i = 0; i < stack.length; i++)
			stackStr += ((StackTraceElement) stack[i]).toString() + tagCR;
		return stackStr;
	}

	/**
	 * envoi de la trace d'une exception ‡ une personne
	 * 
	 * @param mailBus
	 * @param appName
	 * @param e
	 * @param from
	 * @param to
	 * @return
	 */
	/*
	 * public static boolean sendExceptionTrace(CRIMailBus mailBus, String appName, String from, String to, String startText, Throwable e) {
	 * return mailBus.sendMail( from, to, null, "Exception survenue dans l'application " + appName, startText +
	 * "\n\nTrace de l'exception : \n\n" + stackTraceToString(e, false) ); }
	 */

}
