package com.src.teststeps;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private WebDriver driver= CommonMethodsSelenium.getDriver();
	HomePage homePage=new HomePage(driver);
	
	
	@And("user navigates to home page")
	public void userGetsDataHomePage() {
		String browserName = ApplicationHooks.prop.getProperty("homePageUrl");
		homePage.navigateToHomePage(browserName);
		System.out.println(" Home Page navigation is done");
	}
	@When("verify home page is launched")
	public void verificationOfHomePage(){

		Assert.assertTrue(homePage.verifyHomePageLoad());
	}
	@And("^get search name \"([^\"]*)\"$")
	public void enterSearchText(String actualText){

		homePage.enterSearchText(actualText);
	}

}
