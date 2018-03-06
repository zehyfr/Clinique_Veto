package fr.eni.veto.IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fr.eni.veto.BO.Personnels;
import fr.eni.veto.CTRL.Controler;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class MainView {

	private JFrame frmGestion;
	private JTextField nomTxt;
	private JTextField identifiantTxt;
	private Controler ctrl;

	private String nom;
	private String role;
	private String code;

	/**
	 * Create the application.
	 */
	public MainView(Controler controler) {
		this.ctrl = controler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestion = new JFrame();
		frmGestion.setFont(new Font("Gisha", Font.BOLD, 12));
		frmGestion.getContentPane().setBackground(Color.WHITE);
		frmGestion.getContentPane().setForeground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 684, 0 };
		gridBagLayout.rowHeights = new int[] { 461, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		frmGestion.getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Gisha", Font.BOLD, 12));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frmGestion.getContentPane().add(tabbedPane, gbc_tabbedPane);

		JScrollPane agendaPane = new JScrollPane();
		tabbedPane.addTab("Agenda", new ImageIcon(MainView.class.getResource("/ressources/calendar ico.png")),
				agendaPane, null);
		tabbedPane.setForegroundAt(0, new Color(0, 51, 153));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		agendaPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JScrollPane clientPane = new JScrollPane();
		tabbedPane.addTab("Gestion Clients", new ImageIcon(MainView.class.getResource("/ressources/client ico.png")),
				clientPane, null);
		tabbedPane.setForegroundAt(1, new Color(0, 51, 153));
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));

		JScrollPane vetoPane = new JScrollPane();
		tabbedPane.addTab("Gestion du personnel",
				new ImageIcon(MainView.class.getResource("/ressources/veto icon.png")), vetoPane, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		tabbedPane.setForegroundAt(2, new Color(0, 51, 153));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		vetoPane.setViewportView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 47, 315, 20, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 41, 19, 353, 28, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel gestionPersonnelTitleLbl = new JLabel("Gestion du personnel");
		gestionPersonnelTitleLbl.setForeground(new Color(0, 51, 153));
		gestionPersonnelTitleLbl.setFont(new Font("Gisha", Font.BOLD, 18));
		GridBagConstraints gbc_gestionPersonnelTitleLbl = new GridBagConstraints();
		gbc_gestionPersonnelTitleLbl.anchor = GridBagConstraints.SOUTH;
		gbc_gestionPersonnelTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_gestionPersonnelTitleLbl.gridx = 1;
		gbc_gestionPersonnelTitleLbl.gridy = 0;
		panel_1.add(gestionPersonnelTitleLbl, gbc_gestionPersonnelTitleLbl);

		JLabel spaceBoundLbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl = new GridBagConstraints();
		gbc_spaceBoundLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl.gridx = 0;
		gbc_spaceBoundLbl.gridy = 1;
		panel_1.add(spaceBoundLbl, gbc_spaceBoundLbl);

		JLabel spaceBoundLbl3 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl3 = new GridBagConstraints();
		gbc_spaceBoundLbl3.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl3.gridx = 2;
		gbc_spaceBoundLbl3.gridy = 1;
		panel_1.add(spaceBoundLbl3, gbc_spaceBoundLbl3);

		DefaultListModel<Personnels> listModel = new DefaultListModel<Personnels>();
		JList list = new JList(listModel);
		list.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 51, 153)));
		list.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		list.setForeground(new Color(0, 51, 153));
		ArrayList<Personnels> listePersonnels = new ArrayList<Personnels>();
		listePersonnels = ctrl.getListPersonnel();
		for (Personnels personnels : listePersonnels) {
			listModel.addElement(personnels);
		}
		list.setLayoutOrientation(JList.VERTICAL);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 2;
		panel_1.add(list, gbc_list);

		JPanel idPanel = new JPanel();
		idPanel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_idPanel = new GridBagConstraints();
		gbc_idPanel.insets = new Insets(0, 0, 5, 5);
		gbc_idPanel.fill = GridBagConstraints.BOTH;
		gbc_idPanel.gridx = 3;
		gbc_idPanel.gridy = 2;
		panel_1.add(idPanel, gbc_idPanel);
		GridBagLayout gbl_idPanel = new GridBagLayout();
		gbl_idPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_idPanel.rowHeights = new int[] { 28, 0, 16, 0, 17, 0, 25, 0, 87, 14, 0 };
		gbl_idPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_idPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		idPanel.setLayout(gbl_idPanel);

		JLabel spaceBoundlbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundlbl = new GridBagConstraints();
		gbc_spaceBoundlbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundlbl.gridx = 0;
		gbc_spaceBoundlbl.gridy = 0;
		idPanel.add(spaceBoundlbl, gbc_spaceBoundlbl);

		JLabel identifiantLbl = new JLabel("Identifiant :");
		identifiantLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_identifiantLbl = new GridBagConstraints();
		gbc_identifiantLbl.anchor = GridBagConstraints.EAST;
		gbc_identifiantLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantLbl.gridx = 0;
		gbc_identifiantLbl.gridy = 1;
		idPanel.add(identifiantLbl, gbc_identifiantLbl);

		identifiantTxt = new JTextField();
		identifiantTxt.setForeground(new Color(0, 51, 153));
		identifiantTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		identifiantTxt.setText(nom);
		GridBagConstraints gbc_identifiantTxt = new GridBagConstraints();
		gbc_identifiantTxt.gridwidth = 3;
		gbc_identifiantTxt.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_identifiantTxt.gridx = 1;
		gbc_identifiantTxt.gridy = 1;
		idPanel.add(identifiantTxt, gbc_identifiantTxt);
		identifiantTxt.setColumns(10);
		identifiantTxt.setEnabled(false);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		idPanel.add(label, gbc_label);

		JLabel nomLbl = new JLabel("Nom :");
		nomLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_nomLbl = new GridBagConstraints();
		gbc_nomLbl.insets = new Insets(0, 0, 5, 5);
		gbc_nomLbl.anchor = GridBagConstraints.EAST;
		gbc_nomLbl.gridx = 0;
		gbc_nomLbl.gridy = 3;
		idPanel.add(nomLbl, gbc_nomLbl);

		nomTxt = new JTextField();
		nomTxt.setForeground(new Color(0, 51, 153));
		nomTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_nomTxt = new GridBagConstraints();
		gbc_nomTxt.gridwidth = 3;
		gbc_nomTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nomTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nomTxt.gridx = 1;
		gbc_nomTxt.gridy = 3;
		idPanel.add(nomTxt, gbc_nomTxt);
		nomTxt.setColumns(10);

		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		idPanel.add(label_1, gbc_label_1);

		JLabel roleLbl = new JLabel("R\u00F4le :");
		roleLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_roleLbl = new GridBagConstraints();
		gbc_roleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_roleLbl.anchor = GridBagConstraints.EAST;
		gbc_roleLbl.gridx = 0;
		gbc_roleLbl.gridy = 5;
		idPanel.add(roleLbl, gbc_roleLbl);

		JRadioButton rdbtnSec = new JRadioButton("SEC");
		rdbtnSec.setBackground(new Color(255, 255, 255));
		rdbtnSec.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_rdbtnSec = new GridBagConstraints();
		gbc_rdbtnSec.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSec.gridx = 1;
		gbc_rdbtnSec.gridy = 5;
		idPanel.add(rdbtnSec, gbc_rdbtnSec);

		JRadioButton rdbtnVet = new JRadioButton("VET");
		rdbtnVet.setBackground(new Color(255, 255, 255));
		rdbtnVet.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_rdbtnVet = new GridBagConstraints();
		gbc_rdbtnVet.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVet.gridx = 2;
		gbc_rdbtnVet.gridy = 5;
		idPanel.add(rdbtnVet, gbc_rdbtnVet);

		JRadioButton rdbtnAdm = new JRadioButton("ADM");
		rdbtnAdm.setBackground(new Color(255, 255, 255));
		rdbtnAdm.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_rdbtnAdm = new GridBagConstraints();
		gbc_rdbtnAdm.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAdm.gridx = 3;
		gbc_rdbtnAdm.gridy = 5;
		idPanel.add(rdbtnAdm, gbc_rdbtnAdm);

		JButton btnNewButton = new JButton("Archiver");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel spaceBoundlbl5 = new JLabel("");
		GridBagConstraints gbc_spaceBoundlbl5 = new GridBagConstraints();
		gbc_spaceBoundlbl5.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundlbl5.gridx = 0;
		gbc_spaceBoundlbl5.gridy = 6;
		idPanel.add(spaceBoundlbl5, gbc_spaceBoundlbl5);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Gisha", Font.PLAIN, 12));
		btnNewButton_1.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 7;
		idPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(255, 255, 255));
		btnValider.setForeground(new Color(0, 51, 153));
		btnValider.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 7;
		idPanel.add(btnValider, gbc_btnValider);

		JLabel spaceBoundLbl4 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl4 = new GridBagConstraints();
		gbc_spaceBoundLbl4.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl4.gridx = 0;
		gbc_spaceBoundLbl4.gridy = 8;
		idPanel.add(spaceBoundLbl4, gbc_spaceBoundLbl4);
		btnNewButton.setForeground(new Color(0, 51, 153));
		btnNewButton.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 9;
		idPanel.add(btnNewButton, gbc_btnNewButton);

		JLabel spaceBoundLbl2 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl2 = new GridBagConstraints();
		gbc_spaceBoundLbl2.insets = new Insets(0, 0, 0, 5);
		gbc_spaceBoundLbl2.gridx = 0;
		gbc_spaceBoundLbl2.gridy = 3;
		panel_1.add(spaceBoundLbl2, gbc_spaceBoundLbl2);
		frmGestion.setForeground(Color.WHITE);
		frmGestion.setTitle("Gestion");
		frmGestion.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("\\\\10.3.0.254\\Partage_Stagiaires\\ressources\\Images\\ico_veto.png"));
		frmGestion.setBounds(100, 100, 700, 500);
		frmGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					int index = list.getSelectedIndex();
					identifiantTxt.setText(Integer.toString(listModel.get(index).getCodePers()));
					nomTxt.setText(listModel.get(index).getNom());
					switch (listModel.get(index).getRole()) {
					case "VET":
						rdbtnVet.setSelected(true);
						rdbtnSec.setSelected(false);
						rdbtnAdm.setSelected(false);
						break;

					case "ADM":
						rdbtnVet.setSelected(false);
						rdbtnSec.setSelected(false);
						rdbtnAdm.setSelected(true);
						break;

					case "SEC":
						rdbtnVet.setSelected(false);
						rdbtnSec.setSelected(true);
						rdbtnAdm.setSelected(false);
						break;

					default:
						break;
					}
					listModel.get(index).getRole();
				}
			}
		});
		
		rdbtnAdm.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				
			}
		});

		frmGestion.setVisible(true);
	}

}
