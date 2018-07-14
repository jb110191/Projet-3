package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.logoutil.*;

import com.jeux.*;

public class SelectionModes {
	/*
	 * Variable de classe
	 */
	//
	
	/*
	 * Constructeur
	 */
	//
	
	/*
	 * M�thode
	 */
	// M�thode pour choissir le mode de jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixModes(int jeux) {
		// D�claration des variables
		int choix = 0;
		
		//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
		// Switch pour le choix du jeux
		// Cr�ation d'un Scanner pour r�cup�rer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		// On cr�er un instance de RecherchePlusMoins et de Mastermind
		RecherchePlusMoins rpm = new RecherchePlusMoins();
		Mastermind mtm = new Mastermind();
		
		// Test
		try
		{
			do
			{
				//Affichage du choix � chaque boucle
				System.out.print("Choisis le mode pour ");
				if(jeux == 1)
				{
					System.out.println("le Recherche + ou -");
				}
				else if(jeux == 2)
				{
					System.out.println("le Mastermind");
				}
				System.out.println("\t1 - Challenger");
				System.out.println("\t2 - D�fenseur");
				System.out.println("\t3 - Duel");
				
				// R�cup�ration du choix
				choix = clavier.nextInt();

				switch(((jeux - 1) * 3) + choix)
				{
				case 1 :
					rpm.Challenger();
					break;
				case 2 :
					rpm.Defenseur();
					break;
				case 3 :
					rpm.Duel();
					break;
				case 4 :
					mtm.Challenger();
					break;
				case 5 :
					mtm.Defenseur();
					break;
				case 6 :
					mtm.Duel();
					break;
				default :
					System.out.println("Choisis une nombre valide, y a pas de mode de jeux cach�");
					break;
				}

			}while(choix != 1 && choix != 2 && choix != 3);
		}
		
		// Exeception
		catch(InputMismatchException e)
		{
			// Affichage de l'erreur
			LogOutil.LOGGER.trace(e.getStackTrace());
			clavier.close();
		}
	}
}
