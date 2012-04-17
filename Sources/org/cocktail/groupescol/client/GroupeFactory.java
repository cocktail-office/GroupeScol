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

import java.util.HashMap;

import org.cocktail.groupescol.client.eof.CtrlParamAp;
import org.cocktail.groupescol.client.eof.ScolFormationAnnee;
import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;
import org.cocktail.groupescol.client.eof.ScolGroupeInclusion;
import org.cocktail.groupescol.client.eof.ScolGroupeIncompatibilite;
import org.cocktail.groupescol.client.eof.ScolGroupeObjet;
import org.cocktail.groupescol.client.eof.ScolInscriptionEtudiant;
import org.cocktail.groupescol.client.eof.ScolInscriptionGrp;
import org.cocktail.groupescol.client.eof.ScolMaquetteAp;
import org.cocktail.groupescol.client.eof.ScolMaquetteSemestre;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class GroupeFactory {

	private EOEditingContext eContext;

	public GroupeFactory(EOEditingContext eContext) {
		this.eContext = eContext;
	}

	/** renvoie true si la collection existe, false sinon */
	public boolean collectionExiste(String libelle, Number debutValidite) {
		EOQualifier qColl = EOQualifier.qualifierWithQualifierFormat("gcolLibelle=%@ and gcolDateDebut=%@", new NSArray(new Object[] { libelle,
				debutValidite }));
		return (DBHandler.fetchData(eContext, "ScolGroupeCollection", qColl).count() > 0);
	}

	/** permet de creer les groupes de la collection */
	public NSArray creerGroupesPourCollection(ScolGroupeCollection collection, HashMap<String, ?> colMap) throws GroupeException {

		Integer nombreGroupes = (Integer) colMap.get("nombreGroupes");
		String prefixeGroupe = (String) colMap.get("prefixeGroupe");
		Integer debutValidite = (Integer) colMap.get("debutValidite");
		Integer finValidite = (Integer) colMap.get("finValidite");
		Integer capacite = (Integer) colMap.get("capacite");
		Integer capaciteInt = (Integer) colMap.get("capaciteInt");
		String maxTem = (String) colMap.get("maxTem");
		String libelleCol = collection.gcolLibelle();

		// rattachement au semestre et eventuellement aux aps du semestre.
		ScolMaquetteSemestre semestre = (ScolMaquetteSemestre) colMap.get("semestre");
		NSArray aps = (NSArray) colMap.get("aps");

		// creation des groupes
		for (int i = 0; i < nombreGroupes.intValue(); i++) {
			String lclPrefix = null;
			if (nombreGroupes.intValue() > 9 && i < 9) {
				lclPrefix = prefixeGroupe.concat("0");
			}
			else {
				lclPrefix = prefixeGroupe;
			}
			String ggrpCode = lclPrefix + String.valueOf(i + 1);

			creerGroupe(collection, debutValidite, finValidite, capaciteInt, ggrpCode, libelleCol + " - " + ggrpCode, capacite, maxTem, semestre,
					aps, false);
		}

		return collection.scolGroupeGrps();
	}

	public ScolGroupeGrp creerGroupe(ScolGroupeCollection collection, HashMap<String, ?> infosGrp, boolean saveChanges) throws GroupeException {
		String ggrpCode = (String) infosGrp.get("code");
		String ggrpLibelle = (String) infosGrp.get("libelle");
		Integer capacite = (Integer) infosGrp.get("maxCap");
		Integer capaciteInt = (Integer) infosGrp.get("intCap");
		Integer debutValidite = (Integer) infosGrp.get("dateDebut");
		Integer finValidite = (Integer) infosGrp.get("dateFin");
		String maxTem = (String) infosGrp.get("maxTem");
		ScolMaquetteSemestre semestre = (ScolMaquetteSemestre) infosGrp.get("semestre");
		NSArray aps = (NSArray) infosGrp.get("aps");
		return creerGroupe(collection, debutValidite, finValidite, capaciteInt, ggrpCode, ggrpLibelle, capacite, maxTem, semestre, aps, saveChanges);
	}

	public ScolGroupeGrp creerGroupe(ScolGroupeCollection collection, Integer debutValidite, Integer finValidite, Integer capaciteInt,
			String ggrpCode, String ggrpLibelle, Integer capacite, String maxTem, ScolMaquetteSemestre semestre, NSArray aps, boolean saveChanges)
			throws GroupeException {
		ScolGroupeGrp groupe = collection.createScolGroupeGrpsRelationship();
		groupe.setGgrpDateDebut(debutValidite);
		groupe.setGgrpDateFin(finValidite);
		groupe.setGgrpIntCapacite(capaciteInt);
		groupe.setGgrpCode(ggrpCode);
		groupe.setGgrpLibelle(ggrpLibelle);
		groupe.setGgrpMaxCapacite(capacite);
		groupe.setGgrpMaxTemoin(maxTem);

		// rattachement au semestre
		ScolGroupeObjet groupeObjet = groupe.createScolGroupeObjetsRelationship();
		groupeObjet.setGobjType("VDI");
		groupeObjet.setScolFormationAnneeRelationship(semestre.scolFormationAnnee());
		groupeObjet.setScolMaquetteSemestreRelationship(semestre);

		// rattachement aux aps
		for (int iap = 0; iap < aps.count(); iap++) {
			ScolMaquetteAp currentAp = (ScolMaquetteAp) aps.objectAtIndex(iap);
			ScolGroupeObjet groupeObjetAp = groupe.createScolGroupeObjetsRelationship();
			groupeObjetAp.setGobjType("ELP");
			groupeObjetAp.setScolFormationAnneeRelationship(semestre.scolFormationAnnee());
			groupeObjetAp.setScolMaquetteApRelationship(currentAp);
		}

		// creation des incompatibilites
		NSArray groupes = collection.scolGroupeGrps();
		for (int j = 0; j < groupes.count(); j++) {
			ScolGroupeGrp grp2 = (ScolGroupeGrp) groupes.objectAtIndex(j);
			if (grp2.equals(groupe) == false) {
				ScolGroupeIncompatibilite incomp = ScolGroupeIncompatibilite.createScolGroupeIncompatibilite(eContext);
				incomp.setScolGroupeGrp1Relationship(groupe);
				incomp.setScolGroupeGrp2Relationship(grp2);
			}
		}

		if (saveChanges) {
			if (doSaveChanges() == false) {
				return null;
			}
		}
		return groupe;
	}

	/** supprime correctement un groupe */
	public void supprimerGroupe(ScolGroupeGrp groupe, boolean saveChanges) throws GroupeException {
		groupe.deleteAllInclusFilsRelationships();
		groupe.deleteAllInclusPereRelationships();
		groupe.deleteAllScolGroupeObjetsRelationships();

		// suppression paramètres attachés au groupe...
		NSArray tmpArray = groupe.ctrlParamAps().immutableClone();
		for (int j = 0; j < tmpArray.count(); j++) {
			CtrlParamAp cpa = (CtrlParamAp) tmpArray.objectAtIndex(j);
			cpa.deleteAllCtrlParamApIndividusRelationships();
			cpa.deleteAllCtrlParamApObjetsRelationships();
			cpa.deleteAllCtrlParamApSalleChoixsRelationships();
			cpa.deleteAllCtrlParamApSallesRelationships();
		}
		groupe.deleteAllCtrlParamApsRelationships();

		groupe.setScolGroupeCollectionRelationship(null);
		eContext.deleteObject(groupe);

		if (saveChanges) {
			doSaveChanges();
		}
	}

	/** permet de creer une collection de groupes */
	public ScolGroupeCollection creerCollection(HashMap<String, ?> colMap) throws GroupeException {

		String libelleCollection = (String) colMap.get("libelleCollection");
		Integer debutValidite = (Integer) colMap.get("debutValidite");
		Integer finValidite = (Integer) colMap.get("finValidite");

		if (collectionExiste(libelleCollection, debutValidite)) {
			throw new GroupeException("La collection " + libelleCollection + " existe déjà pour " + debutValidite);
		}

		ScolGroupeCollection collection = ScolGroupeCollection.createScolGroupeCollection(eContext, debutValidite, libelleCollection);
		collection.setGcolDateFin(finValidite);
		this.creerGroupesPourCollection(collection, colMap);

		if (doSaveChanges() == false) {
			return null;
		}
		return collection;
	}

	/** permet de supprimer un ensemble de collections */
	public boolean supprimerCollections(NSArray collections) throws Exception {
		for (int ic = 0; ic < collections.count(); ic++) {
			ScolGroupeCollection collection = (ScolGroupeCollection) collections.objectAtIndex(ic);
			NSArray groupes = collection.scolGroupeGrps().immutableClone();
			for (int i = 0; i < groupes.count(); i++) {
				supprimerGroupe((ScolGroupeGrp) groupes.objectAtIndex(i), false);
			}
			collection.setScolFormationAnneeRelationship(null);
			eContext.deleteObject(collection);
		}
		return doSaveChanges();
	}

	/** modifier la collection donnee avec les nouveaux parametres contenus dans colMap */
	public void modifierApsPourCollection(ScolGroupeCollection collection, NSArray aps, ScolFormationAnnee annee) throws Exception {
		NSMutableArray apsDemandes = aps.mutableClone();
		NSArray groupes = collection.scolGroupeGrps();
		NSArray apsExistants = getApsForGroupe((ScolGroupeGrp) groupes.objectAtIndex(0));

		for (int i = 0; i < apsExistants.count(); i++) {
			ScolMaquetteAp currentAp = (ScolMaquetteAp) apsExistants.objectAtIndex(i);
			if (!apsDemandes.containsObject(currentAp)) {
				retirerApPourCollection(collection, currentAp);
			}
			else {
				apsDemandes.removeObject(currentAp);
			}
		}
		affecterApsPourCollection(collection, apsDemandes, annee);
	}

	/** permet de modifier un groupe avec les infos passes dans le hashmap */
	public boolean modifierGroupe(ScolGroupeGrp groupe, HashMap<String, ?> infosGrp, boolean saveChanges) throws GroupeException {
		String code = (String) infosGrp.get("code");
		String libelle = (String) infosGrp.get("libelle");
		Number maxCap = (Number) infosGrp.get("maxCap");
		Number intCap = (Number) infosGrp.get("intCap");
		Number dateDebut = (Number) infosGrp.get("dateDebut");
		Number dateFin = (Number) infosGrp.get("dateFin");
		String maxTem = (String) infosGrp.get("maxTem");

		groupe.setGgrpDateDebut((Integer) dateDebut);
		groupe.setGgrpDateFin((Integer) dateFin);
		groupe.setGgrpIntCapacite((Integer) intCap);

		groupe.setGgrpCode(code);
		groupe.setGgrpLibelle(libelle);
		groupe.setGgrpMaxCapacite((Integer) maxCap);
		groupe.setGgrpMaxTemoin(maxTem);

		if (saveChanges) {
			return doSaveChanges();
		}
		else {
			return true;
		}
	}

	/** permet de detacher l'ap de tous les groupes de la collection en parametre /!\ sans faire de saveChanges */
	public void retirerApPourCollection(ScolGroupeCollection collection, ScolMaquetteAp ap) {
		NSArray groupes = collection.scolGroupeGrps();

		for (int i = 0; i < groupes.count(); i++) {
			ScolGroupeGrp grp = (ScolGroupeGrp) groupes.objectAtIndex(i);
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolGroupeGrp=%@ and scolMaquetteAp=%@ gobjType='ELP'", new NSArray(
					new Object[] { grp, ap }));

			NSArray tmpArray = DBHandler.fetchData(eContext, "ScolGroupeObjet", qualObj);
			for (int j = 0; j < tmpArray.count(); j++) {
				ScolGroupeObjet groupeObjet = (ScolGroupeObjet) tmpArray.objectAtIndex(j);
				groupeObjet.setScolFormationAnneeRelationship(null);
				groupeObjet.setScolGroupeGrpRelationship(null);
				groupeObjet.setScolMaquetteApRelationship(null);
				groupeObjet.setScolMaquetteSemestreRelationship(null);
				eContext.deleteObject(groupeObjet);
			}
		}
	}

	/** affecte les Aps a tous les groupes de la collection, /!\ sans faire de saveChanges */
	public void affecterApsPourCollection(ScolGroupeCollection collection, NSArray aps, ScolFormationAnnee annee) {
		EOQualifier qualGrp = DBHandler.getSimpleQualifier("scolGroupeCollection", collection);
		NSArray groupes = DBHandler.fetchData(eContext, "ScolGroupeGrp", qualGrp);
		ScolGroupeObjet groupeObjet = null;
		for (int i = 0; i < groupes.count(); i++) {
			ScolGroupeGrp groupe = (ScolGroupeGrp) groupes.objectAtIndex(i);
			DBHandler.invalidateObject(eContext, groupe);
			for (int iap = 0; iap < aps.count(); iap++) {
				ScolMaquetteAp currentAp = (ScolMaquetteAp) aps.objectAtIndex(iap);
				DBHandler.invalidateObject(eContext, currentAp);
				groupeObjet = (ScolGroupeObjet) GenericFactory.getInstance(eContext, "ScolGroupeObjet");
				groupeObjet.setGobjType("ELP");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(annee, "scolFormationAnnee");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(groupe, "scolGroupeGrp");
				groupeObjet.addObjectToBothSidesOfRelationshipWithKey(currentAp, "scolMaquetteAp");
			}
		}
	}

	/** renvoie true si l'etudiant est inscrit au groupe, false sinon */
	public boolean etudiantInscritDansGroupe(ScolInscriptionEtudiant etudiant, ScolGroupeGrp groupe) throws GroupeException {
		EOQualifier qualifEtudiant = EOQualifier.qualifierWithQualifierFormat("scolInscriptionEtudiant=%@ and scolGroupeGrp=%@", new NSArray(
				new Object[] { etudiant, groupe }));
		return (DBHandler.fetchData(eContext, "ScolInscriptionGrp", qualifEtudiant).count() > 0);
	}

	public NSArray ajouterEtudiantsAuGroupe(NSArray etudiants, ScolGroupeGrp groupe, ScolFormationAnnee annee) throws GroupeException {
		NSMutableArray inscriptionsGrp = new NSMutableArray();

		int dejaInscrits = groupe.scolInscriptionGrps().count();
		int seuil = groupe.ggrpMaxCapacite().intValue();
		int cntEtud = etudiants.count();
		if (groupe.ggrpMaxTemoin().equals("O") && dejaInscrits + cntEtud > seuil) {
			StringBuffer msg = new StringBuffer();
			msg.append("La capacité maximale du groupe a été atteinte,\n");
			msg.append("Veuillez enlever ");
			msg.append(String.valueOf(dejaInscrits + cntEtud - seuil));
			msg.append(" étudiants de la sélection avant de continuer\n");
			msg.append("Ou bien rendre la capacité Max non bloquante.");
			throw new GroupeException(msg.toString());
		}

		for (int i = 0; i < etudiants.count(); i++) {
			ScolInscriptionEtudiant etudiant = (ScolInscriptionEtudiant) etudiants.objectAtIndex(i);

			if (etudiantInscritDansGroupe(etudiant, groupe)) {
				throw new GroupeException("L'étudiant " + etudiant + " est déjà dans le groupe " + groupe);
			}
			else {
				ScolInscriptionGrp inscriptionGrp = ScolInscriptionGrp.createScolInscriptionGrp(eContext, "N", groupe, etudiant);
				inscriptionGrp.setScolFormationAnneeRelationship(annee);
				inscriptionsGrp.addObject(inscriptionGrp);
			}
		}

		if (doSaveChanges() == false) {
			inscriptionsGrp.removeAllObjects();
		}
		return inscriptionsGrp;
	}

	/** supprime les inscriptions au groupe passees en parametre (SCOL_INSCRIPTION_GRP) */
	public boolean retirerEtudiantsDuGroupe(NSArray inscriptionsGrp) throws GroupeException {
		NSMutableArray tmpArray = inscriptionsGrp.mutableClone();
		while (tmpArray.count() > 0) {
			ScolInscriptionGrp inscriptionGrp = (ScolInscriptionGrp) tmpArray.removeLastObject();
			inscriptionGrp.setScolFormationAnneeRelationship(null);
			inscriptionGrp.setScolGroupeGrpRelationship(null);
			inscriptionGrp.setScolInscriptionEtudiantRelationship(null);
			eContext.deleteObject(inscriptionGrp);
		}
		return doSaveChanges();
	}

	/**
	 * permet d'inclure un ensemble de groupes dans un autre groupe (SCOL_GROUPE_INCLUSION) dans cette table ggrp_key1 est le pere et
	 * ggrp_key2 est le fils
	 */
	public boolean inclureGroupesDansGroupe(NSArray groupesAInclure, ScolGroupeGrp selectedGroupe) throws GroupeException {

		if (selectedGroupe == null || groupesAInclure.count() == 0) {
			return false;
		}

		NSArray dejaInclus = (NSArray) selectedGroupe.valueForKeyPath(ScolGroupeGrp.INCLUS_FILS_KEY + "."
				+ ScolGroupeInclusion.SCOL_GROUPE_GRP_FILS_KEY);
		NSMutableArray dejaInclusAutresGroupes = new NSMutableArray();
		for (int i = 0; i < selectedGroupe.scolGroupeCollection().scolGroupeGrps().count(); i++) {
			ScolGroupeGrp grp = (ScolGroupeGrp) selectedGroupe.scolGroupeCollection().scolGroupeGrps().objectAtIndex(i);
			dejaInclusAutresGroupes.addObjectsFromArray((NSArray) grp.valueForKeyPath(ScolGroupeGrp.INCLUS_FILS_KEY + "."
					+ ScolGroupeInclusion.SCOL_GROUPE_GRP_FILS_KEY));
		}

		// test si pas deja inclus
		for (int i = 0; i < groupesAInclure.count(); i++) {
			ScolGroupeGrp filsAInclure = (ScolGroupeGrp) groupesAInclure.objectAtIndex(i);

			if (filsAInclure.equals(selectedGroupe)) {
				throw new GroupeException("Impossible d'inclure un groupe dans lui même.\nCela poserait des problèmes.");
			}

			if (filsAInclure.ggrpMaxCapacite().intValue() > selectedGroupe.ggrpMaxCapacite().intValue() && selectedGroupe.ggrpMaxTemoin().equals("O")) {
				StringBuffer msg = new StringBuffer();
				msg.append("le groupe ");
				msg.append(filsAInclure);
				msg.append(" a une capacité supérieure a celle du groupe ");
				msg.append(selectedGroupe);
				msg.append(".\nImpossible de faire cette inclusion");
				throw new GroupeException(msg.toString());
			}

			if (dejaInclus.containsObject(filsAInclure)) {
				throw new GroupeException("le groupe " + filsAInclure + " est déjà inclus dans le groupe " + selectedGroupe);
			}

			if (dejaInclusAutresGroupes.containsObject(filsAInclure)) {
				throw new GroupeException("le groupe " + filsAInclure + " est déjà inclus dans un autre groupe de la même collection");
			}

			NSArray inclusDansFils = (NSArray) filsAInclure.valueForKeyPath(ScolGroupeGrp.INCLUS_FILS_KEY + "."
					+ ScolGroupeInclusion.SCOL_GROUPE_GRP_FILS_KEY);

			if (inclusDansFils.containsObject(selectedGroupe)) {
				StringBuffer msg = new StringBuffer();
				msg.append("le groupe ");
				msg.append(selectedGroupe.toString());
				msg.append(" est deja inclus dans le groupe ");
				msg.append(filsAInclure.toString());
				msg.append(".\nImpossible d'inclure un groupe père dans un groupe fils");
				throw new GroupeException(msg.toString());
			}
			ScolGroupeInclusion inclusion = ScolGroupeInclusion.createScolGroupeInclusion(eContext);
			inclusion.setScolGroupeGrpPereRelationship(selectedGroupe);
			inclusion.setScolGroupeGrpFilsRelationship(filsAInclure);
		}

		return doSaveChanges();
	}

	/** supprime proprement une inclusion */
	public boolean supprimerInclusion(ScolGroupeInclusion inclusion) {

		try {
			inclusion.setScolGroupeGrpFilsRelationship(null);
			inclusion.setScolGroupeGrpPereRelationship(null);
			eContext.deleteObject(inclusion);
			return doSaveChanges();
		}
		catch (Exception e) {
			if (e instanceof GroupeException) {
				WindowHandler.showError(e.getMessage());
			}
			else {
				e.printStackTrace();
			}
			return false;
		}
	}

	/** retourne les ancetres du groupe */
	public NSArray parentsPourGroupe(ScolGroupeGrp groupe) {

		NSArray ascendants = new NSArray();
		NSArray peres = (NSArray) groupe.valueForKey(ScolGroupeGrp.INCLUS_PERE_KEY);

		for (int i = 0; i < peres.count(); i++) {
			ScolGroupeInclusion inclusion = (ScolGroupeInclusion) peres.objectAtIndex(i);
			ScolGroupeGrp unPere = inclusion.scolGroupeGrpPere();
			if (unPere != null) {
				ascendants = ascendants.arrayByAddingObject(unPere);
				ascendants = ascendants.arrayByAddingObjectsFromArray(parentsPourGroupe(unPere));
			}
		}
		return ascendants;
	}

	/** effectue un save changes et renvoie true si ok, false si erreur */
	public boolean doSaveChanges() throws GroupeException {
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

	// methodes souvent utilisees.
	public NSArray getApsForGroupe(ScolGroupeGrp grp) {
		if (grp != null) {
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolGroupeObjets.scolGroupeGrp=%@ and scolGroupeObjets.gobjType='ELP'",
					new NSArray(grp));

			return DBHandler.fetchData(eContext, "ScolMaquetteAp", qualObj);
		}
		else {
			return new NSArray();
		}
	}

	/** retourne les groupes rattaches a l'AP */
	public NSArray getGroupesForAp(ScolMaquetteAp ap) {
		if (ap != null) {
			EOQualifier qualObj = EOQualifier.qualifierWithQualifierFormat("scolGroupeObjets.scolMaquetteAp=%@ and scolGroupeObjets.gobjType='ELP'",
					new NSArray(ap));

			return DBHandler.fetchData(eContext, "ScolGroupeGrp", qualObj);
		}
		else {
			return new NSArray();
		}
	}

	/** permet de recuperer les groupes enfants du dernier niveau (qui n'ont pas de fils) du groupe en parametres */
	public NSArray enfantsVentiles(ScolGroupeGrp groupe) {
		NSMutableArray children = new NSMutableArray();
		NSArray fils = (NSArray) groupe.valueForKeyPath("inclusFils.scolGroupeGrpFils");

		if (fils.count() > 0) {
			for (int i = 0; i < fils.count(); i++) {
				children.addObjectsFromArray(enfantsVentiles((ScolGroupeGrp) fils.objectAtIndex(i)));
			}
		}
		else {
			children.addObject(groupe);
		}
		return children;
	}

	/** retourne tous les 'horaire code' valides */
	public NSArray getHoraireCode() {
		EOQualifier qualHor = EOQualifier.qualifierWithQualifierFormat("mhcoValidite='O'", null);
		return DBHandler.fetchData(eContext, "ScolMaquetteHoraireCode", qualHor);
	}

}
