package com.ctli.it.library;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class CustomDriver implements DriverSource {

	@Override
	public WebDriver newDriver() {
		//System.setProperty("webdriver.driver", "Resources/chromedriver.exe");
//		 ChromeOptions options = new ChromeOptions();
//			
//			// added by ab66280
//			// add parameter which will disable the extension
//			options.addArguments("--disable-extensions");
//			//
//			options.addArguments("disable-infobars");
//
//			// options.setBinary(simonProp.getProperty("ChromeDriverLoc"));
//			options.addArguments("start-maximized");
// 
//		 
//		 
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ab73168\\Documents\\My Received Files\\SerenityWorkspace\\HAMPSTEST\\chromedriver.exe");
//      
//		    //return new chro
		    // Add
		  //  return new PhantomJSDriver(ResolvingPhantomJSDriverService.createDefaultService(), capabilities);
		    return new ChromeDriver();
			//return new FirefoxDriver();
	}

	@Override
	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return true;
	}

}
