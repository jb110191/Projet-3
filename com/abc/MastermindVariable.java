package com.abc;

public class MastermindVariable {
	/*
	 * Variable de classe
	 */
	
	// valide et malPlace
	public byte valide;
	public byte malPlace;
	
	/*
	 * Constructeur
	 */
	
	// Constructeur sans paramètres
	public MastermindVariable() {
		valide = 0;
		malPlace = 0;
	}
	
	/*
	 * Méthode
	 */
	
	// 
	public byte getValide() {
		return this.valide;
	}
	
	public byte getMalPlace() {
		return this.malPlace;
	}
	
	public void setValide(byte pValide) {
		this.valide = pValide;
	}
	
	public void setMalPlace(byte pMalPlace) {
		this.malPlace = pMalPlace;
	}
	
	public void setMastermindVariable(byte pValide, byte pMalPlace) {
		this.valide = pValide;
		this.malPlace = pMalPlace;
	}
}
