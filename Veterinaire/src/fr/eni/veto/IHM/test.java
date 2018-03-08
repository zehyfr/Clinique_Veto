package fr.eni.veto.IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class test {

	private JFrame frmInformationsClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmInformationsClient.setVisible(true);
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
		frmInformationsClient = new JFrame();
		frmInformationsClient.getContentPane().setFont(new Font("Gisha", Font.PLAIN, 13));
		frmInformationsClient.getContentPane().setForeground(new Color(0, 51, 153));
		frmInformationsClient.setBackground(Color.WHITE);
		frmInformationsClient.setTitle("Informations client");
		frmInformationsClient.setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/ressources/ico_veto.png")));
		frmInformationsClient.getContentPane().setBackground(Color.WHITE);
		frmInformationsClient.setBounds(100, 100, 435, 432);
		frmInformationsClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{589, 0};
		gridBagLayout.rowHeights = new int[]{338, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmInformationsClient.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmInformationsClient.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{49, 83, 106, 0, 39, 0, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 29, 0, 20, 0, 23, 0, 20, 0, 19, 0, 25, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel titlteInfoClientlbl = new JLabel("Informations client");
		titlteInfoClientlbl.setForeground(new Color(0, 51, 153));
		titlteInfoClientlbl.setFont(new Font("Gisha", Font.BOLD, 18));
		GridBagConstraints gbc_titlteInfoClientlbl = new GridBagConstraints();
		gbc_titlteInfoClientlbl.gridwidth = 2;
		gbc_titlteInfoClientlbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_titlteInfoClientlbl.insets = new Insets(0, 0, 5, 5);
		gbc_titlteInfoClientlbl.gridx = 1;
		gbc_titlteInfoClientlbl.gridy = 1;
		panel.add(titlteInfoClientlbl, gbc_titlteInfoClientlbl);
		
		JLabel imageTitle = new JLabel("");
		imageTitle.setIcon(new ImageIcon(test.class.getResource("/ressources/info icon.png")));
		GridBagConstraints gbc_imageTitle = new GridBagConstraints();
		gbc_imageTitle.anchor = GridBagConstraints.WEST;
		gbc_imageTitle.insets = new Insets(0, 0, 5, 5);
		gbc_imageTitle.gridx = 3;
		gbc_imageTitle.gridy = 1;
		panel.add(imageTitle, gbc_imageTitle);
		
		JLabel spaceBoundinfo6 = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo6 = new GridBagConstraints();
		gbc_spaceBoundinfo6.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo6.gridx = 1;
		gbc_spaceBoundinfo6.gridy = 2;
		panel.add(spaceBoundinfo6, gbc_spaceBoundinfo6);
		
		JLabel nomInfoLbl = new JLabel("Nom : ");
		nomInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		nomInfoLbl.setForeground(new Color(0, 51, 153));
		GridBagConstraints gbc_nomInfoLbl = new GridBagConstraints();
		gbc_nomInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_nomInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_nomInfoLbl.gridx = 1;
		gbc_nomInfoLbl.gridy = 3;
		panel.add(nomInfoLbl, gbc_nomInfoLbl);
		
		JLabel nomInfoTxt = new JLabel("");
		nomInfoTxt.setForeground(new Color(0, 51, 153));
		nomInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_nomInfoTxt = new GridBagConstraints();
		gbc_nomInfoTxt.anchor = GridBagConstraints.WEST;
		gbc_nomInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nomInfoTxt.gridx = 2;
		gbc_nomInfoTxt.gridy = 3;
		panel.add(nomInfoTxt, gbc_nomInfoTxt);
		
		JLabel prenomInfoLbl = new JLabel("Pr\u00E9nom : ");
		prenomInfoLbl.setForeground(new Color(0, 51, 153));
		prenomInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_prenomInfoLbl = new GridBagConstraints();
		gbc_prenomInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_prenomInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_prenomInfoLbl.gridx = 3;
		gbc_prenomInfoLbl.gridy = 3;
		panel.add(prenomInfoLbl, gbc_prenomInfoLbl);
		
		JLabel prenomInfoTxt = new JLabel("");
		prenomInfoTxt.setForeground(new Color(0, 51, 153));
		prenomInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_prenomInfoTxt = new GridBagConstraints();
		gbc_prenomInfoTxt.anchor = GridBagConstraints.WEST;
		gbc_prenomInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_prenomInfoTxt.gridx = 4;
		gbc_prenomInfoTxt.gridy = 3;
		panel.add(prenomInfoTxt, gbc_prenomInfoTxt);
		
		JLabel spaceBoundinfo = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo = new GridBagConstraints();
		gbc_spaceBoundinfo.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo.gridx = 1;
		gbc_spaceBoundinfo.gridy = 4;
		panel.add(spaceBoundinfo, gbc_spaceBoundinfo);
		
		JLabel adresseInfoLbl = new JLabel("Adresse 1 : ");
		adresseInfoLbl.setForeground(new Color(0, 51, 153));
		adresseInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_adresseInfoLbl = new GridBagConstraints();
		gbc_adresseInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_adresseInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_adresseInfoLbl.gridx = 1;
		gbc_adresseInfoLbl.gridy = 5;
		panel.add(adresseInfoLbl, gbc_adresseInfoLbl);
		
		JLabel Adresse1InfoTxt = new JLabel("");
		Adresse1InfoTxt.setForeground(new Color(0, 51, 153));
		Adresse1InfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_Adresse1InfoTxt = new GridBagConstraints();
		gbc_Adresse1InfoTxt.anchor = GridBagConstraints.WEST;
		gbc_Adresse1InfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_Adresse1InfoTxt.gridx = 2;
		gbc_Adresse1InfoTxt.gridy = 5;
		panel.add(Adresse1InfoTxt, gbc_Adresse1InfoTxt);
		
		JLabel adresse2InfoLbl = new JLabel("Adresse 2 : ");
		adresse2InfoLbl.setForeground(new Color(0, 51, 153));
		adresse2InfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_adresse2InfoLbl = new GridBagConstraints();
		gbc_adresse2InfoLbl.anchor = GridBagConstraints.WEST;
		gbc_adresse2InfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_adresse2InfoLbl.gridx = 3;
		gbc_adresse2InfoLbl.gridy = 5;
		panel.add(adresse2InfoLbl, gbc_adresse2InfoLbl);
		
		JLabel adresse2InfoTxt = new JLabel("");
		adresse2InfoTxt.setForeground(new Color(0, 51, 153));
		adresse2InfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_adresse2InfoTxt = new GridBagConstraints();
		gbc_adresse2InfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_adresse2InfoTxt.gridx = 4;
		gbc_adresse2InfoTxt.gridy = 5;
		panel.add(adresse2InfoTxt, gbc_adresse2InfoTxt);
		
		JLabel spaceBoundinfo2 = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo2 = new GridBagConstraints();
		gbc_spaceBoundinfo2.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo2.gridx = 1;
		gbc_spaceBoundinfo2.gridy = 6;
		panel.add(spaceBoundinfo2, gbc_spaceBoundinfo2);
		
		JLabel codePostalInfoLbl = new JLabel("Code postal : ");
		codePostalInfoLbl.setForeground(new Color(0, 51, 153));
		codePostalInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_codePostalInfoLbl = new GridBagConstraints();
		gbc_codePostalInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_codePostalInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_codePostalInfoLbl.gridx = 1;
		gbc_codePostalInfoLbl.gridy = 7;
		panel.add(codePostalInfoLbl, gbc_codePostalInfoLbl);
		
		JLabel codePostalInfoTxt = new JLabel("");
		codePostalInfoTxt.setForeground(new Color(0, 51, 153));
		codePostalInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_codePostalInfoTxt = new GridBagConstraints();
		gbc_codePostalInfoTxt.anchor = GridBagConstraints.WEST;
		gbc_codePostalInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_codePostalInfoTxt.gridx = 2;
		gbc_codePostalInfoTxt.gridy = 7;
		panel.add(codePostalInfoTxt, gbc_codePostalInfoTxt);
		
		JLabel villeInfoLbl = new JLabel("Ville : ");
		villeInfoLbl.setForeground(new Color(0, 51, 153));
		villeInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_villeInfoLbl = new GridBagConstraints();
		gbc_villeInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_villeInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_villeInfoLbl.gridx = 3;
		gbc_villeInfoLbl.gridy = 7;
		panel.add(villeInfoLbl, gbc_villeInfoLbl);
		
		JLabel villeInfoTxt = new JLabel("");
		villeInfoTxt.setForeground(new Color(0, 51, 153));
		villeInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_villeInfoTxt = new GridBagConstraints();
		gbc_villeInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_villeInfoTxt.gridx = 4;
		gbc_villeInfoTxt.gridy = 7;
		panel.add(villeInfoTxt, gbc_villeInfoTxt);
		
		JLabel spaceBoundinfo3 = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo3 = new GridBagConstraints();
		gbc_spaceBoundinfo3.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo3.gridx = 1;
		gbc_spaceBoundinfo3.gridy = 8;
		panel.add(spaceBoundinfo3, gbc_spaceBoundinfo3);
		
		JLabel numTelInfoLbl = new JLabel("N\u00B0 Tel : ");
		numTelInfoLbl.setForeground(new Color(0, 51, 153));
		numTelInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_numTelInfoLbl = new GridBagConstraints();
		gbc_numTelInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_numTelInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_numTelInfoLbl.gridx = 1;
		gbc_numTelInfoLbl.gridy = 9;
		panel.add(numTelInfoLbl, gbc_numTelInfoLbl);
		
		JLabel telInfoTxt = new JLabel("");
		telInfoTxt.setForeground(new Color(0, 51, 153));
		telInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_telInfoTxt = new GridBagConstraints();
		gbc_telInfoTxt.anchor = GridBagConstraints.WEST;
		gbc_telInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_telInfoTxt.gridx = 2;
		gbc_telInfoTxt.gridy = 9;
		panel.add(telInfoTxt, gbc_telInfoTxt);
		
		JLabel emailInfoLbl = new JLabel("eMail : ");
		emailInfoLbl.setForeground(new Color(0, 51, 153));
		emailInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_emailInfoLbl = new GridBagConstraints();
		gbc_emailInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_emailInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_emailInfoLbl.gridx = 3;
		gbc_emailInfoLbl.gridy = 9;
		panel.add(emailInfoLbl, gbc_emailInfoLbl);
		
		JLabel mailInfoTxt = new JLabel("");
		mailInfoTxt.setForeground(new Color(0, 51, 153));
		mailInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_mailInfoTxt = new GridBagConstraints();
		gbc_mailInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_mailInfoTxt.gridx = 4;
		gbc_mailInfoTxt.gridy = 9;
		panel.add(mailInfoTxt, gbc_mailInfoTxt);
		
		JLabel spaceBoundinfo4 = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo4 = new GridBagConstraints();
		gbc_spaceBoundinfo4.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo4.gridx = 1;
		gbc_spaceBoundinfo4.gridy = 10;
		panel.add(spaceBoundinfo4, gbc_spaceBoundinfo4);
		
		JLabel assuranceInfoLbl = new JLabel("Assurance : ");
		assuranceInfoLbl.setForeground(new Color(0, 51, 153));
		assuranceInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_assuranceInfoLbl = new GridBagConstraints();
		gbc_assuranceInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_assuranceInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_assuranceInfoLbl.gridx = 1;
		gbc_assuranceInfoLbl.gridy = 11;
		panel.add(assuranceInfoLbl, gbc_assuranceInfoLbl);
		
		JLabel assuranceInfoTxt = new JLabel("");
		assuranceInfoTxt.setForeground(new Color(0, 51, 153));
		assuranceInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_assuranceInfoTxt = new GridBagConstraints();
		gbc_assuranceInfoTxt.anchor = GridBagConstraints.WEST;
		gbc_assuranceInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_assuranceInfoTxt.gridx = 2;
		gbc_assuranceInfoTxt.gridy = 11;
		panel.add(assuranceInfoTxt, gbc_assuranceInfoTxt);
		
		JLabel commentaireInfoLbl = new JLabel("Commentaire : ");
		commentaireInfoLbl.setForeground(new Color(0, 51, 153));
		commentaireInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_commentaireInfoLbl = new GridBagConstraints();
		gbc_commentaireInfoLbl.anchor = GridBagConstraints.WEST;
		gbc_commentaireInfoLbl.insets = new Insets(0, 0, 5, 5);
		gbc_commentaireInfoLbl.gridx = 3;
		gbc_commentaireInfoLbl.gridy = 11;
		panel.add(commentaireInfoLbl, gbc_commentaireInfoLbl);
		
		JLabel commentaireInfoTxt = new JLabel("");
		commentaireInfoTxt.setForeground(new Color(0, 51, 153));
		commentaireInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_commentaireInfoTxt = new GridBagConstraints();
		gbc_commentaireInfoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_commentaireInfoTxt.gridx = 4;
		gbc_commentaireInfoTxt.gridy = 11;
		panel.add(commentaireInfoTxt, gbc_commentaireInfoTxt);
		
		JLabel spaceBoundinfo5 = new JLabel("");
		GridBagConstraints gbc_spaceBoundinfo5 = new GridBagConstraints();
		gbc_spaceBoundinfo5.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundinfo5.gridx = 1;
		gbc_spaceBoundinfo5.gridy = 12;
		panel.add(spaceBoundinfo5, gbc_spaceBoundinfo5);
		
		JButton btnAnimal = new JButton("Animal");
		btnAnimal.setForeground(new Color(0, 51, 153));
		btnAnimal.setFont(new Font("Gisha", Font.PLAIN, 12));
		btnAnimal.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnAnimal = new GridBagConstraints();
		gbc_btnAnimal.anchor = GridBagConstraints.WEST;
		gbc_btnAnimal.gridwidth = 2;
		gbc_btnAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnimal.gridx = 3;
		gbc_btnAnimal.gridy = 13;
		panel.add(btnAnimal, gbc_btnAnimal);
	}

}
