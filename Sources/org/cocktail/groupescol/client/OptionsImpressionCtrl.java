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
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionsImpressionCtrl extends JDialog {

	public static final int PDF_FILE = 1;
	public static final int XLS_FILE = 2;

	private Window owner;
	private Object sender;
	private JButton bPrintAll, bPrintSelection;

	int fileType = PDF_FILE;
	boolean printAll = false, forceClosing = true;

	public OptionsImpressionCtrl(Frame owner, Object sender) {
		super(owner, true);
		this.owner = owner;
		this.sender = sender;
		_initUI();
	}

	public OptionsImpressionCtrl(Dialog owner, Object sender) {
		super(owner, true);
		this.owner = owner;
		this.sender = sender;
		_initUI();
	}

	private void _initUI() {
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(new BorderLayout(5, 5));
		setTitle("Options Trombino");

		JRadioButton pdfButton = new JRadioButton("PDF");
		pdfButton.setMnemonic(KeyEvent.VK_P);
		pdfButton.setActionCommand("PDF");
		pdfButton.setSelected(true);

		JRadioButton xlsButton = new JRadioButton("XLS");
		xlsButton.setMnemonic(KeyEvent.VK_X);
		xlsButton.setActionCommand("XLS");
		xlsButton.setSelected(false);

		ButtonGroup group = new ButtonGroup();
		group.add(pdfButton);
		group.add(xlsButton);
		JPanel radioPanel = new JPanel(new GridLayout(1, 2));
		radioPanel.add(pdfButton);
		radioPanel.add(xlsButton);
		container.add(radioPanel, BorderLayout.PAGE_START);
		FRadioButtonListener radioButtonListener = new FRadioButtonListener();
		pdfButton.addActionListener(radioButtonListener);
		xlsButton.addActionListener(radioButtonListener);

		bPrintAll = new JButton(new PrintAction("Imprimer Tout"));
		bPrintSelection = new JButton(new PrintAction("Imprimer Selection"));
		JPanel pButtons = new JPanel(new FlowLayout());
		pButtons.add(bPrintAll);
		pButtons.add(bPrintSelection);
		container.add(pButtons, BorderLayout.SOUTH);

		if (sender != null) {
			int xMain = owner.getBounds().x;
			int yMain = owner.getBounds().y;
			int xB = ((JComponent) sender).getX();
			int yB = ((JComponent) sender).getY();
			setLocation((xMain + xB + 30), yMain + yB);
		}

		pack();
	}

	/** retourne si l'utilisateur a choisi de tout imprimer ou juste la selection */
	public boolean isPrintAll() {
		return printAll;
	}

	/** permet de savoir si la fermeture de la fenetre est du a un clique sur un bouton ou fermee avec les boutons du windowManager */
	public boolean isForceClosing() {
		return forceClosing;
	}

	/** retourne le type de fichier choisi par l'utilisateur */
	public int getFileType() {
		return fileType;
	}

	private class FRadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("PDF")) {
				fileType = PDF_FILE;
			}
			else
				if (action.equals("XLS")) {
					fileType = XLS_FILE;
				}
		}
	}

	protected class PrintAction extends AbstractAction {
		public PrintAction(String title) {
			super(title);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bPrintAll) {
				forceClosing = false;
				printAll = true;
				setVisible(false);
			}
			else {
				forceClosing = false;
				printAll = false;
				setVisible(false);
			}
		}
	}

}
