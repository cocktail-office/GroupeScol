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

// DO NOT EDIT.  Make changes to ScolMaquetteRepartitionAp.java instead.
package org.cocktail.groupescol.serveur.eof;

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

public abstract class _ScolMaquetteRepartitionAp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteRepartitionAp";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_REPARTITION_AP";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mrapKey";

	public static final String MRAP_MAJEUR_KEY = "mrapMajeur";
	public static final String MRAP_SEMESTRE_KEY = "mrapSemestre";

	public static final String MRAP_MAJEUR_COLKEY = "MRAP_MAJEUR";
	public static final String MRAP_SEMESTRE_COLKEY = "MRAP_SEMESTRE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_INSCRIPTION_APS_KEY = "scolInscriptionAps";
	public static final String SCOL_MAQUETTE_AP_KEY = "scolMaquetteAp";
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";

	// Utilities methods
	  public ScolMaquetteRepartitionAp localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteRepartitionAp localInstance = (ScolMaquetteRepartitionAp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteRepartitionAp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionAp.ENTITY_NAME);
		      return (ScolMaquetteRepartitionAp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String mrapMajeur() {
    return (String) storedValueForKey("mrapMajeur");
  }

  public void setMrapMajeur(String value) {
    takeStoredValueForKey(value, "mrapMajeur");
  }

  public Long mrapSemestre() {
    return (Long) storedValueForKey("mrapSemestre");
  }

  public void setMrapSemestre(Long value) {
    takeStoredValueForKey(value, "mrapSemestre");
  }

  public org.cocktail.groupescol.serveur.eof.ScolFormationAnnee scolFormationAnnee() {
    return (org.cocktail.groupescol.serveur.eof.ScolFormationAnnee)storedValueForKey("scolFormationAnnee");
  }

  public void setScolFormationAnneeRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationAnnee value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolFormationAnnee oldValue = scolFormationAnnee();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationAnnee");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationAnnee");
    }
  }
  
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteAp scolMaquetteAp() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteAp)storedValueForKey("scolMaquetteAp");
  }

  public void setScolMaquetteApRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteAp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteAp oldValue = scolMaquetteAp();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteAp");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteAp");
    }
  }
  
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
  
  public NSArray scolInscriptionAps() {
    return (NSArray)storedValueForKey("scolInscriptionAps");
  }

  public NSArray scolInscriptionAps(EOQualifier qualifier) {
    return scolInscriptionAps(qualifier, null, false);
  }

  public NSArray scolInscriptionAps(EOQualifier qualifier, boolean fetch) {
    return scolInscriptionAps(qualifier, null, fetch);
  }

  public NSArray scolInscriptionAps(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolInscriptionAp.SCOL_MAQUETTE_REPARTITION_AP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolInscriptionAp.fetchScolInscriptionAps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolInscriptionAps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolInscriptionApsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionAp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
  }

  public void removeFromScolInscriptionApsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
  }

  public org.cocktail.groupescol.serveur.eof.ScolInscriptionAp createScolInscriptionApsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionAp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionAps");
    return (org.cocktail.groupescol.serveur.eof.ScolInscriptionAp) eo;
  }

  public void deleteScolInscriptionApsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionAps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionApsRelationships() {
    Enumeration objects = scolInscriptionAps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionApsRelationship((org.cocktail.groupescol.serveur.eof.ScolInscriptionAp)objects.nextElement());
    }
  }


  public static ScolMaquetteRepartitionAp createScolMaquetteRepartitionAp(EOEditingContext editingContext) {
    ScolMaquetteRepartitionAp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionAp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteRepartitionAp.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteRepartitionAp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllScolMaquetteRepartitionAps(EOEditingContext editingContext) {
    return _ScolMaquetteRepartitionAp.fetchAllScolMaquetteRepartitionAps(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteRepartitionAps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteRepartitionAp.fetchScolMaquetteRepartitionAps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteRepartitionAps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteRepartitionAp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteRepartitionAp fetchScolMaquetteRepartitionAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionAp.fetchScolMaquetteRepartitionAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionAp fetchScolMaquetteRepartitionAp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteRepartitionAp.fetchScolMaquetteRepartitionAps(editingContext, qualifier, null);
    ScolMaquetteRepartitionAp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteRepartitionAp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteRepartitionAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionAp fetchRequiredScolMaquetteRepartitionAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionAp.fetchRequiredScolMaquetteRepartitionAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionAp fetchRequiredScolMaquetteRepartitionAp(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteRepartitionAp eoObject = _ScolMaquetteRepartitionAp.fetchScolMaquetteRepartitionAp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteRepartitionAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionAp localInstanceIn(EOEditingContext editingContext, ScolMaquetteRepartitionAp eo) {
    ScolMaquetteRepartitionAp localInstance = (eo == null) ? null : (ScolMaquetteRepartitionAp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
