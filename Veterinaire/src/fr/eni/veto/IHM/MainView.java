package fr.eni.veto.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JDateChooser;

import fr.eni.veto.BO.Agendas;
import fr.eni.veto.BO.Animaux;
import fr.eni.veto.BO.Clients;
import fr.eni.veto.BO.Personnels;
import fr.eni.veto.CTRL.Controler;
import fr.eni.veto.DAL.DALException;

public class MainView {

	private JFrame frmGestion;
	private JTextField nomTxt;
	private JTextField identifiantTxt;
	private Controler ctrl;

	private int indexPersonnel;
	private int indexClient;
	private int indexCmb = 0;

	private JFrame frmArchiverPersonnel;
	private JFrame frmArchiverClient;
	private JFrame frmAjouterDuPersonnel;
	private JFrame frmAjouterDuClient;
	private JFrame frmInformationsClient;
	private JFrame frmChangerLeMot;
	private JFrame ajouterEspece;
	private JFrame ajouterRace;

	private Date dateJour;

	private List<Animaux> arrayListAnimaux;
	private ArrayList<Clients> arrayClientList;
	private ArrayList<Personnels> arrayVetoList;
	private ArrayList<Agendas> listeAgendasArray;
	private ArrayList<String> listeSexe;
	private ArrayList<String> listeRace;
	private List<String> listeEspece;

	private String droitVisibility;

	private Clients nouveau;
	private int codePersonnel;

	private JDateChooser dateField;

	JLabel heureGestion = new JLabel();

	/**
	 * Create the application.
	 */
	public MainView(Controler controler, String aCode, int aCodePers) {
		this.ctrl = controler;
		droitVisibility = aCode;
		codePersonnel = aCodePers;
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
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		frmGestion.getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Gisha", Font.BOLD, 12));
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frmGestion.getContentPane().add(tabbedPane, gbc_tabbedPane);

		/**
		 * ACCUEIL PANEL
		 */

		JPanel panelAccueil = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/bannerv2.png")), 0,
						0, null);
				this.repaint();
			}
		};
		tabbedPane.addTab("Accueil  ",
				new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/home.png")), panelAccueil, null);
		tabbedPane.setForegroundAt(0, new Color(16, 40, 99));
		panelAccueil.setBackground(Color.WHITE);
		GridBagLayout gbl_panelAccueil = new GridBagLayout();
		gbl_panelAccueil.columnWidths = new int[] { 36, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 53, 115, 51, 0, 0 };
		gbl_panelAccueil.rowHeights = new int[] { 23, 40, 43, 195, 42, 58, 0 };
		gbl_panelAccueil.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		gbl_panelAccueil.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelAccueil.setLayout(gbl_panelAccueil);

		JLabel spaceBoundAccueil = new JLabel("");
		GridBagConstraints gbc_spaceBoundAccueil = new GridBagConstraints();
		gbc_spaceBoundAccueil.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundAccueil.gridx = 0;
		gbc_spaceBoundAccueil.gridy = 0;
		panelAccueil.add(spaceBoundAccueil, gbc_spaceBoundAccueil);

		JLabel iconLbl = new JLabel("");
		iconLbl.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/accueilVetoICO.jpg")));
		GridBagConstraints gbc_iconLbl = new GridBagConstraints();
		gbc_iconLbl.insets = new Insets(0, 0, 5, 5);
		gbc_iconLbl.gridx = 1;
		gbc_iconLbl.gridy = 1;
		panelAccueil.add(iconLbl, gbc_iconLbl);

		JLabel bienvenueLbl = new JLabel("BIENVENUE");
		bienvenueLbl.setForeground(new Color(255, 255, 255));
		bienvenueLbl.setFont(new Font("Gisha", Font.BOLD, 30));
		GridBagConstraints gbc_bienvenueLbl = new GridBagConstraints();
		gbc_bienvenueLbl.anchor = GridBagConstraints.NORTH;
		gbc_bienvenueLbl.insets = new Insets(0, 0, 5, 5);
		gbc_bienvenueLbl.gridx = 3;
		gbc_bienvenueLbl.gridy = 1;
		panelAccueil.add(bienvenueLbl, gbc_bienvenueLbl);

		JPanel panelInfoAccueil = new JPanel();
		panelInfoAccueil.setForeground(new Color(0, 51, 102));
		panelInfoAccueil.setBorder(new TitledBorder(new LineBorder(new Color(16, 40, 99), 1, true), "ACCUEIL",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 102)));
		panelInfoAccueil.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelInfoAccueil = new GridBagConstraints();
		gbc_panelInfoAccueil.gridheight = 2;
		gbc_panelInfoAccueil.gridwidth = 9;
		gbc_panelInfoAccueil.insets = new Insets(0, 0, 5, 5);
		gbc_panelInfoAccueil.fill = GridBagConstraints.BOTH;
		gbc_panelInfoAccueil.gridx = 3;
		gbc_panelInfoAccueil.gridy = 3;
		panelAccueil.add(panelInfoAccueil, gbc_panelInfoAccueil);
		GridBagLayout gbl_panelInfoAccueil = new GridBagLayout();
		gbl_panelInfoAccueil.columnWidths = new int[] { 33, 339, 0 };
		gbl_panelInfoAccueil.rowHeights = new int[] { 22, 0, 44, 0, 0, 21, 0 };
		gbl_panelInfoAccueil.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfoAccueil.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelInfoAccueil.setLayout(gbl_panelInfoAccueil);

		JLabel bjrLbl = null;
		String prefix = "";

		switch (droitVisibility) {
		case "ADM":
			prefix = "Administrateur ";
			break;
		case "VET":
			prefix = "Docteur ";
			break;
		case "SEC":
			prefix = "MR/MME ";
			break;
		default:
			break;

		}
		try {
			bjrLbl = new JLabel("Bonjour " + prefix + ctrl.getSalarie(codePersonnel) + " !");
		} catch (DALException e3) {
			e3.printStackTrace();
		}

		JLabel spaceAccueilLbl1 = new JLabel("");
		GridBagConstraints gbc_spaceAccueilLbl1 = new GridBagConstraints();
		gbc_spaceAccueilLbl1.insets = new Insets(0, 0, 5, 5);
		gbc_spaceAccueilLbl1.gridx = 0;
		gbc_spaceAccueilLbl1.gridy = 0;
		panelInfoAccueil.add(spaceAccueilLbl1, gbc_spaceAccueilLbl1);
		bjrLbl.setFont(new Font("Gisha", Font.PLAIN, 15));
		bjrLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_bjrLbl = new GridBagConstraints();
		gbc_bjrLbl.anchor = GridBagConstraints.WEST;
		gbc_bjrLbl.insets = new Insets(0, 0, 5, 0);
		gbc_bjrLbl.gridx = 1;
		gbc_bjrLbl.gridy = 1;
		panelInfoAccueil.add(bjrLbl, gbc_bjrLbl);

		JLabel spacebound7 = new JLabel("");
		GridBagConstraints gbc_spacebound7 = new GridBagConstraints();
		gbc_spacebound7.insets = new Insets(0, 0, 5, 5);
		gbc_spacebound7.gridx = 0;
		gbc_spacebound7.gridy = 2;
		panelInfoAccueil.add(spacebound7, gbc_spacebound7);

		if (droitVisibility == "VET") {
			JLabel prchRdvlbl = new JLabel("Votre prochain RDV est :");
			prchRdvlbl.setForeground(new Color(16, 40, 99));
			prchRdvlbl.setFont(new Font("Gisha", Font.PLAIN, 15));
			GridBagConstraints gbc_prchRdvlbl = new GridBagConstraints();
			gbc_prchRdvlbl.insets = new Insets(0, 0, 5, 0);
			gbc_prchRdvlbl.gridx = 1;
			gbc_prchRdvlbl.gridy = 3;
			panelInfoAccueil.add(prchRdvlbl, gbc_prchRdvlbl);

			String prochainRdv = null;
			Agendas agendas = null;
			try {
				if (ctrl.getRDV(codePersonnel, new Date(System.currentTimeMillis())).isEmpty()) {
					prochainRdv = "Pas de RDV de programmé aujourd'hui.";
				} else {
					agendas = ctrl.getRDV(codePersonnel, new Date(System.currentTimeMillis())).get(0);
					prochainRdv = "à " + agendas.getDateRdv() + " avec MR/MME " + agendas.getNomClient();
				}
			} catch (DALException e1) {
				e1.printStackTrace();
			}

			JLabel resultLbl = new JLabel(prochainRdv);
			resultLbl.setForeground(new Color(16, 40, 99));
			resultLbl.setFont(new Font("Gisha", Font.PLAIN, 15));
			GridBagConstraints gbc_resultLbl = new GridBagConstraints();
			gbc_resultLbl.gridx = 1;
			gbc_resultLbl.gridy = 5;
			panelInfoAccueil.add(resultLbl, gbc_resultLbl);
		}

		JLabel spaceBound7 = new JLabel("");
		GridBagConstraints gbc_spaceBound7 = new GridBagConstraints();
		gbc_spaceBound7.anchor = GridBagConstraints.SOUTH;
		gbc_spaceBound7.insets = new Insets(0, 0, 0, 5);
		gbc_spaceBound7.gridx = 0;
		gbc_spaceBound7.gridy = 5;
		panelAccueil.add(spaceBound7, gbc_spaceBound7);

		JLabel logoutIco = new JLabel("");
		logoutIco.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/shut-down-icon.png")));
		GridBagConstraints gbc_logoutIco = new GridBagConstraints();
		gbc_logoutIco.insets = new Insets(0, 0, 0, 5);
		gbc_logoutIco.anchor = GridBagConstraints.SOUTHWEST;
		gbc_logoutIco.gridx = 13;
		gbc_logoutIco.gridy = 5;
		panelAccueil.add(logoutIco, gbc_logoutIco);

		logoutIco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmGestion.setVisible(false);
				ctrl.getAuth();
			}
		});

		JMenuBar menuBar = new JMenuBar();

		JMenu mnNewMenu = new JMenu("Mon compte");
		menuBar.add(mnNewMenu);
		mnNewMenu.setForeground(new Color(16, 40, 99));
		mnNewMenu.setFont(new Font("Gisha", Font.PLAIN, 14));
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestion mot de passe");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmChangerLeMot = new JFrame();
				frmChangerLeMot.getContentPane().setBackground(new Color(255, 255, 255));
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 32, 193, 0, 156, 0, 0 };
				gridBagLayout.rowHeights = new int[] { 17, 50, 35, 34, 20, 31, 10 };
				gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				frmChangerLeMot.getContentPane().setLayout(gridBagLayout);

				JLabel spaceLabelMdp;
				spaceLabelMdp = new JLabel("");
				GridBagConstraints gbc_spaceLabelMdp = new GridBagConstraints();
				gbc_spaceLabelMdp.insets = new Insets(0, 0, 5, 6);
				gbc_spaceLabelMdp.gridx = 0;
				gbc_spaceLabelMdp.gridy = 0;
				frmChangerLeMot.getContentPane().add(spaceLabelMdp, gbc_spaceLabelMdp);

				JLabel lblAncienMotDe = new JLabel("Ancien mot de passe :");
				lblAncienMotDe.setForeground(new Color(16, 40, 99));
				lblAncienMotDe.setFont(new Font("Gisha", Font.PLAIN, 14));
				lblAncienMotDe.setBackground(new Color(16, 40, 99));
				GridBagConstraints gbc_lblAncienMotDe = new GridBagConstraints();
				gbc_lblAncienMotDe.anchor = GridBagConstraints.WEST;
				gbc_lblAncienMotDe.insets = new Insets(0, 0, 5, 5);
				gbc_lblAncienMotDe.gridx = 1;
				gbc_lblAncienMotDe.gridy = 1;
				frmChangerLeMot.getContentPane().add(lblAncienMotDe, gbc_lblAncienMotDe);

				JPasswordField ancienMdrTxt;
				ancienMdrTxt = new JPasswordField();
				GridBagConstraints gbc_ancienMdrTxt = new GridBagConstraints();
				gbc_ancienMdrTxt.insets = new Insets(0, 0, 5, 5);
				gbc_ancienMdrTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_ancienMdrTxt.gridx = 3;
				gbc_ancienMdrTxt.gridy = 1;
				frmChangerLeMot.getContentPane().add(ancienMdrTxt, gbc_ancienMdrTxt);
				ancienMdrTxt.setColumns(10);

				JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe :");
				lblNouveauMotDe.setForeground(new Color(16, 40, 99));
				lblNouveauMotDe.setFont(new Font("Gisha", Font.PLAIN, 14));
				lblNouveauMotDe.setBackground(new Color(16, 40, 99));
				GridBagConstraints gbc_lblNouveauMotDe = new GridBagConstraints();
				gbc_lblNouveauMotDe.anchor = GridBagConstraints.WEST;
				gbc_lblNouveauMotDe.insets = new Insets(0, 0, 5, 5);
				gbc_lblNouveauMotDe.gridx = 1;
				gbc_lblNouveauMotDe.gridy = 2;
				frmChangerLeMot.getContentPane().add(lblNouveauMotDe, gbc_lblNouveauMotDe);

				JPasswordField nouveauMdp;
				nouveauMdp = new JPasswordField();
				GridBagConstraints gbc_nouveauMdp = new GridBagConstraints();
				gbc_nouveauMdp.insets = new Insets(0, 0, 5, 5);
				gbc_nouveauMdp.fill = GridBagConstraints.HORIZONTAL;
				gbc_nouveauMdp.gridx = 3;
				gbc_nouveauMdp.gridy = 2;
				frmChangerLeMot.getContentPane().add(nouveauMdp, gbc_nouveauMdp);
				nouveauMdp.setColumns(10);

				JLabel lblConfirmerMotDe = new JLabel("Confirmer mot de passe :");
				lblConfirmerMotDe.setForeground(new Color(16, 40, 99));
				lblConfirmerMotDe.setFont(new Font("Gisha", Font.PLAIN, 14));
				lblConfirmerMotDe.setBackground(new Color(16, 40, 99));
				GridBagConstraints gbc_lblConfirmerMotDe = new GridBagConstraints();
				gbc_lblConfirmerMotDe.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblConfirmerMotDe.insets = new Insets(0, 0, 5, 5);
				gbc_lblConfirmerMotDe.gridx = 1;
				gbc_lblConfirmerMotDe.gridy = 3;
				frmChangerLeMot.getContentPane().add(lblConfirmerMotDe, gbc_lblConfirmerMotDe);

				JPasswordField nouveauMdp2;
				nouveauMdp2 = new JPasswordField();
				GridBagConstraints gbc_nouveauMdp2 = new GridBagConstraints();
				gbc_nouveauMdp2.anchor = GridBagConstraints.NORTH;
				gbc_nouveauMdp2.insets = new Insets(0, 0, 5, 5);
				gbc_nouveauMdp2.fill = GridBagConstraints.HORIZONTAL;
				gbc_nouveauMdp2.gridx = 3;
				gbc_nouveauMdp2.gridy = 3;
				frmChangerLeMot.getContentPane().add(nouveauMdp2, gbc_nouveauMdp2);
				nouveauMdp2.setColumns(10);

				JLabel lblAncienMotDe_1 = new JLabel("Ancien mot de passe incorrect");
				lblAncienMotDe_1.setFont(new Font("Gisha", Font.PLAIN, 12));
				lblAncienMotDe_1.setForeground(new Color(153, 51, 51));
				GridBagConstraints gbc_lblAncienMotDe_1 = new GridBagConstraints();
				gbc_lblAncienMotDe_1.gridwidth = 3;
				gbc_lblAncienMotDe_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblAncienMotDe_1.gridx = 1;
				gbc_lblAncienMotDe_1.gridy = 4;
				lblAncienMotDe_1.setVisible(false);
				frmChangerLeMot.getContentPane().add(lblAncienMotDe_1, gbc_lblAncienMotDe_1);

				JButton validerMotdepasseNew = new JButton("Changer mot de passe");
				validerMotdepasseNew.setForeground(new Color(16, 40, 99));
				validerMotdepasseNew.setFont(new Font("Gisha", Font.PLAIN, 12));
				validerMotdepasseNew.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_validerMotdepasseNew = new GridBagConstraints();
				gbc_validerMotdepasseNew.gridwidth = 3;
				gbc_validerMotdepasseNew.anchor = GridBagConstraints.SOUTH;
				gbc_validerMotdepasseNew.insets = new Insets(0, 0, 0, 6);
				gbc_validerMotdepasseNew.gridx = 1;
				gbc_validerMotdepasseNew.gridy = 5;
				validerMotdepasseNew.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (!ancienMdrTxt.getText().equals("") && !nouveauMdp.getText().equals("") && !nouveauMdp2.getText().equals("")) {
							if ((ctrl.validation(String.valueOf(codePersonnel), ancienMdrTxt.getText()) != "0")
									&& (nouveauMdp.getText().equals(nouveauMdp2.getText()))) {
								try {
									ctrl.modifMdp(codePersonnel, nouveauMdp.getText());

									/////////// MODALE VALIDATION ///////////
									frmArchiverPersonnel = new JFrame();
									frmArchiverPersonnel.setTitle("Valider ?");
									frmArchiverPersonnel.setIconImage(
											Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
									frmArchiverPersonnel.setBounds(200, 200, 350, 145);

									JPanel panel = new JPanel();
									panel.setBackground(Color.WHITE);
									frmArchiverPersonnel.getContentPane().add(panel, BorderLayout.CENTER);
									GridBagLayout gbl_panel = new GridBagLayout();
									gbl_panel.columnWidths = new int[] { 98, 5, 41, 5, 0, 0 };
									gbl_panel.rowHeights = new int[] { 24, 0, 0, 0 };
									gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
											Double.MIN_VALUE };
									gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
									panel.setLayout(gbl_panel);

									JLabel label = new JLabel("");
									GridBagConstraints gbc_label = new GridBagConstraints();
									gbc_label.gridwidth = 3;
									gbc_label.insets = new Insets(0, 0, 5, 5);
									gbc_label.gridx = 1;
									gbc_label.gridy = 0;
									panel.add(label, gbc_label);

									JLabel lblNewLabel = new JLabel("Le mot de passe a été changé");
									lblNewLabel.setForeground(new Color(16, 40, 99));
									lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
									GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
									gbc_lblNewLabel.gridwidth = 5;
									gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
									gbc_lblNewLabel.gridx = 0;
									gbc_lblNewLabel.gridy = 1;
									panel.add(lblNewLabel, gbc_lblNewLabel);

									JButton validerModalBtn = new JButton("Ok");
									validerModalBtn.setForeground(new Color(16, 40, 99));
									validerModalBtn.setFont(new Font("Gisha", Font.PLAIN, 11));
									validerModalBtn.setBackground(new Color(255, 255, 255));
									GridBagConstraints gbc_validerModalBtn = new GridBagConstraints();
									gbc_validerModalBtn.insets = new Insets(0, 0, 0, 5);
									gbc_validerModalBtn.anchor = GridBagConstraints.EAST;
									gbc_validerModalBtn.gridx = 3;
									gbc_validerModalBtn.gridy = 2;
									panel.add(validerModalBtn, gbc_validerModalBtn);

									frmArchiverPersonnel.setVisible(true);
									frmArchiverPersonnel.setLocationRelativeTo(null);

									validerModalBtn.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseClicked(MouseEvent e) {
											frmArchiverPersonnel.setVisible(false);
											frmChangerLeMot.setVisible(false);
										}
									});

								} catch (DALException e1) {
									e1.printStackTrace();
								}
							} else {
								lblAncienMotDe_1.setText("Ancien mot de passe incorrect.");
								lblAncienMotDe_1.setVisible(true);
							}
						} else {
							lblAncienMotDe_1.setText("Un ou plusieurs champs sont vides.");
							lblAncienMotDe_1.setVisible(true);
						}
					}
				});

				frmChangerLeMot.getContentPane().add(validerMotdepasseNew, gbc_validerMotdepasseNew);
				frmChangerLeMot.setTitle("Changer le mot de passe");
				frmChangerLeMot.setIconImage(
						Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/accueilVetoICO.jpg")));
				frmChangerLeMot.setBounds(100, 100, 430, 230);
				frmChangerLeMot.setLocationRelativeTo(null);

				frmChangerLeMot.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmDconnection = new JMenuItem("D\u00E9connection");
		mntmDconnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmGestion.setVisible(false);
				ctrl.getAuth();
			}
		});
		mnNewMenu.add(mntmDconnection);

		/**
		 * AGENDA PANEL
		 */

		JPanel panelAgenda = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/bannerv2.png")), 0,
						0, null);
				this.repaint();
			}
		};
		tabbedPane.addTab("Agendas  ",
				new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/calendar.png")), panelAgenda,
				null);
		tabbedPane.setForegroundAt(1, new Color(16, 40, 99));
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));

		panelAgenda.setBackground(Color.WHITE);
		GridBagLayout gbl_panelAgenda = new GridBagLayout();
		gbl_panelAgenda.columnWidths = new int[] { 32, 32, 0, 0, 0, 63, 264, 22, 105, 0 };
		gbl_panelAgenda.rowHeights = new int[] { 28, 0, 38, 269, 58, 0 };
		gbl_panelAgenda.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelAgenda.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelAgenda.setLayout(gbl_panelAgenda);

		JLabel spaceBoundAgenda = new JLabel("");
		GridBagConstraints gbc_spaceBoundAgenda = new GridBagConstraints();
		gbc_spaceBoundAgenda.gridwidth = 2;
		gbc_spaceBoundAgenda.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundAgenda.gridx = 0;
		gbc_spaceBoundAgenda.gridy = 0;
		panelAgenda.add(spaceBoundAgenda, gbc_spaceBoundAgenda);

		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 7;
		gbc_label_4.gridy = 0;
		panelAgenda.add(label_4, gbc_label_4);

		JLabel agendaTitleLbl = new JLabel("Agenda");
		agendaTitleLbl.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/calendarWt.png")));
		agendaTitleLbl.setForeground(Color.WHITE);
		agendaTitleLbl.setFont(new Font("Gisha", Font.BOLD, 30));
		GridBagConstraints gbc_agendaTitleLbl = new GridBagConstraints();
		gbc_agendaTitleLbl.gridwidth = 3;
		gbc_agendaTitleLbl.anchor = GridBagConstraints.EAST;
		gbc_agendaTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_agendaTitleLbl.gridx = 1;
		gbc_agendaTitleLbl.gridy = 1;
		panelAgenda.add(agendaTitleLbl, gbc_agendaTitleLbl);

		JLabel spaceBound3 = new JLabel("");
		GridBagConstraints gbc_spaceBound3 = new GridBagConstraints();
		gbc_spaceBound3.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBound3.gridx = 2;
		gbc_spaceBound3.gridy = 2;
		panelAgenda.add(spaceBound3, gbc_spaceBound3);

		JPanel agendasPanelInside = new JPanel();
		agendasPanelInside.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_agendasPanelInside = new GridBagConstraints();
		gbc_agendasPanelInside.insets = new Insets(0, 0, 5, 0);
		gbc_agendasPanelInside.gridwidth = 8;
		gbc_agendasPanelInside.fill = GridBagConstraints.HORIZONTAL;
		gbc_agendasPanelInside.gridx = 1;
		gbc_agendasPanelInside.gridy = 3;
		panelAgenda.add(agendasPanelInside, gbc_agendasPanelInside);
		GridBagLayout gbl_agendasPanelInside = new GridBagLayout();
		gbl_agendasPanelInside.columnWidths = new int[] { 43, 115, 15, 33, 36, 19, 31, 14, 32, 41, 22, 79, 12, 0 };
		gbl_agendasPanelInside.rowHeights = new int[] { 21, 0, 12, 0, 28, 42, 102, 0 };
		gbl_agendasPanelInside.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gbl_agendasPanelInside.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		agendasPanelInside.setLayout(gbl_agendasPanelInside);

		JLabel dateAnterieurWarnLbl = new JLabel("Attention, la date du RDV est d\u00E9j\u00E0 pass\u00E9e");
		dateAnterieurWarnLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		dateAnterieurWarnLbl.setForeground(new Color(204, 51, 0));
		GridBagConstraints gbc_dateAnterieurWarnLbl = new GridBagConstraints();
		gbc_dateAnterieurWarnLbl.gridwidth = 6;
		gbc_dateAnterieurWarnLbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_dateAnterieurWarnLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dateAnterieurWarnLbl.gridx = 7;
		gbc_dateAnterieurWarnLbl.gridy = 0;
		agendasPanelInside.add(dateAnterieurWarnLbl, gbc_dateAnterieurWarnLbl);
		dateAnterieurWarnLbl.setVisible(false);

		JLabel lblClient = new JLabel("Client :");
		lblClient.setForeground(new Color(16, 40, 99));
		lblClient.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.anchor = GridBagConstraints.WEST;
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 1;
		agendasPanelInside.add(lblClient, gbc_lblClient);

		JComboBox clientsAgendaCmb = new JComboBox();
		clientsAgendaCmb.setForeground(new Color(16, 40, 99));
		clientsAgendaCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_clientsAgendaCmb = new GridBagConstraints();
		gbc_clientsAgendaCmb.insets = new Insets(0, 0, 5, 5);
		gbc_clientsAgendaCmb.fill = GridBagConstraints.HORIZONTAL;
		gbc_clientsAgendaCmb.gridx = 1;
		gbc_clientsAgendaCmb.gridy = 1;
		agendasPanelInside.add(clientsAgendaCmb, gbc_clientsAgendaCmb);
		arrayClientList = new ArrayList<Clients>();
		arrayClientList = ctrl.getAllClients();
		String emptyClient = "Pas de Clients";
		if (arrayClientList.isEmpty()) {
			clientsAgendaCmb.insertItemAt(emptyClient, 0);
			clientsAgendaCmb.setSelectedIndex(0);
		} else {
			clientsAgendaCmb.setModel(new DefaultComboBoxModel(arrayClientList.toArray()));
		}

		JLabel spacebound6 = new JLabel("");
		GridBagConstraints gbc_spacebound6 = new GridBagConstraints();
		gbc_spacebound6.insets = new Insets(0, 0, 5, 5);
		gbc_spacebound6.gridx = 2;
		gbc_spacebound6.gridy = 1;
		agendasPanelInside.add(spacebound6, gbc_spacebound6);

		JLabel veterinaireLbl = new JLabel("V\u00E9t\u00E9rinaire :");
		veterinaireLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		veterinaireLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_veterinaireLbl = new GridBagConstraints();
		gbc_veterinaireLbl.anchor = GridBagConstraints.WEST;
		gbc_veterinaireLbl.insets = new Insets(0, 0, 5, 5);
		gbc_veterinaireLbl.gridx = 3;
		gbc_veterinaireLbl.gridy = 1;
		agendasPanelInside.add(veterinaireLbl, gbc_veterinaireLbl);

		JComboBox veterinaireAgendaCmb = new JComboBox();
		veterinaireAgendaCmb.setForeground(new Color(16, 40, 99));
		veterinaireAgendaCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_veterinaireAgendaCmb = new GridBagConstraints();
		gbc_veterinaireAgendaCmb.gridwidth = 3;
		gbc_veterinaireAgendaCmb.insets = new Insets(0, 0, 5, 5);
		gbc_veterinaireAgendaCmb.fill = GridBagConstraints.HORIZONTAL;
		gbc_veterinaireAgendaCmb.gridx = 4;
		gbc_veterinaireAgendaCmb.gridy = 1;
		agendasPanelInside.add(veterinaireAgendaCmb, gbc_veterinaireAgendaCmb);

		JLabel dateAgendaLbl = new JLabel("Date :");
		dateAgendaLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		dateAgendaLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_dateAgendaLbl = new GridBagConstraints();
		gbc_dateAgendaLbl.insets = new Insets(0, 0, 5, 5);
		gbc_dateAgendaLbl.anchor = GridBagConstraints.EAST;
		gbc_dateAgendaLbl.gridx = 8;
		gbc_dateAgendaLbl.gridy = 1;
		agendasPanelInside.add(dateAgendaLbl, gbc_dateAgendaLbl);

		dateField = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		dateField.setBackground(new Color(255, 255, 255));
		dateField.setForeground(new Color(16, 40, 99));
		dateField.setDate(new Date(System.currentTimeMillis()));
		GridBagConstraints calendar = new GridBagConstraints();
		calendar.gridwidth = 3;
		calendar.insets = new Insets(0, 0, 5, 5);
		calendar.fill = GridBagConstraints.HORIZONTAL;
		calendar.gridx = 9;
		calendar.gridy = 1;
		agendasPanelInside.add(dateField, calendar);
		arrayVetoList = new ArrayList<Personnels>();
		arrayVetoList = ctrl.getListPersonnel(1);
		String emptyVeto = "Pas de vétérinaire";
		if (arrayVetoList.isEmpty()) {
			veterinaireAgendaCmb.insertItemAt(emptyVeto, 0);
			veterinaireAgendaCmb.setSelectedIndex(0);
		} else {
			veterinaireAgendaCmb.setModel(new DefaultComboBoxModel(arrayVetoList.toArray()));
		}
		
		JLabel spaceBound4 = new JLabel("");
		GridBagConstraints gbc_spaceBound4 = new GridBagConstraints();
		gbc_spaceBound4.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBound4.gridx = 7;
		gbc_spaceBound4.gridy = 2;
		agendasPanelInside.add(spaceBound4, gbc_spaceBound4);

		JLabel lblAnimal = new JLabel("Animal :");
		lblAnimal.setForeground(new Color(16, 40, 99));
		lblAnimal.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.anchor = GridBagConstraints.WEST;
		gbc_lblAnimal.gridx = 0;
		gbc_lblAnimal.gridy = 3;
		agendasPanelInside.add(lblAnimal, gbc_lblAnimal);

		JComboBox animalcomboAngendaCmb = new JComboBox();
		animalcomboAngendaCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
		animalcomboAngendaCmb.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_animalcomboAngendaCmb = new GridBagConstraints();
		gbc_animalcomboAngendaCmb.insets = new Insets(0, 0, 5, 5);
		gbc_animalcomboAngendaCmb.fill = GridBagConstraints.HORIZONTAL;
		gbc_animalcomboAngendaCmb.gridx = 1;
		gbc_animalcomboAngendaCmb.gridy = 3;
		agendasPanelInside.add(animalcomboAngendaCmb, gbc_animalcomboAngendaCmb);

		arrayListAnimaux = new ArrayList<Animaux>();
		if (!arrayClientList.isEmpty()) {
			arrayListAnimaux = ctrl
					.getAllAnimaux(arrayClientList.get(clientsAgendaCmb.getSelectedIndex()).getCodeClient());
		}
		String emptyAnimal = "Pas d'animal";
		if (arrayListAnimaux.isEmpty()) {
			animalcomboAngendaCmb.insertItemAt(emptyAnimal, 0);
			animalcomboAngendaCmb.setSelectedIndex(0);
		} else {
			animalcomboAngendaCmb.setModel(new DefaultComboBoxModel(arrayListAnimaux.toArray()));
		}

		JLabel heureAgendaLbl2 = new JLabel("Heure :");
		heureAgendaLbl2.setForeground(new Color(16, 40, 99));
		heureAgendaLbl2.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_heureAgendaLbl2 = new GridBagConstraints();
		gbc_heureAgendaLbl2.anchor = GridBagConstraints.WEST;
		gbc_heureAgendaLbl2.insets = new Insets(0, 0, 5, 5);
		gbc_heureAgendaLbl2.gridx = 3;
		gbc_heureAgendaLbl2.gridy = 3;
		agendasPanelInside.add(heureAgendaLbl2, gbc_heureAgendaLbl2);

		JSpinner spinnerHeureAgendas = new JSpinner();
		spinnerHeureAgendas.setModel(new SpinnerNumberModel(6, 6, 21, 1));
		((DefaultEditor) spinnerHeureAgendas.getEditor()).getTextField().setEditable(false);
		spinnerHeureAgendas.setFont(new Font("Gisha", Font.PLAIN, 12));
		spinnerHeureAgendas.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 4;
		gbc_spinner.gridy = 3;
		agendasPanelInside.add(spinnerHeureAgendas, gbc_spinner);

		JLabel lblH = new JLabel("H");
		lblH.setFont(new Font("Gisha", Font.PLAIN, 12));
		lblH.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 5;
		gbc_lblH.gridy = 3;
		agendasPanelInside.add(lblH, gbc_lblH);

		clientsAgendaCmb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arrayListAnimaux = ctrl
						.getAllAnimaux(arrayClientList.get(clientsAgendaCmb.getSelectedIndex()).getCodeClient());
				if (arrayListAnimaux.isEmpty()) {
					String emptyAnimal = "Pas d'animal";
					animalcomboAngendaCmb.insertItemAt(emptyAnimal, 0);
					animalcomboAngendaCmb.setSelectedIndex(0);
				} else {
					animalcomboAngendaCmb.setModel(new DefaultComboBoxModel(arrayListAnimaux.toArray()));
				}
			}
		});

		JSpinner spinnerMinuteAgendas = new JSpinner();
		spinnerMinuteAgendas.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		((DefaultEditor) spinnerMinuteAgendas.getEditor()).getTextField().setEditable(false);
		spinnerMinuteAgendas.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.anchor = GridBagConstraints.WEST;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 6;
		gbc_spinner_1.gridy = 3;
		agendasPanelInside.add(spinnerMinuteAgendas, gbc_spinner_1);

		JButton ajouterRDVBtn = new JButton("Ajouter RDV");
		ajouterRDVBtn.setBackground(new Color(255, 255, 255));
		ajouterRDVBtn.setFont(new Font("Gisha", Font.PLAIN, 12));
		ajouterRDVBtn.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_ajouterRDVBtn = new GridBagConstraints();
		gbc_ajouterRDVBtn.anchor = GridBagConstraints.EAST;
		gbc_ajouterRDVBtn.gridwidth = 3;
		gbc_ajouterRDVBtn.insets = new Insets(0, 0, 5, 5);
		gbc_ajouterRDVBtn.gridx = 9;
		gbc_ajouterRDVBtn.gridy = 3;
		agendasPanelInside.add(ajouterRDVBtn, gbc_ajouterRDVBtn);

		JLabel verifyAlertlbl = new JLabel(
				"Le v\u00E9t\u00E9rinaire \u00E0 d\u00E9j\u00E0 un RDV sur ce cr\u00E9neau !");
		verifyAlertlbl.setFont(new Font("Gisha", Font.PLAIN, 12));
		verifyAlertlbl.setForeground(new Color(204, 51, 0));
		GridBagConstraints gbc_verifyAlertlbl = new GridBagConstraints();
		gbc_verifyAlertlbl.gridwidth = 6;
		gbc_verifyAlertlbl.insets = new Insets(0, 0, 5, 5);
		gbc_verifyAlertlbl.gridx = 1;
		gbc_verifyAlertlbl.gridy = 4;
		agendasPanelInside.add(verifyAlertlbl, gbc_verifyAlertlbl);
		verifyAlertlbl.setVisible(false);

		JLabel label_5 = new JLabel("_____________________________________________________________");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.NORTHEAST;
		gbc_label_5.gridwidth = 11;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 5;
		agendasPanelInside.add(label_5, gbc_label_5);

		DefaultListModel<String> listModelAgendas = new DefaultListModel<String>();
		JList listeRdv = new JList(listModelAgendas);
		listeRdv.setFont(new Font("Gisha", Font.PLAIN, 14));
		listeRdv.setForeground(new Color(16, 40, 99));
		listeAgendasArray = new ArrayList<Agendas>();
		if (!arrayVetoList.isEmpty()) {
			try {
				listeAgendasArray = ctrl.getRDV(
						arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers(), dateField.getDate());
			} catch (DALException e2) {
				e2.printStackTrace();
			}
		}
		String tempList = "";
		for (Agendas rdv : listeAgendasArray) {
			int minutesAffichage = rdv.getDateRdv().getMinutes();
			if (minutesAffichage == 0) {
				tempList = "MR/MME " + rdv.getNomClient() + " HEURE: " + rdv.getDateRdv().getHours() + ":" + "00"
						+ " LE : "
						+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(rdv.getDateRdv()).toUpperCase()
								+ " | Vétérinaire : " + rdv.getNomVeto());
			} else {
				tempList = "MR/MME " + rdv.getNomClient() + " HEURE: " + rdv.getDateRdv().getHours() + ":"
						+ minutesAffichage + " LE : "
						+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(rdv.getDateRdv()).toUpperCase()
								+ " | Vétérinaire : " + rdv.getNomVeto());
			}
			listModelAgendas.addElement(tempList);
		}
		
		
		JButton supprimerRdvBtn = new JButton("");
		supprimerRdvBtn.setBackground(Color.WHITE);
		supprimerRdvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!listeRdv.isSelectionEmpty()) {
					try {
						listeAgendasArray = ctrl.getRDV(
								arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers(),
								dateField.getDate());
					} catch (DALException e1) {
						e1.printStackTrace();
					}
					Agendas agendasSuppr = new Agendas(listeAgendasArray.get(listeRdv.getSelectedIndex()).getCodeVeto(),
							listeAgendasArray.get(listeRdv.getSelectedIndex()).getDateRdv(),
							listeAgendasArray.get(listeRdv.getSelectedIndex()).getCodeAnimal());
					try {
						ctrl.supprimerRdv(agendasSuppr);
					} catch (DALException e) {
						e.printStackTrace();
					}

					listModelAgendas.remove(listeRdv.getSelectedIndex());

					if (listModelAgendas.isEmpty()) {
						supprimerRdvBtn.setEnabled(false);
					}
				}
			}
		});
		supprimerRdvBtn.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/trash.png")));
		GridBagConstraints gbc_supprimerRdvBtn = new GridBagConstraints();
		gbc_supprimerRdvBtn.anchor = GridBagConstraints.EAST;
		gbc_supprimerRdvBtn.insets = new Insets(0, 0, 5, 5);
		gbc_supprimerRdvBtn.gridx = 11;
		gbc_supprimerRdvBtn.gridy = 5;
		agendasPanelInside.add(supprimerRdvBtn, gbc_supprimerRdvBtn);
		supprimerRdvBtn.setEnabled(false);

		if (!listModelAgendas.isEmpty()) {
			supprimerRdvBtn.setEnabled(true);
		} else {
			supprimerRdvBtn.setEnabled(false);
		}

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		agendasPanelInside.add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(listeRdv);

		// AJOUTER UN RDV
		ajouterRDVBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listeAgendasArray = ctrl.getRDV(
							arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers(),
							dateField.getDate());
				} catch (DALException e2) {
					e2.printStackTrace();
				}
				Date dateJ = new Date(System.currentTimeMillis());
				Date dateRdv = dateField.getDate();
				dateRdv.setHours((int) spinnerHeureAgendas.getValue());
				dateRdv.setMinutes((int) spinnerMinuteAgendas.getValue());
				dateRdv.setSeconds(00);
				if (dateJ.before(dateRdv)) {
					dateAnterieurWarnLbl.setVisible(false);
					int a = arrayListAnimaux.get(animalcomboAngendaCmb.getSelectedIndex()).getCodeAnimal();
					int v = arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers();
					String vName = arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getNom();
					String cName = arrayClientList.get(clientsAgendaCmb.getSelectedIndex()).getNomClient();
					Agendas nouveauRDV = new Agendas(v, dateRdv, a, vName, cName);
					try {
						if (ctrl.verify(v, nouveauRDV.getDateRdv())) {
							ctrl.rdv(nouveauRDV);
							String tempList = "";
							int minutesAffichage = nouveauRDV.getDateRdv().getMinutes();
							if (minutesAffichage == 0) {
								tempList = "MR/MME " + nouveauRDV.getNomClient() + " HEURE: "
										+ nouveauRDV.getDateRdv().getHours() + ":" + "00" + " LE : "
										+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(nouveauRDV.getDateRdv())
												.toUpperCase() + " | Vétérinaire : " + nouveauRDV.getNomVeto());
							} else {
								tempList = "MR/MME " + nouveauRDV.getNomClient() + " HEURE: "
										+ nouveauRDV.getDateRdv().getHours() + ":" + minutesAffichage + " LE : "
										+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(nouveauRDV.getDateRdv())
												.toUpperCase() + " | Vétérinaire : " + nouveauRDV.getNomVeto());
							}
							listModelAgendas.addElement(tempList);
							listeRdv.setSelectedIndex(listModelAgendas.getSize());
							verifyAlertlbl.setVisible(false);
						} else {
							verifyAlertlbl.setVisible(true);
						}
					} catch (DALException | SQLException | ParseException e1) {
						e1.printStackTrace();
					}

					if (!listModelAgendas.isEmpty()) {
						supprimerRdvBtn.setEnabled(true);
					}
				} else {
					dateAnterieurWarnLbl.setVisible(true);
				}
			}
		});

		veterinaireAgendaCmb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Agendas> listeAgendasArray = new ArrayList<Agendas>();
				listModelAgendas.removeAllElements();
				try {
					listeAgendasArray = ctrl.getRDV(
							arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers(),
							dateField.getDate());
				} catch (DALException e2) {
					e2.printStackTrace();
				}
				for (Agendas rdv : listeAgendasArray) {
					String tempList = "";
					int minutesAffichage = rdv.getDateRdv().getMinutes();
					if (minutesAffichage == 0) {
						tempList = "MR/MME " + rdv.getNomClient() + " HEURE: " + rdv.getDateRdv().getHours() + ":"
								+ "00" + " LE : "
								+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(rdv.getDateRdv()).toUpperCase()
										+ " | Vétérinaire : " + rdv.getNomVeto());
					} else {
						tempList = "MR/MME " + rdv.getNomClient() + " HEURE: " + rdv.getDateRdv().getHours() + ":"
								+ minutesAffichage + " LE : "
								+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(rdv.getDateRdv()).toUpperCase()
										+ " | Vétérinaire : " + rdv.getNomVeto());
					}

					listModelAgendas.addElement(tempList);
				}
			}
		});

		dateField.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				ArrayList<Agendas> listeAgendasArray = new ArrayList<Agendas>();
				listModelAgendas.removeAllElements();
				if (!listeAgendasArray.isEmpty()) {
					try {
						listeAgendasArray = ctrl.getRDV(
								arrayVetoList.get(veterinaireAgendaCmb.getSelectedIndex()).getCodePers(),
								dateField.getDate());
					} catch (DALException e2) {
						e2.printStackTrace();
					}
				}
				for (Agendas rdv : listeAgendasArray) {
					String minutesAffichage = "00";
					if (rdv.getDateRdv().getMinutes() == 0) {
						minutesAffichage = "00";
					}
					String tempList = "MR/MME " + rdv.getNomClient() + " HEURE: " + rdv.getDateRdv().getHours() + ":"
							+ minutesAffichage + " LE : "
							+ (new SimpleDateFormat(" EEEE dd / MM / yyyy").format(rdv.getDateRdv()).toUpperCase()
									+ " | Vétérinaire : " + rdv.getNomVeto());
					listModelAgendas.addElement(tempList);
				}
			}
		});

		/**
		 * CLIENT PANEL
		 */

		if (droitVisibility == "SEC" || droitVisibility == "ADM") {
		JPanel panelClient = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/bannerv2.png")), 0,
						0, null);
				this.repaint();
			}
		};
		tabbedPane.addTab("Gestion Clients  ",
				new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/multiple-users-silhouette2.png")),
				panelClient, null);

		panelClient.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panelClient = new GridBagLayout();
		gbl_panelClient.columnWidths = new int[] { 26, 38, 143, 164, 15, 253, 17, 0 };
		gbl_panelClient.rowHeights = new int[] { 25, 36, 40, 238, 53, 0 };
		gbl_panelClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelClient.setLayout(gbl_panelClient);

		JLabel spaceBoundC2lbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundC2lbl = new GridBagConstraints();
		gbc_spaceBoundC2lbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundC2lbl.gridx = 1;
		gbc_spaceBoundC2lbl.gridy = 0;
		panelClient.add(spaceBoundC2lbl, gbc_spaceBoundC2lbl);

		heureGestion.setForeground(new Color(16, 40, 99));
		heureGestion.setFont(new Font("Gisha", Font.BOLD, 12));
		GridBagConstraints gbc_heureGestion = new GridBagConstraints();
		gbc_heureGestion.gridwidth = 2;
		gbc_heureGestion.anchor = GridBagConstraints.EAST;
		gbc_heureGestion.insets = new Insets(0, 0, 5, 0);
		gbc_heureGestion.gridx = 5;
		gbc_heureGestion.gridy = 0;
		panelClient.add(heureGestion, gbc_heureGestion);

		JLabel spaceBoundC3lbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundC3lbl = new GridBagConstraints();
		gbc_spaceBoundC3lbl.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_spaceBoundC3lbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundC3lbl.gridx = 0;
		gbc_spaceBoundC3lbl.gridy = 1;
		panelClient.add(spaceBoundC3lbl, gbc_spaceBoundC3lbl);

		JLabel gestionClientTitleLbl = new JLabel(" Gestion des clients");
		gestionClientTitleLbl
				.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/multipleWt.png")));
		gestionClientTitleLbl.setForeground(Color.WHITE);
		gestionClientTitleLbl.setFont(new Font("Gisha", Font.BOLD, 30));
		GridBagConstraints gbc_gestionClientTitleLbl = new GridBagConstraints();
		gbc_gestionClientTitleLbl.gridwidth = 3;
		gbc_gestionClientTitleLbl.anchor = GridBagConstraints.WEST;
		gbc_gestionClientTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_gestionClientTitleLbl.gridx = 1;
		gbc_gestionClientTitleLbl.gridy = 1;
		panelClient.add(gestionClientTitleLbl, gbc_gestionClientTitleLbl);

		JLabel spaceBoundCLbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundCLbl = new GridBagConstraints();
		gbc_spaceBoundCLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundCLbl.gridx = 4;
		gbc_spaceBoundCLbl.gridy = 1;
		panelClient.add(spaceBoundCLbl, gbc_spaceBoundCLbl);

		JLabel spaceBoundClbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundClbl = new GridBagConstraints();
		gbc_spaceBoundClbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundClbl.gridx = 1;
		gbc_spaceBoundClbl.gridy = 2;
		panelClient.add(spaceBoundClbl, gbc_spaceBoundClbl);

		// LISTE CLIENTS
		DefaultListModel<Clients> listModelClient = new DefaultListModel<Clients>();
		JList liste = new JList(listModelClient);
		ArrayList<Clients> listeClients = new ArrayList<Clients>();
		listeClients = ctrl.getAllClients();
		for (Clients client : listeClients) {
			listModelClient.addElement(client);
		}
		liste.setLayoutOrientation(JList.VERTICAL);
		liste.setForeground(new Color(16, 40, 99));
		liste.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		liste.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(16, 40, 99)));
		GridBagConstraints gbc_listeClient = new GridBagConstraints();
		gbc_listeClient.gridheight = 2;
		gbc_listeClient.gridwidth = 3;
		gbc_listeClient.insets = new Insets(0, 0, 5, 5);
		gbc_listeClient.fill = GridBagConstraints.BOTH;
		gbc_listeClient.gridx = 1;
		gbc_listeClient.gridy = 3;
		panelClient.add(liste, gbc_listeClient);

		liste.setSelectedIndex(0);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 3;
		panelClient.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 23, 37, 35, 55, 67, 16, 0 };
		gbl_panel_1.rowHeights = new int[] { 28, 0, 16, 0, 25, 0, 36, 14, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel identifiantCLbl = new JLabel("Client :");
		identifiantCLbl.setFont(new Font("Gisha", Font.PLAIN, 14));
		identifiantCLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_identifiantCLbl = new GridBagConstraints();
		gbc_identifiantCLbl.anchor = GridBagConstraints.EAST;
		gbc_identifiantCLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantCLbl.gridx = 2;
		gbc_identifiantCLbl.gridy = 1;
		panel_1.add(identifiantCLbl, gbc_identifiantCLbl);

		JLabel clientNameLbl = new JLabel("");
		if (!listModelClient.isEmpty()) {
			if (listModelClient.get(liste.getSelectedIndex()).getNomClient() != null) {
				clientNameLbl.setText(listModelClient.get(liste.getSelectedIndex()).getNomClient());
			}
		}
		clientNameLbl.setFont(new Font("Gisha", Font.PLAIN, 14));
		clientNameLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_clientNameLbl = new GridBagConstraints();
		gbc_clientNameLbl.gridwidth = 2;
		gbc_clientNameLbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_clientNameLbl.insets = new Insets(0, 0, 5, 5);
		gbc_clientNameLbl.gridx = 3;
		gbc_clientNameLbl.gridy = 1;
		panel_1.add(clientNameLbl, gbc_clientNameLbl);

		liste.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (liste.getSelectedIndex() < 0) {
					indexClient = 0;
				} else {
					indexClient = liste.getSelectedIndex();
				}
				if(!listModelClient.isEmpty())
				{
					clientNameLbl.setText(listModelClient.get(indexClient).getNomClient());
				}
				else
				{
					clientNameLbl.setText("Pas de séléction");
				}
			}
		});

		/**
		 * INFORMATION CLIENT ET SON ANIMAL
		 * 
		 */

		JButton buttonPlus = new JButton("Voir les informations");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmInformationsClient = new JFrame();
				frmInformationsClient.getContentPane().setFont(new Font("Gisha", Font.PLAIN, 13));
				frmInformationsClient.getContentPane().setForeground(new Color(16, 40, 99));
				frmInformationsClient.setBackground(Color.WHITE);
				frmInformationsClient.setTitle("Informations client");
				frmInformationsClient.setIconImage(
						Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/ico_veto.png")));
				frmInformationsClient.getContentPane().setBackground(Color.WHITE);
				frmInformationsClient.setBounds(100, 100, 950, 388);
				frmInformationsClient.setLocationRelativeTo(null);
				GridBagLayout gridBagLayout = new GridBagLayout();
				gridBagLayout.columnWidths = new int[] { 832, 0 };
				gridBagLayout.rowHeights = new int[] { 338, 0 };
				gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
				gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
				frmInformationsClient.getContentPane().setLayout(gridBagLayout);

				// Panel global
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
				frmInformationsClient.getContentPane().add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 39, 83, 112, 70, 97, 485, 23, 0 };
				gbl_panel.rowHeights = new int[] { 17, 0, 29, 20, 20, 0, 23, 0, 20, 0, 19, 0, 20, 0, 25, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel.setLayout(gbl_panel);

				// titre de la vue
				JLabel titlteInfoClientlbl = new JLabel("Informations client");
				titlteInfoClientlbl.setForeground(new Color(16, 40, 99));
				titlteInfoClientlbl.setFont(new Font("Gisha", Font.BOLD, 18));
				GridBagConstraints gbc_titlteInfoClientlbl = new GridBagConstraints();
				gbc_titlteInfoClientlbl.gridwidth = 2;
				gbc_titlteInfoClientlbl.anchor = GridBagConstraints.SOUTHWEST;
				gbc_titlteInfoClientlbl.insets = new Insets(0, 0, 5, 5);
				gbc_titlteInfoClientlbl.gridx = 1;
				gbc_titlteInfoClientlbl.gridy = 1;
				panel.add(titlteInfoClientlbl, gbc_titlteInfoClientlbl);

				// logo de la vue
				JLabel imageTitle = new JLabel("");
				imageTitle.setIcon(new ImageIcon(getClass().getResource("ressources/icon.png")));
				GridBagConstraints gbc_imageTitle = new GridBagConstraints();
				gbc_imageTitle.anchor = GridBagConstraints.WEST;
				gbc_imageTitle.insets = new Insets(0, 0, 5, 5);
				gbc_imageTitle.gridx = 3;
				gbc_imageTitle.gridy = 1;
				panel.add(imageTitle, gbc_imageTitle);

				JLabel spaceBoundInfo7 = new JLabel("");
				GridBagConstraints gbc_spaceBoundInfo7 = new GridBagConstraints();
				gbc_spaceBoundInfo7.insets = new Insets(0, 0, 5, 0);
				gbc_spaceBoundInfo7.gridx = 6;
				gbc_spaceBoundInfo7.gridy = 1;
				panel.add(spaceBoundInfo7, gbc_spaceBoundInfo7);

				JLabel spaceBoundinfo6 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo6 = new GridBagConstraints();
				gbc_spaceBoundinfo6.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo6.gridx = 1;
				gbc_spaceBoundinfo6.gridy = 2;
				panel.add(spaceBoundinfo6, gbc_spaceBoundinfo6);

				// Nom du client
				JLabel nomInfoLbl = new JLabel("Nom : ");
				nomInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				nomInfoLbl.setForeground(new Color(16, 40, 99));
				GridBagConstraints gbc_nomInfoLbl = new GridBagConstraints();
				gbc_nomInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_nomInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_nomInfoLbl.gridx = 1;
				gbc_nomInfoLbl.gridy = 3;
				panel.add(nomInfoLbl, gbc_nomInfoLbl);

				JLabel nomInfoTxt = new JLabel(listModelClient.get(indexClient).getNomClient());
				nomInfoTxt.setForeground(new Color(16, 40, 99));
				nomInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_nomInfoTxt = new GridBagConstraints();
				gbc_nomInfoTxt.anchor = GridBagConstraints.WEST;
				gbc_nomInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_nomInfoTxt.gridx = 2;
				gbc_nomInfoTxt.gridy = 3;
				panel.add(nomInfoTxt, gbc_nomInfoTxt);

				// prenom du client
				JLabel prenomInfoLbl = new JLabel("Pr\u00E9nom : ");
				prenomInfoLbl.setForeground(new Color(16, 40, 99));
				prenomInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_prenomInfoLbl = new GridBagConstraints();
				gbc_prenomInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_prenomInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_prenomInfoLbl.gridx = 3;
				gbc_prenomInfoLbl.gridy = 3;
				panel.add(prenomInfoLbl, gbc_prenomInfoLbl);

				JLabel prenomInfoTxt = new JLabel(listModelClient.get(indexClient).getPrenomClient());
				prenomInfoTxt.setForeground(new Color(16, 40, 99));
				prenomInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_prenomInfoTxt = new GridBagConstraints();
				gbc_prenomInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_prenomInfoTxt.anchor = GridBagConstraints.WEST;
				gbc_prenomInfoTxt.gridx = 4;
				gbc_prenomInfoTxt.gridy = 3;
				panel.add(prenomInfoTxt, gbc_prenomInfoTxt);

				// panel info de l'animal
				JPanel panelAnimal = new JPanel();
				panelAnimal.setBackground(new Color(250, 250, 255));
				panelAnimal.setBorder(new TitledBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(16, 40, 99)),
						"Animal du client", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(16, 40, 99)));
				GridBagConstraints gbc_panelAnimal = new GridBagConstraints();
				gbc_panelAnimal.gridheight = 12;
				gbc_panelAnimal.insets = new Insets(0, 0, 5, 5);
				gbc_panelAnimal.fill = GridBagConstraints.BOTH;
				gbc_panelAnimal.gridx = 5;
				gbc_panelAnimal.gridy = 2;
				panel.add(panelAnimal, gbc_panelAnimal);
				GridBagLayout gbl_panelAnimal = new GridBagLayout();
				gbl_panelAnimal.columnWidths = new int[] { 20, 23, 89, 19, 44, 99, 0, 0 };
				gbl_panelAnimal.rowHeights = new int[] { 13, 0, 21, 0, 22, 22, 19, 0, 26, 0, 0 };
				gbl_panelAnimal.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panelAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
						Double.MIN_VALUE };
				panelAnimal.setLayout(gbl_panelAnimal);

				JLabel spaceAnimal = new JLabel("");
				GridBagConstraints gbc_spaceAnimal = new GridBagConstraints();
				gbc_spaceAnimal.insets = new Insets(0, 0, 5, 5);
				gbc_spaceAnimal.gridx = 1;
				gbc_spaceAnimal.gridy = 0;
				panelAnimal.add(spaceAnimal, gbc_spaceAnimal);

				// numero de l'animal
				JLabel numeroAnimalLbl = new JLabel("N\u00B0 : ");
				numeroAnimalLbl.setForeground(new Color(16, 40, 99));
				numeroAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_numeroAnimalLbl = new GridBagConstraints();
				gbc_numeroAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_numeroAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_numeroAnimalLbl.gridx = 1;
				gbc_numeroAnimalLbl.gridy = 1;
				panelAnimal.add(numeroAnimalLbl, gbc_numeroAnimalLbl);

				JTextField numeroAnimalTxt;
				numeroAnimalTxt = new JTextField();
				GridBagConstraints gbc_numeroAnimalTxt = new GridBagConstraints();
				gbc_numeroAnimalTxt.insets = new Insets(0, 0, 5, 5);
				gbc_numeroAnimalTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_numeroAnimalTxt.gridx = 2;
				gbc_numeroAnimalTxt.gridy = 1;
				panelAnimal.add(numeroAnimalTxt, gbc_numeroAnimalTxt);
				numeroAnimalTxt.setColumns(10);
				numeroAnimalTxt.setEnabled(false);

				JLabel nomAnimalLbl = new JLabel("Nom : ");
				nomAnimalLbl.setForeground(new Color(16, 40, 99));
				nomAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_nomAnimalLbl = new GridBagConstraints();
				gbc_nomAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_nomAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_nomAnimalLbl.gridx = 4;
				gbc_nomAnimalLbl.gridy = 1;
				panelAnimal.add(nomAnimalLbl, gbc_nomAnimalLbl);

				JTextField nomAnimalTxt;
				nomAnimalTxt = new JTextField();
				GridBagConstraints gbc_nomAnimalTxt = new GridBagConstraints();
				gbc_nomAnimalTxt.insets = new Insets(0, 0, 5, 5);
				gbc_nomAnimalTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_nomAnimalTxt.gridx = 5;
				gbc_nomAnimalTxt.gridy = 1;
				panelAnimal.add(nomAnimalTxt, gbc_nomAnimalTxt);
				nomAnimalTxt.setColumns(10);

				JLabel label = new JLabel("");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 2;
				panelAnimal.add(label, gbc_label);

				JLabel sexeAnimalLbl = new JLabel("Sexe : ");
				sexeAnimalLbl.setForeground(new Color(16, 40, 99));
				sexeAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_sexeAnimalLbl = new GridBagConstraints();
				gbc_sexeAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_sexeAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_sexeAnimalLbl.gridx = 1;
				gbc_sexeAnimalLbl.gridy = 3;
				panelAnimal.add(sexeAnimalLbl, gbc_sexeAnimalLbl);

				JComboBox<String> sexeAnimalCmb = new JComboBox<String>();
				sexeAnimalCmb.setForeground(new Color(16, 40, 99));
				sexeAnimalCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_sexeAnimalCmb = new GridBagConstraints();
				gbc_sexeAnimalCmb.insets = new Insets(0, 0, 5, 5);
				gbc_sexeAnimalCmb.fill = GridBagConstraints.HORIZONTAL;
				gbc_sexeAnimalCmb.gridx = 2;
				gbc_sexeAnimalCmb.gridy = 3;
				panelAnimal.add(sexeAnimalCmb, gbc_sexeAnimalCmb);

				listeSexe = new ArrayList<String>();
				listeSexe.add("M");
				listeSexe.add("F");
				listeSexe.add("H");
				sexeAnimalCmb.setModel(new DefaultComboBoxModel(listeSexe.toArray()));

				JLabel couleurAnimalLbl = new JLabel("Couleur : ");
				couleurAnimalLbl.setForeground(new Color(16, 40, 99));
				couleurAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_couleurAnimalLbl = new GridBagConstraints();
				gbc_couleurAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_couleurAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_couleurAnimalLbl.gridx = 4;
				gbc_couleurAnimalLbl.gridy = 3;
				panelAnimal.add(couleurAnimalLbl, gbc_couleurAnimalLbl);

				JTextField couleurAnimalTxt;
				couleurAnimalTxt = new JTextField();
				couleurAnimalTxt.setText("");
				GridBagConstraints gbc_couleurAnimalTxt = new GridBagConstraints();
				gbc_couleurAnimalTxt.insets = new Insets(0, 0, 5, 5);
				gbc_couleurAnimalTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_couleurAnimalTxt.gridx = 5;
				gbc_couleurAnimalTxt.gridy = 3;
				panelAnimal.add(couleurAnimalTxt, gbc_couleurAnimalTxt);
				couleurAnimalTxt.setColumns(10);

				JLabel label_1 = new JLabel("");
				GridBagConstraints gbc_label_1 = new GridBagConstraints();
				gbc_label_1.insets = new Insets(0, 0, 5, 5);
				gbc_label_1.gridx = 1;
				gbc_label_1.gridy = 4;
				panelAnimal.add(label_1, gbc_label_1);

				JLabel raceAnimalLbl = new JLabel("Race : ");
				raceAnimalLbl.setForeground(new Color(16, 40, 99));
				raceAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_raceAnimalLbl = new GridBagConstraints();
				gbc_raceAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_raceAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_raceAnimalLbl.gridx = 1;
				gbc_raceAnimalLbl.gridy = 5;
				panelAnimal.add(raceAnimalLbl, gbc_raceAnimalLbl);

				JComboBox<String> raceAnimalCmb = new JComboBox<String>();
				raceAnimalCmb.setForeground(new Color(16, 40, 99));
				raceAnimalCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_raceAnimalCmb = new GridBagConstraints();
				gbc_raceAnimalCmb.insets = new Insets(0, 0, 5, 5);
				gbc_raceAnimalCmb.fill = GridBagConstraints.HORIZONTAL;
				gbc_raceAnimalCmb.gridx = 2;
				gbc_raceAnimalCmb.gridy = 5;
				panelAnimal.add(raceAnimalCmb, gbc_raceAnimalCmb);
				
				JButton addRacebtn = new JButton("");
				addRacebtn.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/plus16.png")));
				GridBagConstraints gbc_addRacebtn = new GridBagConstraints();
				gbc_addRacebtn.insets = new Insets(0, 0, 5, 5);
				gbc_addRacebtn.gridx = 3;
				gbc_addRacebtn.gridy = 5;
				panelAnimal.add(addRacebtn, gbc_addRacebtn);
				
				addRacebtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ajouterRace = new JFrame();
						ajouterRace.setTitle("Ajouter une race");
						ajouterRace.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/fr/eni/veto/IHM/ressources/ico_veto.png")));
						ajouterRace.setBackground(Color.WHITE);
						ajouterRace.getContentPane().setBackground(Color.WHITE);
						GridBagLayout gridBagLayout = new GridBagLayout();
						gridBagLayout.columnWidths = new int[]{20, 0, 29, 0, 26, 0};
						gridBagLayout.rowHeights = new int[]{46, 0, 24, 0, 21, 0, 0};
						gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
						gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
						ajouterRace.getContentPane().setLayout(gridBagLayout);
						
						JLabel spaceAddRace = new JLabel("");
						GridBagConstraints gbc_spaceAddRace = new GridBagConstraints();
						gbc_spaceAddRace.insets = new Insets(0, 0, 5, 5);
						gbc_spaceAddRace.gridx = 0;
						gbc_spaceAddRace.gridy = 0;
						ajouterRace.getContentPane().add(spaceAddRace, gbc_spaceAddRace);
						
						JLabel lblAjouterUneRace = new JLabel("Ajouter une race :");
						lblAjouterUneRace.setForeground(new Color(0, 51, 102));
						lblAjouterUneRace.setFont(new Font("Gisha", Font.BOLD, 16));
						GridBagConstraints gbc_lblAjouterUneRace = new GridBagConstraints();
						gbc_lblAjouterUneRace.insets = new Insets(0, 0, 5, 5);
						gbc_lblAjouterUneRace.anchor = GridBagConstraints.WEST;
						gbc_lblAjouterUneRace.gridx = 1;
						gbc_lblAjouterUneRace.gridy = 1;
						ajouterRace.getContentPane().add(lblAjouterUneRace, gbc_lblAjouterUneRace);
						
						JComboBox<String> selectEspeceCmb = new JComboBox();
						selectEspeceCmb.setFont(new Font("Gisha", Font.PLAIN, 13));
						selectEspeceCmb.setForeground(new Color(0, 51, 102));
						GridBagConstraints gbc_selectEspeceCmb = new GridBagConstraints();
						gbc_selectEspeceCmb.insets = new Insets(0, 0, 5, 5);
						gbc_selectEspeceCmb.fill = GridBagConstraints.HORIZONTAL;
						gbc_selectEspeceCmb.gridx = 3;
						gbc_selectEspeceCmb.gridy = 1;
						ajouterRace.getContentPane().add(selectEspeceCmb, gbc_selectEspeceCmb);
						// REMPLISSAGE DE LA CMB ESPECE
						listeEspece = new ArrayList<String>();
						listeEspece = ctrl.getEspeces();
						if (listeEspece.isEmpty()) {
							selectEspeceCmb.setSelectedIndex(-1);
						} else {
							selectEspeceCmb.setModel(
									new DefaultComboBoxModel<String>(listeEspece.toArray(new String[listeEspece.size()])));
						}
						
						JLabel spaceAddRace3 = new JLabel("");
						GridBagConstraints gbc_spaceAddRace3 = new GridBagConstraints();
						gbc_spaceAddRace3.insets = new Insets(0, 0, 5, 5);
						gbc_spaceAddRace3.gridx = 2;
						gbc_spaceAddRace3.gridy = 2;
						ajouterRace.getContentPane().add(spaceAddRace3, gbc_spaceAddRace3);
						
						JTextField textField_1 = new JTextField();
						textField_1.setFont(new Font("Gisha", Font.PLAIN, 14));
						textField_1.setForeground(new Color(0, 51, 102));
						textField_1.setColumns(10);
						GridBagConstraints gbc_textField_1 = new GridBagConstraints();
						gbc_textField_1.insets = new Insets(0, 0, 5, 5);
						gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_1.gridx = 3;
						gbc_textField_1.gridy = 3;
						ajouterRace.getContentPane().add(textField_1, gbc_textField_1);
						
						JLabel spaceAddRace4 = new JLabel("");
						GridBagConstraints gbc_spaceAddRace4 = new GridBagConstraints();
						gbc_spaceAddRace4.insets = new Insets(0, 0, 5, 5);
						gbc_spaceAddRace4.gridx = 2;
						gbc_spaceAddRace4.gridy = 4;
						ajouterRace.getContentPane().add(spaceAddRace4, gbc_spaceAddRace4);
						
						JLabel warningLblEspece = new JLabel("Merci de renseigner tous les champs");
						warningLblEspece.setForeground(new Color(153, 51, 0));
						GridBagConstraints gbc_warningLblEspece = new GridBagConstraints();
						gbc_warningLblEspece.insets = new Insets(0, 0, 5, 5);
						gbc_warningLblEspece.gridx = 3;
						gbc_warningLblEspece.gridy = 4;
						ajouterRace.getContentPane().add(warningLblEspece, gbc_warningLblEspece);
						
						JButton annulerAddracebtn = new JButton("Annuler");
						annulerAddracebtn.setFont(new Font("Gisha", Font.PLAIN, 12));
						annulerAddracebtn.setBackground(new Color(255, 255, 255));
						annulerAddracebtn.setForeground(new Color(0, 51, 102));
						GridBagConstraints gbc_annulerAddracebtn = new GridBagConstraints();
						gbc_annulerAddracebtn.anchor = GridBagConstraints.WEST;
						gbc_annulerAddracebtn.insets = new Insets(0, 0, 0, 5);
						gbc_annulerAddracebtn.gridx = 1;
						gbc_annulerAddracebtn.gridy = 5;
						ajouterRace.getContentPane().add(annulerAddracebtn, gbc_annulerAddracebtn);

						JButton btnAjouter = new JButton("Ajouter");
						btnAjouter.setForeground(new Color(0, 51, 102));
						btnAjouter.setFont(new Font("Gisha", Font.PLAIN, 12));
						btnAjouter.setBackground(new Color(255, 255, 255));
						GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
						gbc_btnAjouter.anchor = GridBagConstraints.EAST;
						gbc_btnAjouter.insets = new Insets(0, 0, 0, 5);
						gbc_btnAjouter.gridx = 3;
						gbc_btnAjouter.gridy = 5;
						ajouterRace.getContentPane().add(btnAjouter, gbc_btnAjouter);
						
						annulerAddracebtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ajouterRace.setVisible(true);
							}
						});
						
						btnAjouter.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if(!textField_1.getText().isEmpty())
								{
									ctrl.ajouter(listeEspece.get(selectEspeceCmb.getSelectedIndex()),textField_1.getText());
									warningLblEspece.setVisible(false);
									ajouterRace.setVisible(false);
								}
								else
								{
									warningLblEspece.setVisible(true);
								}
							}
						});
						
						ajouterRace.setBounds(100, 100, 409, 266);
						ajouterRace.setResizable(false);
						ajouterRace.setLocationRelativeTo(null);
						ajouterRace.setVisible(true);
						warningLblEspece.setVisible(false);
					}
				});

				JLabel especeAnimalLbl = new JLabel("Esp\u00E8ce : ");
				especeAnimalLbl.setForeground(new Color(16, 40, 99));
				especeAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_especeAnimalLbl = new GridBagConstraints();
				gbc_especeAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_especeAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_especeAnimalLbl.gridx = 4;
				gbc_especeAnimalLbl.gridy = 5;
				panelAnimal.add(especeAnimalLbl, gbc_especeAnimalLbl);

				JComboBox<String> especeAnimalCmb = new JComboBox<String>();
				especeAnimalCmb.setForeground(new Color(16, 40, 99));
				especeAnimalCmb.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_especeAnimalCmb = new GridBagConstraints();
				gbc_especeAnimalCmb.insets = new Insets(0, 0, 5, 5);
				gbc_especeAnimalCmb.fill = GridBagConstraints.HORIZONTAL;
				gbc_especeAnimalCmb.gridx = 5;
				gbc_especeAnimalCmb.gridy = 5;
				panelAnimal.add(especeAnimalCmb, gbc_especeAnimalCmb);

				// REMPLISSAGE DE LA CMB ESPECE
				listeEspece = new ArrayList<String>();
				listeEspece = ctrl.getEspeces();
				String emptyEspece = "Pas d'espèces";
				if (listeEspece.isEmpty()) {
					especeAnimalCmb.setSelectedIndex(-1);
				} else {
					especeAnimalCmb.setModel(
							new DefaultComboBoxModel<String>(listeEspece.toArray(new String[listeEspece.size()])));
				}

				especeAnimalCmb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// REMPLISSAGE DE LA CMB RACE
						listeRace = new ArrayList<String>();
						if (especeAnimalCmb.getSelectedItem() != null) {
							listeRace = ctrl.getRaces(especeAnimalCmb.getSelectedItem().toString());
						} else {
							listeRace.add("");
						}
						String empty = "Pas de races";
						if (listeRace.isEmpty()) {
							especeAnimalCmb.setSelectedIndex(-1);
						} else {
							raceAnimalCmb.setModel(
									new DefaultComboBoxModel<String>(listeRace.toArray(new String[listeRace.size()])));
						}
					}
				});
				
				JButton addEspeceBtn = new JButton("");
				addEspeceBtn.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/plus16.png")));
				GridBagConstraints gbc_addEspeceBtn = new GridBagConstraints();
				gbc_addEspeceBtn.insets = new Insets(0, 0, 5, 0);
				gbc_addEspeceBtn.gridx = 6;
				gbc_addEspeceBtn.gridy = 5;
				panelAnimal.add(addEspeceBtn, gbc_addEspeceBtn);
				
				addEspeceBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ajouterEspece = new JFrame();
						ajouterEspece.setTitle("Ajouter une esp\u00E8ce");
						ajouterEspece.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/fr/eni/veto/IHM/ressources/ico_veto.png")));
						ajouterEspece.setBackground(Color.WHITE);
						ajouterEspece.getContentPane().setBackground(Color.WHITE);
						GridBagLayout gridBagLayout = new GridBagLayout();
						gridBagLayout.columnWidths = new int[]{20, 0, 29, 0, 26, 0};
						gridBagLayout.rowHeights = new int[]{46, 0, 0, 15, 21, 0, 0};
						gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
						gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
						ajouterEspece.getContentPane().setLayout(gridBagLayout);
						
						JLabel spaceAddRace = new JLabel("");
						GridBagConstraints gbc_spaceAddRace = new GridBagConstraints();
						gbc_spaceAddRace.insets = new Insets(0, 0, 5, 5);
						gbc_spaceAddRace.gridx = 0;
						gbc_spaceAddRace.gridy = 0;
						ajouterEspece.getContentPane().add(spaceAddRace, gbc_spaceAddRace);
						
						JLabel ajouterEspeceLbl = new JLabel("Ajouter une esp\u00E8ce :");
						ajouterEspeceLbl.setFont(new Font("Gisha", Font.BOLD, 16));
						ajouterEspeceLbl.setForeground(new Color(0, 51, 102));
						GridBagConstraints gbc_ajouterEspeceLbl = new GridBagConstraints();
						gbc_ajouterEspeceLbl.anchor = GridBagConstraints.EAST;
						gbc_ajouterEspeceLbl.insets = new Insets(0, 0, 5, 5);
						gbc_ajouterEspeceLbl.gridx = 1;
						gbc_ajouterEspeceLbl.gridy = 1;
						ajouterEspece.getContentPane().add(ajouterEspeceLbl, gbc_ajouterEspeceLbl);
						
						JTextField textField = new JTextField();
						textField.setFont(new Font("Gisha", Font.PLAIN, 14));
						textField.setForeground(new Color(0, 51, 102));
						GridBagConstraints gbc_textField = new GridBagConstraints();
						gbc_textField.insets = new Insets(0, 0, 5, 5);
						gbc_textField.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField.gridx = 3;
						gbc_textField.gridy = 1;
						ajouterEspece.getContentPane().add(textField, gbc_textField);
						textField.setColumns(10);
						
						JTextField textField_2 = new JTextField();
						textField_2.setForeground(new Color(0, 51, 102));
						textField_2.setFont(new Font("Gisha", Font.PLAIN, 14));
						textField_2.setColumns(10);
						GridBagConstraints gbc_textField_2 = new GridBagConstraints();
						gbc_textField_2.insets = new Insets(0, 0, 5, 5);
						gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_2.gridx = 3;
						gbc_textField_2.gridy = 2;
						ajouterEspece.getContentPane().add(textField_2, gbc_textField_2);
						
						JLabel spaceAddRace2 = new JLabel("");
						GridBagConstraints gbc_spaceAddRace2 = new GridBagConstraints();
						gbc_spaceAddRace2.insets = new Insets(0, 0, 5, 0);
						gbc_spaceAddRace2.gridx = 4;
						gbc_spaceAddRace2.gridy = 3;
						ajouterEspece.getContentPane().add(spaceAddRace2, gbc_spaceAddRace2);
						
						JLabel warningLblEspece = new JLabel("Merci de remplir tous les champs");
						warningLblEspece.setForeground(new Color(153, 51, 0));
						GridBagConstraints gbc_warningLblEspece = new GridBagConstraints();
						gbc_warningLblEspece.gridwidth = 4;
						gbc_warningLblEspece.insets = new Insets(0, 0, 5, 5);
						gbc_warningLblEspece.gridx = 1;
						gbc_warningLblEspece.gridy = 4;
						ajouterEspece.getContentPane().add(warningLblEspece, gbc_warningLblEspece);
						warningLblEspece.setVisible(false);
						
						JButton annulerAddracebtn = new JButton("Annuler");
						annulerAddracebtn.setFont(new Font("Gisha", Font.PLAIN, 12));
						annulerAddracebtn.setBackground(new Color(255, 255, 255));
						annulerAddracebtn.setForeground(new Color(0, 51, 102));
						GridBagConstraints gbc_annulerAddracebtn = new GridBagConstraints();
						gbc_annulerAddracebtn.anchor = GridBagConstraints.WEST;
						gbc_annulerAddracebtn.insets = new Insets(0, 0, 0, 5);
						gbc_annulerAddracebtn.gridx = 1;
						gbc_annulerAddracebtn.gridy = 5;
						ajouterEspece.getContentPane().add(annulerAddracebtn, gbc_annulerAddracebtn);
						
						JButton btnAjouter = new JButton("Ajouter");
						btnAjouter.setForeground(new Color(0, 51, 102));
						btnAjouter.setFont(new Font("Gisha", Font.PLAIN, 12));
						btnAjouter.setBackground(new Color(255, 255, 255));
						GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
						gbc_btnAjouter.anchor = GridBagConstraints.EAST;
						gbc_btnAjouter.insets = new Insets(0, 0, 0, 5);
						gbc_btnAjouter.gridx = 3;
						gbc_btnAjouter.gridy = 5;
						ajouterEspece.getContentPane().add(btnAjouter, gbc_btnAjouter);
						ajouterEspece.setBounds(100, 100, 409, 228);
						ajouterEspece.setResizable(false);
						ajouterEspece.setLocationRelativeTo(null);
						
						btnAjouter.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if(textField.getText().isEmpty()||textField_2.getText().isEmpty())
								{
									warningLblEspece.setVisible(true);
								}
								else
								{
									ctrl.ajouter(textField.getText(),textField_2.getText());
									warningLblEspece.setVisible(false);
									ajouterEspece.setVisible(false);
								}
							}
						});
						
						annulerAddracebtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ajouterEspece.setVisible(false);
							}
						});
						
						ajouterEspece.setVisible(true);
					}
				});
				
				

				JLabel label_2 = new JLabel("");
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 1;
				gbc_label_2.gridy = 6;
				panelAnimal.add(label_2, gbc_label_2);

				JLabel tatouageAnimalLbl = new JLabel("Tatouage : ");
				tatouageAnimalLbl.setForeground(new Color(16, 40, 99));
				tatouageAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_tatouageAnimalLbl = new GridBagConstraints();
				gbc_tatouageAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_tatouageAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_tatouageAnimalLbl.gridx = 1;
				gbc_tatouageAnimalLbl.gridy = 7;
				panelAnimal.add(tatouageAnimalLbl, gbc_tatouageAnimalLbl);

				JTextField tatouageAnimalTxt;
				tatouageAnimalTxt = new JTextField();
				GridBagConstraints gbc_tatouageAnimalTxt = new GridBagConstraints();
				gbc_tatouageAnimalTxt.anchor = GridBagConstraints.NORTH;
				gbc_tatouageAnimalTxt.insets = new Insets(0, 0, 5, 5);
				gbc_tatouageAnimalTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_tatouageAnimalTxt.gridx = 2;
				gbc_tatouageAnimalTxt.gridy = 7;
				panelAnimal.add(tatouageAnimalTxt, gbc_tatouageAnimalTxt);
				tatouageAnimalTxt.setColumns(10);

				JLabel antecedantAnimalLbl = new JLabel("Antec\u00E9dants : ");
				antecedantAnimalLbl.setForeground(new Color(16, 40, 99));
				antecedantAnimalLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_antecedantAnimalLbl = new GridBagConstraints();
				gbc_antecedantAnimalLbl.anchor = GridBagConstraints.WEST;
				gbc_antecedantAnimalLbl.insets = new Insets(0, 0, 5, 5);
				gbc_antecedantAnimalLbl.gridx = 4;
				gbc_antecedantAnimalLbl.gridy = 7;
				panelAnimal.add(antecedantAnimalLbl, gbc_antecedantAnimalLbl);

				JTextField antecedantAnimalTxt;
				antecedantAnimalTxt = new JTextField();
				GridBagConstraints gbc_antecedantAnimalTxt = new GridBagConstraints();
				gbc_antecedantAnimalTxt.insets = new Insets(0, 0, 5, 5);
				gbc_antecedantAnimalTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_antecedantAnimalTxt.gridx = 5;
				gbc_antecedantAnimalTxt.gridy = 7;
				panelAnimal.add(antecedantAnimalTxt, gbc_antecedantAnimalTxt);
				antecedantAnimalTxt.setColumns(10);

				JLabel label_3 = new JLabel("");
				GridBagConstraints gbc_label_3 = new GridBagConstraints();
				gbc_label_3.insets = new Insets(0, 0, 5, 5);
				gbc_label_3.gridx = 1;
				gbc_label_3.gridy = 8;
				panelAnimal.add(label_3, gbc_label_3);

				JButton annulerAnimalBtn = new JButton("Annuler");
				annulerAnimalBtn.setBackground(new Color(255, 255, 255));
				annulerAnimalBtn.setFont(new Font("Gisha", Font.PLAIN, 12));
				annulerAnimalBtn.setForeground(new Color(16, 40, 99));
				GridBagConstraints gbc_annulerAnimalBtn = new GridBagConstraints();
				gbc_annulerAnimalBtn.insets = new Insets(0, 0, 0, 5);
				gbc_annulerAnimalBtn.gridx = 2;
				gbc_annulerAnimalBtn.gridy = 9;
				panelAnimal.add(annulerAnimalBtn, gbc_annulerAnimalBtn);

				JButton ajouterAnimalBtn = new JButton("Ajouter");
				ajouterAnimalBtn.setForeground(new Color(16, 40, 99));
				ajouterAnimalBtn.setFont(new Font("Gisha", Font.PLAIN, 12));
				ajouterAnimalBtn.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_ajouterAnimalBtn = new GridBagConstraints();
				gbc_ajouterAnimalBtn.insets = new Insets(0, 0, 0, 5);
				gbc_ajouterAnimalBtn.gridx = 5;
				gbc_ajouterAnimalBtn.gridy = 9;
				panelAnimal.add(ajouterAnimalBtn, gbc_ajouterAnimalBtn);
				ajouterAnimalBtn.setVisible(false);

				JButton validerAnimalBtn = new JButton("Valider");
				validerAnimalBtn.setForeground(new Color(16, 40, 99));
				validerAnimalBtn.setFont(new Font("Gisha", Font.PLAIN, 12));
				validerAnimalBtn.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_validerAnimalBtn = new GridBagConstraints();
				gbc_validerAnimalBtn.insets = new Insets(0, 0, 0, 5);
				gbc_validerAnimalBtn.gridx = 5;
				gbc_validerAnimalBtn.gridy = 9;
				panelAnimal.add(validerAnimalBtn, gbc_validerAnimalBtn);
				validerAnimalBtn.setVisible(false);

				JLabel spaceBoundinfo = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo = new GridBagConstraints();
				gbc_spaceBoundinfo.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo.gridx = 1;
				gbc_spaceBoundinfo.gridy = 4;
				panel.add(spaceBoundinfo, gbc_spaceBoundinfo);

				// retour aux infos clients
				JLabel adresseInfoLbl = new JLabel("Adresse 1 : ");
				adresseInfoLbl.setForeground(new Color(16, 40, 99));
				adresseInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresseInfoLbl = new GridBagConstraints();
				gbc_adresseInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_adresseInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresseInfoLbl.gridx = 1;
				gbc_adresseInfoLbl.gridy = 5;
				panel.add(adresseInfoLbl, gbc_adresseInfoLbl);

				JLabel Adresse1InfoTxt = new JLabel(listModelClient.get(indexClient).getAdresse1());
				Adresse1InfoTxt.setForeground(new Color(16, 40, 99));
				Adresse1InfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_Adresse1InfoTxt = new GridBagConstraints();
				gbc_Adresse1InfoTxt.anchor = GridBagConstraints.WEST;
				gbc_Adresse1InfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_Adresse1InfoTxt.gridx = 2;
				gbc_Adresse1InfoTxt.gridy = 5;
				panel.add(Adresse1InfoTxt, gbc_Adresse1InfoTxt);

				JLabel adresse2InfoLbl = new JLabel("Adresse 2 : ");
				adresse2InfoLbl.setForeground(new Color(16, 40, 99));
				adresse2InfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresse2InfoLbl = new GridBagConstraints();
				gbc_adresse2InfoLbl.anchor = GridBagConstraints.WEST;
				gbc_adresse2InfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresse2InfoLbl.gridx = 3;
				gbc_adresse2InfoLbl.gridy = 5;
				panel.add(adresse2InfoLbl, gbc_adresse2InfoLbl);

				JLabel adresse2InfoTxt = new JLabel(listModelClient.get(indexClient).getAdresse2());
				adresse2InfoTxt.setForeground(new Color(16, 40, 99));
				adresse2InfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresse2InfoTxt = new GridBagConstraints();
				gbc_adresse2InfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_adresse2InfoTxt.gridx = 4;
				gbc_adresse2InfoTxt.gridy = 5;
				gbc_adresse2InfoTxt.anchor = GridBagConstraints.WEST;
				panel.add(adresse2InfoTxt, gbc_adresse2InfoTxt);

				JLabel spaceBoundinfo2 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo2 = new GridBagConstraints();
				gbc_spaceBoundinfo2.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo2.gridx = 1;
				gbc_spaceBoundinfo2.gridy = 6;
				panel.add(spaceBoundinfo2, gbc_spaceBoundinfo2);

				JLabel codePostalInfoLbl = new JLabel("Code postal : ");
				codePostalInfoLbl.setForeground(new Color(16, 40, 99));
				codePostalInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_codePostalInfoLbl = new GridBagConstraints();
				gbc_codePostalInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_codePostalInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_codePostalInfoLbl.gridx = 1;
				gbc_codePostalInfoLbl.gridy = 7;
				panel.add(codePostalInfoLbl, gbc_codePostalInfoLbl);

				JLabel codePostalInfoTxt = new JLabel(listModelClient.get(indexClient).getCodePostal());
				codePostalInfoTxt.setForeground(new Color(16, 40, 99));
				codePostalInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_codePostalInfoTxt = new GridBagConstraints();
				gbc_codePostalInfoTxt.anchor = GridBagConstraints.WEST;
				gbc_codePostalInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_codePostalInfoTxt.gridx = 2;
				gbc_codePostalInfoTxt.gridy = 7;
				panel.add(codePostalInfoTxt, gbc_codePostalInfoTxt);

				JLabel villeInfoLbl = new JLabel("Ville : ");
				villeInfoLbl.setForeground(new Color(16, 40, 99));
				villeInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_villeInfoLbl = new GridBagConstraints();
				gbc_villeInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_villeInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_villeInfoLbl.gridx = 3;
				gbc_villeInfoLbl.gridy = 7;
				panel.add(villeInfoLbl, gbc_villeInfoLbl);

				JLabel villeInfoTxt = new JLabel(listModelClient.get(indexClient).getVille());
				villeInfoTxt.setForeground(new Color(16, 40, 99));
				villeInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_villeInfoTxt = new GridBagConstraints();
				gbc_villeInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_villeInfoTxt.gridx = 4;
				gbc_villeInfoTxt.gridy = 7;
				gbc_villeInfoTxt.anchor = GridBagConstraints.WEST;
				panel.add(villeInfoTxt, gbc_villeInfoTxt);

				JLabel spaceBoundinfo3 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo3 = new GridBagConstraints();
				gbc_spaceBoundinfo3.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo3.gridx = 1;
				gbc_spaceBoundinfo3.gridy = 8;
				panel.add(spaceBoundinfo3, gbc_spaceBoundinfo3);

				JLabel numTelInfoLbl = new JLabel("N\u00B0 Tel : ");
				numTelInfoLbl.setForeground(new Color(16, 40, 99));
				numTelInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_numTelInfoLbl = new GridBagConstraints();
				gbc_numTelInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_numTelInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_numTelInfoLbl.gridx = 1;
				gbc_numTelInfoLbl.gridy = 9;
				panel.add(numTelInfoLbl, gbc_numTelInfoLbl);

				JLabel telInfoTxt = new JLabel(listModelClient.get(indexClient).getNumTel());
				telInfoTxt.setForeground(new Color(16, 40, 99));
				telInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_telInfoTxt = new GridBagConstraints();
				gbc_telInfoTxt.anchor = GridBagConstraints.WEST;
				gbc_telInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_telInfoTxt.gridx = 2;
				gbc_telInfoTxt.gridy = 9;
				panel.add(telInfoTxt, gbc_telInfoTxt);

				JLabel emailInfoLbl = new JLabel("eMail : ");
				emailInfoLbl.setForeground(new Color(16, 40, 99));
				emailInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_emailInfoLbl = new GridBagConstraints();
				gbc_emailInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_emailInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_emailInfoLbl.gridx = 3;
				gbc_emailInfoLbl.gridy = 9;
				panel.add(emailInfoLbl, gbc_emailInfoLbl);

				JLabel mailInfoTxt = new JLabel(listModelClient.get(indexClient).getEmail());
				mailInfoTxt.setForeground(new Color(16, 40, 99));
				mailInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_mailInfoTxt = new GridBagConstraints();
				gbc_mailInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_mailInfoTxt.gridx = 4;
				gbc_mailInfoTxt.gridy = 9;
				gbc_mailInfoTxt.anchor = GridBagConstraints.WEST;
				panel.add(mailInfoTxt, gbc_mailInfoTxt);

				JLabel spaceBoundinfo4 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo4 = new GridBagConstraints();
				gbc_spaceBoundinfo4.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo4.gridx = 1;
				gbc_spaceBoundinfo4.gridy = 10;
				panel.add(spaceBoundinfo4, gbc_spaceBoundinfo4);

				JLabel assuranceInfoLbl = new JLabel("Assurance : ");
				assuranceInfoLbl.setForeground(new Color(16, 40, 99));
				assuranceInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_assuranceInfoLbl = new GridBagConstraints();
				gbc_assuranceInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_assuranceInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_assuranceInfoLbl.gridx = 1;
				gbc_assuranceInfoLbl.gridy = 11;
				panel.add(assuranceInfoLbl, gbc_assuranceInfoLbl);

				JLabel assuranceInfoTxt = new JLabel(listModelClient.get(indexClient).getAssurance());
				assuranceInfoTxt.setForeground(new Color(16, 40, 99));
				assuranceInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_assuranceInfoTxt = new GridBagConstraints();
				gbc_assuranceInfoTxt.anchor = GridBagConstraints.WEST;
				gbc_assuranceInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_assuranceInfoTxt.gridx = 2;
				gbc_assuranceInfoTxt.gridy = 11;
				panel.add(assuranceInfoTxt, gbc_assuranceInfoTxt);

				JLabel commentaireInfoLbl = new JLabel("Commentaire : ");
				commentaireInfoLbl.setForeground(new Color(16, 40, 99));
				commentaireInfoLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_commentaireInfoLbl = new GridBagConstraints();
				gbc_commentaireInfoLbl.anchor = GridBagConstraints.WEST;
				gbc_commentaireInfoLbl.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireInfoLbl.gridx = 3;
				gbc_commentaireInfoLbl.gridy = 11;
				panel.add(commentaireInfoLbl, gbc_commentaireInfoLbl);

				JLabel commentaireInfoTxt = new JLabel(listModelClient.get(indexClient).getRemarque());
				commentaireInfoTxt.setForeground(new Color(16, 40, 99));
				commentaireInfoTxt.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_commentaireInfoTxt = new GridBagConstraints();
				gbc_commentaireInfoTxt.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireInfoTxt.gridx = 4;
				gbc_commentaireInfoTxt.gridy = 11;
				gbc_commentaireInfoTxt.anchor = GridBagConstraints.WEST;
				panel.add(commentaireInfoTxt, gbc_commentaireInfoTxt);

				JLabel spaceBoundinfo8 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo8 = new GridBagConstraints();
				gbc_spaceBoundinfo8.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo8.gridx = 0;
				gbc_spaceBoundinfo8.gridy = 12;
				panel.add(spaceBoundinfo8, gbc_spaceBoundinfo8);

				JButton ajouterAnimalBtnInfo = new JButton("");
				ajouterAnimalBtnInfo.setIcon(new ImageIcon(MainView.class.getResource("ressources/plus16.png")));
				ajouterAnimalBtnInfo.setBackground(Color.WHITE);
				GridBagConstraints gbc_ajouterAnimalBtnInfo = new GridBagConstraints();
				gbc_ajouterAnimalBtnInfo.anchor = GridBagConstraints.WEST;
				gbc_ajouterAnimalBtnInfo.insets = new Insets(0, 0, 5, 5);
				gbc_ajouterAnimalBtnInfo.gridx = 3;
				gbc_ajouterAnimalBtnInfo.gridy = 13;
				panel.add(ajouterAnimalBtnInfo, gbc_ajouterAnimalBtnInfo);

				JLabel spaceBoundinfo5 = new JLabel("");
				GridBagConstraints gbc_spaceBoundinfo5 = new GridBagConstraints();
				gbc_spaceBoundinfo5.insets = new Insets(0, 0, 5, 5);
				gbc_spaceBoundinfo5.gridx = 1;
				gbc_spaceBoundinfo5.gridy = 14;
				panel.add(spaceBoundinfo5, gbc_spaceBoundinfo5);

				JComboBox<Animaux> animalCmb = new JComboBox<Animaux>();
				GridBagConstraints gbc_animalCmb = new GridBagConstraints();
				gbc_animalCmb.gridwidth = 2;
				gbc_animalCmb.insets = new Insets(0, 0, 5, 5);
				gbc_animalCmb.fill = GridBagConstraints.HORIZONTAL;
				gbc_animalCmb.gridx = 1;
				gbc_animalCmb.gridy = 13;

				ajouterAnimalBtnInfo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						numeroAnimalTxt.setText("");
						nomAnimalTxt.setText("");
						sexeAnimalCmb.setSelectedIndex(-1);
						couleurAnimalTxt.setText("");
						raceAnimalCmb.setSelectedIndex(-1);
						especeAnimalCmb.setSelectedIndex(-1);
						tatouageAnimalTxt.setText("");
						antecedantAnimalTxt.setText("");
						validerAnimalBtn.setVisible(false);
						ajouterAnimalBtn.setVisible(true);
					}
				});

				arrayListAnimaux = new ArrayList<Animaux>();
				arrayListAnimaux = ctrl.getAllAnimaux(listModelClient.get(indexClient).getCodeClient());
				String emptyAnimal = "Pas d'animal";
				if (arrayListAnimaux.isEmpty()) {
					animalCmb.setSelectedIndex(-1);
					ajouterAnimalBtn.setVisible(true);
				} else {
					DefaultComboBoxModel<Animaux> model = new DefaultComboBoxModel<Animaux>(
							arrayListAnimaux.toArray(new Animaux[arrayListAnimaux.size()]));
					animalCmb.setModel(model);
					numeroAnimalTxt.setText(Integer.toString(arrayListAnimaux.get(indexCmb).getCodeAnimal()));
					nomAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getNomAnimal());
					if (arrayListAnimaux.get(indexCmb).getSexe().equals("M")) {
						sexeAnimalCmb.setSelectedIndex(0);
					} else if (arrayListAnimaux.get(indexCmb).getSexe().equals("F")) {
						sexeAnimalCmb.setSelectedIndex(1);
					} else {
						sexeAnimalCmb.setSelectedIndex(2);
					}
					Animaux locAnimal = arrayListAnimaux.get(indexCmb);
					couleurAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getCouleur());
					especeAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getEspece());
					raceAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getRace());
					tatouageAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getTatouage());
					antecedantAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getAntecedant());
					validerAnimalBtn.setVisible(true);
					animalCmb.removeAll();
					arrayListAnimaux = ctrl.getAllAnimaux(listModelClient.get(indexClient).getCodeClient());
					animalCmb.setModel(new DefaultComboBoxModel(arrayListAnimaux.toArray()));
				}

				animalCmb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						indexCmb = animalCmb.getSelectedIndex();
						if (animalCmb.getSelectedIndex() == -1) {
							numeroAnimalTxt.setText("");
							nomAnimalTxt.setText("");
							sexeAnimalCmb.setSelectedIndex(-1);
							couleurAnimalTxt.setText("");
							especeAnimalCmb.setSelectedIndex(0);
							raceAnimalCmb.setSelectedIndex(0);
							tatouageAnimalTxt.setText("");
							antecedantAnimalTxt.setText("");
						} else {
							numeroAnimalTxt.setText(Integer.toString(arrayListAnimaux.get(indexCmb).getCodeAnimal()));
							nomAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getNomAnimal());
							sexeAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getSexe());
							couleurAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getCouleur());
							especeAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getEspece());
							raceAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getRace());
							tatouageAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getTatouage());
							antecedantAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getAntecedant());
						}
					}
				});

				panel.add(animalCmb, gbc_animalCmb);

				// BOUTTON ANNULER ANIMAL
				annulerAnimalBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (animalCmb.getSelectedIndex() == -1) {
							nomAnimalTxt.setText("");
							sexeAnimalCmb.setSelectedIndex(-1);
							couleurAnimalTxt.setText("");
							raceAnimalCmb.setSelectedIndex(-1);
							especeAnimalCmb.setSelectedIndex(-1);
							tatouageAnimalTxt.setText("");
							antecedantAnimalTxt.setText("");
						} else {
							numeroAnimalTxt.setText(Integer.toString(arrayListAnimaux.get(indexCmb).getCodeAnimal()));
							nomAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getNomAnimal());
							sexeAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getSexe());
							couleurAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getCouleur());
							especeAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getEspece());
							raceAnimalCmb.setSelectedItem(arrayListAnimaux.get(indexCmb).getRace());
							tatouageAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getTatouage());
							antecedantAnimalTxt.setText(arrayListAnimaux.get(indexCmb).getAntecedant());
							validerAnimalBtn.setVisible(true);
							ajouterAnimalBtn.setVisible(false);
						}
					}
				});

				// BOUTTON AJOUTER ANIMAL
				ajouterAnimalBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Animaux newAnimal = new Animaux(nomAnimalTxt.getText(), (String)sexeAnimalCmb.getSelectedItem(),
								couleurAnimalTxt.getText(), (String)raceAnimalCmb.getSelectedItem(), (String)especeAnimalCmb.getSelectedItem(),
								listModelClient.get(indexClient).getCodeClient(), tatouageAnimalTxt.getText(),
								antecedantAnimalTxt.getText(), false);
						try {
							ctrl.insertAnimal(newAnimal);
						} catch (DALException e1) {
							e1.printStackTrace();
						}
					}
				});

				// BOUTTON VALIDER ANIMAL
				validerAnimalBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Animaux dltAnimal = new Animaux(Integer.parseInt(numeroAnimalTxt.getText()),
								nomAnimalTxt.getText(), (String)sexeAnimalCmb.getSelectedItem(),
								couleurAnimalTxt.getText(), (String)raceAnimalCmb.getSelectedItem(), (String)especeAnimalCmb.getSelectedItem(),
								listModelClient.get(indexClient).getCodeClient(), tatouageAnimalTxt.getText(),
								antecedantAnimalTxt.getText(), false);
						try {
							ctrl.updateAnimal(dltAnimal);
						} catch (DALException e1) {
							e1.printStackTrace();
						}

					}
				});

				frmInformationsClient.setVisible(true);
			}

		});
		buttonPlus.setForeground(new Color(16, 40, 99));
		buttonPlus.setFont(new Font("Gisha", Font.PLAIN, 12));
		buttonPlus.setBackground(Color.WHITE);
		GridBagConstraints gbc_buttonPlus = new GridBagConstraints();
		gbc_buttonPlus.gridwidth = 4;
		gbc_buttonPlus.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPlus.gridx = 1;
		gbc_buttonPlus.gridy = 3;
		panel_1.add(buttonPlus, gbc_buttonPlus);

		JLabel label_10 = new JLabel("_________________________");
		label_10.setForeground(new Color(16, 40, 99));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.SOUTH;
		gbc_label_10.gridwidth = 4;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 5;
		panel_1.add(label_10, gbc_label_10);

		// BOUTTON ARCHIVER CLIENT
		JButton archiverClientBtn = new JButton("");
		archiverClientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frmArchiverClient = new JFrame();
				frmArchiverClient.setTitle("Archiver ?");
				frmArchiverClient.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
				frmArchiverClient.setBounds(200, 200, 350, 145);

				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				frmArchiverClient.getContentPane().add(panel, BorderLayout.CENTER);
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
				lblNewLabel.setForeground(new Color(16, 40, 99));
				lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 5;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);

				JButton validerModalBtn = new JButton("Oui");
				validerModalBtn.setForeground(new Color(16, 40, 99));
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
				btnNon.setForeground(new Color(16, 40, 99));
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

						frmArchiverClient.setVisible(false);
						ctrl.archivage(listModelClient.get(indexClient).getCodeClient());
						listModelClient.remove(liste.getSelectedIndex());
						int indexActualC = liste.getSelectedIndex();
						liste.setSelectedIndex(indexActualC + 1);
						indexPersonnel = liste.getSelectedIndex();
						
						if (listModelClient.isEmpty()) {
							buttonPlus.setEnabled(false);
							archiverClientBtn.setEnabled(false);
							
						} else {
							archiverClientBtn.setEnabled(true);
							buttonPlus.setEnabled(true);
						}
						
						arrayClientList = new ArrayList<Clients>();
						arrayClientList = ctrl.getAllClients();
						String emptyClient = "Pas de Clients";
						if (arrayClientList.isEmpty()) {
							clientsAgendaCmb.insertItemAt(emptyClient, 0);
							clientsAgendaCmb.setSelectedIndex(0);
						} else {
							clientsAgendaCmb.setModel(new DefaultComboBoxModel(arrayClientList.toArray()));
						}
					}
				});

				btnNon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frmArchiverClient.setVisible(false);
					}
				});

				frmArchiverClient.setVisible(true);
				frmArchiverClient.setLocationRelativeTo(null);
			}
		});
		archiverClientBtn.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/trash.png")));
		archiverClientBtn.setForeground(new Color(16, 40, 99));
		archiverClientBtn.setBackground(Color.WHITE);
		GridBagConstraints gbc_archiverClientBtn = new GridBagConstraints();
		gbc_archiverClientBtn.anchor = GridBagConstraints.WEST;
		gbc_archiverClientBtn.gridwidth = 3;
		gbc_archiverClientBtn.insets = new Insets(0, 0, 0, 5);
		gbc_archiverClientBtn.gridx = 1;
		gbc_archiverClientBtn.gridy = 7;
		panel_1.add(archiverClientBtn, gbc_archiverClientBtn);

		// AJOUTER CLIENT
		JButton addClientButton = new JButton("");
		addClientButton.addActionListener(new ActionListener() {
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
				gbl_panel.columnWidths = new int[] { 45, 46, 70, 85, 16, 43, 161, 0, 0 };
				gbl_panel.rowHeights = new int[] { 22, 0, 23, 0, 18, 19, 15, 0, 14, 0, 20, 0, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
						Double.MIN_VALUE };
				panel.setLayout(gbl_panel);

				JLabel lblAjouterClient = new JLabel("Ajouter un client");
				lblAjouterClient.setForeground(new Color(16, 40, 99));
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
				label.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/ajoutClient icon.jpg")));
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
				lblNomCAdd.setForeground(new Color(16, 40, 99));
				GridBagConstraints gbc_lblNomCAdd = new GridBagConstraints();
				gbc_lblNomCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_lblNomCAdd.anchor = GridBagConstraints.EAST;
				gbc_lblNomCAdd.gridx = 1;
				gbc_lblNomCAdd.gridy = 3;
				panel.add(lblNomCAdd, gbc_lblNomCAdd);

				JTextField nomTxtCAdd;
				nomTxtCAdd = new JTextField();
				nomTxtCAdd.setForeground(new Color(16, 40, 99));
				GridBagConstraints gbc_nomTxtCAdd = new GridBagConstraints();
				gbc_nomTxtCAdd.gridwidth = 2;
				gbc_nomTxtCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_nomTxtCAdd.fill = GridBagConstraints.HORIZONTAL;
				gbc_nomTxtCAdd.gridx = 2;
				gbc_nomTxtCAdd.gridy = 3;
				panel.add(nomTxtCAdd, gbc_nomTxtCAdd);
				nomTxtCAdd.setColumns(10);

				JLabel prenomClientLbl = new JLabel("Pr\u00E9nom :");
				prenomClientLbl.setForeground(new Color(16, 40, 99));
				prenomClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_prenomClientLbl = new GridBagConstraints();
				gbc_prenomClientLbl.anchor = GridBagConstraints.EAST;
				gbc_prenomClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_prenomClientLbl.gridx = 5;
				gbc_prenomClientLbl.gridy = 3;
				panel.add(prenomClientLbl, gbc_prenomClientLbl);

				JTextField prenomClientTxtAdd;
				prenomClientTxtAdd = new JTextField();
				prenomClientTxtAdd.setForeground(new Color(16, 40, 99));
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
				adresseClienLbl.setForeground(new Color(16, 40, 99));
				adresseClienLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresseClienLbl = new GridBagConstraints();
				gbc_adresseClienLbl.anchor = GridBagConstraints.EAST;
				gbc_adresseClienLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresseClienLbl.gridx = 1;
				gbc_adresseClienLbl.gridy = 5;
				panel.add(adresseClienLbl, gbc_adresseClienLbl);

				JTextField adresse1ClientTxt;
				adresse1ClientTxt = new JTextField();
				adresse1ClientTxt.setForeground(new Color(16, 40, 99));
				adresse1ClientTxt.setColumns(10);
				GridBagConstraints gbc_adresse1ClientLbl = new GridBagConstraints();
				gbc_adresse1ClientLbl.gridwidth = 2;
				gbc_adresse1ClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresse1ClientLbl.fill = GridBagConstraints.HORIZONTAL;
				gbc_adresse1ClientLbl.gridx = 2;
				gbc_adresse1ClientLbl.gridy = 5;
				panel.add(adresse1ClientTxt, gbc_adresse1ClientLbl);

				JLabel adresseClient2Lbl = new JLabel("Adresse 2 :");
				adresseClient2Lbl.setForeground(new Color(16, 40, 99));
				adresseClient2Lbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_adresseClient2Lbl = new GridBagConstraints();
				gbc_adresseClient2Lbl.anchor = GridBagConstraints.EAST;
				gbc_adresseClient2Lbl.insets = new Insets(0, 0, 5, 5);
				gbc_adresseClient2Lbl.gridx = 5;
				gbc_adresseClient2Lbl.gridy = 5;
				panel.add(adresseClient2Lbl, gbc_adresseClient2Lbl);

				JTextField adresseClient2Txt;
				adresseClient2Txt = new JTextField();
				adresseClient2Txt.setForeground(new Color(16, 40, 99));
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
				codePostalClientLbl.setForeground(new Color(16, 40, 99));
				codePostalClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_codePostalClientLbl = new GridBagConstraints();
				gbc_codePostalClientLbl.anchor = GridBagConstraints.EAST;
				gbc_codePostalClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_codePostalClientLbl.gridx = 1;
				gbc_codePostalClientLbl.gridy = 7;
				panel.add(codePostalClientLbl, gbc_codePostalClientLbl);

				JTextField codePostalTxtAdd;
				codePostalTxtAdd = new JTextField();
				codePostalTxtAdd.setForeground(new Color(16, 40, 99));
				codePostalTxtAdd.setColumns(10);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 2;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 7;
				panel.add(codePostalTxtAdd, gbc_textField_1);

				JLabel villeClientLabel = new JLabel("Ville :");
				villeClientLabel.setForeground(new Color(16, 40, 99));
				villeClientLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_villeClientLabel = new GridBagConstraints();
				gbc_villeClientLabel.anchor = GridBagConstraints.EAST;
				gbc_villeClientLabel.insets = new Insets(0, 0, 5, 5);
				gbc_villeClientLabel.gridx = 5;
				gbc_villeClientLabel.gridy = 7;
				panel.add(villeClientLabel, gbc_villeClientLabel);

				JTextField villeTxtAdd;
				villeTxtAdd = new JTextField();
				villeTxtAdd.setForeground(new Color(16, 40, 99));
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
				numTelLbl.setForeground(new Color(16, 40, 99));
				numTelLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_numTelLbl = new GridBagConstraints();
				gbc_numTelLbl.anchor = GridBagConstraints.EAST;
				gbc_numTelLbl.insets = new Insets(0, 0, 5, 5);
				gbc_numTelLbl.gridx = 1;
				gbc_numTelLbl.gridy = 9;
				panel.add(numTelLbl, gbc_numTelLbl);

				JTextField telTxt;
				telTxt = new JTextField();
				telTxt.setForeground(new Color(16, 40, 99));
				telTxt.setColumns(10);
				GridBagConstraints gbc_telTxt = new GridBagConstraints();
				gbc_telTxt.gridwidth = 2;
				gbc_telTxt.insets = new Insets(0, 0, 5, 5);
				gbc_telTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_telTxt.gridx = 2;
				gbc_telTxt.gridy = 9;
				panel.add(telTxt, gbc_telTxt);

				JLabel emailClientLbl = new JLabel("eMail :");
				emailClientLbl.setForeground(new Color(16, 40, 99));
				emailClientLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_emailClientLbl = new GridBagConstraints();
				gbc_emailClientLbl.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
				gbc_emailClientLbl.insets = new Insets(0, 0, 5, 5);
				gbc_emailClientLbl.gridx = 5;
				gbc_emailClientLbl.gridy = 9;
				panel.add(emailClientLbl, gbc_emailClientLbl);

				JTextField emailTxt;
				emailTxt = new JTextField();
				emailTxt.setForeground(new Color(16, 40, 99));
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
				commentaireLbl.setForeground(new Color(16, 40, 99));
				commentaireLbl.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_commentaireLbl = new GridBagConstraints();
				gbc_commentaireLbl.anchor = GridBagConstraints.EAST;
				gbc_commentaireLbl.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireLbl.gridx = 1;
				gbc_commentaireLbl.gridy = 11;
				panel.add(commentaireLbl, gbc_commentaireLbl);

				JTextField commentaireTxt;
				commentaireTxt = new JTextField();
				commentaireTxt.setForeground(new Color(16, 40, 99));
				commentaireTxt.setColumns(10);
				GridBagConstraints gbc_commentaireTxt = new GridBagConstraints();
				gbc_commentaireTxt.gridwidth = 2;
				gbc_commentaireTxt.insets = new Insets(0, 0, 5, 5);
				gbc_commentaireTxt.fill = GridBagConstraints.HORIZONTAL;
				gbc_commentaireTxt.gridx = 2;
				gbc_commentaireTxt.gridy = 11;
				panel.add(commentaireTxt, gbc_commentaireTxt);

				JButton btnAjouterCAdd = new JButton("Ajouter");
				btnAjouterCAdd.setForeground(new Color(16, 40, 99));
				btnAjouterCAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				btnAjouterCAdd.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_btnAjouterCAdd = new GridBagConstraints();
				gbc_btnAjouterCAdd.anchor = GridBagConstraints.EAST;
				gbc_btnAjouterCAdd.insets = new Insets(0, 0, 5, 5);
				gbc_btnAjouterCAdd.gridx = 6;
				gbc_btnAjouterCAdd.gridy = 11;
				panel.add(btnAjouterCAdd, gbc_btnAjouterCAdd);
				btnAjouterCAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						nouveau = new Clients(nomTxtCAdd.getText(), prenomClientTxtAdd.getText(),
								adresse1ClientTxt.getText(), adresseClient2Txt.getText(), codePostalTxtAdd.getText(),
								villeTxtAdd.getText(), telTxt.getText(), "no", emailTxt.getText(),
								commentaireTxt.getText(), false);
						ctrl.ajouterClient(nouveau);
						listModelClient.addElement(ctrl.getAllClients().get(listModelClient.getSize()));
						liste.setSelectedIndex(listModelClient.getSize());
						frmAjouterDuClient.setVisible(false);
						if (listModelClient.isEmpty()) {
							buttonPlus.setEnabled(false);
							archiverClientBtn.setEnabled(false);
							
						} else {
							archiverClientBtn.setEnabled(true);
							buttonPlus.setEnabled(true);
						}
						
						arrayClientList = new ArrayList<Clients>();
						arrayClientList = ctrl.getAllClients();
						String emptyClient = "Pas de Clients";
						if (arrayClientList.isEmpty()) {
							clientsAgendaCmb.insertItemAt(emptyClient, 0);
							clientsAgendaCmb.setSelectedIndex(0);
						} else {
							clientsAgendaCmb.setModel(new DefaultComboBoxModel(arrayClientList.toArray()));
						}
					}
				});
				frmAjouterDuClient.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
				frmAjouterDuClient.setTitle("Ajouter un client");
				frmAjouterDuClient.setBounds(100, 100, 605, 377);
				frmAjouterDuClient.setLocationRelativeTo(null);
				frmAjouterDuClient.setVisible(true);

			}
		});

		// FIN DE L'AJOUT D'UN CLIENT
		
		if (listModelClient.isEmpty()) {
			buttonPlus.setEnabled(false);
			archiverClientBtn.setEnabled(false);
			
		} else {
			archiverClientBtn.setEnabled(true);
			buttonPlus.setEnabled(true);
		}

		addClientButton.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/plus.png")));
		addClientButton.setForeground(new Color(16, 40, 99));
		addClientButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_addClientButton = new GridBagConstraints();
		gbc_addClientButton.anchor = GridBagConstraints.EAST;
		gbc_addClientButton.insets = new Insets(0, 0, 0, 5);
		gbc_addClientButton.gridx = 4;
		gbc_addClientButton.gridy = 7;
		panel_1.add(addClientButton, gbc_addClientButton);
		tabbedPane.setForegroundAt(2, new Color(16, 40, 99));
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));

		// FIN BOUTON AJOUTER CLIENT
		}

		/**
		 * PERSONNELS PANEL
		 */

		if (droitVisibility == "ADM") {
		JPanel panelPersonnels = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ressources/bannerv2.png")), 0,
						0, null);
				this.repaint();
			}
		};
		tabbedPane.addTab("Gestion du personnel  ",
				new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/veterinarian.png")),
				panelPersonnels, null);

		panelPersonnels.setBackground(new Color(204, 204, 204));
		GridBagLayout gbl_panelPersonnels = new GridBagLayout();
		gbl_panelPersonnels.columnWidths = new int[] { 26, 345, 30, 0, 0, 0 };
		gbl_panelPersonnels.rowHeights = new int[] { 22, 48, 36, 290, 7, 0 };
		gbl_panelPersonnels.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelPersonnels.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelPersonnels.setLayout(gbl_panelPersonnels);

		JLabel gestionPersonelleTitleLbl = new JLabel(" Gestion du personnel");
		gestionPersonelleTitleLbl
				.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/veterinarianWt.png")));
		gestionPersonelleTitleLbl.setForeground(Color.WHITE);
		gestionPersonelleTitleLbl.setFont(new Font("Gisha", Font.BOLD, 30));
		GridBagConstraints gbc_gestionPersonelleTitleLbl = new GridBagConstraints();
		gbc_gestionPersonelleTitleLbl.gridwidth = 3;
		gbc_gestionPersonelleTitleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_gestionPersonelleTitleLbl.gridx = 0;
		gbc_gestionPersonelleTitleLbl.gridy = 1;
		panelPersonnels.add(gestionPersonelleTitleLbl, gbc_gestionPersonelleTitleLbl);

		JLabel spaceBoundLbl = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl = new GridBagConstraints();
		gbc_spaceBoundLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl.gridx = 0;
		gbc_spaceBoundLbl.gridy = 2;
		panelPersonnels.add(spaceBoundLbl, gbc_spaceBoundLbl);

		JLabel spaceBoundLbl3 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl3 = new GridBagConstraints();
		gbc_spaceBoundLbl3.insets = new Insets(0, 0, 5, 5);
		gbc_spaceBoundLbl3.gridx = 2;
		gbc_spaceBoundLbl3.gridy = 2;
		panelPersonnels.add(spaceBoundLbl3, gbc_spaceBoundLbl3);

		// LISTE VIEW PERSONNELS

		DefaultListModel<Personnels> listModel = new DefaultListModel<Personnels>();
		JList list = new JList(listModel);
		list.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(16, 40, 99)));
		list.setFont(new Font("Levenim MT", Font.PLAIN, 14));
		list.setForeground(new Color(16, 40, 99));
		ArrayList<Personnels> listePersonnels = new ArrayList<Personnels>();
		listePersonnels = ctrl.getListPersonnel(0);
		for (Personnels personnels : listePersonnels) {
			listModel.addElement(personnels);
		}
		list.setLayoutOrientation(JList.VERTICAL);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 3;
		panelPersonnels.add(list, gbc_list);
		list.setSelectedIndex(0);

		JPanel idPanel = new JPanel();
		idPanel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_idPanel = new GridBagConstraints();
		gbc_idPanel.insets = new Insets(0, 0, 5, 5);
		gbc_idPanel.fill = GridBagConstraints.BOTH;
		gbc_idPanel.gridx = 3;
		gbc_idPanel.gridy = 3;
		panelPersonnels.add(idPanel, gbc_idPanel);
		GridBagLayout gbl_idPanel = new GridBagLayout();
		gbl_idPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_idPanel.rowHeights = new int[] { 28, 0, 16, 0, 17, 0, 25, 0, 23, 12, 14, 0, 0 };
		gbl_idPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_idPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
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
		identifiantLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_identifiantLbl = new GridBagConstraints();
		gbc_identifiantLbl.gridwidth = 2;
		gbc_identifiantLbl.anchor = GridBagConstraints.WEST;
		gbc_identifiantLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantLbl.gridx = 0;
		gbc_identifiantLbl.gridy = 1;
		idPanel.add(identifiantLbl, gbc_identifiantLbl);

		identifiantTxt = new JTextField();
		identifiantTxt.setForeground(new Color(16, 40, 99));
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
		nomLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_nomLbl = new GridBagConstraints();
		gbc_nomLbl.gridwidth = 2;
		gbc_nomLbl.insets = new Insets(0, 0, 5, 5);
		gbc_nomLbl.anchor = GridBagConstraints.WEST;
		gbc_nomLbl.gridx = 0;
		gbc_nomLbl.gridy = 3;
		idPanel.add(nomLbl, gbc_nomLbl);

		nomTxt = new JTextField();
		nomTxt.setForeground(new Color(16, 40, 99));
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
		roleLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_roleLbl = new GridBagConstraints();
		gbc_roleLbl.gridwidth = 2;
		gbc_roleLbl.insets = new Insets(0, 0, 5, 5);
		gbc_roleLbl.anchor = GridBagConstraints.WEST;
		gbc_roleLbl.gridx = 0;
		gbc_roleLbl.gridy = 5;
		idPanel.add(roleLbl, gbc_roleLbl);

		JRadioButton rdbtnSec = new JRadioButton("SEC");
		rdbtnSec.setBackground(new Color(255, 255, 255));
		rdbtnSec.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_rdbtnSec = new GridBagConstraints();
		gbc_rdbtnSec.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSec.gridx = 2;
		gbc_rdbtnSec.gridy = 5;
		idPanel.add(rdbtnSec, gbc_rdbtnSec);

		JRadioButton rdbtnVet = new JRadioButton("VET");
		rdbtnVet.setBackground(new Color(255, 255, 255));
		rdbtnVet.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_rdbtnVet = new GridBagConstraints();
		gbc_rdbtnVet.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVet.gridx = 3;
		gbc_rdbtnVet.gridy = 5;
		idPanel.add(rdbtnVet, gbc_rdbtnVet);

		JRadioButton rdbtnAdm = new JRadioButton("ADM");
		rdbtnAdm.setBackground(new Color(255, 255, 255));
		rdbtnAdm.setForeground(new Color(16, 40, 99));
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
		btnAnnuler.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.anchor = GridBagConstraints.WEST;
		gbc_btnAnnuler.gridwidth = 2;
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 7;
		idPanel.add(btnAnnuler, gbc_btnAnnuler);

		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(255, 255, 255));
		btnValider.setForeground(new Color(16, 40, 99));
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

		// BOUTTON ARCHIVER PERSONNEL

		JButton btnArchiver = new JButton("");
		btnArchiver.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/trash.png")));
		btnArchiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmArchiverPersonnel = new JFrame();
				frmArchiverPersonnel.setTitle("Archiver ?");
				frmArchiverPersonnel.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
				frmArchiverPersonnel.setBounds(200, 200, 350, 145);

				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				frmArchiverPersonnel.getContentPane().add(panel, BorderLayout.CENTER);
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
				lblNewLabel.setForeground(new Color(16, 40, 99));
				lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridwidth = 5;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel.gridx = 0;
				gbc_lblNewLabel.gridy = 1;
				panel.add(lblNewLabel, gbc_lblNewLabel);

				JButton validerModalBtn = new JButton("Oui");
				validerModalBtn.setForeground(new Color(16, 40, 99));
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
				btnNon.setForeground(new Color(16, 40, 99));
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

						frmArchiverPersonnel.setVisible(false);
						ctrl.archive(listModel.get(indexPersonnel).getCodePers());
						listModel.remove(list.getSelectedIndex());
						int indexActual = list.getSelectedIndex();
						list.setSelectedIndex(indexActual + 1);
						indexPersonnel = list.getSelectedIndex();
						identifiantTxt.setText(Integer.toString(listModel.get(indexPersonnel).getCodePers()));
						nomTxt.setText(listModel.get(indexPersonnel).getNom());
						
						arrayVetoList = new ArrayList<Personnels>();
						arrayVetoList = ctrl.getListPersonnel(1);
						String emptyVeto = "Pas de vétérinaire";
						if (arrayVetoList.isEmpty()) {
							veterinaireAgendaCmb.insertItemAt(emptyVeto, 0);
							veterinaireAgendaCmb.setSelectedIndex(0);
						} else {
							veterinaireAgendaCmb.setModel(new DefaultComboBoxModel(arrayVetoList.toArray()));
						}
						if (droitVisibility == "VET") {
							veterinaireAgendaCmb.setSelectedIndex(codePersonnel - 1);
						}
					}
				});

				btnNon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frmArchiverPersonnel.setVisible(false);
					}
				});

				frmArchiverPersonnel.setVisible(true);
				frmArchiverPersonnel.setLocationRelativeTo(null);
			}
		});

		JLabel traitLbl = new JLabel("_________________________");
		traitLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		traitLbl.setForeground(new Color(16, 40, 99));
		GridBagConstraints gbc_traitLbl = new GridBagConstraints();
		gbc_traitLbl.anchor = GridBagConstraints.SOUTH;
		gbc_traitLbl.gridwidth = 4;
		gbc_traitLbl.insets = new Insets(0, 0, 5, 5);
		gbc_traitLbl.gridx = 1;
		gbc_traitLbl.gridy = 8;
		idPanel.add(traitLbl, gbc_traitLbl);
		btnArchiver.setForeground(new Color(16, 40, 99));
		btnArchiver.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnArchiver = new GridBagConstraints();
		gbc_btnArchiver.gridwidth = 2;
		gbc_btnArchiver.anchor = GridBagConstraints.WEST;
		gbc_btnArchiver.insets = new Insets(0, 0, 0, 5);
		gbc_btnArchiver.gridx = 1;
		gbc_btnArchiver.gridy = 10;
		idPanel.add(btnArchiver, gbc_btnArchiver);

		indexPersonnel = list.getSelectedIndex();
		identifiantTxt.setText(Integer.toString(listModel.get(indexPersonnel).getCodePers()));
		nomTxt.setText(listModel.get(indexPersonnel).getNom());
		switch (listModel.get(indexPersonnel).getRole()) {
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

		// BOUTTON AJOUTER PERSONNEL

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
				lblAjouterDuPersonnel.setForeground(new Color(16, 40, 99));
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
				label.setIcon(new ImageIcon("/ressources/medic image.png"));
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
				lblNomAdd.setForeground(new Color(16, 40, 99));
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
				roleLblAdd.setForeground(new Color(16, 40, 99));
				roleLblAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				GridBagConstraints gbc_roleLblAdd = new GridBagConstraints();
				gbc_roleLblAdd.anchor = GridBagConstraints.EAST;
				gbc_roleLblAdd.insets = new Insets(0, 0, 5, 5);
				gbc_roleLblAdd.gridx = 1;
				gbc_roleLblAdd.gridy = 5;
				panel.add(roleLblAdd, gbc_roleLblAdd);

				JRadioButton rdbtnSecAdd = new JRadioButton("SEC");
				rdbtnSecAdd.setBackground(new Color(255, 255, 255));
				rdbtnSecAdd.setForeground(new Color(16, 40, 99));
				GridBagConstraints gbc_rdbtnSecAdd = new GridBagConstraints();
				gbc_rdbtnSecAdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnSecAdd.gridx = 2;
				gbc_rdbtnSecAdd.gridy = 5;
				panel.add(rdbtnSecAdd, gbc_rdbtnSecAdd);

				JRadioButton rdbtnVetAdd = new JRadioButton("VET");
				rdbtnVetAdd.setForeground(new Color(16, 40, 99));
				rdbtnVetAdd.setBackground(Color.WHITE);
				GridBagConstraints gbc_rdbtnVetAdd = new GridBagConstraints();
				gbc_rdbtnVetAdd.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnVetAdd.gridx = 3;
				gbc_rdbtnVetAdd.gridy = 5;
				panel.add(rdbtnVetAdd, gbc_rdbtnVetAdd);

				JRadioButton rdbtnAdmAdd = new JRadioButton("ADM");
				rdbtnAdmAdd.setForeground(new Color(16, 40, 99));
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
						listModel.addElement(ctrl.getListPersonnel(0).get(listModel.getSize()));
						list.setSelectedIndex(listModel.getSize());
						frmAjouterDuPersonnel.setVisible(false);
						
						arrayClientList = new ArrayList<Clients>();
						arrayClientList = ctrl.getAllClients();
						String emptyClient = "Pas de Clients";
						if (arrayClientList.isEmpty()) {
							clientsAgendaCmb.insertItemAt(emptyClient, 0);
							clientsAgendaCmb.setSelectedIndex(0);
						} else {
							clientsAgendaCmb.setModel(new DefaultComboBoxModel(arrayClientList.toArray()));
						}
					}
				});
				btnAjouterAdd.setForeground(new Color(16, 40, 99));
				btnAjouterAdd.setFont(new Font("Gisha", Font.PLAIN, 12));
				btnAjouterAdd.setBackground(new Color(255, 255, 255));
				GridBagConstraints gbc_btnAjouterAdd = new GridBagConstraints();
				gbc_btnAjouterAdd.gridwidth = 2;
				gbc_btnAjouterAdd.anchor = GridBagConstraints.WEST;
				gbc_btnAjouterAdd.insets = new Insets(0, 0, 0, 5);
				gbc_btnAjouterAdd.gridx = 3;
				gbc_btnAjouterAdd.gridy = 7;
				panel.add(btnAjouterAdd, gbc_btnAjouterAdd);
				frmAjouterDuPersonnel.setIconImage(Toolkit.getDefaultToolkit().getImage("/ressources/ico_veto.png"));
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
		addButon.setIcon(new ImageIcon(MainView.class.getResource("/fr/eni/veto/IHM/ressources/plus.png")));
		addButon.setForeground(new Color(16, 40, 99));
		addButon.setBackground(Color.WHITE);
		GridBagConstraints gbc_addButon = new GridBagConstraints();
		gbc_addButon.anchor = GridBagConstraints.EAST;
		gbc_addButon.insets = new Insets(0, 0, 0, 5);
		gbc_addButon.gridx = 4;
		gbc_addButon.gridy = 10;
		idPanel.add(addButon, gbc_addButon);

		JLabel spaceBoundLbl2 = new JLabel("");
		GridBagConstraints gbc_spaceBoundLbl2 = new GridBagConstraints();
		gbc_spaceBoundLbl2.insets = new Insets(0, 0, 0, 5);
		gbc_spaceBoundLbl2.gridx = 0;
		gbc_spaceBoundLbl2.gridy = 4;
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
					indexPersonnel = list.getSelectedIndex();
					identifiantTxt.setText(Integer.toString(listModel.get(indexPersonnel).getCodePers()));
					nomTxt.setText(listModel.get(indexPersonnel).getNom());
					switch (listModel.get(indexPersonnel).getRole()) {
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
					listModel.get(indexPersonnel).getRole();
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
				listModel.get(indexPersonnel).setNom(nomTxt.getText());
				if (rdbtnAdm.isSelected()) {
					newCode = "ADM";
				} else if (rdbtnSec.isSelected()) {
					newCode = "SEC";
				} else if (rdbtnVet.isSelected()) {
					newCode = "VET";
				}
				listModel.get(indexPersonnel).setRole(newCode);

				ctrl.update(listModel.get(indexPersonnel).getNom(), listModel.get(indexPersonnel).getRole(),
						listModel.get(indexPersonnel).getCodePers());
			}
		});

		// BOUTON ANNULER
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				indexPersonnel = list.getSelectedIndex();
				identifiantTxt.setText(Integer.toString(listModel.get(indexPersonnel).getCodePers()));
				nomTxt.setText(listModel.get(indexPersonnel).getNom());
				switch (listModel.get(indexPersonnel).getRole()) {
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
				listModel.get(indexPersonnel).getRole();
			}
		});
		idPanel.setOpaque(false);
		}

		// Gestion de l'heure

		new Thread() {

			@Override
			public void run() {
				while (true) {
					dateJour = new Date(System.currentTimeMillis());
					heureGestion.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dateJour));
				}
			}
		}.start();
		
		menuBar.add(Box.createGlue());
		menuBar.add(heureGestion);

		// VISIBILITY DES ONGLETS

		frmGestion.setBounds(100, 100, 700, 500);
		frmGestion.setLocationRelativeTo(null);
		frmGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestion.setResizable(false);
		frmGestion.setJMenuBar(menuBar);
		frmGestion.setVisible(true);
	}
}
