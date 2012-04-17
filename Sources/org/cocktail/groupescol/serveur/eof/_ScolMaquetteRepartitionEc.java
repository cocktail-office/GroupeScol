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

// DO NOT EDIT.  Make changes to ScolMaquetteRepartitionEc.java instead.
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

public abstract class _ScolMaquetteRepartitionEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteRepartitionEc";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_REPARTITION_EC";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mrecKey";

	public static final String MREC_BONIFIABLE_KEY = "mrecBonifiable";
	public static final String MREC_COEFFICIENT_KEY = "mrecCoefficient";
	public static final String MREC_COMPTABILISABLE_KEY = "mrecComptabilisable";
	public static final String MREC_NIVEAU_KEY = "mrecNiveau";
	public static final String MREC_NOTE_BASE_KEY = "mrecNoteBase";
	public static final String MREC_NOTE_ELIMINATION_KEY = "mrecNoteElimination";
	public static final String MREC_NOTE_OBTENTION_KEY = "mrecNoteObtention";
	public static final String MREC_ORDRE_KEY = "mrecOrdre";
	public static final String MTEC_CODE_KEY = "mtecCode";

	public static final String MREC_BONIFIABLE_COLKEY = "MREC_BONIFIABLE";
	public static final String MREC_COEFFICIENT_COLKEY = "MREC_COEFFICIENT";
	public static final String MREC_COMPTABILISABLE_COLKEY = "MREC_COMPTABILISABLE";
	public static final String MREC_NIVEAU_COLKEY = "MREC_NIVEAU";
	public static final String MREC_NOTE_BASE_COLKEY = "MREC_NOTE_BASE";
	public static final String MREC_NOTE_ELIMINATION_COLKEY = "MREC_NOTE_ELIMINATION";
	public static final String MREC_NOTE_OBTENTION_COLKEY = "MREC_NOTE_OBTENTION";
	public static final String MREC_ORDRE_COLKEY = "MREC_ORDRE";
	public static final String MTEC_CODE_COLKEY = "MTEC_CODE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_INSCRIPTION_ECS_KEY = "scolInscriptionEcs";
	public static final String SCOL_MAQUETTE_EC_KEY = "scolMaquetteEc";
	public static final String SCOL_MAQUETTE_UE_KEY = "scolMaquetteUe";

	// Utilities methods
	  public ScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteRepartitionEc localInstance = (ScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteRepartitionEc getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionEc.ENTITY_NAME);
		      return (ScolMaquetteRepartitionEc) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long mrecBonifiable() {
    return (Long) storedValueForKey("mrecBonifiable");
  }

  public void setMrecBonifiable(Long value) {
    takeStoredValueForKey(value, "mrecBonifiable");
  }

  public java.math.BigDecimal mrecCoefficient() {
    return (java.math.BigDecimal) storedValueForKey("mrecCoefficient");
  }

  public void setMrecCoefficient(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrecCoefficient");
  }

  public Long mrecComptabilisable() {
    return (Long) storedValueForKey("mrecComptabilisable");
  }

  public void setMrecComptabilisable(Long value) {
    takeStoredValueForKey(value, "mrecComptabilisable");
  }

  public String mrecNiveau() {
    return (String) storedValueForKey("mrecNiveau");
  }

  public void setMrecNiveau(String value) {
    takeStoredValueForKey(value, "mrecNiveau");
  }

  public java.math.BigDecimal mrecNoteBase() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteBase");
  }

  public void setMrecNoteBase(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrecNoteBase");
  }

  public java.math.BigDecimal mrecNoteElimination() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteElimination");
  }

  public void setMrecNoteElimination(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrecNoteElimination");
  }

  public java.math.BigDecimal mrecNoteObtention() {
    return (java.math.BigDecimal) storedValueForKey("mrecNoteObtention");
  }

  public void setMrecNoteObtention(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrecNoteObtention");
  }

  public Long mrecOrdre() {
    return (Long) storedValueForKey("mrecOrdre");
  }

  public void setMrecOrdre(Long value) {
    takeStoredValueForKey(value, "mrecOrdre");
  }

  public String mtecCode() {
    return (String) storedValueForKey("mtecCode");
  }

  public void setMtecCode(String value) {
    takeStoredValueForKey(value, "mtecCode");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteUe scolMaquetteUe() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteUe)storedValueForKey("scolMaquetteUe");
  }

  public void setScolMaquetteUeRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteUe value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteUe oldValue = scolMaquetteUe();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteUe");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteUe");
    }
  }
  
  public NSArray scolInscriptionEcs() {
    return (NSArray)storedValueForKey("scolInscriptionEcs");
  }

  public NSArray scolInscriptionEcs(EOQualifier qualifier) {
    return scolInscriptionEcs(qualifier, null, false);
  }

  public NSArray scolInscriptionEcs(EOQualifier qualifier, boolean fetch) {
    return scolInscriptionEcs(qualifier, null, fetch);
  }

  public NSArray scolInscriptionEcs(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolInscriptionEc.SCOL_MAQUETTE_REPARTITION_EC_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolInscriptionEc.fetchScolInscriptionEcs(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolInscriptionEcs();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolInscriptionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionEc object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionEcs");
  }

  public void removeFromScolInscriptionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionEcs");
  }

  public org.cocktail.groupescol.serveur.eof.ScolInscriptionEc createScolInscriptionEcsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionEc");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionEcs");
    return (org.cocktail.groupescol.serveur.eof.ScolInscriptionEc) eo;
  }

  public void deleteScolInscriptionEcsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionEc object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionEcs");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionEcsRelationships() {
    Enumeration objects = scolInscriptionEcs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionEcsRelationship((org.cocktail.groupescol.serveur.eof.ScolInscriptionEc)objects.nextElement());
    }
  }


  public static ScolMaquetteRepartitionEc createScolMaquetteRepartitionEc(EOEditingContext editingContext, Long mrecBonifiable
, java.math.BigDecimal mrecCoefficient
, Long mrecComptabilisable
, java.math.BigDecimal mrecNoteBase
, java.math.BigDecimal mrecNoteObtention
, Long mrecOrdre
, String mtecCode
) {
    ScolMaquetteRepartitionEc eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionEc.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteRepartitionEc.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteRepartitionEc) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMrecBonifiable(mrecBonifiable);
		eo.setMrecCoefficient(mrecCoefficient);
		eo.setMrecComptabilisable(mrecComptabilisable);
		eo.setMrecNoteBase(mrecNoteBase);
		eo.setMrecNoteObtention(mrecNoteObtention);
		eo.setMrecOrdre(mrecOrdre);
		eo.setMtecCode(mtecCode);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteRepartitionEcs(EOEditingContext editingContext) {
    return _ScolMaquetteRepartitionEc.fetchAllScolMaquetteRepartitionEcs(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteRepartitionEcs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteRepartitionEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteRepartitionEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteRepartitionEc fetchScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionEc fetchScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEcs(editingContext, qualifier, null);
    ScolMaquetteRepartitionEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteRepartitionEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionEc fetchRequiredScolMaquetteRepartitionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionEc.fetchRequiredScolMaquetteRepartitionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionEc fetchRequiredScolMaquetteRepartitionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteRepartitionEc eoObject = _ScolMaquetteRepartitionEc.fetchScolMaquetteRepartitionEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteRepartitionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionEc localInstanceIn(EOEditingContext editingContext, ScolMaquetteRepartitionEc eo) {
    ScolMaquetteRepartitionEc localInstance = (eo == null) ? null : (ScolMaquetteRepartitionEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
