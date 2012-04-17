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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOController;
import com.webobjects.eoapplication.EOSimpleWindowController;

public class PrintController extends JDialog {

	private GestionTrombino owner;
	private Object sender;
	private JButton bPrintAll, bPrintSelection;

	public PrintController(GestionTrombino owner, Object sender) {
		super((Dialog) ((EOSimpleWindowController) ((EOController) owner).supercontroller()).window(), true);
		this.owner = owner;
		this.sender = sender;
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		setTitle("Options Trombino");
		bPrintAll = new JButton(new PrintAction("Imprimer Tout"));
		bPrintSelection = new JButton(new PrintAction("Imprimer Selection"));
		container.add(bPrintAll, BorderLayout.WEST);
		container.add(bPrintSelection, BorderLayout.EAST);
		pack();
		MainInterface mainInterface = ((MainClient) EOApplication.sharedApplication()).mainInterface();
		Window mainWindow = ((EOSimpleWindowController) ((EOController) mainInterface).supercontroller()).window();
		int xMain = mainWindow.getBounds().x;
		int yMain = mainWindow.getBounds().y;
		int xB = ((JComponent) sender).getX();
		int yB = ((JComponent) sender).getY();
		setLocation((xMain + xB + 30), yMain + yB);
	}

	protected class PrintAction extends AbstractAction {
		public PrintAction(String title) {
			super(title);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bPrintAll) {
				owner.printAll();
				setVisible(false);
			}
			else {
				owner.printSelection();
				setVisible(false);
			}
		}

	}

}
