package com.syafiq.appium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.syafiq.appium.drivers.DriverSingleton;
import com.syafiq.appium.pages.CartPage;
import com.syafiq.appium.pages.CheckoutPage;
import com.syafiq.appium.pages.LoginPage;
import com.syafiq.appium.pages.ProductPage;

import io.appium.java_client.AppiumDriver;

public class CheckoutTest {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("android");
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.validUsernameAndPassword("standard_user", "secret_sauce");
    }

    @Test
    public void testEndToEndCheckout() {
        System.out.println("Memulai proses Add to Cart");
        productPage.addFirstProductToCart();
        productPage.openCart();

        System.out.println("Berada di halaman Cart, lanjut Checkout");
        cartPage.proceedToCheckout();

        System.out.println("Mengisi data diri di Checkout");
        checkoutPage.inputInformation("Syafiq", "Test", "12345");
        
        System.out.println("Menyelesaikan pesanan");
        checkoutPage.finishCheckout();

        String actualMessage = checkoutPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, "THANK YOU FOR YOU ORDER");
        System.out.println("Checkout Berhasil! Pesan: " + actualMessage);
    }

    @AfterClass
    public void tearDown() {
        DriverSingleton.closeObjectInstance();
    }
}