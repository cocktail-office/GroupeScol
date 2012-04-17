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

// DO NOT EDIT.  Make changes to ScolFormationHabilitation.java instead.
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

public abstract class _ScolFormationHabilitation extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationHabilitation";
	public static final String ENTITY_TABLE_NAME = "SCOL_FORMATION_HABILITATION";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "fhabKey";

	public static final String FHAB_KEY_KEY = "fhabKey";
	public static final String FHAB_NIVEAU_KEY = "fhabNiveau";
	public static final String FHAB_OUVERT_KEY = "fhabOuvert";

	public static final String FHAB_KEY_COLKEY = "FHAB_KEY";
	public static final String FHAB_NIVEAU_COLKEY = "FHAB_NIVEAU";
	public static final String FHAB_OUVERT_COLKEY = "FHAB_OUVERT";

	// Relationships
	public static final String PREF_SCOLS_KEY = "prefScols";
	public static final String SCOL_DROIT_DIPLOMES_KEY = "scolDroitDiplomes";
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_FORMATION_SPECIALISATION_KEY = "scolFormationSpecialisation";

	// Utilities methods
	  public ScolFormationHabilitation localInstanceIn(EOEditingContext editingContext) {
	    ScolFormationHabilitation localInstance = (ScolFormationHabilitation)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolFormationHabilitation getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolFormationHabilitation.ENTITY_NAME);
		      return (ScolFormationHabilitation) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long fhabKey() {
    return (Long) storedValueForKey("fhabKey");
  }

  public void setFhabKey(Long value) {
    takeStoredValueForKey(value, "fhabKey");
  }

  public Long fhabNiveau() {
    return (Long) storedValueForKey("fhabNiveau");
  }

  public void setFhabNiveau(Long value) {
    takeStoredValueForKey(value, "fhabNiveau");
  }

  public String fhabOuvert() {
    return (String) storedValueForKey("fhabOuvert");
  }

  public void setFhabOuvert(String value) {
    takeStoredValueForKey(value, "fhabOuvert");
  }

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
  
  public org.cocktail.groupescol.client.eof.ScolFormationSpecialisation scolFormationSpecialisation() {
    return (org.cocktail.groupescol.client.eof.ScolFormationSpecialisation)storedValueForKey("scolFormationSpecialisation");
  }

  public void setScolFormationSpecialisationRelationship(org.cocktail.groupescol.client.eof.ScolFormationSpecialisation value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolFormationSpecialisation oldValue = scolFormationSpecialisation();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationSpecialisation");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationSpecialisation");
    }
  }
  
  public NSArray prefScols() {
    return (NSArray)storedValueForKey("prefScols");
  }

  public NSArray prefScols(EOQualifier qualifier) {
    return prefScols(qualifier, null);
  }

  public NSArray prefScols(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = prefScols();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToPrefScolsRelationship(org.cocktail.groupescol.client.eof.PrefScol object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "prefScols");
  }

  public void removeFromPrefScolsRelationship(org.cocktail.groupescol.client.eof.PrefScol object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "prefScols");
  }

  public org.cocktail.groupescol.client.eof.PrefScol createPrefScolsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("PrefScol");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "prefScols");
    return (org.cocktail.groupescol.client.eof.PrefScol) eo;
  }

  public void deletePrefScolsRelationship(org.cocktail.groupescol.client.eof.PrefScol object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "prefScols");
    editingContext().deleteObject(object);
  }

  public void deleteAllPrefScolsRelationships() {
    Enumeration objects = prefScols().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePrefScolsRelationship((org.cocktail.groupescol.client.eof.PrefScol)objects.nextElement());
    }
  }

  public NSArray scolDroitDiplomes() {
    return (NSArray)storedValueForKey("scolDroitDiplomes");
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier) {
    return scolDroitDiplomes(qualifier, null, false);
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier, boolean fetch) {
    return scolDroitDiplomes(qualifier, null, fetch);
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolDroitDiplome.SCOL_FORMATION_HABILITATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolDroitDiplome.fetchScolDroitDiplomes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolDroitDiplomes();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
  }

  public void removeFromScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
  }

  public org.cocktail.groupescol.client.eof.ScolDroitDiplome createScolDroitDiplomesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolDroitDiplome");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolDroitDiplomes");
    return (org.cocktail.groupescol.client.eof.ScolDroitDiplome) eo;
  }

  public void deleteScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolDroitDiplomesRelationships() {
    Enumeration objects = scolDroitDiplomes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolDroitDiplomesRelationship((org.cocktail.groupescol.client.eof.ScolDroitDiplome)objects.nextElement());
    }
  }


  public static ScolFormationHabilitation createScolFormationHabilitation(EOEditingContext editingContext, Long fhabKey
, Long fhabNiveau
, String fhabOuvert
) {
    ScolFormationHabilitation eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolFormationHabilitation.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolFormationHabilitation.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolFormationHabilitation) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setFhabKey(fhabKey);
		eo.setFhabNiveau(fhabNiveau);
		eo.setFhabOuvert(fhabOuvert);
    return eo;
  }

  public static NSArray fetchAllScolFormationHabilitations(EOEditingContext editingContext) {
    return _ScolFormationHabilitation.fetchAllScolFormationHabilitations(editingContext, null);
  }

  public static NSArray fetchAllScolFormationHabilitations(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolFormationHabilitation.fetchScolFormationHabilitations(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolFormationHabilitations(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolFormationHabilitation.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolFormationHabilitation fetchScolFormationHabilitation(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationHabilitation.fetchScolFormationHabilitation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationHabilitation fetchScolFormationHabilitation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolFormationHabilitation.fetchScolFormationHabilitations(editingContext, qualifier, null);
    ScolFormationHabilitation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolFormationHabilitation)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationHabilitation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationHabilitation fetchRequiredScolFormationHabilitation(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationHabilitation.fetchRequiredScolFormationHabilitation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationHabilitation fetchRequiredScolFormationHabilitation(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolFormationHabilitation eoObject = _ScolFormationHabilitation.fetchScolFormationHabilitation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationHabilitation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationHabilitation localInstanceIn(EOEditingContext editingContext, ScolFormationHabilitation eo) {
    ScolFormationHabilitation localInstance = (eo == null) ? null : (ScolFormationHabilitation)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
