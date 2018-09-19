package com.reglageListe;

import java.util.ArrayList;

import com.logoutil.LogOutil;

public class ReglageListePossible {
	/*
	 * Variable de classe
	 */
	
	ReglageListeOrdre instanceReglageListeOrdre = new ReglageListeOrdre();
	ReglageListeHasard instanceReglageListeHasard = new ReglageListeHasard();
	
	public void reglageListePossible(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, int pTailleCombinaison, byte pNombreValeur) {		

		//On met les chiffres dans un ordre
		if(LogOutil.instanceLogger.isDebugEnabled() == true)
		{
			instanceReglageListeOrdre.reglageListeOrdre(pChiffrePossible, pNombreValeur);
		}
		else
		{
			instanceReglageListeHasard.reglageListeHasard(pChiffrePossible, pNombreValeur);
		}

		for(int i = 0; i < Math.pow(pNombreValeur, pTailleCombinaison); i++)
		{
			String strTampon = new String();
			ArrayList <Integer> liste = new ArrayList <Integer>();

			strTampon = Integer.toString(Integer.parseInt(Integer.toString(i), 10), pNombreValeur);
			strTampon = String.format("%1$" + pTailleCombinaison + "s", strTampon).replace(" ", "0");

			for(int j = 0; j < pTailleCombinaison; j++)
			{
				liste.add(pChiffrePossible.get((int) strTampon.charAt(j) - 48));
			}
			pListesPossibles.add(liste);
		}
	}
}
