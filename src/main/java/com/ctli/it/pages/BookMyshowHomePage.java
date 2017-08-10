package com.ctli.it.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookMyshowHomePage extends ExtendingPage {
	@FindBy(xpath="//a[@title='BookMyShow']")
	public WebElementFacade bmspage;
	
	@FindBy(xpath="//a[text()='Bengaluru']")
	public WebElementFacade citySelection;
	
	@FindBy(id="spnSelectedRegion")
	public WebElementFacade verifyCitySelection;
	
	@FindBy(xpath="//div[div[h2[text()='TOP MOVIES']]]//a")
	public WebElementFacade topmovies;
	
	@FindBy(xpath="//a[text()='Sunil Grover Live']")
	public WebElementFacade sunilShow;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return bmspage;
	} 
	
	public void clickCity()
	{
		citySelection.click();
	}

	public void VerifyCity()
	{
		verifyCitySelection.isPresent();
	}
	
	public void topMovieTextPage()
	{
		waitFor(topmovies);
		
		List<WebElement> elements = getDriver().findElements(By.xpath("//div[div[h2[text()='TOP MOVIES']]]//a"));
		for(int i=0;i<3;i++)
		{
			System.out.println(elements.get(i).getText());
		}
	}
	
	public void clcikSunilGroverPage()
	{
		
		
		//waitFor(sunilShow);
		JavascriptExecutor jsx = (JavascriptExecutor)getDriver();
		jsx.executeScript("window.scrollBy(450,0)", "");
		sunilShow.click();
		
	}
}
