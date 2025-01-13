package com.auto.htt.utils;


import java.util.Locale;
import java.util.ResourceBundle;

public class LocatorHelper {
    private final static ResourceBundle enBundle;
    private final static ResourceBundle viBundle;

    // Initialize by loading the localization files
    static {
        enBundle = ResourceBundle.getBundle("localization.homepage.text", Locale.ENGLISH);
        viBundle = ResourceBundle.getBundle("localization.homepage.text", Locale.forLanguageTag("vi-VN"));
    }

    /**
     * Retrieve a value from the localization file based on the language and key path
     *
     * @param language Language ("vi" or "en")
     * @param key      Key (e.g., "homePage.button.findFlight")
     * @return Localization value
     */
    public static String getLocalizedText(String language, String key) {
        if ("vi".equalsIgnoreCase(language)) {
            return viBundle.getString(key);
        } else {
            return enBundle.getString(key);
        }
    }

    /**
     * Update a locator with text from the properties file
     *
     * @param locator  Locator template (e.g., "//*[text()='%s']")
     * @param language Language ("vi" or "en")
     * @param key      Key (e.g., "button.findFlight")
     * @return Updated locator
     */
    public static String updateLocatorWithDynamicText(String locator, String language, String key) {
        String localizedText = getLocalizedText(language, key);
        return String.format(locator, localizedText);
    }
}

