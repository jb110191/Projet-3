package com.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.logoutil.*;
import com.abc.Abc;
import com.jeux.*;

public class SelectionModes {
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
	 * Méthode
	 */
	// Méthode pour choissir le mode de jeux grace à un switch qui appelle la méthode mode de jeu pour séléctionner le mode qui appellera le jeux en lui même
	void choixModes(Jeux pMonJeux) {
		// Déclaration des variables
		int choix = 0;
		Boolean rejouer = false;
		
		//Boucle de do ... while, car elle doit s'éxécuté au moins un fois
		// Switch pour le choix du jeux
		// Création d'un Scanner pour récupérer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		do
		{
			//Affichage du choix à chaque boucle
			System.out.println("Choisis le mode");
			System.out.println("\t1 - Challenger");
			System.out.println("\t2 - Défenseur");
			System.out.println("\t3 - Duel");

			// Récupération du choix
			choix = monAbc.entree();

			switch(choix)
			{
			case 1 :
				do
				{
					pMonJeux.Challenger();
					rejouer = monAbc.demandeRejouer();
				}while(rejouer != false);
				break;
			case 2 :
				do
				{
					pMonJeux.Defenseur();
					rejouer = monAbc.demandeRejouer();
				}while(rejouer != false);
				break;
			case 3 :
				do
				{
					pMonJeux.Duel();
					rejouer = monAbc.demandeRejouer();
				}while(rejouer != false);
				break;
			default :
				System.out.println("Choisis une nombre valide, y a pas de mode de jeux caché");
				break;
			}
		}while(choix != 1 && choix != 2 && choix != 3);
	}
}
