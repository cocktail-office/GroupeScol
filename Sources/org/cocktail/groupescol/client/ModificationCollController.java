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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cocktail.groupescol.client.eof.ScolGroupeCollection;

import com.webobjects.eoapplication.EOController;
import com.webobjects.eoapplication.EOSimpleWindowController;

public class ModificationCollController extends JDialog {

	private Container cont;
	private JTextField tLibelle;
	private JButton bValider, bFermer;
	private Object sender;
	private MainInterface owner;
	private ScolGroupeCollection collection;

	public ModificationCollController(MainInterface owner, Object sender, ScolGroupeCollection collec) {
		super((Frame) ((EOSimpleWindowController) ((EOController) owner).supercontroller()).window(), true);
		setTitle("Modifier la collection");
		this.owner = owner;
		this.sender = sender;
		this.collection = collec;
		initUI();
		initData();
	}

	private void initData() {
		tLibelle.setText(collection.gcolLibelle());
	}

	private void initUI() {
		setSize(350, 70);
		Window ownerWindow = ((EOSimpleWindowController) ((EOController) owner).supercontroller()).window();
		int xMain = ownerWindow.getBounds().x;
		int yMain = ownerWindow.getBounds().y;
		int xB = ((JComponent) sender).getX();
		int yB = ((JComponent) sender).getY();
		setLocation((xMain + xB + 30), yMain + yB);
		setResizable(false);
		cont = getContentPane();
		JPanel panel = new JPanel(new GridLayout(2, 2, 3, 3));
		panel.setPreferredSize(new Dimension(350, 70));
		cont.setLayout(new BorderLayout(5, 5));
		cont.add(panel, BorderLayout.CENTER);

		tLibelle = new JTextField();

		JLabel lLibelle = new JLabel("Libelle");
		panel.add(lLibelle);
		panel.add(tLibelle);

		bValider = new JButton(new GroupeAction("Valider"));
		bFermer = new JButton(new GroupeAction("Fermer"));
		bValider.setPreferredSize(new Dimension(70, 20));
		bFermer.setPreferredSize(new Dimension(70, 20));

		panel.add(bValider);
		panel.add(bFermer);
		pack();
	}

	private void valider() {

		String libelle = tLibelle.getText();

		if (libelle.equals("")) {
			WindowHandler.showError("Il faut un libelle pour la collection");
		}
		else {

			if (!WindowHandler.showConfirmation("Confirmez-vous les modifications sur la collection selectionn\u00e9 ?")) {
				return;
			}

			try {
				collection.setGcolLibelle(libelle);
				collection.editingContext().saveChanges();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void fermer() {
		setVisible(false);
	}

	protected class GroupeAction extends AbstractAction {
		public GroupeAction(String title) {
			super(title);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bValider) {
				valider();
				fermer();
			}
			else {
				fermer();
			}
		}
	}

}
