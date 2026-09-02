package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class EmailFormat {

	private WebDriver driver;
	private RegisterPage rg;

	public EmailFormat() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}

	@When("the user enters valid mandatory registration details {string}, {string}, {string}, {string}, {string}")
	public void the_user_enters_valid_mandatory_registration_details(String firstname, String lastname,
			String Telephone, String Password, String PasswordConfirm) {
		rg.firstnameInput(firstname);
		rg.lastnameInput(lastname);
		rg.telephoneInput(Telephone);
		rg.passwordInput(Password);
		rg.passwordConfirm(PasswordConfirm);
		System.out.println("User enter the mandatory details");
	}

	@When("user enter invalid email address {string}")
	public void user_enter_invalid_email_address(String Mail) {
		rg.emailInput(Mail);
	}

	@Then("the Email correction error should be displayed")
	public void the_email_correction_error_should_be_displayed() {
		Assert.assertTrue(rg.getEmailValidationMessage());
		System.out.println("Please correct the email format");
	}

}
