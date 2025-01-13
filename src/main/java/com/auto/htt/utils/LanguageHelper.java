package com.auto.htt.utils;

import com.codeborne.selenide.PropertiesReader;


public class LanguageHelper {

    static PropertiesReader properties = new PropertiesReader("properties/selenide.properties");

    public static String getLanguage() {
        return properties.getProperty("language", "en");
    }

    public static String getLocalizedURL() {
        String baseUrl = properties.getProperty("baseUrl","");
        // Check and concat URL
        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        return baseUrl + getLanguage();
    }

}
