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

// DO NOT EDIT.  Make changes to ScolMaquetteEc.java instead.
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

public abstract class _ScolMaquetteEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteEc";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_EC";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mecKey";

	public static final String MEC_BASE_KEY = "mecBase";
	public static final String MEC_CODE_KEY = "mecCode";
	public static final String MEC_HORAIRE_ETU_KEY = "mecHoraireEtu";
	public static final String MEC_LIBELLE_KEY = "mecLibelle";
	public static final String MEC_LIBELLE_COURT_KEY = "mecLibelleCourt";
	public static final String MEC_POINTS_KEY = "mecPoints";
	public static final String MEC_SESSION1_KEY = "mecSession1";
	public static final String MEC_SESSION2_KEY = "mecSession2";

	public static final String MEC_BASE_COLKEY = "MEC_BASE";
	public static final String MEC_CODE_COLKEY = "MEC_CODE";
	public static final String MEC_HORAIRE_ETU_COLKEY = "MEC_HORAIRE_ETU";
	public static final String MEC_LIBELLE_COLKEY = "MEC_LIBELLE";
	public static final String MEC_LIBELLE_COURT_COLKEY = "MEC_LIBELLE_COURT";
	public static final String MEC_POINTS_COLKEY = "MEC_POINTS";
	public static final String MEC_SESSION1_COLKEY = "MEC_SESSION1";
	public static final String MEC_SESSION2_COLKEY = "MEC_SESSION2";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_REPARTITION_APS_KEY = "scolMaquetteRepartitionAps";
	public static final String SCOL_MAQUETTE_REPARTITION_ECS_KEY = "scolMaquetteRepartitionEcs";

	// Utilities methods
	  public ScolMaquetteEc localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteEc localInstance = (ScolMaquetteEc)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteEc getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteEc.ENTITY_NAME);
		      return (ScolMaquetteEc) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long mecBase() {
    return (Long) storedValueForKey("mecBase");
  }

  public void setMecBase(Long value) {
    takeStoredValueForKey(value, "mecBase");
  }

  public String mecCode() {
    return (String) storedValueForKey("mecCode");
  }

  public void setMecCode(String value) {
    takeStoredValueForKey(value, "mecCode");
  }

  public java.math.BigDecimal mecHoraireEtu() {
    return (java.math.BigDecimal) storedValueForKey("mecHoraireEtu");
  }

  public void setMecHoraireEtu(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mecHoraireEtu");
  }

  public String mecLibelle() {
    return (String) storedValueForKey("mecLibelle");
  }

  public void setMecLibelle(String value) {
    takeStoredValueForKey(value, "mecLibelle");
  }

  public String mecLibelleCourt() {
    return (String) storedValueForKey("mecLibelleCourt");
  }

  public void setMecLibelleCourt(String value) {
    takeStoredValueForKey(value, "mecLibelleCourt");
  }

  public java.math.BigDecimal mecPoints() {
    return (java.math.BigDecimal) storedValueForKey("mecPoints");
  }

  public void setMecPoints(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mecPoints");
  }

  public String mecSession1() {
    return (String) storedValueForKey("mecSession1");
  }

  public void setMecSession1(String value) {
    takeStoredValueForKey(value, "mecSession1");
  }

  public String mecSession2() {
    return (String) storedValueForKey("mecSession2");
  }

  public void setMecSession2(String value) {
    takeStoredValueForKey(value, "mecSession2");
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
  
  public NSArray scolMaquetteRepartitionAps() {
    return (NSArray)storedValueForKey("scolMaquetteRepartitionAps");
  }

  public NSArray scolMaquetteRepartitionAps(EOQualifier qualifier) {
    return scolMaquetteRepartitionAps(qualifier, null, false);
  }

  public NSArray scolMaquetteRepartitionAps(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteRepartitionAps(qualifier, null, fetch);
  }

  public NSArray scolMaquetteRepartitionAps(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp.SCOL_MAQUETTE_EC_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp.fetchScolMaquetteRepartitionAps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteRepartitionAps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteRepartitionApsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionAps");
  }

  public void removeFromScolMaquetteRepartitionApsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionAps");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp createScolMaquetteRepartitionApsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionAp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionAps");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp) eo;
  }

  public void deleteScolMaquetteRepartitionApsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionAps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionApsRelationships() {
    Enumeration objects = scolMaquetteRepartitionAps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionApsRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc.SCOL_MAQUETTE_EC_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext(), fullQualifier, sortOrderings);
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
  
  public void addToScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public void removeFromScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc createScolMaquetteRepartitionEcsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionEcs");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc) eo;
  }

  public void deleteScolMaquetteRepartitionEcsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionEcs");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionEcsRelationships() {
    Enumeration objects = scolMaquetteRepartitionEcs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionEcsRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc)objects.nextElement());
    }
  }


  public static ScolMaquetteEc createScolMaquetteEc(EOEditingContext editingContext, Long mecBase
, String mecCode
, java.math.BigDecimal mecHoraireEtu
, java.math.BigDecimal mecPoints
) {
    ScolMaquetteEc eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteEc.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteEc.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteEc) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMecBase(mecBase);
		eo.setMecCode(mecCode);
		eo.setMecHoraireEtu(mecHoraireEtu);
		eo.setMecPoints(mecPoints);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteEcs(EOEditingContext editingContext) {
    return _ScolMaquetteEc.fetchAllScolMaquetteEcs(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteEcs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteEc.fetchScolMaquetteEcs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteEc fetchScolMaquetteEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEc.fetchScolMaquetteEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEc fetchScolMaquetteEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteEc.fetchScolMaquetteEcs(editingContext, qualifier, null);
    ScolMaquetteEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEc fetchRequiredScolMaquetteEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEc.fetchRequiredScolMaquetteEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEc fetchRequiredScolMaquetteEc(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteEc eoObject = _ScolMaquetteEc.fetchScolMaquetteEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEc localInstanceIn(EOEditingContext editingContext, ScolMaquetteEc eo) {
    ScolMaquetteEc localInstance = (eo == null) ? null : (ScolMaquetteEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
