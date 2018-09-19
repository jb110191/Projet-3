package com.logoutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogOutil {

	public static Logger instanceLogger;

	// Méhtode guerant le logger
	public void gereLogOutil() {
		instanceLogger = LogManager.getLogger();
	}
	public void gereLogOutil(String nomLogger) {
		instanceLogger = LogManager.getLogger(nomLogger);
	}
}
