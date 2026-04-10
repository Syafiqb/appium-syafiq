package com.syafiq.appium.pages;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

    private final AppiumDriver driver;

    public CheckoutPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement continueBtn;

    @AndroidFindBy(accessibility = "test-FINISH")
    private WebElement finishBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    private WebElement successMessage;

    public void inputInformation(String fName, String lName, String zip) {
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        zipCodeField.sendKeys(zip);
        continueBtn.click();
    }

    public void finishCheckout() {
        // Scroll ke bawah agar tombol FINISH terlihat
        HashMap<String, Object> scrollArgs = new HashMap<>();
        scrollArgs.put("direction", "down");
        scrollArgs.put("strategy", "accessibility id");
        scrollArgs.put("selector", "test-FINISH");
        driver.executeScript("mobile: scroll", scrollArgs);

        // Tunggu dan klik tombol FINISH
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }
}