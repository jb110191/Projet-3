package com.jeux;

import java.util.ArrayList;

import com.abc.*;
import com.logoutil.*;

public class Mastermind {
	/*
	 * Variable de classe
	 */
	static Abc monAbc = new Abc();
	
	/*
	 * Constructeur
	 */
	//
	
	/*
	 * Méthode
	 */
	
	
	
	// Méthode des modes de jeux
	
	/*
	 * Principe du Mastermind 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche le nombre de chiffre au bonne emplacement et le nombre de chiffre au mauvais emplacement
	 */
	
	public static void Challenger() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Challenger de la classe Mastermind.");
		
		// Déclaration de variable
		byte combinaisonIA[] = new byte[4];
		byte proposition[] = new byte[4];
		byte valideJoueur = 0;
		byte nombreValeur = 4;
		int coups = 0;

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Mastermind : Challenger");
		System.out.println("Trouver la combinaison de l'IA");
		System.out.println();

		// Génération d'une combinaison
		monAbc.genereCombinaison(combinaisonIA, (byte) (nombreValeur-1));
		
		// Le joueur cherche la combinaison de l'IA
		do
		{
			// On ajoute un coups à chaque boucle
			coups++;
			System.out.println("Tour " + coups);
			
			// On appelle tourJoueur
			valideJoueur = tourJoueur(combinaisonIA, proposition);
			
			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideJoueur != combinaisonIA.length); // Il faut un nombre de coups maximal
				
		System.out.println("Tu as gagné en " + coups + " coups.");
		
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Challenger de la classe Mastermind.");
	}
	
	public static void Defenseur() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Defenseur de la classe Mastermind.");
		
		// Déclaration de variable
		ArrayList <ArrayList <Integer>> listePossible = new ArrayList <ArrayList <Integer>>();

		byte combinaisonJoueur[] = new byte[4];
		byte proposition[] = new byte[4];		
		byte valideIA = 0;
		byte malPlaceIA[] = new byte[1];
		byte nombreValeur = 4;
		int coups = 0;
		
		// On initialise listePossible
		monAbc.reglageListePossible(listePossible, combinaisonJoueur,  nombreValeur);
		
		// Log pour afficher listePossible
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			for(int i = 0; i < listePossible.size(); i++)
			{
				for(int j = 0; j < listePossible.get(i).size(); j++)
				{
					LogOutil.LOGGER.trace("listePossible.get(" + i + ").get(" + j + ") = " + listePossible.get(i).get(j));
				}
			}
		}
		
		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Mastermind : Défenseur");
		System.out.println("Trouver la combinaison du joueur");
		System.out.println();
		
		// On demande au joueur de rentrer un combinaison
		System.out.println("\tTapes une suite de " + combinaisonJoueur.length + " chiffres.");
		System.out.print("\t\t");
		monAbc.lisCombinaison(combinaisonJoueur);
		System.out.println();
		
		// L'IA cherche la combinaison du joueur
		do
		{
			// On ajoute un coups à chaque boucle
			coups++;
			System.out.println("Tour " + coups);
					
			// On appelle tourIA
			valideIA = tourIA(listePossible, combinaisonJoueur, proposition, valideIA, malPlaceIA, coups);
					
			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideIA != combinaisonJoueur.length);
				
		System.out.println("Tu as gagné en " + coups + " coups.");
		
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Defenseur de la classe Mastermind.");
	}
	
	public static void Duel() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Duel de la classe Mastermind.");

		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Duel de la classe Mastermind.");
	}
	
	// Méthode de tour
	protected static byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tJoueur");

		// Lis l'entrée de l'utilisateur
		System.out.print("\t\tLe joueur propose ");
		monAbc.lisCombinaison(pProposition);

		// On affiche la réponse à la proposition du joueur
		System.out.print("\t\tRéponse ");
		return monAbc.afficheReponseM(pCombinaisonIA, pProposition);
	}
	
	protected static byte tourIA(ArrayList <ArrayList <Integer>> pListePossible, byte pCombinaisonJoueur[], byte pProposition[], byte pValideIA, byte pMalPlace[], int pCoups) {
		// Affichage du jeu
		System.out.println("\tIA");
		
		// L'IA joue
		joueIA(pListePossible ,pCombinaisonJoueur, pProposition, pValideIA, pMalPlace, pCoups);
		
		// On affiche la proposition de l'IA
		System.out.print("\t\tL'IA propose ");
		monAbc.afficheCombinaison(pProposition);
		System.out.println("");
		
		// On affiche la réponse à la proposition de l'IA
		System.out.print("\t\tRéponse ");
		return monAbc.afficheReponseM(pCombinaisonJoueur, pProposition, pMalPlace);
	}
	
	protected static void joueIA(ArrayList <ArrayList <Integer>> pListePossible, byte pCombinaisonJoueur[], byte pProposition[], byte pValideIA, byte pMalPlace[], int pCoups) {
		
		/*
		 * Tableau des combinaison possible ?
		 * 
		 * Liste des précedentes porposition ?
		 * Liste des précédentes valide et malPlace ?
		 */
		
		// On joue le premier coups
		if(pCoups == 0)
		{
			for(int i = 0; i < pCombinaisonJoueur.length; i++)
			{
				pProposition[i] = (byte)((int) (pListePossible.get(i).get(0)));
			}
		}
		
		// On retire les valeurs impossibles et on fait jouer l'IA
		else
		{
			if(pValideIA == 0)
			{
				for(int i = 0; i < pCombinaisonJoueur.length; i++)
				{
					for(int j = 0; j < pListePossible.get(i).size(); j++)
					{
						if(pListePossible.get(i).get(j) == pProposition[i])
						{
							pListePossible.get(i).remove(j);			
						}
					}
				} 
			}
			// ?
			else if(pValideIA > 0)
			{
				//
			}
			
			// L'IA joue
			
		}
	}
}
