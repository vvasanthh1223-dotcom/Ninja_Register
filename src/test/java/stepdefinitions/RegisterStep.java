package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterStep {

	private WebDriver driver;
	RegisterPage rg;

	@Given("the user opens the Tutorial Ninja application in a browser")
	public void the_user_opens_the_tutorial_ninja_application_in_a_browser() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("tutorialsninja"),
				"Application URL does not contain 'tutorialsninja'");
		System.out.println("Application opened");
	}

	@Given("the user navigates to the {string} page")
	public void the_user_navigates_to_the_page(String string) {
		rg.accountButton();
		rg.selectRegister();
		Assert.assertTrue(rg.isVerifyRegisterPage(), "User not in the Register Page");
		System.out.println("User in Register Page");
	}

	@When("the user enters valid mandatory registration details {string}, {string}, {string}, {string}, {string}, {string}")
	public void the_user_enters_valid_mandatory_registration_details(String firstname, String lastname, String Mail,
			String Telephone, String Password, String PasswordConfirm) {
		rg.firstnameInput(firstname);
		rg.lastnameInput(lastname);
		rg.emailInput(Mail);
		rg.telephoneInput(Telephone);
		rg.passwordInput(Password);
		rg.passwordConfirm(PasswordConfirm);
		System.out.println("User enter the mandatory details");

	}

	@When("the user agrees to the Privacy Policy")
	public void the_user_agrees_to_the_privacy_policy() {
		rg.selectPrivacyPolicy();

	}

	@When("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		rg.clickContinue();

	}

	@Then("the user should be taken to the {string} page")
	public void the_user_should_be_taken_to_the_page(String page) {
		// Assert.assertTrue(rg.isRegistrationSuccessful(), "Account page not
		// displayed");
		if (page.equalsIgnoreCase("Register Account")) {
			Assert.assertTrue(rg.isVerifyRegisterPage(), "User was not navigated to the Register Account page");
		} else if (page.equalsIgnoreCase("Account Success")) {
			Assert.assertTrue(rg.isRegistrationSuccessful(), "Registration was not successful");
		} else {
			throw new IllegalArgumentException("Invalid page name: " + page);
		}
	}

	@Then("validation errors should be displayed")
	public void validation_errors_should_be_displayed() {
		Assert.assertTrue(rg.isErrorNotificationDisplayed());
	}

}
