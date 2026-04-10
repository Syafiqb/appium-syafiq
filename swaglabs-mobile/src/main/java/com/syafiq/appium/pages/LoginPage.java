package com.syafiq.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private WebElement passwordField;
    
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']//android.widget.TextView")
    private WebElement errorMessage;

    public void blankUsernameAndPassword() {
        usernameField.clear();
        passwordField.clear();
        loginButton.click();
    }      
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void validUsernameAndPassword(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }



}
