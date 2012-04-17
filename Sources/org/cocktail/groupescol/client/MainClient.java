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
package org.cocktail.groupescol.client;

import java.awt.Color;
import java.util.ArrayList;

import org.cocktail.groupescol.client.eof.IndividuUlr;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOArchive;
import com.webobjects.eoapplication.EOFrameController;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.eodistribution.client.EODistributedObjectStore;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimeZone;

import fr.univlr.cri.util.StringCtrl;

/**
 * classe d'entree dans le programme JavaClient
 */
public class MainClient extends EOApplication {

	public static final String RETURN = System.getProperty("line.separator");

	public static final Color VERT = new Color(0x32CD32);
	public static final Color BLEU = new Color(0x1E90FF);
	public static final Color JAUNE = new Color(0xFFD700);
	public static final Color VIOLET = new Color(0xDDA0DD);

	private MainInterface mainInterface;

	private EOEditingContext eContext = new EOEditingContext();
	private NSMutableDictionary userInfos;
	private NSMutableDictionary appInfos;
	private String userName;
	private NSArray formationAnnees;
	private GroupeFactory groupeFactory;

	public WaitingHandler waitingHandler;

	private boolean groupeActif = false;

	public WaitingHandler waitingHandler() {
		return waitingHandler;
	}

	public GroupeFactory groupeFactory() {
		return this.groupeFactory;
	}

	/** methode appelee a la fin du demarrage de l'application */
	public void finishInitialization() {
		super.finishInitialization();
		setQuitsOnLastWindowClose(false);
		this.initApplication();
	}

	/** retourne l'editing context utilise par defaut */
	public EOEditingContext editingContext() {
		return this.eContext;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserInfos(NSDictionary userinfos) {
		this.userInfos = new NSMutableDictionary(userinfos);

		IndividuUlr individu = (IndividuUlr) DBHandler.fetchUniqueData(eContext, "IndividuUlr", "persId", userinfos.objectForKey("persId"));
		if (individu != null) {
			this.userInfos.setObjectForKey(individu, "individu");
		}
		else
			if (((NSArray) userInfos.objectForKey("droits")).count() == 0) {
				WindowHandler.showError("Vous n'avez pas de droits sur les diplomes\nVoir avec votre responsable p\u00e9dagogique");
				this.quit();
			}
	}

	public NSDictionary userInfos() {
		return userInfos;
	}

	public MainInterface mainInterface() {
		return mainInterface;
	}

	public void setGroupeActif(boolean actif) {
		this.groupeActif = actif;
	}

	public boolean groupeActif() {
		return this.groupeActif;
	}

	private void initApplication() {

		boolean useLoginPassword = ((Boolean) simpleInvokeRemoteMethod("clientSideRequestUseLoginPassword")).booleanValue();

		String casUserName = LoginPasswd.getCASUserName(this);
		LoginPasswd loginPass = new LoginPasswd(eContext);
		EOArchive.loadArchiveNamed("LoginPasswd", loginPass, "org.cocktail.groupescol.client", loginPass.disposableRegistry());

		if ((!useLoginPassword) || (casUserName != null)) {
			System.out.println("useLoginPassword=" + useLoginPassword);
			System.out.println("casUserName=" + casUserName);
			String login = (casUserName != null) ? casUserName : System.getProperty("user.name");
			setUserName(login);
			setUserInfos(loginPass.getUserInfos(login, null, "O"));
		}
		else {
			loginPass.afficher();
		}

		waitingHandler = WaitingHandler.getInstance("Groupes", "Lancement en cours ...", "", new java.awt.Dimension(300, 60));
		groupeFactory = new GroupeFactory(eContext);

		// Recuperation du time zone a partir du serveur
		NSTimeZone tz = (NSTimeZone) simpleInvokeRemoteMethod("clientSideRequestDefaultTimeZone");
		NSTimeZone.setDefault(tz);
		NSTimeZone.setDefaultTimeZone(tz);
		EOSortOrdering sortAnnees = EOSortOrdering.sortOrderingWithKey("fannKey", EOSortOrdering.CompareAscending);
		formationAnnees = EOSortOrdering.sortedArrayUsingKeyOrderArray(DBHandler.fetchData(eContext, "ScolFormationAnnee", null), new NSArray(
				sortAnnees));

		if (((Number) userInfo("droits")).intValue() == -1) {
			WindowHandler.showError("Vous n'avez pas les droits sur la scolarit\u00e9\nFermeture de l'application");
			this.quit();
		}

		mainInterface = new MainInterface(eContext, this);
		EOArchive.loadArchiveNamed("MainInterface", mainInterface, "org.cocktail.groupescol.client", mainInterface.disposableRegistry());

		IndividuUlr agent = (IndividuUlr) userInfo("individu");
		String nom = StringCtrl.capitalize(agent.prenom()) + " " + agent.nomUsuel();
		String titre = "GroupeScol : Gestion des groupes etudiants : [ " + nom + " ]";

		EOFrameController.runControllerInNewFrame(mainInterface, titre);
		setQuitsOnLastWindowClose(true);
	}

	/** retourne les formationAnnees */
	public NSArray getFormationAnnees() {
		return formationAnnees;
	}

	/** renvoie les formations specialisations auquelles l'agent a droit */
	public NSArray formationSpecialisationAgent() {
		NSArray droits = (NSArray) userInfo("droits");
		ArrayList sumQualifiers = new ArrayList();
		if (droits.count() > 0) {
			EOQualifier qualDroits = EOQualifier.qualifierWithQualifierFormat("droitDiplomes.dlogKey=%@", new NSArray(droits.objectAtIndex(0)));
			sumQualifiers.add(qualDroits);
		}

		EOQualifier totalQualifier = new EOAndQualifier(new NSArray(sumQualifiers.toArray()));
		return (NSArray) DBHandler.fetchData(eContext, "ScolFormationHabilitation", totalQualifier).valueForKey("scolFormationSpecialisation");
	}

	/** retourne une valeur particuliere des parametres pour l'utilisateur */
	public Object userInfo(String key) {
		return userInfos.objectForKey(key);
	}

	public Object primaryKeyFromEO(EOGenericRecord eObject, String primKey) {
		if (eObject != null) {
			EOGlobalID gid = eContext.globalIDForObject(eObject);
			return this.primaryKey(gid, primKey);
		}
		else {
			return null;
		}
	}

	/** permet de faire une invocation simple ie : sans parametres */
	public Object simpleInvokeRemoteMethod(String methodName) {
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		return objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", methodName, null, null, false);
	}

	public Object primaryKey(EOGlobalID gid, String primKey) {
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		return objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestPrimaryKey", new Class[] { EOGlobalID.class,
				String.class }, new Object[] { gid, primKey }, false);
	}

	public void serverLog(String msg) {
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestServerLog", new Class[] { String.class },
				new Object[] { msg }, false);
	}

	public boolean saveChanges() {
		boolean retour = true;
		eContext.lock();
		try {
			eContext.saveChanges();
		}
		catch (Exception exe) {
			exe.printStackTrace();
			eContext.revert();
			retour = false;
		}
		finally {
			eContext.unlock();
		}
		return retour;
	}

	public void quit() {
		super.quit();
	}

}
