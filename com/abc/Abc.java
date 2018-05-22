package com.abc;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
		
		//test
		ArrayList<Integer> liste = new ArrayList<Integer>();
		boolean dansLaListe = false;
				
		/*
		 * Si le chiffre de la proposition est bon -> valide++
		 * Sinon
		 * 		si le chiffre de la proposition est pr�sent dans le reste de combinaison
		 * 			si le chiffre de la proposition est le chiffre de la combinaison n'est pas le m�me
		 * 				si le chiffre n'a pas d�j� �t� propos�
		 */
		
		//test
		System.out.println();

		for(int i = 0; i < pCombinaison.length; i++)
		{
			if(pProposition[i] == pCombinaison[i])
			{
				System.out.println("Test A pProposition[i] == pCombinaison[i] -> pProposition[" + i + "] == pCombinaison[" + i + "] -> " + pProposition[i] + " == " + pCombinaison[i] + ".");
				valide++;
			}
			else
			{
				for(int j = 0;  j < pCombinaison.length; j++)
				{
					if(pProposition[i] == pCombinaison[j])
					{
						System.out.println("Test B pProposition[i] == pCombinaison[j] -> pProposition[" + i + "] == pCombinaison[" + j + "] -> " + pProposition[i] + " == " + pCombinaison[j] + ".");
						if(pProposition[j] != pCombinaison[j])
						{
							System.out.println("Test C pProposition[j] != pCombinaison[j] -> pProposition[" + j + "] != pCombinaison[" + j + "] -> " + pProposition[j] + " != " + pCombinaison[j] + ".");
							// Besoin de sauvegard� le chiffre de la proposition pour v�rifier et ne pars avoir de double ou de triple mal plac�
							dansLaListe = false;
							
							for(int k = 0; k < liste.size(); k++)
							{
								if(liste.get(k) == pProposition[i])
								{
									System.out.println("Test D liste.get(k) == pProposition[i] -> liste.get(" + k + ") == pProposition[" + i + "] -> " + liste.get(k) + " == " + pProposition[i] + ".");
									dansLaListe = true;									
								}
							}
							if(dansLaListe == false)
							{
								System.out.println("Test E dansLaListe == false -> " + dansLaListe + " == " + false + ".");
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
			pCombi[i] = (byte) (Math.random() * 9);
		}
	}
	
	// G�n�re une combinaison avec valeur max
	public void genereCombinaison(byte pCombi[], byte pMax) {
		for(int i = 0; i < pCombi.length; i++)
		{
			pCombi[i] = (byte) (Math.random() * pMax);
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
}