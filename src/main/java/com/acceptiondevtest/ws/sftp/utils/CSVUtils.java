package com.acceptiondevtest.ws.sftp.utils;

public class CSVUtils {
	
	public static String stringArrayToCSVLine(String[] array) {
		
		return String.join(";", array).concat("\n");
	};
}
