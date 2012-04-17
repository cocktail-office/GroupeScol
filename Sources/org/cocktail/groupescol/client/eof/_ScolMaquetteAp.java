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

// DO NOT EDIT.  Make changes to ScolMaquetteAp.java instead.
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

public abstract class _ScolMaquetteAp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteAp";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_AP";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mapKey";

	public static final String MAP_GROUPE_PREVU_KEY = "mapGroupePrevu";
	public static final String MAP_GROUPE_REEL_KEY = "mapGroupeReel";
	public static final String MAP_LIBELLE_KEY = "mapLibelle";
	public static final String MAP_LIBELLE_REEL_KEY = "mapLibelleReel";
	public static final String MAP_SEUIL_KEY = "mapSeuil";
	public static final String MAP_VALEUR_KEY = "mapValeur";
	public static final String MHCO_CODE_KEY = "mhcoCode";

	public static final String MAP_GROUPE_PREVU_COLKEY = "MAP_GROUPE_PREVU";
	public static final String MAP_GROUPE_REEL_COLKEY = "MAP_GROUPE_REEL";
	public static final String MAP_LIBELLE_COLKEY = "$attribute.columnName";
	public static final String MAP_LIBELLE_REEL_COLKEY = "MAP_LIBELLE";
	public static final String MAP_SEUIL_COLKEY = "MAP_SEUIL";
	public static final String MAP_VALEUR_COLKEY = "MAP_VALEUR";
	public static final String MHCO_CODE_COLKEY = "MHCO_CODE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_GROUPE_OBJETS_KEY = "scolGroupeObjets";
	public static final String SCOL_MAQUETTE_HORAIRE_CODE_KEY = "scolMaquetteHoraireCode";
	public static final String SCOL_MAQUETTE_HORAIRE_MODE_KEY = "scolMaquetteHoraireMode";
	public static final String SCOL_MAQUETTE_REPARTITION_APS_KEY = "scolMaquetteRepartitionAps";
	public static final String V_SCOL_MAQUETTE_AP_EC_KEY = "vScolMaquetteApEc";
	public static final String V_SEMESTRE_AP_KEY = "vSemestreAp";

	// Utilities methods
	  public ScolMaquetteAp localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteAp localInstance = (ScolMaquetteAp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteAp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteAp.ENTITY_NAME);
		      return (ScolMaquetteAp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long mapGroupePrevu() {
    return (Long) storedValueForKey("mapGroupePrevu");
  }

  public void setMapGroupePrevu(Long value) {
    takeStoredValueForKey(value, "mapGroupePrevu");
  }

  public Long mapGroupeReel() {
    return (Long) storedValueForKey("mapGroupeReel");
  }

  public void setMapGroupeReel(Long value) {
    takeStoredValueForKey(value, "mapGroupeReel");
  }

  public String mapLibelle() {
    return (String) storedValueForKey("mapLibelle");
  }

  public void setMapLibelle(String value) {
    takeStoredValueForKey(value, "mapLibelle");
  }

  public String mapLibelleReel() {
    return (String) storedValueForKey("mapLibelleReel");
  }

  public void setMapLibelleReel(String value) {
    takeStoredValueForKey(value, "mapLibelleReel");
  }

  public Long mapSeuil() {
    return (Long) storedValueForKey("mapSeuil");
  }

  public void setMapSeuil(Long value) {
    takeStoredValueForKey(value, "mapSeuil");
  }

  public java.math.BigDecimal mapValeur() {
    return (java.math.BigDecimal) storedValueForKey("mapValeur");
  }

  public void setMapValeur(java.math.BigDecimal value) {
    takeStoredValueForKey(value, "mapValeur");
  }

  public String mhcoCode() {
    return (String) storedValueForKey("mhcoCode");
  }

  public void setMhcoCode(String value) {
    takeStoredValueForKey(value, "mhcoCode");
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
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteHoraireCode scolMaquetteHoraireCode() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteHoraireCode)storedValueForKey("scolMaquetteHoraireCode");
  }

  public void setScolMaquetteHoraireCodeRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteHoraireCode value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteHoraireCode oldValue = scolMaquetteHoraireCode();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteHoraireCode");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteHoraireCode");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolMaquetteHoraireMode scolMaquetteHoraireMode() {
    return (org.cocktail.groupescol.client.eof.ScolMaquetteHoraireMode)storedValueForKey("scolMaquetteHoraireMode");
  }

  public void setScolMaquetteHoraireModeRelationship(org.cocktail.groupescol.client.eof.ScolMaquetteHoraireMode value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolMaquetteHoraireMode oldValue = scolMaquetteHoraireMode();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteHoraireMode");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteHoraireMode");
    }
  }
  
  public org.cocktail.groupescol.client.eof.VScolMaquetteApEc vScolMaquetteApEc() {
    return (org.cocktail.groupescol.client.eof.VScolMaquetteApEc)storedValueForKey("vScolMaquetteApEc");
  }

  public void setVScolMaquetteApEcRelationship(org.cocktail.groupescol.client.eof.VScolMaquetteApEc value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.VScolMaquetteApEc oldValue = vScolMaquetteApEc();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "vScolMaquetteApEc");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "vScolMaquetteApEc");
    }
  }
  
  public org.cocktail.groupescol.client.eof.VSemestreAp vSemestreAp() {
    return (org.cocktail.groupescol.client.eof.VSemestreAp)storedValueForKey("vSemestreAp");
  }

  public void setVSemestreApRelationship(org.cocktail.groupescol.client.eof.VSemestreAp value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.VSemestreAp oldValue = vSemestreAp();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "vSemestreAp");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "vSemestreAp");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeObjet.SCOL_MAQUETTE_AP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolMaquetteRepartitionAp.SCOL_MAQUETTE_AP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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


  public static ScolMaquetteAp createScolMaquetteAp(EOEditingContext editingContext, Long mapGroupePrevu
, Long mapGroupeReel
, String mapLibelle
, String mapLibelleReel
, Long mapSeuil
, java.math.BigDecimal mapValeur
, String mhcoCode
, org.cocktail.groupescol.client.eof.VScolMaquetteApEc vScolMaquetteApEc, org.cocktail.groupescol.client.eof.VSemestreAp vSemestreAp) {
    ScolMaquetteAp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteAp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteAp.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteAp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMapGroupePrevu(mapGroupePrevu);
		eo.setMapGroupeReel(mapGroupeReel);
		eo.setMapLibelle(mapLibelle);
		eo.setMapLibelleReel(mapLibelleReel);
		eo.setMapSeuil(mapSeuil);
		eo.setMapValeur(mapValeur);
		eo.setMhcoCode(mhcoCode);
    eo.setVScolMaquetteApEcRelationship(vScolMaquetteApEc);
    eo.setVSemestreApRelationship(vSemestreAp);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteAps(EOEditingContext editingContext) {
    return _ScolMaquetteAp.fetchAllScolMaquetteAps(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteAps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteAp.fetchScolMaquetteAps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteAps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteAp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteAp fetchScolMaquetteAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteAp.fetchScolMaquetteAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteAp fetchScolMaquetteAp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteAp.fetchScolMaquetteAps(editingContext, qualifier, null);
    ScolMaquetteAp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteAp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteAp fetchRequiredScolMaquetteAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteAp.fetchRequiredScolMaquetteAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteAp fetchRequiredScolMaquetteAp(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteAp eoObject = _ScolMaquetteAp.fetchScolMaquetteAp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteAp localInstanceIn(EOEditingContext editingContext, ScolMaquetteAp eo) {
    ScolMaquetteAp localInstance = (eo == null) ? null : (ScolMaquetteAp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
