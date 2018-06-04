package com.main;

import com.logoutil.LogOutil;

import com.jeux.RecherchePlusMoins;
import com.jeux.Mastermind;

public class Main {
	public static void main(String[] args) {
		// Log pour afficher le début du programme
		LogOutil.LOGGER.trace("Début du programme");
		
		// On appelle la méthode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		SelectionJeux.choixJeux();
		
		/*
		 * Test
		 */
		RecherchePlusMoins rpm = new RecherchePlusMoins();
		
		//rpm.Challenger();
		
		//rpm.Defenseur();
		
		//rpm.Duel();
		
		Mastermind msm = new Mastermind();
		
		//msm.Challenger();
		
		//msm.Defenseur();
		
		//msm.Duel();
		
		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
