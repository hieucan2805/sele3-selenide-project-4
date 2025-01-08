package com.auto.htt.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ElementHelper {

    public static String updateLocatorWithDynamicText(String locator, String locale) {
        // Constructing the locator with dynamic text
        return  String.format(locator, locale);

    }

    public static String getElementByTargetLanguage(String language, String locator) {
        // id='%s' => if language = vi -> return id = Tu
        // id='%s' => if language = en -> return id = From
    }
}
