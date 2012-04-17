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

// DO NOT EDIT.  Make changes to ScolInscriptionSemestre.java instead.
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

public abstract class _ScolInscriptionSemestre extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolInscriptionSemestre";
	public static final String ENTITY_TABLE_NAME = "SCOL_INSCRIPTION_SEMESTRE";

	// Attributes



	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_INSCRIPTION_APS_KEY = "scolInscriptionAps";
	public static final String SCOL_INSCRIPTION_ETUDIANT_KEY = "scolInscriptionEtudiant";
	public static final String SCOL_INSCRIPTION_GRPS_KEY = "scolInscriptionGrps";
	public static final String SCOL_MAQUETTE_REPARTITION_SEM_KEY = "scolMaquetteRepartitionSem";

	// Utilities methods
	  public ScolInscriptionSemestre localInstanceIn(EOEditingContext editingContext) {
	    ScolInscriptionSemestre localInstance = (ScolInscriptionSemestre)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolInscriptionSemestre getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionSemestre.ENTITY_NAME);
		      return (ScolInscriptionSemestre) descriptionClass.createInstanceWithEditingContext(editingContext, null);
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
  
  public org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant scolInscriptionEtudiant() {
    return (org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant)storedValueForKey("scolInscriptionEtudiant");
  }

  public void setScolInscriptionEtudiantRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant oldValue = scolInscriptionEtudiant();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolInscriptionEtudiant");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolInscriptionEtudiant");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem scolMaquetteRepartitionSem() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem)storedValueForKey("scolMaquetteRepartitionSem");
  }

  public void setScolMaquetteRepartitionSemRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem oldValue = scolMaquetteRepartitionSem();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteRepartitionSem");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteRepartitionSem");
    }
  }
  
  public NSArray scolInscriptionAps() {
    return (NSArray)storedValueForKey("scolInscriptionAps");
  }

  public NSArray scolInscriptionAps(EOQualifier qualifier) {
    return scolInscriptionAps(qualifier, null);
  }

  public NSArray scolInscriptionAps(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = scolInscriptionAps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToScolInscriptionApsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionAp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
  }

  public void removeFromScolInscriptionApsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
  }

  public org.cocktail.groupescol.client.eof.ScolInscriptionAp createScolInscriptionApsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionAp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionAps");
    return (org.cocktail.groupescol.client.eof.ScolInscriptionAp) eo;
  }

  public void deleteScolInscriptionApsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionApsRelationships() {
    Enumeration objects = scolInscriptionAps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionApsRelationship((org.cocktail.groupescol.client.eof.ScolInscriptionAp)objects.nextElement());
    }
  }

  public NSArray scolInscriptionGrps() {
    return (NSArray)storedValueForKey("scolInscriptionGrps");
  }

  public NSArray scolInscriptionGrps(EOQualifier qualifier) {
    return scolInscriptionGrps(qualifier, null);
  }

  public NSArray scolInscriptionGrps(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = scolInscriptionGrps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public void removeFromScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public org.cocktail.groupescol.client.eof.ScolInscriptionGrp createScolInscriptionGrpsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionGrps");
    return (org.cocktail.groupescol.client.eof.ScolInscriptionGrp) eo;
  }

  public void deleteScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionGrpsRelationships() {
    Enumeration objects = scolInscriptionGrps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionGrpsRelationship((org.cocktail.groupescol.client.eof.ScolInscriptionGrp)objects.nextElement());
    }
  }


  public static ScolInscriptionSemestre createScolInscriptionSemestre(EOEditingContext editingContext) {
    ScolInscriptionSemestre eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionSemestre.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolInscriptionSemestre.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolInscriptionSemestre) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolInscriptionSemestres(EOEditingContext editingContext) {
    return _ScolInscriptionSemestre.fetchAllScolInscriptionSemestres(editingContext, null);
  }

  public static NSArray fetchAllScolInscriptionSemestres(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolInscriptionSemestre.fetchScolInscriptionSemestres(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolInscriptionSemestres(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolInscriptionSemestre.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolInscriptionSemestre fetchScolInscriptionSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionSemestre.fetchScolInscriptionSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionSemestre fetchScolInscriptionSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolInscriptionSemestre.fetchScolInscriptionSemestres(editingContext, qualifier, null);
    ScolInscriptionSemestre eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolInscriptionSemestre)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolInscriptionSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionSemestre fetchRequiredScolInscriptionSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionSemestre.fetchRequiredScolInscriptionSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionSemestre fetchRequiredScolInscriptionSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolInscriptionSemestre eoObject = _ScolInscriptionSemestre.fetchScolInscriptionSemestre(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolInscriptionSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionSemestre localInstanceIn(EOEditingContext editingContext, ScolInscriptionSemestre eo) {
    ScolInscriptionSemestre localInstance = (eo == null) ? null : (ScolInscriptionSemestre)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
