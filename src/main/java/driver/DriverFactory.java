package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver;

	public static void initBrowser(String browser, String... arguments) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();

			java.util.Map<String, Object> prefs = new java.util.HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);

			for (String argument : arguments) {
				options.addArguments(argument);
			}

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		} else {
			throw new IllegalArgumentException("Unsupported browser" + browser);
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

}
