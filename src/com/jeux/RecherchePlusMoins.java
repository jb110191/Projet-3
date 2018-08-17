package com.jeux;

import com.logoutil.LogOutil;

public class RecherchePlusMoins implements Jeux {
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
	 * Principe de Recherche + ou - 
	 * Trouver une combinanaison de 4 chiffres
	 * Le jeux affiche
	 * 		+ si le chiffre de la combinaison est supérieur
	 * 		= si le chiffre de la combinaison est égale
	 * 		- si le chiffre de la combinaison est inférieur
	 */

	public void Challenger () {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Challenger de la classe RecherchePlusMoins.");

		// Déclaration de variable
		byte combinaisonIA[] = new byte[4];
		byte proposition[] = new byte[4];
		byte valideJoueur = 0;
		int coups = 0;

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Challenger");
		System.out.println("Trouver la combinaison de l'IA");
		System.out.println();

		// Génération d'une combinaison
		instanceMethodesOutils.genereCombinaison(combinaisonIA);

		// Affichage de la combinaison en mode Debug
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			System.out.println("Mode debug");
			System.out.println("La combinaison est " + instanceMethodesOutils.combinaisonTexte(combinaisonIA) + ".");
		}

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
		LogOutil.LOGGER.trace("Fin de la méthode Challenger de la classe RecherchePlusMoins.");
	}

	public void Defenseur() {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Defenseur de la classe RecherchePlusMoins.");

		// Déclaration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte proposition[] = new byte[4];
		byte min[] = new byte[4];
		byte max[] = new byte[4];
		byte valideIA = 0;
		int coups = 0;

		// On règle les valeurs minimals et maximals de la combinaison
		instanceMethodesOutils.reglageMinMax(min, max);

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Défenseur");
		System.out.println("Trouver la combinaison du joueur");
		System.out.println();

		// On demande au joueur de rentrer un combinaison
		System.out.println("\tTapes une suite de " + combinaisonJoueur.length + " chiffres avec des chiffres de 0 à 9." );
		System.out.print("\t\t");
		instanceEntreeUtilisateur.lisCombinaison(combinaisonJoueur, 9);
		System.out.println();

		// L'IA cherche la combinaison du joueur
		do
		{
			// On ajoute un coups à chaque boucle
			coups++;
			System.out.println("Tour " + coups);

			// On appelle tourIA
			valideIA = tourIA(combinaisonJoueur, proposition, min, max);

			// On saute une ligne pour l'affichage
			System.out.println();
		}while(valideIA != combinaisonJoueur.length);

		System.out.println("Tu as gagné en " + coups + " coups.");

		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Defenseur de la classe RecherchePlusMoins.");
	}

	public void Duel () {
		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Début de la méthode Duel de la classe RecherchePlusMoins.");

		// Déclaration de variable
		byte combinaisonJoueur[] = new byte[4];
		byte combinaisonIA[] = new byte[4];
		byte proposition[] = new byte[4];
		byte min[] = new byte[4];
		byte max[] = new byte[4];
		byte valideJoueur = 0;
		byte valideIA = 0;
		int coups = 0;

		// On règle les valeurs minimals et maximals de la combinaison
		instanceMethodesOutils.reglageMinMax(min, max);

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Duel");
		System.out.println("Trouver la combinaison de l'IA avant qu'elle ne trouve la tienne.");
		System.out.println();

		// La combinaison de l'IA est gèneré et on en demande une au joueur
		instanceMethodesOutils.genereCombinaison(combinaisonIA);

		// On demande au joueur de rentrer un combinaison
		System.out.println("\tTapes une suite de " + combinaisonJoueur.length + " chiffres avec des chiffres de 0 à 9." );
		System.out.print("\t\t");
		instanceEntreeUtilisateur.lisCombinaison(combinaisonJoueur, 9);
		System.out.println();

		// Affichage de la combinaison en mode Debug
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			System.out.println("Mode debug");
			System.out.println("La combinaison est " + instanceMethodesOutils.combinaisonTexte(combinaisonIA) + ".");
		}

		// Appelle sucessif des méthodes de tourJoueur et de tourIA
		if(instanceMethodesOutils.zeroUn() == 1)
		{
			System.out.println("Le joueur joue en premier.");
			System.out.println();
			do
			{
				coups++;
				System.out.println("Tour " + coups);

				// On appelle tourJoueur
				valideJoueur = tourJoueur(combinaisonIA, proposition);

				// On appelle tourIA
				valideIA = tourIA(combinaisonJoueur, proposition, min, max);

				// On saute une ligne pour l'affichage
				System.out.println();			
			}while(valideJoueur != combinaisonJoueur.length && valideIA != combinaisonIA.length);
		}
		else
		{
			System.out.println("L'IA joue en premier.");
			System.out.println();
			do
			{
				coups++;
				System.out.println("Tour " + coups);

				// On appelle tourIA
				valideIA = tourIA(combinaisonJoueur, proposition, min, max);

				// On appelle tourJoueur
				valideJoueur = tourJoueur(combinaisonIA, proposition);

				// On saute une ligne pour l'affichage
				System.out.println();
			}while(valideJoueur != combinaisonIA.length && valideIA != combinaisonJoueur.length);
		}
		if(valideJoueur == combinaisonIA.length && valideIA == combinaisonJoueur.length)
		{
			System.out.println("Match nul en " + coups + " coups.");			
		}
		else if(valideJoueur == combinaisonIA.length)
		{
			System.out.println("Tu as gagné en " + coups + " coups.");
		}
		else if(valideIA == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagné en " + coups + " coups, sa combinaison était " + instanceMethodesOutils.combinaisonTexte(combinaisonIA) + ".");
		}
		System.out.println();

		// Log pour afficher le début de la méthode
		LogOutil.LOGGER.trace("Fin de la méthode Duel de la classe RecherchePlusMoins.");
	}

	// Méthode de tour
	protected byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Affichage du jeu
		System.out.println("\tJoueur");

		// Lis l'entrée de l'utilisateur
		System.out.print("\t\tLe joueur propose ");
		instanceEntreeUtilisateur.lisCombinaison(pProposition, 9);	

		// On affiche la réponse à la proposition du joueur
		System.out.print("\t\tRéponse ");
		return instanceMethodesOutils.afficheReponseR(pCombinaisonIA, pProposition);
	}

	protected byte tourIA(byte pCombinaisonJoueur[], byte pProposition[], byte pMin[], byte pMax[]) {
		// Affichage du jeu
		System.out.println("\tIA");

		// L'IA joue
		joueIA(pCombinaisonJoueur, pProposition, pMin, pMax);

		// On affiche la proposition de l'IA
		System.out.println("\t\tL'IA propose " + instanceMethodesOutils.combinaisonTexte(pProposition));

		// On affiche la réponse à la proposition de l'IA
		System.out.print("\t\tRéponse ");
		return instanceMethodesOutils.afficheReponseR(pCombinaisonJoueur, pProposition);
	}

	protected void joueIA(byte pCombinaisonJoueur[], byte pProposition[], byte pMin[], byte pMax[]) {
		for(int i = 0; i < pCombinaisonJoueur.length ; i++)
		{
			pProposition[i] = (byte) (Math.round((pMin[i] + pMax[i]) / 2));

			if(pProposition[i] < pCombinaisonJoueur[i])
			{
				pMin[i] = (byte) (pProposition[i] + 1);
			}
			else if(pProposition[i] > pCombinaisonJoueur[i])
			{
				pMax[i] = (byte) (pProposition[i] - 1);
			}
			else
			{
				pMin[i] = pProposition[i];
				pMax[i] = pProposition[i];
			}
		}
	}
}
