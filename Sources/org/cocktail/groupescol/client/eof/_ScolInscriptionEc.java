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

// DO NOT EDIT.  Make changes to ScolInscriptionEc.java instead.
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

public abstract class _ScolInscriptionEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolInscriptionEc";
	public static final String ENTITY_TABLE_NAME = "SCOL_INSCRIPTION_EC";

	// Attributes

	public static final String IMREC_ABSENCE1_KEY = "imrecAbsence1";
	public static final String IMREC_ABSENCE2_KEY = "imrecAbsence2";
	public static final String IMREC_COEFFICIENT_KEY = "imrecCoefficient";
	public static final String IMREC_DISPENSE_KEY = "imrecDispense";
	public static final String IMREC_ETAT_KEY = "imrecEtat";
	public static final String IMREC_MENTION1_KEY = "imrecMention1";
	public static final String IMREC_MENTION2_KEY = "imrecMention2";
	public static final String IMREC_NOTE_BASE_KEY = "imrecNoteBase";
	public static final String IMREC_OBTENTION_KEY = "imrecObtention";
	public static final String IMREC_POINT_JURY_KEY = "imrecPointJury";
	public static final String IMREC_PONDERATION_KEY = "imrecPonderation";
	public static final String IMREC_SESSION1_KEY = "imrecSession1";
	public static final String IMREC_SESSION2_KEY = "imrecSession2";

	public static final String IMREC_ABSENCE1_COLKEY = "IMREC_ABSENCE1";
	public static final String IMREC_ABSENCE2_COLKEY = "IMREC_ABSENCE2";
	public static final String IMREC_COEFFICIENT_COLKEY = "IMREC_COEFFICIENT";
	public static final String IMREC_DISPENSE_COLKEY = "IMREC_DISPENSE";
	public static final String IMREC_ETAT_COLKEY = "IMREC_ETAT";
	public static final String IMREC_MENTION1_COLKEY = "IMREC_MENTION1";
	public static final String IMREC_MENTION2_COLKEY = "IMREC_MENTION2";
	public static final String IMREC_NOTE_BASE_COLKEY = "IMREC_NOTE_BASE";
	public static final String IMREC_OBTENTION_COLKEY = "IMREC_OBTENTION";
	public static final String IMREC_POINT_JURY_COLKEY = "IMREC_POINT_JURY";
	public static final String IMREC_PONDERATION_COLKEY = "IMREC_PONDERATION";
	public static final String IMREC_SESSION1_COLKEY = "IMREC_SESSION1";
	public static final String IMREC_SESSION2_COLKEY = "IMREC_SESSION2";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_MAQUETTE_REPARTITION_EC_KEY = "scolMaquetteRepartitionEc";

	// Utilities methods
	  public ScolInscriptionEc localInstanceIn(EOEditingContext editingContext) {
	    ScolInscriptionEc localInstance = (ScolInscriptionEc)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolInscriptionEc getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionEc.ENTITY_NAME);
		      return (ScolInscriptionEc) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long imrecAbsence1() {
    return (Long) storedValueForKey("imrecAbsence1");
  }

  public void setImrecAbsence1(Long value) {
    takeStoredValueForKey(value, "imrecAbsence1");
  }

  public Long imrecAbsence2() {
    return (Long) storedValueForKey("imrecAbsence2");
  }

  public void setImrecAbsence2(Long value) {
    takeStoredValueForKey(value, "imrecAbsence2");
  }

  public java.math.BigDecimal imrecCoefficient() {
    return (java.math.BigDecimal) storedValueForKey("imrecCoefficient");
  }

  public void setImrecCoefficient(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecCoefficient");
  }

  public Long imrecDispense() {
    return (Long) storedValueForKey("imrecDispense");
  }

  public void setImrecDispense(Long value) {
    takeStoredValueForKey(value, "imrecDispense");
  }

  public Long imrecEtat() {
    return (Long) storedValueForKey("imrecEtat");
  }

  public void setImrecEtat(Long value) {
    takeStoredValueForKey(value, "imrecEtat");
  }

  public Long imrecMention1() {
    return (Long) storedValueForKey("imrecMention1");
  }

  public void setImrecMention1(Long value) {
    takeStoredValueForKey(value, "imrecMention1");
  }

  public Long imrecMention2() {
    return (Long) storedValueForKey("imrecMention2");
  }

  public void setImrecMention2(Long value) {
    takeStoredValueForKey(value, "imrecMention2");
  }

  public java.math.BigDecimal imrecNoteBase() {
    return (java.math.BigDecimal) storedValueForKey("imrecNoteBase");
  }

  public void setImrecNoteBase(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecNoteBase");
  }

  public String imrecObtention() {
    return (String) storedValueForKey("imrecObtention");
  }

  public void setImrecObtention(String value) {
    takeStoredValueForKey(value, "imrecObtention");
  }

  public java.math.BigDecimal imrecPointJury() {
    return (java.math.BigDecimal) storedValueForKey("imrecPointJury");
  }

  public void setImrecPointJury(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecPointJury");
  }

  public java.math.BigDecimal imrecPonderation() {
    return (java.math.BigDecimal) storedValueForKey("imrecPonderation");
  }

  public void setImrecPonderation(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecPonderation");
  }

  public java.math.BigDecimal imrecSession1() {
    return (java.math.BigDecimal) storedValueForKey("imrecSession1");
  }

  public void setImrecSession1(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecSession1");
  }

  public java.math.BigDecimal imrecSession2() {
    return (java.math.BigDecimal) storedValueForKey("imrecSession2");
  }

  public void setImrecSession2(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "imrecSession2");
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
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc scolMaquetteRepartitionEc() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc)storedValueForKey("scolMaquetteRepartitionEc");
  }

  public void setScolMaquetteRepartitionEcRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionEc oldValue = scolMaquetteRepartitionEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteRepartitionEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteRepartitionEc");
    }
  }
  

  public static ScolInscriptionEc createScolInscriptionEc(EOEditingContext editingContext, Long imrecAbsence1
, Long imrecAbsence2
, Long imrecDispense
, Long imrecEtat
, Long imrecMention1
, Long imrecMention2
) {
    ScolInscriptionEc eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionEc.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolInscriptionEc.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolInscriptionEc) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setImrecAbsence1(imrecAbsence1);
		eo.setImrecAbsence2(imrecAbsence2);
		eo.setImrecDispense(imrecDispense);
		eo.setImrecEtat(imrecEtat);
		eo.setImrecMention1(imrecMention1);
		eo.setImrecMention2(imrecMention2);
    return eo;
  }

  public static NSArray fetchAllScolInscriptionEcs(EOEditingContext editingContext) {
    return _ScolInscriptionEc.fetchAllScolInscriptionEcs(editingContext, null);
  }

  public static NSArray fetchAllScolInscriptionEcs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolInscriptionEc.fetchScolInscriptionEcs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolInscriptionEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolInscriptionEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolInscriptionEc fetchScolInscriptionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionEc.fetchScolInscriptionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionEc fetchScolInscriptionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolInscriptionEc.fetchScolInscriptionEcs(editingContext, qualifier, null);
    ScolInscriptionEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolInscriptionEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolInscriptionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionEc fetchRequiredScolInscriptionEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionEc.fetchRequiredScolInscriptionEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionEc fetchRequiredScolInscriptionEc(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolInscriptionEc eoObject = _ScolInscriptionEc.fetchScolInscriptionEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolInscriptionEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionEc localInstanceIn(EOEditingContext editingContext, ScolInscriptionEc eo) {
    ScolInscriptionEc localInstance = (eo == null) ? null : (ScolInscriptionEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
