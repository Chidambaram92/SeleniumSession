package com.src.teststeps;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.utils.CommonMethodsSelenium;
import com.qa.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private WebDriver driver;
	private ConfigReader configReader;
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports report;

	@Before(order = 0)
	public void getProperty() {
		// Load property file as below through Config Reader class
		configReader = new ConfigReader();
		prop = configReader.loadPropertyFile();
	}

	@Before(order = 1)
	public void launchBrowser() {
		//Utilize the browser value from property value
		String browserName = prop.getProperty("browserType");
		driver= new CommonMethodsSelenium().initializeDriver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}

	}
}
