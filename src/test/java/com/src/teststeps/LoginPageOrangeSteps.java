package com.src.teststeps;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;
import com.qa.utils.LoadExcelData;
import com.test.pages.HomePageOrange;
import com.test.pages.LoginOrange;

import io.cucumber.datatable.DataTable;
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
	@And("I verify the tabs present in Home page")
	public void returnTabsSelection(DataTable testData) {
		List<String> categoryList = testData.asList();
		System.out.println("Expected accounts section list: " + categoryList);
		List<String> applicationCategoryList = homeOrange.getCategorySectionsList();
		System.out.println("Actual accounts section list in Application is: " + applicationCategoryList);

	}
	@And("load excel test data with testid {string} testcase name {string} and browser {string}")
	public void loadExcelData(String id,String name, String browser) {
		homeOrange.validateExcelSheet(id,name,browser);
	}

}
