package utils;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;

public class Screenshot {

	public static void takeScreenshot(WebDriver driver, Scenario scenario, String status) {
		try {

			ChromeDriver chromeDriver = (ChromeDriver) driver;

			Map<String, Object> metrics = chromeDriver.executeCdpCommand("Page.getLayoutMetrics", new HashMap<>());
			Map<String, Object> contentSize = (Map<String, Object>) metrics.get("contentSize");

			double width = ((Number) contentSize.get("width")).doubleValue();
			double height = ((Number) contentSize.get("height")).doubleValue();

			Map<String, Object> clip = new HashMap<>();
			clip.put("x", 0);
			clip.put("y", 0);
			clip.put("width", width);
			clip.put("height", height);
			clip.put("scale", 1);

			Map<String, Object> params = new HashMap<>();
			params.put("format", "png");
			params.put("clip", clip);
			params.put("captureBeyondViewport", true);

			Map<String, Object> result = chromeDriver.executeCdpCommand("Page.captureScreenshot", params);

			byte[] screenshot = Base64.getDecoder().decode((String) result.get("data"));
			String screenshotName = status + " - " + scenario.getName();
			scenario.attach(screenshot, "image/png", screenshotName);
			System.out.println("Screenshot attached to Cucumber report: " + screenshotName);
		} catch (Exception e) {
			System.out.println("Screenshot failed: " + e.getMessage());
		}

	}

}
