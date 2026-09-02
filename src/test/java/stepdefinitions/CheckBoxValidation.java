package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class CheckBoxValidation {
	
	private WebDriver driver;
	private RegisterPage rg;

	public CheckBoxValidation() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}
	
	@Then("the Privacy Policy checkbox should not be selected by default")
	public void the_privacy_policy_checkbox_should_not_be_selected_by_default() {
	    Assert.assertFalse(rg.isPrivacyPolicySelected(), "Privacy Policy selected by default");
	}
	
	@When("the user does not agrees to the Privacy Policy")
	public void the_user_does_not_agrees_to_the_privacy_policy() {
		rg.isPrivacyPolicySelected();
	}
	@Then("the Privacy error message should be displayed")
	public void the_privacy_error_message_should_be_displayed() {
		Assert.assertTrue(rg.isErrorNotificationDisplayed());
	   
	}

}
