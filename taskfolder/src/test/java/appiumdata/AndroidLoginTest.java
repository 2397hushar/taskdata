package appiumdata;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AndroidLoginTest {
	 public static void main(String[] args) {
	        // Set the desired capabilities
	        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	        desiredCapabilities.setCapability("platformName", "Android");
	        desiredCapabilities.setCapability("deviceName", "emulator-5554");
	        desiredCapabilities.setCapability("appPackage", "com.example");
	        desiredCapabilities.setCapability("appActivity", "com.example.MainActivity");

	        try {
	            // Initialize the Android driver
	            AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), desiredCapabilities);

	            // Find elements
	            MobileElement usernameField = driver.findElement(By.id("com.example:id/username"));
	            MobileElement passwordField = driver.findElement(By.id("com.example:id/password"));
	            MobileElement loginButton = driver.findElement(By.id("com.example:id/login"));

	            // Interact with elements
	            usernameField.sendKeys("testuser");
	            passwordField.sendKeys("password");
	            loginButton.click();

	            // Quit the driver
	            driver.quit();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
    }
}

}
