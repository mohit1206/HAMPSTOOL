package com.ctli.it.library;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctli.it.xml.IntContainerField;
import com.ctli.it.xml.IntDataContainer;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public abstract class Page extends PageObject {

	public static Environment currentEnvironment;
	public static IntDataContainer data;
	public static IntDataContainer envData;
	public static IntDataContainer commonData;
	public static boolean isInitialized = false;
	private static String parentHandle;
	private static String childHandle;

	private AutoPopulate autoPopulate = new AutoPopulate();
	private AutoVerify autoVerify = new AutoVerify();

	public abstract WebElementFacade getUniqueElementInPage();

	public static void initialize() {
		if (!isInitialized) {
			currentEnvironment = Steps.currentEnvironment;
			data = Steps.data;
			envData = Steps.envData;
			commonData = Steps.commonData;
			isInitialized = true;
		}
	}

	public Environment getCurrentEnvironment() {
		return currentEnvironment;
	}

	public void setCurrentEnvironment(Environment env) {
		currentEnvironment = env;
	}

	public void maximize() {
		getDriver().manage().window().maximize();
	}

	public void fillMandatoryFields(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValues();
		autoPopulate.populateValues(page,
				dataContainer.getMandatoryFields());
	}

	public void fillAllFields(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValues();
		autoPopulate.populateValues(page,
				dataContainer.getFields());
	}

	public void fillMandatoryFields(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValues();
		autoPopulate.populateValues(page,
				dataContainer.getMandatoryFields());
	}

	public void fillAllFields(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValues();
		autoPopulate.populateValues(page,
				dataContainer.getFields());
	}

	public void fillMandatoryFieldsFromAllContainers(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValuesForAllContainers();
		autoPopulate.populateValues(page,
				dataContainer.getMandatoryFieldsFromAllContainers());
	}

	public void fillAllFieldsFromAllContainers(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValuesForAllContainers();
		autoPopulate.populateValues(page,
				dataContainer.getFieldsFromAllContainers());
	}

	public void fillMandatoryFieldsFromAllContainers(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValuesForAllContainers();
		autoPopulate.populateValues(page,
				dataContainer.getMandatoryFieldsFromAllContainers());
	}

	public void fillAllFieldsFromAllContainers(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValuesForAllContainers();
		autoPopulate.populateValues(page,
				dataContainer.getFieldsFromAllContainers());
	}
	
	public void fillFields(Page page, List<IntContainerField> fields) {
		autoPopulate.populateValues(page, fields);
	}

	public void verifyMandatoryFields(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValues();
		autoVerify.verifyValues(page,
				dataContainer.getMandatoryFields());
	}

	public void verifyAllFields(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValues();
		autoVerify.verifyValues(page,
				dataContainer.getFields());
	}

	public void verifyMandatoryFieldsFromAllContainers(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValuesForAllContainers();
		autoVerify.verifyValues(page,
				dataContainer.getMandatoryFieldsFromAllContainers());
	}

	public void verifyAllFieldsFromAllContainers(Page page) {
		IntDataContainer dataContainer = commonData.getContainer(page.getClass().getSimpleName());
		dataContainer.setActualValuesForAllContainers();
		autoVerify.verifyValues(page,
				dataContainer.getFieldsFromAllContainers());
	}

	public void verifyMandatoryFields(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValues();
		autoVerify.verifyValues(page,
				dataContainer.getMandatoryFields());
	}

	public void verifyAllFields(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValues();
		autoVerify.verifyValues(page,
				dataContainer.getFields());
	}

	public void verifyMandatoryFieldsFromAllContainers(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValuesForAllContainers();
		autoVerify.verifyValues(page,
				dataContainer.getMandatoryFieldsFromAllContainers());
	}

	public void verifyAllFieldsFromAllContainers(Page page, IntDataContainer dataContainer) {
		dataContainer.setActualValuesForAllContainers();
		autoVerify.verifyValues(page,
				dataContainer.getFieldsFromAllContainers());
	}

	public void verifyCustomFields(Page page, List<IntContainerField> fields) {
		autoVerify.verifyValues(page, fields);
	}

	public static String getDate(String... format) {
		DateFormat dateFormat;
		if (format.length > 0) {
			dateFormat = new SimpleDateFormat(format[0]);
		} else {
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		}
		Date date = new Date();
		return dateFormat.format(date);
	}

	public String getParentHandle() {
		return parentHandle;
	}

	public void setParentHandle() {
		parentHandle = getDriver().getWindowHandle();
	}

	public String getChildHandle() {
		return childHandle;
	}

	public void setChildHandle() {
		for (String winHandle : getDriver().getWindowHandles()) {
			if (!parentHandle.equals(winHandle)) {
				childHandle = winHandle;
				break;
			}
		}
	}

	public void switchToChildWindow() {
		setChildHandle();
		getDriver().switchTo().window(childHandle);
		maximize();
	}

	public void switchToParentWindow() {
		getDriver().switchTo().window(parentHandle);
	}

	public void switchToFrame(String frameName, int... waitTime) {
		WaitForFrameToLoad(frameName, waitTime);
		getDriver().switchTo().frame(frameName);
	}

	public void waitForChildWindowToAppear() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getWindowHandles().size() == 2;
			}
		};
		withTimeoutOf(10, TimeUnit.SECONDS).waitFor(expectation);
	}

	public Wait<WebDriver> Wait(int... waitTime) {
		int waitTimeInSeconds;
		if (waitTime.length > 0) {
			waitTimeInSeconds = waitTime[0];
		} else {
			waitTimeInSeconds = 5;
		}
		return new FluentWait<WebDriver>(getDriver())
				.withTimeout(waitTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(WebDriverException.class);
	}

	public void WaitForPageToLoad(int... waitTime) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		if (waitTime.length > 0) {
			Wait(waitTime).until(expectation);
		} else {
			Wait(30).until(expectation);
		}
	}

	public void WaitForFrameToLoad(final String frameName, int... waitTime) {
		getDriver().switchTo().defaultContent();
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.switchTo().frame(frameName) != null;
			}
		};
		if (waitTime.length > 0) {
			Wait(waitTime).until(expectation);
		} else {
			Wait(30).until(expectation);
		}
		getDriver().switchTo().defaultContent();
	}

	public void shouldExist(Page page, int... waitTime) {
		WaitForPageToLoad(waitTime);
		if (!page.getUniqueElementInPage().isPresent()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		assertThat("User is not in the page : "
				+ page.getClass().getSimpleName(), page
				.getUniqueElementInPage().isVisible());
	}

	public boolean isExist(Page page, int... waitTime) {
		WaitForPageToLoad(waitTime);
		return page.getUniqueElementInPage().isVisible();
	}
//...............Customized WebDriver Method...................
	public void mouseMoveClick(WebElementFacade ele) {
		try {
			shouldBeVisible(ele);
			Actions action = new Actions(getDriver());
			action.moveToElement(ele).click().build().perform();
		} catch (Exception e) {
			fail("Failed mouseMoveClick() with Exception: " + e.getMessage());
		}
	}

	public void mouseHover(WebElementFacade ele) {
		try {
			shouldBeVisible(ele);
			Actions action = new Actions(getDriver());
			action.moveToElement(ele).perform();
			// action.moveToElement(ele).build().perform();
		} catch (Exception e) {
			fail("Failed mouseHover() with Exception: " + e.getMessage());
		}
	}
	
			public void mouseHoverWithJs(WebElementFacade hoverElm)
			{
				try
				{
					 String javaScript = "var evObj = document.createEvent('MouseEvents');"
				                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				                + "arguments[0].dispatchEvent(evObj);";
				        JavascriptExecutor js = (JavascriptExecutor) getDriver();
				        js.executeScript(javaScript, hoverElm);
				        //click(clickElm);
					
				}
				 catch (StaleElementReferenceException sere) {
						System.out.print("StaleElementReferenceException\n");
					} catch (NoSuchElementException nsee) {
						System.out.print("NoSuchElementException\n");
					} catch (Exception e) {
						fail("Failed java script executor with Exception: " + e.getMessage());
					}
			}
			
			public void mouseSelectWithRetry(WebElementFacade hoverElm, WebElementFacade clickElm) {
				int attempts = 0;
				boolean success = false;
				while (attempts < 3) {
					try {
						// System.out.print("attempts = " + attempts + "\n");
						mouseHover(hoverElm);
						//WebDriverWait dWait = new WebDriverWait(driver, 60);
						Actions action = new Actions(getDriver());
						
						action.moveToElement(clickElm).click(clickElm).perform();
						success = true;
					} catch (StaleElementReferenceException sere) {
						System.out.print("StaleElementReferenceException\n");
					} catch (NoSuchElementException nsee) {
						System.out.print("NoSuchElementException\n");
					} catch (Exception e) {
						fail("Failed mouseSelectWithRetry() with Exception: " + e.getMessage());
					}
					if (success)
						break;
					attempts++;
				}
			}
			
			public void mouseSelectWithRetry(WebElementFacade hoverElm1,WebElementFacade hoverElm2, String clickElmName) {
				int attempts = 0;
				boolean success = false;
				while (attempts < 3) {
					try {
						// System.out.print("attempts = " + attempts + "\n");
						mouseHover(hoverElm1);
						WebDriverWait dWait = new WebDriverWait(getDriver(), 60);
						Actions action = new Actions(getDriver());
						hoverElm2 = (WebElementFacade) dWait.until(ExpectedConditions.visibilityOf(hoverElm2));
						action.moveToElement(hoverElm2);
						mouseHover(hoverElm2);
						dWait = new WebDriverWait(getDriver(), 60);
						WebElement clickElm = dWait
								.until(ExpectedConditions.visibilityOfElementLocated(ByName.name(clickElmName)));
						action.moveToElement(clickElm).click(clickElm).perform();
						success = true;
					} catch (StaleElementReferenceException sere) {
						System.out.print("StaleElementReferenceException\n");
					} catch (NoSuchElementException nsee) {
						System.out.print("NoSuchElementException\n");
					} catch (Exception e) {
						fail("Failed mouseSelectWithRetry() with Exception: " + e.getMessage());
					}
					if (success)
						break;
					attempts++;
				}
			}
			
			public void mouseSelectWithRetry(WebElementFacade hoverElm1, WebElementFacade hoverElm2, WebElementFacade hoverElm3 , String clickElmName) {
				int attempts = 0;
				boolean success = false;
				while (attempts < 3) {
					try {
						// System.out.print("attempts = " + attempts + "\n");
						mouseHover(hoverElm1);
						WebDriverWait dWait = new WebDriverWait(getDriver(), 60);
						Actions action = new Actions(getDriver());
						hoverElm2 = (WebElementFacade) dWait.until(ExpectedConditions.visibilityOf(hoverElm2));
						action.moveToElement(hoverElm2);
						
						mouseHover(hoverElm2);
						dWait = new WebDriverWait(getDriver(), 60);
						hoverElm3 = (WebElementFacade) dWait.until(ExpectedConditions.visibilityOf(hoverElm3));
						action.moveToElement(hoverElm3);
						
						mouseHover(hoverElm3);
						dWait = new WebDriverWait(getDriver(), 60);
						WebElement clickElm = dWait.until(ExpectedConditions.visibilityOfElementLocated(ByXPath.xpath(clickElmName)));
						action.moveToElement(clickElm).click(clickElm).perform();
						success = true;
					} catch (StaleElementReferenceException sere) {
						System.out.print("StaleElementReferenceException\n");
					} catch (NoSuchElementException nsee) {
						System.out.print("NoSuchElementException\n");
					} catch (Exception e) {
						fail("Failed mouseSelectWithRetry() with Exception: " + e.getMessage());
					}
					if (success)
						break;
					attempts++;
				}	
			
			
}}