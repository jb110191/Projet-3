package com.main;

import com.jeux.Jeux;
import com.outils.EntreeUtilisateur;
import com.outils.Rejouer;

public class SelectionModes {
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
	// M�thode pour choissir le mode de jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixModes(Jeux pMonJeux) {
		// D�claration des variables
		int choix = 0;

		do
		{
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
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				case 2 :
					do
					{
						pMonJeux.Defenseur();
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				case 3 :
					do
					{
						pMonJeux.Duel();
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				default :
					System.out.println("Veuillez entrer une valeur valide");
					break;
				}
			}while(choix != 1 && choix != 2 && choix != 3);
		}while(instanceRejouer.getChoix() == 1);
	}
}
