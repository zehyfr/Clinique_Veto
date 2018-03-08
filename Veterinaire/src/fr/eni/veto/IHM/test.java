package fr.eni.veto.IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fr.eni.veto.BO.Clients;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class test {

	private JFrame frmAjouterDuClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmAjouterDuClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		label.setIcon(new ImageIcon(test.class.getResource("/ressources/ajoutClient icon.jpg")));
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
		
		JTextField prenomClientTxtAdd;
		prenomClientTxtAdd = new JTextField();
		prenomClientTxtAdd.setForeground(new Color(0, 51, 153));
		prenomClientTxtAdd.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 3;
		panel.add(prenomClientTxtAdd, gbc_textField);
		
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
		
		JTextField adresse1ClientTxt;
		adresse1ClientTxt = new JTextField();
		adresse1ClientTxt.setForeground(new Color(0, 51, 153));
		adresse1ClientTxt.setColumns(10);
		GridBagConstraints gbc_adresse1ClientLbl = new GridBagConstraints();
		gbc_adresse1ClientLbl.gridwidth = 2;
		gbc_adresse1ClientLbl.insets = new Insets(0, 0, 5, 5);
		gbc_adresse1ClientLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_adresse1ClientLbl.gridx = 2;
		gbc_adresse1ClientLbl.gridy = 5;
		panel.add(adresse1ClientTxt, gbc_adresse1ClientLbl);
		
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
		
		JTextField codePostalTxtAdd;
		codePostalTxtAdd = new JTextField();
		codePostalTxtAdd.setForeground(new Color(0, 51, 153));
		codePostalTxtAdd.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		panel.add(codePostalTxtAdd, gbc_textField_1);
		
		JLabel villeClientLabel = new JLabel("Ville :");
		villeClientLabel.setForeground(new Color(0, 51, 153));
		villeClientLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_villeClientLabel = new GridBagConstraints();
		gbc_villeClientLabel.anchor = GridBagConstraints.EAST;
		gbc_villeClientLabel.insets = new Insets(0, 0, 5, 5);
		gbc_villeClientLabel.gridx = 5;
		gbc_villeClientLabel.gridy = 7;
		panel.add(villeClientLabel, gbc_villeClientLabel);
		
		JTextField villeTxtAdd;
		villeTxtAdd = new JTextField();
		villeTxtAdd.setForeground(new Color(0, 51, 153));
		villeTxtAdd.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 7;
		panel.add(villeTxtAdd, gbc_textField_2);
		
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
		btnAjouterCAdd.setForeground(new Color(0, 51, 153));
		btnAjouterCAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
		btnAjouterCAdd.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnAjouterCAdd = new GridBagConstraints();
		gbc_btnAjouterCAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAjouterCAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouterCAdd.gridx = 6;
		gbc_btnAjouterCAdd.gridy = 11;
		panel.add(btnAjouterCAdd, gbc_btnAjouterCAdd);
		frmAjouterDuClient.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
		frmAjouterDuClient.setTitle("Ajouter un client");
		frmAjouterDuClient.setBounds(100, 100, 605, 377);
		frmAjouterDuClient.setLocationRelativeTo(null);
		frmAjouterDuClient.setVisible(true);

	}

}
