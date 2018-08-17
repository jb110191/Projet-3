package com.jeux;

import com.outils.EntreeUtilisateur;
import com.outils.MethodesOutils;

public interface Jeux {
	/*
	 * Variable de classe
	 */

	static MethodesOutils instanceMethodesOutils = new MethodesOutils();
	static EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur ();

	/*
	 * Constructeur
	 */
	//

	/*
	 * Méthode
	 */
	// Méthode des modes de jeux
	void Challenger();
	void Defenseur();
	void Duel();
}
