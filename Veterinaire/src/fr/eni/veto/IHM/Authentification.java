package fr.eni.veto.IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.veto.CTRL.Controler;

public class Authentification {

	private JFrame frmIdentification;
	private JTextField identifiantTxt;
	private JPasswordField passwordField;
	private JLabel errorIdLbl;

	private Controler ctrl;

	/**
	 * Create the application.
	 */
	public Authentification(Controler controler) {
		this.ctrl = controler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdentification = new JFrame();
		frmIdentification.setTitle("Identification");
		frmIdentification.getContentPane().setBackground(new Color(255, 255, 255));
		frmIdentification.setIconImage(Toolkit.getDefaultToolkit().getImage("src/ressources/ico_veto.png"));
		frmIdentification.setBounds(100, 100, 700, 300);
		frmIdentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("serial")
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				try {
					g.drawImage(ImageIO.read(new File("src/ressources/fond.jpg")), 0, 0, null);
				} catch (IOException e) {
				}
			}
		};
		frmIdentification.setContentPane(panel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 157, 117, 187, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 27, 56, 0, 0, 14, 0, 48, 59, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frmIdentification.getContentPane().setLayout(gridBagLayout);
		frmIdentification.setLocationRelativeTo(null);

		JLabel iconeImage = new JLabel("");
		iconeImage.setIcon(new ImageIcon("src/ressources/logo.jpg"));
		GridBagConstraints gbc_iconeImage = new GridBagConstraints();
		gbc_iconeImage.gridheight = 2;
		gbc_iconeImage.insets = new Insets(0, 0, 5, 5);
		gbc_iconeImage.gridx = 0;
		gbc_iconeImage.gridy = 1;
		frmIdentification.getContentPane().add(iconeImage, gbc_iconeImage);

		JLabel connectionLbl = new JLabel("Connection");
		connectionLbl.setForeground(new Color(0, 51, 153));
		connectionLbl.setFont(new Font("Gisha", Font.BOLD, 23));
		GridBagConstraints gbc_connectionLbl = new GridBagConstraints();
		gbc_connectionLbl.anchor = GridBagConstraints.SOUTH;
		gbc_connectionLbl.insets = new Insets(0, 0, 5, 5);
		gbc_connectionLbl.gridx = 2;
		gbc_connectionLbl.gridy = 1;
		frmIdentification.getContentPane().add(connectionLbl, gbc_connectionLbl);

		JLabel identificationLbl = new JLabel("Identifiant");
		identificationLbl.setForeground(new Color(0, 51, 153));
		identificationLbl.setFont(new Font("Gisha", Font.BOLD, 12));
		GridBagConstraints gbc_identificationLbl = new GridBagConstraints();
		gbc_identificationLbl.insets = new Insets(0, 0, 5, 5);
		gbc_identificationLbl.gridx = 1;
		gbc_identificationLbl.gridy = 3;
		frmIdentification.getContentPane().add(identificationLbl, gbc_identificationLbl);

		identifiantTxt = new JNumberTextField();
		GridBagConstraints gbc_identifiantTxt = new GridBagConstraints();
		gbc_identifiantTxt.insets = new Insets(0, 0, 5, 5);
		gbc_identifiantTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_identifiantTxt.gridx = 2;
		gbc_identifiantTxt.gridy = 3;
		frmIdentification.getContentPane().add(identifiantTxt, gbc_identifiantTxt);
		identifiantTxt.setColumns(10);
		
		JLabel spaceLbl = new JLabel("");
		GridBagConstraints gbc_spaceLbl = new GridBagConstraints();
		gbc_spaceLbl.insets = new Insets(0, 0, 5, 5);
		gbc_spaceLbl.gridx = 1;
		gbc_spaceLbl.gridy = 4;
		frmIdentification.getContentPane().add(spaceLbl, gbc_spaceLbl);

		JLabel passwordLbl = new JLabel("Mot de passe");
		passwordLbl.setForeground(new Color(0, 51, 153));
		passwordLbl.setFont(new Font("Gisha", Font.BOLD, 12));
		GridBagConstraints gbc_passwordLbl = new GridBagConstraints();
		gbc_passwordLbl.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLbl.gridx = 1;
		gbc_passwordLbl.gridy = 5;
		frmIdentification.getContentPane().add(passwordLbl, gbc_passwordLbl);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 5;
		frmIdentification.getContentPane().add(passwordField, gbc_passwordField);

		JButton validerBtn = new JButton("Valider");
		validerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (identifiantTxt.getText().equals("")) {
					errorIdLbl.setVisible(true);
				} else {
					switch (ctrl.validation(identifiantTxt.getText(), passwordField.getText())) {
					case "VET":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("VET", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "ADM":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("ADM", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "SEC":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("SEC", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "0":
						errorIdLbl.setVisible(true);
						break;

					default:
						break;
					}
					identifiantTxt.setText("");
					passwordField.setText("");
					errorIdLbl.setVisible(false);
				}
			}
		});

		passwordField.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (identifiantTxt.getText().equals("")) {
					errorIdLbl.setVisible(true);
				} else {
					switch (ctrl.validation(identifiantTxt.getText(), passwordField.getText())) {
					case "VET":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("VET", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "ADM":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("ADM", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "SEC":
						frmIdentification.setVisible(false);
						errorIdLbl.setVisible(false);
						ctrl.acces("SEC", Integer.parseInt(identifiantTxt.getText()));
						break;
					case "0":
						errorIdLbl.setVisible(true);
						break;

					default:
						break;
					}
					identifiantTxt.setText("");
					passwordField.setText("");
				}
			}
		});

		errorIdLbl = new JLabel("Identifiant et/ou mot de passe incorrect !");
		errorIdLbl.setForeground(new Color(220, 20, 60));
		GridBagConstraints gbc_errorIdLbl = new GridBagConstraints();
		gbc_errorIdLbl.anchor = GridBagConstraints.EAST;
		gbc_errorIdLbl.gridwidth = 2;
		gbc_errorIdLbl.insets = new Insets(0, 0, 5, 5);
		gbc_errorIdLbl.gridx = 1;
		gbc_errorIdLbl.gridy = 6;
		panel.add(errorIdLbl, gbc_errorIdLbl);
		errorIdLbl.setVisible(false);

		validerBtn.setBackground(new Color(255, 255, 255));
		validerBtn.setIcon(new ImageIcon("src/ressources/tick.png"));
		validerBtn.setForeground(new Color(0, 0, 0));
		validerBtn.setFont(new Font("Gisha", Font.BOLD, 11));
		GridBagConstraints gbc_validerBtn = new GridBagConstraints();
		gbc_validerBtn.anchor = GridBagConstraints.SOUTH;
		gbc_validerBtn.insets = new Insets(0, 0, 5, 0);
		gbc_validerBtn.gridx = 3;
		gbc_validerBtn.gridy = 6;
		frmIdentification.getContentPane().add(validerBtn, gbc_validerBtn);

		JButton btnTechnician = new JButton("Technicien");
		btnTechnician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctrl.acces("VET", 1);
			}
		});
		GridBagConstraints gbc_btnTechnician = new GridBagConstraints();
		gbc_btnTechnician.anchor = GridBagConstraints.NORTH;
		gbc_btnTechnician.gridx = 3;
		gbc_btnTechnician.gridy = 7;
		panel.add(btnTechnician, gbc_btnTechnician);
		btnTechnician.setVisible(false);

		frmIdentification.setVisible(true);
	}

	public JFrame getFrmIdentification() {
		return frmIdentification;
	}

	public void setFrmIdentification(JFrame frmIdentification) {
		this.frmIdentification = frmIdentification;
	}
	
	public class JNumberTextField extends JTextField {
	    private static final long serialVersionUID = 1L;

	    @Override
	    public void processKeyEvent(KeyEvent ev) {
	        if (Character.isDigit(ev.getKeyChar()) || ev.getKeyCode() == KeyEvent.VK_BACK_SPACE || ev.getKeyCode() == KeyEvent.VK_LEFT || ev.getKeyCode() == KeyEvent.VK_RIGHT) {
	            super.processKeyEvent(ev);
	        }
	        ev.consume();
	        return;
	    }

	    /**
	     * As the user is not even able to enter a dot ("."), only integers (whole numbers) may be entered.
	     */
	    public Long getNumber() {
	        Long result = null;
	        String text = getText();
	        if (text != null && !"".equals(text)) {
	            result = Long.valueOf(text);
	        }
	        return result;
	    }
	}
	
}
