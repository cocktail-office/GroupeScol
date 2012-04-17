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

// DO NOT EDIT.  Make changes to ScolMaquetteRepartitionUe.java instead.
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

public abstract class _ScolMaquetteRepartitionUe extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteRepartitionUe";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_REPARTITION_UE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mrueKey";

	public static final String MRUE_BONIFIABLE_KEY = "mrueBonifiable";
	public static final String MRUE_COEFFICIENT_KEY = "mrueCoefficient";
	public static final String MRUE_COMPTABILISABLE_KEY = "mrueComptabilisable";
	public static final String MRUE_NOTE_BASE_KEY = "mrueNoteBase";
	public static final String MRUE_NOTE_ELIMINATION_KEY = "mrueNoteElimination";
	public static final String MRUE_NOTE_OBTENTION_KEY = "mrueNoteObtention";
	public static final String MRUE_ORDRE_KEY = "mrueOrdre";

	public static final String MRUE_BONIFIABLE_COLKEY = "MRUE_BONIFIABLE";
	public static final String MRUE_COEFFICIENT_COLKEY = "MRUE_COEFFICIENT";
	public static final String MRUE_COMPTABILISABLE_COLKEY = "MRUE_COMPTABILISABLE";
	public static final String MRUE_NOTE_BASE_COLKEY = "MRUE_NOTE_BASE";
	public static final String MRUE_NOTE_ELIMINATION_COLKEY = "MRUE_NOTE_ELIMINATION";
	public static final String MRUE_NOTE_OBTENTION_COLKEY = "MRUE_NOTE_OBTENTION";
	public static final String MRUE_ORDRE_COLKEY = "MRUE_ORDRE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_SEMESTRE_KEY = "scolMaquetteSemestre";
	public static final String SCOL_MAQUETTE_UE_KEY = "scolMaquetteUe";

	// Utilities methods
	  public ScolMaquetteRepartitionUe localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteRepartitionUe localInstance = (ScolMaquetteRepartitionUe)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteRepartitionUe getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionUe.ENTITY_NAME);
		      return (ScolMaquetteRepartitionUe) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long mrueBonifiable() {
    return (Long) storedValueForKey("mrueBonifiable");
  }

  public void setMrueBonifiable(Long value) {
    takeStoredValueForKey(value, "mrueBonifiable");
  }

  public java.math.BigDecimal mrueCoefficient() {
    return (java.math.BigDecimal) storedValueForKey("mrueCoefficient");
  }

  public void setMrueCoefficient(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrueCoefficient");
  }

  public Long mrueComptabilisable() {
    return (Long) storedValueForKey("mrueComptabilisable");
  }

  public void setMrueComptabilisable(Long value) {
    takeStoredValueForKey(value, "mrueComptabilisable");
  }

  public java.math.BigDecimal mrueNoteBase() {
    return (java.math.BigDecimal) storedValueForKey("mrueNoteBase");
  }

  public void setMrueNoteBase(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrueNoteBase");
  }

  public java.math.BigDecimal mrueNoteElimination() {
    return (java.math.BigDecimal) storedValueForKey("mrueNoteElimination");
  }

  public void setMrueNoteElimination(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrueNoteElimination");
  }

  public java.math.BigDecimal mrueNoteObtention() {
    return (java.math.BigDecimal) storedValueForKey("mrueNoteObtention");
  }

  public void setMrueNoteObtention(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mrueNoteObtention");
  }

  public Long mrueOrdre() {
    return (Long) storedValueForKey("mrueOrdre");
  }

  public void setMrueOrdre(Long value) {
    takeStoredValueForKey(value, "mrueOrdre");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre scolMaquetteSemestre() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre)storedValueForKey("scolMaquetteSemestre");
  }

  public void setScolMaquetteSemestreRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre oldValue = scolMaquetteSemestre();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteSemestre");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteSemestre");
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
  

  public static ScolMaquetteRepartitionUe createScolMaquetteRepartitionUe(EOEditingContext editingContext, Long mrueBonifiable
, java.math.BigDecimal mrueCoefficient
, Long mrueComptabilisable
, java.math.BigDecimal mrueNoteBase
, java.math.BigDecimal mrueNoteObtention
, Long mrueOrdre
) {
    ScolMaquetteRepartitionUe eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteRepartitionUe.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteRepartitionUe.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteRepartitionUe) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMrueBonifiable(mrueBonifiable);
		eo.setMrueCoefficient(mrueCoefficient);
		eo.setMrueComptabilisable(mrueComptabilisable);
		eo.setMrueNoteBase(mrueNoteBase);
		eo.setMrueNoteObtention(mrueNoteObtention);
		eo.setMrueOrdre(mrueOrdre);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteRepartitionUes(EOEditingContext editingContext) {
    return _ScolMaquetteRepartitionUe.fetchAllScolMaquetteRepartitionUes(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteRepartitionUes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteRepartitionUes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteRepartitionUe.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteRepartitionUe fetchScolMaquetteRepartitionUe(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionUe fetchScolMaquetteRepartitionUe(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUes(editingContext, qualifier, null);
    ScolMaquetteRepartitionUe eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteRepartitionUe)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteRepartitionUe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionUe fetchRequiredScolMaquetteRepartitionUe(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteRepartitionUe.fetchRequiredScolMaquetteRepartitionUe(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteRepartitionUe fetchRequiredScolMaquetteRepartitionUe(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteRepartitionUe eoObject = _ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUe(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteRepartitionUe that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteRepartitionUe localInstanceIn(EOEditingContext editingContext, ScolMaquetteRepartitionUe eo) {
    ScolMaquetteRepartitionUe localInstance = (eo == null) ? null : (ScolMaquetteRepartitionUe)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
