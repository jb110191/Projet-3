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
	 * M�thode
	 */
	
	// M�thode des modes de jeux
	
	/*
	 * Principe du Mastermind 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche le nombre de chiffre au bonne emplacement et le nombre de chiffre au mauvais emplacement
	 */
	
	public static void Challenger() {
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("D�but de la m�thode Challenger de la classe Mastermind.");
		
		// D�claration de variable
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

		// G�n�ration d'une combinaison
		monAbc.genereCombinaison(combinaisonIA, (byte) (nombreValeur-1));
		
		// Le joueur cherche la combinaison de l'IA
		do
		{		
			// On ajoute un coups � chaque boucle
			coups++;
			System.out.println("Tour " + coups);
						
			/*
			 * Log
			 * pour afficher le tour
			 */
			LogOutil.LOGGER.trace("Tour " + coups);
			
			// On appelle tourJoueur
			valideJoueur = tourJoueur(combinaisonIA, proposition);
			
			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideJoueur != combinaisonIA.length); // Il faut un nombre de coups maximal
				
		System.out.println("Tu as gagn� en " + coups + " coups.");
		
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("Fin de la m�thode Challenger de la classe Mastermind.");
	}
	
	public static void Defenseur() {
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("D�but de la m�thode Defenseur de la classe Mastermind.");
		
		// D�claration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte proposition[] = new byte[4];	
		
		MastermindVariable mesNouvellesVariables = new MastermindVariable();
		MastermindVariable mesAnciennesVariables = new MastermindVariable();
		
		byte nombreValeur = 4;
		int coups = 0;
		
		ArrayList <ArrayList <Integer>> listesPossibles = new ArrayList <ArrayList <Integer>>();
		ArrayList <Integer> chiffrePossible = new ArrayList <Integer>();
		ArrayList <Integer> chiffreTrouve = new ArrayList <Integer>();
		
		// On initialise listePossible
		monAbc.reglageListePossible(listesPossibles, chiffrePossible, combinaisonJoueur.length, nombreValeur);
		
		/*
		 * Log
		 * pour v�rifier les combinaisons dans listesPossibles
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "La listes des combinaisons";
			
			for(int i = 0; i < listesPossibles.size(); i++)
			{
				if((i % (Math.pow(nombreValeur, 2))) == 0)
				{
					str += "\n\t\t";
				}
				else
				{
					str += " - ";
				}
				for(int j = 0; j < listesPossibles.get(i).size(); j++)
				{
					str += listesPossibles.get(i).get(j);
				}
			}
			LogOutil.LOGGER.trace(str);
		}
		
		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Mastermind : D�fenseur");
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
			// On ajoute un coups � chaque boucle
			coups++;
			System.out.println("Tour " + coups);
			
			/*
			 * Log
			 * pour afficher le tour
			 */
			LogOutil.LOGGER.trace("Tour " + coups);
			
					
			// On appelle tourIA
			tourIA(listesPossibles, chiffrePossible, chiffreTrouve, combinaisonJoueur, proposition, mesNouvellesVariables, mesAnciennesVariables, coups);
					
			// On saute une ligne pour l'affichage
			System.out.println();		
		}while(mesNouvellesVariables.valide != combinaisonJoueur.length && coups < 10);
				
		if(mesNouvellesVariables.valide == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagn� en " + coups + " coups.");
		}
		else
		{
			System.out.println("L'IA a perdu.");
		}
		
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("Fin de la m�thode Defenseur de la classe Mastermind.");
	}
	
	public static void Duel() {
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("D�but de la m�thode Duel de la classe Mastermind.");
		
		// D�claration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte combinaisonIA[] = new byte[4];
		byte proposition[] = new byte[4];
		byte valideJoueur = 0;
		byte nombreValeur = 4;
		int coups = 0;

		MastermindVariable mesNouvellesVariables = new MastermindVariable();
		MastermindVariable mesAnciennesVariables = new MastermindVariable();
		
		ArrayList <ArrayList <Integer>> listesPossibles = new ArrayList <ArrayList <Integer>>();
		ArrayList <Integer> chiffrePossible = new ArrayList <Integer>();
		ArrayList <Integer> chiffreTrouve = new ArrayList <Integer>();
		
		// On initialise listePossible
		monAbc.reglageListePossible(listesPossibles, chiffrePossible, combinaisonJoueur.length, nombreValeur);
				
		/*
		 * Log
		 * pour v�rifier les combinaisons dans listesPossibles
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "La listes des combinaisons";
					
			for(int i = 0; i < listesPossibles.size(); i++)
			{
				if((i % (Math.pow(nombreValeur, 2))) == 0)
				{
					str += "\n\t\t";
				}
				else
				{
					str += " - ";
				}
				for(int j = 0; j < listesPossibles.get(i).size(); j++)
				{
					str += listesPossibles.get(i).get(j);
				}
			}
			LogOutil.LOGGER.trace(str);
		}
				
		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Mastermind : Duel");
		System.out.println("Trouver la combinaison du joueur");
		System.out.println();
		
		// On demande au joueur de rentrer un combinaison
		System.out.println("\tTapes une suite de " + combinaisonJoueur.length + " chiffres.");
		System.out.print("\t\t");
		monAbc.lisCombinaison(combinaisonJoueur);
		System.out.println();
		
		// G�n�ration d'une combinaison
		monAbc.genereCombinaison(combinaisonIA, (byte) (nombreValeur-1));
		
		// Appelle sucessif des m�thodes de tourJoueur et de tourIA
		if(monAbc.zeroUn() == 1)
		{
			System.out.println("Le joueur joue en premier.");
			System.out.println();
			do
			{
				// On ajoute un coups � chaque boucle
				coups++;
				System.out.println("Tour " + coups);
				
				/*
				 * Log
				 * pour afficher le tour
				 */
				LogOutil.LOGGER.trace("Tour " + coups);
				
				// On appelle tourJoueur
				valideJoueur = tourJoueur(combinaisonIA, proposition);
				
				// On appelle tourIA
				tourIA(listesPossibles, chiffrePossible, chiffreTrouve, combinaisonJoueur, proposition, mesNouvellesVariables, mesAnciennesVariables, coups);
				
				// On saute une ligne pour l'affichage
				System.out.println();
			}while(valideJoueur != combinaisonIA.length && mesNouvellesVariables.valide != combinaisonJoueur.length);
		}
		else
		{
			System.out.println("L'IA joue en premier.");
			System.out.println();
			do
			{
				// On ajoute un coups � chaque boucle
				coups++;
				System.out.println("Tour " + coups);
				
				/*
				 * Log
				 * pour afficher le tour
				 */
				LogOutil.LOGGER.trace("Tour " + coups);
				
				// On appelle tourIA
				tourIA(listesPossibles, chiffrePossible, chiffreTrouve, combinaisonJoueur, proposition, mesNouvellesVariables, mesAnciennesVariables, coups);
				
				// On appelle tourJoueur
				valideJoueur = tourJoueur(combinaisonIA, proposition);
				
				// On saute une ligne pour l'affichage
				System.out.println();
			}while(valideJoueur != combinaisonIA.length && mesNouvellesVariables.valide != combinaisonJoueur.length);
		}
		if(valideJoueur == combinaisonIA.length && mesNouvellesVariables.valide == combinaisonJoueur.length)
		{
			System.out.println("Match nul en " + coups + " coups.");			
		}
		else if(valideJoueur == combinaisonIA.length)
		{
			System.out.println("Tu as gagn� en " + coups + " coups.");
		}
		else if(mesNouvellesVariables.valide == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagn� en " + coups + " coups.");
		}
		
		// Log pour afficher le d�but de la m�thode
		LogOutil.LOGGER.trace("Fin de la m�thode Duel de la classe Mastermind.");
	}
	
	// M�thode de tour
	protected static byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tJoueur");

		// Lis l'entr�e de l'utilisateur
		System.out.print("\t\tLe joueur propose ");
		monAbc.lisCombinaison(pProposition);

		// On affiche la r�ponse � la proposition du joueur
		System.out.print("\t\tR�ponse ");
		return monAbc.afficheReponseM(pCombinaisonIA, pProposition);
	}
	
	protected static void tourIA(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, ArrayList <Integer> pChiffreTrouve, byte pCombinaisonJoueur[], byte pProposition[], MastermindVariable pMesNouvellesVariables, MastermindVariable pMesAnciennesVariables, int pCoups) {
		// Affichage du jeu
		System.out.println("\tIA");
		
		// L'IA joue
		joueIA(pListesPossibles, pChiffrePossible, pChiffreTrouve, pCombinaisonJoueur, pProposition, pMesNouvellesVariables, pMesAnciennesVariables, pCoups);
		
		// On affiche la proposition de l'IA
		System.out.print("\t\tL'IA propose ");
		monAbc.afficheCombinaison(pProposition);
		System.out.println("");
		
		/*
		 * Log
		 * pour v�rifier les valides est malPlac�
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "Valeur des valides et malPlac�s";
			
			str += "\n\t\t";
			str += "pMesNouvellesVariables.Valide " + pMesNouvellesVariables.valide;
			str += "\n\t\t";
			str += "pMesNouvellesVariables.malPlace " + pMesNouvellesVariables.malPlace;
			str += "\n\t\t";
			str += "pMesAnciennesVariables.Valide " + pMesAnciennesVariables.valide;
			str += "\n\t\t";
			str += "pMesAnciennesVariables.malPlace " + pMesAnciennesVariables.malPlace;
			
			LogOutil.LOGGER.trace(str);
		}
		
		// On d�place les valide et malPlace pour le prochain coup
		monAbc.guereMastermindVariable(pMesNouvellesVariables, pMesAnciennesVariables);
		
		// On affiche la r�ponse � la proposition de l'IA
		System.out.print("\t\tR�ponse ");
		monAbc.afficheReponseM(pCombinaisonJoueur, pProposition, pMesNouvellesVariables);
	}
	
	protected static void joueIA(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, ArrayList <Integer> pChiffreTrouve, byte pCombinaisonJoueur[], byte pProposition[], MastermindVariable pMesNouvellesVariables, MastermindVariable pMesAnciennesVariables, int pCoups) {
		
		/*
		 * Tableau des combinaison possible ?
		 * 
		 * Liste des pr�cedentes porposition ?
		 * Liste des pr�c�dentes valide et malPlace ?
		 */
		// D�claration de variable
		if(pCoups != 1)
		{
			// On supprime la combinaison que l'on � test� pr�cedement
			/*
			 * Pas directement il le faut pur comparer avec les valide et malPlace 
			 * pListesPossibles.remove(0);
			*/
			
			/*
			System.out.println("if(pChiffreTrouve.size() != pCombinaisonJoueur.length)");
			System.out.println("if(" + pChiffreTrouve.size() + " != " + pCombinaisonJoueur.length + ")");
			*/
			
			if(pChiffreTrouve.size() != pCombinaisonJoueur.length)
			{				
				// On cr�e un variable pour une boucle
				int nombreNouveauxIndices = (pMesNouvellesVariables.valide + pMesNouvellesVariables.malPlace) - (pMesAnciennesVariables.valide + pMesAnciennesVariables.malPlace);
				int nombreIndiceCombinaison = 0;
				
				// On d�roule les valeurs dans la liste des possibles
				for(int i = 0; i < pListesPossibles.size(); i++)
				{
					//On met nombreIndiceCombinaison � 0 au d�but de chaque boucle
					nombreIndiceCombinaison = 0;
					
					for(int j = 0; j < pListesPossibles.get(i).size(); j++)
					{
						if(pListesPossibles.get(i).get(j) == pChiffrePossible.get(0))
						{
							nombreIndiceCombinaison++;
						}
					}
					
					/*
					 * Log
					 */
					if(LogOutil.LOGGER.isTraceEnabled() == true)
					{
						String str = "";
						for(int j = 0; j < pListesPossibles.get(i).size(); j++)
						{
							str += pListesPossibles.get(i).get(j);
						}
						LogOutil.LOGGER.trace("La combinaison " + str + "\nElle a " + nombreIndiceCombinaison + " fois la valeur et il faut exactement " + nombreNouveauxIndices + " fois la valeur pour rester dans la listes des possibles.");
					}
					
					// Si nombreIndiceCombinaison est diff�rent de nombreNouveauxIndices ont retire la combinaison
					if(nombreIndiceCombinaison != nombreNouveauxIndices)
					{
						/*
						 * Log
						 */
						LogOutil.LOGGER.trace("La combinaison est supprim�");
						
						pListesPossibles.remove(i);
						i--;
					}
				}
				for(int i = 0; i < nombreNouveauxIndices; i++)
				{
					pChiffreTrouve.add(pChiffrePossible.get(0));
				}
				// On supprime le chiffre qui a �t� test�
				pChiffrePossible.remove(0);
			}
		}
		
		// On fait la premi�re proposition possible
		for(int i = 0; i < pProposition.length; i++)
		{
			pProposition[i] = (byte)(int)pListesPossibles.get(0).get(i);
		}
		
		/*
		 * On supprime la combinaison choissis
		 */
		pListesPossibles.remove(0);
	}
}
