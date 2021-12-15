package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethodsSelenium {
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	JavascriptExecutor js;
//	
//	 * public static void getDriver(String browserType) { try {
//	 * returnDriver(browserType); driver.manage().deleteAllCookies();
//	 * driver.manage().window().maximize(); }catch(NullPointerException e) {
//	 * e.printStackTrace(); }
//	 * 
//	 * }
	 
	
//	
//	  public static WebDriver returnDriver(String browserValue) {
//	  if(browserValue.equalsIgnoreCase("chrome")){
//	  WebDriverManager.chromedriver().setup(); driver= new ChromeDriver(); } else
//	  if(browserValue.equalsIgnoreCase("firefox")) {
//	  WebDriverManager.firefoxdriver().setup(); driver= new FirefoxDriver(); }else
//	  { System.out.println("Invalid driver Selection"); driver = null; } return
//	  driver; }
//	 
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public WebDriver initializeDriver(String browser) {

		System.out.println("browser value is: " + browser);
       try {
    	   if (browser.equals("chrome")) {
   			WebDriverManager.chromedriver().setup();
   			tlDriver.set(new ChromeDriver());
   		} else if (browser.equals("firefox")) {
   			WebDriverManager.firefoxdriver().setup();
   			tlDriver.set(new FirefoxDriver());
   		} else if (browser.equals("safari")) {
   			tlDriver.set(new SafariDriver());
   		} else {
   			System.out.println("Please pass the correct browser value: " + browser);
   		}
        getDriver().manage().deleteAllCookies();
   		getDriver().manage().window().maximize();
   		
       }catch(Exception e) {
    	   e.printStackTrace();
       }
		
       return getDriver();
	}
	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	public void waitStatementMethod(WebDriver driver, By locator) throws ElementNotVisibleException,NoSuchElementException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitElementToClick(WebDriver driver, By locator)  {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void enterText(WebDriver driver, By locator,String keyString) {
		waitStatementMethod(driver, locator);
		WebElement element = driver.findElement(locator);
		element.sendKeys(keyString);		
	}
	public void clickElement(WebDriver driver, By locator) {
		waitElementToClick(driver, locator);
		WebElement element = driver.findElement(locator);
		element.click();
	}
	public void clickElementJavaScript(WebDriver driver, By locator) {
		waitStatementMethod(driver, locator);
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", locator);
	}
	public void enterTextElementJavaScript(WebDriver driver, By locator,String keyWord) {
		waitStatementMethod(driver, locator);
		WebElement element = driver.findElement(locator);
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+keyWord+"'", element);
	}
	public void scrolllDownPageJavaScript(WebDriver driver, By locator) {
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
	}
	public void selectElementFromDropDown(WebDriver driver, By locator,String ddlValue) {
		waitStatementMethod(driver, locator);
		WebElement element = driver.findElement(locator);
		Select selectObj = new Select(element);
		selectObj.selectByVisibleText(ddlValue);
	}
	public void takescreenShot(WebDriver driver,String pageName) {
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        try {
	            FileUtils.copyFile(screenshot, new File("E:\\New Maven\\screenshots\\"+pageName+".png"));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
	
}
