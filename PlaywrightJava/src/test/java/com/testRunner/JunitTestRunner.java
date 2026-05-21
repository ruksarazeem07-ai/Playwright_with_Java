package com.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, features = { "src/test/resources/Feature/Login.feature" },
//		features = "@target/failedrerun.txt", 
		glue = { "com.stepDefinitions", "utils" }, monochrome = true, dryRun = false
//		,tags = "@012"
)

public class JunitTestRunner {
}