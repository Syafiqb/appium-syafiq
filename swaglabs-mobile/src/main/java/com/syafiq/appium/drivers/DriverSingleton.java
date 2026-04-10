package com.syafiq.appium.drivers;

import java.time.Duration;

import com.syafiq.appium.drivers.strategies.DriverStrategy;
import com.syafiq.appium.drivers.strategies.DriverStrategyImplementer;

import io.appium.java_client.AppiumDriver;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static AppiumDriver driver;

    private DriverSingleton(String driverStrategy) {
        instantiate(driverStrategy);
    }

    public AppiumDriver instantiate(String strategy) {
        if (driver == null) {
            DriverStrategyImplementer driverStrategyImplementer = new DriverStrategyImplementer();
            DriverStrategy driverStrategy = driverStrategyImplementer.chooseStrategy(strategy);
            driver = driverStrategy.setStrategy();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver has not been initialized. Call getInstance() first.");
        }
        return driver;
    }

    public static void closeObjectInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        instance = null;
    }

}
