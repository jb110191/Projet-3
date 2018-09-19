package com.outils;

public class MethodesOutils {
	/*
	 * Variable de classe
	 */

	static CombinaisonTexte instanceCombinaisonTexte = new CombinaisonTexte();

	public void affichageDebug(byte pCombinaisonIA[]) {
		System.out.println("Mode debug");
		System.out.println("La combinaison est " + instanceCombinaisonTexte.combinaisonTexte(pCombinaisonIA) + ".");
		System.out.println();
	}
}