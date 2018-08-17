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
	public int tailleCombinaison;
	public int coupsMax;
	public byte nombreValeur;

	/*
    Pour chaque jeu :
        le nombre de cases de la combinaison secr�te
        le nombre d'essais possibles
    Pour le Mastermind :
        le nombre couleur/chiffre utilisables (de 4 � 10)
	 */

	/*
	 * Constructeur
	 */

	// Constructeur sans param�tre
	public ProprieteApplication ()
	{
		Configurations configs = new Configurations();
		Configuration maConfig;

		try {
			maConfig = configs.properties("config.txt");

			tailleCombinaison = maConfig.getInt("tailleCombinaison");
			coupsMax = maConfig.getInt("coupsMax");
			nombreValeur = maConfig.getByte("nombreValeur");
		} catch (ConfigurationException e) {
			LogOutil.LOGGER.trace("Probl�me lors de la r�cup�ration des propri�t�s de l'application");
		}
	}

	/*
	 * M�thode
	 */

	// 
}
