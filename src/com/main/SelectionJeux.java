package com.main;

import com.jeux.Jeux;
import com.jeux.Mastermind;
import com.jeux.RecherchePlusMoins;
import com.outils.EntreeUtilisateur;
import com.outils.Rejouer;

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
	static EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur();
	static Rejouer instanceRejouer = new Rejouer();


	/*
	 * Constructeur
	 */

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
			//Affichage du choix à chaque boucle
			System.out.println("Choisis le jeux");
			System.out.println("\t1 - Recherche +/-");
			System.out.println("\t2 - Mastermind");

			do
			{
				// Récupération du choix
				choix = instanceEntreeUtilisateur.lisEntree(1, 2);

				if(choix != 1 && choix != 2)
				{
					System.out.println("Veuillez entrer une valeur valide");
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
		}while(instanceRejouer.getChoix() == 2);
	}
}

