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

import org.cocktail.groupescol.serveur.eof.ScolDroitLogin;
import org.cocktail.groupescol.serveur.eof.ScolFormationSpecialisation;
import org.cocktail.groupescol.serveur.eof.ScolGroupeGrp;
import org.cocktail.groupescol.serveur.eof.ScolMaquetteParcours;
import org.cocktail.groupescol.serveur.eof.ScolMaquetteSemestre;

import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOSession;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOGlobalID;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eodistribution.EODistributionContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSTimeZone;
import com.webobjects.foundation.NSTimestamp;

import fr.univlr.cri.util.CRIpto;
import fr.univlr.cri.webapp.LRConfig;
import fr.univlr.cri.webapp.LRUserInfo;
import fr.univlr.cri.webapp.LRUserInfoDB;

public class Session extends WOSession {

	private EOEditingContext eContext;
	private NSMutableDictionary userInfos;
	private LRConfig cfg;
	private Application woApplication;
	private Number persId = null, noIndividu = null;
	private String userName = null;
	private LRUserInfoDB lrUser;
	private GroupeFactory groupeFactory;

	public Session() {
		super();
		setTimeOut(43200); // 12heures
		woApplication = (Application) WOApplication.application();
		cfg = woApplication.config();
		userInfos = new NSMutableDictionary();
		this.eContext = this.defaultEditingContext();
		groupeFactory = new GroupeFactory(eContext);
	}

	public Application woApplication() {
		return woApplication;
	}

	public LRConfig config() {
		return woApplication.config();
	}

	private void initUserInfos() {
		try {
			userInfos.takeValueForKey(persId, "persId");
			noIndividu = lrUser.noIndividu();
			userInfos.takeValueForKey(noIndividu, "noIndividu");
			userInfos.takeValueForKey(lrUser.email(), "email");
			userInfos.takeValueForKey(printParameters(), "printParameters");
			userInfos.takeValueForKey(userName, "login");

			EOQualifier qDroit = EOQualifier.qualifierWithQualifierFormat("dlogValide='O' and dlogLogin='" + userName + "'", null);
			NSArray droitsLogin = DBHandler.fetchData(eContext, "ScolDroitLogin", qDroit);

			if (droitsLogin.count() > 0) {
				userInfos.takeValueForKey(((ScolDroitLogin) droitsLogin.objectAtIndex(0)).dlogKey(), "droits");
			}
			else {
				userInfos.takeValueForKey(new Integer(-1), "droits");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NSDictionary printParameters() {

		// information pour SIX
		String daPhoto = cfg.stringForKey("DIRECT_ACTION_PHOTO");
		NSMutableDictionary params = new NSMutableDictionary();
		params.takeValueForKey(cfg.valueForKey("XML_PRINTER_DRIVER"), "XML_PRINTER_DRIVER");
		params.takeValueForKey(cfg.valueForKey("SIX_SERVICE_HOST"), "SIX_SERVICE_HOST");
		params.takeValueForKey(cfg.valueForKey("SIX_SERVICE_PORT"), "SIX_SERVICE_PORT");
		params.takeValueForKey(cfg.valueForKey("SIX_USE_COMPRESSION"), "SIX_USE_COMPRESSION");
		params.takeValueForKey(cfg.valueForKey("MAQUETTE_ID"), "MAQUETTE_ID");
		params.takeValueForKey(daPhoto, "directActionPhoto");
		params.takeValueForKey(this.sessionID(), "sessionID");
		return params;
	}

	/** renvoie le timezone cote client */
	public NSTimeZone clientSideRequestDefaultTimeZone() {
		String tzStr = (String) cfg.valueForKey("TIME_ZONE");
		NSTimeZone tz;
		if (tzStr == null) {
			tz = NSTimeZone.defaultTimeZone();
		}
		else {
			tz = NSTimeZone.timeZoneWithName(tzStr, false);
		}
		return tz;
	}

	/** dit si le login/password doit etre utilise ou non */
	public Boolean clientSideRequestUseLoginPassword() {
		return Boolean.valueOf(cfg.booleanForKey("SAUT_USER"));
	}

	/**
	 * verifie le login/mot de passe avec LRUserInfoDB
	 */
	public NSDictionary clientSideRequestUserInfos(String login, String passwd, String casAuth) {

		String rootPW = cfg.stringForKey("APP_ADMIN_PASSWORD");

		userName = CRIpto.decrypt(login);
		String passwdClair = null;
		if (casAuth.equals("N")) {
			passwdClair = CRIpto.decrypt(passwd);
		}
		else {
			passwdClair = null;
		}

		lrUser = new LRUserInfoDB(woApplication.dataBus());
		lrUser.setRootPass(rootPW);
		lrUser.compteForLogin(userName, passwdClair, true);
		if (lrUser.errorCode() == LRUserInfo.ERROR_NONE) {
			persId = lrUser.persId();

			String heure = FormatHandler.dateToStr(new NSTimestamp(), " @ %d/%m/%Y %H:%M");
			NSLog.out.appendln("login=" + userName + " noIndividu=" + lrUser.noIndividu() + heure);

			initUserInfos();
			return userInfos;
		}
		else {
			NSLog.out.appendln("Erreur : " + lrUser.errorMessage());
			return null;
		}
	}

	public NSData clientSideRequestImprimerTrombino(NSArray etudiants, NSDictionary infos, NSDictionary printParameters) {
		PrintFactory printFactory = new PrintFactory(printParameters);
		try {
			NSData pdfData = printFactory.imprimerTrombino(etudiants, infos);
			return pdfData;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object clientSideRequestPrimaryKey(EOGlobalID gid, String primKey) {
		try {
			EOEnterpriseObject record = eContext.objectForGlobalID(gid);
			NSDictionary keys = EOUtilities.primaryKeyForObject(eContext, record);
			return keys.objectForKey(primKey);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**  */
	private Object primaryKey(EOGenericRecord record, String key) {
		try {
			NSDictionary keys = EOUtilities.primaryKeyForObject(eContext, record);
			return keys.objectForKey(key);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean distributionContextShouldFollowKeyPath(EODistributionContext context, String path) {
		if (path.equals("session")) {
			return true;
		}
		else {
			return false;
		}
	}

	/** clientSideRequestPrintTrombino */
	public NSData clientSideRequestXlsFile(NSArray idsEtudiants, NSDictionary infos) {
		try {
			NSArray etudiants = DBHandler.faultsForGlobalIDs(eContext, idsEtudiants);
			XlsFileFactory xlsFileFactory = new XlsFileFactory();
			return xlsFileFactory.xlsFileEtudiants(etudiants, infos);
		}
		catch (Exception e) {
			NSLog.out.appendln("clientSideRequestXlsFile");
			e.printStackTrace();
			return null;
		}
	}

	/** clientSideRequestGetEtudiantsApsDuGroupe */
	public NSArray clientSideRequestGetEtudiantsApsDuGroupe(EOGlobalID idGroupe, NSArray groupesSemIDs) {
		try {
			ScolGroupeGrp groupe = (ScolGroupeGrp) eContext.faultForGlobalID(idGroupe, eContext);
			// ScolMaquetteSemestre semestre = (ScolMaquetteSemestre)eContext.faultForGlobalID(idSemestre,eContext);

			NSArray aps = groupeFactory.getApsForGroupe(groupe);
			NSArray inscritsAp;

			NSMutableArray sumQualifier = new NSMutableArray();
			for (int i = 0; i < aps.count(); i++) {
				sumQualifier.addObject(DBHandler.getSimpleQualifier("scolMaquetteRepartitionAp.scolMaquetteAp", aps.objectAtIndex(i)));
			}

			inscritsAp = DBHandler.fetchData(eContext, "ScolInscriptionAp", new EOOrQualifier(sumQualifier));
			inscritsAp = (NSArray) inscritsAp.valueForKey("scolInscriptionEtudiant");

			inscritsAp = FormatHandler.distinctObjects(inscritsAp);

			NSArray inscritsGrp;
			NSArray groupes = DBHandler.faultsForGlobalIDs(eContext, groupesSemIDs);

			sumQualifier.removeAllObjects();

			for (int i = 0; i < groupes.count(); i++) {
				sumQualifier.addObject(DBHandler.getSimpleQualifier("scolGroupeGrp", groupes.objectAtIndex(i)));
			}

			inscritsGrp = DBHandler.fetchData(eContext, "ScolInscriptionGrp", new EOOrQualifier(sumQualifier));
			inscritsGrp = (NSArray) inscritsGrp.valueForKey("scolInscriptionEtudiant");

			NSMutableArray inscriptions = inscritsAp.mutableClone();

			inscriptions.removeObjects(inscritsGrp.objects());
			NSArray idsInsc = DBHandler.globalIDsForObjects(eContext, inscriptions);
			return idsInsc;
		}
		catch (Throwable e) {
			NSLog.out.appendln("clientSideRequestGetEtudiantsApsDuGroupe:");
			e.printStackTrace();
			return new NSArray();
		}
	}

	/** recupere et regroupe le type d'ap et le seuil pour differents AP du semestre */
	public NSArray clientSideRequestTypeApSeuil(EOGlobalID idSpecialisation, EOGlobalID idParcours, EOGlobalID idSemestre) {

		ScolMaquetteSemestre semestre = (ScolMaquetteSemestre) eContext.faultForGlobalID(idSemestre, eContext);
		ScolMaquetteParcours parcours = (ScolMaquetteParcours) eContext.faultForGlobalID(idParcours, eContext);
		;
		ScolFormationSpecialisation specialisation = (ScolFormationSpecialisation) eContext.faultForGlobalID(idSpecialisation, eContext);

		Number mparKey = (Number) primaryKey(parcours, "mparKey");
		Number fspnKey = (Number) primaryKey(specialisation, "fspnKey");
		Number msemOrdre = semestre.msemOrdre();

		StringBuffer query = new StringBuffer();
		query.append("SELECT unique map.mhco_code,map.map_seuil");
		query.append(" FROM   SCOL_MAQUETTE_PARCOURS mpar,SCOL_MAQUETTE_REPARTITION_SEM mrsem,");
		query.append(" SCOL_MAQUETTE_SEMESTRE msem,SCOL_MAQUETTE_REPARTITION_UE mrue,");
		query.append(" SCOL_MAQUETTE_UE mue,SCOL_MAQUETTE_REPARTITION_EC mrec,");
		query.append(" SCOL_MAQUETTE_EC mec,SCOL_MAQUETTE_REPARTITION_AP mrap,SCOL_MAQUETTE_AP map");
		query.append(" WHERE  map.map_key = mrap.map_key");
		query.append(" AND mrap.mec_key = mec.mec_key");
		query.append(" AND mec.mec_key = mrec.mec_key");
		query.append(" AND mrec.mue_key = mue.mue_key");
		query.append(" AND mue.mue_key = mrue.mue_key");
		query.append(" AND mrue.msem_key = msem.msem_key");
		query.append(" AND msem.msem_key = mrsem.msem_key");
		query.append(" AND mrsem.mpar_key = mpar.mpar_key");
		query.append(" AND mrap.mrap_semestre = MOD(msem.msem_ordre,2)");
		query.append(" AND mpar.fspn_key = ");
		query.append(String.valueOf(fspnKey.intValue()));
		query.append(" AND msem.msem_ordre = ");
		query.append(String.valueOf(msemOrdre.intValue()));
		query.append(" AND mpar.mpar_key = ");
		query.append(String.valueOf(mparKey.intValue()));
		query.append(" order by map.mhco_code, map.map_seuil");
		return rawRowsForSQL("GroupeScol", query.toString());
	}

	/** renvoi l'url d'acces a la viewlet de presentation de cette application */
	public String clientSideRequestGetUrlViewlet() {
		return cfg.stringForKey("URL_VIEWLET");
	}

	public NSDictionary clientSideRequestGetVersion() {
		NSMutableDictionary d = new NSMutableDictionary();
		d.takeValueForKey(Version.versionNum(), "version");
		d.takeValueForKey(Version.VERSIONDATE, "date");
		return d.immutableClone();
	}

	/** execute la requette sql et recupere les valeurs des colonnes demandees dans le tableau */
	private NSArray rawRowsForSQL(String eomodelName, String query) {
		try {
			return EOUtilities.rawRowsForSQL(defaultEditingContext(), eomodelName, query);
		}
		catch (Throwable th) {
			th.printStackTrace();
			return new NSArray();
		}

	}

	public void terminate() {
		userInfos = null;
		super.terminate();
	}

}
