package com.main;

import com.logoutil.LogOutil;
import com.outils.ProprieteApplication;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le d�but du programme
		LogOutil.LOGGER.trace("D�but du programme");

		// Affichage de l'entr�e du programme
		System.out.println("Bienvenue l'application Recherche +/- ou Mastermind");
		System.out.println();

		//On r�cup�re les propri�t�s
		ProprieteApplication mesPropriete = new ProprieteApplication();
		/*
		System.out.println(mesPropriete.tailleCombinaison);
		 */

		// On cr�e une instance de SelectionJeux
		SelectionJeux slctJx = new SelectionJeux();

		// On appelle la m�thode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		slctJx.choixJeux();

		// Affichage de la sortie du programme
		System.out.println();
		System.out.println("J'esp�re que le jeux t'as amus�.");

		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
