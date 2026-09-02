package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src/test/resources/features",
		glue = {"stepdefinitions", "hooks"},
		plugin = {"pretty",
				   "summary",
				   "html:target/CucumberReport.html",
				   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		monochrome = true
	//	tags ="@TC_UI_001"
		)


public class TestRunner extends AbstractTestNGCucumberTests {

}
