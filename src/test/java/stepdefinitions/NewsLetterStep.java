package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class NewsLetterStep {

	private WebDriver driver;
	private RegisterPage rg;

	public NewsLetterStep() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}

	@When("the user selects {string} for the Newsletter option")
	public void the_user_selects_for_the_newsletter_option(String newsletter) {
		rg.selectNewsletter(newsletter);
	}

	@Then("the Newsletter option {string} should be selected")
	public void the_newsletter_option_should_be_selected(String option) {
		boolean isSelected = rg.isNewsletterSelected(option);
		Assert.assertTrue(isSelected, "Newsletter option '" + option + "' is not selected");
	}
}
