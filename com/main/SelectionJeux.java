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
	 * Méthode
	 */
	// Méthode pour choissir le jeux grace à un switch qui appelle la méthode mode de jeu pour séléctionner le mode qui appellera le jeux en lui même
	static void ChoixJeux() {
		// Déclaration des variables
		int choix = 0;
		
		//Boucle de do ... while, car elle doit s'éxécuté au moins un fois
		// Switch pour le choix du jeux
		// Création d'un Scanner pour récupérer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		// Test
		try
		{
			do
			{
				//Affichage du choix à chaque boucle
				System.out.println("Choisis le jeux");
				System.out.println("\t1 - Recherche +/-");
				System.out.println("\t2 - Mastermind");
				
				// Récupération du choix
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
					System.out.println("Choisis une nombre valide, y a pas de jeux caché");
					break;
				}

			}while(choix != 1 && choix != 2);
			
			// Affichage de la sortie du programme
			System.out.println();
			System.out.println("J'espère que le jeux t'as amusé.");
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
