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
	 * M�thode
	 */
	
	
	
	// M�thode
	
	/*
	 * Principe de Recherche + ou - 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche
	 * 		+ si le chiffre de la combinaison est sup�rieur
	 * 		= si le chiffre de la combinaison est �gale
	 * 		- si le chiffre de la combinaison est inf�rieur
	 */
	
	public void Challenger () {
		// G�n�ration d'une combinaison
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
		
		// Cr�ation d'un Scanner pour r�cup�rer les entr�es de l'utilisateur
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
		
		System.out.println("Tu as gagn� en " + coups + ".");
		
		clavier.close();
	}
	
	public void Defenseur() {
		/*
		 *  L'utilisateur entre une combinaison
		 */
		// Cr�ation d'un Scanner pour la combinaison de l'utilisateur
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
		
		// Cr�ation d'un Scanner pour r�cup�rer les entr�es de l'utilisateur
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
	
				
		System.out.println("Tu as gagn� en " + coups + ".");
	}
	
	public void Duel () {
		// Appeler sucessivement les fontions de Challenger et de d�fenseur
	}
}
