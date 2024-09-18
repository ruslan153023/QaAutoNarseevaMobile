import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CafeTest {

    private AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_4_API_30");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("app", "C:\\Users\\Ruslan\\IdeaProjects\\AutoMobile\\src\\test\\java\\app-debug.apk");
        //capabilities.setCapability("adbExecTimeout","50000");

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    }

    @Test
    public void testCafe() {
        MobileElement element = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id=\"com.example.mycafe:id/inputName\"]");
        element.setValue("Ruslan");

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
