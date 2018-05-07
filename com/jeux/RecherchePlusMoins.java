package com.jeux;

import java.util.InputMismatchException;
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
	
	
	
	// M�thode des modes de jeux
	
	/*
	 * Principe de Recherche + ou - 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche
	 * 		+ si le chiffre de la combinaison est sup�rieur
	 * 		= si le chiffre de la combinaison est �gale
	 * 		- si le chiffre de la combinaison est inf�rieur
	 */
	
	public void Challenger () {
		// D�claration de variable
		byte combinaison[] = new byte[4];
		byte nombre[] = new byte[4];
		byte valide = 0;
		int coups = 0;

		// G�n�ration d'une combinaison
		genereCombinaison(combinaison);
		
		do
		{
			valide = 0;
			
			lisCombinaison(nombre);	
			
			valide = afficheReponse(combinaison, nombre);

			coups++;
		}while(valide != combinaison.length); // Il faut un nombre de coups maximal
		
		System.out.println("Tu as gagn� en " + coups + " coups.");		
	}
	
	public void Defenseur() {
		// D�claration de variable
		byte combinaison[] = new byte[4];
		byte nombre[] = new byte[4];
		byte min[] = new byte[4];
		byte max[] = new byte[4];
		byte valide = 0;
		int coups = 0;
		
		
		System.out.println("Tapes ta combinaison");
		lisCombinaison(combinaison);
		
		// Une m�htode pour le tout (byte minTab[], byte maxTab[]) ou une m�thode avec 2 param�tre (byte tableau[], byte valeur) ?
		for(int i = 0; i < min.length; i++)
		{
			min[i] = 0;
		}
		for(int i = 0; i < max.length; i++)
		{
			max[i] = 9;
		}

		
		// L'ia cherche la combinaison
		do
		{
			coups++;
			valide = 0;
			
			// L' ia joue
			System.out.println("Tour " + coups);
			
			
			for(int i = 0; i < combinaison.length ; i++)
			{
				nombre[i] = (byte) (Math.round((min[i]+max[i]) / 2));
					
				if(nombre[i] < combinaison[i])
				{
					min[i] = (byte) (nombre[i] + 1);
				}
				else if(nombre[i] > combinaison[i])
				{
					max[i] = (byte) (nombre[i] - 1);
				}
				else
				{
					min[i] = nombre[i];
					max[i] = nombre[i];
				}
			}
			
			// On affiche la proposition de l'ia
			afficheCombinaison(nombre);
			
			valide = afficheReponse(combinaison, nombre);
			
			System.out.println();
			System.out.println();	
		}while(valide != combinaison.length);
		
		System.out.println("Tu as gagn� en " + coups + " coups.");
	}
	
	public void Duel () {
		// D�claration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte combinaisonIA[] = new byte[4];
		byte nombre[] = new byte[4];
		byte min[] = new byte[4];
		byte max[] = new byte[4];
		byte valideJoueur = 0;
		byte valideIA = 0;
		int coups = 0;
		
		// Une m�htode pour le tout (byte minTab[], byte maxTab[]) ou une m�thode avec 2 param�tre (byte tableau[], byte valeur) ?
		for(int i = 0; i < min.length; i++)
		{
			min[i] = 0;
		}
		for(int i = 0; i < max.length; i++)
		{
			max[i] = 9;
		}
		
		// La combinaison de l'IA est g�ner� et on en demande une au joueur
		genereCombinaison(combinaisonIA);
		System.out.println("Choisis ta combinaison");
		lisCombinaison(combinaisonJoueur);
		
		// Appeler sucessivement les fontions de Challenger et de d�fenseur
		if(zeroUn() == 1)
		{
			System.out.println("Le joueur joue en premier.");
			do
			{
				coups++;
				System.out.println("Tour " + coups);

				System.out.println("Joueur");
				
				System.out.print("\tLe joueur propose ");				
				lisCombinaison(nombre);
				
				System.out.print("\tR�ponse ");
				valideJoueur = afficheReponse(combinaisonIA, nombre);
				
				System.out.println();
				
				System.out.println("IA");
				
				for(int i = 0; i < combinaisonJoueur.length ; i++)
				{
					nombre[i] = (byte) (Math.round((min[i]+max[i]) / 2));
						
					if(nombre[i] < combinaisonJoueur[i])
					{
						min[i] = (byte) (nombre[i] + 1);
					}
					else if(nombre[i] > combinaisonJoueur[i])
					{
						max[i] = (byte) (nombre[i] - 1);
					}
					else
					{
						min[i] = nombre[i];
						max[i] = nombre[i];
					}
				}
				
				// On affiche la proposition de l'ia
				System.out.print("\tL'IA propose ");				
				afficheCombinaison(nombre);
				System.out.print("\n");

				System.out.print("\tR�ponse ");
				valideIA = afficheReponse(combinaisonJoueur, nombre);
				
				System.out.println();
				System.out.println();				
			}while(valideJoueur != combinaisonJoueur.length && valideIA != combinaisonIA.length);
		}
		else
		{
			System.out.println("L'IA joue en premier.");
			do
			{
				coups++;
				System.out.println("Tour " + coups);

				System.out.println("IA");
				
				for(int i = 0; i < combinaisonJoueur.length ; i++)
				{
					nombre[i] = (byte) (Math.round((min[i]+max[i]) / 2));
						
					if(nombre[i] < combinaisonJoueur[i])
					{
						min[i] = (byte) (nombre[i] + 1);
					}
					else if(nombre[i] > combinaisonJoueur[i])
					{
						max[i] = (byte) (nombre[i] - 1);
					}
					else
					{
						min[i] = nombre[i];
						max[i] = nombre[i];
					}
				}
				
				// On affiche la proposition de l'ia
				System.out.print("\tL'IA propose ");				
				afficheCombinaison(nombre);
				System.out.print("\n");

				System.out.print("\tR�ponse ");
				valideIA = afficheReponse(combinaisonJoueur, nombre);

				System.out.println();

				System.out.println("Joueur");
				
				System.out.print("\tLe joueur propose ");				
				lisCombinaison(nombre);
				
				System.out.print("\tR�ponse ");
				valideJoueur = afficheReponse(combinaisonIA, nombre);
				
				System.out.println();
				System.out.println();
			}while(valideJoueur != combinaisonIA.length && valideIA != combinaisonJoueur.length);
		}
		if(valideJoueur == combinaisonIA.length && valideIA == combinaisonJoueur.length)
		{
			System.out.println("Match nul en " + coups + " coups.");			
		}
		else if(valideJoueur == combinaisonIA.length)
		{
			System.out.println("Tu as gagn� en " + coups + " coups.");
		}
		else if(valideIA == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagn� en " + coups + " coups.");
		}

	}
	
	// M�thode
	protected void afficheCombinaison(byte pCombi[]) {
		for(int i = 0; i < pCombi.length; i++)
		{
			System.out.print(pCombi[i]);
		}
	}
	
	
	// Valide n'est qu'une copie est ne modifie pas une variable
	protected byte afficheReponse(byte combinaison[], byte nombre[]) {
		// D�claration de variable
		byte valide = 0;
		
		for(int i = 0; i < combinaison.length; i++)
		{				
			if(nombre[i] < combinaison[i])
			{
				System.out.print("+");
			}
			else if(nombre[i] > combinaison[i])
			{
				System.out.print("-");
			}
			else
			{
				System.out.print("=");
				valide++;
			}
		}
		
		return valide;
	}
	
	protected int zeroUn() {
		double nombre = 0.5;
		do
		{
			nombre = Math.random();
			if(nombre < 0.5 || nombre > 0.5)
			{
				Math.round(nombre);
			}											
		}while(nombre == 0.5);
		return (int) nombre;
	}
	
	// R�cup�re une entr�e de l'utilisateur est la converti en un tableaux de byte
	protected void lisCombinaison(byte pNombre[]) {
		// D�claration de variable
		short entreeUtilisateur = 0;
		entreeUtilisateur = entree();
		
		// Convertion en un tableaux de byte de l'entr�e
		for(int i = 0; i < pNombre.length; i++)
		{				
			pNombre[i] = (byte) (entreeUtilisateur / Math.pow(10, (pNombre.length - (i + 1))));
			entreeUtilisateur -= pNombre[i] * Math.pow(10, (pNombre.length - (i + 1)));
		}
	}
	
	public short entree() {
		// D�claration de variable
		Scanner clavier = new Scanner(System.in);
		short entreeUtilisateur = 0;
				
		try
		{
			// R�cup�ration d'une entr�e utilisateur
			entreeUtilisateur = clavier.nextShort();
			return entreeUtilisateur;
		}
		catch(InputMismatchException e)
		{
			clavier.next();
			return 0;
		}
	}
	
	protected void genereCombinaison(byte pCombi[]) {
		for(int i = 0; i < pCombi.length; i++)
		{
			pCombi[i] = (byte) (Math.random() * 9);
		}
	}
}
