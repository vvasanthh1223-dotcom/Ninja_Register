package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class PasswordError {
	private WebDriver driver;
	private RegisterPage rg;

	public PasswordError() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}

	@Then("the password confirmation validation error should be displayed")
	public void the_password_confirmation_validation_error_should_be_displayed() {
		Assert.assertTrue(rg.isPasswordError(), "Password confirmation validation error was not displayed");
	}
	
	@When("the user enters valid mandatory registration details {string}, {string},{string}, {string}")
	public void the_user_enters_valid_mandatory_registration_details(String firstname, String lastname, String Mail, String Telephone) {
		rg.firstnameInput(firstname);
		rg.lastnameInput(lastname);
		rg.emailInput(Mail);
		rg.telephoneInput(Telephone);
	}
	@When("user enter invalid password format {string}, {string}")
	public void user_enter_invalid_password_format(String Password, String PasswordConfirm) {
		rg.passwordInput(Password);
		rg.passwordConfirm(PasswordConfirm);
		System.out.println("User entered password");
	    
	}
	@Then("the Password correction error should be displayed")
	public void the_password_correction_error_should_be_displayed() {
		Assert.assertTrue(rg.isPasswordError(), "Password confirmation validation error was not displayed");
	}
	
	@When("the user enters valid mandatory registration details {string}, {string}, {string}, {string},{string}")
	public void the_user_enters_valid_mandatory_registration_details(String firstname, String lastname, String Mail, String Telephone, String Password) {
		rg.firstnameInput(firstname);
		rg.lastnameInput(lastname);
		rg.emailInput(Mail);
		rg.telephoneInput(Telephone);
		rg.passwordInput(Password);
		
	}
	@When("user enter password field {string}")
	public void user_enter_password_field(String string) {
	  System.out.println("Password confirmation field is empty");
	}
	
	

}
