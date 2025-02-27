package com.auto.htt.utils;

import com.codeborne.selenide.PropertiesReader;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class URLHelper {

    static PropertiesReader properties = new PropertiesReader("selenide.properties");

    public static String getLanguage() {
        return properties.getProperty("language", "en");
    }

    public static String getTestSuite() {
        return System.getProperty("test.suite", "vietjet").toLowerCase();
    }


    public static String getBaseURL() {
        String testSuite = getTestSuite();
        String baseUrl;

        if ("vietjet".equals(testSuite)) {
            baseUrl = properties.getProperty("baseUrl.vj", "https://vietjetair.com");
        } else if ("leapfrog".equals(testSuite)) {
            baseUrl = properties.getProperty("baseUrl.lf", "");
        } else {
            log.warn("Unknown test suite: {}. Defaulting to Vietjet base URL.", testSuite);
            baseUrl = properties.getProperty("baseUrl.vj", "https://vietjetair.com");
        }

        log.info("Using base URL: {}", baseUrl);
        return baseUrl;
    }

    public static String getLocalizedURL() {
        String testSuite = getTestSuite();
        String baseUrl = getBaseURL();

        // Only append language for Vietjet
        if ("vietjet".equals(testSuite)) {
            if (!baseUrl.endsWith("/")) {
                baseUrl += "/";
            }
            return baseUrl + getLanguage();
        }

        return baseUrl;
    }
}
