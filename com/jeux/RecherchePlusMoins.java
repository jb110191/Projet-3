package com.jeux;

import java.util.Scanner;

public class RecherchePlusMoins {
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
	
	
	
	// Méthode
	
	/*
	 * Principe de Recherche + ou - 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche
	 * 		+ si le chiffre de la combinaison est supérieur
	 * 		= si le chiffre de la combinaison est égale
	 * 		- si le chiffre de la combinaison est inférieur
	 */
	
	public void Challenger () {
		// Génération d'une combinaison
		byte combinaison[] = new byte[4];
		for(int i = 0; i < combinaison.length; i++)
		{
			combinaison[i] = (byte) (Math.random() * 9);
		}
		
		for(int i = 0; i < combinaison.length; i++)
		{
			System.out.print(combinaison[i]);
		}
		System.out.println();
		
		// Création d'un Scanner pour récupérer les entrées de l'utilisateur
		Scanner clavier = new Scanner(System.in);
		
		short entreeUtilisateur = 0;
		byte nombre[] = new byte[4];
		byte valide = 0;
		int coups = 0;
		
		do
		{
			valide = 0;
			entreeUtilisateur = clavier.nextShort();
			for(int i = 0; i < combinaison.length; i++)
			{				
				nombre[i] = (byte) (entreeUtilisateur / Math.pow(10, (combinaison.length - (i + 1))));
				entreeUtilisateur -= nombre[i] * Math.pow(10, (combinaison.length - (i + 1)));
				
				if(nombre[i] > combinaison[i])
				{
					System.out.print("+");
				}
				else if(nombre[i] < combinaison[i])
				{
					System.out.print("-");
				}
				else
				{
					System.out.print("=");
					valide++;
				}
			}
			System.out.println();

			coups++;
		}while(valide != combinaison.length);
		
		System.out.println("Tu as gagné en " + coups + ".");
		
		clavier.close();
	}
	
	public void Defenseur() {
		/*
		 *  L'utilisateur entre une combinaison
		 */
		// Création d'un Scanner pour la combinaison de l'utilisateur
		System.out.println("Tapes ta combinaison");
		
		Scanner clavier = new Scanner(System.in);
		
		short entreeUtilisateur = clavier.nextShort();
		
		clavier.close();
		
		byte combinaison[] = new byte[4];
		
		for(int i = 0; i < combinaison.length; i++)
		{
			combinaison[i] = (byte) (entreeUtilisateur / Math.pow(10, (combinaison.length - (i + 1))));
			entreeUtilisateur -= combinaison[i] * Math.pow(10, (combinaison.length - (i + 1)));
		}
		
		System.out.println("La combinaison");
		
		// L'ia cherche la combinaison
		
		// Création d'un Scanner pour récupérer les entrées de l'utilisateur
		byte nombre[] = new byte[4];
		byte plusMoinsIA[] = new byte[4]; 
		byte valide = 0;
		int coups = 0;
		
		do
		{
			valide = 0;
			for(int i = 0; i < combinaison.length; i++)
			{				
				
				if(nombre[i] > combinaison[i])
				{
					System.out.print("+");
					plusMoinsIA[i] = 1;
				}
				else if(nombre[i] < combinaison[i])
				{
					System.out.print("-");
					plusMoinsIA[i] = -1;
				}
				else
				{
					System.out.print("=");
					plusMoinsIA[i] = 0;
					valide++;
				}
			}
			System.out.println();

			coups++;
		}while(valide != combinaison.length);
	
				
		System.out.println("Tu as gagné en " + coups + ".");
	}
	
	public void Duel () {
		// Appeler sucessivement les fontions de Challenger et de défenseur
	}
}
