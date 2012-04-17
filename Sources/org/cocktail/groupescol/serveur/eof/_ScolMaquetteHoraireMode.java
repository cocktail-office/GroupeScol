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

// DO NOT EDIT.  Make changes to ScolMaquetteHoraireMode.java instead.
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

public abstract class _ScolMaquetteHoraireMode extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolMaquetteHoraireMode";
	public static final String ENTITY_TABLE_NAME = "SCOL_MAQUETTE_HORAIRE_MODE";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "mhmoCode";

	public static final String MHMO_ABREVIATION_KEY = "mhmoAbreviation";
	public static final String MHMO_LIBELLE_KEY = "mhmoLibelle";
	public static final String MHMO_PAYABLE_KEY = "mhmoPayable";
	public static final String MHMO_PRIORITE_KEY = "mhmoPriorite";
	public static final String MHMO_VALIDITE_KEY = "mhmoValidite";

	public static final String MHMO_ABREVIATION_COLKEY = "MHMO_ABREVIATION";
	public static final String MHMO_LIBELLE_COLKEY = "MHMO_LIBELLE";
	public static final String MHMO_PAYABLE_COLKEY = "MHMO_PAYABLE";
	public static final String MHMO_PRIORITE_COLKEY = "MHMO_PRIORITE";
	public static final String MHMO_VALIDITE_COLKEY = "MHMO_VALIDITE";

	// Relationships

	// Utilities methods
	  public ScolMaquetteHoraireMode localInstanceIn(EOEditingContext editingContext) {
	    ScolMaquetteHoraireMode localInstance = (ScolMaquetteHoraireMode)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolMaquetteHoraireMode getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteHoraireMode.ENTITY_NAME);
		      return (ScolMaquetteHoraireMode) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String mhmoAbreviation() {
    return (String) storedValueForKey("mhmoAbreviation");
  }

  public void setMhmoAbreviation(String value) {
    takeStoredValueForKey(value, "mhmoAbreviation");
  }

  public String mhmoLibelle() {
    return (String) storedValueForKey("mhmoLibelle");
  }

  public void setMhmoLibelle(String value) {
    takeStoredValueForKey(value, "mhmoLibelle");
  }

  public String mhmoPayable() {
    return (String) storedValueForKey("mhmoPayable");
  }

  public void setMhmoPayable(String value) {
    takeStoredValueForKey(value, "mhmoPayable");
  }

  public Long mhmoPriorite() {
    return (Long) storedValueForKey("mhmoPriorite");
  }

  public void setMhmoPriorite(Long value) {
    takeStoredValueForKey(value, "mhmoPriorite");
  }

  public String mhmoValidite() {
    return (String) storedValueForKey("mhmoValidite");
  }

  public void setMhmoValidite(String value) {
    takeStoredValueForKey(value, "mhmoValidite");
  }


  public static ScolMaquetteHoraireMode createScolMaquetteHoraireMode(EOEditingContext editingContext, String mhmoLibelle
, String mhmoPayable
, Long mhmoPriorite
, String mhmoValidite
) {
    ScolMaquetteHoraireMode eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolMaquetteHoraireMode.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolMaquetteHoraireMode.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolMaquetteHoraireMode) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setMhmoLibelle(mhmoLibelle);
		eo.setMhmoPayable(mhmoPayable);
		eo.setMhmoPriorite(mhmoPriorite);
		eo.setMhmoValidite(mhmoValidite);
    return eo;
  }

  public static NSArray fetchAllScolMaquetteHoraireModes(EOEditingContext editingContext) {
    return _ScolMaquetteHoraireMode.fetchAllScolMaquetteHoraireModes(editingContext, null);
  }

  public static NSArray fetchAllScolMaquetteHoraireModes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolMaquetteHoraireMode.fetchScolMaquetteHoraireModes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolMaquetteHoraireModes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolMaquetteHoraireMode.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolMaquetteHoraireMode fetchScolMaquetteHoraireMode(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteHoraireMode.fetchScolMaquetteHoraireMode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteHoraireMode fetchScolMaquetteHoraireMode(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolMaquetteHoraireMode.fetchScolMaquetteHoraireModes(editingContext, qualifier, null);
    ScolMaquetteHoraireMode eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolMaquetteHoraireMode)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolMaquetteHoraireMode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteHoraireMode fetchRequiredScolMaquetteHoraireMode(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolMaquetteHoraireMode.fetchRequiredScolMaquetteHoraireMode(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolMaquetteHoraireMode fetchRequiredScolMaquetteHoraireMode(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolMaquetteHoraireMode eoObject = _ScolMaquetteHoraireMode.fetchScolMaquetteHoraireMode(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolMaquetteHoraireMode that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolMaquetteHoraireMode localInstanceIn(EOEditingContext editingContext, ScolMaquetteHoraireMode eo) {
    ScolMaquetteHoraireMode localInstance = (eo == null) ? null : (ScolMaquetteHoraireMode)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
