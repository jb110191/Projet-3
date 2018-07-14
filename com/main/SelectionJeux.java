package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.logoutil.*;
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
	void choixJeux() {
		// Déclaration des variables
		int choix = 0;
		
		//Boucle de do ... while, car elle doit s'éxécuté au moins un fois
		// Switch pour le choix du jeux
		// Création d'un Scanner pour récupérer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		// On crée une instance de SelectionModes
		SelectionModes slctMd = new SelectionModes();
		
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

				if(choix != 1 && choix != 2)
				{
					System.out.println("Choisis une nombre valide, y a pas de jeux caché");
				}

			}while(choix != 1 && choix != 2);
			
			// On appelle la méthode choixJeux
			slctMd.choixModes(choix);
			
			// Affichage de la sortie du programme
			System.out.println();
			System.out.println("J'espère que le jeux t'as amusé.");
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
