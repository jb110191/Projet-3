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
	 * M�thode
	 */
	// M�thode des modes de jeux
	void Challenger();
	void Defenseur();
	void Duel();
}
