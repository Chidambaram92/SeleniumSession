package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.utils.CommonMethodsSelenium;

public class SearchPage extends CommonMethodsSelenium {

	private WebDriver driver;
	// Declare Page Objects here
	private By searchText= By.xpath("//input[@name='search_query']");
	private By searchRsultsList= By.xpath("//div[@class='ac_results']/ul/li");
	private By searchResultsNewsletter=By.xpath("//h4[text()='Newsletter']");

	public SearchPage(WebDriver driver) {
		this.driver= driver;
	}
	public boolean enterSearchResults(String searchValue) {
		boolean flagedTest= false;
		try {

			enterText(driver, searchText, searchValue);
			clickElement(driver, searchText);
			flagedTest= true;

		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return flagedTest;

	}
	public void verifyListOfSearchelements(String serachElementInList) {
		List<WebElement> webElement = driver.findElements(searchRsultsList);
		for(WebElement oneElement:webElement) {
			if(oneElement.getText().contains(serachElementInList)){
				try {
					oneElement.click();
					break;
				}catch(ElementClickInterceptedException e ) {
					e.printStackTrace();

				}

			}
		}

	}
	public void searchPageFooterNews() {
		waitStatementMethod(driver, searchResultsNewsletter);
		WebElement newsLetter= driver.findElement(searchResultsNewsletter);
		Actions action= new Actions(driver);
		try {
			action.moveToElement(newsLetter).build().perform();	
			
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}

	}
	public void getListOfFooterLinks(String footerValue) {
		WebElement footerLinkInfor= driver.findElement(By.xpath("//section[@id='block_various_links_footer']/h4[contains(text(),'Information')]//following-sibling::ul/li/a[contains(text(),'"+footerValue+"')]"));
		footerLinkInfor.click();
	}
}
