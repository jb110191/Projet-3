package com.outils;

import com.logoutil.LogOutil;

public class ParametresLancement {
	public void gereParametreApplication(String pArgs[]) {
		// Variable
		LogOutil monLogOutil = new LogOutil();

		try
		{
			monLogOutil.gereLogOutil(pArgs[0]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			monLogOutil.gereLogOutil();
		}
	}
}
