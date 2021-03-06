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

// DO NOT EDIT.  Make changes to PhotosEtudiantsOldGrhum.java instead.
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
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSTimestamp;

public abstract class _PhotosEtudiantsOldGrhum extends  EOGenericRecord {
	public static final String ENTITY_NAME = "PhotosEtudiantsOldGrhum";
	public static final String ENTITY_TABLE_NAME = "GRHUM.PHOTOS_ETUDIANTS_OLD_GRHUM";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "noIndividu";

	public static final String DATAS_PHOTO_KEY = "datasPhoto";
	public static final String DATE_PRISE_KEY = "datePrise";

	public static final String DATAS_PHOTO_COLKEY = "DATAS_PHOTO";
	public static final String DATE_PRISE_COLKEY = "DATE_PRISE";

	// Relationships
	public static final String SCOL_INSCRIPTION_ETUDIANTS_KEY = "scolInscriptionEtudiants";

	// Utilities methods
	  public PhotosEtudiantsOldGrhum localInstanceIn(EOEditingContext editingContext) {
	    PhotosEtudiantsOldGrhum localInstance = (PhotosEtudiantsOldGrhum)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static PhotosEtudiantsOldGrhum getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_PhotosEtudiantsOldGrhum.ENTITY_NAME);
		      return (PhotosEtudiantsOldGrhum) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public NSData datasPhoto() {
    return (NSData) storedValueForKey("datasPhoto");
  }

  public void setDatasPhoto(NSData value) {
    takeStoredValueForKey(value, "datasPhoto");
  }

  public NSTimestamp datePrise() {
    return (NSTimestamp) storedValueForKey("datePrise");
  }

  public void setDatePrise(NSTimestamp value) {
    takeStoredValueForKey(value, "datePrise");
  }

  public NSArray scolInscriptionEtudiants() {
    return (NSArray)storedValueForKey("scolInscriptionEtudiants");
  }

  public NSArray scolInscriptionEtudiants(EOQualifier qualifier) {
    return scolInscriptionEtudiants(qualifier, null);
  }

  public NSArray scolInscriptionEtudiants(EOQualifier qualifier, NSArray sortOrderings) {
    NSArray results;
      results = scolInscriptionEtudiants();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToScolInscriptionEtudiantsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolInscriptionEtudiants");
  }

  public void removeFromScolInscriptionEtudiantsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionEtudiants");
  }

  public org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant createScolInscriptionEtudiantsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolInscriptionEtudiant");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolInscriptionEtudiants");
    return (org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant) eo;
  }

  public void deleteScolInscriptionEtudiantsRelationship(org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolInscriptionEtudiants");
    editingContext().deleteObject(object);
  }

  public void deleteAllScolInscriptionEtudiantsRelationships() {
    Enumeration objects = scolInscriptionEtudiants().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolInscriptionEtudiantsRelationship((org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant)objects.nextElement());
    }
  }


  public static PhotosEtudiantsOldGrhum createPhotosEtudiantsOldGrhum(EOEditingContext editingContext) {
    PhotosEtudiantsOldGrhum eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_PhotosEtudiantsOldGrhum.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _PhotosEtudiantsOldGrhum.ENTITY_NAME + "' !");
    } else
    {
        eo = (PhotosEtudiantsOldGrhum) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
    return eo;
  }

  public static NSArray fetchAllPhotosEtudiantsOldGrhums(EOEditingContext editingContext) {
    return _PhotosEtudiantsOldGrhum.fetchAllPhotosEtudiantsOldGrhums(editingContext, null);
  }

  public static NSArray fetchAllPhotosEtudiantsOldGrhums(EOEditingContext editingContext, NSArray sortOrderings) {
    return _PhotosEtudiantsOldGrhum.fetchPhotosEtudiantsOldGrhums(editingContext, null, sortOrderings);
  }

  public static NSArray fetchPhotosEtudiantsOldGrhums(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_PhotosEtudiantsOldGrhum.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static PhotosEtudiantsOldGrhum fetchPhotosEtudiantsOldGrhum(EOEditingContext editingContext, String keyName, Object value) {
    return _PhotosEtudiantsOldGrhum.fetchPhotosEtudiantsOldGrhum(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PhotosEtudiantsOldGrhum fetchPhotosEtudiantsOldGrhum(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _PhotosEtudiantsOldGrhum.fetchPhotosEtudiantsOldGrhums(editingContext, qualifier, null);
    PhotosEtudiantsOldGrhum eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (PhotosEtudiantsOldGrhum)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one PhotosEtudiantsOldGrhum that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PhotosEtudiantsOldGrhum fetchRequiredPhotosEtudiantsOldGrhum(EOEditingContext editingContext, String keyName, Object value) {
    return _PhotosEtudiantsOldGrhum.fetchRequiredPhotosEtudiantsOldGrhum(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PhotosEtudiantsOldGrhum fetchRequiredPhotosEtudiantsOldGrhum(EOEditingContext editingContext, EOQualifier qualifier) {
    PhotosEtudiantsOldGrhum eoObject = _PhotosEtudiantsOldGrhum.fetchPhotosEtudiantsOldGrhum(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no PhotosEtudiantsOldGrhum that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PhotosEtudiantsOldGrhum localInstanceIn(EOEditingContext editingContext, PhotosEtudiantsOldGrhum eo) {
    PhotosEtudiantsOldGrhum localInstance = (eo == null) ? null : (PhotosEtudiantsOldGrhum)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
