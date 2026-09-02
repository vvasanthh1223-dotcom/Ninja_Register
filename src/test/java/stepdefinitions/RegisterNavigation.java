package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterNavigation {

	private WebDriver driver;
	private RegisterPage rg;

	public RegisterNavigation() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}

	@When("the user clicks on the {string} drop-down menu")
	public void the_user_clicks_on_the_drop_down_menu(String menuName) {
		rg.accountButton();
	}

	@When("the user clicks on the {string} option")
	public void the_user_clicks_on_the_option(String optionName) {

		if (optionName.equalsIgnoreCase("Register")) {
			rg.selectRegister();

		} else if (optionName.equalsIgnoreCase("Login")) {
			rg.selectLogin();

		} else {
			throw new IllegalArgumentException("Invalid option: " + optionName);
		}
		System.out.println("User in: "+ optionName);
	}

	@When("the user clicks on the {string} button inside the {string} box")
	public void the_user_clicks_on_the_button_inside_the_box(String buttonName, String boxName) {
		rg.clickContinueLogin();
		Assert.assertTrue(rg.isVerifyRegisterPage(), "User was not navigated to the Register Account page");
	}

	@When("the user clicks on the {string} option from the Right Column options")
	public void the_user_clicks_on_the_option_from_the_right_column_options(String optionName) {
		rg.selectLoginRegister();
		Assert.assertTrue(rg.isVerifyRegisterPage(), "User was not navigated to the Register Account page");

	}

}
