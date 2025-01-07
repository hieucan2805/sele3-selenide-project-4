package com.auto.htt.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.PropertiesReader;

public class DriverFactory {

    public static void setupDriver() {
        PropertiesReader properties = new PropertiesReader("properties/selenide.properties");

        // Load properties vào Configuration
        Configuration.browser = properties.getProperty("browser", null);
        Configuration.browserSize = properties.getProperty("browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(properties.getProperty("timeout", "10000"));
        Configuration.baseUrl = properties.getProperty("baseUrl", null);
        Configuration.headless = Boolean.parseBoolean(properties.getProperty("headless", "false"));
        Configuration.pageLoadStrategy = properties.getProperty("pageLoadStrategy", "none");

    }

}
