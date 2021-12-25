package com.test.pages;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.CommonMethodsSelenium;
import com.qa.utils.LoadExcelData;

public class HomePageOrange extends CommonMethodsSelenium {
	private WebDriver driver;
	LoadExcelData exceldata= new LoadExcelData();

	// Declare Page Objects here
	private By PIMLink = By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']/li/a/b[contains(text(),'PIM')]");
	private By employeeName = By.xpath("//input[@id='empsearch_employee_name_empName']");
	private By searchButton = By.xpath("//input[@id='searchBtn']");
	private By categorySection= By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']/li/a/b");

	public HomePageOrange(WebDriver driver) {
		this.driver=driver;
	}
	public void clickLinkDashboard() {
		waitStatementMethod(driver, PIMLink);
		clickElement(driver, PIMLink);
	}

	public void validateExcelSheet(String testId, String testName,  String testBrowser) {
		try {
			exceldata.commonTestDataLoad(testId,testName,testBrowser);
			enterText(driver, employeeName,exceldata.applicationId);
			clickElement(driver, searchButton);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<String> getCategorySectionsList() {

		List<String> categoryList = new ArrayList<>();
		List<WebElement> sectionHeaderList = driver.findElements(categorySection);

		for (WebElement e : sectionHeaderList) {
			String text = e.getText();
			System.out.println(text);
			categoryList.add(text);
		}

		return categoryList;

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
