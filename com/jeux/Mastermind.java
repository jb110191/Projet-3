package com.jeux;

import java.util.ArrayList;

import com.abc.*;
import com.logoutil.*;

public class Mastermind implements Jeux {
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
	// Méthode des modes de jeux
	
	/*
	 * Principe du Mastermind 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche le nombre de chiffre au bonne emplacement et le nombre de chiffre au mauvais emplacement
	 */
	
	public void Challenger() {
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
		
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			System.out.println("Mode debug");
			System.out.print("La combinaison est ");
			for(int i = 0; i < combinaisonIA.length; i++)
			{
				System.out.print(combinaisonIA[i]);
			}
			System.out.println();
		}
		
		// Le joueur cherche la combinaison de l'IA
		do
		{		
			// On ajoute un coups à chaque boucle
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
				
		System.out.println("Tu as gagné en " + coups + " coups.");
		
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Challenger de la classe Mastermind.");
	}
	
	public void Defenseur() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Defenseur de la classe Mastermind.");
		
		// Déclaration de variable
		byte combinaisonJoueur[] = new byte[6];
		byte proposition[] = new byte[6];	
		
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
		 * pour vérifier les combinaisons dans listesPossibles
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "La listes des ";
			str += listesPossibles.size();
			str += " combinaisons";

			for(int i = 0; i < listesPossibles.size(); i++)
			{
				if((i % 20) == 0)
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
			System.out.println("L'IA a gagné en " + coups + " coups.");
		}
		else
		{
			System.out.println("L'IA a perdu.");
		}
		
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Defenseur de la classe Mastermind.");
	}
	
	public void Duel() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Duel de la classe Mastermind.");
		
		// Déclaration de variable
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
		 * pour vérifier les combinaisons dans listesPossibles
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "La listes des ";
			str += listesPossibles.size();
			str += " combinaisons";
					
			for(int i = 0; i < listesPossibles.size(); i++)
			{
				if((i % 20) == 0)
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
		
		// Génération d'une combinaison
		monAbc.genereCombinaison(combinaisonIA, (byte) (nombreValeur-1));
		
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			System.out.println("Mode debug");
			System.out.print("La combinaison est ");
			for(int i = 0; i < combinaisonIA.length; i++)
			{
				System.out.print(combinaisonIA[i]);
			}
			System.out.println();
		}
		
		// Appelle sucessif des méthodes de tourJoueur et de tourIA
		if(monAbc.zeroUn() == 1)
		{
			System.out.println("Le joueur joue en premier.");
			System.out.println();
			do
			{
				// On ajoute un coups à chaque boucle
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
				// On ajoute un coups à chaque boucle
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
			System.out.println("Tu as gagné en " + coups + " coups.");
		}
		else if(mesNouvellesVariables.valide == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagné en " + coups + " coups.");
		}
		
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Duel de la classe Mastermind.");
	}
	
	// Méthode de tour
	protected byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tJoueur");

		// Lis l'entrée de l'utilisateur
		System.out.print("\t\tLe joueur propose ");
		monAbc.lisCombinaison(pProposition);

		// On affiche la réponse à la proposition du joueur
		System.out.print("\t\tRéponse ");
		return monAbc.afficheReponseM(pCombinaisonIA, pProposition);
	}
	
	protected void tourIA(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, ArrayList <Integer> pChiffreTrouve, byte pCombinaisonJoueur[], byte pProposition[], MastermindVariable pMesNouvellesVariables, MastermindVariable pMesAnciennesVariables, int pCoups) {
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
		 * pour vérifier les valides est malPlacé
		 */
		if(LogOutil.LOGGER.isTraceEnabled() == true)
		{
			String str = "Valeur des valides et malPlacés";
			
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
		
		// On déplace les valide et malPlace pour le prochain coup
		monAbc.guereMastermindVariable(pMesNouvellesVariables, pMesAnciennesVariables);
		
		// On affiche la réponse à la proposition de l'IA
		System.out.print("\t\tRéponse ");
		monAbc.afficheReponseM(pCombinaisonJoueur, pProposition, pMesNouvellesVariables);
	}
	
	protected void joueIA(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, ArrayList <Integer> pChiffreTrouve, byte pCombinaisonJoueur[], byte pProposition[], MastermindVariable pMesNouvellesVariables, MastermindVariable pMesAnciennesVariables, int pCoups) {
		// Déclaration de variable
		if(pCoups != 1)
		{
			if(pChiffreTrouve.size() != pCombinaisonJoueur.length)
			{				
				// On crée un variable pour une boucle
				int nombreNouveauxIndices = (pMesNouvellesVariables.valide + pMesNouvellesVariables.malPlace) - (pMesAnciennesVariables.valide + pMesAnciennesVariables.malPlace);
				int nombreIndiceCombinaison = 0;
				
				/*
				 * Test
				 */
				LogOutil.LOGGER.trace("pChiffrePossible.size() = " + pChiffrePossible.size());
				
				// On déroule les valeurs dans la liste des possibles
				for(int i = 0; i < pListesPossibles.size(); i++)
				{
					//On met nombreIndiceCombinaison à 0 au début de chaque boucle
					nombreIndiceCombinaison = 0;
					
					for(int j = 0; j < pListesPossibles.get(i).size(); j++)
					{
						if(pListesPossibles.get(i).get(j) == pChiffrePossible.get(0))
						{
							nombreIndiceCombinaison++;
						}
					}
									
					// Si nombreIndiceCombinaison est différent de nombreNouveauxIndices ont retire la combinaison
					if(nombreIndiceCombinaison != nombreNouveauxIndices)
					{
						
						if(LogOutil.LOGGER.isTraceEnabled() == true)
						{
							String str = "La combinaisons ";
							
							for(int j = 0; j < pListesPossibles.get(i).size(); j++)
							{
								str += pListesPossibles.get(i).get(j);
							}
							str += " est suprimmé car elle a ";
							str += nombreIndiceCombinaison;
							str += " chiffre(s) _";
							str += pChiffrePossible.get(0);
							str += "_ au lieux de ";
							str += nombreNouveauxIndices;
							str += ".";
							LogOutil.LOGGER.trace(str);
						}
						pListesPossibles.remove(i);
						i--;
					}
				}
				for(int i = 0; i < nombreNouveauxIndices; i++)
				{
					pChiffreTrouve.add(pChiffrePossible.get(0));
				}
				// On supprime le chiffre qui a été testé
				pChiffrePossible.remove(0);
			}
			
			/*
			 * Log
			 * pour vérifier les combinaisons dans listesPossibles
			 */
			if(LogOutil.LOGGER.isTraceEnabled() == true)
			{
				String str = "La listes des ";
				str += pListesPossibles.size();
				str += " combinaisons";
				
				for(int i = 0; i < pListesPossibles.size(); i++)
				{
					if((i % 20) == 0)
					{
						str += "\n\t\t";
					}
					else
					{
						str += " - ";
					}
					for(int j = 0; j < pListesPossibles.get(i).size(); j++)
					{
						str += pListesPossibles.get(i).get(j);
					}
				}
				LogOutil.LOGGER.trace(str);
			}
		}
		
		// On fait la première proposition possible
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
