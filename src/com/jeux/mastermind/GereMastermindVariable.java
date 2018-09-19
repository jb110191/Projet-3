package com.jeux.mastermind;

import com.outils.IndicesMastermind;

public class GereMastermindVariable {
	public void gereMastermindVariable(IndicesMastermind pMesNouvellesVariables, IndicesMastermind pMesAnciennesVariables) {
		pMesAnciennesVariables.valide = pMesNouvellesVariables.valide;
		pMesAnciennesVariables.malPlace = pMesNouvellesVariables.malPlace;
		pMesNouvellesVariables.valide = 0;
		pMesNouvellesVariables.malPlace = 0;
	}
}
