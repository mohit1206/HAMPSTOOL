package com.ctli.it.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctli.it.pages.BookMyShowMobilePage;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class BookMyShowMobileSteps extends ExtendingSteps {
	BookMyShowMobilePage bhmpa;
	@Step
	public void clickComingSoon() throws InterruptedException
	{
//	WebDriverWait wait=new WebDriverWait(getDriver(), 220);
//	wait.until(ExpectedConditions.visibilityOf(bhmpa.btn_ComingSoon));
//		Thread.sleep(50000);
//		System.out.println(getDriver().getPageSource());
	getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//bhmpa.btn_ComingSoon.click();
		bhmpa.click_ComingSoon();
//		bhmpa.link_vekhshow.click();
//		bhmpa.btn_share.click();
		bhmpa.btn_Filter.click();
		bhmpa.btn_english.click();
		bhmpa.btn_Hindi.click();
		bhmpa.btn_Apply.click();
		getDriver().findElements(By.id("com.bt.bms:id/view_bottom_item_iv")).get(1).click();
		bhmpa.tbx_search.sendKeys("Berlin Syndrome");
		bhmpa.btn_berlinsyndrome.click();
		
	
		
		System.out.println("wait starts");
		Thread.sleep(10000);
		//bhmpa.clickOn(bhmpa.btn_ComingSoon);
		//getDriver().findElements(By.id("com.bt.bms:id/view_bottom_item_iv")).get(1).click();
		
	}

}
