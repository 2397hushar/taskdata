package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomiseExperiencePage {

	WebDriver driver;

	@FindBy(xpath = "//button[text()='Stress and anxiety']")
	private WebElement stressAndAnxietyOption;

	@FindBy(xpath = "//button[text()='Focus']")
	private WebElement focusOption;

	@FindBy(xpath = "//button[text()='Productivity']")
	private WebElement productivityOption;

	@FindBy(xpath = "//button[text()='Relaxation']")
	private WebElement relaxationOption;

	@FindBy(xpath = "//button[text()='Anger']")
	private WebElement angerOption;

	@FindBy(xpath = "//button[text()='Peace']")
	private WebElement peaceOption;

	@FindBy(xpath = "//button[text()='Motivation']")
	private WebElement motivationOption;

	@FindBy(xpath = "//button[text()='Self love']")
	private WebElement selfLoveOption;

	@FindBy(id = "selectedMeditation")
	private WebElement selectedMeditationLabel;

	public CustomiseExperiencePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectMeditation(String meditationType) {
		switch (meditationType.toLowerCase()) {
		case "stress and anxiety":
			stressAndAnxietyOption.click();
			break;
		case "focus":
			focusOption.click();
			break;
		case "productivity":
			productivityOption.click();
			break;
		case "relaxation":
			relaxationOption.click();
			break;
		case "anger":
			angerOption.click();
			break;
		case "peace":
			peaceOption.click();
			break;
		case "motivation":
			motivationOption.click();
			break;
		case "self love":
			selfLoveOption.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid meditation type: " + meditationType);
		}
	}

	public String getSelectedMeditation() {
		return selectedMeditationLabel.getText();
	}
}
