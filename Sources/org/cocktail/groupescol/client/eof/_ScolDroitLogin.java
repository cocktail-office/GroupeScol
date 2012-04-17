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

// DO NOT EDIT.  Make changes to ScolDroitLogin.java instead.
package org.cocktail.groupescol.client.eof;

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

public abstract class _ScolDroitLogin extends  EOGenericRecord {
	public static final String ENTITY_NAME = "ScolDroitLogin";
	public static final String ENTITY_TABLE_NAME = "SCOL_DROIT_LOGIN";

	// Attributes
 public static final String ENTITY_PRIMARY_KEY = "dlogKey";

	public static final String DLOG_KEY_KEY = "dlogKey";
	public static final String DLOG_LOGIN_KEY = "dlogLogin";
	public static final String DLOG_NOM_KEY = "dlogNom";
	public static final String DLOG_PRENOM_KEY = "dlogPrenom";
	public static final String DLOG_VALIDE_KEY = "dlogValide";

	public static final String DLOG_KEY_COLKEY = "DLOG_KEY";
	public static final String DLOG_LOGIN_COLKEY = "DLOG_LOGIN";
	public static final String DLOG_NOM_COLKEY = "DLOG_NOM";
	public static final String DLOG_PRENOM_COLKEY = "DLOG_PRENOM";
	public static final String DLOG_VALIDE_COLKEY = "DLOG_VALIDE";

	// Relationships
	public static final String SCOL_DROIT_DIPLOMES_KEY = "scolDroitDiplomes";

	// Utilities methods
	  public ScolDroitLogin localInstanceIn(EOEditingContext editingContext) {
	    ScolDroitLogin localInstance = (ScolDroitLogin)EOUtilities.localInstanceOfObject(editingContext, this);
	    if (localInstance == null) {
	      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
	    }
	    return localInstance;
	  }

	
			public static ScolDroitLogin getInstance(EOEditingContext editingContext) {
			  EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(_ScolDroitLogin.ENTITY_NAME);
		      return (ScolDroitLogin) descriptionClass.createInstanceWithEditingContext(editingContext, null);
		}
		
	// Accessors methods
  public Long dlogKey() {
    return (Long) storedValueForKey("dlogKey");
  }

  public void setDlogKey(Long value) {
    takeStoredValueForKey(value, "dlogKey");
  }

  public String dlogLogin() {
    return (String) storedValueForKey("dlogLogin");
  }

  public void setDlogLogin(String value) {
    takeStoredValueForKey(value, "dlogLogin");
  }

  public String dlogNom() {
    return (String) storedValueForKey("dlogNom");
  }

  public void setDlogNom(String value) {
    takeStoredValueForKey(value, "dlogNom");
  }

  public String dlogPrenom() {
    return (String) storedValueForKey("dlogPrenom");
  }

  public void setDlogPrenom(String value) {
    takeStoredValueForKey(value, "dlogPrenom");
  }

  public String dlogValide() {
    return (String) storedValueForKey("dlogValide");
  }

  public void setDlogValide(String value) {
    takeStoredValueForKey(value, "dlogValide");
  }

  public NSArray scolDroitDiplomes() {
    return (NSArray)storedValueForKey("scolDroitDiplomes");
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier) {
    return scolDroitDiplomes(qualifier, null, false);
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier, boolean fetch) {
    return scolDroitDiplomes(qualifier, null, fetch);
  }

  public NSArray scolDroitDiplomes(EOQualifier qualifier, NSArray sortOrderings, boolean fetch) {
    NSArray results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.cocktail.groupescol.client.eof.ScolDroitDiplome.SCOL_DROIT_LOGIN_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.cocktail.groupescol.client.eof.ScolDroitDiplome.fetchScolDroitDiplomes(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = scolDroitDiplomes();
      if (qualifier != null) {
        results = (NSArray)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    addObjectToBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
  }

  public void removeFromScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
  }

  public org.cocktail.groupescol.client.eof.ScolDroitDiplome createScolDroitDiplomesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("ScolDroitDiplome");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "scolDroitDiplomes");
    return (org.cocktail.groupescol.client.eof.ScolDroitDiplome) eo;
  }

  public void deleteScolDroitDiplomesRelationship(org.cocktail.groupescol.client.eof.ScolDroitDiplome object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "scolDroitDiplomes");
  }

  public void deleteAllScolDroitDiplomesRelationships() {
    Enumeration objects = scolDroitDiplomes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteScolDroitDiplomesRelationship((org.cocktail.groupescol.client.eof.ScolDroitDiplome)objects.nextElement());
    }
  }


  public static ScolDroitLogin createScolDroitLogin(EOEditingContext editingContext, Long dlogKey
, String dlogLogin
, String dlogValide
) {
    ScolDroitLogin eo = null;
    EOClassDescription classDescription = EOClassDescription.classDescriptionForEntityName(_ScolDroitLogin.ENTITY_NAME);
    if(classDescription == null)
    {
        throw new IllegalArgumentException("Could not find EOClassDescription for entity name '" + _ScolDroitLogin.ENTITY_NAME + "' !");
    } else
    {
        eo = (ScolDroitLogin) classDescription.createInstanceWithEditingContext(editingContext, null);
        editingContext.insertObject(eo);
    }
    
		eo.setDlogKey(dlogKey);
		eo.setDlogLogin(dlogLogin);
		eo.setDlogValide(dlogValide);
    return eo;
  }

  public static NSArray fetchAllScolDroitLogins(EOEditingContext editingContext) {
    return _ScolDroitLogin.fetchAllScolDroitLogins(editingContext, null);
  }

  public static NSArray fetchAllScolDroitLogins(EOEditingContext editingContext, NSArray sortOrderings) {
    return _ScolDroitLogin.fetchScolDroitLogins(editingContext, null, sortOrderings);
  }

  public static NSArray fetchScolDroitLogins(EOEditingContext editingContext, EOQualifier qualifier, NSArray sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ScolDroitLogin.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray eoObjects = (NSArray)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static ScolDroitLogin fetchScolDroitLogin(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolDroitLogin.fetchScolDroitLogin(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolDroitLogin fetchScolDroitLogin(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray eoObjects = _ScolDroitLogin.fetchScolDroitLogins(editingContext, qualifier, null);
    ScolDroitLogin eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (ScolDroitLogin)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one ScolDroitLogin that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolDroitLogin fetchRequiredScolDroitLogin(EOEditingContext editingContext, String keyName, Object value) {
    return _ScolDroitLogin.fetchRequiredScolDroitLogin(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ScolDroitLogin fetchRequiredScolDroitLogin(EOEditingContext editingContext, EOQualifier qualifier) {
    ScolDroitLogin eoObject = _ScolDroitLogin.fetchScolDroitLogin(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ScolDroitLogin that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ScolDroitLogin localInstanceIn(EOEditingContext editingContext, ScolDroitLogin eo) {
    ScolDroitLogin localInstance = (eo == null) ? null : (ScolDroitLogin)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
