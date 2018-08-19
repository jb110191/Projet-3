package com.jeux;

import com.outils.EntreeUtilisateur;
import com.outils.MethodesOutils;
import com.outils.ProprieteApplication;

public interface Jeux {
	/*
	 * Variable de classe
	 */

	static MethodesOutils instanceMethodesOutils = new MethodesOutils();
	static EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur();
	static ProprieteApplication instanceProprieteApplication = new ProprieteApplication();

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
