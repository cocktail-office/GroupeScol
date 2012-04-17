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

import java.io.File;
import java.io.FileOutputStream;

import com.webobjects.foundation.NSData;

public class PdfManager {
	private static final String LNX_CMD = "gpdf ";
	private static final String MAC_CMD = "open ";
	private final String TEMP_PATH = System.getProperty("java.io.tmpdir").concat("/");
	private String temporaryDir;
	private String filePath;

	public String getTemporaryDir() {
		return temporaryDir;
	}

	public void setTemporaryDir(String dir) {
		temporaryDir = dir;
	}

	/**
	 * Methode qui renvoie le chemin ou a ete depose le pdf
	 * 
	 * @param data
	 *            les donnees du pdf
	 * @param filename
	 *            le nom du fichier qu'on veut lui donner
	 * @return le chemin du pdf
	 */
	public String dataToPDF(NSData data, String fileName) {
		String filePath = "";

		if (data == null) {
			System.out.println("Impossible de récupérer le PDF.");
		}

		setTemporaryDir(TEMP_PATH);

		filePath = getTemporaryDir() + fileName + ".pdf";

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			data.writeToStream(fileOutputStream);
			fileOutputStream.close();
		}
		catch (Exception exception) {
			WindowHandler.showError("Impossible d'ecrire le fichier PDF sur le disque.\n Verifiez qu'un autre fichier n'est pas deja ouvert.");
			exception.printStackTrace();
		}
		// vérifie que le fichier a bien été crée
		try {
			File tmpFile = new File(filePath);
			if (!tmpFile.exists()) {
				System.out.println("Le fichier " + filePath + " n'existe pas.");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return filePath;
	}

	/**
	 * ouvre le pdf a partir d'un chemin param filePath le chemin du pdf a ouvrir
	 */
	public void openPDF(String filePath) throws Exception {
		File aFile = new File(filePath);
		Runtime runtime = Runtime.getRuntime();
		if (System.getProperty("os.name").startsWith("Windows")) {
			runtime.exec(new String[] { "rundll32", "url.dll,FileProtocolHandler", "\"" + aFile + "\"" });
		}
		else
			if (System.getProperty("os.name").startsWith("Linux")) {
				runtime.exec(LNX_CMD + aFile);
			}
			else {
				System.out.println("\nExecution de la commande : " + MAC_CMD + aFile);
				runtime.exec(MAC_CMD + aFile);
			}

	}

	public String dataToXXX(NSData data, String fileName, String extension) {
		String filePath = "";

		if (data == null) {
			System.out.println("Impossible de récupérer le fichier " + fileName);
		}

		setTemporaryDir(TEMP_PATH);

		filePath = getTemporaryDir() + fileName + "." + extension;

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			data.writeToStream(fileOutputStream);
			fileOutputStream.close();
		}
		catch (Exception exception) {
			WindowHandler.showError("Impossible d'ecrire le fichier " + filePath
					+ "sur le disque.\n Verifiez qu'un autre fichier portant le meme nom n'est pas deja ouvert.");
			exception.printStackTrace();
		}

		// vérifie que le fichier a bien été crée
		try {
			File tmpFile = new File(filePath);
			if (!tmpFile.exists()) {
				System.out.println("Le fichier " + filePath + " n'existe pas.");
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return filePath;
	}

}
