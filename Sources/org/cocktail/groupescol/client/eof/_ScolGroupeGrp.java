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

// DO NOT EDIT.  Make changes to ScolGroupeGrp.java instead.
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

public abstract class _ScolGroupeGrp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolGroupeGrp";
	public static final String ENTITY_TABLE_NAME = "SCOL_GROUPE_GRP";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "ggrpKey";

	public static final String GGRP_CODE_KEY = "ggrpCode";
	public static final String GGRP_DATE_DEBUT_KEY = "ggrpDateDebut";
	public static final String GGRP_DATE_FIN_KEY = "ggrpDateFin";
	public static final String GGRP_INT_CAPACITE_KEY = "ggrpIntCapacite";
	public static final String GGRP_LIBELLE_KEY = "ggrpLibelle";
	public static final String GGRP_MAX_CAPACITE_KEY = "ggrpMaxCapacite";
	public static final String GGRP_MAX_TEMOIN_KEY = "ggrpMaxTemoin";

	public static final String GGRP_CODE_COLKEY = "GGRP_CODE";
	public static final String GGRP_DATE_DEBUT_COLKEY = "GGRP_DATE_DEBUT";
	public static final String GGRP_DATE_FIN_COLKEY = "GGRP_DATE_FIN";
	public static final String GGRP_INT_CAPACITE_COLKEY = "GGRP_INT_CAPACITE";
	public static final String GGRP_LIBELLE_COLKEY = "GGRP_LIBELLE";
	public static final String GGRP_MAX_CAPACITE_COLKEY = "GGRP_MAX_CAPACITE";
	public static final String GGRP_MAX_TEMOIN_COLKEY = "GGRP_MAX_TEMOIN";

	// Relationships
	public static final String CTRL_PARAM_APS_KEY = "ctrlParamAps";
	public static final String GROUPE_INCOMPATIBILITE1_KEY = "groupeIncompatibilite1";
	public static final String GROUPE_INCOMPATIBILITE2_KEY = "groupeIncompatibilite2";
	public static final String INCLUS_FILS_KEY = "inclusFils";
	public static final String INCLUS_PERE_KEY = "inclusPere";
	public static final String NEW_GRP_KEY = "newGrp";
	public static final String OLD_GRP_KEY = "oldGrp";
	public static final String SCOL_GROUPE_COLLECTION_KEY = "scolGroupeCollection";
	public static final String SCOL_GROUPE_OBJETS_KEY = "scolGroupeObjets";
	public static final String SCOL_INSCRIPTION_GRPS_KEY = "scolInscriptionGrps";

	// Utilities methods
	  public ScolGroupeGrp localInstanceIn(EOEditingContext editingContext) {
	    ScolGroupeGrp localInstance = (ScolGroupeGrp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolGroupeGrp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolGroupeGrp.ENTITY_NAME);
		      return (ScolGroupeGrp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String ggrpCode() {
    return (String) storedValueForKey("ggrpCode");
  }

  public void setGgrpCode(String value) {
    takeStoredValueForKey(value, "ggrpCode");
  }

  public Integer ggrpDateDebut() {
    return (Integer) storedValueForKey("ggrpDateDebut");
  }

  public void setGgrpDateDebut(Integer value) {
    takeStoredValueForKey(value, "ggrpDateDebut");
  }

  public Integer ggrpDateFin() {
    return (Integer) storedValueForKey("ggrpDateFin");
  }

  public void setGgrpDateFin(Integer value) {
    takeStoredValueForKey(value, "ggrpDateFin");
  }

  public Integer ggrpIntCapacite() {
    return (Integer) storedValueForKey("ggrpIntCapacite");
  }

  public void setGgrpIntCapacite(Integer value) {
    takeStoredValueForKey(value, "ggrpIntCapacite");
  }

  public String ggrpLibelle() {
    return (String) storedValueForKey("ggrpLibelle");
  }

  public void setGgrpLibelle(String value) {
    takeStoredValueForKey(value, "ggrpLibelle");
  }

  public Integer ggrpMaxCapacite() {
    return (Integer) storedValueForKey("ggrpMaxCapacite");
  }

  public void setGgrpMaxCapacite(Integer value) {
    takeStoredValueForKey(value, "ggrpMaxCapacite");
  }

  public String ggrpMaxTemoin() {
    return (String) storedValueForKey("ggrpMaxTemoin");
  }

  public void setGgrpMaxTemoin(String value) {
    takeStoredValueForKey(value, "ggrpMaxTemoin");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeCollection scolGroupeCollection() {
    return (org.cocktail.groupescol.client.eof.ScolGroupeCollection)storedValueForKey("scolGroupeCollection");
  }

  public void setScolGroupeCollectionRelationship(org.cocktail.groupescol.client.eof.ScolGroupeCollection value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolGroupeCollection oldValue = scolGroupeCollection();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeCollection");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeCollection");
    }
  }
  
  public NSArray ctrlParamAps() {
    return (NSArray)storedValueForKey("ctrlParamAps");
  }

  public NSArray ctrlParamAps(EOQualifier qualifier) {
    return ctrlParamAps(qualifier, null);
  }

  public NSArray ctrlParamAps(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = ctrlParamAps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToCtrlParamApsRelationship(org.cocktail.groupescol.client.eof.CtrlParamAp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "ctrlParamAps");
  }

  public void removeFromCtrlParamApsRelationship(org.cocktail.groupescol.client.eof.CtrlParamAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamAps");
  }

  public org.cocktail.groupescol.client.eof.CtrlParamAp createCtrlParamApsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("CtrlParamAp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "ctrlParamAps");
    return (org.cocktail.groupescol.client.eof.CtrlParamAp) eo;
  }

  public void deleteCtrlParamApsRelationship(org.cocktail.groupescol.client.eof.CtrlParamAp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "ctrlParamAps");
    editingContext().deleteObject(object);
  }

  public void deleteAllCtrlParamApsRelationships() {
    Enumeration objects = ctrlParamAps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCtrlParamApsRelationship((org.cocktail.groupescol.client.eof.CtrlParamAp)objects.nextElement());
    }
  }

  public NSArray groupeIncompatibilite1() {
    return (NSArray)storedValueForKey("groupeIncompatibilite1");
  }

  public NSArray groupeIncompatibilite1(EOQualifier qualifier) {
    return groupeIncompatibilite1(qualifier, null, false);
  }

  public NSArray groupeIncompatibilite1(EOQualifier qualifier, boolean fetch) {
    return groupeIncompatibilite1(qualifier, null, fetch);
  }

  public NSArray groupeIncompatibilite1(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite.SCOL_GROUPE_GRP1_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilites(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = groupeIncompatibilite1();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToGroupeIncompatibilite1Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite1");
  }

  public void removeFromGroupeIncompatibilite1Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite1");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite createGroupeIncompatibilite1Relationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeIncompatibilite");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "groupeIncompatibilite1");
    return (org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite) eo;
  }

  public void deleteGroupeIncompatibilite1Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite1");
    editingContext().deleteObject(object);
  }

  public void deleteAllGroupeIncompatibilite1Relationships() {
    Enumeration objects = groupeIncompatibilite1().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteGroupeIncompatibilite1Relationship((org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite)objects.nextElement());
    }
  }

  public NSArray groupeIncompatibilite2() {
    return (NSArray)storedValueForKey("groupeIncompatibilite2");
  }

  public NSArray groupeIncompatibilite2(EOQualifier qualifier) {
    return groupeIncompatibilite2(qualifier, null, false);
  }

  public NSArray groupeIncompatibilite2(EOQualifier qualifier, boolean fetch) {
    return groupeIncompatibilite2(qualifier, null, fetch);
  }

  public NSArray groupeIncompatibilite2(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite.SCOL_GROUPE_GRP2_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite.fetchScolGroupeIncompatibilites(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = groupeIncompatibilite2();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToGroupeIncompatibilite2Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite2");
  }

  public void removeFromGroupeIncompatibilite2Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite2");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite createGroupeIncompatibilite2Relationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeIncompatibilite");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "groupeIncompatibilite2");
    return (org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite) eo;
  }

  public void deleteGroupeIncompatibilite2Relationship(org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "groupeIncompatibilite2");
    editingContext().deleteObject(object);
  }

  public void deleteAllGroupeIncompatibilite2Relationships() {
    Enumeration objects = groupeIncompatibilite2().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteGroupeIncompatibilite2Relationship((org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite)objects.nextElement());
    }
  }

  public NSArray inclusFils() {
    return (NSArray)storedValueForKey("inclusFils");
  }

  public NSArray inclusFils(EOQualifier qualifier) {
    return inclusFils(qualifier, null, false);
  }

  public NSArray inclusFils(EOQualifier qualifier, boolean fetch) {
    return inclusFils(qualifier, null, fetch);
  }

  public NSArray inclusFils(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeInclusion.SCOL_GROUPE_GRP_PERE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolGroupeInclusion.fetchScolGroupeInclusions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = inclusFils();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToInclusFilsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "inclusFils");
  }

  public void removeFromInclusFilsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "inclusFils");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeInclusion createInclusFilsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeInclusion");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "inclusFils");
    return (org.cocktail.groupescol.client.eof.ScolGroupeInclusion) eo;
  }

  public void deleteInclusFilsRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "inclusFils");
    editingContext().deleteObject(object);
  }

  public void deleteAllInclusFilsRelationships() {
    Enumeration objects = inclusFils().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInclusFilsRelationship((org.cocktail.groupescol.client.eof.ScolGroupeInclusion)objects.nextElement());
    }
  }

  public NSArray inclusPere() {
    return (NSArray)storedValueForKey("inclusPere");
  }

  public NSArray inclusPere(EOQualifier qualifier) {
    return inclusPere(qualifier, null, false);
  }

  public NSArray inclusPere(EOQualifier qualifier, boolean fetch) {
    return inclusPere(qualifier, null, fetch);
  }

  public NSArray inclusPere(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeInclusion.SCOL_GROUPE_GRP_FILS_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolGroupeInclusion.fetchScolGroupeInclusions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = inclusPere();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToInclusPereRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "inclusPere");
  }

  public void removeFromInclusPereRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "inclusPere");
  }

  public org.cocktail.groupescol.client.eof.ScolGroupeInclusion createInclusPereRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeInclusion");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "inclusPere");
    return (org.cocktail.groupescol.client.eof.ScolGroupeInclusion) eo;
  }

  public void deleteInclusPereRelationship(org.cocktail.groupescol.client.eof.ScolGroupeInclusion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "inclusPere");
    editingContext().deleteObject(object);
  }

  public void deleteAllInclusPereRelationships() {
    Enumeration objects = inclusPere().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInclusPereRelationship((org.cocktail.groupescol.client.eof.ScolGroupeInclusion)objects.nextElement());
    }
  }

  public NSArray newGrp() {
    return (NSArray)storedValueForKey("newGrp");
  }

  public NSArray newGrp(EOQualifier qualifier) {
    return newGrp(qualifier, null, false);
  }

  public NSArray newGrp(EOQualifier qualifier, boolean fetch) {
    return newGrp(qualifier, null, fetch);
  }

  public NSArray newGrp(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolTransfertGrp.NEW_GRP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolTransfertGrp.fetchScolTransfertGrps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = newGrp();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToNewGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "newGrp");
  }

  public void removeFromNewGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "newGrp");
  }

  public org.cocktail.groupescol.client.eof.ScolTransfertGrp createNewGrpRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolTransfertGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "newGrp");
    return (org.cocktail.groupescol.client.eof.ScolTransfertGrp) eo;
  }

  public void deleteNewGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "newGrp");
    editingContext().deleteObject(object);
  }

  public void deleteAllNewGrpRelationships() {
    Enumeration objects = newGrp().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteNewGrpRelationship((org.cocktail.groupescol.client.eof.ScolTransfertGrp)objects.nextElement());
    }
  }

  public NSArray oldGrp() {
    return (NSArray)storedValueForKey("oldGrp");
  }

  public NSArray oldGrp(EOQualifier qualifier) {
    return oldGrp(qualifier, null, false);
  }

  public NSArray oldGrp(EOQualifier qualifier, boolean fetch) {
    return oldGrp(qualifier, null, fetch);
  }

  public NSArray oldGrp(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolTransfertGrp.OLD_GRP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolTransfertGrp.fetchScolTransfertGrps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = oldGrp();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToOldGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "oldGrp");
  }

  public void removeFromOldGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "oldGrp");
  }

  public org.cocktail.groupescol.client.eof.ScolTransfertGrp createOldGrpRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolTransfertGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "oldGrp");
    return (org.cocktail.groupescol.client.eof.ScolTransfertGrp) eo;
  }

  public void deleteOldGrpRelationship(org.cocktail.groupescol.client.eof.ScolTransfertGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "oldGrp");
    editingContext().deleteObject(object);
  }

  public void deleteAllOldGrpRelationships() {
    Enumeration objects = oldGrp().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteOldGrpRelationship((org.cocktail.groupescol.client.eof.ScolTransfertGrp)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolGroupeObjet.SCOL_GROUPE_GRP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
  }

  public void deleteAllScolGroupeObjetsRelationships() {
    Enumeration objects = scolGroupeObjets().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolGroupeObjetsRelationship((org.cocktail.groupescol.client.eof.ScolGroupeObjet)objects.nextElement());
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolInscriptionGrp.SCOL_GROUPE_GRP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolInscriptionGrp.fetchScolInscriptionGrps(editingContext(), fullQualifier, sortOrderings);
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
  
  public void addToScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public void removeFromScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
  }

  public org.cocktail.groupescol.client.eof.ScolInscriptionGrp createScolInscriptionGrpsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionGrps");
    return (org.cocktail.groupescol.client.eof.ScolInscriptionGrp) eo;
  }

  public void deleteScolInscriptionGrpsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionGrps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionGrpsRelationships() {
    Enumeration objects = scolInscriptionGrps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionGrpsRelationship((org.cocktail.groupescol.client.eof.ScolInscriptionGrp)objects.nextElement());
    }
  }


  public static ScolGroupeGrp createScolGroupeGrp(EOEditingContext editingContext, String ggrpCode
, Integer ggrpDateDebut
, String ggrpMaxTemoin
) {
    ScolGroupeGrp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolGroupeGrp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolGroupeGrp.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolGroupeGrp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setGgrpCode(ggrpCode);
		eo.setGgrpDateDebut(ggrpDateDebut);
		eo.setGgrpMaxTemoin(ggrpMaxTemoin);
    return eo;
  }

  public static NSArray fetchAllScolGroupeGrps(EOEditingContext editingContext) {
    return _ScolGroupeGrp.fetchAllScolGroupeGrps(editingContext, null);
  }

  public static NSArray fetchAllScolGroupeGrps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolGroupeGrp.fetchScolGroupeGrps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolGroupeGrps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolGroupeGrp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolGroupeGrp fetchScolGroupeGrp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeGrp.fetchScolGroupeGrp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeGrp fetchScolGroupeGrp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolGroupeGrp.fetchScolGroupeGrps(editingContext, qualifier, null);
    ScolGroupeGrp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolGroupeGrp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolGroupeGrp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeGrp fetchRequiredScolGroupeGrp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeGrp.fetchRequiredScolGroupeGrp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeGrp fetchRequiredScolGroupeGrp(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolGroupeGrp eoObject = _ScolGroupeGrp.fetchScolGroupeGrp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolGroupeGrp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeGrp localInstanceIn(EOEditingContext editingContext, ScolGroupeGrp eo) {
    ScolGroupeGrp localInstance = (eo == null) ? null : (ScolGroupeGrp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
