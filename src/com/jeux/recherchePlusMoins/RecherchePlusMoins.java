package com.jeux.recherchePlusMoins;

import com.jeux.Jeux;
import com.logoutil.LogOutil;
import com.outils.ReglageMinMax;

public class RecherchePlusMoins implements Jeux {
	/*
	 * Variable de classe
	 */
	
	AfficheReponseR instanceAfficheReponseR = new AfficheReponseR();
	ReglageMinMax instanceReglageMinMax =  new ReglageMinMax();
	

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

	public void challenger () {
		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Début de la méthode Challenger de la classe RecherchePlusMoins.");

		// Déclaration de variable
		byte combinaisonIA[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte proposition[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte valideJoueur = 0;
		int coups = 0;

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Challenger");
		System.out.println("Trouver la combinaison de l'IA en moins de " + instanceProprieteApplication.getCoupsMax() + " coups");
		System.out.println();

		// Génération d'une combinaison
		instanceGenereCombinaison.genereCombinaison(combinaisonIA);

		// Affichage de la combinaison en mode Debug
		if(LogOutil.instanceLogger.isDebugEnabled() == true)
		{
			instanceMethodesOutils.affichageDebug(combinaisonIA);
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
		}while(valideJoueur != combinaisonIA.length && coups < instanceProprieteApplication.getCoupsMax());

		if(valideJoueur == combinaisonIA.length)
		{
			System.out.println("Tu as gagné en " + coups + " coups.");
		}
		else
		{
			System.out.println("Tu as perdu, la combinaison de l'IA était " + instanceCombinaisonTexte.combinaisonTexte(combinaisonIA) + ".");
		}
		System.out.println();

		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Fin de la méthode Challenger de la classe RecherchePlusMoins.");
	}

	public void defenseur() {
		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Début de la méthode Defenseur de la classe RecherchePlusMoins.");

		// Déclaration de variable
		String texteChoix = "";
		byte combinaisonJoueur[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte proposition[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte min[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte max[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte valideIA = 0;
		int coups = 0;

		texteChoix += "\tTapes une suite de " + combinaisonJoueur.length + " chiffres avec des chiffres de 0 à 9, ce sera ta combinaison.\n";
		texteChoix += "\t\t";

		// On règle les valeurs minimals et maximals de la combinaison
		instanceReglageMinMax.reglageMinMax(min, max);

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Défenseur");
		System.out.println("L'IA doit trouvé la combinaison du joueur en moins de " + instanceProprieteApplication.getCoupsMax() + " coups");
		System.out.println();

		// On demande au joueur de rentrer un combinaison
		System.out.print(texteChoix);
		instanceEntreeUtilisateur.lisCombinaison(combinaisonJoueur, 9, texteChoix);
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
		}while(valideIA != combinaisonJoueur.length && coups < instanceProprieteApplication.getCoupsMax());

		if(valideIA == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagné en " + coups + " coups.");
		}
		else
		{
			System.out.println("L'IA a perdu.");
		}
		System.out.println();

		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Fin de la méthode Defenseur de la classe RecherchePlusMoins.");
	}

	public void duel () {
		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Début de la méthode Duel de la classe RecherchePlusMoins.");

		// Déclaration de variable
		String texteChoix = "";
		byte combinaisonJoueur[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte combinaisonIA[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte proposition[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte min[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte max[] = new byte[instanceProprieteApplication.getTailleCombinaison()];
		byte valideJoueur = 0;
		byte valideIA = 0;
		int coups = 0;

		texteChoix += "\tTapes une suite de " + combinaisonJoueur.length + " chiffres avec des chiffres de 0 à 9, ce sera ta combinaison.\n";
		texteChoix += "\t\t";

		// On règle les valeurs minimals et maximals de la combinaison
		instanceReglageMinMax.reglageMinMax(min, max);

		/*
		 * A mettre dans selection de jeux ?
		 * On affiche le jeu et le mode
		 */
		System.out.println("Recherche Plus ou Moins : Duel");
		System.out.println("Trouver la combinaison de l'IA avant qu'elle ne trouve la tienne.");
		System.out.println();

		// La combinaison de l'IA est gèneré et on en demande une au joueur
		instanceGenereCombinaison.genereCombinaison(combinaisonIA);

		// On demande au joueur de rentrer un combinaison
		System.out.print(texteChoix);
		instanceEntreeUtilisateur.lisCombinaison(combinaisonJoueur, 9, texteChoix);
		System.out.println();

		// Affichage de la combinaison en mode Debug
		if(LogOutil.instanceLogger.isDebugEnabled() == true)
		{
			instanceMethodesOutils.affichageDebug(combinaisonIA);
		}

		// Appelle sucessif des méthodes de tourJoueur et de tourIA
		if(instanceZeroUn.zeroUn() == 1)
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
			}while(valideJoueur != combinaisonJoueur.length && valideIA != combinaisonIA.length && coups < instanceProprieteApplication.getCoupsMax());
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
			}while(valideJoueur != combinaisonIA.length && valideIA != combinaisonJoueur.length && coups < instanceProprieteApplication.getCoupsMax());
		}

		if(valideJoueur == combinaisonIA.length && valideIA != combinaisonJoueur.length)
		{
			System.out.println("Tu as gagné en " + coups + " coups.");
		}
		else if(valideJoueur != combinaisonIA.length && valideIA == combinaisonJoueur.length)
		{
			System.out.println("L'IA a gagné en " + coups + " coups, sa combinaison était " + instanceCombinaisonTexte.combinaisonTexte(combinaisonIA) + ".");
		}
		else
		{
			System.out.println("Match nul en " + coups + " coups, la combinaison de l'IA était " + instanceCombinaisonTexte.combinaisonTexte(combinaisonIA) + ".");			
		}
		System.out.println();

		// Log pour afficher le début de la méthode
		LogOutil.instanceLogger.trace("Fin de la méthode Duel de la classe RecherchePlusMoins.");
	}

	// Méthode de tour
	protected byte tourJoueur(byte pCombinaisonIA[], byte pProposition[]) {
		// Variable
		String texteChoix = "";

		texteChoix +="\tJoueur\n";
		texteChoix += "\t\tLe joueur propose ";

		// Affichage du jeu
		System.out.print(texteChoix);

		// Lis l'entrée de l'utilisateur
		instanceEntreeUtilisateur.lisCombinaison(pProposition, 9, texteChoix);

		// On affiche la réponse à la proposition du joueur
		System.out.print("\t\tRéponse ");
		return instanceAfficheReponseR.afficheReponseR(pCombinaisonIA, pProposition);
	}

	protected byte tourIA(byte pCombinaisonJoueur[], byte pProposition[], byte pMin[], byte pMax[]) {
		// Affichage du jeu
		System.out.println("\tIA");

		// L'IA joue
		joueIA(pCombinaisonJoueur, pProposition, pMin, pMax);

		// On affiche la proposition de l'IA
		System.out.println("\t\tL'IA propose " + instanceCombinaisonTexte.combinaisonTexte(pProposition));

		// On affiche la réponse à la proposition de l'IA
		System.out.print("\t\tRéponse ");
		return instanceAfficheReponseR.afficheReponseR(pCombinaisonJoueur, pProposition);
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
