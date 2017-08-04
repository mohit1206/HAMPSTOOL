package com.ctli.it.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	@FindBy(xpath="//a[text()='Gmail']")
	public WebElementFacade btn_Gmail;
	
	
	//#####################################################################//
	
	@FindBy(xpath=".//a[contains(text(),'Bangalore,')]")
	public WebElementFacade btn_bngrg;
	
	@FindBy(xpath=".//*[@class='auth']/a[text()='Login']")
	public WebElementFacade btn_loginto;
	
	@FindBy(xpath=".//*[@name='username']")
	public WebElementFacade tbx_loginname; 
	
	@FindBy(xpath=".//*[@id='password']")
	public WebElementFacade tbx_pwd;
	
	@FindBy(xpath=".//*[text()='LOGIN']")
	public WebElementFacade btn_login;
	
	
	@FindBy(xpath=".//a[contains(text(),'Shop by Category')]")
	public WebElementFacade lbl_shop_category;
	
	/*@FindBy(xpath=".//*[@class='dropdown-menu']//a[text()='Imported & Gourmet']")
	public WebElementFacade lbl_imported_gournet;
	*/
	@FindBy(xpath=".//*[@id='navBarMegaNav']//.[text()='Imported & Gourmet']")
	public WebElementFacade lbl_imported_gournet;
	
	//@FindBy(xpath=".//*[@id='navBarMegaNav']//.[text()='Chocolate & Confectionaries']")
	@FindBy(xpath=".//*[@ng-mouseover='vm.readyToShow = true']/following-sibling::ul//.[@id='imported-gourmet']/div/div/div[1]/ul/li[11]/a")
	public WebElementFacade lbl_choclated;
	
	@FindBy(xpath=".//*[@ng-mouseover='vm.readyToShow = true']/following-sibling::ul//.[@id='imported-gourmet']/div/div/div[2]/div/div/div/div[1]/div/ul/li[10]/a")
	public WebElementFacade lbl_frudge;
	
	
	@FindBy(xpath=".//*[@id='filterbar']//.[text()='Category']")
	public WebElementFacade lbl_filter_categ; 
	
	@FindBy(xpath=".//*[@ng-if='subcategory.display_name']")
	public WebElementFacade lbl_subcategory;
/*	
	.//*[@ng-if="subcategory.display_name"]/a[1]//div[@class="ng-binding ng-scope"]
	
	.//*[@id="filterbar"]//.[@ng-if="subcategory.display_name"]/a[1]//span
	*/
	@FindBy(xpath=".//*[@id='filterbar']//input[@ng-model='vm.brandSearch']")
	public WebElementFacade tbx_brandsearch;/*---D*/
	
	//@FindBy(xpath=".//*[@id='filterbar']//input[@ng-change='vm.onFacetFilterChange(brand,filter.filter_name,filter.filter_slug)']/following-sibling::span/i")
	@FindBy(xpath=".//*[@id='filterbar']/div[4]/div[2]/section/div[2]/label")
	public WebElementFacade chk_brandselect;
	
	@FindBy(xpath=".//*[@id='filterbar']//.[@value='Search by Pack Size']")
	public WebElementFacade tbx_packsize;/*---1*/
	
	
	//@FindBy(xpath=".//*[@id='filterbar']//.[@ng-model='packsize.selected']/following-sibling::span/i")
	@FindBy(xpath=".//*[@id='filterbar']/div[7]/div[2]/section/div[1]/label")
	public WebElementFacade chk_packsize;
	
	/*.//*[@id='dynamicDirective']//.[@class="items ng-scope"]/div[1]//.[@class="save-price ng-scope"]
	
	.//*[@id='dynamicDirective']//.[@class="items ng-scope"]/div[1]//.[@ng-model="vm.startQuantity"]
	
	.//*[@id='dynamicDirective']//.[@class="items ng-scope"]/div[1]//.[@ng-click="vm.addToBasket(vm.selectedProduct);"]
*/	
	@FindBy(xpath=".//*[@id='toast-container']/div/div")
	public WebElementFacade lbl_msg_add;
	
	@FindBy(xpath=".//*[@id='navbar-main']//.[@class='basket-content']")
	public WebElementFacade btn_mybasket; 
	
	@FindBy(xpath=".//*[@id='navbar-main']//.[@ng-click='vm.goToBasketPage(vm.cart.cart_no_items);']")
	public WebElementFacade btn_checkout2;
	
/*	.//*[contains(@class,'yourbasketitems-gridlist')]/div[1]//button[@class="icon icon-decrease-qty-search-popup"]
*/	
	
	@FindBy(xpath=".//*[@id='finalTotal']")
	public WebElementFacade lbl_finalbill;
	
	@FindBy(xpath=".//*[@id='foodTotal']")
	public WebElementFacade lbl_foodcouponbill;
	
	
	
	
	public void Allactionbhp() throws Throwable{
		//Actions action = new Actions(getDriver());
		waitFor(btn_bngrg);
		
		btn_bngrg.click();
		
		waitFor(btn_loginto);
		
		btn_loginto.click();
		
		waitFor(tbx_loginname);
		
		tbx_loginname.sendKeys("pratim09@gmail.com");
		tbx_pwd.sendKeys("TestAutothon2017");
		
		 btn_login.click();
		 
		 waitFor(lbl_shop_category);
		 
		// action.moveToElement(we).moveToElement
		 mouseHover(lbl_shop_category);
		 waitFor(lbl_imported_gournet);
		 mouseHover(lbl_imported_gournet);  
		 waitFor(lbl_choclated);
		 mouseHover(lbl_choclated);
		 waitFor(lbl_frudge);
		 lbl_frudge.click();
		 
		// waitFor(tbx_brandsearch);
		 Thread.sleep(10000);
		 int i=1;
		 while(i!=0){
			 System.out.println(getDriver().findElement(By.xpath(".//*[@id='filterbar']//.[@ng-if='subcategory.display_name']/div["+i+"]//div[@class='ng-binding ng-scope']")).getText());
			 
			 System.out.println(getDriver().findElement(By.xpath(".//*[@id='filterbar']//.[@ng-if='subcategory.display_name']/div["+i+"]//span")).getText());
			 	i++;
			 	 System.out.println("i="+i);
			 if(!isElementVisible(By.xpath(".//*[@id='filterbar']//.[@ng-if='subcategory.display_name']/div["+i+"]"))){
				 break;
			 }
		 
		 }
		 
		// tbx_brandsearch.sendKeys("D"); 
			
			chk_brandselect.click();
			Thread.sleep(5000);
		// tbx_packsize.sendKeys("1");
		
		 chk_packsize.click();
		 Thread.sleep(10000);
		 i=1;
		 while(i!=0){
			 System.out.println(getDriver().findElement(By.xpath(" .//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@class='save-price ng-scope']")).getText());
				
			System.out.println(getDriver().findElement(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@ng-model='vm.startQuantity']")).getText());
			getDriver().findElement(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@ng-model='vm.startQuantity']")).clear();
			getDriver().findElement(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@ng-model='vm.startQuantity']")).sendKeys("2");
			
			System.out.println(getDriver().findElement(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@ng-click='vm.addToBasket(vm.selectedProduct);']")).getText());
			getDriver().findElement(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@ng-click='vm.addToBasket(vm.selectedProduct);']")).click();
			waitFor(lbl_msg_add);
			Thread.sleep(2000);
			i++;
			if(!isElementVisible(By.xpath(".//*[@id='dynamicDirective']//.[@class='items ng-scope']/div["+i+"]//.[@class='save-price ng-scope']"))){
				 break;
			}
		 }
		 
		 btn_mybasket.click();
		 
		 waitFor(btn_checkout2);
		 
		 btn_checkout2.click();
		 
		 waitFor(lbl_finalbill);
		 i=1;
		 while(i!=0){
				getDriver().findElement(By.xpath(".//*[contains(@class,'yourbasketitems-gridlist')]/div["+i+"]//button[@class='icon icon-decrease-qty-search-popup']")).click();
				Thread.sleep(2000);
				i++;
				if(!isElementVisible(By.xpath(".//*[contains(@class,'yourbasketitems-gridlist')]/div["+i+"]//button[@class='icon icon-decrease-qty-search-popup']"))){
					 break;
				}
		 }
		 
		 if(lbl_foodcouponbill.getText().equals(lbl_finalbill.getText())){
			 System.out.println("Passed--Finally");
		 } else {
			 System.out.println("Still Passed--but food coupon gone waste"); 
		 }
		 
	}

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
	
	public void click_ndnkd()
	{
	//click1( btn_Gmail);
	}
}
