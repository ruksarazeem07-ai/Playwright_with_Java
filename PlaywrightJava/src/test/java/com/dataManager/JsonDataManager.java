package com.dataManager;


import java.io.FileReader;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataManager {
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> readData(String key, int i) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src\\test\\resources\\FeatureFilesJsonData.json");
		JSONObject jsonObj = (JSONObject) jsonParser.parse(reader);
		JSONArray jsonArray = (JSONArray) jsonObj.get(key);
		return (JSONObject) jsonArray.get(i);
	}
}
