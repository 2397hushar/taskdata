package pageobject;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class SetupClass {

	private String platform;
	private WebDriver driver;

	public SetupClass(String platform) {
		this.platform = platform;
	}

	public void initializeDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (platform.equalsIgnoreCase("android")) {
			capabilities.setCapability("app", "/path/to/your/app.apk");
			capabilities.setCapability("appPackage", "com.levelsupermind");
			capabilities.setCapability("appActivity", "com.levelsupermind.MainActivity");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "samsung");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		} else if (platform.equalsIgnoreCase("ios")) {
			capabilities.setCapability("app", Paths.get("/path/to/your/app.app").toAbsolutePath().toString());
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("deviceName", "iphone12");
			capabilities.setCapability("bundleId", "com.levelsupermind");
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} else {
			throw new IllegalArgumentException("Invalid platform! Please specify 'android' or 'ios'.");
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please specify the platform: 'android' or 'ios'");
			return;
		}

		String platform = args[0];
		SetupClass setup = new SetupClass(platform);

		try {
			setup.initializeDriver();
			WebDriver driver = setup.getDriver();

			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
