package com.main;

import com.jeux.Jeux;
import com.jeux.RecherchePlusMoins;
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
		String texteChoix = "";
		int choix = 0;

		//�criture du choix
		texteChoix += "Choisis le mode du ";
		if(pMonJeux.getClass() == RecherchePlusMoins.class)
		{
			texteChoix += "Recherche +/-";
		}
		else
		{
			texteChoix += "Mastermind";	
		}
		texteChoix += "\n";
		texteChoix += "\t1 - Challenger\n";
		texteChoix += "\t2 - D�fenseur\n";
		texteChoix += "\t3 - Duel\n";
		texteChoix += "\t\t";

		do
		{
			//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
			// Switch pour le choix du jeux
			//Affichage du choix
			System.out.print(texteChoix);
			do
			{
				// R�cup�ration du choix
				choix = instanceEntreeUtilisateur.lisValeur(1, 3, texteChoix);

				switch(choix)
				{
				case 1 :
					do
					{
						System.out.println();
						pMonJeux.Challenger();
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				case 2 :
					do
					{
						System.out.println();
						pMonJeux.Defenseur();
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				case 3 :
					do
					{
						System.out.println();
						pMonJeux.Duel();
						instanceRejouer.setChoix(instanceEntreeUtilisateur.demandeRejouer());
					}while(instanceRejouer.getChoix() == 0);
					break;
				default :
					System.out.println("Veuillez entrer une valeur valide");
					break;
				}
				System.out.println();
			}while(choix != 1 && choix != 2 && choix != 3);
		}while(instanceRejouer.getChoix() == 1);
	}
}
