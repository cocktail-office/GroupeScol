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

import java.io.ByteArrayOutputStream;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.cocktail.groupescol.serveur.eof.ScolInscriptionEtudiant;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;

public class XlsFileFactory {

	/** permet de generer un fichier Excel avec la liste des etudiants 'students' et les infos d'entete 'infos' */
	public NSData xlsFileEtudiants(NSArray students, NSDictionary infos) throws Exception {

		String diplome = (String) infos.objectForKey("diplome");
		String specialite = (String) infos.objectForKey("specialite");
		String annee = (String) infos.objectForKey("annee");
		infos.objectForKey("ap");
		String groupe = (String) infos.objectForKey("groupe");
		String semestre = (String) infos.objectForKey("semestre");

		ByteArrayOutputStream localByteArrayOS = new ByteArrayOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(localByteArrayOS);

		WritableSheet sheet = workbook.createSheet("Liste Etudiants", 0);

		WritableFont font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setWrap(false);
		cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		cellFormat.setBackground(Colour.SKY_BLUE);
		Label lbl;

		int idxRow = 0;

		lbl = new Label(0, idxRow, diplome + " - " + specialite + " - Ann�e Univ. " + annee, cellFormat);
		sheet.mergeCells(0, idxRow, 8, idxRow);
		sheet.addCell(lbl);

		idxRow = 1;

		lbl = new Label(0, idxRow, semestre + " - Groupe : " + groupe, cellFormat);
		sheet.mergeCells(0, idxRow, 8, idxRow);
		sheet.addCell(lbl);

		idxRow = 3;

		lbl = new Label(0, idxRow, "Nom", cellFormat);
		sheet.mergeCells(0, idxRow, 2, idxRow);
		sheet.addCell(lbl);

		lbl = new Label(3, idxRow, "Prenom", cellFormat);
		sheet.mergeCells(3, idxRow, 5, idxRow);
		sheet.addCell(lbl);

		lbl = new Label(6, idxRow, "No \u00e9tudiant", cellFormat);
		sheet.mergeCells(6, idxRow, 8, idxRow);
		sheet.addCell(lbl);

		idxRow = 5;
		for (int i = 0; i < students.count(); i++) {
			ScolInscriptionEtudiant etudiant = (ScolInscriptionEtudiant) students.objectAtIndex(i);
			idxRow = this.writeEtudiant(etudiant, sheet, idxRow);
		}

		workbook.write();
		workbook.close();

		return new NSData(localByteArrayOS.toByteArray());
	}

	/** permet d'ecrire une ligne dans le fichier excel, nom,prenom et numero de l'etudiant */
	public int writeEtudiant(ScolInscriptionEtudiant etudiant, WritableSheet sheet, int row) throws Exception {
		Label lbl;
		Colour backgrd = Colour.VERY_LIGHT_YELLOW;
		WritableFont font = new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE, WritableFont.NO_BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLACK);

		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setWrap(false);
		cellFormat.setBackground(backgrd);

		int localRowNum = row;

		lbl = new Label(0, localRowNum, etudiant.adrNom(), cellFormat);
		sheet.mergeCells(0, localRowNum, 2, localRowNum);
		sheet.addCell(lbl);

		lbl = new Label(3, localRowNum, etudiant.adrPrenom(), cellFormat);
		sheet.mergeCells(3, localRowNum, 5, localRowNum);
		sheet.addCell(lbl);

		lbl = new Label(6, localRowNum, etudiant.etudNumero().toString(), cellFormat);
		sheet.mergeCells(6, localRowNum, 8, localRowNum);
		sheet.addCell(lbl);
		localRowNum = localRowNum + 1;
		return localRowNum;
	}

}
