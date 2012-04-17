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

import fr.univlr.cri.webapp.VersionCocktail;

// Versions...
// nom de l'application
public final class Version extends VersionCocktail {

	// Nom de l'appli
	public static final String APPLI_ID = "GroupeScol";

	// Version appli
	public static final String VERSIONDATE = "03/04/2012";

	public static final int VERSIONNUMMAJ = 1;
	public static final int VERSIONNUMMIN = 0;
	public static final int VERSIONNUMPATCH = 6;
	public static final int VERSIONNUMBUILD = 14;

	// Version minimum de la base de donnees necessaire pour fonctionner avec cette version
	private static final String MIN_APPLI_BD_VERSION = "04.10.01.01";

	// Pour affichage en ligne de commande...
	public static void main(final String argv[]) {
		System.out.println("");
		System.out.println(APPLI_ID);
		System.out.println("Version " + VERSIONNUMMAJ + "." + VERSIONNUMMIN + "." + VERSIONNUMPATCH + "." + VERSIONNUMBUILD + "." + " du "
				+ VERSIONDATE);
		System.out.println("(c) " + VERSIONDATE.substring(VERSIONDATE.length() - 4) + " Association Cocktail");
		System.out.println("");
		System.out.println("Version minimum de la base de donnees necessaire : " + MIN_APPLI_BD_VERSION);
		System.out.println("");
	}

	public VersionCocktailRequirements[] dependencies() {
		return new VersionCocktailRequirements[] {
				new VersionCocktailRequirements(new fr.univlr.cri.webapp.VersionCocktailWebObjects(), "5.2.4", null, true),
				new VersionCocktailRequirements(new fr.univlr.cri.webapp.VersionCocktailJava(), "1.4.2", "1.5", true),
				new VersionCocktailRequirements(new fr.univlr.cri.webext.Version(), "3", null, false),
				new VersionCocktailRequirements(new fr.univlr.cri.webapp.Version(), "3", null, false),
				new VersionCocktailRequirements(new VersionDB(), MIN_APPLI_BD_VERSION, null, true) };
	}

	public static String versionNum() {
		return Version.VERSIONNUMMAJ + "." + Version.VERSIONNUMMIN + "." + Version.VERSIONNUMPATCH + "." + Version.VERSIONNUMBUILD;
	}

	public String name() {
		return APPLI_ID;
	}

	public String date() {
		return VERSIONDATE;
	}

	public int versionNumMaj() {
		return VERSIONNUMMAJ;
	}

	public int versionNumMin() {
		return VERSIONNUMMIN;
	}

	public int versionNumPatch() {
		return VERSIONNUMPATCH;
	}

	public int versionNumBuild() {
		return VERSIONNUMBUILD;
	}

}
