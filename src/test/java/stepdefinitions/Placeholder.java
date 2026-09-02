package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import pages.RegisterPage;

public class Placeholder {

	private WebDriver driver;
	private RegisterPage rg;

	public Placeholder() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}

	@Then("all the registration fields should have the proper placeholder")
	public void all_the_registration_fields_should_have_the_proper_placeholder() {
		Assert.assertEquals(rg.getFirstNamePlaceholder(), "First Name");
		Assert.assertEquals(rg.getLastNamePlaceholder(), "Last Name");
		Assert.assertEquals(rg.getEmailPlaceholder(), "E-Mail");
		Assert.assertEquals(rg.getTelephonePlaceholder(), "Telephone");
		Assert.assertEquals(rg.getPasswordPlaceholder(), "Password");
		Assert.assertEquals(rg.getConfirmPasswordPlaceholder(), "Password Confirm");

		System.out.println("Placeholder are validated all goods");
	}

}
