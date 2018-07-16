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
	 * M�thode
	 */
	// M�thode pour choissir le mode de jeux grace � un switch qui appelle la m�thode mode de jeu pour s�l�ctionner le mode qui appellera le jeux en lui m�me
	void choixModes(Jeux pMonJeux) {
		// D�claration des variables
		int choix = 0;
		Boolean rejouer = false;
		
		//Boucle de do ... while, car elle doit s'�x�cut� au moins un fois
		// Switch pour le choix du jeux
		// Cr�ation d'un Scanner pour r�cup�rer le choix puis sa fermeture
		Scanner clavier = new Scanner(System.in);
		
		do
		{
			//Affichage du choix � chaque boucle
			System.out.println("Choisis le mode");
			System.out.println("\t1 - Challenger");
			System.out.println("\t2 - D�fenseur");
			System.out.println("\t3 - Duel");

			// R�cup�ration du choix
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
				System.out.println("Choisis une nombre valide, y a pas de mode de jeux cach�");
				break;
			}
		}while(choix != 1 && choix != 2 && choix != 3);
	}
}
