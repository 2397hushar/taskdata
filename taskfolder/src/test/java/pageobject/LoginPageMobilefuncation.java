package pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMobilefuncation extends BasePage {

	@FindBy(id = "com.example:id/mobileNumber")
	private WebElement mobileNumberField;

	@FindBy(id = "com.example:id/otp")
	private WebElement otpField;

	@FindBy(id = "com.example:id/loginButton")
	private WebElement loginButton;

	@FindBy(id = "com.example:id/errorMessage")
	private WebElement errorMessage;

	@FindBy(id = "allow")
	private WebElement Clickonallow;

	@FindBy(id = "deny")
	private WebElement Clickondeny;

	public LoginPageMobilefuncation(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void enterMobileNumber(String mobileNumber) {
		mobileNumberField.sendKeys(mobileNumber);
	}

	public void enterOtp(String otp) {
		otpField.sendKeys(otp);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

	public boolean allowButton() {
		Clickonallow.click();

		String otp = "900199";
		return false;
	}

	public void denyButton() {
		Clickondeny.click();

	}

}
