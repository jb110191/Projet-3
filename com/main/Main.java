package com.main;

import com.jeux.RecherchePlusMoins;

public class Main {
	public static void main(String[] args) {
		// On appelle la méthode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		//SelectionJeux.ChoixJeux();
		
		/*
		 * Test
		 */
		RecherchePlusMoins xyz = new RecherchePlusMoins();
		
		//xyz.Challenger();
		
		xyz.Defenseur();
		
		// affiche quand le progamme se finit
		System.out.println();
		System.out.println();
		System.out.println("fin du progamme");
	}
}
