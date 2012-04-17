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

// DO NOT EDIT.  Make changes to ScolMaquetteHoraireCode.java instead.
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

public abstract class _ScolMaquetteHoraireCode extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteHoraireCode";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_HORAIRE_CODE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mhcoCode";

	public static final String MHCO_ABREVIATION_KEY = "mhcoAbreviation";
	public static final String MHCO_CODE_KEY = "mhcoCode";
	public static final String MHCO_LIBELLE_KEY = "mhcoLibelle";
	public static final String MHCO_SEUIL_KEY = "mhcoSeuil";
	public static final String MHCO_VALIDITE_KEY = "mhcoValidite";

	public static final String MHCO_ABREVIATION_COLKEY = "MHCO_ABREVIATION";
	public static final String MHCO_CODE_COLKEY = "MHCO_CODE";
	public static final String MHCO_LIBELLE_COLKEY = "MHCO_LIBELLE";
	public static final String MHCO_SEUIL_COLKEY = "MHCO_SEUIL";
	public static final String MHCO_VALIDITE_COLKEY = "MHCO_VALIDITE";

	// Relationships

	// Utilities methods
	  public ScolMaquetteHoraireCode localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteHoraireCode localInstance = (ScolMaquetteHoraireCode)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteHoraireCode getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteHoraireCode.ENTITY_NAME);
		      return (ScolMaquetteHoraireCode) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String mhcoAbreviation() {
    return (String) storedValueForKey("mhcoAbreviation");
  }

  public void setMhcoAbreviation(String value) {
    takeStoredValueForKey(value, "mhcoAbreviation");
  }

  public String mhcoCode() {
    return (String) storedValueForKey("mhcoCode");
  }

  public void setMhcoCode(String value) {
    takeStoredValueForKey(value, "mhcoCode");
  }

  public String mhcoLibelle() {
    return (String) storedValueForKey("mhcoLibelle");
  }

  public void setMhcoLibelle(String value) {
    takeStoredValueForKey(value, "mhcoLibelle");
  }

  public Long mhcoSeuil() {
    return (Long) storedValueForKey("mhcoSeuil");
  }

  public void setMhcoSeuil(Long value) {
    takeStoredValueForKey(value, "mhcoSeuil");
  }

  public String mhcoValidite() {
    return (String) storedValueForKey("mhcoValidite");
  }

  public void setMhcoValidite(String value) {
    takeStoredValueForKey(value, "mhcoValidite");
  }


  public static ScolMaquetteHoraireCode createScolMaquetteHoraireCode(EOEditingContext editingContext, String mhcoCode
, String mhcoLibelle
, Long mhcoSeuil
, String mhcoValidite
) {
    ScolMaquetteHoraireCode eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteHoraireCode.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteHoraireCode.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteHoraireCode) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMhcoCode(mhcoCode);
		eo.setMhcoLibelle(mhcoLibelle);
		eo.setMhcoSeuil(mhcoSeuil);
		eo.setMhcoValidite(mhcoValidite);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteHoraireCodes(EOEditingContext editingContext) {
    return _ScolMaquetteHoraireCode.fetchAllScolMaquetteHoraireCodes(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteHoraireCodes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteHoraireCode.fetchScolMaquetteHoraireCodes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteHoraireCodes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteHoraireCode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteHoraireCode fetchScolMaquetteHoraireCode(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteHoraireCode.fetchScolMaquetteHoraireCode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteHoraireCode fetchScolMaquetteHoraireCode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteHoraireCode.fetchScolMaquetteHoraireCodes(editingContext, qualifier, null);
    ScolMaquetteHoraireCode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteHoraireCode)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteHoraireCode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteHoraireCode fetchRequiredScolMaquetteHoraireCode(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteHoraireCode.fetchRequiredScolMaquetteHoraireCode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteHoraireCode fetchRequiredScolMaquetteHoraireCode(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteHoraireCode eoObject = _ScolMaquetteHoraireCode.fetchScolMaquetteHoraireCode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteHoraireCode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteHoraireCode localInstanceIn(EOEditingContext editingContext, ScolMaquetteHoraireCode eo) {
    ScolMaquetteHoraireCode localInstance = (eo == null) ? null : (ScolMaquetteHoraireCode)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
