package com.auto.htt.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocatorHelper {
    private final static ResourceBundle localBundle;

    private static final String language = LanguageHelper.getLanguage();

    // Initialize by loading the localization files
    static {
        localBundle = ResourceBundle.getBundle("localization.homepage", Locale.of(language));
    }

    /**
     * Retrieve a value from the localization file based on the language and key path
     * @param key      Key (e.g., "homePage.button.findFlight")
     * @return Localization value
     */
    public static String getLocalizedText(String key) {
        return localBundle.getString(key);
    }

    /**
     * Update a locator with text from the properties file
     * @param locator  Locator template (e.g., "//*[text()='%s']")
     * @param key      Key (e.g., "button.findFlight")
     * @return Updated locator
     */
    public static String updateLocatorWithDynamicText(String locator, String key) {
        String localizedText = getLocalizedText(key);
        return String.format(locator, localizedText);
    }

}

