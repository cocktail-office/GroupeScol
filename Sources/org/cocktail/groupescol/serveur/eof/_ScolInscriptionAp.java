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

// DO NOT EDIT.  Make changes to ScolInscriptionAp.java instead.
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

public abstract class _ScolInscriptionAp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolInscriptionAp";
	public static final String ENTITY_TABLE_NAME = "SCOL_INSCRIPTION_AP";

	// Attributes

	public static final String IMRAP_DISPENSE_KEY = "imrapDispense";
	public static final String IMRAP_SEMESTRE_KEY = "imrapSemestre";

	public static final String IMRAP_DISPENSE_COLKEY = "IMRAP_DISPENSE";
	public static final String IMRAP_SEMESTRE_COLKEY = "IMRAP_SEMESTRE";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_INSCRIPTION_ETUDIANT_KEY = "scolInscriptionEtudiant";
	public static final String SCOL_MAQUETTE_REPARTITION_AP_KEY = "scolMaquetteRepartitionAp";

	// Utilities methods
	  public ScolInscriptionAp localInstanceIn(EOEditingContext editingContext) {
	    ScolInscriptionAp localInstance = (ScolInscriptionAp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolInscriptionAp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionAp.ENTITY_NAME);
		      return (ScolInscriptionAp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long imrapDispense() {
    return (Long) storedValueForKey("imrapDispense");
  }

  public void setImrapDispense(Long value) {
    takeStoredValueForKey(value, "imrapDispense");
  }

  public Long imrapSemestre() {
    return (Long) storedValueForKey("imrapSemestre");
  }

  public void setImrapSemestre(Long value) {
    takeStoredValueForKey(value, "imrapSemestre");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant scolInscriptionEtudiant() {
    return (org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant)storedValueForKey("scolInscriptionEtudiant");
  }

  public void setScolInscriptionEtudiantRelationship(org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant oldValue = scolInscriptionEtudiant();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolInscriptionEtudiant");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolInscriptionEtudiant");
    }
  }
  
  public org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionAp scolMaquetteRepartitionAp() {
    return (org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionAp)storedValueForKey("scolMaquetteRepartitionAp");
  }

  public void setScolMaquetteRepartitionApRelationship(org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionAp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolMaquetteRepartitionAp oldValue = scolMaquetteRepartitionAp();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolMaquetteRepartitionAp");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolMaquetteRepartitionAp");
    }
  }
  

  public static ScolInscriptionAp createScolInscriptionAp(EOEditingContext editingContext, Long imrapDispense
, Long imrapSemestre
) {
    ScolInscriptionAp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionAp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolInscriptionAp.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolInscriptionAp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setImrapDispense(imrapDispense);
		eo.setImrapSemestre(imrapSemestre);
    return eo;
  }

  public static NSArray fetchAllScolInscriptionAps(EOEditingContext editingContext) {
    return _ScolInscriptionAp.fetchAllScolInscriptionAps(editingContext, null);
  }

  public static NSArray fetchAllScolInscriptionAps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolInscriptionAp.fetchScolInscriptionAps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolInscriptionAps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolInscriptionAp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolInscriptionAp fetchScolInscriptionAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionAp.fetchScolInscriptionAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionAp fetchScolInscriptionAp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolInscriptionAp.fetchScolInscriptionAps(editingContext, qualifier, null);
    ScolInscriptionAp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolInscriptionAp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolInscriptionAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionAp fetchRequiredScolInscriptionAp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionAp.fetchRequiredScolInscriptionAp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionAp fetchRequiredScolInscriptionAp(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolInscriptionAp eoObject = _ScolInscriptionAp.fetchScolInscriptionAp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolInscriptionAp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionAp localInstanceIn(EOEditingContext editingContext, ScolInscriptionAp eo) {
    ScolInscriptionAp localInstance = (eo == null) ? null : (ScolInscriptionAp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
