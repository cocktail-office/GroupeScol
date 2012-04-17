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

// DO NOT EDIT.  Make changes to ScolInscriptionEtudiant.java instead.
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

public abstract class _ScolInscriptionEtudiant extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolInscriptionEtudiant";
	public static final String ENTITY_TABLE_NAME = "SCOL_INSCRIPTION_ETUDIANT";

	// Attributes

	public static final String ADR_CIVILITE_KEY = "adrCivilite";
	public static final String ADR_NOM_KEY = "adrNom";
	public static final String ADR_PRENOM_KEY = "adrPrenom";
	public static final String ETUD_CODE_INE_KEY = "etudCodeIne";
	public static final String ETUD_NUMERO_KEY = "etudNumero";
	public static final String FDIP_ABREVIATION_KEY = "fdipAbreviation";
	public static final String FGRA_CODE_KEY = "fgraCode";
	public static final String FORMATION_KEY = "formation";
	public static final String FSPN_LIBELLE_KEY = "fspnLibelle";
	public static final String IDENTITE_KEY = "identite";
	public static final String IDIPL_ANNEE_SUIVIE_KEY = "idiplAnneeSuivie";
	public static final String IDIPL_PASSAGE_CONDITIONNEL_KEY = "idiplPassageConditionnel";
	public static final String IDIPL_TYPE_INSCRIPTION_KEY = "idiplTypeInscription";
	public static final String NO_INDIVIDU_KEY = "noIndividu";

	public static final String ADR_CIVILITE_COLKEY = "ADR_CIVILITE";
	public static final String ADR_NOM_COLKEY = "ADR_NOM";
	public static final String ADR_PRENOM_COLKEY = "ADR_PRENOM";
	public static final String ETUD_CODE_INE_COLKEY = "ETUD_CODE_INE";
	public static final String ETUD_NUMERO_COLKEY = "ETUD_NUMERO";
	public static final String FDIP_ABREVIATION_COLKEY = "FDIP_ABREVIATION";
	public static final String FGRA_CODE_COLKEY = "FGRA_CODE";
	public static final String FORMATION_COLKEY = "formation";
	public static final String FSPN_LIBELLE_COLKEY = "FSPN_LIBELLE";
	public static final String IDENTITE_COLKEY = "identite";
	public static final String IDIPL_ANNEE_SUIVIE_COLKEY = "IDIPL_ANNEE_SUIVIE";
	public static final String IDIPL_PASSAGE_CONDITIONNEL_COLKEY = "IDIPL_PASSAGE_CONDITIONNEL";
	public static final String IDIPL_TYPE_INSCRIPTION_COLKEY = "IDIPL_TYPE_INSCRIPTION";
	public static final String NO_INDIVIDU_COLKEY = "NO_INDIVIDU";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_FORMATION_SPECIALISATION_KEY = "scolFormationSpecialisation";
	public static final String SCOL_INSCRIPTION_APS_KEY = "scolInscriptionAps";
	public static final String SCOL_INSCRIPTION_GRPS_KEY = "scolInscriptionGrps";
	public static final String SCOL_INSCRIPTION_SEMESTRES_KEY = "scolInscriptionSemestres";

	// Utilities methods
	  public ScolInscriptionEtudiant localInstanceIn(EOEditingContext editingContext) {
	    ScolInscriptionEtudiant localInstance = (ScolInscriptionEtudiant)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolInscriptionEtudiant getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionEtudiant.ENTITY_NAME);
		      return (ScolInscriptionEtudiant) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String adrCivilite() {
    return (String) storedValueForKey("adrCivilite");
  }

  public void setAdrCivilite(String value) {
    takeStoredValueForKey(value, "adrCivilite");
  }

  public String adrNom() {
    return (String) storedValueForKey("adrNom");
  }

  public void setAdrNom(String value) {
    takeStoredValueForKey(value, "adrNom");
  }

  public String adrPrenom() {
    return (String) storedValueForKey("adrPrenom");
  }

  public void setAdrPrenom(String value) {
    takeStoredValueForKey(value, "adrPrenom");
  }

  public String etudCodeIne() {
    return (String) storedValueForKey("etudCodeIne");
  }

  public void setEtudCodeIne(String value) {
    takeStoredValueForKey(value, "etudCodeIne");
  }

  public Long etudNumero() {
    return (Long) storedValueForKey("etudNumero");
  }

  public void setEtudNumero(Long value) {
    takeStoredValueForKey(value, "etudNumero");
  }

  public String fdipAbreviation() {
    return (String) storedValueForKey("fdipAbreviation");
  }

  public void setFdipAbreviation(String value) {
    takeStoredValueForKey(value, "fdipAbreviation");
  }

  public String fgraCode() {
    return (String) storedValueForKey("fgraCode");
  }

  public void setFgraCode(String value) {
    takeStoredValueForKey(value, "fgraCode");
  }

  public String formation() {
    return (String) storedValueForKey("formation");
  }

  public void setFormation(String value) {
    takeStoredValueForKey(value, "formation");
  }

  public String fspnLibelle() {
    return (String) storedValueForKey("fspnLibelle");
  }

  public void setFspnLibelle(String value) {
    takeStoredValueForKey(value, "fspnLibelle");
  }

  public String identite() {
    return (String) storedValueForKey("identite");
  }

  public void setIdentite(String value) {
    takeStoredValueForKey(value, "identite");
  }

  public Long idiplAnneeSuivie() {
    return (Long) storedValueForKey("idiplAnneeSuivie");
  }

  public void setIdiplAnneeSuivie(Long value) {
    takeStoredValueForKey(value, "idiplAnneeSuivie");
  }

  public String idiplPassageConditionnel() {
    return (String) storedValueForKey("idiplPassageConditionnel");
  }

  public void setIdiplPassageConditionnel(String value) {
    takeStoredValueForKey(value, "idiplPassageConditionnel");
  }

  public Long idiplTypeInscription() {
    return (Long) storedValueForKey("idiplTypeInscription");
  }

  public void setIdiplTypeInscription(Long value) {
    takeStoredValueForKey(value, "idiplTypeInscription");
  }

  public Long noIndividu() {
    return (Long) storedValueForKey("noIndividu");
  }

  public void setNoIndividu(Long value) {
    takeStoredValueForKey(value, "noIndividu");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation scolFormationSpecialisation() {
    return (org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation)storedValueForKey("scolFormationSpecialisation");
  }

  public void setScolFormationSpecialisationRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation oldValue = scolFormationSpecialisation();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationSpecialisation");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationSpecialisation");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolInscriptionAp.SCOL_INSCRIPTION_ETUDIANT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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

  public NSArray scolInscriptionGrps() {
    return (NSArray)storedValueForKey("scolInscriptionGrps");
  }

  public NSArray scolInscriptionGrps(EOQualifier qualifier) {
    return scolInscriptionGrps(qualifier, null, false);
  }

  public NSArray scolInscriptionGrps(EOQualifier qualifier, boolean fetch) {
    return scolInscriptionGrps(qualifier, null, fetch);
  }

  public NSArray scolInscriptionGrps(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp.SCOL_INSCRIPTION_ETUDIANT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp.fetchScolInscriptionGrps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolInscriptionGrps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolInscriptionGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public void removeFromScolInscriptionGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp createScolInscriptionGrpsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionGrps");
    return (org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp) eo;
  }

  public void deleteScolInscriptionGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionGrpsRelationships() {
    Enumeration objects = scolInscriptionGrps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionGrpsRelationship((org.cocktail.groupescol.serveur.eof.ScolInscriptionGrp)objects.nextElement());
    }
  }

  public NSArray scolInscriptionSemestres() {
    return (NSArray)storedValueForKey("scolInscriptionSemestres");
  }

  public NSArray scolInscriptionSemestres(EOQualifier qualifier) {
    return scolInscriptionSemestres(qualifier, null, false);
  }

  public NSArray scolInscriptionSemestres(EOQualifier qualifier, boolean fetch) {
    return scolInscriptionSemestres(qualifier, null, fetch);
  }

  public NSArray scolInscriptionSemestres(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre.SCOL_INSCRIPTION_ETUDIANT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre.fetchScolInscriptionSemestres(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolInscriptionSemestres();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolInscriptionSemestresRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionSemestres");
  }

  public void removeFromScolInscriptionSemestresRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionSemestres");
  }

  public org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre createScolInscriptionSemestresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionSemestre");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionSemestres");
    return (org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre) eo;
  }

  public void deleteScolInscriptionSemestresRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionSemestres");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionSemestresRelationships() {
    Enumeration objects = scolInscriptionSemestres().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionSemestresRelationship((org.cocktail.groupescol.serveur.eof.ScolInscriptionSemestre)objects.nextElement());
    }
  }


  public static ScolInscriptionEtudiant createScolInscriptionEtudiant(EOEditingContext editingContext, Long etudNumero
, String formation
, String idiplPassageConditionnel
) {
    ScolInscriptionEtudiant eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionEtudiant.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolInscriptionEtudiant.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolInscriptionEtudiant) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setEtudNumero(etudNumero);
		eo.setFormation(formation);
		eo.setIdiplPassageConditionnel(idiplPassageConditionnel);
    return eo;
  }

  public static NSArray fetchAllScolInscriptionEtudiants(EOEditingContext editingContext) {
    return _ScolInscriptionEtudiant.fetchAllScolInscriptionEtudiants(editingContext, null);
  }

  public static NSArray fetchAllScolInscriptionEtudiants(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolInscriptionEtudiant.fetchScolInscriptionEtudiants(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolInscriptionEtudiants(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolInscriptionEtudiant.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolInscriptionEtudiant fetchScolInscriptionEtudiant(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionEtudiant.fetchScolInscriptionEtudiant(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionEtudiant fetchScolInscriptionEtudiant(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolInscriptionEtudiant.fetchScolInscriptionEtudiants(editingContext, qualifier, null);
    ScolInscriptionEtudiant eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolInscriptionEtudiant)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolInscriptionEtudiant that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionEtudiant fetchRequiredScolInscriptionEtudiant(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionEtudiant.fetchRequiredScolInscriptionEtudiant(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionEtudiant fetchRequiredScolInscriptionEtudiant(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolInscriptionEtudiant eoObject = _ScolInscriptionEtudiant.fetchScolInscriptionEtudiant(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolInscriptionEtudiant that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionEtudiant localInstanceIn(EOEditingContext editingContext, ScolInscriptionEtudiant eo) {
    ScolInscriptionEtudiant localInstance = (eo == null) ? null : (ScolInscriptionEtudiant)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
