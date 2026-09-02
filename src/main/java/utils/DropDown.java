package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDown {
private WaitsUtils wait;
	
	public DropDown(WebDriver driver) {
		 this.wait = new WaitsUtils(driver);
	 }
	 
	 private Select getSelect(WebElement element) {
	        return new Select(wait.waitForVisible(element));
	    }

	    public void selectByText(WebElement element, String text) {
	        getSelect(element).selectByVisibleText(text);
	    }

	    public void selectByValue(WebElement element, String value) {
	        getSelect(element).selectByValue(value);
	    }

	    public void selectByIndex(WebElement element, int index) {
	        getSelect(element).selectByIndex(index);
	    }

	    public String getSelectedOption(WebElement element) {
	        return getSelect(element).getFirstSelectedOption().getText();
	    }
	
}
