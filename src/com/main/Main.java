package com.main;

import com.logoutil.LogOutil;
import com.outils.ProprieteApplication;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le début du programme
		LogOutil.LOGGER.trace("Début du programme");

		// Affichage de l'entrée du programme
		System.out.println("Bienvenue l'application Recherche +/- ou Mastermind");
		System.out.println();

		//On récupère les propriétés
		ProprieteApplication mesPropriete = new ProprieteApplication();
		/*
		System.out.println(mesPropriete.tailleCombinaison);
		 */

		// On crée une instance de SelectionJeux
		SelectionJeux slctJx = new SelectionJeux();

		// On appelle la méthode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		slctJx.choixJeux();

		// Affichage de la sortie du programme
		System.out.println();
		System.out.println("J'espère que le jeux t'as amusé.");

		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
