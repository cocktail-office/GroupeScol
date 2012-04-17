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

// DO NOT EDIT.  Make changes to VSemestreAp.java instead.
package org.cocktail.groupescol.client.eof;

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

public abstract class _VSemestreAp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "VSemestreAp";
	public static final String ENTITY_TABLE_NAME = "EDTSCOL.V_SEMESTRE_AP";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mapKey";

	public static final String FANN_KEY_KEY = "fannKey";

	public static final String FANN_KEY_COLKEY = "FANN_KEY";

	// Relationships
	public static final String AP_KEY = "ap";
	public static final String EC_LIBRE_KEY = "ecLibre";
	public static final String REPARTITION_EC_KEY = "repartitionEc";
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";
	public static final String SEMESTRE_KEY = "semestre";

	// Utilities methods
	  public VSemestreAp localInstanceIn(EOEditingContext editingContext) {
	    VSemestreAp localInstance = (VSemestreAp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static VSemestreAp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_VSemestreAp.ENTITY_NAME);
		      return (VSemestreAp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    takeStoredValueForKey(value, "fannKey");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteAp ap() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteAp)storedValueForKey("ap");
  }

  public void setApRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteAp value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteAp oldValue = ap();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "ap");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "ap");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteEcLibre ecLibre() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteEcLibre)storedValueForKey("ecLibre");
  }

  public void setEcLibreRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteEcLibre value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteEcLibre oldValue = ecLibre();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "ecLibre");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "ecLibre");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteEc scolMaquetteEc() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteEc)storedValueForKey("scolMaquetteEc");
  }

  public void setScolMaquetteEcRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteEc value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteEc oldValue = scolMaquetteEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteEc");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteSemestre semestre() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteSemestre)storedValueForKey("semestre");
  }

  public void setSemestreRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteSemestre value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteSemestre oldValue = semestre();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "semestre");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "semestre");
    }
  }
  
  public NSArray repartitionEc() {
    return (NSArray)storedValueForKey("repartitionEc");
  }

  public NSArray repartitionEc(EOQualifier qualifier) {
    return repartitionEc(qualifier, null);
  }

  public NSArray repartitionEc(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = repartitionEc();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToRepartitionEcRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "repartitionEc");
  }

  public void removeFromRepartitionEcRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "repartitionEc");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc createRepartitionEcRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "repartitionEc");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc) eo;
  }

  public void deleteRepartitionEcRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "repartitionEc");
    editingContext().deleteObject(object);
  }

  public void deleteAllRepartitionEcRelationships() {
    Enumeration objects = repartitionEc().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRepartitionEcRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc)objects.nextElement());
    }
  }


  public static VSemestreAp createVSemestreAp(EOEditingContext editingContext, Long fannKey
) {
    VSemestreAp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_VSemestreAp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _VSemestreAp.ENTITY_NAME + "' !");
    } else
    {
        eo = (VSemestreAp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setFannKey(fannKey);
    return eo;
  }

  public static NSArray fetchAllVSemestreAps(EOEditingContext editingContext) {
    return _VSemestreAp.fetchAllVSemestreAps(editingContext, null);
  }

  public static NSArray fetchAllVSemestreAps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _VSemestreAp.fetchVSemestreAps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchVSemestreAps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_VSemestreAp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static VSemestreAp fetchVSemestreAp(EOEditingContext editingContext, String keyName, Object value) {
    return _VSemestreAp.fetchVSemestreAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VSemestreAp fetchVSemestreAp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _VSemestreAp.fetchVSemestreAps(editingContext, qualifier, null);
    VSemestreAp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (VSemestreAp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one VSemestreAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VSemestreAp fetchRequiredVSemestreAp(EOEditingContext editingContext, String keyName, Object value) {
    return _VSemestreAp.fetchRequiredVSemestreAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VSemestreAp fetchRequiredVSemestreAp(EOEditingContext editingContext, EOQualifier qualifier) {
    VSemestreAp eoObject = _VSemestreAp.fetchVSemestreAp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no VSemestreAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VSemestreAp localInstanceIn(EOEditingContext editingContext, VSemestreAp eo) {
    VSemestreAp localInstance = (eo == null) ? null : (VSemestreAp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
