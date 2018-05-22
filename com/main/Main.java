package com.main;

import com.jeux.*;

public class Main {
	public static void main(String[] args) {
		// On appelle la méthode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		//SelectionJeux.ChoixJeux();
		
		/*
		 * Test
		 */
		//RecherchePlusMoins xyz = new RecherchePlusMoins();
		
		//xyz.Challenger();
		
		//xyz.Defenseur();
		
		//xyz.Duel();
		
		Mastermind msm = new Mastermind();
		
		msm.Challenger();
		
		//msm.Defenseur();
		
		//msm.Duel();
		
		// affiche quand le progamme se finit
		System.out.println();
		System.out.println();
		System.out.println("fin du progamme");
	}
}
