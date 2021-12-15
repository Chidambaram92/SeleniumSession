package com.src.teststeps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.SearchPage;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SearchPageSteps {
	private WebDriver driver= CommonMethodsSelenium.getDriver();
	SearchPage searchPage=new SearchPage(driver);
	Scenario scenario;

	@And("user wants to search for {string} in search header")
	public void userGetsSearchKey(String searchKey) {
		Assert.assertTrue("SearchKey is enetered in search header", searchPage.enterSearchResults(searchKey));
		System.out.println("Searching is done");
		
	}
	@When("^user check for the \"([^\"]*)\" in search list of particular category$")
	public void verificationOfSearchResults(String getFromList){
		searchPage.verifyListOfSearchelements(getFromList);
		System.out.println("List of search elements method is done");
		

	}
	@And("verify if footer news letter is loaded in search results page")
	public void goToNewsLetterSection() {
		searchPage.searchPageFooterNews();
		System.out.println("Footer of Search Page News letter done");
		
	}

	@When("^user verify the \"([^\"]*)\" value in footer section$")
	public void verificationOfSearchHeaderSection(String footerValue){
		searchPage.getListOfFooterLinks(footerValue);
		System.out.println("Footer of Search Page Specific link is done");

	}

}

