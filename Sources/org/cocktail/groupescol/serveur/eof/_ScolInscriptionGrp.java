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

// DO NOT EDIT.  Make changes to ScolInscriptionGrp.java instead.
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

public abstract class _ScolInscriptionGrp extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolInscriptionGrp";
	public static final String ENTITY_TABLE_NAME = "SCOL_INSCRIPTION_GRP";

	// Attributes

	public static final String IGGRP_TEMOIN_SELECTION_KEY = "iggrpTemoinSelection";

	public static final String IGGRP_TEMOIN_SELECTION_COLKEY = "IGGRP_TEMOIN_SELECTION";

	// Relationships
	public static final String SCOL_FORMATION_ANNEE_KEY = "scolFormationAnnee";
	public static final String SCOL_GROUPE_GRP_KEY = "scolGroupeGrp";
	public static final String SCOL_INSCRIPTION_ETUDIANT_KEY = "scolInscriptionEtudiant";

	// Utilities methods
	  public ScolInscriptionGrp localInstanceIn(EOEditingContext editingContext) {
	    ScolInscriptionGrp localInstance = (ScolInscriptionGrp)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolInscriptionGrp getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionGrp.ENTITY_NAME);
		      return (ScolInscriptionGrp) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public String iggrpTemoinSelection() {
    return (String) storedValueForKey("iggrpTemoinSelection");
  }

  public void setIggrpTemoinSelection(String value) {
    takeStoredValueForKey(value, "iggrpTemoinSelection");
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
  
  public org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrp() {
    return (org.cocktail.groupescol.serveur.eof.ScolGroupeGrp)storedValueForKey("scolGroupeGrp");
  }

  public void setScolGroupeGrpRelationship(org.cocktail.groupescol.serveur.eof.ScolGroupeGrp value) {
    if (value == null) {
    	org.cocktail.groupescol.serveur.eof.ScolGroupeGrp oldValue = scolGroupeGrp();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "scolGroupeGrp");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "scolGroupeGrp");
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
  

  public static ScolInscriptionGrp createScolInscriptionGrp(EOEditingContext editingContext, String iggrpTemoinSelection
, org.cocktail.groupescol.serveur.eof.ScolGroupeGrp scolGroupeGrp, org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant scolInscriptionEtudiant) {
    ScolInscriptionGrp eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolInscriptionGrp.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolInscriptionGrp.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolInscriptionGrp) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setIggrpTemoinSelection(iggrpTemoinSelection);
    eo.setScolGroupeGrpRelationship(scolGroupeGrp);
    eo.setScolInscriptionEtudiantRelationship(scolInscriptionEtudiant);
    return eo;
  }

  public static NSArray fetchAllScolInscriptionGrps(EOEditingContext editingContext) {
    return _ScolInscriptionGrp.fetchAllScolInscriptionGrps(editingContext, null);
  }

  public static NSArray fetchAllScolInscriptionGrps(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolInscriptionGrp.fetchScolInscriptionGrps(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolInscriptionGrps(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolInscriptionGrp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolInscriptionGrp fetchScolInscriptionGrp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionGrp.fetchScolInscriptionGrp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionGrp fetchScolInscriptionGrp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolInscriptionGrp.fetchScolInscriptionGrps(editingContext, qualifier, null);
    ScolInscriptionGrp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolInscriptionGrp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolInscriptionGrp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionGrp fetchRequiredScolInscriptionGrp(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolInscriptionGrp.fetchRequiredScolInscriptionGrp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolInscriptionGrp fetchRequiredScolInscriptionGrp(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolInscriptionGrp eoObject = _ScolInscriptionGrp.fetchScolInscriptionGrp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolInscriptionGrp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolInscriptionGrp localInstanceIn(EOEditingContext editingContext, ScolInscriptionGrp eo) {
    ScolInscriptionGrp localInstance = (eo == null) ? null : (ScolInscriptionGrp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
