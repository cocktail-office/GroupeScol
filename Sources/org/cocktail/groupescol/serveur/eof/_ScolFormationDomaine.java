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

// DO NOT EDIT.  Make changes to ScolFormationDomaine.java instead.
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

public abstract class _ScolFormationDomaine extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolFormationDomaine";
	public static final String ENTITY_TABLE_NAME = "SCOL_FORMATION_DOMAINE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "fdomCode";

	public static final String FDOM_ABREVIATION_KEY = "fdomAbreviation";
	public static final String FDOM_LIBELLE_KEY = "fdomLibelle";
	public static final String FDOM_TYPE_KEY = "fdomType";
	public static final String FDOM_VALIDITE_KEY = "fdomValidite";

	public static final String FDOM_ABREVIATION_COLKEY = "FDOM_ABREVIATION";
	public static final String FDOM_LIBELLE_COLKEY = "FDOM_LIBELLE";
	public static final String FDOM_TYPE_COLKEY = "FDOM_TYPE";
	public static final String FDOM_VALIDITE_COLKEY = "FDOM_VALIDITE";

	// Relationships
	public static final String SCOL_MAQUETTE_UES_KEY = "scolMaquetteUes";

	// Utilities methods
	  public ScolFormationDomaine localInstanceIn(EOEditingContext editingContext) {
	    ScolFormationDomaine localInstance = (ScolFormationDomaine)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolFormationDomaine getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolFormationDomaine.ENTITY_NAME);
		      return (ScolFormationDomaine) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String fdomAbreviation() {
    return (String) storedValueForKey("fdomAbreviation");
  }

  public void setFdomAbreviation(String value) {
    takeStoredValueForKey(value, "fdomAbreviation");
  }

  public String fdomLibelle() {
    return (String) storedValueForKey("fdomLibelle");
  }

  public void setFdomLibelle(String value) {
    takeStoredValueForKey(value, "fdomLibelle");
  }

  public String fdomType() {
    return (String) storedValueForKey("fdomType");
  }

  public void setFdomType(String value) {
    takeStoredValueForKey(value, "fdomType");
  }

  public String fdomValidite() {
    return (String) storedValueForKey("fdomValidite");
  }

  public void setFdomValidite(String value) {
    takeStoredValueForKey(value, "fdomValidite");
  }

  public NSArray scolMaquetteUes() {
    return (NSArray)storedValueForKey("scolMaquetteUes");
  }

  public NSArray scolMaquetteUes(EOQualifier qualifier) {
    return scolMaquetteUes(qualifier, null, false);
  }

  public NSArray scolMaquetteUes(EOQualifier qualifier, boolean fetch) {
    return scolMaquetteUes(qualifier, null, fetch);
  }

  public NSArray scolMaquetteUes(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolMaquetteUe.SCOL_FORMATION_DOMAINE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolMaquetteUe.fetchScolMaquetteUes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolMaquetteUes();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolMaquetteUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteUe object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolMaquetteUes");
  }

  public void removeFromScolMaquetteUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteUes");
  }

  public org.cocktail.groupescol.serveur.eof.ScolMaquetteUe createScolMaquetteUesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolMaquetteUe");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolMaquetteUes");
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteUe) eo;
  }

  public void deleteScolMaquetteUesRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteUe object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolMaquetteUes");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolMaquetteUesRelationships() {
    Enumeration objects = scolMaquetteUes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolMaquetteUesRelationship((org.cocktail.groupescol.serveur.eof.ScolMaquetteUe)objects.nextElement());
    }
  }


  public static ScolFormationDomaine createScolFormationDomaine(EOEditingContext editingContext, String fdomLibelle
, String fdomType
, String fdomValidite
) {
    ScolFormationDomaine eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolFormationDomaine.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolFormationDomaine.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolFormationDomaine) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setFdomLibelle(fdomLibelle);
		eo.setFdomType(fdomType);
		eo.setFdomValidite(fdomValidite);
    return eo;
  }

  public static NSArray fetchAllScolFormationDomaines(EOEditingContext editingContext) {
    return _ScolFormationDomaine.fetchAllScolFormationDomaines(editingContext, null);
  }

  public static NSArray fetchAllScolFormationDomaines(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolFormationDomaine.fetchScolFormationDomaines(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolFormationDomaines(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolFormationDomaine.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolFormationDomaine fetchScolFormationDomaine(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationDomaine.fetchScolFormationDomaine(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationDomaine fetchScolFormationDomaine(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolFormationDomaine.fetchScolFormationDomaines(editingContext, qualifier, null);
    ScolFormationDomaine eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolFormationDomaine)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolFormationDomaine that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationDomaine fetchRequiredScolFormationDomaine(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolFormationDomaine.fetchRequiredScolFormationDomaine(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolFormationDomaine fetchRequiredScolFormationDomaine(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolFormationDomaine eoObject = _ScolFormationDomaine.fetchScolFormationDomaine(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolFormationDomaine that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolFormationDomaine localInstanceIn(EOEditingContext editingContext, ScolFormationDomaine eo) {
    ScolFormationDomaine localInstance = (eo == null) ? null : (ScolFormationDomaine)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
