package com.ctli.it.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBys;

import com.ctli.it.library.Page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;

public class BookMyShowMobilePage extends Page{

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@FindBy(name="Coming Soon")
	public WebElementFacade btn_ComingSoon;
	@FindBy(name="Vekh Baraatan Challiyan")
	public WebElement link_vekhshow;
	@FindBy(name="Share")
	public WebElement btn_share;
	@FindBy(name="Filters")
	public WebElement btn_Filter;
	@FindBy(name="English")
	public WebElement btn_english;
	@FindBy(name="Hindi")
	public WebElement btn_Hindi;
	@FindBy(name="Apply")
	public WebElement btn_Apply;
	@FindBy(id="com.bt.bms:id/search_src_text")
	public WebElement tbx_search;
	@FindBy(xpath="//android.widget.TextView[@text='Berlin Syndrome']")
	public WebElement btn_berlinsyndrome;
//	@FindBys(id="com.bt.bms:id/view_bottom_item_iv")
//	public WebElement link_berlinshow;
	
	
	/*@FindBy(name="Coming Soon")
	public WebElement btn_ComingSoon;
	@FindBy(name="Coming Soon")
	public WebElement btn_ComingSoon;*/
	
	public void click_ComingSoon()
	{
		//btn_ComingSoon.getImplicitTimeoutInMilliseconds();
		//btn_ComingSoon.isVisible();
		
		//AndroidDriver web = (AndroidDriver) getDriver();
		WebDriver facade = getDriver();
		WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
		//AndroidDriver a2 = (AndroidDriver) driver;
		//a2.closeApp();
		
		
		//AndroidDriver a2 = (AndroidDriver) getDriver();
		
		AndroidDriver a1 = (AndroidDriver)driver;
	System.out.println(	a1.getRemoteAddress()+"remote adree");
	
	
	// AndroidElement list = (AndroidElement) a1.findElement(By.name("Coming Soon"));
     MobileElement listGroup = (AndroidElement) a1
             .findElement(MobileBy
                     .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                             + "new UiSelector().text(\"Mom\"));"));
	
//	TouchActions action0=new TouchActions(a1);
//	action0.scroll(0, 200).build().perform();
		System.out.println(a1.currentActivity());
//		WebDriver driver=getDriver();
//		AndroidDriver a1=(AndroidDriver) driver;
		
		
		
	}

}
