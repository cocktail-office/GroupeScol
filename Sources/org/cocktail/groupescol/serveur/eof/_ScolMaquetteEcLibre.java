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

// DO NOT EDIT.  Make changes to ScolMaquetteEcLibre.java instead.
package org.cocktail.groupescol.serveur.eof;

import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public abstract class _ScolMaquetteEcLibre extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteEcLibre";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_EC_LIBRE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mecKey";

	public static final String FANN_KEY_KEY = "fannKey";
	public static final String MEC_KEY_KEY = "mecKey";

	public static final String FANN_KEY_COLKEY = "FANN_KEY";
	public static final String MEC_KEY_COLKEY = "MEC_KEY";

	// Relationships

	// Utilities methods
	  public ScolMaquetteEcLibre localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteEcLibre localInstance = (ScolMaquetteEcLibre)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteEcLibre getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteEcLibre.ENTITY_NAME);
		      return (ScolMaquetteEcLibre) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long fannKey() {
    return (Long) storedValueForKey("fannKey");
  }

  public void setFannKey(Long value) {
    takeStoredValueForKey(value, "fannKey");
  }

  public Long mecKey() {
    return (Long) storedValueForKey("mecKey");
  }

  public void setMecKey(Long value) {
    takeStoredValueForKey(value, "mecKey");
  }


  public static ScolMaquetteEcLibre createScolMaquetteEcLibre(EOEditingContext editingContext, Long fannKey
, Long mecKey
) {
    ScolMaquetteEcLibre eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteEcLibre.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteEcLibre.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteEcLibre) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setFannKey(fannKey);
		eo.setMecKey(mecKey);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteEcLibres(EOEditingContext editingContext) {
    return _ScolMaquetteEcLibre.fetchAllScolMaquetteEcLibres(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteEcLibres(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteEcLibre.fetchScolMaquetteEcLibres(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteEcLibres(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteEcLibre.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteEcLibre fetchScolMaquetteEcLibre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEcLibre.fetchScolMaquetteEcLibre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEcLibre fetchScolMaquetteEcLibre(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteEcLibre.fetchScolMaquetteEcLibres(editingContext, qualifier, null);
    ScolMaquetteEcLibre eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteEcLibre)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteEcLibre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEcLibre fetchRequiredScolMaquetteEcLibre(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteEcLibre.fetchRequiredScolMaquetteEcLibre(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteEcLibre fetchRequiredScolMaquetteEcLibre(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteEcLibre eoObject = _ScolMaquetteEcLibre.fetchScolMaquetteEcLibre(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteEcLibre that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteEcLibre localInstanceIn(EOEditingContext editingContext, ScolMaquetteEcLibre eo) {
    ScolMaquetteEcLibre localInstance = (eo == null) ? null : (ScolMaquetteEcLibre)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
