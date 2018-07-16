package com.abc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.logoutil.LogOutil;

public class Abc {
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
		byte valide = 0;
		byte malPlace = 0;
		
		ArrayList<Integer> liste = new ArrayList<Integer>();
		boolean dansLaListe = false;

		for(int i = 0; i < pCombinaison.length; i++)
		{
			// On vérifie si un chiffre de la proposition est bonne
			if(pProposition[i] == pCombinaison[i])
			{
				/*
				 * Logs pas clair
				 */
				// Log
				LogOutil.LOGGER.trace("Test A pProposition[i] == pCombinaison[i] -> pProposition[" + i + "] == pCombinaison[" + i + "] -> " + pProposition[i] + " == " + pCombinaison[i] + ".");
				valide++;
			}
			// Sinon
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					// On vérifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j])
					{
						// Log
						LogOutil.LOGGER.trace("Test B pProposition[i] == pCombinaison[j] -> pProposition[" + i + "] == pCombinaison[" + j + "] -> " + pProposition[i] + " == " + pCombinaison[j] + ".");
						
						/*
						 * On verifie que le nième chiffre de la proposition n'est pas égale au nième chiffre de la combinaison
						 * car si un nième chiffre de la proposition est égale au nième chiffre de la combinaison
						 * c'est l'affaire du premier if avant le else
						 */
						if(pProposition[j] != pCombinaison[j])
						{
							// Log
							LogOutil.LOGGER.trace("Test C pProposition[j] != pCombinaison[j] -> pProposition[" + j + "] != pCombinaison[" + j + "] -> " + pProposition[j] + " != " + pCombinaison[j] + ".");
							
							// On met faux dans dansLaListe avant de faire défiller la liste 
							dansLaListe = false;
							for(int k = 0; k < liste.size(); k++)
							{
								// Et enfin si le chiffre est dans la liste des chiffres on met vrai dans dansLaListe
								if(liste.get(k) == pProposition[i])
								{
									// Log
									LogOutil.LOGGER.trace("Test D liste.get(k) == pProposition[i] -> liste.get(" + k + ") == pProposition[" + i + "] -> " + liste.get(k) + " == " + pProposition[i] + ".");
									dansLaListe = true;									
								}
							}
							// Si dans la liste est faux on ajoute le chiffre de la proposition à la liste et on ajoute 1 à malPlace 
							if(dansLaListe == false)
							{
								// Log
								LogOutil.LOGGER.trace("Test E dansLaListe == false -> " + dansLaListe + " == " + false + ".");
								liste.add((int)pProposition[i]);
								malPlace++;
							}
						}
					}
				}
			}
		}
		System.out.println("Il y a " + valide + " chiffres bien placé et " + malPlace + " mal placé.");

		return valide;
	}
	
	// Affiche la réponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public void afficheReponseM(byte pCombinaison[], byte pProposition[], MastermindVariable pMesNouvellesVariables) {
		// Déclaration de variable
			
		ArrayList<Integer> liste = new ArrayList<Integer>();
		boolean dansLaListe = false;

		for(int i = 0; i < pCombinaison.length; i++)
		{
			// On vérifie si un chiffre de la proposition est bonne
			if(pProposition[i] == pCombinaison[i])
			{
				// Log
				LogOutil.LOGGER.trace("Test A pProposition[i] == pCombinaison[i] -> pProposition[" + i + "] == pCombinaison[" + i + "] -> " + pProposition[i] + " == " + pCombinaison[i] + ".");
				pMesNouvellesVariables.valide++;;
			}
			// Sinon
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					// On vérifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j])
					{
						// Log
						LogOutil.LOGGER.trace("Test B pProposition[i] == pCombinaison[j] -> pProposition[" + i + "] == pCombinaison[" + j + "] -> " + pProposition[i] + " == " + pCombinaison[j] + ".");
						
						/*
						 * On verifie que le nième chiffre de la proposition n'est pas égale au nième chiffre de la combinaison
						 * car si un nième chiffre de la proposition est égale au nième chiffre de la combinaison
						 * c'est l'affaire du premier if avant le else
						 */
						if(pProposition[j] != pCombinaison[j])
						{
							// Log
							LogOutil.LOGGER.trace("Test C pProposition[j] != pCombinaison[j] -> pProposition[" + j + "] != pCombinaison[" + j + "] -> " + pProposition[j] + " != " + pCombinaison[j] + ".");
							
							// On met faux dans dansLaListe avant de faire défiller la liste 
							dansLaListe = false;
							for(int k = 0; k < liste.size(); k++)
							{
								// Et enfin si le chiffre est dans la liste des chiffres on met vrai dans dansLaListe
								if(liste.get(k) == pProposition[i])
								{
									// Log
									LogOutil.LOGGER.trace("Test D liste.get(k) == pProposition[i] -> liste.get(" + k + ") == pProposition[" + i + "] -> " + liste.get(k) + " == " + pProposition[i] + ".");
									dansLaListe = true;									
								}
							}
							// Si dans la liste est faux on ajoute le chiffre de la proposition à la liste et on ajoute 1 à malPlace 
							if(dansLaListe == false)
							{
								// Log
								LogOutil.LOGGER.trace("Test E dansLaListe == false -> " + dansLaListe + " == " + false + ".");
								liste.add((int)pProposition[i]);
								pMesNouvellesVariables.malPlace++;
							}
						}
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
		
	// Récupère une entrée de l'utilisateur est la converti en un tableaux de byte
	/*
	 * Proposition
	 * pas inférieur à 0
	 * pas supérieur à max * 1_111
	 */
	public void lisCombinaison(byte pNombre[]) {
		// Déclaration de variable
		short entreeUtilisateur = 0;
		entreeUtilisateur = entree();
		
		// Convertion en un tableaux de byte de l'entrée
		for(int i = 0; i < pNombre.length; i++)
		{				
			pNombre[i] = (byte) (entreeUtilisateur / Math.pow(10, (pNombre.length - (i + 1))));
			entreeUtilisateur -= pNombre[i] * Math.pow(10, (pNombre.length - (i + 1)));
		}
	}
	
	// Récupère un entrée de l'utilisateur
	public short entree() {
		// Déclaration de variable
		Scanner clavier = new Scanner(System.in);
		short entreeUtilisateur = 0;
		
		Boolean estShort = false;
		
		while(estShort != true)
		{
			try
			{
				// Récupération d'une entrée utilisateur
				entreeUtilisateur = clavier.nextShort();
				estShort = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("What");
				LogOutil.LOGGER.trace("InputMismatchException -> " + e.getMessage());
				clavier.next();
				System.out.println("Veuillez entrer une valeur valide");
			}
		}
		
		// On retourne un short
		return entreeUtilisateur;
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
		
		//On met les chiffres dans un ordre aléatoire
		reglageListeHasard(pChiffrePossible, pNombreValeur);
		
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
	
	public void guereMastermindVariable(MastermindVariable pMesNouvellesVariables, MastermindVariable pMesAnciennesVariables) {
		pMesAnciennesVariables.valide = pMesNouvellesVariables.valide;
		pMesAnciennesVariables.malPlace = pMesNouvellesVariables.malPlace;
		pMesNouvellesVariables.valide = 0;
		pMesNouvellesVariables.malPlace = 0;
	}
}