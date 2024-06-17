package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLoginPage {
	private WebDriver driver;

	// Constructor to initialize WebDriver
	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By usernameField = By.id("identifierId");
	By passwordField = By.name("password");
	By signInButton = By.id("signIn");

	// Methods
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickSignIn() {
		driver.findElement(signInButton).click();
	}
}
