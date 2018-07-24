package com.main;

import com.abc.Abc;
import com.jeux.Jeux;
import com.jeux.Mastermind;
import com.jeux.RecherchePlusMoins;

/**
 * 
 * @author Julian
 *
 */

public class SelectionJeux {
	/*
	 * Variable de classe
	 */
	//
	static Abc monAbc = new Abc();
	
	/*
	 * Constructeur
	 */
	//
	
	/*
	 * Méthode
	 */
	// Méthode pour choissir le jeux grace à un switch qui appelle la méthode mode de jeu pour séléctionner le mode qui appellera le jeux en lui même
	void choixJeux() {
		// Déclaration des variables
		int choix = 0;
		Boolean rejouer = false;
		
		Jeux monJeux;
		
		//Boucle de do ... while, car elle doit s'éxécuté au moins un fois
		// Switch pour le choix du jeux
		
		// On crée une instance de SelectionModes
		SelectionModes slctMd = new SelectionModes();
		
		do
		{
			do
			{
				//Affichage du choix à chaque boucle
				System.out.println("Choisis le jeux");
				System.out.println("\t1 - Recherche +/-");
				System.out.println("\t2 - Mastermind");

				// Récupération du choix
				choix = monAbc.entree();

				if(choix != 1 && choix != 2)
				{
					System.out.println("Choisis une nombre valide, y a pas de jeux caché");
				}
			}while(choix != 1 && choix != 2);

			// On créer un instance de RecherchePlusMoins ou de Mastermind
			if(choix == 1)
			{
				monJeux = new RecherchePlusMoins();
			}
			else
			{
				monJeux = new Mastermind();
			}

			// On appelle la méthode choixJeux
			slctMd.choixModes(monJeux);
			rejouer = monAbc.demandeAutreJeux();
		}while(rejouer != false);

		// Affichage de la sortie du programme
		System.out.println();
		System.out.println("J'espère que le jeux t'as amusé.");
	}
}

