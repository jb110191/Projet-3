package com.reglageListe;

import java.util.ArrayList;

public class ReglageListeHasard {
	public void reglageListeHasard(ArrayList<Integer> pListeHasard, byte pNombreValeur) {
		ArrayList <Integer> listeTampon = new ArrayList <Integer>();

		for(int i = 0; i < pNombreValeur; i++)
		{
			listeTampon.add(i);
		}

		while(listeTampon.size() != 0)
		{			
			int hazard = (int) (Math.random() * listeTampon.size()) % (listeTampon.size() + 1);
			pListeHasard.add(listeTampon.get(hazard));
			listeTampon.remove(hazard);
		}
	}
}
