package com.main;

import com.jeux.Jeux;
import com.outils.EntreeUtilisateur;

public class SelectionModes {
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
	// M�thode pour choissir le mode de jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixModes(Jeux pMonJeux) {
		// D�claration des variables
		int choix = 0;
		Boolean rejouer = false;

		//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
		// Switch pour le choix du jeux

		//Affichage du choix
		System.out.println("Choisis le mode");
		System.out.println("\t1 - Challenger");
		System.out.println("\t2 - D�fenseur");
		System.out.println("\t3 - Duel");

		do
		{
			// R�cup�ration du choix
			choix = instanceEntreeUtilisateur.lisEntree(1, 3);

			switch(choix)
			{
			case 1 :
				do
				{
					pMonJeux.Challenger();
					rejouer = instanceEntreeUtilisateur.demandeRejouer();
				}while(rejouer != false);
				break;
			case 2 :
				do
				{
					pMonJeux.Defenseur();
					rejouer = instanceEntreeUtilisateur.demandeRejouer();
				}while(rejouer != false);
				break;
			case 3 :
				do
				{
					pMonJeux.Duel();
					rejouer = instanceEntreeUtilisateur.demandeRejouer();
				}while(rejouer != false);
				break;
			default :
				System.out.println("Veuillez entrer une valeur valide");
				break;
			}
		}while(choix != 1 && choix != 2 && choix != 3);
	}
}
