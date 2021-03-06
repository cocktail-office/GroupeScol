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

// DO NOT EDIT.  Make changes to VScolMaquetteApEc.java instead.
package org.cocktail.groupescol.serveur.eof;

import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public abstract class _VScolMaquetteApEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "VScolMaquetteApEc";
	public static final String ENTITY_TABLE_NAME = "edtscol.v_scol_maquette_ap_ec";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mapKey";



	// Relationships
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";

	// Utilities methods
	  public VScolMaquetteApEc localInstanceIn(EOEditingContext editingContext) {
	    VScolMaquetteApEc localInstance = (VScolMaquetteApEc)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static VScolMaquetteApEc getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_VScolMaquetteApEc.ENTITY_NAME);
		      return (VScolMaquetteApEc) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteEc scolMaquetteEc() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteEc)storedValueForKey("scolMaquetteEc");
  }

  public void setScolMaquetteEcRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteEc value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteEc oldValue = scolMaquetteEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteEc");
    }
  }
  

  public static VScolMaquetteApEc createVScolMaquetteApEc(EOEditingContext editingContext, org.cocktail.groupescol.serveur.eof.ScolMaquetteEc scolMaquetteEc) {
    VScolMaquetteApEc eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_VScolMaquetteApEc.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _VScolMaquetteApEc.ENTITY_NAME + "' !");
    } else
    {
        eo = (VScolMaquetteApEc) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    eo.setScolMaquetteEcRelationship(scolMaquetteEc);
    return eo;
  }

  public static NSArray fetchAllVScolMaquetteApEcs(EOEditingContext editingContext) {
    return _VScolMaquetteApEc.fetchAllVScolMaquetteApEcs(editingContext, null);
  }

  public static NSArray fetchAllVScolMaquetteApEcs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _VScolMaquetteApEc.fetchVScolMaquetteApEcs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchVScolMaquetteApEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_VScolMaquetteApEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static VScolMaquetteApEc fetchVScolMaquetteApEc(EOEditingContext editingContext, String keyName, Object value) {
    return _VScolMaquetteApEc.fetchVScolMaquetteApEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VScolMaquetteApEc fetchVScolMaquetteApEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _VScolMaquetteApEc.fetchVScolMaquetteApEcs(editingContext, qualifier, null);
    VScolMaquetteApEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (VScolMaquetteApEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one VScolMaquetteApEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VScolMaquetteApEc fetchRequiredVScolMaquetteApEc(EOEditingContext editingContext, String keyName, Object value) {
    return _VScolMaquetteApEc.fetchRequiredVScolMaquetteApEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VScolMaquetteApEc fetchRequiredVScolMaquetteApEc(EOEditingContext editingContext, EOQualifier qualifier) {
    VScolMaquetteApEc eoObject = _VScolMaquetteApEc.fetchVScolMaquetteApEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no VScolMaquetteApEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VScolMaquetteApEc localInstanceIn(EOEditingContext editingContext, VScolMaquetteApEc eo) {
    VScolMaquetteApEc localInstance = (eo == null) ? null : (VScolMaquetteApEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
