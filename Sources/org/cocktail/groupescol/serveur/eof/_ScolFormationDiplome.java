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

// DO NOT EDIT.  Make changes to ScolFormationDiplome.java instead.
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

public abstract class _ScolFormationDiplome extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationDiplome";
	public static final String ENTITY_TABLE_NAME = "SCOL_FORMATION_DIPLOME";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "fdipCode";

	public static final String COMP_CODE_KEY = "compCode";
	public static final String ETAB_CODE_KEY = "etabCode";
	public static final String FDIP_ABREVIATION_KEY = "fdipAbreviation";
	public static final String FDIP_ARRIVEE_KEY = "fdipArrivee";
	public static final String FDIP_CYCLE_KEY = "fdipCycle";
	public static final String FDIP_DEPART_KEY = "fdipDepart";
	public static final String FDIP_LIBELLE_KEY = "fdipLibelle";
	public static final String FDIP_MENTION_KEY = "fdipMention";
	public static final String FDIP_MODELE_KEY = "fdipModele";
	public static final String FDIP_SPECIALITE_KEY = "fdipSpecialite";
	public static final String FDIP_TYPE_KEY = "fdipType";
	public static final String FDIP_TYPE_DROIT_KEY = "fdipTypeDroit";
	public static final String FDOM_CODE_KEY = "fdomCode";
	public static final String FGRA_CODE_KEY = "fgraCode";
	public static final String FVOC_CODE_KEY = "fvocCode";
	public static final String SREMO_CODE_KEY = "sremoCode";

	public static final String COMP_CODE_COLKEY = "COMP_CODE";
	public static final String ETAB_CODE_COLKEY = "ETAB_CODE";
	public static final String FDIP_ABREVIATION_COLKEY = "FDIP_ABREVIATION";
	public static final String FDIP_ARRIVEE_COLKEY = "FDIP_ARRIVEE";
	public static final String FDIP_CYCLE_COLKEY = "FDIP_CYCLE";
	public static final String FDIP_DEPART_COLKEY = "FDIP_DEPART";
	public static final String FDIP_LIBELLE_COLKEY = "FDIP_LIBELLE";
	public static final String FDIP_MENTION_COLKEY = "FDIP_MENTION";
	public static final String FDIP_MODELE_COLKEY = "FDIP_MODELE";
	public static final String FDIP_SPECIALITE_COLKEY = "FDIP_SPECIALITE";
	public static final String FDIP_TYPE_COLKEY = "FDIP_TYPE";
	public static final String FDIP_TYPE_DROIT_COLKEY = "FDIP_TYPE_DROIT";
	public static final String FDOM_CODE_COLKEY = "FDOM_CODE";
	public static final String FGRA_CODE_COLKEY = "FGRA_CODE";
	public static final String FVOC_CODE_COLKEY = "FVOC_CODE";
	public static final String SREMO_CODE_COLKEY = "SREMO_CODE";

	// Relationships
	public static final String SCOL_FORMATION_SPECIALISATIONS_KEY = "scolFormationSpecialisations";

	// Utilities methods
	  public ScolFormationDiplome localInstanceIn(EOEditingContext editingContext) {
	    ScolFormationDiplome localInstance = (ScolFormationDiplome)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolFormationDiplome getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolFormationDiplome.ENTITY_NAME);
		      return (ScolFormationDiplome) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String compCode() {
    return (String) storedValueForKey("compCode");
  }

  public void setCompCode(String value) {
    takeStoredValueForKey(value, "compCode");
  }

  public String etabCode() {
    return (String) storedValueForKey("etabCode");
  }

  public void setEtabCode(String value) {
    takeStoredValueForKey(value, "etabCode");
  }

  public String fdipAbreviation() {
    return (String) storedValueForKey("fdipAbreviation");
  }

  public void setFdipAbreviation(String value) {
    takeStoredValueForKey(value, "fdipAbreviation");
  }

  public Long fdipArrivee() {
    return (Long) storedValueForKey("fdipArrivee");
  }

  public void setFdipArrivee(Long value) {
    takeStoredValueForKey(value, "fdipArrivee");
  }

  public Integer fdipCycle() {
    return (Integer) storedValueForKey("fdipCycle");
  }

  public void setFdipCycle(Integer value) {
    takeStoredValueForKey(value, "fdipCycle");
  }

  public Integer fdipDepart() {
    return (Integer) storedValueForKey("fdipDepart");
  }

  public void setFdipDepart(Integer value) {
    takeStoredValueForKey(value, "fdipDepart");
  }

  public String fdipLibelle() {
    return (String) storedValueForKey("fdipLibelle");
  }

  public void setFdipLibelle(String value) {
    takeStoredValueForKey(value, "fdipLibelle");
  }

  public String fdipMention() {
    return (String) storedValueForKey("fdipMention");
  }

  public void setFdipMention(String value) {
    takeStoredValueForKey(value, "fdipMention");
  }

  public String fdipModele() {
    return (String) storedValueForKey("fdipModele");
  }

  public void setFdipModele(String value) {
    takeStoredValueForKey(value, "fdipModele");
  }

  public String fdipSpecialite() {
    return (String) storedValueForKey("fdipSpecialite");
  }

  public void setFdipSpecialite(String value) {
    takeStoredValueForKey(value, "fdipSpecialite");
  }

  public String fdipType() {
    return (String) storedValueForKey("fdipType");
  }

  public void setFdipType(String value) {
    takeStoredValueForKey(value, "fdipType");
  }

  public String fdipTypeDroit() {
    return (String) storedValueForKey("fdipTypeDroit");
  }

  public void setFdipTypeDroit(String value) {
    takeStoredValueForKey(value, "fdipTypeDroit");
  }

  public String fdomCode() {
    return (String) storedValueForKey("fdomCode");
  }

  public void setFdomCode(String value) {
    takeStoredValueForKey(value, "fdomCode");
  }

  public String fgraCode() {
    return (String) storedValueForKey("fgraCode");
  }

  public void setFgraCode(String value) {
    takeStoredValueForKey(value, "fgraCode");
  }

  public String fvocCode() {
    return (String) storedValueForKey("fvocCode");
  }

  public void setFvocCode(String value) {
    takeStoredValueForKey(value, "fvocCode");
  }

  public String sremoCode() {
    return (String) storedValueForKey("sremoCode");
  }

  public void setSremoCode(String value) {
    takeStoredValueForKey(value, "sremoCode");
  }

  public NSArray scolFormationSpecialisations() {
    return (NSArray)storedValueForKey("scolFormationSpecialisations");
  }

  public NSArray scolFormationSpecialisations(EOQualifier qualifier) {
    return scolFormationSpecialisations(qualifier, null, false);
  }

  public NSArray scolFormationSpecialisations(EOQualifier qualifier, boolean fetch) {
    return scolFormationSpecialisations(qualifier, null, fetch);
  }

  public NSArray scolFormationSpecialisations(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation.SCOL_FORMATION_DIPLOME_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation.fetchScolFormationSpecialisations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolFormationSpecialisations();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolFormationSpecialisationsRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolFormationSpecialisations");
  }

  public void removeFromScolFormationSpecialisationsRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolFormationSpecialisations");
  }

  public org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation createScolFormationSpecialisationsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolFormationSpecialisation");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolFormationSpecialisations");
    return (org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation) eo;
  }

  public void deleteScolFormationSpecialisationsRelationship(org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolFormationSpecialisations");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolFormationSpecialisationsRelationships() {
    Enumeration objects = scolFormationSpecialisations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolFormationSpecialisationsRelationship((org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation)objects.nextElement());
    }
  }


  public static ScolFormationDiplome createScolFormationDiplome(EOEditingContext editingContext, String compCode
, String etabCode
, Long fdipArrivee
, Integer fdipCycle
, Integer fdipDepart
, String fdipLibelle
, String fdipMention
, String fdipType
, String fdipTypeDroit
, String fdomCode
, String fgraCode
, String fvocCode
) {
    ScolFormationDiplome eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolFormationDiplome.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolFormationDiplome.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolFormationDiplome) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setCompCode(compCode);
		eo.setEtabCode(etabCode);
		eo.setFdipArrivee(fdipArrivee);
		eo.setFdipCycle(fdipCycle);
		eo.setFdipDepart(fdipDepart);
		eo.setFdipLibelle(fdipLibelle);
		eo.setFdipMention(fdipMention);
		eo.setFdipType(fdipType);
		eo.setFdipTypeDroit(fdipTypeDroit);
		eo.setFdomCode(fdomCode);
		eo.setFgraCode(fgraCode);
		eo.setFvocCode(fvocCode);
    return eo;
  }

  public static NSArray fetchAllScolFormationDiplomes(EOEditingContext editingContext) {
    return _ScolFormationDiplome.fetchAllScolFormationDiplomes(editingContext, null);
  }

  public static NSArray fetchAllScolFormationDiplomes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolFormationDiplome.fetchScolFormationDiplomes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolFormationDiplomes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolFormationDiplome.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolFormationDiplome fetchScolFormationDiplome(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationDiplome.fetchScolFormationDiplome(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationDiplome fetchScolFormationDiplome(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolFormationDiplome.fetchScolFormationDiplomes(editingContext, qualifier, null);
    ScolFormationDiplome eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolFormationDiplome)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationDiplome that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationDiplome fetchRequiredScolFormationDiplome(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationDiplome.fetchRequiredScolFormationDiplome(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationDiplome fetchRequiredScolFormationDiplome(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolFormationDiplome eoObject = _ScolFormationDiplome.fetchScolFormationDiplome(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationDiplome that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationDiplome localInstanceIn(EOEditingContext editingContext, ScolFormationDiplome eo) {
    ScolFormationDiplome localInstance = (eo == null) ? null : (ScolFormationDiplome)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
