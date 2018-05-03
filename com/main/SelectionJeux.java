package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;
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
	
	/*
	 * Constructeur
	 */
	//
	
	/*
	 * M�thode
	 */
	// M�thode pour choissir le jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	static void ChoixJeux() {
		// D�claration des variables
		int choix = 0;
		
		//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
		// Switch pour le choix du jeux
		// Cr�ation d'un Scanner pour r�cup�rer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		// Test
		try
		{
			do
			{
				//Affichage du choix � chaque boucle
				System.out.println("Choisis le jeux");
				System.out.println("\t1 - Recherche +/-");
				System.out.println("\t2 - Mastermind");
				
				// R�cup�ration du choix
				choix = clavier.nextInt();

				switch(choix)
				{
				case 1 :
					// On appelle ?
					clavier.close();
					break;
				case 2 :
					// On appelle ?
					clavier.close();
					break;
				default :
					System.out.println("Choisis une nombre valide, y a pas de jeux cach�");
					break;
				}

			}while(choix != 1 && choix != 2);
			
			// Affichage de la sortie du programme
			System.out.println();
			System.out.println("J'esp�re que le jeux t'as amus�.");
		}
		
		// Exeception
		catch(InputMismatchException e)
		{
			System.out.println("catch");
			clavier.close();
			// Affichage de l'erreur
		}
	}
}
