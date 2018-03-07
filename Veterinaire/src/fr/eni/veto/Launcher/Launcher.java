package fr.eni.veto.Launcher;

import javax.swing.SwingUtilities;

import fr.eni.veto.CTRL.Controler;

public class Launcher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new Controler();
		});
	}
}
