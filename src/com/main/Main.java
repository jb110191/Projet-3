package com.main;

import com.logoutil.LogOutil;
import com.outils.ProprieteApplication;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le d�but du programme
		LogOutil.LOGGER.trace("D�but du programme");

		//On r�cup�re les propri�t�s

		ProprieteApplication mesPropriete = new ProprieteApplication();
		/*
		System.out.println(mesPropriete.tailleCombinaison);
		 */

		// On cr�e une instance de SelectionJeux
		SelectionJeux slctJx = new SelectionJeux();

		// On appelle la m�thode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		slctJx.choixJeux();

		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
