package fr.eni.veto.IHM;

import java.awt.BorderLayout;
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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.w3c.dom.ls.LSInput;

import fr.eni.veto.BO.Clients;
import fr.eni.veto.BO.Personnels;
import fr.eni.veto.CTRL.Controler;
import javax.swing.ListModel;

public class MainView {

	private JFrame frmGestion;
	private JTextField nomTxt;
	private JTextField identifiantTxt;
	private Controler ctrl;

	private int index;

	private JFrame frmArchiver;
	private JFrame frmAjouterDuPersonnel;
	private JFrame frmAjouterDuClient;

	/**
	 * Create the application.
	 */
	public MainView(Controler controler) {
		this.ctrl = controler;
		initialize();
	}

	/**
	 * Initialize
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

		JPanel panelAgenda = new JPanel();
		panelAgenda.setBackground(new Color(255, 255, 255));
		agendaPane.setViewportView(panelAgenda);
		GridBagLayout gbl_panelAgenda = new GridBagLayout();
		gbl_panelAgenda.columnWidths = new int[] { 0 };
		gbl_panelAgenda.rowHeights = new int[] { 0 };
		gbl_panelAgenda.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panelAgenda.rowWeights = new double[] { Double.MIN_VALUE };
		panelAgenda.setLayout(gbl_panelAgenda);

		JScrollPane clientPane = new JScrollPane();
		tabbedPane.addTab("Gestion Clients", new ImageIcon(MainView.class.getResource("/ressources/client ico.png")),
				clientPane, null);

		JPanel panelClient = new JPanel();
		panelClient.setBackground(new Color(255, 255, 255));
		clientPane.setViewportView(panelClient);
		GridBagLayout gbl_panelClient = new GridBagLayout();
		gbl_panelClient.columnWidths = new int[] { 26, 108, 240, 41, 246, 0, 0 };
		gbl_panelClient.rowHeights = new int[] { 16, 18, 16, 336, 0 };
		gbl_panelClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelClient.setLayout(gbl_panelClient);

		JLabel spaceBoundC2lbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundC2lbl = new GridBagConstraints();
		gbc_spaceBoundC2lbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundC2lbl.gridx = 1;
		gbc_spaceBoundC2lbl.gridy = 0;
		panelClient.add(spaceBoundC2lbl, gbc_spaceBoundC2lbl);

		JLabel spaceBoundC3lbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundC3lbl = new GridBagConstraints();
		gbc_spaceBoundC3lbl.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_spaceBoundC3lbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundC3lbl.gridx = 0;
		gbc_spaceBoundC3lbl.gridy = 1;
		panelClient.add(spaceBoundC3lbl, gbc_spaceBoundC3lbl);

		JLabel clientTitleLbl = new JLabel("Gestion des clients");
		clientTitleLbl.setForeground(new Color(0, 51, 153));
		clientTitleLbl.setFont(new Font("Gisha", Font.BOLD, 18));
		GridBagConstraints gbc_clientTitleLbl = new GridBagConstraints();
		gbc_clientTitleLbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_clientTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_clientTitleLbl.gridx = 2;
		gbc_clientTitleLbl.gridy = 1;
		panelClient.add(clientTitleLbl, gbc_clientTitleLbl);

		JLabel spaceBoundCLbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundCLbl = new GridBagConstraints();
		gbc_spaceBoundCLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundCLbl.gridx = 3;
		gbc_spaceBoundCLbl.gridy = 1;
		panelClient.add(spaceBoundCLbl, gbc_spaceBoundCLbl);

		JLabel spaceBoundClbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundClbl = new GridBagConstraints();
		gbc_spaceBoundClbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundClbl.gridx = 1;
		gbc_spaceBoundClbl.gridy = 2;
		panelClient.add(spaceBoundClbl, gbc_spaceBoundClbl);

		DefaultListModel<Clients> listModelClient = new DefaultListModel<Clients>();
		JList liste = new JList(listModelClient);
		ArrayList<Clients> listeClients = new ArrayList<Clients>();
		listeClients = ctrl.getAllClients();
		for (Clients client : listeClients) {
			listModelClient.addElement(client);
		}
		liste.setSelectedIndex(0);
		liste.setLayoutOrientation(JList.VERTICAL);
		liste.setForeground(new Color(0, 51, 153));
		liste.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		liste.setBorder(new MatteBorder(0, 0, 0, 3, (Color) new Color(0, 51, 153)));
		GridBagConstraints gbc_listeClient = new GridBagConstraints();
		gbc_listeClient.gridwidth = 2;
		gbc_listeClient.insets = new Insets(0, 0, 0, 5);
		gbc_listeClient.fill = GridBagConstraints.BOTH;
		gbc_listeClient.gridx = 1;
		gbc_listeClient.gridy = 3;
		panelClient.add(liste, gbc_listeClient);
		
		liste.setSelectedIndex(0);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 3;
		panelClient.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 67, 55, 67, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 28, 0, 16, 0, 25, 0, 36, 14, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel identifiantCLbl = new JLabel("Client :");
		identifiantCLbl.setFont(new Font("Gisha", Font.PLAIN, 14));
		identifiantCLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_identifiantCLbl = new GridBagConstraints();
		gbc_identifiantCLbl.anchor = GridBagConstraints.EAST;
		gbc_identifiantCLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantCLbl.gridx = 0;
		gbc_identifiantCLbl.gridy = 1;
		panel_1.add(identifiantCLbl, gbc_identifiantCLbl);

		JLabel clientNameLbl = new JLabel("");
		if(listModelClient.get(liste.getSelectedIndex()).getNomClient()!=null)
		{
			clientNameLbl.setText(listModelClient.get(liste.getSelectedIndex()).getNomClient());
		}
		clientNameLbl.setFont(new Font("Gisha", Font.PLAIN, 14));
		clientNameLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_clientNameLbl = new GridBagConstraints();
		gbc_clientNameLbl.gridwidth = 2;
		gbc_clientNameLbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_clientNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc_clientNameLbl.gridx = 1;
		gbc_clientNameLbl.gridy = 1;
		panel_1.add(clientNameLbl, gbc_clientNameLbl);
		
		liste.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(listModelClient.get(liste.getSelectedIndex()).getNomClient());
				clientNameLbl.setText(listModelClient.get(liste.getSelectedIndex()).getNomClient());
			}
		});

		JButton buttonPlus = new JButton("Voir les informations");
		buttonPlus.setForeground(new Color(0, 51, 153));
		buttonPlus.setFont(new Font("Gisha", Font.PLAIN, 12));
		buttonPlus.setBackground(Color.WHITE);
		GridBagConstraints gbc_buttonPlus = new GridBagConstraints();
		gbc_buttonPlus.gridwidth = 3;
		gbc_buttonPlus.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPlus.gridx = 0;
		gbc_buttonPlus.gridy = 3;
		panel_1.add(buttonPlus, gbc_buttonPlus);

		JLabel label_10 = new JLabel("_________________________");
		label_10.setForeground(new Color(0, 51, 153));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.SOUTH;
		gbc_label_10.gridwidth = 3;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 0;
		gbc_label_10.gridy = 5;
		panel_1.add(label_10, gbc_label_10);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setIcon(new ImageIcon(MainView.class.getResource("/ressources/trash2.png")));
		button_2.setForeground(new Color(0, 51, 153));
		button_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.WEST;
		gbc_button_2.gridwidth = 2;
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 7;
		panel_1.add(button_2, gbc_button_2);

		JButton addButtonClient = new JButton("");
		addButtonClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * Fenetre d'ajout clients
				 */
				
				frmAjouterDuClient = new JFrame();
				frmAjouterDuClient.getContentPane().setBackground(new Color(255, 255, 255));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				frmAjouterDuClient.getContentPane().add(panel, BorderLayout.CENTER);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{45, 46, 70, 85, 16, 43, 161, 0, 0};
				gbl_panel.rowHeights = new int[]{22, 0, 23, 0, 18, 19, 15, 0, 14, 0, 20, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				
				JLabel lblAjouterClient = new JLabel("Ajouter un client");
				lblAjouterClient.setForeground(new Color(0, 51, 153));
				lblAjouterClient.setFont(new Font("Gisha", Font.BOLD, 18));
				lblAjouterClient.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAjouterClient = new GridBagConstraints();
				gbc_lblAjouterClient.gridwidth = 2;
				gbc_lblAjouterClient.anchor = GridBagConstraints.WEST;
				gbc_lblAjouterClient.insets = new Insets(0, 0, 5, 5);
				gbc_lblAjouterClient.gridx = 1;
				gbc_lblAjouterClient.gridy = 1;
				panel.add(lblAjouterClient, gbc_lblAjouterClient);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(test.class.getResource("/ressources/client icon.png")));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.gridwidth = 2;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 3;
				gbc_label.gridy = 1;
				panel.add(label, gbc_label);
				
				JLabel spaceBoundAdd = new JLabel("");
				GridBagConstraints gbc_spaceBoundAdd = new GridBagConstraints();
				gbc_spaceBoundAdd.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundAdd.gridx = 1;
				gbc_spaceBoundAdd.gridy = 2;
				panel.add(spaceBoundAdd, gbc_spaceBoundAdd);
				
				JLabel spaceBoundC6 = new JLabel("");
				GridBagConstraints gbc_spaceBoundC6 = new GridBagConstraints();
				gbc_spaceBoundC6.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundC6.gridx = 4;
				gbc_spaceBoundC6.gridy = 2;
				panel.add(spaceBoundC6, gbc_spaceBoundC6);
				
				JLabel lblNomCAdd = new JLabel("Nom :");
				lblNomCAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				lblNomCAdd.setForeground(new Color(0, 51, 153));
				GridBagConstraints gbc_lblNomCAdd = new GridBagConstraints();
				gbc_lblNomCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_lblNomCAdd.anchor = GridBagConstraints.EAST;
				gbc_lblNomCAdd.gridx = 1;
				gbc_lblNomCAdd.gridy = 3;
				panel.add(lblNomCAdd, gbc_lblNomCAdd);
				
				JTextField nomTxtCAdd;
				nomTxtCAdd = new JTextField();
				nomTxtCAdd.setForeground(new Color(0, 51, 153));
				GridBagConstraints gbc_nomTxtCAdd = new GridBagConstraints();
				gbc_nomTxtCAdd.gridwidth = 2;
				gbc_nomTxtCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_nomTxtCAdd.fill = GridBagConstraints.HORIZONTAL;
				gbc_nomTxtCAdd.gridx = 2;
				gbc_nomTxtCAdd.gridy = 3;
				panel.add(nomTxtCAdd, gbc_nomTxtCAdd);
				nomTxtCAdd.setColumns(10);
				
				JLabel prenomClientLbl = new JLabel("Pr\u00E9nom :");
				prenomClientLbl.setForeground(new Color(0, 51, 153));
				prenomClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_prenomClientLbl = new GridBagConstraints();
				gbc_prenomClientLbl.anchor = GridBagConstraints.EAST;
				gbc_prenomClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_prenomClientLbl.gridx = 5;
				gbc_prenomClientLbl.gridy = 3;
				panel.add(prenomClientLbl, gbc_prenomClientLbl);
				
				JTextField textField;
				textField = new JTextField();
				textField.setForeground(new Color(0, 51, 153));
				textField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 6;
				gbc_textField.gridy = 3;
				panel.add(textField, gbc_textField);
				
				JLabel spaceAdd = new JLabel("");
				GridBagConstraints gbc_spaceAdd = new GridBagConstraints();
				gbc_spaceAdd.insets = new Insets(0, 0, 5, 5);
				gbc_spaceAdd.gridx = 1;
				gbc_spaceAdd.gridy = 4;
				panel.add(spaceAdd, gbc_spaceAdd);
				
				JLabel adresseClienLbl = new JLabel("Adresse 1 :");
				adresseClienLbl.setForeground(new Color(0, 51, 153));
				adresseClienLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresseClienLbl = new GridBagConstraints();
				gbc_adresseClienLbl.anchor = GridBagConstraints.EAST;
				gbc_adresseClienLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresseClienLbl.gridx = 1;
				gbc_adresseClienLbl.gridy = 5;
				panel.add(adresseClienLbl, gbc_adresseClienLbl);
				
				JTextField adresse1ClientLbl;
				adresse1ClientLbl = new JTextField();
				adresse1ClientLbl.setForeground(new Color(0, 51, 153));
				adresse1ClientLbl.setColumns(10);
				GridBagConstraints gbc_adresse1ClientLbl = new GridBagConstraints();
				gbc_adresse1ClientLbl.gridwidth = 2;
				gbc_adresse1ClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresse1ClientLbl.fill = GridBagConstraints.HORIZONTAL;
				gbc_adresse1ClientLbl.gridx = 2;
				gbc_adresse1ClientLbl.gridy = 5;
				panel.add(adresse1ClientLbl, gbc_adresse1ClientLbl);
				
				JLabel adresseClient2Lbl = new JLabel("Adresse 2 :");
				adresseClient2Lbl.setForeground(new Color(0, 51, 153));
				adresseClient2Lbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresseClient2Lbl = new GridBagConstraints();
				gbc_adresseClient2Lbl.anchor = GridBagConstraints.EAST;
				gbc_adresseClient2Lbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresseClient2Lbl.gridx = 5;
				gbc_adresseClient2Lbl.gridy = 5;
				panel.add(adresseClient2Lbl, gbc_adresseClient2Lbl);
				
				JTextField adresseClient2Txt;
				adresseClient2Txt = new JTextField();
				adresseClient2Txt.setForeground(new Color(0, 51, 153));
				adresseClient2Txt.setColumns(10);
				GridBagConstraints gbc_adresseClient2Txt = new GridBagConstraints();
				gbc_adresseClient2Txt.insets = new Insets(0, 0, 5, 5);
				gbc_adresseClient2Txt.fill = GridBagConstraints.HORIZONTAL;
				gbc_adresseClient2Txt.gridx = 6;
				gbc_adresseClient2Txt.gridy = 5;
				panel.add(adresseClient2Txt, gbc_adresseClient2Txt);
				
				JLabel spaceBoundAdd2 = new JLabel("");
				GridBagConstraints gbc_spaceBoundAdd2 = new GridBagConstraints();
				gbc_spaceBoundAdd2.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundAdd2.gridx = 1;
				gbc_spaceBoundAdd2.gridy = 6;
				panel.add(spaceBoundAdd2, gbc_spaceBoundAdd2);
				
				JLabel codePostalClientLbl = new JLabel("Code Postal :");
				codePostalClientLbl.setForeground(new Color(0, 51, 153));
				codePostalClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_codePostalClientLbl = new GridBagConstraints();
				gbc_codePostalClientLbl.anchor = GridBagConstraints.EAST;
				gbc_codePostalClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_codePostalClientLbl.gridx = 1;
				gbc_codePostalClientLbl.gridy = 7;
				panel.add(codePostalClientLbl, gbc_codePostalClientLbl);
				
				JTextField textField_1;
				textField_1 = new JTextField();
				textField_1.setForeground(new Color(0, 51, 153));
				textField_1.setColumns(10);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 2;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 7;
				panel.add(textField_1, gbc_textField_1);
				
				JLabel villeClientLabel = new JLabel("Ville :");
				villeClientLabel.setForeground(new Color(0, 51, 153));
				villeClientLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_villeClientLabel = new GridBagConstraints();
				gbc_villeClientLabel.anchor = GridBagConstraints.EAST;
				gbc_villeClientLabel.insets = new Insets(0, 0, 5, 5);
				gbc_villeClientLabel.gridx = 5;
				gbc_villeClientLabel.gridy = 7;
				panel.add(villeClientLabel, gbc_villeClientLabel);
				
				JTextField textField_2;
				textField_2 = new JTextField();
				textField_2.setForeground(new Color(0, 51, 153));
				textField_2.setColumns(10);
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 6;
				gbc_textField_2.gridy = 7;
				panel.add(textField_2, gbc_textField_2);
				
				JLabel spaceBoundCLient4 = new JLabel("");
				GridBagConstraints gbc_spaceBoundCLient4 = new GridBagConstraints();
				gbc_spaceBoundCLient4.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundCLient4.gridx = 0;
				gbc_spaceBoundCLient4.gridy = 8;
				panel.add(spaceBoundCLient4, gbc_spaceBoundCLient4);
				
				JLabel numTelLbl = new JLabel("N\u00B0 tel. :");
				numTelLbl.setForeground(new Color(0, 51, 153));
				numTelLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_numTelLbl = new GridBagConstraints();
				gbc_numTelLbl.anchor = GridBagConstraints.EAST;
				gbc_numTelLbl.insets = new Insets(0, 0, 5, 5);
				gbc_numTelLbl.gridx = 1;
				gbc_numTelLbl.gridy = 9;
				panel.add(numTelLbl, gbc_numTelLbl);
				
				JTextField telTxt;
				telTxt = new JTextField();
				telTxt.setForeground(new Color(0, 51, 153));
				telTxt.setColumns(10);
				GridBagConstraints gbc_telTxt = new GridBagConstraints();
				gbc_telTxt.gridwidth = 2;
				gbc_telTxt.insets = new Insets(0, 0, 5, 5);
				gbc_telTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_telTxt.gridx = 2;
				gbc_telTxt.gridy = 9;
				panel.add(telTxt, gbc_telTxt);
				
				JLabel emailClientLbl = new JLabel("eMail :");
				emailClientLbl.setForeground(new Color(0, 51, 153));
				emailClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_emailClientLbl = new GridBagConstraints();
				gbc_emailClientLbl.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
				gbc_emailClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_emailClientLbl.gridx = 5;
				gbc_emailClientLbl.gridy = 9;
				panel.add(emailClientLbl, gbc_emailClientLbl);
				
				JTextField emailTxt;
				emailTxt = new JTextField();
				emailTxt.setForeground(new Color(0, 51, 153));
				emailTxt.setColumns(10);
				GridBagConstraints gbc_emailTxt = new GridBagConstraints();
				gbc_emailTxt.insets = new Insets(0, 0, 5, 5);
				gbc_emailTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_emailTxt.gridx = 6;
				gbc_emailTxt.gridy = 9;
				panel.add(emailTxt, gbc_emailTxt);
				
				JLabel spaceBoundC5 = new JLabel("");
				GridBagConstraints gbc_spaceBoundC5 = new GridBagConstraints();
				gbc_spaceBoundC5.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundC5.gridx = 0;
				gbc_spaceBoundC5.gridy = 10;
				panel.add(spaceBoundC5, gbc_spaceBoundC5);
				
				JLabel commentaireLbl = new JLabel("Commentaire :");
				commentaireLbl.setForeground(new Color(0, 51, 153));
				commentaireLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_commentaireLbl = new GridBagConstraints();
				gbc_commentaireLbl.anchor = GridBagConstraints.EAST;
				gbc_commentaireLbl.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireLbl.gridx = 1;
				gbc_commentaireLbl.gridy = 11;
				panel.add(commentaireLbl, gbc_commentaireLbl);
				
				JTextField commentaireTxt;
				commentaireTxt = new JTextField();
				commentaireTxt.setForeground(new Color(0, 51, 153));
				commentaireTxt.setColumns(10);
				GridBagConstraints gbc_commentaireTxt = new GridBagConstraints();
				gbc_commentaireTxt.gridwidth = 2;
				gbc_commentaireTxt.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_commentaireTxt.gridx = 2;
				gbc_commentaireTxt.gridy = 11;
				panel.add(commentaireTxt, gbc_commentaireTxt);
				
				
				
				JButton btnAjouterCAdd = new JButton("Ajouter");
				btnAjouterCAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
					}
				});
				btnAjouterCAdd.setIcon(new ImageIcon(test.class.getResource("/ressources/blue.png")));
				btnAjouterCAdd.setForeground(new Color(0, 51, 153));
				btnAjouterCAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				btnAjouterCAdd.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_btnAjouterCAdd = new GridBagConstraints();
				gbc_btnAjouterCAdd.anchor = GridBagConstraints.EAST;
				gbc_btnAjouterCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_btnAjouterCAdd.gridx = 6;
				gbc_btnAjouterCAdd.gridy = 11;
				panel.add(btnAjouterCAdd, gbc_btnAjouterCAdd);
				frmAjouterDuClient.setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/ressources/ico_veto.png")));
				frmAjouterDuClient.setTitle("Ajouter un client");
				frmAjouterDuClient.setBounds(100, 100, 605, 377);
				frmAjouterDuClient.setLocationRelativeTo(null);
				frmAjouterDuClient.setVisible(true);

			}
		});
		addButtonClient.setIcon(new ImageIcon(MainView.class.getResource("/ressources/blue.png")));
		addButtonClient.setForeground(new Color(0, 51, 153));
		addButtonClient.setBackground(Color.WHITE);
		GridBagConstraints gbc_addButtonClient = new GridBagConstraints();
		gbc_addButtonClient.anchor = GridBagConstraints.EAST;
		gbc_addButtonClient.insets = new Insets(0, 0, 0, 5);
		gbc_addButtonClient.gridx = 2;
		gbc_addButtonClient.gridy = 7;
		panel_1.add(addButtonClient, gbc_addButtonClient);
		tabbedPane.setForegroundAt(1, new Color(0, 51, 153));
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		
		//FIN BOUTON AJOUTER CLIENT

		JScrollPane vetoPane = new JScrollPane();
		tabbedPane.addTab("Gestion du personnel",
				new ImageIcon(MainView.class.getResource("/ressources/veto icon.png")), vetoPane, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		tabbedPane.setForegroundAt(2, new Color(0, 51, 153));

		JPanel panelPersonnels = new JPanel();
		panelPersonnels.setBackground(new Color(255, 255, 255));
		vetoPane.setViewportView(panelPersonnels);
		GridBagLayout gbl_panelPersonnels = new GridBagLayout();
		gbl_panelPersonnels.columnWidths = new int[] { 47, 315, 20, 0, 0, 0 };
		gbl_panelPersonnels.rowHeights = new int[] { 41, 19, 353, 28, 0 };
		gbl_panelPersonnels.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelPersonnels.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelPersonnels.setLayout(gbl_panelPersonnels);

		JLabel gestionPersonnelTitleLbl = new JLabel("Gestion du personnel");
		gestionPersonnelTitleLbl.setForeground(new Color(0, 51, 153));
		gestionPersonnelTitleLbl.setFont(new Font("Gisha", Font.BOLD, 18));
		GridBagConstraints gbc_gestionPersonnelTitleLbl = new GridBagConstraints();
		gbc_gestionPersonnelTitleLbl.anchor = GridBagConstraints.SOUTH;
		gbc_gestionPersonnelTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_gestionPersonnelTitleLbl.gridx = 1;
		gbc_gestionPersonnelTitleLbl.gridy = 0;
		panelPersonnels.add(gestionPersonnelTitleLbl, gbc_gestionPersonnelTitleLbl);

		JLabel spaceBoundLbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl = new GridBagConstraints();
		gbc_spaceBoundLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl.gridx = 0;
		gbc_spaceBoundLbl.gridy = 1;
		panelPersonnels.add(spaceBoundLbl, gbc_spaceBoundLbl);

		JLabel spaceBoundLbl3 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl3 = new GridBagConstraints();
		gbc_spaceBoundLbl3.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl3.gridx = 2;
		gbc_spaceBoundLbl3.gridy = 1;
		panelPersonnels.add(spaceBoundLbl3, gbc_spaceBoundLbl3);

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
		panelPersonnels.add(list, gbc_list);
		list.setSelectedIndex(0);

		JPanel idPanel = new JPanel();
		idPanel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_idPanel = new GridBagConstraints();
		gbc_idPanel.insets = new Insets(0, 0, 5, 5);
		gbc_idPanel.fill = GridBagConstraints.BOTH;
		gbc_idPanel.gridx = 3;
		gbc_idPanel.gridy = 2;
		panelPersonnels.add(idPanel, gbc_idPanel);
		GridBagLayout gbl_idPanel = new GridBagLayout();
		gbl_idPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_idPanel.rowHeights = new int[] { 28, 0, 16, 0, 17, 0, 25, 0, 36, 29, 14, 0 };
		gbl_idPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_idPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		idPanel.setLayout(gbl_idPanel);

		JLabel spaceBoundlbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundlbl = new GridBagConstraints();
		gbc_spaceBoundlbl.gridwidth = 2;
		gbc_spaceBoundlbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundlbl.gridx = 0;
		gbc_spaceBoundlbl.gridy = 0;
		idPanel.add(spaceBoundlbl, gbc_spaceBoundlbl);

		JLabel identifiantLbl = new JLabel("Identifiant :");
		identifiantLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_identifiantLbl = new GridBagConstraints();
		gbc_identifiantLbl.gridwidth = 2;
		gbc_identifiantLbl.anchor = GridBagConstraints.EAST;
		gbc_identifiantLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantLbl.gridx = 0;
		gbc_identifiantLbl.gridy = 1;
		idPanel.add(identifiantLbl, gbc_identifiantLbl);

		identifiantTxt = new JTextField();
		identifiantTxt.setForeground(new Color(0, 51, 153));
		identifiantTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_identifiantTxt = new GridBagConstraints();
		gbc_identifiantTxt.gridwidth = 3;
		gbc_identifiantTxt.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_identifiantTxt.gridx = 2;
		gbc_identifiantTxt.gridy = 1;
		idPanel.add(identifiantTxt, gbc_identifiantTxt);
		identifiantTxt.setColumns(10);
		identifiantTxt.setEnabled(false);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		idPanel.add(label, gbc_label);

		JLabel nomLbl = new JLabel("Nom :");
		nomLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_nomLbl = new GridBagConstraints();
		gbc_nomLbl.gridwidth = 2;
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
		gbc_nomTxt.gridx = 2;
		gbc_nomTxt.gridy = 3;
		idPanel.add(nomTxt, gbc_nomTxt);
		nomTxt.setColumns(10);

		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 4;
		idPanel.add(label_1, gbc_label_1);

		JLabel roleLbl = new JLabel("R\u00F4le :");
		roleLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_roleLbl = new GridBagConstraints();
		gbc_roleLbl.gridwidth = 2;
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
		gbc_rdbtnSec.gridx = 2;
		gbc_rdbtnSec.gridy = 5;
		idPanel.add(rdbtnSec, gbc_rdbtnSec);

		JRadioButton rdbtnVet = new JRadioButton("VET");
		rdbtnVet.setBackground(new Color(255, 255, 255));
		rdbtnVet.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_rdbtnVet = new GridBagConstraints();
		gbc_rdbtnVet.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVet.gridx = 3;
		gbc_rdbtnVet.gridy = 5;
		idPanel.add(rdbtnVet, gbc_rdbtnVet);

		JRadioButton rdbtnAdm = new JRadioButton("ADM");
		rdbtnAdm.setBackground(new Color(255, 255, 255));
		rdbtnAdm.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_rdbtnAdm = new GridBagConstraints();
		gbc_rdbtnAdm.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAdm.gridx = 4;
		gbc_rdbtnAdm.gridy = 5;
		idPanel.add(rdbtnAdm, gbc_rdbtnAdm);

		JLabel spaceBoundlbl5 = new JLabel("");
		GridBagConstraints gbc_spaceBoundlbl5 = new GridBagConstraints();
		gbc_spaceBoundlbl5.gridwidth = 2;
		gbc_spaceBoundlbl5.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundlbl5.gridx = 0;
		gbc_spaceBoundlbl5.gridy = 6;
		idPanel.add(spaceBoundlbl5, gbc_spaceBoundlbl5);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 255, 255));
		btnAnnuler.setFont(new Font("Gisha", Font.PLAIN, 12));
		btnAnnuler.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.anchor = GridBagConstraints.WEST;
		gbc_btnAnnuler.gridwidth = 2;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 7;
		idPanel.add(btnAnnuler, gbc_btnAnnuler);

		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(255, 255, 255));
		btnValider.setForeground(new Color(0, 51, 153));
		btnValider.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 3;
		gbc_btnValider.gridy = 7;
		idPanel.add(btnValider, gbc_btnValider);

		JLabel spaceBoundLbl4 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl4 = new GridBagConstraints();
		gbc_spaceBoundLbl4.gridwidth = 2;
		gbc_spaceBoundLbl4.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl4.gridx = 0;
		gbc_spaceBoundLbl4.gridy = 9;
		idPanel.add(spaceBoundLbl4, gbc_spaceBoundLbl4);

		JButton btnArchiver = new JButton("");
		btnArchiver.setIcon(new ImageIcon(MainView.class.getResource("/ressources/trash2.png")));
		btnArchiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		JLabel traitLbl = new JLabel("_________________________");
		traitLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		traitLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_traitLbl = new GridBagConstraints();
		gbc_traitLbl.anchor = GridBagConstraints.SOUTH;
		gbc_traitLbl.gridwidth = 4;
		gbc_traitLbl.insets = new Insets(0, 0, 5, 5);
		gbc_traitLbl.gridx = 1;
		gbc_traitLbl.gridy = 8;
		idPanel.add(traitLbl, gbc_traitLbl);
		btnArchiver.setForeground(new Color(0, 51, 153));
		btnArchiver.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnArchiver = new GridBagConstraints();
		gbc_btnArchiver.gridwidth = 2;
		gbc_btnArchiver.anchor = GridBagConstraints.WEST;
		gbc_btnArchiver.insets = new Insets(0, 0, 0, 5);
		gbc_btnArchiver.gridx = 1;
		gbc_btnArchiver.gridy = 10;
		idPanel.add(btnArchiver, gbc_btnArchiver);

		index = list.getSelectedIndex();
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

		JButton addButon = new JButton("");
		addButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frmAjouterDuPersonnel = new JFrame();
				frmAjouterDuPersonnel.getContentPane().setBackground(new Color(255, 255, 255));

				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				frmAjouterDuPersonnel.getContentPane().add(panel, BorderLayout.CENTER);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 45, 46, 44, 41, 75, 0, 43, 0 };
				gbl_panel.rowHeights = new int[] { 22, 0, 23, 0, 18, 19, 15, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel.setLayout(gbl_panel);

				JLabel lblAjouterDuPersonnel = new JLabel("Ajouter du personnel");
				lblAjouterDuPersonnel.setForeground(new Color(0, 51, 153));
				lblAjouterDuPersonnel.setFont(new Font("Gisha", Font.BOLD, 18));
				lblAjouterDuPersonnel.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblAjouterDuPersonnel = new GridBagConstraints();
				gbc_lblAjouterDuPersonnel.gridwidth = 4;
				gbc_lblAjouterDuPersonnel.anchor = GridBagConstraints.SOUTHWEST;
				gbc_lblAjouterDuPersonnel.insets = new Insets(0, 0, 5, 5);
				gbc_lblAjouterDuPersonnel.gridx = 1;
				gbc_lblAjouterDuPersonnel.gridy = 1;
				panel.add(lblAjouterDuPersonnel, gbc_lblAjouterDuPersonnel);

				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(test.class.getResource("/ressources/medic image.png")));
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 5;
				gbc_label.gridy = 1;
				panel.add(label, gbc_label);

				JLabel spaceBoundAdd = new JLabel("");
				GridBagConstraints gbc_spaceBoundAdd = new GridBagConstraints();
				gbc_spaceBoundAdd.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundAdd.gridx = 1;
				gbc_spaceBoundAdd.gridy = 2;
				panel.add(spaceBoundAdd, gbc_spaceBoundAdd);

				JLabel lblNomAdd = new JLabel("Nom :");
				lblNomAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				lblNomAdd.setForeground(new Color(0, 51, 153));
				GridBagConstraints gbc_lblNomAdd = new GridBagConstraints();
				gbc_lblNomAdd.insets = new Insets(0, 0, 5, 5);
				gbc_lblNomAdd.anchor = GridBagConstraints.EAST;
				gbc_lblNomAdd.gridx = 1;
				gbc_lblNomAdd.gridy = 3;
				panel.add(lblNomAdd, gbc_lblNomAdd);

				final JTextField nomTxtAdd;
				nomTxtAdd = new JTextField();
				GridBagConstraints gbc_nomTxtAdd = new GridBagConstraints();
				gbc_nomTxtAdd.gridwidth = 4;
				gbc_nomTxtAdd.insets = new Insets(0, 0, 5, 5);
				gbc_nomTxtAdd.fill = GridBagConstraints.HORIZONTAL;
				gbc_nomTxtAdd.gridx = 2;
				gbc_nomTxtAdd.gridy = 3;
				panel.add(nomTxtAdd, gbc_nomTxtAdd);
				nomTxtAdd.setColumns(10);

				JLabel spaceAdd = new JLabel("");
				GridBagConstraints gbc_spaceAdd = new GridBagConstraints();
				gbc_spaceAdd.insets = new Insets(0, 0, 5, 5);
				gbc_spaceAdd.gridx = 1;
				gbc_spaceAdd.gridy = 4;
				panel.add(spaceAdd, gbc_spaceAdd);

				JLabel roleLblAdd = new JLabel("R\u00F4le :");
				roleLblAdd.setForeground(new Color(0, 51, 153));
				roleLblAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_roleLblAdd = new GridBagConstraints();
				gbc_roleLblAdd.anchor = GridBagConstraints.EAST;
				gbc_roleLblAdd.insets = new Insets(0, 0, 5, 5);
				gbc_roleLblAdd.gridx = 1;
				gbc_roleLblAdd.gridy = 5;
				panel.add(roleLblAdd, gbc_roleLblAdd);

				JRadioButton rdbtnSecAdd = new JRadioButton("SEC");
				rdbtnSecAdd.setBackground(new Color(255, 255, 255));
				rdbtnSecAdd.setForeground(new Color(0, 51, 153));
				GridBagConstraints gbc_rdbtnSecAdd = new GridBagConstraints();
				gbc_rdbtnSecAdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnSecAdd.gridx = 2;
				gbc_rdbtnSecAdd.gridy = 5;
				panel.add(rdbtnSecAdd, gbc_rdbtnSecAdd);

				JRadioButton rdbtnVetAdd = new JRadioButton("VET");
				rdbtnVetAdd.setForeground(new Color(0, 51, 153));
				rdbtnVetAdd.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtnVetAdd = new GridBagConstraints();
				gbc_rdbtnVetAdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnVetAdd.gridx = 3;
				gbc_rdbtnVetAdd.gridy = 5;
				panel.add(rdbtnVetAdd, gbc_rdbtnVetAdd);

				JRadioButton rdbtnAdmAdd = new JRadioButton("ADM");
				rdbtnAdmAdd.setForeground(new Color(0, 51, 153));
				rdbtnAdmAdd.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtnAdmAdd = new GridBagConstraints();
				gbc_rdbtnAdmAdd.anchor = GridBagConstraints.WEST;
				gbc_rdbtnAdmAdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnAdmAdd.gridx = 4;
				gbc_rdbtnAdmAdd.gridy = 5;
				panel.add(rdbtnAdmAdd, gbc_rdbtnAdmAdd);

				JLabel spaceBoundAdd2 = new JLabel("");
				GridBagConstraints gbc_spaceBoundAdd2 = new GridBagConstraints();
				gbc_spaceBoundAdd2.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundAdd2.gridx = 1;
				gbc_spaceBoundAdd2.gridy = 6;
				panel.add(spaceBoundAdd2, gbc_spaceBoundAdd2);

				JButton btnAjouterAdd = new JButton("Ajouter");
				btnAjouterAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						nomTxtAdd.getText();
						String newCode = "";
						if (rdbtnAdmAdd.isSelected()) {
							newCode = "ADM";
						} else if (rdbtnSecAdd.isSelected()) {
							newCode = "SEC";
						} else if (rdbtnVetAdd.isSelected()) {
							newCode = "VET";
						}
						ctrl.create(nomTxtAdd.getText(), newCode);
						listModel.addElement(ctrl.getListPersonnel().get(listModel.getSize()));
						list.setSelectedIndex(listModel.getSize());
						frmAjouterDuPersonnel.setVisible(false);
					}
				});
				btnAjouterAdd.setForeground(new Color(0, 51, 153));
				btnAjouterAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				btnAjouterAdd.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_btnAjouterAdd = new GridBagConstraints();
				gbc_btnAjouterAdd.gridwidth = 2;
				gbc_btnAjouterAdd.anchor = GridBagConstraints.WEST;
				gbc_btnAjouterAdd.insets = new Insets(0, 0, 0, 5);
				gbc_btnAjouterAdd.gridx = 3;
				gbc_btnAjouterAdd.gridy = 7;
				panel.add(btnAjouterAdd, gbc_btnAjouterAdd);
				frmAjouterDuPersonnel.setIconImage(
						Toolkit.getDefaultToolkit().getImage(test.class.getResource("/ressources/ico_veto.png")));
				frmAjouterDuPersonnel.setTitle("Ajouter du personnel");
				frmAjouterDuPersonnel.setBounds(100, 100, 347, 276);
				frmAjouterDuPersonnel.setLocationRelativeTo(null);
				frmAjouterDuPersonnel.setVisible(true);

				rdbtnAdmAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (rdbtnAdmAdd.isSelected()) {
							rdbtnSecAdd.setSelected(false);
							rdbtnVetAdd.setSelected(false);
						}
					}
				});

				rdbtnSecAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (rdbtnSecAdd.isSelected()) {
							rdbtnAdmAdd.setSelected(false);
							rdbtnVetAdd.setSelected(false);
						}
					}
				});

				rdbtnVetAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (rdbtnVetAdd.isSelected()) {
							rdbtnSecAdd.setSelected(false);
							rdbtnAdmAdd.setSelected(false);
						}
					}
				});
			}
		});
		addButon.setIcon(new ImageIcon(MainView.class.getResource("/ressources/blue.png")));
		addButon.setForeground(new Color(0, 51, 153));
		addButon.setBackground(Color.WHITE);
		GridBagConstraints gbc_addButon = new GridBagConstraints();
		gbc_addButon.anchor = GridBagConstraints.EAST;
		gbc_addButon.insets = new Insets(0, 0, 0, 5);
		gbc_addButon.gridx = 4;
		gbc_addButon.gridy = 10;
		idPanel.add(addButon, gbc_addButon);

		// BOUTON ARCHIVER
		btnArchiver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmArchiver = new JFrame();
				frmArchiver.setTitle("Archiver ?");
				frmArchiver.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
				frmArchiver.setBounds(200, 200, 350, 145);

				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				frmArchiver.getContentPane().add(panel, BorderLayout.CENTER);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 98, 5, 29, 5, 0, 0 };
				gbl_panel.rowHeights = new int[] { 24, 0, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
				panel.setLayout(gbl_panel);

				JLabel label = new JLabel("");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.gridwidth = 3;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				panel.add(label, gbc_label);

				JLabel lblNewLabel = new JLabel("Etes-vous s\u00FBr de vouloir archiver cette personne ?");
				lblNewLabel.setForeground(new Color(0, 51, 153));
				lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 5;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);

				JButton validerModalBtn = new JButton("Oui");
				validerModalBtn.setForeground(new Color(0, 51, 153));
				validerModalBtn.setFont(new Font("Gisha", Font.PLAIN, 11));
				validerModalBtn.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_validerModalBtn = new GridBagConstraints();
				gbc_validerModalBtn.insets = new Insets(0, 0, 0, 5);
				gbc_validerModalBtn.anchor = GridBagConstraints.WEST;
				gbc_validerModalBtn.gridx = 1;
				gbc_validerModalBtn.gridy = 2;
				panel.add(validerModalBtn, gbc_validerModalBtn);

				JLabel label_1 = new JLabel("");
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 0, 5);
				gbc_label_1.gridx = 2;
				gbc_label_1.gridy = 2;
				panel.add(label_1, gbc_label_1);

				JButton btnNon = new JButton("Non");
				btnNon.setForeground(new Color(0, 51, 153));
				btnNon.setFont(new Font("Gisha", Font.PLAIN, 11));
				btnNon.setBackground(Color.WHITE);
				GridBagConstraints gbc_btnNon = new GridBagConstraints();
				gbc_btnNon.insets = new Insets(0, 0, 0, 5);
				gbc_btnNon.gridx = 3;
				gbc_btnNon.gridy = 2;
				panel.add(btnNon, gbc_btnNon);

				validerModalBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						frmArchiver.setVisible(false);
						ctrl.archive(listModel.get(index).getCodePers());
						listModel.remove(list.getSelectedIndex());
						int indexActual = list.getSelectedIndex();
						list.setSelectedIndex(indexActual + 1);
						index = list.getSelectedIndex();
						identifiantTxt.setText(Integer.toString(listModel.get(index).getCodePers()));
						nomTxt.setText(listModel.get(index).getNom());
					}
				});

				btnNon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frmArchiver.setVisible(false);
					}
				});

				frmArchiver.setVisible(true);
				frmArchiver.setLocationRelativeTo(null);
			}
		});

		JLabel spaceBoundLbl2 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl2 = new GridBagConstraints();
		gbc_spaceBoundLbl2.insets = new Insets(0, 0, 0, 5);
		gbc_spaceBoundLbl2.gridx = 0;
		gbc_spaceBoundLbl2.gridy = 3;
		panelPersonnels.add(spaceBoundLbl2, gbc_spaceBoundLbl2);
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
					index = list.getSelectedIndex();
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

		rdbtnAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnAdm.isSelected()) {
					rdbtnSec.setSelected(false);
					rdbtnVet.setSelected(false);
				}
			}
		});

		rdbtnSec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnSec.isSelected()) {
					rdbtnAdm.setSelected(false);
					rdbtnVet.setSelected(false);
				}
			}
		});

		rdbtnVet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnVet.isSelected()) {
					rdbtnSec.setSelected(false);
					rdbtnAdm.setSelected(false);
				}
			}
		});

		// BOUTON VALIDER
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newCode = null;
				listModel.get(index).setNom(nomTxt.getText());
				if (rdbtnAdm.isSelected()) {
					newCode = "ADM";
				} else if (rdbtnSec.isSelected()) {
					newCode = "SEC";
				} else if (rdbtnVet.isSelected()) {
					newCode = "VET";
				}
				listModel.get(index).setRole(newCode);

				ctrl.update(listModel.get(index).getNom(), listModel.get(index).getRole(),
						listModel.get(index).getCodePers());
			}
		});

		// BOUTON ANNULER
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				index = list.getSelectedIndex();
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
		});

		frmGestion.setLocationRelativeTo(null);
		frmGestion.setVisible(true);
	}

}
