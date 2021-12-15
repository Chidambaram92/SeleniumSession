package com.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.utils.CommonMethodsSelenium;

public class HomePage extends CommonMethodsSelenium{
	private WebDriver driver;

	// Declare Page Objects here
	private By siteLogo= By.xpath("//img[@class='logo img-responsive']");
	private By contactUsLink= By.xpath("//a[text()='Contact us']");
	private By signInLink= By.linkText("Sign in");
	private By searchText= By.xpath("//input[@name='search_query']");
	private By headerText= By.xpath("//span[contains(text(),'Dresses')]");
	

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Declare Page specific methods
	public void navigateToHomePage(String homePagelink) {
		driver.get(homePagelink);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public boolean verifyHomePageLoad() {

		boolean flagValue= false;
		waitStatementMethod(driver, siteLogo);
		waitStatementMethod(driver, contactUsLink);
		WebElement searchBox= driver.findElement(contactUsLink);
		if(searchBox.isDisplayed()) {
			flagValue= true;
		}
		return flagValue;
	}

	public boolean enterSearchText(String searchValue) {
		boolean flagValue = false;
		waitStatementMethod(driver, searchText);
		WebElement searchBox= driver.findElement(searchText);
		// Enter search text
		searchBox.sendKeys(searchValue);
		searchBox.sendKeys(Keys.ENTER);
		System.out.println("Print search value: "+searchValue);
		// Navigated to search Page
		waitStatementMethod(driver, headerText);
		if(driver.getTitle().contains("Dresses")) {
			flagValue= true;
		}
		return flagValue;

	}
	
}
