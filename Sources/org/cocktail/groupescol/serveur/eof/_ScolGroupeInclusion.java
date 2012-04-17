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

// DO NOT EDIT.  Make changes to ScolGroupeInclusion.java instead.
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

public abstract class _ScolGroupeInclusion extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolGroupeInclusion";
	public static final String ENTITY_TABLE_NAME = "SCOL_GROUPE_INCLUSION";

	// Attributes



	// Relationships
	public static final String SCOL_GROUPE_GRP_FILS_KEY = "scolGroupeGrpFils";
	public static final String SCOL_GROUPE_GRP_PERE_KEY = "scolGroupeGrpPere";

	// Utilities methods
	  public ScolGroupeInclusion localInstanceIn(EOEditingContext editingContext) {
	    ScolGroupeInclusion localInstance = (ScolGroupeInclusion)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolGroupeInclusion getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolGroupeInclusion.ENTITY_NAME);
		      return (ScolGroupeInclusion) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrpFils() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)storedValueForKey("scolGroupeGrpFils");
  }

  public void setScolGroupeGrpFilsRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeGrp oldValue = scolGroupeGrpFils();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeGrpFils");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeGrpFils");
    }
  }
  
  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrpPere() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)storedValueForKey("scolGroupeGrpPere");
  }

  public void setScolGroupeGrpPereRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeGrp oldValue = scolGroupeGrpPere();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeGrpPere");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeGrpPere");
    }
  }
  

  public static ScolGroupeInclusion createScolGroupeInclusion(EOEditingContext editingContext) {
    ScolGroupeInclusion eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolGroupeInclusion.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolGroupeInclusion.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolGroupeInclusion) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolGroupeInclusions(EOEditingContext editingContext) {
    return _ScolGroupeInclusion.fetchAllScolGroupeInclusions(editingContext, null);
  }

  public static NSArray fetchAllScolGroupeInclusions(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolGroupeInclusion.fetchScolGroupeInclusions(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolGroupeInclusions(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolGroupeInclusion.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolGroupeInclusion fetchScolGroupeInclusion(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeInclusion.fetchScolGroupeInclusion(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeInclusion fetchScolGroupeInclusion(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolGroupeInclusion.fetchScolGroupeInclusions(editingContext, qualifier, null);
    ScolGroupeInclusion eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolGroupeInclusion)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolGroupeInclusion that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeInclusion fetchRequiredScolGroupeInclusion(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeInclusion.fetchRequiredScolGroupeInclusion(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeInclusion fetchRequiredScolGroupeInclusion(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolGroupeInclusion eoObject = _ScolGroupeInclusion.fetchScolGroupeInclusion(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolGroupeInclusion that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeInclusion localInstanceIn(EOEditingContext editingContext, ScolGroupeInclusion eo) {
    ScolGroupeInclusion localInstance = (eo == null) ? null : (ScolGroupeInclusion)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
