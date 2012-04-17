//
//  GenericFactory.java
//  EdtScol
//
//  Created by Adour on Wed Apr 21 2004.
//  Copyright (c) 2004 __Universit√© de La Rochelle__. All rights reserved.
//

package org.cocktail.groupescol.serveur.eof;

import com.webobjects.eocontrol.EOClassDescription;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;

public class GenericFactory {
    
    private EOEditingContext eContext;
    
    
    public GenericFactory(EOEditingContext eContext) {
        this.eContext = eContext;
    }
        
    /** cree une instance de l'enregistrement d'entite entity et avec l'editingContext eContext */
    public static EOGenericRecord getInstance(EOEditingContext eContext, String entity) {
        EOClassDescription descriptionClass = EOClassDescription.classDescriptionForEntityName(entity);
        EOGenericRecord instance = (EOGenericRecord)descriptionClass.createInstanceWithEditingContext (eContext, null);
        eContext.insertObject(instance);
        return instance;
    }
    
    


}
