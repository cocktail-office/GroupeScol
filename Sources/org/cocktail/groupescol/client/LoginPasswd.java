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

import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOModalDialogController;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eodistribution.client.EODistributedObjectStore;
import com.webobjects.eointerface.swing.EOImageView;
import com.webobjects.eointerface.swing.EOTextField;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;

import fr.univlr.cri.util.CRIpto;
import fr.univlr.cri.webapp.LRDockClient;

public class LoginPasswd extends EOModalDialogController {

	public MainClient app = (MainClient) EOApplication.sharedApplication();

	public JButton btConnecter, btAnnuler;
	public EOTextField tfLogin, tfAlerte;
	public JPasswordField tfPasswd;
	public boolean autorise = false;
	public String login;
	private EOEditingContext eContext;
	public EOImageView iconeLogin;

	public LoginPasswd(EOEditingContext eContext) {
		super();
		this.eContext = eContext;
	}

	/** */
	protected void componentDidBecomeVisible() {
		setWindowTitle(this.window(), "Authentification");
		tfAlerte.setVisible(false);
		WidgetHandler.decorateButton("ok", btConnecter);
		WidgetHandler.decorateButton("cancel", btAnnuler);

		iconeLogin.setImageScaling(EOImageView.ScaleToFit);
		try {
			iconeLogin.setImage(WidgetHandler.image("clefs"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// en mode WebStart on peut ne pas avoir acces a la valeur
		String leUser = null;
		try {
			leUser = System.getProperty("user.name");
			tfLogin.setText(leUser);
		}
		catch (SecurityException secExp) {
			app.serverLog("SecurityException -" + secExp.getMessage());
		}

		if ((leUser == null) || (leUser.equals(""))) {
			tfLogin.setEditable(true);
			tfLogin.setRequestFocusEnabled(true);
		}
		else {
			tfLogin.setEditable(true);
			tfPasswd.setRequestFocusEnabled(true);
		}

	}

	public void afficher() {
		this.activateWindow();
	}

	public void cacher() {
		this.deactivateWindow();
	}

	public void connecter(Object sender) {

		tfAlerte.setVisible(false);
		login = tfLogin.getText();
		String passwd = new String(tfPasswd.getPassword());
		if (passwd.equals("")) {
			return;
		}
		NSDictionary userInfos = getUserInfos(login, passwd, "N");

		if (userInfos != null) {
			app.setUserName(login);
			app.setUserInfos(userInfos);
			cacher();
		}
		else {
			tfAlerte.setForeground(Color.red);
			tfAlerte.setVisible(true);
		}
	}

	/**
	 * retourne le pers_id de la personne sinon nul, si pas login/mot de passe incorrects, les chaines sont cryptees avant requete au
	 * serveur
	 */
	public NSDictionary getUserInfos(String log, String pass, String casAuth) {
		NSDictionary userInfos = null;
		String crLogin = CRIpto.crypt(log);
		String crPasswd = CRIpto.crypt(pass);
		EODistributedObjectStore objectStore = (EODistributedObjectStore) EOEditingContext.defaultParentObjectStore();
		userInfos = (NSDictionary) objectStore.invokeRemoteMethodWithKeyPath(eContext, "session", "clientSideRequestUserInfos", new Class[] {
				String.class, String.class, String.class }, new Object[] { crLogin, crPasswd, casAuth }, false);
		return userInfos;
	}

	/** utilisee pour le developpement */
	public void directConnection(String login, String pass) {
		NSDictionary infos = getUserInfos(login, pass, "N");
		if (infos != null) {
			app.setUserName(login);
			app.setUserInfos(infos);
		}
		else {
			NSLog.out.appendln(this.getClass().getName() + " : userinfos==null");
		}
	}

	public static String getCASUserName(EOApplication application) {
		NSDictionary arguments = application.arguments();
		String dockPort = (String) arguments.objectForKey("LRAppDockPort");
		String dockTicket = (String) arguments.objectForKey("LRAppDockTicket");
		String uname = null;
		if ((dockTicket != null) && (dockPort != null)) {
			uname = LRDockClient.getNetID(null, dockPort, dockTicket);
		}
		return uname;
	}

	public void fermer() {
		cacher();
	}

	public void annuler(Object sender) {
		app.setCanQuit(true);
		app.quit();
	}

}
