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

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

public class FormatHandler {

	/* Gestion des nombres et chaines */

	/** renvoie le Integer representant le String */
	public static Integer strToInteger(String str) {
		return new Integer(str);
	}

	/** renvoie le int representant le String */
	public static int strToInt(String str) {
		return strToInteger(str).intValue();
	}

	/* Gestion des formats de dates */

	/** obtenir la chaine representant l'instant date */
	public static String dateToStr(NSTimestamp date) {
		return dateToStr(date, "%d/%m/%Y");
	}

	/** obtenir la chaine representant l'instant date */
	public static String dateToStr(NSTimestamp date, String format) {
		NSTimestampFormatter formatter = new NSTimestampFormatter(format);
		try {
			return formatter.format(date);
		}
		catch (Exception e) {
			return null;
		}
	}

	/** obtenir l'objet date a partir de la chaine et le format */
	public static NSTimestamp strToDate(String strDate) {
		return strToDate(strDate, "%d/%m/%Y %H:%M:%S");
	}

	/** obtenir l'objet date a partir de la chaine et le format */
	public static NSTimestamp strToDate(String strDate, String format) {

		NSTimestampFormatter formatter = new NSTimestampFormatter(format);
		try {
			return (NSTimestamp) formatter.parseObject(strDate, new ParsePosition(0));
		}
		catch (Exception e) {
			return null;
		}
	}

	/** reformate la date pour minuit */
	public static NSTimestamp midnightTime(NSTimestamp time) {
		String strDate = dateToStr(time);
		return strToDate(strDate + " 00:00:00", "%d/%m/%Y %H:%M:%S");
	}

	/** reformate la date pour minuit */
	public static NSTimestamp midnightTime(String sTime) {
		return strToDate(sTime + " 00:00:00", "%d/%m/%Y %H:%M:%S");
	}

	/** reformate la date pour la fin du jour */
	public static NSTimestamp endOfDay(NSTimestamp time) {
		String strDate = dateToStr(time);
		return strToDate(strDate + " 23:59:59", "%d/%m/%Y %H:%M:%S");
	}

	/** reformate la date pour la fin du jour */
	public static NSTimestamp endOfDay(String sTime) {
		return strToDate(sTime + " 23:59:59", "%d/%m/%Y %H:%M:%S");
	}

	public static String getShortDayName(NSTimestamp date) {
		return getDayName(date).substring(0, 3);
	}

	public static String getDayName(NSTimestamp date) {
		DateFormat f = new SimpleDateFormat("EEEE");
		try {
			return f.format(date);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/** retourne le nom du jour de la semaine */
	public static String intToDay(int day) {
		String retour = "";
		switch (day) {
		case Calendar.MONDAY:
			retour = "Lundi";
			break;
		case Calendar.TUESDAY:
			retour = "Mardi";
			break;
		case Calendar.WEDNESDAY:
			retour = "Mercredi";
			break;
		case Calendar.THURSDAY:
			retour = "Jeudi";
			break;
		case Calendar.FRIDAY:
			retour = "Vendredi";
			break;
		case Calendar.SATURDAY:
			retour = "Samedi";
			break;
		case Calendar.SUNDAY:
			retour = "Dimanche";
			break;
		}
		return retour;
	}

	/** retourne le nom du jour de la semaine */
	public static String dayString(NSTimestamp date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(4);
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String retour = "";
		switch (day) {
		case Calendar.MONDAY:
			retour = "Lundi";
			break;
		case Calendar.TUESDAY:
			retour = "Mardi";
			break;
		case Calendar.WEDNESDAY:
			retour = "Mercredi";
			break;
		case Calendar.THURSDAY:
			retour = "Jeudi";
			break;
		case Calendar.FRIDAY:
			retour = "Vendredi";
			break;
		case Calendar.SATURDAY:
			retour = "Samedi";
			break;
		case Calendar.SUNDAY:
			retour = "Dimanche";
			break;
		}
		return retour;
	}

	public static NSMutableArray distinctObjects(NSArray anArray) {

		NSMutableArray tmp = new NSMutableArray();

		for (int i = 0; i < anArray.count(); i++) {
			Object objet = anArray.objectAtIndex(i);
			if (!tmp.containsObject(objet)) {
				tmp.addObject(objet);
			}
		}
		return tmp;
	}

}
