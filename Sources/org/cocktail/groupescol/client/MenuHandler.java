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

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.webobjects.eoapplication.EOComponentController;

public class MenuHandler extends JMenuBar {

	private MainInterface owner;

	JMenuItem miQuitter, miTrombino, miPresentation, miRecopieGroupe, miAPropos;

	public MenuHandler(MainInterface owner) {
		this.owner = owner;

		miQuitter = new JMenuItem("Quitter");
		miTrombino = new JMenuItem("Trombino/Export tableur...");
		miPresentation = new JMenuItem("Pr\u00e9sentation visuelle");
		miRecopieGroupe = new JMenuItem("Recopie de groupes");
		miAPropos = new JMenuItem("A Propos");

		MenuAction mAction = new MenuAction();

		miQuitter.addActionListener(mAction);
		miTrombino.addActionListener(mAction);
		miPresentation.addActionListener(mAction);
		miRecopieGroupe.addActionListener(mAction);
		miAPropos.addActionListener(mAction);

		JMenu mFichier = new JMenu("Fichier");
		add(mFichier);
		mFichier.add(miTrombino);
		mFichier.add(miQuitter);

		JMenu mOutils = new JMenu("Outils");
		add(mOutils);
		mOutils.add(miRecopieGroupe);

		JMenu mAide = new JMenu("Aide");
		add(mAide);
		mAide.add(miPresentation);
		mAide.addSeparator();
		mAide.add(miAPropos);

		// affectation du menuBar a l'interface owner.
		((EOComponentController) owner.supercontroller()).component().getRootPane().setJMenuBar(this);
	}

	private class MenuAction extends AbstractAction {

		public MenuAction() {
			super();
		}

		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();

			if (src == miQuitter) {
				owner.quitter();
			}
			else
				if (src == miTrombino) {
					owner.lancerGestionTrombino();
				}
				else
					if (src == miPresentation) {
						owner.lancerViewlet();
					}
					else
						if (src == miRecopieGroupe) {
							owner.lancerRecopieGroupe();
						}
						else
							if (src == miAPropos) {
								owner.lancerAPropos();
							}
		}
	}

}
