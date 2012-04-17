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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;

import org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;

import fr.univlr.cri.print.LRPrinter;
import fr.univlr.cri.util.LRXMLWriter;
import fr.univlr.cri.util.StreamCtrl;

public class PrintFactory {

	private String maquetteID;
	private LRPrinter printer;
	private byte[] xmlbytes;
	private ByteArrayInputStream xmlStream;
	private NSDictionary printParameters;

	public PrintFactory(NSDictionary printParameters) {
		this.printParameters = printParameters;
		maquetteID = (String) printParameters.valueForKey("MAQUETTE_ID");
	}

	/** genererPDF */
	private InputStream genererPDF(InputStream xmlstream, int streamSize, String maquetteID) throws Exception {
		try {
			InputStream stream = null;

			try {
				printer = LRPrinter.newDefaultInstance(printParameters.hashtable());
			}
			catch (ClassNotFoundException e) {
				NSLog.out.appendln("LRPrinter : " + e.getMessage());
				return stream;
			}

			stream = printer.printFileImmediate(maquetteID, xmlstream, streamSize);

			int jobId = printer.getJobID();

			// On verifie si l'operation s'est bien passé
			if (printer.hasSuccess()) {
				return stream;
			}
			else {
				NSLog.out.appendln("Erreur Six :  " + printer.getMessage());
				NSLog.out.appendln("jobId " + jobId);
				return null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public NSData imprimerTrombino(NSArray students, NSDictionary infos) throws Exception {

		String diplome = (String) infos.objectForKey("diplome");
		String specialite = (String) infos.objectForKey("specialite");
		String annee = (String) infos.objectForKey("annee");
		String semestre = (String) infos.objectForKey("semestre");
		String groupe = (String) infos.objectForKey("groupe");

		StringWriter myStringWriter = new StringWriter();
		LRXMLWriter myLRXMLWriter = new LRXMLWriter(myStringWriter);

		new EOEditingContext();
		myLRXMLWriter.setUseCompactMode(true);
		myLRXMLWriter.setCharsToEscape("<>&");
		myLRXMLWriter.setEscapeSpecChars(true);

		try {
			// On initialise le document
			myLRXMLWriter.startDocument();
			// balise PlanTrombino
			myLRXMLWriter.startElement("PlanTrombino");
			// balise Entete (entete du document)
			myLRXMLWriter.startElement("Entete");
			myLRXMLWriter.writeElement("Diplome", diplome);
			myLRXMLWriter.writeElement("Annee", annee);
			myLRXMLWriter.writeElement("Specialite", specialite);
			myLRXMLWriter.writeElement("semestre", semestre);
			myLRXMLWriter.writeElement("Groupe", groupe);
			// fin balise Entete
			myLRXMLWriter.endElement();
			// Balise InfoTrombino (information du document)
			myLRXMLWriter.startElement("InfoTrombino");
			int nbLigne = (students.count() - 1) / 8 + 1;
			for (int i = 0; i < nbLigne; i++) {
				myLRXMLWriter.startElement("Ligne");
				for (int j = 0; j < 8; j++) {
					int index = 8 * i + j;
					if (index < students.count()) {
						// balise Etudiant (infomations sur un Etudiant)
						myLRXMLWriter.startElement("Etudiant");
						ScolInscriptionEtudiant student = (ScolInscriptionEtudiant) students.objectAtIndex(index);
						try {
							String adrRecupPhoto = (String) printParameters.valueForKey("directActionPhoto");
							String sessId = (String) printParameters.valueForKey("sessionID");
							String photo = adrRecupPhoto + sessId + "-" + paddingLeftWithZero((Number) student.valueForKey("noIndividu"), 4);
							myLRXMLWriter.writeElement("Photo", photo);
						}
						catch (Exception e) {
							e.printStackTrace();
							// si aucune photo on affiche rien
							myLRXMLWriter.writeElement("Photo", "");
						}

						myLRXMLWriter.writeElement("Nom", student.adrNom());
						myLRXMLWriter.writeElement("Prenom", student.adrPrenom());
						// fin balise Etudiant
						myLRXMLWriter.endElement();
					}
				}
				// fin balise Ligne
				myLRXMLWriter.endElement();
			}
			// fin balise InfoTrombino
			myLRXMLWriter.endElement();
			// fin balise PlanTrombino
			myLRXMLWriter.endElement();
			// Il est recommende de finir le document par l'appel suivant
			myLRXMLWriter.endDocument();
			// Terminer l'ecriture du document XML
			myLRXMLWriter.close();

			xmlbytes = myStringWriter.toString().getBytes();
			xmlStream = new ByteArrayInputStream(xmlbytes);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Erreur lors de la generation du PDF :" + ex.getMessage());
		}

		// ///

		xmlbytes = myStringWriter.toString().getBytes();
		xmlStream = new ByteArrayInputStream(xmlbytes);
		InputStream pdfStream = genererPDF(xmlStream, xmlbytes.length, maquetteID);
		if (pdfStream == null) {
			throw new Exception("Le flux PDF est nul.");
		}
		ByteArrayOutputStream tmpByteArrayOutputStream = new ByteArrayOutputStream();
		StreamCtrl.writeContentToStream(pdfStream, tmpByteArrayOutputStream, -1);

		return new NSData(tmpByteArrayOutputStream.toByteArray());

	}

	/**
	 * Effectue un remplissage avec des zeros pour atteindre la taille necessaire
	 */
	protected String paddingLeftWithZero(Number clef, int sizeOfString) {
		String myString = String.valueOf(clef);
		int myStringLength = myString.length();
		for (int i = 0; i < (sizeOfString - myStringLength); i++) {
			myString = '0' + myString;
		}
		return myString;
	}

}
