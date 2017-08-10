package com.ctli.it.pages;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Properties;

import com.ctli.it.excel.ExcelUtils;
public class UtilityPage  extends ExtendingPage{
	
	public void method(String sheet) throws Throwable
	{

		ExcelUtils util=new ExcelUtils();
		Properties prop = new Properties();
		if(getRunData() != null && getRunData().isEmpty()){
			prop.putAll(getRunData());
		}else{
			fail("No RunData found!");
		}
		
		util.WriteInsertResultToExcel2( prop, sheet);
	
	}

}
