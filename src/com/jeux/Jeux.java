package com.jeux;

import com.outils.MethodesOutils;

public interface Jeux {
	/*
	 * Variable de classe
	 */
	
	static MethodesOutils mesMethodesOutils = new MethodesOutils();
	
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
