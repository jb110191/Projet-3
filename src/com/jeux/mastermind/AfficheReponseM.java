package com.jeux.mastermind;

import com.outils.IndicesMastermind;

public class AfficheReponseM {
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
}
