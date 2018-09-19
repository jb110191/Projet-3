package com.jeux.mastermind;

import com.outils.IndicesMastermind;

public class AfficheReponseM {
	// Affiche la r�ponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public byte afficheReponseM(byte pCombinaison[], byte pProposition[]) {
		// D�claration de variable
		IndicesMastermind indice = new IndicesMastermind();
		boolean tabIndice[] = new boolean[pCombinaison.length];

		// On initialise les valeur � faux
		for(int i = 0; i < tabIndice.length; i++)
		{
			tabIndice[i] = false;
		}

		for(int i = 0; i < pCombinaison.length; i++)
		{			
			// On v�rifie si un chiffre de la proposition est bonne
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
					// On v�rifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j] && pProposition[j] != pCombinaison[j] && tabIndice[j] == false)
					{
						indice.malPlace++;
						tabIndice[j] = true;
					}
				}
			}
		}		
		System.out.println("Il y a " + indice.valide + " chiffres bien plac� et " + indice.malPlace + " mal plac�.");

		return indice.valide;
	}

	// Affiche la r�ponse du Mastemind et renvoie le nombre de chiffre de la combinaison qui sont bon
	public void afficheReponseM(byte pCombinaison[], byte pProposition[], IndicesMastermind pMesNouvellesVariables) {
		// D�claration de variable
		boolean tabIndice[] = new boolean[pCombinaison.length];

		// On initialise les valeur � faux
		for(int i = 0; i < tabIndice.length; i++)
		{
			tabIndice[i] = false;
		}

		for(int i = 0; i < pCombinaison.length; i++)
		{			
			// On v�rifie si un chiffre de la proposition est bonne
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
					// On v�rifie si un chiffre de la proposition est dans la combinaison 
					if(pProposition[i] == pCombinaison[j] && pProposition[j] != pCombinaison[j] && tabIndice[j] == false)
					{
						pMesNouvellesVariables.malPlace++;
						tabIndice[j] = true;
					}
				}
			}
		}
		System.out.println("Il y a " + pMesNouvellesVariables.valide + " chiffres bien plac� et " + pMesNouvellesVariables.malPlace + " mal plac�.");
	}
}
