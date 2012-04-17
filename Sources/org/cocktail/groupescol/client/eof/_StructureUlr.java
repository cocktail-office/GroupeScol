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

// DO NOT EDIT.  Make changes to StructureUlr.java instead.
package org.cocktail.groupescol.client.eof;

import java.util.Enumeration;
import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public abstract class _StructureUlr extends  EOGenericRecord {
	public static final String ENTITY_NAME = "StructureUlr";
	public static final String ENTITY_TABLE_NAME = "GRHUM.STRUCTURE_ULR";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "cStructure";

	public static final String C_TYPE_STRUCTURE_KEY = "cTypeStructure";
	public static final String GRP_ACCES_KEY = "grpAcces";
	public static final String GRP_ALIAS_KEY = "grpAlias";
	public static final String GRP_MOTS_CLEFS_KEY = "grpMotsClefs";
	public static final String GRP_RESPONSABILITE_KEY = "grpResponsabilite";
	public static final String LC_STRUCTURE_KEY = "lcStructure";
	public static final String LL_STRUCTURE_KEY = "llStructure";
	public static final String PERS_ID_KEY = "persId";
	public static final String TEM_VALIDE_KEY = "temValide";

	public static final String C_TYPE_STRUCTURE_COLKEY = "C_TYPE_STRUCTURE";
	public static final String GRP_ACCES_COLKEY = "GRP_ACCES";
	public static final String GRP_ALIAS_COLKEY = "GRP_ALIAS";
	public static final String GRP_MOTS_CLEFS_COLKEY = "GRP_MOTS_CLEFS";
	public static final String GRP_RESPONSABILITE_COLKEY = "GRP_RESPONSABILITE";
	public static final String LC_STRUCTURE_COLKEY = "LC_STRUCTURE";
	public static final String LL_STRUCTURE_COLKEY = "LL_STRUCTURE";
	public static final String PERS_ID_COLKEY = "PERS_ID";
	public static final String TEM_VALIDE_COLKEY = "TEM_VALIDE";

	// Relationships
	public static final String REPART_STRUCTURES_KEY = "repartStructures";
	public static final String RESPONSABLE_KEY = "responsable";

	// Utilities methods
	  public StructureUlr localInstanceIn(EOEditingContext editingContext) {
	    StructureUlr localInstance = (StructureUlr)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static StructureUlr getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_StructureUlr.ENTITY_NAME);
		      return (StructureUlr) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String cTypeStructure() {
    return (String) storedValueForKey("cTypeStructure");
  }

  public void setCTypeStructure(String value) {
    takeStoredValueForKey(value, "cTypeStructure");
  }

  public String grpAcces() {
    return (String) storedValueForKey("grpAcces");
  }

  public void setGrpAcces(String value) {
    takeStoredValueForKey(value, "grpAcces");
  }

  public String grpAlias() {
    return (String) storedValueForKey("grpAlias");
  }

  public void setGrpAlias(String value) {
    takeStoredValueForKey(value, "grpAlias");
  }

  public String grpMotsClefs() {
    return (String) storedValueForKey("grpMotsClefs");
  }

  public void setGrpMotsClefs(String value) {
    takeStoredValueForKey(value, "grpMotsClefs");
  }

  public String grpResponsabilite() {
    return (String) storedValueForKey("grpResponsabilite");
  }

  public void setGrpResponsabilite(String value) {
    takeStoredValueForKey(value, "grpResponsabilite");
  }

  public String lcStructure() {
    return (String) storedValueForKey("lcStructure");
  }

  public void setLcStructure(String value) {
    takeStoredValueForKey(value, "lcStructure");
  }

  public String llStructure() {
    return (String) storedValueForKey("llStructure");
  }

  public void setLlStructure(String value) {
    takeStoredValueForKey(value, "llStructure");
  }

  public Double persId() {
    return (Double) storedValueForKey("persId");
  }

  public void setPersId(Double value) {
    takeStoredValueForKey(value, "persId");
  }

  public String temValide() {
    return (String) storedValueForKey("temValide");
  }

  public void setTemValide(String value) {
    takeStoredValueForKey(value, "temValide");
  }

  public org.cocktail.groupescol.client.eof.IndividuUlr responsable() {
    return (org.cocktail.groupescol.client.eof.IndividuUlr)storedValueForKey("responsable");
  }

  public void setResponsableRelationship(org.cocktail.groupescol.client.eof.IndividuUlr value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.IndividuUlr oldValue = responsable();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "responsable");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "responsable");
    }
  }
  
  public NSArray repartStructures() {
    return (NSArray)storedValueForKey("repartStructures");
  }

  public NSArray repartStructures(EOQualifier qualifier) {
    return repartStructures(qualifier, null);
  }

  public NSArray repartStructures(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = repartStructures();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToRepartStructuresRelationship(org.cocktail.groupescol.client.eof.RepartStructure object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "repartStructures");
  }

  public void removeFromRepartStructuresRelationship(org.cocktail.groupescol.client.eof.RepartStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "repartStructures");
  }

  public org.cocktail.groupescol.client.eof.RepartStructure createRepartStructuresRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("RepartStructure");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "repartStructures");
    return (org.cocktail.groupescol.client.eof.RepartStructure) eo;
  }

  public void deleteRepartStructuresRelationship(org.cocktail.groupescol.client.eof.RepartStructure object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "repartStructures");
    editingContext().deleteObject(object);
  }

  public void deleteAllRepartStructuresRelationships() {
    Enumeration objects = repartStructures().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteRepartStructuresRelationship((org.cocktail.groupescol.client.eof.RepartStructure)objects.nextElement());
    }
  }


  public static StructureUlr createStructureUlr(EOEditingContext editingContext, String cTypeStructure
, Double persId
, String temValide
) {
    StructureUlr eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_StructureUlr.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _StructureUlr.ENTITY_NAME + "' !");
    } else
    {
        eo = (StructureUlr) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setCTypeStructure(cTypeStructure);
		eo.setPersId(persId);
		eo.setTemValide(temValide);
    return eo;
  }

  public static NSArray fetchAllStructureUlrs(EOEditingContext editingContext) {
    return _StructureUlr.fetchAllStructureUlrs(editingContext, null);
  }

  public static NSArray fetchAllStructureUlrs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _StructureUlr.fetchStructureUlrs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchStructureUlrs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_StructureUlr.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static StructureUlr fetchStructureUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _StructureUlr.fetchStructureUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static StructureUlr fetchStructureUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _StructureUlr.fetchStructureUlrs(editingContext, qualifier, null);
    StructureUlr eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (StructureUlr)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one StructureUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static StructureUlr fetchRequiredStructureUlr(EOEditingContext editingContext, String keyName, Object value) {
    return _StructureUlr.fetchRequiredStructureUlr(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static StructureUlr fetchRequiredStructureUlr(EOEditingContext editingContext, EOQualifier qualifier) {
    StructureUlr eoObject = _StructureUlr.fetchStructureUlr(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no StructureUlr that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static StructureUlr localInstanceIn(EOEditingContext editingContext, StructureUlr eo) {
    StructureUlr localInstance = (eo == null) ? null : (StructureUlr)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
