package com.outils;

public class CombinaisonTexte {
	// Renvoi la combinaison sous forme de texte
	public String combinaisonTexte(byte pCombi[]) {
		String combinaison = "";
		for(int i = 0; i < pCombi.length; i++)
		{
			combinaison += pCombi[i];
		}
		return combinaison;
	}
}
