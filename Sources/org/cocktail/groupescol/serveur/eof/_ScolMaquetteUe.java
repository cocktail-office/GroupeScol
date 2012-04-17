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

// DO NOT EDIT.  Make changes to ScolMaquetteUe.java instead.
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

public abstract class _ScolMaquetteUe extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteUe";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_UE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mueKey";

	public static final String MUE_CODE_KEY = "mueCode";
	public static final String MUE_HORAIRE_ETU_KEY = "mueHoraireEtu";
	public static final String MUE_LIBELLE_KEY = "mueLibelle";
	public static final String MUE_POINTS_KEY = "muePoints";

	public static final String MUE_CODE_COLKEY = "MUE_CODE";
	public static final String MUE_HORAIRE_ETU_COLKEY = "MUE_HORAIRE_ETU";
	public static final String MUE_LIBELLE_COLKEY = "MUE_LIBELLE";
	public static final String MUE_POINTS_COLKEY = "MUE_POINTS";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_FORMATION_DOMAINE_KEY = "scolFormationDomaine";
	public static final String SCOL_MAQUETTE_REPARTITION_ECS_KEY = "scolMaquetteRepartitionEcs";
	public static final String SCOL_MAQUETTE_REPARTITION_UES_KEY = "scolMaquetteRepartitionUes";

	// Utilities methods
	  public ScolMaquetteUe localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteUe localInstance = (ScolMaquetteUe)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteUe getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteUe.ENTITY_NAME);
		      return (ScolMaquetteUe) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String mueCode() {
    return (String) storedValueForKey("mueCode");
  }

  public void setMueCode(String value) {
    takeStoredValueForKey(value, "mueCode");
  }

  public java.math.BigDecimal mueHoraireEtu() {
    return (java.math.BigDecimal) storedValueForKey("mueHoraireEtu");
  }

  public void setMueHoraireEtu(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mueHoraireEtu");
  }

  public String mueLibelle() {
    return (String) storedValueForKey("mueLibelle");
  }

  public void setMueLibelle(String value) {
    takeStoredValueForKey(value, "mueLibelle");
  }

  public java.math.BigDecimal muePoints() {
    return (java.math.BigDecimal) storedValueForKey("muePoints");
  }

  public void setMuePoints(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "muePoints");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolFormationDomaine scolFormationDomaine() {
    return (org.cocktail.groupescol.serveur.eof.ScolFormationDomaine)storedValueForKey("scolFormationDomaine");
  }

  public void setScolFormationDomaineRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationDomaine value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolFormationDomaine oldValue = scolFormationDomaine();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationDomaine");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationDomaine");
    }
  }
  
  public NSArray scolMaquetteRepartitionEcs() {
    return (NSArray)storedValueForKey("scolMaquetteRepartitionEcs");
  }

  public NSArray scolMaquetteRepartitionEcs(EOQualifier qualifier) {
    return scolMaquetteRepartitionEcs(qualifier, null, false);
  }

  public NSArray scolMaquetteRepartitionEcs(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteRepartitionEcs(qualifier, null, fetch);
  }

  public NSArray scolMaquetteRepartitionEcs(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc.SCOL_MAQUETTE_UE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteRepartitionEcs();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public void removeFromScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc createScolMaquetteRepartitionEcsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionEcs");
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc) eo;
  }

  public void deleteScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionEcsRelationships() {
    Enumeration objects = scolMaquetteRepartitionEcs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionEcsRelationship((org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionEc)objects.nextElement());
    }
  }

  public NSArray scolMaquetteRepartitionUes() {
    return (NSArray)storedValueForKey("scolMaquetteRepartitionUes");
  }

  public NSArray scolMaquetteRepartitionUes(EOQualifier qualifier) {
    return scolMaquetteRepartitionUes(qualifier, null, false);
  }

  public NSArray scolMaquetteRepartitionUes(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteRepartitionUes(qualifier, null, fetch);
  }

  public NSArray scolMaquetteRepartitionUes(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe.SCOL_MAQUETTE_UE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteRepartitionUes();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
  }

  public void removeFromScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
  }

  public org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe createScolMaquetteRepartitionUesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionUe");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionUes");
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe) eo;
  }

  public void deleteScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionUesRelationships() {
    Enumeration objects = scolMaquetteRepartitionUes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionUesRelationship((org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionUe)objects.nextElement());
    }
  }


  public static ScolMaquetteUe createScolMaquetteUe(EOEditingContext editingContext, String mueCode
, java.math.BigDecimal mueHoraireEtu
, java.math.BigDecimal muePoints
) {
    ScolMaquetteUe eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteUe.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteUe.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteUe) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMueCode(mueCode);
		eo.setMueHoraireEtu(mueHoraireEtu);
		eo.setMuePoints(muePoints);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteUes(EOEditingContext editingContext) {
    return _ScolMaquetteUe.fetchAllScolMaquetteUes(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteUes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteUe.fetchScolMaquetteUes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteUes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteUe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteUe fetchScolMaquetteUe(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteUe.fetchScolMaquetteUe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteUe fetchScolMaquetteUe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteUe.fetchScolMaquetteUes(editingContext, qualifier, null);
    ScolMaquetteUe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteUe)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteUe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteUe fetchRequiredScolMaquetteUe(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteUe.fetchRequiredScolMaquetteUe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteUe fetchRequiredScolMaquetteUe(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteUe eoObject = _ScolMaquetteUe.fetchScolMaquetteUe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteUe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteUe localInstanceIn(EOEditingContext editingContext, ScolMaquetteUe eo) {
    ScolMaquetteUe localInstance = (eo == null) ? null : (ScolMaquetteUe)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
