package com.reglageListe;

import java.util.ArrayList;

public class ReglageListeOrdre {
	public void reglageListeOrdre(ArrayList<Integer> pChiffrePossible, byte pNombreValeur) {
		for(int i = 0; i < pNombreValeur; i++)
		{
			pChiffrePossible.add(i);
		}
	}
}
