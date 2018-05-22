package com.jeux;

import com.abc.Abc;

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
	
	public void Challenger() {
		// D�claration de variable
		byte combinaisonIA[] = new byte[4];
		byte proposition[] = new byte[4];
		byte valideJoueur = 0;
		byte valeurMax = 4;
		int coups = 0;

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Mastermind : Challenger");
		System.out.println("Trouver la combinaison de l'IA");
		System.out.println();
		
		
		/*
		 * Test avec combinaison sp�cial
		// G�n�ration d'une combinaison
		monAbc.genereCombinaison(combinaisonIA, valeurMax);
		*/
		combinaisonIA[0] = 2;
		combinaisonIA[1] = 2;
		combinaisonIA[2] = 3;
		combinaisonIA[3] = 4;

		//Test
		System.out.print("La combinaison est ");
		monAbc.afficheCombinaison(combinaisonIA);
		System.out.println();		
		
		// Le joueur cherche la combinaison de l'IA
		do
		{
			// On ajoute un coups � chaque boucle
			coups++;
			System.out.println("Tour " + coups);
			
			// On appelle tourJoueur
			valideJoueur = tourJoueur(combinaisonIA, proposition);
			
			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideJoueur != combinaisonIA.length); // Il faut un nombre de coups maximal
				
		System.out.println("Tu as gagn� en " + coups + " coups.");
	}
	
	public void Defenseur() {
		// D�claration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte proposition[] = new byte[4];
		byte valideIA = 0;
		int coups = 0;
		
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
					
			// On appelle tourIA
			valideIA = tourIA(combinaisonJoueur, proposition);
					
			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideIA != combinaisonJoueur.length);
				
				System.out.println("Tu as gagn� en " + coups + " coups.");
	}
	
	public void Duel() {
		//
	}
	
	// M�thode de tour
	protected byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tJoueur");

		// Lis l'entr�e de l'utilisateur
		System.out.print("\t\tLe joueur propose ");
		monAbc.lisCombinaison(pProposition);

		// On affiche la r�ponse � la proposition du joueur
		System.out.print("\t\tR�ponse ");
		return monAbc.afficheReponseM(pCombinaisonIA, pProposition);
	}
	
	protected byte tourIA(byte pCombinaisonJoueur[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tIA");
		
		// L'IA joue
		//joueIA(pCombinaisonJoueur, pProposition);
		
		// On affiche la proposition de l'IA
		System.out.print("\t\tL'IA propose ");
		monAbc.afficheCombinaison(pProposition);
		System.out.println("");
		
		// On affiche la r�ponse � la proposition de l'IA
		System.out.print("\t\tR�ponse ");
		return monAbc.afficheReponseR(pCombinaisonJoueur, pProposition);
	}
	
	protected void joueIA(byte pCombinaisonJoueur[], byte pProposition[]) {
		// ?
	}
}
