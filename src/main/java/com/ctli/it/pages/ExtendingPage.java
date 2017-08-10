package com.ctli.it.pages;

import java.util.HashMap;

import com.ctli.it.library.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public  class ExtendingPage extends Page implements SetRunData {
	
	private HashMap<String, String> runData;
    private boolean flag=false;
	
	public ExtendingPage() {
		
		if(flag==false) {
		System.out.println("run data");
		runData =  new HashMap<String, String>();
		flag=true;
		}
		else
		{
			
		}
			
	}
	
	public ExtendingPage(String arg1)
	{
		runData =  new HashMap<String, String>();
	}
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getRunData() {
		// TODO Auto-generated method stub
		return runData;
	}

	@Override
	public void setRunData(HashMap<String, String> runData) {
		this.runData = runData;
		
	}

	@Override
	public void addAValueToRunData(String key, String value) {
		runData.put(key, value);
		
	}

	@Override
	public String getRunDataValue(String key) {
		return runData.get(key);
	}

}
