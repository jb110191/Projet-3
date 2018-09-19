package com.outils;

public class GenereCombinaison {
	// Génère une combianaison
	public void genereCombinaison(byte pCombi[]) {
		for(int i = 0; i < pCombi.length; i++)
		{
			pCombi[i] = (byte) Math.round(Math.random() * 9);
		}
	}

	// Génére une combinaison avec valeur max
	public void genereCombinaison(byte pCombi[], byte pMax) {
		for(int i = 0; i < pCombi.length; i++)
		{
			pCombi[i] = (byte) Math.round((Math.random() * pMax));
		}
	}
}
