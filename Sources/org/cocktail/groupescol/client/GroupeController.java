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
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cocktail.groupescol.client.eof.ScolGroupeCollection;
import org.cocktail.groupescol.client.eof.ScolGroupeGrp;

import com.webobjects.eoapplication.EOApplication;
import com.webobjects.eoapplication.EOController;
import com.webobjects.eoapplication.EOSimpleWindowController;

public class GroupeController extends JDialog {

	private Container cont;
	private JTextField tMaxCapa, tIntCapa, tDateDeb, tDateFin, tLibelle, tCode;
	private JButton bValider, bFermer;
	private JCheckBox cCapBloquante;
	private Object sender;
	private MainInterface owner;
	private ScolGroupeGrp groupe;
	private ScolGroupeCollection collection;

	public GroupeController(MainInterface owner, Object sender, ScolGroupeGrp grp, ScolGroupeCollection collection) {
		super((Frame) ((EOSimpleWindowController) ((EOController) owner).supercontroller()).window(), true);
		setTitle("Création / modification de groupe");
		this.owner = owner;
		this.sender = sender;
		this.groupe = grp;
		this.collection = collection;
		initUI();
		initData();
	}

	private void initData() {
		if (groupe != null) {
			tMaxCapa.setText(groupe.ggrpMaxCapacite().toString());
			if (groupe.ggrpIntCapacite() != null) {
				tIntCapa.setText(groupe.ggrpIntCapacite().toString());
			}
			tDateDeb.setText(groupe.ggrpDateDebut().toString());
			if (groupe.ggrpDateFin() != null) {
				tDateFin.setText(groupe.ggrpDateFin().toString());
			}
			if (groupe.ggrpLibelle() != null) {
				tLibelle.setText(groupe.ggrpLibelle());
			}
			tCode.setText(groupe.ggrpCode());
			cCapBloquante.setSelected(groupe.ggrpMaxTemoin().equals("O"));
		}
	}

	private void initUI() {
		setSize(350, 220);
		Window ownerWindow = ((EOSimpleWindowController) ((EOController) owner).supercontroller()).window();
		int xMain = ownerWindow.getBounds().x;
		int yMain = ownerWindow.getBounds().y;
		int xB = ((JComponent) sender).getX();
		int yB = ((JComponent) sender).getY();
		setLocation((xMain + xB + 30), yMain + yB);
		setResizable(false);
		cont = getContentPane();
		JPanel panel = new JPanel(new GridLayout(8, 2, 3, 3));
		panel.setPreferredSize(new Dimension(350, 220));
		cont.setLayout(new BorderLayout(5, 5));
		cont.add(panel, BorderLayout.CENTER);

		tCode = new JTextField();
		tLibelle = new JTextField();
		tMaxCapa = new JTextField();
		tIntCapa = new JTextField();
		tDateDeb = new JTextField();
		tDateFin = new JTextField();

		JLabel lCode = new JLabel("Code groupe");
		JLabel lLibelle = new JLabel("Libelle");
		panel.add(lCode);
		panel.add(lLibelle);
		panel.add(tCode);
		panel.add(tLibelle);

		JLabel lMaxCapa = new JLabel("Cap. Max");
		JLabel lIntCapa = new JLabel("Cap. Int");
		panel.add(lMaxCapa);
		panel.add(lIntCapa);
		panel.add(tMaxCapa);
		panel.add(tIntCapa);

		JLabel lDateDeb = new JLabel("Debut Val.");
		JLabel lDateFin = new JLabel("Fin val.");
		panel.add(lDateDeb);
		panel.add(lDateFin);
		panel.add(tDateDeb);
		panel.add(tDateFin);

		JLabel lBloquante = new JLabel("Effet capa Max");
		cCapBloquante = new JCheckBox("Bloquante", true);
		panel.add(lBloquante);
		panel.add(cCapBloquante);

		Color color = new Color(0xE9967A);
		WidgetHandler.colorJLabel(lDateDeb, color);
		WidgetHandler.colorJLabel(lMaxCapa, color);
		WidgetHandler.colorJLabel(lCode, color);

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
		String code = tCode.getText();

		String tmp = tDateDeb.getText();
		Integer dateDebut = null;
		if (tmp.length() == 4) {
			dateDebut = new Integer(tmp);
		}

		tmp = tDateFin.getText();
		Integer dateFin = null;
		if (tmp.length() == 4) {
			dateFin = new Integer(tmp);
		}

		String mc = tMaxCapa.getText();
		String ic = tIntCapa.getText();

		Integer maxCap = null;
		if (!mc.equals("")) {
			maxCap = new Integer(mc);
		}

		Integer intCap = null;
		if (!ic.equals("")) {
			intCap = new Integer(ic);
		}

		if (dateDebut == null || maxCap == null || code.equals("")) {
			WindowHandler.showError("Les champs marqués en rouge sont obligatoires");
		}
		else {
			try {
				HashMap infosGrp = new HashMap();
				infosGrp.put("code", code);
				infosGrp.put("libelle", libelle);
				infosGrp.put("maxCap", maxCap);
				infosGrp.put("intCap", intCap);
				infosGrp.put("dateDebut", dateDebut);
				infosGrp.put("dateFin", dateFin);
				infosGrp.put("maxTem", cCapBloquante.isSelected() ? "O" : "N");

				MainClient app = (MainClient) EOApplication.sharedApplication();
				if (groupe != null) {
					app.groupeFactory().modifierGroupe(groupe, infosGrp, true);
				}
				else {
					if (collection != null && collection.scolGroupeGrps() != null && collection.scolGroupeGrps().count() > 0) {
						ScolGroupeGrp grp = (ScolGroupeGrp) collection.scolGroupeGrps().lastObject();
						infosGrp.put("semestre", grp.getSemestre());
						infosGrp.put("aps", grp.getAps());
						app.groupeFactory().creerGroupe(collection, infosGrp, true);
					}
				}
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
