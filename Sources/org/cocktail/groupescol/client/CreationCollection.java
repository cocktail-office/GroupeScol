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
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;

public class CreationCollection extends EOInterfaceController {

	private MainClient app = (MainClient) EOApplication.sharedApplication();

	public JCheckBox cBoquante;
	public JButton bAnnuler, bCreer;
	public JTextField tCapa, tCapaInt, tDebutVal, tFinVal, tLibelleCol, tNbGrp, tPrefixGrp;
	public JTextField lDebutVal, lLibelleCol, lNbGrp, lPrefixGrp, tInfos;
	TypeApSeuilHolder infos;
	private EOEditingContext eContext;

	private GroupeFactory groupeFactory;
	private CreationController creationController;
	private ScolGroupeCollection collection;
	private ScolFormationAnnee annee;

	public CreationCollection(EOEditingContext eContext, CreationController creationController, TypeApSeuilHolder infos) {
		super(eContext);
		this.groupeFactory = creationController.groupeFactory();
		this.creationController = creationController;
		this.infos = infos;
	}

	protected void controllerDidLoadArchive(NSDictionary objects) {
		super.controllerDidLoadArchive(objects);
		eContext = editingContext();
		lDebutVal.setOpaque(true);
		lLibelleCol.setOpaque(true);
		lNbGrp.setOpaque(true);
		lPrefixGrp.setOpaque(true);
		Color color = new Color(0xE9967A);
		lDebutVal.setBackground(color);
		lLibelleCol.setBackground(color);
		lNbGrp.setBackground(color);
		lPrefixGrp.setBackground(color);
		if (infos != null) {
			tInfos.setText(infos.toString());
		}
		tInfos.setEditable(false);
		cBoquante.setSelected(true);
		init();
	}

	private void init() {
		if (infos != null && creationController.semestre() != null) {
			Number msemKey = (Number) creationController.semestre().storedValueForKey("msemKey");
			tLibelleCol.setText("C_" + infos.mhcoCode() + "-Seuil_" + infos.mapSeuil() + "-" + msemKey.toString());
			tPrefixGrp.setText(infos.mhcoCode() + "_");
			tCapa.setText((infos.mapSeuil() != null) ? infos.mapSeuil().toString() : "");
		}
		annee = creationController.semestre().scolFormationAnnee();
		tDebutVal.setText(annee.fannKey().toString());
		tFinVal.setText(String.valueOf(annee.fannKey().intValue() + 1));
	}

	public void annuler(Object sender) {
		fermer();
	}

	public void fermer() {
		WindowHandler.closeModal(this);
	}

	public void creerCollection(Object sender) {

		String capa = tCapa.getText();
		String capInt = tCapaInt.getText();
		String debVal = tDebutVal.getText();
		String finVal = tFinVal.getText();
		String libelleCol = tLibelleCol.getText();
		String nbGrp = tNbGrp.getText();
		String prefixGrp = tPrefixGrp.getText();

		if (libelleCol.equals("") || nbGrp.equals("") || prefixGrp.equals("") || debVal.equals("")) {
			WindowHandler.showError("Tous les champs marqués en rouge sont obligatoires");
			return;
		}

		if (creationController.semestre() == null) {
			WindowHandler.showError("Aucun semestre n'est sélectionné");
			return;
		}

		WindowHandler.setWaitCursor(this);

		HashMap mapCol = new HashMap();

		mapCol.put("libelleCollection", libelleCol);
		mapCol.put("nombreGroupes", new Integer(nbGrp));
		mapCol.put("prefixeGroupe", prefixGrp);
		mapCol.put("debutValidite", new Integer(debVal));
		mapCol.put("finValidite", finVal.equals("") ? null : new Integer(finVal));
		mapCol.put("capacite", capa.equals("") ? null : new Integer(capa));
		mapCol.put("capaciteInt", capInt.equals("") ? null : new Integer(capInt));
		mapCol.put("maxTem", cBoquante.isSelected() ? "O" : "N");
		mapCol.put("semestre", creationController.semestre());
		mapCol.put("aps", creationController.getSelectedAps());

		try {
			collection = groupeFactory.creerCollection(mapCol);
		}
		catch (Exception ex) {
			WindowHandler.setDefaultCursor(this);
			if (ex instanceof GroupeException) {
				WindowHandler.showError(ex.getMessage());
			}
			else {
				ex.printStackTrace();
			}
		}

		if (collection != null) {
			creationController.collectionCreated(collection);
			WindowHandler.setDefaultCursor(this);
			collectionSucceed();
		}
	}

	private void collectionSucceed() {
		if (infos != null) {
			infos.setCollectionCreated(true);
		}
		fermer();
	}

}
