package com.jeux;

import com.abc.Abc;

public interface Jeux {
	/*
	 * Variable de classe
	 */
	static Abc monAbc = new Abc();
	
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
