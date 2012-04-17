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

// DO NOT EDIT.  Make changes to ScolMaquetteSemestre.java instead.
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
import com.webobjects.foundation.NSTimestamp;

public abstract class _ScolMaquetteSemestre extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteSemestre";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_SEMESTRE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "msemKey";

	public static final String MSEM_BONIFIABLE_KEY = "msemBonifiable";
	public static final String MSEM_DATE_DEBUT_KEY = "msemDateDebut";
	public static final String MSEM_DATE_FIN_KEY = "msemDateFin";
	public static final String MSEM_HORAIRE_ETU_KEY = "msemHoraireEtu";
	public static final String MSEM_KEY_KEY = "msemKey";
	public static final String MSEM_NOTE_BASE_KEY = "msemNoteBase";
	public static final String MSEM_NOTE_ELIMINATION_KEY = "msemNoteElimination";
	public static final String MSEM_NOTE_OBTENTION_KEY = "msemNoteObtention";
	public static final String MSEM_ORDRE_KEY = "msemOrdre";
	public static final String MSEM_SEMAINE_SESSION1_KEY = "msemSemaineSession1";
	public static final String MSEM_SEMAINE_SESSION2_KEY = "msemSemaineSession2";

	public static final String MSEM_BONIFIABLE_COLKEY = "MSEM_BONIFIABLE";
	public static final String MSEM_DATE_DEBUT_COLKEY = "MSEM_DATE_DEBUT";
	public static final String MSEM_DATE_FIN_COLKEY = "MSEM_DATE_FIN";
	public static final String MSEM_HORAIRE_ETU_COLKEY = "MSEM_HORAIRE_ETU";
	public static final String MSEM_KEY_COLKEY = "MSEM_KEY";
	public static final String MSEM_NOTE_BASE_COLKEY = "MSEM_NOTE_BASE";
	public static final String MSEM_NOTE_ELIMINATION_COLKEY = "MSEM_NOTE_ELIMINATION";
	public static final String MSEM_NOTE_OBTENTION_COLKEY = "MSEM_NOTE_OBTENTION";
	public static final String MSEM_ORDRE_COLKEY = "MSEM_ORDRE";
	public static final String MSEM_SEMAINE_SESSION1_COLKEY = "MSEM_SEMAINE_SESSION1";
	public static final String MSEM_SEMAINE_SESSION2_COLKEY = "MSEM_SEMAINE_SESSION2";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_GROUPE_OBJETS_KEY = "scolGroupeObjets";
	public static final String SCOL_MAQUETTE_REPARTITION_SEMS_KEY = "scolMaquetteRepartitionSems";
	public static final String SCOL_MAQUETTE_REPARTITION_UES_KEY = "scolMaquetteRepartitionUes";

	// Utilities methods
	  public ScolMaquetteSemestre localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteSemestre localInstance = (ScolMaquetteSemestre)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteSemestre getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteSemestre.ENTITY_NAME);
		      return (ScolMaquetteSemestre) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long msemBonifiable() {
    return (Long) storedValueForKey("msemBonifiable");
  }

  public void setMsemBonifiable(Long value) {
    takeStoredValueForKey(value, "msemBonifiable");
  }

  public NSTimestamp msemDateDebut() {
    return (NSTimestamp) storedValueForKey("msemDateDebut");
  }

  public void setMsemDateDebut(NSTimestamp value) {
    takeStoredValueForKey(value, "msemDateDebut");
  }

  public NSTimestamp msemDateFin() {
    return (NSTimestamp) storedValueForKey("msemDateFin");
  }

  public void setMsemDateFin(NSTimestamp value) {
    takeStoredValueForKey(value, "msemDateFin");
  }

  public java.math.BigDecimal msemHoraireEtu() {
    return (java.math.BigDecimal) storedValueForKey("msemHoraireEtu");
  }

  public void setMsemHoraireEtu(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "msemHoraireEtu");
  }

  public Long msemKey() {
    return (Long) storedValueForKey("msemKey");
  }

  public void setMsemKey(Long value) {
    takeStoredValueForKey(value, "msemKey");
  }

  public java.math.BigDecimal msemNoteBase() {
    return (java.math.BigDecimal) storedValueForKey("msemNoteBase");
  }

  public void setMsemNoteBase(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "msemNoteBase");
  }

  public java.math.BigDecimal msemNoteElimination() {
    return (java.math.BigDecimal) storedValueForKey("msemNoteElimination");
  }

  public void setMsemNoteElimination(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "msemNoteElimination");
  }

  public java.math.BigDecimal msemNoteObtention() {
    return (java.math.BigDecimal) storedValueForKey("msemNoteObtention");
  }

  public void setMsemNoteObtention(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "msemNoteObtention");
  }

  public Long msemOrdre() {
    return (Long) storedValueForKey("msemOrdre");
  }

  public void setMsemOrdre(Long value) {
    takeStoredValueForKey(value, "msemOrdre");
  }

  public Long msemSemaineSession1() {
    return (Long) storedValueForKey("msemSemaineSession1");
  }

  public void setMsemSemaineSession1(Long value) {
    takeStoredValueForKey(value, "msemSemaineSession1");
  }

  public Long msemSemaineSession2() {
    return (Long) storedValueForKey("msemSemaineSession2");
  }

  public void setMsemSemaineSession2(Long value) {
    takeStoredValueForKey(value, "msemSemaineSession2");
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
  
  public NSArray scolGroupeObjets() {
    return (NSArray)storedValueForKey("scolGroupeObjets");
  }

  public NSArray scolGroupeObjets(EOQualifier qualifier) {
    return scolGroupeObjets(qualifier, null, false);
  }

  public NSArray scolGroupeObjets(EOQualifier qualifier, boolean fetch) {
    return scolGroupeObjets(qualifier, null, fetch);
  }

  public NSArray scolGroupeObjets(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeObjet.SCOL_MAQUETTE_SEMESTRE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolGroupeObjet.fetchScolGroupeObjets(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolGroupeObjets();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolGroupeObjetsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeObjet object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolGroupeObjets");
  }

  public void removeFromScolGroupeObjetsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeObjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolGroupeObjets");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeObjet createScolGroupeObjetsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeObjet");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolGroupeObjets");
    return (org.cocktail.groupescol.client.eof.ScolGroupeObjet) eo;
  }

  public void deleteScolGroupeObjetsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeObjet object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolGroupeObjets");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolGroupeObjetsRelationships() {
    Enumeration objects = scolGroupeObjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolGroupeObjetsRelationship((org.cocktail.groupescol.client.eof.ScolGroupeObjet)objects.nextElement());
    }
  }

  public NSArray scolMaquetteRepartitionSems() {
    return (NSArray)storedValueForKey("scolMaquetteRepartitionSems");
  }

  public NSArray scolMaquetteRepartitionSems(EOQualifier qualifier) {
    return scolMaquetteRepartitionSems(qualifier, null, false);
  }

  public NSArray scolMaquetteRepartitionSems(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteRepartitionSems(qualifier, null, fetch);
  }

  public NSArray scolMaquetteRepartitionSems(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem.SCOL_MAQUETTE_SEMESTRE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem.fetchScolMaquetteRepartitionSems(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteRepartitionSems();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteRepartitionSemsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionSems");
  }

  public void removeFromScolMaquetteRepartitionSemsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionSems");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem createScolMaquetteRepartitionSemsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionSem");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionSems");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem) eo;
  }

  public void deleteScolMaquetteRepartitionSemsRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionSems");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionSemsRelationships() {
    Enumeration objects = scolMaquetteRepartitionSems().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionSemsRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionSem)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe.SCOL_MAQUETTE_SEMESTRE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe.fetchScolMaquetteRepartitionUes(editingContext(), fullQualifier, sortOrderings);
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
  
  public void addToScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
  }

  public void removeFromScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
  }

  public org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe createScolMaquetteRepartitionUesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteRepartitionUe");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteRepartitionUes");
    return (org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe) eo;
  }

  public void deleteScolMaquetteRepartitionUesRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteRepartitionUes");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteRepartitionUesRelationships() {
    Enumeration objects = scolMaquetteRepartitionUes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteRepartitionUesRelationship((org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionUe)objects.nextElement());
    }
  }


  public static ScolMaquetteSemestre createScolMaquetteSemestre(EOEditingContext editingContext, Long msemBonifiable
, java.math.BigDecimal msemHoraireEtu
, Long msemKey
, java.math.BigDecimal msemNoteBase
, java.math.BigDecimal msemNoteObtention
, Long msemOrdre
) {
    ScolMaquetteSemestre eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteSemestre.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteSemestre.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteSemestre) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMsemBonifiable(msemBonifiable);
		eo.setMsemHoraireEtu(msemHoraireEtu);
		eo.setMsemKey(msemKey);
		eo.setMsemNoteBase(msemNoteBase);
		eo.setMsemNoteObtention(msemNoteObtention);
		eo.setMsemOrdre(msemOrdre);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteSemestres(EOEditingContext editingContext) {
    return _ScolMaquetteSemestre.fetchAllScolMaquetteSemestres(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteSemestres(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteSemestre.fetchScolMaquetteSemestres(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteSemestres(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteSemestre.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteSemestre fetchScolMaquetteSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteSemestre.fetchScolMaquetteSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteSemestre fetchScolMaquetteSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteSemestre.fetchScolMaquetteSemestres(editingContext, qualifier, null);
    ScolMaquetteSemestre eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteSemestre)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteSemestre fetchRequiredScolMaquetteSemestre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteSemestre.fetchRequiredScolMaquetteSemestre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteSemestre fetchRequiredScolMaquetteSemestre(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteSemestre eoObject = _ScolMaquetteSemestre.fetchScolMaquetteSemestre(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteSemestre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteSemestre localInstanceIn(EOEditingContext editingContext, ScolMaquetteSemestre eo) {
    ScolMaquetteSemestre localInstance = (eo == null) ? null : (ScolMaquetteSemestre)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
