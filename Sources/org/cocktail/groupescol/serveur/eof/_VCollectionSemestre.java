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

// DO NOT EDIT.  Make changes to VCollectionSemestre.java instead.
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

public abstract class _VCollectionSemestre extends  EOGenericRecord {
	public static final String ENTITY_NAME = "VCollectionSemestre";
	public static final String ENTITY_TABLE_NAME = "EDTSCOL.V_COLLECTION_SEMESTRE";

	// Attributes

	public static final String FANN_KEY_KEY = "fannKey";

	public static final String FANN_KEY_COLKEY = "FANN_KEY";

	// Relationships
	public static final String SCOL_GROUPE_COLLECTION_KEY = "scolGroupeCollection";
	public static final String SCOL_MAQUETTE_SEMESTRE_KEY = "scolMaquetteSemestre";

	// Utilities methods
	  public VCollectionSemestre localInstanceIn(EOEditingContext editingContext) {
	    VCollectionSemestre localInstance = (VCollectionSemestre)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static VCollectionSemestre getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_VCollectionSemestre.ENTITY_NAME);
		      return (VCollectionSemestre) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    takeStoredValueForKey(value, "fannKey");
  }

  public org.cocktail.groupescol.serveur.eof.ScolGroupeCollection scolGroupeCollection() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeCollection)storedValueForKey("scolGroupeCollection");
  }

  public void setScolGroupeCollectionRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeCollection value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeCollection oldValue = scolGroupeCollection();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeCollection");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeCollection");
    }
  }
  
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre scolMaquetteSemestre() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre)storedValueForKey("scolMaquetteSemestre");
  }

  public void setScolMaquetteSemestreRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre oldValue = scolMaquetteSemestre();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteSemestre");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteSemestre");
    }
  }
  

  public static VCollectionSemestre createVCollectionSemestre(EOEditingContext editingContext, Long fannKey
) {
    VCollectionSemestre eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_VCollectionSemestre.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _VCollectionSemestre.ENTITY_NAME + "' !");
    } else
    {
        eo = (VCollectionSemestre) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setFannKey(fannKey);
    return eo;
  }

  public static NSArray fetchAllVCollectionSemestres(EOEditingContext editingContext) {
    return _VCollectionSemestre.fetchAllVCollectionSemestres(editingContext, null);
  }

  public static NSArray fetchAllVCollectionSemestres(EOEditingContext editingContext, NSArray sortOrderings) {
    return _VCollectionSemestre.fetchVCollectionSemestres(editingContext, null, sortOrderings);
  }

  public static NSArray fetchVCollectionSemestres(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_VCollectionSemestre.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static VCollectionSemestre fetchVCollectionSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _VCollectionSemestre.fetchVCollectionSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VCollectionSemestre fetchVCollectionSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _VCollectionSemestre.fetchVCollectionSemestres(editingContext, qualifier, null);
    VCollectionSemestre eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (VCollectionSemestre)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one VCollectionSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VCollectionSemestre fetchRequiredVCollectionSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _VCollectionSemestre.fetchRequiredVCollectionSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static VCollectionSemestre fetchRequiredVCollectionSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    VCollectionSemestre eoObject = _VCollectionSemestre.fetchVCollectionSemestre(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no VCollectionSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static VCollectionSemestre localInstanceIn(EOEditingContext editingContext, VCollectionSemestre eo) {
    VCollectionSemestre localInstance = (eo == null) ? null : (VCollectionSemestre)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
