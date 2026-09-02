package hooks;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.Screenshot;

public class Hooks {

	private WebDriver driver;
	String browser;
	String url;

	@Before(order = 1)
	public void setUp() {
		loadConfig();
		setBrowser();
	}

	public void loadConfig() {
		browser = ConfigReader.getProperty("browser");
		url = ConfigReader.getProperty("url");

		System.out.println("browser: " + browser);
		System.out.println("url: " + url);
	}

	public void setBrowser() {
		DriverFactory.initBrowser(browser, "--disable-notifications", "--disable-popup-blocking",
				"--disable-save-password-bubble");
		driver = DriverFactory.getDriver();
		driver.get(url);
		System.out.println("Browser Opened");

	}

	@AfterStep
	public void afterSteps(Scenario scenario) {
		if (!scenario.isFailed()) {
			Screenshot.takeScreenshot(driver, scenario, "Step Passed");
		}
	}

	@After(order = 0)
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			Screenshot.takeScreenshot(driver, scenario, "FAILED");
		}
		DriverFactory.closeBrowser();
		System.out.println("Browser Closed");
	}

}
