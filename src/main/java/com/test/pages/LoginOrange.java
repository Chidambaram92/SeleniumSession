package com.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethodsSelenium;

public class LoginOrange extends CommonMethodsSelenium {
	private WebDriver driver;

	// Declare Page Objects here
	private By loginUserName= By.xpath("//input[@id='txtUsername']");
	private By loginPassword= By.xpath("//input[@id='txtPassword']");
	private By loginButton= By.id("btnLogin");


	public LoginOrange(WebDriver driver) {
		this.driver=driver;
	}
	public void launchSite(String homePagelink) {
		driver.get(homePagelink);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public boolean enterLoginCredentials(String userName, String password) {
		boolean flagValue = false;
		try {
			waitStatementMethod(driver, loginUserName);
			enterText(driver, loginUserName, userName);
			enterText(driver, loginPassword, password);
			clickElement(driver, loginButton);
			if(driver.getCurrentUrl().contains("orangehrmlive.com/index.php/dashboard")) {
				flagValue= true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return flagValue;
	}
}
