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

import org.cocktail.groupescol.client.eof.ScolFormationHabilitation;
import org.cocktail.groupescol.client.eof.ScolMaquetteParcours;

import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class ScolariteHandler {

	public static NSArray semestresFromHabilitationParcours(EOEditingContext eContext, ScolFormationHabilitation hab, ScolMaquetteParcours parc,
			Number fannKey) {
		int niveau = hab.fhabNiveau().intValue();
		int ordre1 = niveau * 2 - 1;
		int ordre2 = ordre1 + 1;

		EOQualifier qualSem = EOQualifier.qualifierWithQualifierFormat(
				"(scolMaquetteSemestre.msemOrdre=%@ or scolMaquetteSemestre.msemOrdre=%@) and scolMaquetteParcours=%@ and fannKey=%@", new NSArray(
						new Object[] { new Integer(ordre1), new Integer(ordre2), parc, fannKey }));

		EOSortOrdering.sortOrderingWithKey("msemOrdre", EOSortOrdering.CompareCaseInsensitiveAscending);

		NSArray repSemestres = DBHandler.fetchData(eContext, "ScolMaquetteRepartitionSem", qualSem);
		return (NSArray) repSemestres.valueForKey("scolMaquetteSemestre");
	}

	/** recherche les habilitations pour une personne avec ses droits */
	public static NSArray getHabilitations(EOEditingContext eContext, String diplome, String grade, Number annee, Number droit) {

		if (annee == null) {
			return new NSArray();
		}

		NSMutableArray sumQualifiers = new NSMutableArray();
		if (!(diplome == null) || !diplome.equals("")) {
			sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat(
					"scolFormationSpecialisation.scolFormationDiplome.fdipAbreviation caseInsensitiveLike '*" + diplome + "*'"
							+ " or scolFormationSpecialisation.scolFormationDiplome.fdipLibelle caseInsensitiveLike '*" + diplome + "*'", null));
		}

		if (!(grade == null) || !grade.equals("")) {
			sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat(
					"scolFormationSpecialisation.scolFormationDiplome.fgraCode caseInsensitiveLike '*" + grade + "*'", null));
		}

		sumQualifiers.addObject(EOQualifier.qualifierWithQualifierFormat("fannKey=%@", new NSArray(annee)));

		if (droit != null) {
			EOQualifier qualDroits = EOQualifier.qualifierWithQualifierFormat("scolDroitDiplomes.dlogKey=%@ and scolDroitDiplomes.ddipGroupes='A'",
					new NSArray(droit));
			sumQualifiers.addObject(qualDroits);
		}

		return DBHandler.fetchData(eContext, "ScolFormationHabilitation", new EOAndQualifier(sumQualifiers));
	}

}
