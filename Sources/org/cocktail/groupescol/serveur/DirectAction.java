/*
 * Copyright COCKTAIL (www.cocktail.org), 2001, 2012 
 * 
 * This software is governed by the CeCILL license under French law and
 * abiding by the rules of distribution of free software. You can use, 
 * modify and/or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info". 
 * 
 * As a counterpart to the access to the source code and rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty and the software's author, the holder of the
 * economic rights, and the successive licensors have only limited
 * liability. 
 * 
 * In this respect, the user's attention is drawn to the risks associated
 * with loading, using, modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean that it is complicated to manipulate, and that also
 * therefore means that it is reserved for developers and experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or 
 * data to be ensured and, more generally, to use and operate it in the 
 * same conditions as regards security. 
 * 
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */
package org.cocktail.groupescol.serveur;

import java.net.URL;

import javax.swing.ImageIcon;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WODirectAction;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOSession;
import com.webobjects.appserver.WOSessionStore;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSLog;

import fr.univlr.cri.webapp.LRDataResponse;
import fr.univlr.cri.webapp.LRResourceManager;

public class DirectAction extends WODirectAction {

	Application app = (Application) WOApplication.application();
	LRResourceManager resBundle = app.appResources();

	public DirectAction(WORequest aRequest) {
		super(aRequest);
	}

	public WOActionResults defaultAction() {
		return pageWithName("Main");
	}

	public WOActionResults afficherPhotoAction() {
		WORequest aRequest = this.request();
		LRDataResponse myResp = new LRDataResponse();
		URL photoVide = null;
		NSData laPhoto = null;
		char separateur = '-'; // car le + est transforme en espace
		int iSeparateur = 0;
		String id = aRequest.stringFormValueForKey("id");
		// on cherche l'index du charactere qui separe le sessionId du persId
		do {
			iSeparateur++;
		}
		while ((id.charAt(iSeparateur) != separateur) && (iSeparateur < (id.length() - 1)));
		// on recupere l'id de la session
		String sessionId = id.substring(0, iSeparateur);

		WOSessionStore store = app.sessionStore();
		WOSession session = store.restoreSessionWithID(sessionId, null);

		if (session == null) {
			try {
				new ImageIcon("file:///" + resBundle.pathForResource("no_photo.gif"));
				photoVide = new URL("file:///" + resBundle.pathForResource("no_photo.gif"));
				laPhoto = new NSData(photoVide);
			}
			catch (Exception e) {
				NSLog.out.appendln("probleme avec la photo vide");
			}
		}
		else {
			String idIndividu = id.substring(iSeparateur + 1, id.length());
			if (idIndividu == null) {
				return null;
			}
			Number noIndividu = new Integer(idIndividu);
			EOEditingContext ec = new EOEditingContext();

			if (idIndividu != null) {
				EOQualifier myQualifier = EOQualifier.qualifierWithQualifierFormat("noIndividu = %@", new NSArray(noIndividu));
				EOFetchSpecification myFetch = new EOFetchSpecification("PhotosEtudiantsGrhum", myQualifier, null);
				NSArray myResult = ec.objectsWithFetchSpecification(myFetch);

				if (myResult.count() == 0) {
					myFetch = new EOFetchSpecification("PhotosEtudiantsOldGrhum", myQualifier, null);
					myResult = ec.objectsWithFetchSpecification(myFetch);
				}

				if (myResult.count() > 0) {
					if (myResult.valueForKey("datasPhoto") != null) {
						laPhoto = (NSData) ((EOGenericRecord) myResult.objectAtIndex(0)).valueForKey("datasPhoto");
					}
				}
			}
		}

		// pas de photo on met l'image "aucune photo"
		if (laPhoto == null) {
			try {
				new ImageIcon("file:///" + resBundle.pathForResource("no_photo.gif"));
				photoVide = new URL("file:///" + resBundle.pathForResource("no_photo.gif"));
				laPhoto = new NSData(photoVide);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		// On construit la reponse
		myResp.setContent(laPhoto, "image/jpeg");
		return myResp;
	}

}
