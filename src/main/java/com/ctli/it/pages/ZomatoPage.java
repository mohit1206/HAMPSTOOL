package com.ctli.it.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ZomatoPage extends ExtendingPage{

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@FindBy(xpath="//a[@title=\"Restaurants in Marathahalli\"]")
	public WebElementFacade restroName;
	@FindBy(xpath="//a[@title=\"Restaurants in Marathahalli\"]//span")
	public WebElementFacade restroCount;
	@FindBy(xpath="//div[contains(text(),'Drinks & nightlife')]")
	public WebElementFacade btn_drinks;
	@FindBy(xpath="(//span[text()='See more'])[1]")
	public WebElementFacade btn_ssemore;
	@FindBy(xpath="//span[contains(text(),'votes')]//span")
	public WebElementFacade noOfVote;
	
	public void clickDrinkNightlife()
	{
		Actions action=new Actions(getDriver());
		action.moveToElement(btn_drinks).build().perform();
		
	}
	public void clickJimiBeerCafe() throws InterruptedException
	{
		boolean flag=false;
		List<WebElement> element = getDriver().findElements(By.xpath("//a[@data-result-type='ResCard_Name']"));
		for(int i=0;i<element.size();i++)
		{
			System.out.println(element.get(i).getText());
			if(element.get(i).getText().contains("Jimi's Beer café "))
			{
				element.get(i).click();
				flag=true;
				break;
			}
		}
		
		if(flag==false)
		{
			$("//i[@class=\"right angle icon\"]").click();
			//Thread.sleep(10000);
			List<WebElement> element1 = getDriver().findElements(By.xpath("//a[@data-result-type='ResCard_Name']"));
			for(int i=0;i<element1.size();i++) {
				System.out.println(element1.get(i).getText());
			if(element1.get(i).getText().equals("Jimi's Beer Cafe"))
			{
				System.out.println("Ankit");
				element1.get(i).click();
				flag=true;
				break;
			}
			
		}}
		
		System.out.println(noOfVote.getText());
		System.out.println($("(//span[contains(text(),'votes')]/../../div[1])[1]//div").getText());
		System.out.println($("(//span[contains(text(),'Reviews')])[1]").getText());
		
		System.out.println($("//div[text()='Average']/..").getText());
		//$("//a[@data-result-type=\"ResCard_Name\" ]")
		$("(//span[contains(text(),'Reviews')])[1]").click();
		
		$("//a[contains(text(),'All Reviews')]").click();
		String s2 = $("//a[contains(text(),'All Reviews')]//span").getText();
		int i=Integer.parseInt(s2);
		 int i1=i/5;
		 for(int j=1;j<i1;j++)
		 {
			 Thread.sleep(5000);
				JavascriptExecutor jse = (JavascriptExecutor)getDriver();
				jse.executeScript("arguments[0].click();", $("//span[contains(text(),'Load More')]"));
			// $("//span[contains(text(),'Load More')]").click();
		 }
	}

	
	

}
