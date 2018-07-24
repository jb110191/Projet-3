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
			do
			{
				//Affichage du choix � chaque boucle
				System.out.println("Choisis le jeux");
				System.out.println("\t1 - Recherche +/-");
				System.out.println("\t2 - Mastermind");

				// R�cup�ration du choix
				choix = monAbc.entree();

				if(choix != 1 && choix != 2)
				{
					System.out.println("Choisis une nombre valide, y a pas de jeux cach�");
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
			rejouer = monAbc.demandeAutreJeux();
		}while(rejouer != false);

		// Affichage de la sortie du programme
		System.out.println();
		System.out.println("J'esp�re que le jeux t'as amus�.");
	}
}

