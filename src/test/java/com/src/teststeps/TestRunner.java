package com.src.teststeps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/feature"},
		glue = {"com/src/teststeps"},
		plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
		monochrome= true,
		tags="@HomeTest or @SearchTest"
		)

public class TestRunner {

}
