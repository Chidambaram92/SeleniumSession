package com.src.teststeps;

import org.openqa.selenium.WebDriver;

import com.qa.utils.CommonMethodsSelenium;
import com.test.pages.EmployeePage;
import com.test.pages.HomePage;

public class EmployeeInformation {
	private WebDriver driver= CommonMethodsSelenium.getDriver();
	EmployeePage employeeObj= new EmployeePage(driver);
	
}
