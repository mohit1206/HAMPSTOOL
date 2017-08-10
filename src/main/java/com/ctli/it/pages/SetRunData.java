package com.ctli.it.pages;

import java.util.HashMap;

public interface SetRunData {
	
	 HashMap<String, String> getRunData();

	  void setRunData(HashMap<String, String> runData);
		
	  void addAValueToRunData(String key, String value);
			
	  String getRunDataValue(String key);	

}
