package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginpageEmailfuncation {

	private WebDriver driver;

	public LoginpageEmailfuncation(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By emailField = By.id("email");
	By passwordField = By.id("password");
	By nextButton = By.id("next");
	By errorMessage = By.id("error-message");

	// Methods
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickNext() {
		driver.findElement(nextButton).click();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

	public boolean isInvalidPasswordErrorDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
