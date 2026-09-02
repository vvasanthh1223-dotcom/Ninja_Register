package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Then;
import pages.RegisterPage;

public class ValidationPart {
	private WebDriver driver;
	private RegisterPage rg;

	public ValidationPart() {
		driver = DriverFactory.getDriver();
		rg = new RegisterPage(driver);
	}
	
	@Then("the Register Account page URL should be correct")
	public void the_register_account_page_url_should_be_correct() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("route=account/register"),"check the link");
	}
	@Then("the Register Account page title sholud be correct")
	public void the_register_account_page_title_sholud_be_correct() {
		Assert.assertEquals(rg.getPageTitle(), "Register Account","Page title is incorrect");
	   
	}
	@Then("the Register Account page heading should be correct")
	public void the_register_account_page_heading_should_be_correct() {
		Assert.assertEquals(rg.getRegisterPageHeading(),"Register Account","Page heading is incorrect");
	}
	@Then("the Register Account Breadcrumb should be correct")
	public void the_register_account_breadcrumb_should_be_correct() {
	    Assert.assertTrue(rg.isBreadcrumbDisplayed(), "Breadcrumb is should not displayed");
	    System.out.println("Breadcrumb is displayed");
	}

}
