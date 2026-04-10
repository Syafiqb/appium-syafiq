package com.syafiq.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
    public CartPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private WebElement checkoutBtn;

    public void proceedToCheckout() {
        checkoutBtn.click();
    }
}