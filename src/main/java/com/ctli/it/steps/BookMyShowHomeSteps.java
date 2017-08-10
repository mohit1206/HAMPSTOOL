package com.ctli.it.steps;

import com.ctli.it.pages.BookMyshowHomePage;
import com.ctli.it.xml.IntDataContainer;

import net.thucydides.core.annotations.Step;

public class BookMyShowHomeSteps extends ExtendingSteps {
	BookMyshowHomePage bhp;
	@Step
	public void homePage()
	{
		System.out.println("In Login Page");
		bhp.openAt("https://in.bookmyshow.com");
		//maximize();
	}
	
	@Step
	public void click_citys() throws InterruptedException

	{
		System.out.println("clicking bangalore");
		bhp.getUniqueElementInPage();
		bhp.clickCity();
		Thread.sleep(6000);
		
		
	}
	@Step
	public void verif_City()
	{
		System.out.println("verify the city");
		bhp.VerifyCity();
	}
	
	@Step
	public void topMovieText()
	{
		System.out.println("get the text of 3 movie");
		bhp.topMovieTextPage();
	}
	@Step
	public void click_SunilGrover()
	{
		System.out.println("clcik on sunil grover show");
		bhp.clcikSunilGroverPage();
		IntDataContainer container = commonData;
		}
	
}
