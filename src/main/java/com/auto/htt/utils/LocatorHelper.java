package com.auto.htt.utils;

import com.google.gson.JsonObject;

public class LocatorHelper {
    private static JsonObject enLocalization;
    private static JsonObject viLocalization;

    // Initialize by loading the localization files
    static {
        String enFilePath = "path/to/en.json"; // Replace with the actual path
        String viFilePath = "path/to/vi.json"; // Replace with the actual path

        enLocalization = JsonUtils.getJsonObjects(enFilePath);
        viLocalization = JsonUtils.getJsonObjects(viFilePath);
    }

    /**
     * Retrieve a value from the localization file based on the language and key path
     *
     * @param language Language ("vi" or "en")
     * @param keyPath  Key path (e.g., "homePage.button.findFlight")
     * @return Localization value
     */
    public static String getLocalizedText(String language, String keyPath) {
        JsonObject localization = "vi".equalsIgnoreCase(language) ? viLocalization : enLocalization;
        return getValueFromKeyPath(localization, keyPath);
    }

    /**
     * Update a locator with text from the localization file
     *
     * @param locator  Locator template (e.g., "//*[text()='%s']")
     * @param language Language ("vi" or "en")
     * @param keyPath  Key path
     * @return Updated locator
     */
    public static String updateLocatorWithDynamicText(String locator, String language, String keyPath) {
        String localizedText = getLocalizedText(language, keyPath);
        return String.format(locator, localizedText);
    }

    /**
     * Helper method to retrieve a value from a key path in the JSON
     *
     * @param jsonObject JSON containing the localization data
     * @param keyPath    Key path (e.g., "homePage.button.findFlight")
     * @return Value at the specified key path
     */
    private static String getValueFromKeyPath(JsonObject jsonObject, String keyPath) {
        String[] keys = keyPath.split("\\.");
        JsonObject currentObject = jsonObject;
        String value = null;

        for (int i = 0; i < keys.length; i++) {
            if (i == keys.length - 1) {
                value = currentObject.get(keys[i]).getAsString();
            } else {
                currentObject = currentObject.getAsJsonObject(keys[i]);
            }
        }

        return value;
    }
}

