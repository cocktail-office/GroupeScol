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

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSTimeZone;

import fr.univlr.cri.webapp.CRIWebApplication;
import fr.univlr.cri.webapp.VersionCocktail;

public class Application extends CRIWebApplication {

	private static final String MAIN_MODEL_NAME = "GroupeScol";
	private static final String CONFIG_FILE_NAME = "GroupeScol.config";
	private static final String CONFIG_TABLE_NAME = "ul_GrhumParametres";

	private VersionCocktail _appVersionCocktail = null;
	private VersionCocktail _appVersionCocktailDB = null;

	String applicationInstanceURL, applicationURL;

	public static void main(String argv[]) {
		WOApplication.main(argv, Application.class);
	}

	public Application() {
		super();

		System.out.println("Bienvenue dans " + this.name() + "!");

		if (config().booleanForKey("LOG_SQL_GENERATION")) {
			NSLog.setAllowedDebugLevel(NSLog.DebugLevelDetailed);
			NSLog.allowDebugLoggingForGroups(NSLog.DebugGroupSQLGeneration);
			NSLog.allowDebugLoggingForGroups(NSLog.DebugGroupDatabaseAccess);
		}

		String tz = config().stringForKey("TIME_ZONE");
		NSTimeZone.setDefaultTimeZone(NSTimeZone.timeZoneWithName(tz, false));
	}

	public String copyright() {
		return "&copy; 2004 Universit&eacute; de La Rochelle";
	}

	public String configFileName() {
		return CONFIG_FILE_NAME;
	}

	public String configTableName() {
		return CONFIG_TABLE_NAME;
	}

	public String mainModelName() {
		return MAIN_MODEL_NAME;
	}

	public VersionCocktail appVersionCocktail() {
		if (_appVersionCocktail == null) {
			_appVersionCocktail = new Version();
		}
		return _appVersionCocktail;
	}

	public VersionCocktail appVersionCocktailDb() {
		if (_appVersionCocktailDB == null) {
			_appVersionCocktailDB = new VersionDB();
		}
		return _appVersionCocktailDB;
	}

	/** retourne l'ULR de l'instance courante, ne marche pas bien selon le deploiement WebServer utilis� */
	public String getApplicationInstanceURL(WOContext context) {
		if (applicationInstanceURL == null) {
			applicationURL = getApplicationURL(context);
			applicationInstanceURL = applicationURL;
			if (applicationURL != null) {
				String req = context.request().applicationURLPrefix();
				int i = req.indexOf(".woa");
				if (i >= 0) {
					req = req.substring(0, i) + ".woa";
				}
				i = applicationURL.indexOf(req);
				if (i >= 0) {
					applicationInstanceURL = applicationURL.substring(0, i);
					req = context.request().applicationURLPrefix();
					if (!req.startsWith("/") && (applicationInstanceURL.length() > 0)) {
						applicationInstanceURL += "/";
					}
					applicationInstanceURL += req;
				}
			}
		}
		return applicationInstanceURL;
	}

}
