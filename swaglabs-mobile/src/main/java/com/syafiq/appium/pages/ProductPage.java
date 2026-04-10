package com.syafiq.appium.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {

    public ProductPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<WebElement> productName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<WebElement> productPrices;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Price (low to high)']")
    private WebElement sortPriceLowToHigh;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")
    private WebElement firstAddToCartBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private WebElement cartIcon;

    public String getProductTitle() {
        return productTitle.getText();
    }

    public List<WebElement> getProductName() {
        return productName;
    }

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    public void sortByPriceLowToHigh() {
        filterButton.click();
        sortPriceLowToHigh.click();
    }

    public void addFirstProductToCart() {
        firstAddToCartBtn.click();
    }

    public void openCart() {
        cartIcon.click();
    }
}