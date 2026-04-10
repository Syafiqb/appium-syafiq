package com.syafiq.appium.drivers.strategies;

public class DriverStrategyImplementer {
    public DriverStrategy chooseStrategy(String strategy) {
        switch (strategy.toLowerCase()) {
            case "android":
                return new AndroidManager();
            case "ios":
                return new IOSManager();
            default:
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
        }
    }
}


