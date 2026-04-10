package com.syafiq.appium;
 
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import com.syafiq.appium.drivers.DriverSingleton;
import com.syafiq.appium.pages.LoginPage;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
 
public class LoginTest {
    private AppiumDriver driver;
    private LoginPage loginPage;
 
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("android");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
    }
 
    @AfterClass
    public void tearDown() {
        DriverSingleton.closeObjectInstance();
    }
 
    @Test
    public void testBlankUsernameAndPassword() {
        loginPage.blankUsernameAndPassword();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Username is required", "Pesan error tidak sesuai");
    }
 
    @Test
    public void testValidUsernameAndPassword() {
        loginPage.validUsernameAndPassword("standard_user", "secret_sauce");
 
        // Cast ke AndroidDriver karena currentActivity() tidak ada di AppiumDriver
        AndroidDriver androidDriver = (AndroidDriver) DriverSingleton.getDriver();
        String activity = androidDriver.currentActivity();
        System.out.println("Current activity: " + activity); // untuk debug
        Assert.assertTrue(
            activity.contains("MainActivity") || activity.contains("Inventory"),
            "Seharusnya berpindah ke inventory, actual: " + activity
        );
    }
}