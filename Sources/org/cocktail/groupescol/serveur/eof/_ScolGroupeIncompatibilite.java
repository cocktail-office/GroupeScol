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

// DO NOT EDIT.  Make changes to ScolGroupeIncompatibilite.java instead.
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

public abstract class _ScolGroupeIncompatibilite extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolGroupeIncompatibilite";
	public static final String ENTITY_TABLE_NAME = "SCOL_GROUPE_INCOMPATIBILITE";

	// Attributes



	// Relationships
	public static final String SCOL_GROUPE_GRP1_KEY = "scolGroupeGrp1";
	public static final String SCOL_GROUPE_GRP2_KEY = "scolGroupeGrp2";

	// Utilities methods
	  public ScolGroupeIncompatibilite localInstanceIn(EOEditingContext editingContext) {
	    ScolGroupeIncompatibilite localInstance = (ScolGroupeIncompatibilite)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolGroupeIncompatibilite getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolGroupeIncompatibilite.ENTITY_NAME);
		      return (ScolGroupeIncompatibilite) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrp1() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)storedValueForKey("scolGroupeGrp1");
  }

  public void setScolGroupeGrp1Relationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeGrp oldValue = scolGroupeGrp1();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeGrp1");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeGrp1");
    }
  }
  
  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrp2() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)storedValueForKey("scolGroupeGrp2");
  }

  public void setScolGroupeGrp2Relationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeGrp oldValue = scolGroupeGrp2();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeGrp2");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeGrp2");
    }
  }
  

  public static ScolGroupeIncompatibilite createScolGroupeIncompatibilite(EOEditingContext editingContext) {
    ScolGroupeIncompatibilite eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolGroupeIncompatibilite.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolGroupeIncompatibilite.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolGroupeIncompatibilite) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolGroupeIncompatibilites(EOEditingContext editingContext) {
    return _ScolGroupeIncompatibilite.fetchAllScolGroupeIncompatibilites(editingContext, null);
  }

  public static NSArray fetchAllScolGroupeIncompatibilites(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilites(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolGroupeIncompatibilites(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolGroupeIncompatibilite.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolGroupeIncompatibilite fetchScolGroupeIncompatibilite(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeIncompatibilite fetchScolGroupeIncompatibilite(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilites(editingContext, qualifier, null);
    ScolGroupeIncompatibilite eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolGroupeIncompatibilite)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolGroupeIncompatibilite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeIncompatibilite fetchRequiredScolGroupeIncompatibilite(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeIncompatibilite.fetchRequiredScolGroupeIncompatibilite(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeIncompatibilite fetchRequiredScolGroupeIncompatibilite(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolGroupeIncompatibilite eoObject = _ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilite(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolGroupeIncompatibilite that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeIncompatibilite localInstanceIn(EOEditingContext editingContext, ScolGroupeIncompatibilite eo) {
    ScolGroupeIncompatibilite localInstance = (eo == null) ? null : (ScolGroupeIncompatibilite)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
