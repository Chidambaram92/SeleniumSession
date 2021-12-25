package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;

public class EmployeePage extends CommonMethodsSelenium {
	private WebDriver driver;
	private By employeeName = By.xpath("//input[@id='empsearch_employee_name_empName']");
	private By searchButton = By.xpath("//input[@id='searchBtn']");
	public EmployeePage(WebDriver driver) {
		this.driver=driver;
	}

}
