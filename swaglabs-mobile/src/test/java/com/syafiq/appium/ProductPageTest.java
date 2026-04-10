package com.syafiq.appium;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.syafiq.appium.drivers.DriverSingleton;
import com.syafiq.appium.pages.LoginPage;
import com.syafiq.appium.pages.ProductPage;
import io.appium.java_client.AppiumDriver;

public class ProductPageTest {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    
    // Logger untuk monitoring jalannya test
    Logger logger = LoggerFactory.getLogger(ProductPageTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("Setup: Menginisialisasi Driver dan Page Objects");
        DriverSingleton.getInstance("android"); //
        driver = DriverSingleton.getDriver();
        
        // SOLUSI: Inisialisasi object agar tidak NullPointerException
        loginPage = new LoginPage(driver); //
        productPage = new ProductPage(driver); //
        
        // Alur wajib: Login terlebih dahulu
        logger.info("Melakukan login otomatis untuk mengakses halaman produk");
        loginPage.validUsernameAndPassword("standard_user", "secret_sauce");
    }

    @Test(description = "Sort price low to high and verify")
    public void testSortByPriceLowToHigh() {
        logger.info("Memulai testing price sorting from low to high");
        
        // 1. Jalankan fungsi sort
        productPage.sortByPriceLowToHigh(); //
        logger.info("Berhasil mengklik filter Price (low to high)");
        
        // 2. Ambil data harga asli dari elemen UI
        List<WebElement> priceElements = productPage.getProductPrices();
        
        // Pastikan ada produk yang tampil untuk dibandingkan
        Assert.assertTrue(priceElements.size() >= 2, "Produk tidak cukup untuk dibandingkan");

        // Ambil teks harga produk pertama dan kedua
        String price1Text = priceElements.get(0).getText(); 
        String price2Text = priceElements.get(1).getText(); 
        
        logger.info("Harga produk ke-1: " + price1Text);
        logger.info("Harga produk ke-2: " + price2Text);

        // 3. Logika parsing string ke double (Menghapus simbol '$')
        double price1 = Double.parseDouble(price1Text.replace("$", ""));
        double price2 = Double.parseDouble(price2Text.replace("$", ""));

        // 4. Assertion untuk memastikan urutan benar (Kecil ke Besar)
        Assert.assertTrue(price1 <= price2, "Gagal: Harga pertama (" + price1 + ") lebih besar dari kedua (" + price2 + ")");
        
        logger.info("Verifikasi Sukses: Price sorting from low to high is correct");
    }

    @AfterClass
    public void tearDown() {
        logger.info("Menutup sesi testing");
        DriverSingleton.closeObjectInstance(); //
    }
}