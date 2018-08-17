package com.outils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntreeUtilisateur {
	/*
	 * Variable de classe
	 */

	/*
	 * Constructeur
	 */

	/*
	 * Méthode
	 */

	// Récupère une entrée de l'utilisateur est la converti en un tableaux de byte
	public void lisCombinaison(byte pNombre[], int pNbValeur) {
		// déclaration de variable
		int entreeInt = 0;

		// On appelle lisEntree
		entreeInt = lisEntree(pNombre.length, pNbValeur);

		// Convertion en un tableaux de byte de l'entrée
		for(int i = 0; i < pNombre.length; i++)
		{				
			pNombre[i] = (byte) (entreeInt / Math.pow(10, (pNombre.length - (i + 1))));
			entreeInt -= pNombre[i] * Math.pow(10, (pNombre.length - (i + 1)));
		}
	}

	public int lisEntree(int pLongueurEntree, int pNbValeur) {
		// Déclaration de variable
		String entreeString = "";
		int entreeInt = 0;
		int maxInt = 0;

		boolean entreBonne = false;

		for(int i = 0; i < pLongueurEntree; i++)
		{				
			maxInt += pNbValeur * Math.pow(10, (pLongueurEntree - (i + 1)));
		}

		while(entreBonne == false)
		{
			entreeString = entree();
			entreeInt = 0;
			if(entreeString.length() == pLongueurEntree)
			{				
				// Convertion en un tableaux de byte de l'entrée
				for(int i = 0; i < pLongueurEntree; i++)
				{				
					entreeInt += (int) (entreeString.charAt(i) - 48) * Math.pow(10, (pLongueurEntree - (i + 1)));
				}
				if(entreeInt >= 0 && entreeInt <= maxInt)
				{
					entreBonne = true;
				}	
			}
			if(entreBonne == false)
			{
				System.out.println("Veuillez entrer une valeur valide");
			}
		}

		return entreeInt;
	}

	// Récupère un entrée de l'utilisateur
	public String entree() {
		// Déclaration de variable
		Scanner clavier = new Scanner(System.in);
		String entreeUtilisateur = "";

		Boolean estString = false;

		while(estString != true)
		{
			try
			{
				// Récupération d'une entrée utilisateur
				entreeUtilisateur = clavier.next();
				estString = true;
			}
			catch(InputMismatchException e)
			{
				clavier.next();
				System.out.println("Veuillez entrer une valeur valide");
			}
		}

		// On retourne un short
		return entreeUtilisateur;
	}

	//
	public int demandeRejouer() {
		System.out.println("Veux-tu rejouer ?");
		System.out.println("\t0 - Rejouer le même jeu dans le même mode");
		System.out.println("\t1 - Retour séléction du choix du mode");
		System.out.println("\t2 - Retour séléction du choix du jeu");
		System.out.println("\t3 - Quitter l'application");

		return lisEntree(1, 3);
	}
}
