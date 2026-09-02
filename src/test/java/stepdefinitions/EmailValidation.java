package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import pages.RegisterPage;

public class EmailValidation {
	
	private WebDriver driver;
	private RegisterPage rg;

	public EmailValidation() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}
	@Then("the Email  validation error should be displayed")
	public void the_email_validation_error_should_be_displayed() {
		Assert.assertTrue(rg.isErrorNotificationDisplayed());
		System.out.println("Entered Email already exits");
	}


}
