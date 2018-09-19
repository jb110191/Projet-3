package com.jeux;

import com.outils.CombinaisonTexte;
import com.outils.EntreeUtilisateur;
import com.outils.GenereCombinaison;
import com.outils.MethodesOutils;
import com.outils.ProprieteApplication;
import com.outils.ZeroUn;

public interface Jeux {
	/*
	 * Variable de classe
	 */

	static CombinaisonTexte instanceCombinaisonTexte = new CombinaisonTexte();
	static EntreeUtilisateur instanceEntreeUtilisateur = new EntreeUtilisateur();
	static GenereCombinaison instanceGenereCombinaison = new GenereCombinaison();
	static MethodesOutils instanceMethodesOutils = new MethodesOutils();
	static ProprieteApplication instanceProprieteApplication = new ProprieteApplication();
	static ZeroUn instanceZeroUn = new ZeroUn();

	/*
	 * Constructeur
	 */
	//

	/*
	 * Méthode
	 */
	// Méthode des modes de jeux
	void challenger();
	void defenseur();
	void duel();
}
