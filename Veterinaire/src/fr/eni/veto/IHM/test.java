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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class test {

	private JFrame frmInformationsClient;
	private JTextField numeroAnimalTxt;
	private JTextField sexeAnimalTxt;
	private JTextField raceAnimalTxt;
	private JTextField tatouageAnimalTxt;
	private JTextField nomAnimalTxt;
	private JTextField couleurAnimalTxt;
	private JTextField especeAnimalTxt;
	private JTextField antecedantAnimalTxt;

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
		
	}

}
