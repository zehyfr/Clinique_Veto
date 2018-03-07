package fr.eni.veto.IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class test {

	private JFrame frmArchiver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmArchiver.setVisible(true);
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
		frmArchiver = new JFrame();
		frmArchiver.setTitle("Archiver ?");
		frmArchiver.setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/ressources/ico_veto.png")));
		frmArchiver.setBounds(100, 100, 350, 145);
		frmArchiver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmArchiver.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{135, 5, 0, 0};
		gbl_panel.rowHeights = new int[]{24, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel("Etes-vous s\u00FBr de vouloir archiver cette personne ?");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Gisha", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
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
	}

}
