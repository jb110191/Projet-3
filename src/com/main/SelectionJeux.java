package com.main;

import com.jeux.Jeux;
import com.jeux.mastermind.Mastermind;
import com.jeux.recherchePlusMoins.RecherchePlusMoins;
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
	 * M�thode
	 */
	// M�thode pour choissir le jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixJeux() {
		// D�claration des variables
		String texteChoix = "";
		int choix = 0;

		Jeux monJeux;

		//Boucle de do ... while, car elle doit s'�x�cut� au moins une fois
		// Switch pour le choix du jeux

		// On cr�e une instance de SelectionModes
		SelectionModes slctMd = new SelectionModes();

		//�criture du choix
		texteChoix += "Choisis le jeux\n";
		texteChoix += "\t1 - Recherche +/-\n";
		texteChoix += "\t2 - Mastermind\n";
		texteChoix += "\t\t";

		do
		{
			// Affichage du choix � chaque boucle
			System.out.print(texteChoix);
			do
			{	
				// R�cup�ration du choix
				choix = instanceEntreeUtilisateur.lisValeur(1, 2, texteChoix);
			}while(choix != 1 && choix != 2);
			System.out.println();

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
		}while(instanceRejouer.getChoix() == 2);
	}
}

