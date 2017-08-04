package com.ctli.it.steps;

import com.ctli.it.pages.BookMyshowHomePage;
import com.ctli.it.xml.IntDataContainer;

import net.thucydides.core.annotations.Step;

public class BookMyShowHomeSteps extends ExtendingSteps {
	BookMyshowHomePage bhp;
	@Step
	public void homePage(String url) throws Throwable
	{
		//System.out.println(commonData.getContainer(bhp.getClass().getSimpleName()).getFieldValue("tbx_usrname"));
		System.out.println("In Login Page");
		System.out.println("url value"+url);
		//bhp.openAt(bhp.checkParmString(url));
		if(url.equals("bigbasket")){
			bhp.openAt("https://www.bigbasket.com");
			getDriver().manage().window().maximize();
			/*bhp.btn_bngrg.click();
			Thread.sleep(3000);*/
			
			bhp.Allactionbhp();
		} else {
			bhp.openAt("https://www.google.co.in/?gfe_rd=cr&ei=KHV9WaaBFpTT8gfNwa_oDQ");
			bhp.click_ndnkd();
		}
		
		//maximize();
		//System.out.println(commonData.getContainer(bhp.getClass().getSimpleName()).getFieldValue("tbx_usrname"));
	}
	
	@Step
	public void click_citys() throws InterruptedException

	{
		System.out.println("clicking bangalore");
		bhp.getUniqueElementInPage();
		bhp.clickCity();
		Thread.sleep(6000);
		IntDataContainer actualContainer= commonData;
	
		
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
	}
	
}
