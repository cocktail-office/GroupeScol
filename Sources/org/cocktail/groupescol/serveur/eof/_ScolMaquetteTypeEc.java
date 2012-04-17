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

// DO NOT EDIT.  Make changes to ScolMaquetteTypeEc.java instead.
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

public abstract class _ScolMaquetteTypeEc extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteTypeEc";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_TYPE_EC";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mtecCode";

	public static final String MTEC_ABREVIATION_KEY = "mtecAbreviation";
	public static final String MTEC_CHOIX_KEY = "mtecChoix";
	public static final String MTEC_CODE_KEY = "mtecCode";
	public static final String MTEC_LIBELLE_KEY = "mtecLibelle";

	public static final String MTEC_ABREVIATION_COLKEY = "MTEC_ABREVIATION";
	public static final String MTEC_CHOIX_COLKEY = "MTEC_CHOIX";
	public static final String MTEC_CODE_COLKEY = "MTEC_CODE";
	public static final String MTEC_LIBELLE_COLKEY = "MTEC_LIBELLE";

	// Relationships

	// Utilities methods
	  public ScolMaquetteTypeEc localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteTypeEc localInstance = (ScolMaquetteTypeEc)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteTypeEc getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteTypeEc.ENTITY_NAME);
		      return (ScolMaquetteTypeEc) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String mtecAbreviation() {
    return (String) storedValueForKey("mtecAbreviation");
  }

  public void setMtecAbreviation(String value) {
    takeStoredValueForKey(value, "mtecAbreviation");
  }

  public String mtecChoix() {
    return (String) storedValueForKey("mtecChoix");
  }

  public void setMtecChoix(String value) {
    takeStoredValueForKey(value, "mtecChoix");
  }

  public String mtecCode() {
    return (String) storedValueForKey("mtecCode");
  }

  public void setMtecCode(String value) {
    takeStoredValueForKey(value, "mtecCode");
  }

  public String mtecLibelle() {
    return (String) storedValueForKey("mtecLibelle");
  }

  public void setMtecLibelle(String value) {
    takeStoredValueForKey(value, "mtecLibelle");
  }


  public static ScolMaquetteTypeEc createScolMaquetteTypeEc(EOEditingContext editingContext, String mtecChoix
, String mtecCode
, String mtecLibelle
) {
    ScolMaquetteTypeEc eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteTypeEc.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteTypeEc.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteTypeEc) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMtecChoix(mtecChoix);
		eo.setMtecCode(mtecCode);
		eo.setMtecLibelle(mtecLibelle);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteTypeEcs(EOEditingContext editingContext) {
    return _ScolMaquetteTypeEc.fetchAllScolMaquetteTypeEcs(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteTypeEcs(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteTypeEc.fetchScolMaquetteTypeEcs(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteTypeEcs(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteTypeEc.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteTypeEc fetchScolMaquetteTypeEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteTypeEc.fetchScolMaquetteTypeEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteTypeEc fetchScolMaquetteTypeEc(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteTypeEc.fetchScolMaquetteTypeEcs(editingContext, qualifier, null);
    ScolMaquetteTypeEc eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteTypeEc)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteTypeEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteTypeEc fetchRequiredScolMaquetteTypeEc(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteTypeEc.fetchRequiredScolMaquetteTypeEc(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteTypeEc fetchRequiredScolMaquetteTypeEc(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteTypeEc eoObject = _ScolMaquetteTypeEc.fetchScolMaquetteTypeEc(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteTypeEc that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteTypeEc localInstanceIn(EOEditingContext editingContext, ScolMaquetteTypeEc eo) {
    ScolMaquetteTypeEc localInstance = (eo == null) ? null : (ScolMaquetteTypeEc)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
