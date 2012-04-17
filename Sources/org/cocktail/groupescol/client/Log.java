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

import java.util.Date;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;

public class Log {

	long start = 0;

	public Log() {
	}

	public void startOp(String op) {
		start = (new Date()).getTime();
		NSLog.out.appendln(">>start " + op);
	}

	public void endOp() {
		long end = (new Date()).getTime();
		NSLog.out.appendln(">>ended : ms-" + (end - start) + "\n");
	}

	public void endOp(String msg) {
		long end = (new Date()).getTime();
		NSLog.out.appendln(">>ended : ms-" + (end - start));
		NSLog.out.appendln("> " + msg + "\n");
	}

	public static void printArray(NSArray array, String msg) {
		if (msg != null) {
			NSLog.out.appendln(msg);
		}
		NSLog.out.appendln("count=" + array.count());
		for (int i = 0; i < array.count(); i++) {
			NSLog.out.appendln(array.objectAtIndex(i));
		}
	}

	public static void printArray(NSArray array) {
		for (int i = 0; i < array.count(); i++) {
			NSLog.out.appendln(array.objectAtIndex(i));
		}
	}

	public static void out(Object obj) {
		NSLog.out.appendln(obj.toString());
	}

	public static void out(Object sender, Object obj) {
		NSLog.out.appendln(sender.getClass().getName() + " - " + obj.toString());
	}

	public static void out(int i) {
		NSLog.out.appendln(String.valueOf(i));
	}

}
