package testcasedata;

import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pageobject.CustomiseExperiencePage;
import pageobject.FormPage;
import pageobject.GmailLoginPage;
import pageobject.LoginPageMobilefuncation;
import pageobject.LoginpageEmailfuncation;
import pageobject.SetupClass;

public class TestData extends SetupClass {

	public TestData(String platform) {
		super(platform);
		// TODO Auto-generated constructor stub
	}

	// private WebDriver driver;
	private LoginpageEmailfuncation loginPage;
	protected AppiumDriver<MobileElement> driver;
	private LoginPageMobilefuncation mobilepage;
	private RemoteWebElement denyButton;
	private GmailLoginPage gmailloginPage;
	FormPage formPage;
	CustomiseExperiencePage meditationSelectionPage;
	ExtentReports extent;
    ExtentTest test;
	/**********************
	 * * Email Function Sign Up Test Case
	 ********************************/

	@Test(priority = 1)
	public void testValidLogin() {
        test = extent.createTest("Valid Login Test", "Test for valid login credentials");
       // test1.log(Status.PASS, "url is getting");

        test.log(Status.INFO,"data");
		loginPage.enterEmail("valid@email.com");
		loginPage.enterPassword("validOtp");
		loginPage.clickNext();

		boolean isLoginPageDisplayed = driver.findElement(By.id("login-success")).isDisplayed();
		Assert.assertTrue(isLoginPageDisplayed, "Customise your experience page");
	}

	public void testvalidOtp() {
		loginPage.enterEmail("valid@email.com");
		loginPage.enterPassword("validOtp");
		loginPage.clickNext();
		String successMessage = null;
		Assert.assertEquals(successMessage, "Customise your experience page");

	}

	public void testInValidLogin() {

		loginPage.enterEmail("Invalid@email.com");
		loginPage.enterPassword("validOtp");
		loginPage.clickNext();

		boolean isErrorDisplayed = driver.findElement(By.id("error-message")).isDisplayed();
		Assert.assertTrue(isErrorDisplayed, "Error message for invalid email not displayed");
	}

	public void testInvalidOtp() {
		loginPage.enterEmail("valid@email.com");
		loginPage.enterPassword("InvalidOtp");
		loginPage.clickNext();
		assert (loginPage.isInvalidPasswordErrorDisplayed());
	}

	/**************************** Mobile Function Sign Up Test Case **************/

	@BeforeMethod
	public void setUpMethod() {
		mobilepage = new LoginPageMobilefuncation(driver);
	}

	@Test(priority = 2)
	public void testValidMobilenumber() {
		mobilepage.enterMobileNumber("1234567890");
		// Simulate receiving OTP for testing purposes
		WebDriverWait wait = new WebDriverWait(driver, 10);

		mobilepage.enterOtp("otp");
		mobilepage.allowButton();
		Assert.assertTrue(mobilepage.allowButton());

	}

	@Test
	public void testInvalidMobilenumber() {
		mobilepage.enterMobileNumber("1234567890");
		// Simulate receiving OTP for testing purposes
		WebDriverWait wait = new WebDriverWait(driver, 10);

		mobilepage.enterOtp("123456");
		mobilepage.denyButton();

		Assert.assertTrue(denyButton.isDisplayed(), "Deny button is not displayed.");

	}

	/******************** Or Sign up With Gmail Test Case *********************/

	@BeforeClass
	public void setUp() {

		// Initialize GmailLoginPage
		gmailloginPage = new GmailLoginPage(driver);
	}

	@Test(priority = 3)

	public void testGmailLogin() {

		gmailloginPage.enterUsername("your.email@gmail.com");
		gmailloginPage.clickSignIn();
		gmailloginPage.enterPassword("your-password");
		gmailloginPage.clickSignIn();

		// Verify successful login (assertions or verifications here)
		Assert.assertTrue(driver.getTitle().contains("Inbox"));

	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();

	}

	@DataProvider(name = "formData")
	public Object[][] formData() {
		return new Object[][] { { "John Doe", "john@example.com", "Male", "12345", true, true, true }, // Valid data
				{ "", "invalid-email", "Female", "", false, true, false }, // Invalid data
		};
	}

	@Test(dataProvider = "formData")
	public void testFormSubmission(String name, String email, String gender, String referralCode,
			boolean agreeToReceive, boolean agreeTerms, boolean expectedSuccess) {
		formPage.enterName(name);
		formPage.enterEmail(email);
		formPage.selectGender(gender);
		if (agreeToReceive) {
			formPage.clickAgreeToReceive();
		}
		if (agreeTerms) {
			formPage.clickAgreeTerms();
		}
		formPage.enterReferralCode(referralCode);
		formPage.clickNextButton();

		boolean actualSuccess = driver.getCurrentUrl().contains("success"); // Replace with actual success condition
		Assert.assertEquals(actualSuccess, expectedSuccess);
	}

	/************************
	 * CustomiseExperiencePage
	 *******************************************/

	@Test(priority = 4)

	@DataProvider(name = "meditationTypes")
	public Object[][] meditationTypes() {
		return new Object[][] { { "Stress and anxiety" }, { "Focus" }, { "Productivity" }, { "Relaxation" },
				{ "Anger" }, { "Peace" }, { "Motivation" }, { "Self love" } };
	}

	@Test(dataProvider = "meditationTypes")
	public void testMeditationSelection(String meditationType) {
		meditationSelectionPage.selectMeditation(meditationType);
		String selectedMeditation = meditationSelectionPage.getSelectedMeditation();
		Assert.assertEquals(selectedMeditation, meditationType,
				"The selected meditation does not match the expected value.");
	}

}