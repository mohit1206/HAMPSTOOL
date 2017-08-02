package com.ctli.it.library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public abstract class AppiumPage extends PageObject {
	public abstract WebElementFacade getUniqueElementInPage();
	
	
}
