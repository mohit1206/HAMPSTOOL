package com.ctli.it.steps;

import java.io.IOException;
import java.util.Properties;

import com.ctli.it.excel.ExcelUtils;
import com.ctli.it.library.Page;
import com.ctli.it.pages.ExtendingPage;
import com.ctli.it.pages.UtilityPage;

import net.thucydides.core.annotations.Step;

import static org.junit.Assert.fail;

public class UtilitySteps extends ExtendingSteps {
	
	UtilityPage upage;
    @Step
	public void ExcelWrite(String sheetName) throws Throwable
	{
		
			upage.method(sheetName);
		
	
	}
	
}
