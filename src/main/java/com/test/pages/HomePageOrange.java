package com.test.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethodsSelenium;

public class HomePageOrange extends CommonMethodsSelenium {
	private WebDriver driver;

	// Declare Page Objects here
	private By PIMLink = By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']/li/a/b[contains(text(),'PIM')]");


	public HomePageOrange(WebDriver driver) {
		this.driver=driver;
	}
	public void clickLinkDashboard() {
	waitStatementMethod(driver, PIMLink);
	clickElement(driver, PIMLink);
	}

	public void validateWebTable() {
		
		  WebElement
		  htmltable=driver.findElement(By.xpath("//table[@id='resultTable']"));
		  List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
		  
		  for(int rnum=0;rnum<rows.size();rnum++) { 
		  List<WebElement>
		  columns=rows.get(rnum).findElements(By.tagName("td"));
		  System.out.println("Number of columns:"+columns.size());
		  
		  for(int cnum=0;cnum<columns.size();cnum++) {
		  System.out.println(columns.get(cnum).getText()); } }
		 
	}
}
