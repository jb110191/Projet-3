package com.main;

import com.logoutil.LogOutil;
import com.outils.ProprieteApplication;
import com.outils.EntreeUtilisateur;

public class Main {
	public static void main(String[] args) {

		// Log pour afficher le d�but du programme
		LogOutil.LOGGER.trace("D�but du programme");

		// Affichage de l'entr�e du programme
		System.out.println("Bienvenue dans l'application Recherche +/- ou Mastermind");
		System.out.println();

		//On cr�e un instance ProprieteApplication puis on r�cup�re les propri�t�s
		ProprieteApplication mesProprietes = new ProprieteApplication();
		mesProprietes.recupereProprieteApplication();

		// On demande le mode debug
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			String texteChoix = "";

			EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur();

			// tailleCombinaison
			texteChoix += "Choissisez la taille de la combinaison pour le Recherche +/- et le Mastermind\n";
			texteChoix += "\tValeur de 1 � 8\n";
			texteChoix += "\t\t";
			System.out.print(texteChoix);
			mesProprietes.setTailleCombinaison(instanceEntreeUtilisateur.lisValeur(1, 8, texteChoix));
			System.out.println("");

			// Remise � z�ro de texteChoix
			texteChoix = "";

			// coupsMax
			texteChoix += "Choissisez le nombre de coups maximal pour le Recherche +/- et le Mastermind\n";
			texteChoix += "\tValeur de 1 � 30\n";
			texteChoix += "\t\t";
			System.out.print(texteChoix);
			mesProprietes.setCoupsMax(instanceEntreeUtilisateur.lisValeur(1, 30, texteChoix));
			System.out.println("");

			// Remise � z�ro de texteChoix
			texteChoix = "";

			// nombreValeur
			texteChoix += "Choissisez le nombre de valeur pour le Mastermind\n";
			texteChoix += "\tValeur de 4 � 10\n";
			texteChoix += "\t\t";
			System.out.print(texteChoix);
			mesProprietes.setNombreValeur((byte) instanceEntreeUtilisateur.lisValeur(4, 10, texteChoix));
			System.out.println("");
		}

		// On cr�e une instance de SelectionJeux
		SelectionJeux slctJx = new SelectionJeux();

		// On appelle la m�thode ChoixJeux de la classe SelectionJeux pour faire le choix du jeux 
		slctJx.choixJeux();

		// Affichage de la sortie du programme
		System.out.println("J'esp�re que le jeux t'as amus�.");

		// Log pour afficher la fin du programme
		LogOutil.LOGGER.trace("Fin du programme");
	}
}
