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

// DO NOT EDIT.  Make changes to ScolGroupeCollection.java instead.
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

public abstract class _ScolGroupeCollection extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolGroupeCollection";
	public static final String ENTITY_TABLE_NAME = "SCOL_GROUPE_COLLECTION";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "gcolKey";

	public static final String GCOL_DATE_DEBUT_KEY = "gcolDateDebut";
	public static final String GCOL_DATE_FIN_KEY = "gcolDateFin";
	public static final String GCOL_LIBELLE_KEY = "gcolLibelle";

	public static final String GCOL_DATE_DEBUT_COLKEY = "GCOL_DATE_DEBUT";
	public static final String GCOL_DATE_FIN_COLKEY = "GCOL_DATE_FIN";
	public static final String GCOL_LIBELLE_COLKEY = "GCOL_LIBELLE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_GROUPE_GRPS_KEY = "scolGroupeGrps";

	// Utilities methods
	  public ScolGroupeCollection localInstanceIn(EOEditingContext editingContext) {
	    ScolGroupeCollection localInstance = (ScolGroupeCollection)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolGroupeCollection getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolGroupeCollection.ENTITY_NAME);
		      return (ScolGroupeCollection) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Integer gcolDateDebut() {
    return (Integer) storedValueForKey("gcolDateDebut");
  }

  public void setGcolDateDebut(Integer value) {
    takeStoredValueForKey(value, "gcolDateDebut");
  }

  public Integer gcolDateFin() {
    return (Integer) storedValueForKey("gcolDateFin");
  }

  public void setGcolDateFin(Integer value) {
    takeStoredValueForKey(value, "gcolDateFin");
  }

  public String gcolLibelle() {
    return (String) storedValueForKey("gcolLibelle");
  }

  public void setGcolLibelle(String value) {
    takeStoredValueForKey(value, "gcolLibelle");
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
  
  public NSArray scolGroupeGrps() {
    return (NSArray)storedValueForKey("scolGroupeGrps");
  }

  public NSArray scolGroupeGrps(EOQualifier qualifier) {
    return scolGroupeGrps(qualifier, null, false);
  }

  public NSArray scolGroupeGrps(EOQualifier qualifier, boolean fetch) {
    return scolGroupeGrps(qualifier, null, fetch);
  }

  public NSArray scolGroupeGrps(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp.SCOL_GROUPE_COLLECTION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.serveur.eof.ScolGroupeGrp.fetchScolGroupeGrps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolGroupeGrps();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolGroupeGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolGroupeGrps");
  }

  public void removeFromScolGroupeGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolGroupeGrps");
  }

  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp createScolGroupeGrpsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolGroupeGrp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolGroupeGrps");
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp) eo;
  }

  public void deleteScolGroupeGrpsRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolGroupeGrps");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolGroupeGrpsRelationships() {
    Enumeration objects = scolGroupeGrps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolGroupeGrpsRelationship((org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)objects.nextElement());
    }
  }


  public static ScolGroupeCollection createScolGroupeCollection(EOEditingContext editingContext, Integer gcolDateDebut
, String gcolLibelle
) {
    ScolGroupeCollection eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolGroupeCollection.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolGroupeCollection.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolGroupeCollection) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setGcolDateDebut(gcolDateDebut);
		eo.setGcolLibelle(gcolLibelle);
    return eo;
  }

  public static NSArray fetchAllScolGroupeCollections(EOEditingContext editingContext) {
    return _ScolGroupeCollection.fetchAllScolGroupeCollections(editingContext, null);
  }

  public static NSArray fetchAllScolGroupeCollections(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolGroupeCollection.fetchScolGroupeCollections(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolGroupeCollections(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolGroupeCollection.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolGroupeCollection fetchScolGroupeCollection(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeCollection.fetchScolGroupeCollection(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeCollection fetchScolGroupeCollection(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolGroupeCollection.fetchScolGroupeCollections(editingContext, qualifier, null);
    ScolGroupeCollection eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolGroupeCollection)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolGroupeCollection that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeCollection fetchRequiredScolGroupeCollection(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolGroupeCollection.fetchRequiredScolGroupeCollection(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolGroupeCollection fetchRequiredScolGroupeCollection(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolGroupeCollection eoObject = _ScolGroupeCollection.fetchScolGroupeCollection(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolGroupeCollection that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolGroupeCollection localInstanceIn(EOEditingContext editingContext, ScolGroupeCollection eo) {
    ScolGroupeCollection localInstance = (eo == null) ? null : (ScolGroupeCollection)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
