package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {

	WebDriver driver;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "gender")
    private WebElement genderDropdown;

    @FindBy(id = "agreeToReceive")
    private WebElement agreeToReceiveCheckbox;

    @FindBy(id = "agreeTerms")
    private WebElement agreeTermsCheckbox;

    @FindBy(id = "referralCode")
    private WebElement referralCodeField;

    @FindBy(id = "nextButton")
    private WebElement nextButton;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void selectGender(String gender) {
        genderDropdown.sendKeys(gender);  // Adjust if there's a proper select implementation
    }

    public void clickAgreeToReceive() {
        if (!agreeToReceiveCheckbox.isSelected()) {
            agreeToReceiveCheckbox.click();
        }
    }

    public void clickAgreeTerms() {
        if (!agreeTermsCheckbox.isSelected()) {
            agreeTermsCheckbox.click();
        }
    }

    public void enterReferralCode(String code) {
        referralCodeField.sendKeys(code);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}
	

