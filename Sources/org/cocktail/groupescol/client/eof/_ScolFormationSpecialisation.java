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

// DO NOT EDIT.  Make changes to ScolFormationSpecialisation.java instead.
package org.cocktail.groupescol.client.eof;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public abstract class _ScolFormationSpecialisation extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationSpecialisation";
	public static final String ENTITY_TABLE_NAME = "SCOL_FORMATION_SPECIALISATION";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "fspnKey";

	public static final String FSPN_ABREVIATION_KEY = "fspnAbreviation";
	public static final String FSPN_LIBELLE_KEY = "fspnLibelle";

	public static final String FSPN_ABREVIATION_COLKEY = "FSPN_ABREVIATION";
	public static final String FSPN_LIBELLE_COLKEY = "FSPN_LIBELLE";

	// Relationships
	public static final String SCOL_FORMATION_DIPLOME_KEY = "scolFormationDiplome";
	public static final String SCOL_FORMATION_HABILITATIONS_KEY = "scolFormationHabilitations";
	public static final String SCOL_MAQUETTE_PARCOURS_KEY = "scolMaquetteParcours";

	// Utilities methods
	  public ScolFormationSpecialisation localInstanceIn(EOEditingContext editingContext) {
	    ScolFormationSpecialisation localInstance = (ScolFormationSpecialisation)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolFormationSpecialisation getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolFormationSpecialisation.ENTITY_NAME);
		      return (ScolFormationSpecialisation) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String fspnAbreviation() {
    return (String) storedValueForKey("fspnAbreviation");
  }

  public void setFspnAbreviation(String value) {
    takeStoredValueForKey(value, "fspnAbreviation");
  }

  public String fspnLibelle() {
    return (String) storedValueForKey("fspnLibelle");
  }

  public void setFspnLibelle(String value) {
    takeStoredValueForKey(value, "fspnLibelle");
  }

  public org.cocktail.groupescol.client.eof.ScolFormationDiplome scolFormationDiplome() {
    return (org.cocktail.groupescol.client.eof.ScolFormationDiplome)storedValueForKey("scolFormationDiplome");
  }

  public void setScolFormationDiplomeRelationship(org.cocktail.groupescol.client.eof.ScolFormationDiplome value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolFormationDiplome oldValue = scolFormationDiplome();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationDiplome");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationDiplome");
    }
  }
  
  public NSArray scolFormationHabilitations() {
    return (NSArray)storedValueForKey("scolFormationHabilitations");
  }

  public NSArray scolFormationHabilitations(EOQualifier qualifier) {
    return scolFormationHabilitations(qualifier, null, false);
  }

  public NSArray scolFormationHabilitations(EOQualifier qualifier, boolean fetch) {
    return scolFormationHabilitations(qualifier, null, fetch);
  }

  public NSArray scolFormationHabilitations(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolFormationHabilitation.SCOL_FORMATION_SPECIALISATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolFormationHabilitation.fetchScolFormationHabilitations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolFormationHabilitations();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolFormationHabilitationsRelationship(org.cocktail.groupescol.client.eof.ScolFormationHabilitation object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolFormationHabilitations");
  }

  public void removeFromScolFormationHabilitationsRelationship(org.cocktail.groupescol.client.eof.ScolFormationHabilitation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolFormationHabilitations");
  }

  public org.cocktail.groupescol.client.eof.ScolFormationHabilitation createScolFormationHabilitationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolFormationHabilitation");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolFormationHabilitations");
    return (org.cocktail.groupescol.client.eof.ScolFormationHabilitation) eo;
  }

  public void deleteScolFormationHabilitationsRelationship(org.cocktail.groupescol.client.eof.ScolFormationHabilitation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolFormationHabilitations");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolFormationHabilitationsRelationships() {
    Enumeration objects = scolFormationHabilitations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolFormationHabilitationsRelationship((org.cocktail.groupescol.client.eof.ScolFormationHabilitation)objects.nextElement());
    }
  }

  public NSArray scolMaquetteParcours() {
    return (NSArray)storedValueForKey("scolMaquetteParcours");
  }

  public NSArray scolMaquetteParcours(EOQualifier qualifier) {
    return scolMaquetteParcours(qualifier, null, false);
  }

  public NSArray scolMaquetteParcours(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteParcours(qualifier, null, fetch);
  }

  public NSArray scolMaquetteParcours(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteParcours.SCOL_FORMATION_SPECIALISATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolMaquetteParcours.fetchScolMaquetteParcourses(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteParcours();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteParcoursRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteParcours object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteParcours");
  }

  public void removeFromScolMaquetteParcoursRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteParcours object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteParcours");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteParcours createScolMaquetteParcoursRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteParcours");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteParcours");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteParcours) eo;
  }

  public void deleteScolMaquetteParcoursRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteParcours object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteParcours");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteParcoursRelationships() {
    Enumeration objects = scolMaquetteParcours().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteParcoursRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteParcours)objects.nextElement());
    }
  }


  public static ScolFormationSpecialisation createScolFormationSpecialisation(EOEditingContext editingContext) {
    ScolFormationSpecialisation eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolFormationSpecialisation.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolFormationSpecialisation.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolFormationSpecialisation) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolFormationSpecialisations(EOEditingContext editingContext) {
    return _ScolFormationSpecialisation.fetchAllScolFormationSpecialisations(editingContext, null);
  }

  public static NSArray fetchAllScolFormationSpecialisations(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolFormationSpecialisation.fetchScolFormationSpecialisations(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolFormationSpecialisations(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolFormationSpecialisation.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolFormationSpecialisation fetchScolFormationSpecialisation(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationSpecialisation.fetchScolFormationSpecialisation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationSpecialisation fetchScolFormationSpecialisation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolFormationSpecialisation.fetchScolFormationSpecialisations(editingContext, qualifier, null);
    ScolFormationSpecialisation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolFormationSpecialisation)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationSpecialisation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationSpecialisation fetchRequiredScolFormationSpecialisation(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationSpecialisation.fetchRequiredScolFormationSpecialisation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationSpecialisation fetchRequiredScolFormationSpecialisation(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolFormationSpecialisation eoObject = _ScolFormationSpecialisation.fetchScolFormationSpecialisation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationSpecialisation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationSpecialisation localInstanceIn(EOEditingContext editingContext, ScolFormationSpecialisation eo) {
    ScolFormationSpecialisation localInstance = (eo == null) ? null : (ScolFormationSpecialisation)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
