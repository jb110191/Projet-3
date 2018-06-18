package com.main;

import com.logoutil.LogOutil;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le d�but du programme
		LogOutil.LOGGER.trace("D�but du programme");
		
		// On appelle la m�thode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		//SelectionJeux.choixJeux();
		
		/*
		 * Test
		 */
		
		//com.jeux.RecherchePlusMoins.Challenger();
		
		//com.jeux.RecherchePlusMoins.Defenseur();
		
		//com.jeux.RecherchePlusMoins.Duel();
		
		//com.jeux.Mastermind.Challenger();
		
		com.jeux.Mastermind.Defenseur();
		
		//com.jeux.Mastermind.Duel();
		
		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
