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

// DO NOT EDIT.  Make changes to ScolDroitDiplome.java instead.
package org.cocktail.groupescol.client.eof;

import java.util.NoSuchElementException;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOKeyValueQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

public abstract class _ScolDroitDiplome extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolDroitDiplome";
	public static final String ENTITY_TABLE_NAME = "SCOL_DROIT_DIPLOME";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "ddipKey";

	public static final String DDIP_GROUPES_KEY = "ddipGroupes";
	public static final String DDIP_MAQUETTES_KEY = "ddipMaquettes";

	public static final String DDIP_GROUPES_COLKEY = "DDIP_GROUPES";
	public static final String DDIP_MAQUETTES_COLKEY = "DDIP_MAQUETTES";

	// Relationships
	public static final String SCOL_DROIT_LOGIN_KEY = "scolDroitLogin";
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_FORMATION_HABILITATION_KEY = "scolFormationHabilitation";

	// Utilities methods
	  public ScolDroitDiplome localInstanceIn(EOEditingContext editingContext) {
	    ScolDroitDiplome localInstance = (ScolDroitDiplome)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolDroitDiplome getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolDroitDiplome.ENTITY_NAME);
		      return (ScolDroitDiplome) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String ddipGroupes() {
    return (String) storedValueForKey("ddipGroupes");
  }

  public void setDdipGroupes(String value) {
    takeStoredValueForKey(value, "ddipGroupes");
  }

  public String ddipMaquettes() {
    return (String) storedValueForKey("ddipMaquettes");
  }

  public void setDdipMaquettes(String value) {
    takeStoredValueForKey(value, "ddipMaquettes");
  }

  public org.cocktail.groupescol.client.eof.ScolDroitLogin scolDroitLogin() {
    return (org.cocktail.groupescol.client.eof.ScolDroitLogin)storedValueForKey("scolDroitLogin");
  }

  public void setScolDroitLoginRelationship(org.cocktail.groupescol.client.eof.ScolDroitLogin value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolDroitLogin oldValue = scolDroitLogin();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolDroitLogin");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolDroitLogin");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolFormationAnnee scolFormationAnnee() {
    return (org.cocktail.groupescol.client.eof.ScolFormationAnnee)storedValueForKey("scolFormationAnnee");
  }

  public void setScolFormationAnneeRelationship(org.cocktail.groupescol.client.eof.ScolFormationAnnee value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolFormationAnnee oldValue = scolFormationAnnee();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationAnnee");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationAnnee");
    }
  }
  
  public org.cocktail.groupescol.client.eof.ScolFormationHabilitation scolFormationHabilitation() {
    return (org.cocktail.groupescol.client.eof.ScolFormationHabilitation)storedValueForKey("scolFormationHabilitation");
  }

  public void setScolFormationHabilitationRelationship(org.cocktail.groupescol.client.eof.ScolFormationHabilitation value) {
    if (value == null) {
    	org.cocktail.groupescol.client.eof.ScolFormationHabilitation oldValue = scolFormationHabilitation();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolFormationHabilitation");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolFormationHabilitation");
    }
  }
  

  public static ScolDroitDiplome createScolDroitDiplome(EOEditingContext editingContext, String ddipGroupes
, String ddipMaquettes
) {
    ScolDroitDiplome eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolDroitDiplome.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolDroitDiplome.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolDroitDiplome) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setDdipGroupes(ddipGroupes);
		eo.setDdipMaquettes(ddipMaquettes);
    return eo;
  }

  public static NSArray fetchAllScolDroitDiplomes(EOEditingContext editingContext) {
    return _ScolDroitDiplome.fetchAllScolDroitDiplomes(editingContext, null);
  }

  public static NSArray fetchAllScolDroitDiplomes(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolDroitDiplome.fetchScolDroitDiplomes(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolDroitDiplomes(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolDroitDiplome.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolDroitDiplome fetchScolDroitDiplome(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolDroitDiplome.fetchScolDroitDiplome(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolDroitDiplome fetchScolDroitDiplome(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolDroitDiplome.fetchScolDroitDiplomes(editingContext, qualifier, null);
    ScolDroitDiplome eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolDroitDiplome)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolDroitDiplome that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolDroitDiplome fetchRequiredScolDroitDiplome(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolDroitDiplome.fetchRequiredScolDroitDiplome(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolDroitDiplome fetchRequiredScolDroitDiplome(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolDroitDiplome eoObject = _ScolDroitDiplome.fetchScolDroitDiplome(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolDroitDiplome that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolDroitDiplome localInstanceIn(EOEditingContext editingContext, ScolDroitDiplome eo) {
    ScolDroitDiplome localInstance = (eo == null) ? null : (ScolDroitDiplome)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
