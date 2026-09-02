package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtils {

	private WebDriver driver;
	private WebDriverWait wait;

	public WaitsUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(TimeConfig.Explicity_Wait));
	}

	public WebElement waitForVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitForDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public boolean waitForTitle(String title) {
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public boolean waitForUrl(String url) {
		return wait.until(ExpectedConditions.urlContains(url));
	}
}
