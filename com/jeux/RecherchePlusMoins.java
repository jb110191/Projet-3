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
		}while(valide != combinaison.length); // Il faut un nombre de coups maximal
		
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
		
		System.out.print("La combinaison est ");
		for(int i = 0; i < combinaison.length; i++)
		{
			System.out.print(combinaison[i]);
		}
		System.out.println();

		
		// L'ia cherche la combinaison
		
		// Cr�ation d'un Scanner pour r�cup�rer les entr�es de l'utilisateur
		byte nombre[] = new byte[4];
		byte plusMoinsIA[] = new byte[4]; 
		byte valide = 0;
		int coups = 0;
		
		do
		{
			coups++;
			valide = 0;
			
			// L' ia joue
			System.out.println("Tour " + coups);
			
			//Si c'est le premier coup
			if(coups == 1)
			{
				for(int i = 0; i < combinaison.length; i++)
				{
					double zeroUn = 0.5;
					do
					{
						zeroUn = Math.random();
						if(zeroUn < 0.5 || zeroUn > 0.5)
						{
							nombre[i] = (byte) (4 + Math.round(zeroUn));
						}											
					}while(zeroUn == 0.5);
				}
			}
			// Sinon
			else
			{
				for(int i = 0; i < combinaison.length; i++)
				{
					if(plusMoinsIA[i] == 1)
					{
						nombre[i] += 1;
					}
					else if(plusMoinsIA[i] == -1)
					{
						nombre[i] -= 1;
					}
				}
			}
			
			// On affiche la proposition de l'ia
			for(int i = 0; i < combinaison.length; i++)
			{
				System.out.print(nombre[i]);
			}
			System.out.println();
			
			for(int i = 0; i < combinaison.length; i++)
			{
				if(nombre[i] < combinaison[i])
				{
					System.out.print("+");
					plusMoinsIA[i] = 1;
				}
				else if(nombre[i] > combinaison[i])
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
			System.out.println();
		}while(valide != combinaison.length);
		
		System.out.println("Tu as gagn� en " + coups + ".");
	}
	
	public void Duel () {
		// Appeler sucessivement les fontions de Challenger et de d�fenseur
	}
}
