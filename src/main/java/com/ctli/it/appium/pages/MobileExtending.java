package com.ctli.it.appium.pages;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.webdriver.WebDriverFacade;

public class MobileExtending extends Pages {
	
	public AndroidDriver getAndroidDriver()
	{
		WebDriver facade = getDriver();
		WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
		AndroidDriver a1 = (AndroidDriver)driver;
		return a1;
		
	}
	
	public void verticalScroll()
	{
		 AndroidElement list = (AndroidElement) getAndroidDriver().findElement(By.name("Coming Soon"));
	     MobileElement listGroup = list
	             .findElement(MobileBy
	                     .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
	                             + "new UiSelector().text(\"Mom\"));"));
		
	}

}
