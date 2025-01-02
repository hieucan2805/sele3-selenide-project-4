package com.auto.htt.page.vietjet;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import com.auto.htt.utils.Constants;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BasePage.class);

    private final SelenideElement buttonAcceptCookie = $x("//div[@id='popup-dialog-description']//following-sibling::div//button");

    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Navigate to ")
    public void openHomePage() {
        open(Constants.VIETJET_EN);
        log.debug("Navigate to {}", Constants.VIETJET_EN);
    }

    @Step("Wait And Accept Cookie")
    public void acceptCookie() {
        buttonAcceptCookie.shouldBe(visible, Duration.ofSeconds(5));
//        if (buttonAcceptCookie.isDisplayed()) {
        log.info("Cookie pop-up appears");
        buttonAcceptCookie.shouldBe(visible).click();
//        }
    }

    protected boolean isElementsBlocked(SelenideElement element) {
        try {
            element.click();
        } catch (UIAssertionError e) {
            if (e.getMessage().contains("is not clickable at point")) {
                log.warn("The element {} is blocked by another element.", element);
            } else {
                log.error(e.getMessage());
                return false;
            }
        }
        return true;
    }
}
