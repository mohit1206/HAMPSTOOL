package com.ctli.it.appium.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public abstract class MustExtendMobilePage extends PageObject {
	public abstract WebElement getUniqueElementInPage();
}
