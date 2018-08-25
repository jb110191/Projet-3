package com.outils;

import com.logoutil.LogOutil;

public class ParametresLancement {
	public void guereParametreApplication(String pArgs[]) {
		// Variable
		LogOutil monLogOutil = new LogOutil();

		try
		{
			monLogOutil.guereLogOutil(pArgs[0]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			monLogOutil.guereLogOutil();
		}
	}
}
