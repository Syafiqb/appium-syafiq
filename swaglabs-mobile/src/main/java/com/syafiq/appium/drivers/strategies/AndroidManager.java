package com.syafiq.appium.drivers.strategies;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidManager implements DriverStrategy {

    @Override
    public AppiumDriver setStrategy() {
        // Implementasi strategi untuk Android
        // Kode untuk menginisialisasi dan mengembalikan AppiumDriver untuk Android
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3 API 29");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("10.0");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");
        options.setNoReset(true);

        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new IllegalStateException("Appium server URL is invalid", e);
        }   
        return driver;
    
    }   

}
