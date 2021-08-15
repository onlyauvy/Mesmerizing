package util;

import java.text.ParseException;

public class Util {
	
	public static String hasValue1(String key) {
		return ConfigData.properties.getProperty(key);
	}
	
	public static boolean hasValue(String key) {
		
		ConfigData.currentTmpStr= ConfigData.properties.getProperty(key);
		return ConfigData.currentTmpStr == null ? false:true;
	}
	
	
	public static int parseToInteger(String val) throws ParseException {
		try {
			return Integer.parseInt(val.trim());
		}catch(Exception e) {
			e.printStackTrace();
			throw new ParseException("Problem in parsing as Integer : "+val, 3);
		}
	}
	
	public static Boolean parseToBoolean(String val) throws ParseException {
		try {
			return Boolean.parseBoolean(val.trim());
		}catch(Exception e) {
			throw new ParseException("Problem in parsing as boolean : "+val, 2);
		}
	}
	
	public static String getStringValue(String key) throws ParseException{
		if(ConfigData.properties.getProperty(key) == null ||
				ConfigData.properties.getProperty(key).equals("null"))
			return null;
		return ConfigData.properties.getProperty(key).trim();
	}
	
	public static boolean getBooleanValue(String key) throws ParseException{
		return parseToBoolean(ConfigData.properties.getProperty(key.trim()));
	}
	
	public static int getIntegerValue(String key) throws ParseException{
		return parseToInteger(ConfigData.properties.getProperty(key.trim()));
	}
	
	public static int currentTmpValueAsInteger() throws ParseException {
		return parseToInteger(ConfigData.currentTmpStr);
	}
	
	public static boolean currentTmpValueAsBoolean() throws ParseException {
		return parseToBoolean(ConfigData.currentTmpStr);
	}
	
	public static String currentTmpValueAsString() throws ParseException {
		return ConfigData.currentTmpStr;
	}
	
	
	public static String getCommonString(String keyStartWith) {
		if (keyStartWith == null || keyStartWith.isEmpty())
			return keyStartWith;

		String[] keyParts = keyStartWith.split("\\.");
		if (keyParts.length >= 2 && isNumeric(keyParts[1])) {
			keyParts[1] = "common";
		} else if (keyParts.length >= 3 && isNumeric(keyParts[2])) {
			keyParts[2] = "common";
		}

		String str = String.join(".", keyParts);
		return str;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			int d = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
