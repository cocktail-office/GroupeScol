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

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.webobjects.eoapplication.EODialogController;
import com.webobjects.eoapplication.EOInterfaceController;
import com.webobjects.eoapplication.EOModalDialogController;
import com.webobjects.eoapplication.EOSimpleWindowController;

public class WindowHandler {

	public static void runModal(EOInterfaceController ctrl, String title) {
		EOModalDialogController.runControllerInNewModalDialog(ctrl, title);
	}

	public static void run(EOInterfaceController ctrl, String title) {
		EODialogController.runControllerInNewDialog(ctrl, title);
	}

	public static void closeModal(EOInterfaceController ctrl) {
		((EOModalDialogController) ctrl.supercontroller()).closeWindow();
	}

	public static void close(EOInterfaceController ctrl) {
		((EODialogController) ctrl.supercontroller()).closeWindow();
	}

	/** affiche un message informatif en utilisant JOptionPane */
	public static void showInfo(String info) {
		JOptionPane.showMessageDialog(null, info, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	/** affiche un message d'erreur en utilisant JOptionPane */
	public static void showError(String erreur) {
		JOptionPane.showMessageDialog(null, erreur, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * affiche une demande de confirmation Oui/Non retour true pour Oui et false pour Non
	 */
	public static boolean showConfirmation(String question) {
		int choix = JOptionPane.showConfirmDialog(null, question, "Confirmation", JOptionPane.YES_NO_OPTION);
		return ((choix == 0) ? true : false);
	}

	/**
	 * methode a usage interne a la classe
	 * 
	 * @see setWaitCursor, setDefaultCursor
	 */
	public static void setCursor(int type, EOInterfaceController controller) {
		Container container = (((EOSimpleWindowController) controller.supercontroller()).window());
		Component[] children = container.getComponents();
		for (int i = 0; i < container.getComponentCount(); i++) {
			((Container) children[i]).setCursor(Cursor.getPredefinedCursor(type));
		}
	}

	public static void setWaitCursor(EOInterfaceController controller) {
		setCursor(Cursor.WAIT_CURSOR, controller);
	}

	public static void setDefaultCursor(EOInterfaceController controller) {
		setCursor(Cursor.DEFAULT_CURSOR, controller);
	}

	public static void setWaitCursor(Component controller) {
		controller.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	}

	public static void setDefaultCursor(Component controller) {
		controller.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	// ///
	public static void setWaitCursor(EOModalDialogController controller) {
		setWaitCursor(controller.window());
	}

	public static void setDefaultCursor(EOModalDialogController controller) {
		setDefaultCursor(controller.window());
	}

	// ///

	/** Renvoie la fenêtre principale (ou null si celle-ci n'est pas encore créée) */
	public static Window getWindowFromController(EOInterfaceController controller) {
		if (controller != null) {
			return ((EOSimpleWindowController) controller.supercontroller()).window();
		}
		else {
			return null;
		}
	}

	/** Renvoie la fenêtre principale (sous forme de JFrame) si celle-ci est créée */
	public static JFrame getJFrameFromController(EOInterfaceController controller) {
		if (controller != null) {
			return (JFrame) getWindowFromController(controller);
		}
		else {
			return null;
		}
	}

}
