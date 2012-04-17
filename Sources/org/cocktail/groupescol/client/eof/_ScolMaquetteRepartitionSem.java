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

// DO NOT EDIT.  Make changes to ScolMaquetteRepartitionSem.java instead.
package org.cocktail.groupescol.client.eof;

import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public abstract class _ScolMaquetteRepartitionSem extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteRepartitionSem";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_REPARTITION_SEM";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mrsemKey";



	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_PARCOURS_KEY = "scolMaquetteParcours";
	public static final String SCOL_MAQUETTE_SEMESTRE_KEY = "scolMaquetteSemestre";

	// Utilities methods
	  public ScolMaquetteRepartitionSem localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteRepartitionSem localInstance = (ScolMaquetteRepartitionSem)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteRepartitionSem getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionSem.ENTITY_NAME);
		      return (ScolMaquetteRepartitionSem) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public org.cocktail.groupescol.client.eof.ScolFormationAnnee scolFormationAnnee() {
    return (org.cocktail.groupescol.client.eof.ScolFormationAnnee)storedValueForKey("scolFormationAnnee");
  }

  public void setScolFormationAnneeRelationship(org.cocktail.groupescol.client.eof.ScolFormationAnnee value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolFormationAnnee oldValue = scolFormationAnnee();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationAnnee");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationAnnee");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteParcours scolMaquetteParcours() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteParcours)storedValueForKey("scolMaquetteParcours");
  }

  public void setScolMaquetteParcoursRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteParcours value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteParcours oldValue = scolMaquetteParcours();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteParcours");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteParcours");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteSemestre scolMaquetteSemestre() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteSemestre)storedValueForKey("scolMaquetteSemestre");
  }

  public void setScolMaquetteSemestreRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteSemestre value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteSemestre oldValue = scolMaquetteSemestre();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteSemestre");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteSemestre");
    }
  }
  

  public static ScolMaquetteRepartitionSem createScolMaquetteRepartitionSem(EOEditingContext editingContext) {
    ScolMaquetteRepartitionSem eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionSem.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteRepartitionSem.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteRepartitionSem) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolMaquetteRepartitionSems(EOEditingContext editingContext) {
    return _ScolMaquetteRepartitionSem.fetchAllScolMaquetteRepartitionSems(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteRepartitionSems(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSems(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteRepartitionSems(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteRepartitionSem.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteRepartitionSem fetchScolMaquetteRepartitionSem(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionSem fetchScolMaquetteRepartitionSem(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSems(editingContext, qualifier, null);
    ScolMaquetteRepartitionSem eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteRepartitionSem)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteRepartitionSem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionSem fetchRequiredScolMaquetteRepartitionSem(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionSem.fetchRequiredScolMaquetteRepartitionSem(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionSem fetchRequiredScolMaquetteRepartitionSem(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteRepartitionSem eoObject = _ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSem(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteRepartitionSem that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionSem localInstanceIn(EOEditingContext editingContext, ScolMaquetteRepartitionSem eo) {
    ScolMaquetteRepartitionSem localInstance = (eo == null) ? null : (ScolMaquetteRepartitionSem)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
