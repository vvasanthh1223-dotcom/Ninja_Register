package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Actions;
import utils.DropDown;
import utils.WaitsUtils;

public class RegisterPage {

	private WebDriver driver;
	private Actions ac;
	private DropDown dd;
	private WaitsUtils wait;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitsUtils(driver);
		this.ac = new Actions(driver);
		this.dd = new DropDown(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccontButton;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[contains(., 'Register')]")
	private WebElement selectRegister;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[contains(., 'Login')]")
	private WebElement selectLogin;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueInsideLogin;

	@FindBy(xpath = "//a[@class='list-group-item' and normalize-space()='Register']")
	private WebElement loginRegisterButton;

	@FindBy(xpath = "//div[@id='content']//h1[contains(.,'Register Account')]")
	private WebElement verifyRegisterPage;

	@FindBy(id = "input-firstname")
	private WebElement firstnameInput;

	@FindBy(id = "input-lastname")
	private WebElement lastnameInput;

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(id = "input-confirm")
	private WebElement passwordconfirmInputField;

	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsletterYesField;

	@FindBy(xpath = "(//input[@name='newsletter'])[2]")
	private WebElement newsletterNoField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBoxField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButtonField;

	@FindBy(xpath = "//div[@id='content']//h1[contains(.,'Created!')]")
	private WebElement successMessageField;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorNotificationField;

	@FindBy(xpath = "//input[@id=\"input-email\"]/following-sibling::div[contains(@class,'text-danger')]")
	private WebElement invalidEmailFormat;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement passwordError;

	@FindBy(xpath = "//ul[@class='breadcrumb']")
	private WebElement breadCrumbsField;

	@FindBy(xpath = "//div[contains(@class,'form-group') and contains(@class,'required')]")
	private List<WebElement> mandatoryField;

	public void accountButton() {
		ac.click(myAccontButton);
	}

	public void selectRegister() {
		ac.click(selectRegister);
	}

	public void selectLoginRegister() {
		wait.waitForClickable(loginRegisterButton);
		ac.click(loginRegisterButton);
	}

	public void selectLogin() {
		wait.waitForClickable(selectLogin);
		ac.click(selectLogin);
	}

	public void clickContinueLogin() {
		wait.waitForClickable(continueInsideLogin);
		ac.click(continueInsideLogin);
	}

	public boolean isVerifyRegisterPage() {
		return wait.waitForDisplayed(verifyRegisterPage);
	}

	public void firstnameInput(String firstName) {
		ac.type(firstnameInput, firstName);
	}

	public void lastnameInput(String lastName) {
		ac.type(lastnameInput, lastName);
	}

	public void emailInput(String emailInput) {
		ac.type(emailInputField, emailInput);
	}

	public void telephoneInput(String telephoneNumber) {
		ac.type(telephoneInputField, telephoneNumber);
	}

	public void passwordInput(String passWord) {
		ac.type(passwordInputField, passWord);
	}

	public void passwordConfirm(String passWordConfirm) {
		ac.type(passwordconfirmInputField, passWordConfirm);
	}

	public void selectNewsletter(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			wait.waitForClickable(newsletterYesField);
			if (!newsletterYesField.isSelected()) {
				ac.click(newsletterYesField);
			}
		} else if (option.equalsIgnoreCase("No")) {
			wait.waitForClickable(newsletterNoField);
			if (!newsletterNoField.isSelected()) {
				ac.click(newsletterNoField);
			}
		} else {
			throw new IllegalArgumentException("Invalid Newsletter option: " + option);
		}
	}

	public boolean isNewsletterSelected(String option) {

		if (option.equalsIgnoreCase("Yes")) {
			return newsletterYesField.isSelected();

		} else if (option.equalsIgnoreCase("No")) {
			return newsletterNoField.isSelected();

		} else {
			throw new IllegalArgumentException("Invalid Newsletter option: " + option);
		}
	}

	public void selectPrivacyPolicy() {
		wait.waitForClickable(privacyPolicyCheckBoxField);
		if (!privacyPolicyCheckBoxField.isSelected()) {
			ac.click(privacyPolicyCheckBoxField);
		}
	}

	public boolean isPrivacyPolicySelected() {
		return privacyPolicyCheckBoxField.isSelected();
	}

	public void clickContinue() {
		wait.waitForClickable(continueButtonField);
		ac.click(continueButtonField);
	}

	public boolean isRegistrationSuccessful() {
		return wait.waitForDisplayed(successMessageField);
	}

	public boolean isErrorNotificationDisplayed() {
		return wait.waitForDisplayed(errorNotificationField);
	}

	public boolean isPasswordError() {
		return wait.waitForDisplayed(passwordError);
	}

	public boolean getEmailValidationMessage() {
		return wait.waitForDisplayed(invalidEmailFormat);
	}

	public boolean isBreadcrumbDisplayed() {
		return wait.waitForDisplayed(breadCrumbsField);
	}

	public String getFirstNamePlaceholder() {
		return firstnameInput.getAttribute("placeholder");

	}

	public String getLastNamePlaceholder() {
		return lastnameInput.getAttribute("placeholder");

	}

	public String getEmailPlaceholder() {
		return emailInputField.getAttribute("placeholder");

	}

	public String getTelephonePlaceholder() {
		return telephoneInputField.getAttribute("placeholder");

	}

	public String getPasswordPlaceholder() {
		return passwordInputField.getAttribute("placeholder");

	}

	public String getConfirmPasswordPlaceholder() {
		return passwordconfirmInputField.getAttribute("placeholder");

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getRegisterPageHeading() {
		return verifyRegisterPage.getText();
	}

	public String getBreadCrumb() {
		return breadCrumbsField.getText();
	}

}
