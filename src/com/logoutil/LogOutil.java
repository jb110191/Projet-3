package com.logoutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogOutil {

	public static Logger instanceLogger;

	// M�htode guerant le logger
	public void guereLogOutil() {
		instanceLogger = LogManager.getLogger();
	}
	public void guereLogOutil(String nomLogger) {
		instanceLogger = LogManager.getLogger(nomLogger);
	}
}
