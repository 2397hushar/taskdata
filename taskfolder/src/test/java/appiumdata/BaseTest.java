package appiumdata;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
	
	protected AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Google Pixel 7a");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("udid", "33101JEHN18985");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("browserName", "Chrome");

        // Set desired capabilities here
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        // For iOS, use:
        // driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


