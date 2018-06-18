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
	
	// Affiche la r�ponse du recherche + ou - et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseR(byte pCombinaison[], byte pProposition[]) {
		// D�claration de variable
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
	
	// Affiche la r�ponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseM(byte pCombinaison[], byte pProposition[]) {
		// D�claration de variable
		byte valide = 0;
		byte malPlace = 0;
		
		ArrayList<Integer> liste = new ArrayList<Integer>();
		boolean dansLaListe = false;

		for(int i = 0; i < pCombinaison.length; i++)
		{
			// On v�rifie si un chiffre de la proposition est bonne
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
					// On v�rifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j])
					{
						// Log
						LogOutil.LOGGER.trace("Test B pProposition[i] == pCombinaison[j] -> pProposition[" + i + "] == pCombinaison[" + j + "] -> " + pProposition[i] + " == " + pCombinaison[j] + ".");
						
						/*
						 * On verifie que le ni�me chiffre de la proposition n'est pas �gale au ni�me chiffre de la combinaison
						 * car si un ni�me chiffre de la proposition est �gale au ni�me chiffre de la combinaison
						 * c'est l'affaire du premier if avant le else
						 */
						if(pProposition[j] != pCombinaison[j])
						{
							// Log
							LogOutil.LOGGER.trace("Test C pProposition[j] != pCombinaison[j] -> pProposition[" + j + "] != pCombinaison[" + j + "] -> " + pProposition[j] + " != " + pCombinaison[j] + ".");
							
							// On met faux dans dansLaListe avant de faire d�filler la liste 
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
							// Si dans la liste est faux on ajoute le chiffre de la proposition � la liste et on ajoute 1 � malPlace 
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
		System.out.println("Il y a " + valide + " chiffres bien plac� et " + malPlace + " mal plac�.");

		return valide;
	}
	
	// Affiche la r�ponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseM(byte pCombinaison[], byte pProposition[], byte pMalPlace[]) {
		// D�claration de variable
		byte valide = 0;
		byte malPlace = 0;
			
		ArrayList<Integer> liste = new ArrayList<Integer>();
		boolean dansLaListe = false;

		for(int i = 0; i < pCombinaison.length; i++)
		{
			// On v�rifie si un chiffre de la proposition est bonne
			if(pProposition[i] == pCombinaison[i])
			{
				// Log
				LogOutil.LOGGER.trace("Test A pProposition[i] == pCombinaison[i] -> pProposition[" + i + "] == pCombinaison[" + i + "] -> " + pProposition[i] + " == " + pCombinaison[i] + ".");
				valide++;
			}
			// Sinon
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					// On v�rifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j])
					{
						// Log
						LogOutil.LOGGER.trace("Test B pProposition[i] == pCombinaison[j] -> pProposition[" + i + "] == pCombinaison[" + j + "] -> " + pProposition[i] + " == " + pCombinaison[j] + ".");
						
						/*
						 * On verifie que le ni�me chiffre de la proposition n'est pas �gale au ni�me chiffre de la combinaison
						 * car si un ni�me chiffre de la proposition est �gale au ni�me chiffre de la combinaison
						 * c'est l'affaire du premier if avant le else
						 */
						if(pProposition[j] != pCombinaison[j])
						{
							// Log
							LogOutil.LOGGER.trace("Test C pProposition[j] != pCombinaison[j] -> pProposition[" + j + "] != pCombinaison[" + j + "] -> " + pProposition[j] + " != " + pCombinaison[j] + ".");
							
							// On met faux dans dansLaListe avant de faire d�filler la liste 
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
							// Si dans la liste est faux on ajoute le chiffre de la proposition � la liste et on ajoute 1 � malPlace 
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
		System.out.println("Il y a " + valide + " chiffres bien plac� et " + malPlace + " mal plac�.");
		
		// On recup�re malPlace grace au "pointeur" pMalPlace
		pMalPlace[0] = malPlace;

		return valide;
	}
	
	// Renvoie 0 ou 1 de fa�on al�atoire
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
		
	// R�cup�re une entr�e de l'utilisateur est la converti en un tableaux de byte
	/*
	 * Proposition
	 * pas inf�rieur � 0
	 * pas sup�rieur � max * 1_111
	 */
	public void lisCombinaison(byte pNombre[]) {
		// D�claration de variable
		short entreeUtilisateur = 0;
		entreeUtilisateur = entree();
		
		// Convertion en un tableaux de byte de l'entr�e
		for(int i = 0; i < pNombre.length; i++)
		{				
			pNombre[i] = (byte) (entreeUtilisateur / Math.pow(10, (pNombre.length - (i + 1))));
			entreeUtilisateur -= pNombre[i] * Math.pow(10, (pNombre.length - (i + 1)));
		}
	}
	
	// R�cup�re un entr�e de l'utilisateur
	protected short entree() {
		// D�claration de variable
		Scanner clavier = new Scanner(System.in);
		short entreeUtilisateur = 0;
				
		try
		{
			// R�cup�ration d'une entr�e utilisateur
			entreeUtilisateur = clavier.nextShort();
			return entreeUtilisateur;
		}
		catch(InputMismatchException e)
		{
			clavier.next();
			return 0;
		}
	}
	
	// G�n�re une combianaison
	public void genereCombinaison(byte pCombi[]) {
		for(int i = 0; i < pCombi.length; i++)
		{
			pCombi[i] = (byte) Math.round(Math.random() * 9);
		}
	}
	
	// G�n�re une combinaison avec valeur max
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
	
	protected void reglageMinMax(byte pMin[], byte pMax[], byte pValeurMax) {
		for(int i = 0; i < pMin.length; i++)
		{
			pMin[i] = 0;
			pMax[i] = pValeurMax;
		}
	}
	
	public void reglageListePossible(ArrayList <ArrayList <Integer>> pListesPossibles, int pTailleCombinaison, byte pNombreValeur) {		
		/*
		 * Pour avoir plus tard  une liste avec les chiffres dans le d�sordre
		 * Cr�er une ArrayList d'Integer listeHasard avec les chiffres au hasard
		 * Remplacer
		 * 		les "listeTampon.add(0);" par "listeTampon.add(listeHasard.get(0));"
		 * 		et les "listeTampon.add(unNombre);" par "listeTampon.add(listeHasard.get(unNombre));"
		 */
		ArrayList <Integer> listeHasard = new ArrayList <Integer>();
		
		reglageListeHasard(listeHasard, pNombreValeur);
		
		for(int i = 0; i < Math.pow(pNombreValeur, pTailleCombinaison); i++)
		{
			String strTampon = new String();
			ArrayList <Integer> liste = new ArrayList <Integer>();
			
			strTampon = Integer.toString(Integer.parseInt(Integer.toString(i), 10), pNombreValeur);
			strTampon = String.format("%1$" + pTailleCombinaison + "s", strTampon).replace(" ", "0");
			
			for(int j = 0; j < pTailleCombinaison; j++)
			{
				liste.add(listeHasard.get((int) strTampon.charAt(j) - 48));
			}
			
			/*
			 * Affichage
			 */
			for(int j = 0; j < liste.size(); j++)
			{
				System.out.print(liste.get(j));
			}
			System.out.println();
			
			pListesPossibles.add(liste);
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
}