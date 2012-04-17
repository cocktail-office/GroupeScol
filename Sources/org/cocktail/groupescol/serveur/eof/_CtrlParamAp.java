/*
 * Copyright COCKTAIL (www.cocktail.org), 1995, 2012 This software
 * is governed by the CeCILL license under French law and abiding by the
 * rules of distribution of free software. You can use, modify and/or
 * redistribute the software under the terms of the CeCILL license as
 * circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * As a counterpart to the access to the source code and rights to copy, modify
 * and redistribute granted by the license, users are provided only with a
 * limited warranty and the software's author, the holder of the economic
 * rights, and the successive licensors have only limited liability. In this
 * respect, the user's attention is drawn to the risks associated with loading,
 * using, modifying and/or developing or reproducing the software by the user
 * in light of its specific status of free software, that may mean that it
 * is complicated to manipulate, and that also therefore means that it is
 * reserved for developers and experienced professionals having in-depth
 * computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling
 * the security of their systems and/or data to be ensured and, more generally,
 * to use and operate it in the same conditions as regards security. The
 * fact that you are presently reading this means that you have had knowledge
 * of the CeCILL license and that you accept its terms.
 */

// DO NOT EDIT.  Make changes to CtrlParamAp.java instead.
package org.cocktail.groupescol.serveur.eof;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public abstract class _CtrlParamAp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "CtrlParamAp";
	public static final String ENTITY_TABLE_NAME = "EDTSCOL.CTRL_PARAM_AP";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "cpaKey";



	// Relationships
	public static final String CTRL_PARAM_AP_INDIVIDUS_KEY = "ctrlParamApIndividus";
	public static final String CTRL_PARAM_AP_OBJETS_KEY = "ctrlParamApObjets";
	public static final String CTRL_PARAM_AP_SALLE_CHOIXS_KEY = "ctrlParamApSalleChoixs";
	public static final String CTRL_PARAM_AP_SALLES_KEY = "ctrlParamApSalles";

	// Utilities methods
	  public CtrlParamAp localInstanceIn(EOEditingContext editingContext) {
	    CtrlParamAp localInstance = (CtrlParamAp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static CtrlParamAp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_CtrlParamAp.ENTITY_NAME);
		      return (CtrlParamAp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public NSArray ctrlParamApIndividus() {
    return (NSArray)storedValueForKey("ctrlParamApIndividus");
  }

  public NSArray ctrlParamApIndividus(EOQualifier qualifier) {
    return ctrlParamApIndividus(qualifier, null);
  }

  public NSArray ctrlParamApIndividus(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = ctrlParamApIndividus();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToCtrlParamApIndividusRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "ctrlParamApIndividus");
  }

  public void removeFromCtrlParamApIndividusRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApIndividus");
  }

  public org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu createCtrlParamApIndividusRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("CtrlParamApIndividu");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "ctrlParamApIndividus");
    return (org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu) eo;
  }

  public void deleteCtrlParamApIndividusRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApIndividus");
    editingContext().deleteObject(object);
  }

  public void deleteAllCtrlParamApIndividusRelationships() {
    Enumeration objects = ctrlParamApIndividus().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCtrlParamApIndividusRelationship((org.cocktail.groupescol.serveur.eof.CtrlParamApIndividu)objects.nextElement());
    }
  }

  public NSArray ctrlParamApObjets() {
    return (NSArray)storedValueForKey("ctrlParamApObjets");
  }

  public NSArray ctrlParamApObjets(EOQualifier qualifier) {
    return ctrlParamApObjets(qualifier, null);
  }

  public NSArray ctrlParamApObjets(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = ctrlParamApObjets();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToCtrlParamApObjetsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApObjet object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "ctrlParamApObjets");
  }

  public void removeFromCtrlParamApObjetsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApObjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApObjets");
  }

  public org.cocktail.groupescol.serveur.eof.CtrlParamApObjet createCtrlParamApObjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("CtrlParamApObjet");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "ctrlParamApObjets");
    return (org.cocktail.groupescol.serveur.eof.CtrlParamApObjet) eo;
  }

  public void deleteCtrlParamApObjetsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApObjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApObjets");
    editingContext().deleteObject(object);
  }

  public void deleteAllCtrlParamApObjetsRelationships() {
    Enumeration objects = ctrlParamApObjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCtrlParamApObjetsRelationship((org.cocktail.groupescol.serveur.eof.CtrlParamApObjet)objects.nextElement());
    }
  }

  public NSArray ctrlParamApSalleChoixs() {
    return (NSArray)storedValueForKey("ctrlParamApSalleChoixs");
  }

  public NSArray ctrlParamApSalleChoixs(EOQualifier qualifier) {
    return ctrlParamApSalleChoixs(qualifier, null);
  }

  public NSArray ctrlParamApSalleChoixs(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = ctrlParamApSalleChoixs();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToCtrlParamApSalleChoixsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "ctrlParamApSalleChoixs");
  }

  public void removeFromCtrlParamApSalleChoixsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApSalleChoixs");
  }

  public org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix createCtrlParamApSalleChoixsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("CtrlParamApSalleChoix");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "ctrlParamApSalleChoixs");
    return (org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix) eo;
  }

  public void deleteCtrlParamApSalleChoixsRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApSalleChoixs");
    editingContext().deleteObject(object);
  }

  public void deleteAllCtrlParamApSalleChoixsRelationships() {
    Enumeration objects = ctrlParamApSalleChoixs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCtrlParamApSalleChoixsRelationship((org.cocktail.groupescol.serveur.eof.CtrlParamApSalleChoix)objects.nextElement());
    }
  }

  public NSArray ctrlParamApSalles() {
    return (NSArray)storedValueForKey("ctrlParamApSalles");
  }

  public NSArray ctrlParamApSalles(EOQualifier qualifier) {
    return ctrlParamApSalles(qualifier, null);
  }

  public NSArray ctrlParamApSalles(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = ctrlParamApSalles();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToCtrlParamApSallesRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalle object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "ctrlParamApSalles");
  }

  public void removeFromCtrlParamApSallesRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalle object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApSalles");
  }

  public org.cocktail.groupescol.serveur.eof.CtrlParamApSalle createCtrlParamApSallesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("CtrlParamApSalle");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "ctrlParamApSalles");
    return (org.cocktail.groupescol.serveur.eof.CtrlParamApSalle) eo;
  }

  public void deleteCtrlParamApSallesRelationship(org.cocktail.groupescol.serveur.eof.CtrlParamApSalle object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamApSalles");
    editingContext().deleteObject(object);
  }

  public void deleteAllCtrlParamApSallesRelationships() {
    Enumeration objects = ctrlParamApSalles().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCtrlParamApSallesRelationship((org.cocktail.groupescol.serveur.eof.CtrlParamApSalle)objects.nextElement());
    }
  }


  public static CtrlParamAp createCtrlParamAp(EOEditingContext editingContext) {
    CtrlParamAp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_CtrlParamAp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _CtrlParamAp.ENTITY_NAME + "' !");
    } else
    {
        eo = (CtrlParamAp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllCtrlParamAps(EOEditingContext editingContext) {
    return _CtrlParamAp.fetchAllCtrlParamAps(editingContext, null);
  }

  public static NSArray fetchAllCtrlParamAps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _CtrlParamAp.fetchCtrlParamAps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchCtrlParamAps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_CtrlParamAp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static CtrlParamAp fetchCtrlParamAp(EOEditingContext editingContext, String keyName, Object value) {
    return _CtrlParamAp.fetchCtrlParamAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CtrlParamAp fetchCtrlParamAp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _CtrlParamAp.fetchCtrlParamAps(editingContext, qualifier, null);
    CtrlParamAp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (CtrlParamAp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one CtrlParamAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CtrlParamAp fetchRequiredCtrlParamAp(EOEditingContext editingContext, String keyName, Object value) {
    return _CtrlParamAp.fetchRequiredCtrlParamAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CtrlParamAp fetchRequiredCtrlParamAp(EOEditingContext editingContext, EOQualifier qualifier) {
    CtrlParamAp eoObject = _CtrlParamAp.fetchCtrlParamAp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no CtrlParamAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CtrlParamAp localInstanceIn(EOEditingContext editingContext, CtrlParamAp eo) {
    CtrlParamAp localInstance = (eo == null) ? null : (CtrlParamAp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
