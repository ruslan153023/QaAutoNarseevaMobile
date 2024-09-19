package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DrinkChangePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

public class LoginTest {

    LoginPage loginPage = new LoginPage();
    DrinkChangePage drinkChangePage = new DrinkChangePage();

    private AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_4_API_30");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("app", "C:\\Users\\Ruslan\\IdeaProjects\\AutoMobile\\src\\test\\java\\app-debug.apk");
        capabilities.setCapability("adbExecTimeout","50000");

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    }

    @Test
    public void loginTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement nameInput = (MobileElement) driver.findElementByXPath(loginPage.byNameInput);
        nameInput.setValue("Ruslan");
        Assert.assertEquals(nameInput.getText(), "Ruslan");

        MobileElement passwordInput = (MobileElement) driver.findElementByXPath(loginPage.byPasswordInput);
        passwordInput.setValue("Password");

        MobileElement loginButton = (MobileElement) driver.findElementByXPath(loginPage.byLoginButton);
        loginButton.click();

        MobileElement welcomeTextView = (MobileElement) driver.findElementByXPath(drinkChangePage.byWelcomeTextView);
        welcomeTextView.isDisplayed();
        Assert.assertEquals(welcomeTextView.getText(), "Здравствуйте, Ruslan! Что желаете?");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
