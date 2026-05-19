package com.dataManager;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class CommonMethods {


	public static String getDetails(String type, int i ,String key) throws IOException, ParseException {
		return JsonDataManager.readData(type, i).get(key);
	}
}
