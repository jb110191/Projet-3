package com.outils;

import java.util.ArrayList;

import com.logoutil.LogOutil;

public class MethodesOutils {
	// Affiche la combinaison
	public void afficheCombinaison(byte pCombi[]) {
		for(int i = 0; i < pCombi.length; i++)
		{
			System.out.print(pCombi[i]);
		}
	}

	// Affiche la réponse du recherche + ou - et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseR(byte pCombinaison[], byte pProposition[]) {
		// Déclaration de variable
		byte valide = 0;

		for(int i = 0; i < pCombinaison.length; i++)
		{				
			if(pProposition[i] < pCombinaison[i])
			{
				System.out.print("+");
			}
			else if(pProposition[i] > pCombinaison[i])
			{
				System.out.print("-");
			}
			else
			{
				System.out.print("=");
				valide++;
			}
		}
		System.out.println("");

		return valide;
	}

	// Affiche la réponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseM(byte pCombinaison[], byte pProposition[]) {
		// Déclaration de variable
		IndicesMastermind indice = new IndicesMastermind();
		boolean tabIndice[] = new boolean[pCombinaison.length];

		// On initialise les valeur à faux
		for(int i = 0; i < tabIndice.length; i++)
		{
			tabIndice[i] = false;
		}

		for(int i = 0; i < pCombinaison.length; i++)
		{			
			// On vérifie si un chiffre de la proposition est bonne
			if(pProposition[i] == pCombinaison[i])
			{
				indice.valide++;
				tabIndice[i] = true;
			}
			// Sinon
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					// On vérifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j] && pProposition[j] != pCombinaison[j] && tabIndice[j] == false)
					{
						indice.malPlace++;
						tabIndice[j] = true;
					}
				}
			}
		}		
		System.out.println("Il y a " + indice.valide + " chiffres bien placé et " + indice.malPlace + " mal placé.");

		return indice.valide;
	}

	// Affiche la réponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public void afficheReponseM(byte pCombinaison[], byte pProposition[], IndicesMastermind pMesNouvellesVariables) {
		// Déclaration de variable
		boolean tabIndice[] = new boolean[pCombinaison.length];

		// On initialise les valeur à faux
		for(int i = 0; i < tabIndice.length; i++)
		{
			tabIndice[i] = false;
		}

		for(int i = 0; i < pCombinaison.length; i++)
		{			
			// On vérifie si un chiffre de la proposition est bonne
			if(pProposition[i] == pCombinaison[i])
			{
				pMesNouvellesVariables.valide++;
				tabIndice[i] = true;
			}
			// Sinon
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					// On vérifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j] && pProposition[j] != pCombinaison[j] && tabIndice[j] == false)
					{
						pMesNouvellesVariables.malPlace++;
						tabIndice[j] = true;
					}
				}
			}
		}
		System.out.println("Il y a " + pMesNouvellesVariables.valide + " chiffres bien placé et " + pMesNouvellesVariables.malPlace + " mal placé.");
	}

	// Renvoie 0 ou 1 de façon aléatoire
	public int zeroUn() {
		double nombre = 0.5;
		do
		{
			nombre = Math.random();
			if(nombre < 0.5 || nombre > 0.5)
			{
				Math.round(nombre);
			}											
		}while(nombre == 0.5);
		return (int) nombre;
	}

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

	public void reglageMinMax(byte pMin[], byte pMax[]) {
		for(int i = 0; i < pMin.length; i++)
		{
			pMin[i] = 0;
			pMax[i] = 9;
		}
	}

	public void reglageMinMax(byte pMin[], byte pMax[], byte pValeurMax) {
		for(int i = 0; i < pMin.length; i++)
		{
			pMin[i] = 0;
			pMax[i] = pValeurMax;
		}
	}

	public void reglageListePossible(ArrayList <ArrayList <Integer>> pListesPossibles, ArrayList <Integer> pChiffrePossible, int pTailleCombinaison, byte pNombreValeur) {		

		//On met les chiffres dans un ordre
		if(LogOutil.LOGGER.isDebugEnabled() == true)
		{
			reglageListeOrdre(pChiffrePossible, pNombreValeur);
		}
		else
		{
			reglageListeHasard(pChiffrePossible, pNombreValeur);
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

	public void reglageListeOrdre(ArrayList<Integer> pChiffrePossible, byte pNombreValeur) {
		for(int i = 0; i < pNombreValeur; i++)
		{
			pChiffrePossible.add(i);
		}
	}

	public void reglageListeHasard(ArrayList <Integer> pListeHasard, byte pNombreValeur) {
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

	public void guereMastermindVariable(IndicesMastermind pMesNouvellesVariables, IndicesMastermind pMesAnciennesVariables) {
		pMesAnciennesVariables.valide = pMesNouvellesVariables.valide;
		pMesAnciennesVariables.malPlace = pMesNouvellesVariables.malPlace;
		pMesNouvellesVariables.valide = 0;
		pMesNouvellesVariables.malPlace = 0;
	}
}