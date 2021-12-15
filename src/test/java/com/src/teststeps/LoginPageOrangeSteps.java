package com.src.teststeps;


import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.HomePageOrange;
import com.test.pages.LoginOrange;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import org.testng.Assert;


public class LoginPageOrangeSteps {
	private WebDriver driver= CommonMethodsSelenium.getDriver();
	LoginOrange loginPageOrange=new LoginOrange(driver);
	HomePageOrange homeOrange= new HomePageOrange(driver);
	
	
	@And("user navigates to orange site launch page")
	public void userGetsDataLoginPage() {
		String browserName = ApplicationHooks.prop.getProperty("orangePageURL");
		loginPageOrange.launchSite(browserName);
		System.out.println("Orange site launch is done");
	}
	
	@When("verify if orange site home page is navigated")
	public void verificationOfLoginPage(){
		String userName = ApplicationHooks.prop.getProperty("orangeUser");
		String passWord = ApplicationHooks.prop.getProperty("orangePassword");
		Assert.assertTrue(loginPageOrange.enterLoginCredentials(userName, passWord));
		System.out.println("Orange site home page is navigated");
	}
	@And("click on PIM link present in the home page")
	public void userGetPiPage() {
		homeOrange.clickLinkDashboard();
	}
 
}
