package com.main;

import com.logoutil.LogOutil;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le début du programme
		LogOutil.LOGGER.trace("Début du programme");
		
		// On crée une instance de SelectionJeux
		SelectionJeux slctJx = new SelectionJeux();
		
		// On appelle la méthode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		slctJx.choixJeux();
		
		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
