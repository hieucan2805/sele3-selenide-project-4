package com.auto.htt.utils;

import com.codeborne.selenide.PropertiesReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LanguageHelper {

    static PropertiesReader properties = new PropertiesReader("selenide.properties");

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
