package com.outils;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import com.logoutil.LogOutil;

public class ProprieteApplication {
	/*
	 * Variable de classe
	 */

	//Les propi�t�s r�cup�r� de l'application
	static boolean modeDev;
	static int tailleCombinaison;
	static int coupsMax;
	static byte nombreValeur;

	/*
	 * Constructeur
	 */	

	/*
	 * M�thode
	 */

	// Accesseur
	public boolean getModeDev() {
		return modeDev;
	}
	
	public int getTailleCombinaison() {
		return tailleCombinaison;
	}

	public int getCoupsMax() {
		return coupsMax;
	}

	public byte getNombreValeur() {
		return nombreValeur;
	}

	// Modificateur
	public void setTailleCombinaison(int pTailleCombinaison) {
		tailleCombinaison = pTailleCombinaison;
	}

	public void setCoupsMax(int pCoupsMax) {
		coupsMax = pCoupsMax;
	}

	public void setNombreValeur(byte pNombreValeur) {
		nombreValeur = pNombreValeur;
	}

	/*
    Pour chaque jeu :
        le nombre de cases de la combinaison secr�te
        le nombre d'essais possibles
    Pour le Mastermind :
        le nombre couleur/chiffre utilisables (de 4 � 10)
	 */

	// R�cup�ration des propti�t�s par un fichier .properties
	public  void recupereProprieteApplication ()
	{
		Configurations configs = new Configurations();
		Configuration maConfig;

		try {
			maConfig = configs.properties("config.properties");
			
			modeDev = maConfig.getBoolean("modeDev");
			tailleCombinaison = maConfig.getInt("tailleCombinaison");
			coupsMax = maConfig.getInt("coupsMax");
			nombreValeur = maConfig.getByte("nombreValeur");
		} catch (ConfigurationException e) {
			LogOutil.instanceLogger.trace("Probl�me lors de la r�cup�ration des propri�t�s de l'application");
			modeDev = false;
			tailleCombinaison = 4;
			coupsMax = 10;
			nombreValeur = 4;
		}
	}
}
