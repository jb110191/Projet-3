package com.main;

import com.jeux.Jeux;
import com.jeux.Mastermind;
import com.jeux.RecherchePlusMoins;
import com.outils.EntreeUtilisateur;

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
	static EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur ();

	/*
	 * Constructeur
	 */

	/*
	 * M�thode
	 */
	// M�thode pour choissir le jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixJeux() {
		// D�claration des variables
		int choix = 0;
		Boolean rejouer = false;

		Jeux monJeux;

		//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
		// Switch pour le choix du jeux

		// On cr�e une instance de SelectionModes
		SelectionModes slctMd = new SelectionModes();

		do
		{
			//Affichage du choix � chaque boucle
			System.out.println("Choisis le jeux");
			System.out.println("\t1 - Recherche +/-");
			System.out.println("\t2 - Mastermind");

			do
			{
				// R�cup�ration du choix
				choix = instanceEntreeUtilisateur.lisEntree(1, 2);

				if(choix != 1 && choix != 2)
				{
					System.out.println("Veuillez entrer une valeur valide");
				}
			}while(choix != 1 && choix != 2);

			// On cr�er un instance de RecherchePlusMoins ou de Mastermind
			if(choix == 1)
			{
				monJeux = new RecherchePlusMoins();
			}
			else
			{
				monJeux = new Mastermind();
			}

			// On appelle la m�thode choixJeux
			slctMd.choixModes(monJeux);
			rejouer = instanceEntreeUtilisateur.demandeAutreJeux();
		}while(rejouer != false);

		// Affichage de la sortie du programme
		System.out.println();
		System.out.println("J'esp�re que le jeux t'as amus�.");
	}
}

