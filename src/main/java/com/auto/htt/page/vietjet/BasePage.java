package com.auto.htt.page.vietjet;

import com.auto.htt.utils.LanguageHelper;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BasePage.class);

    private final SelenideElement buttonAcceptCookie = $x("//div[@id='popup-dialog-description']//following-sibling::div//button");
    private final SelenideElement buttonCancelAds = $x("//button[@id='NC_CTA_TWO']");
    private final SelenideElement imgAdsInfo = $x( "//alt='popup information'");
    private final SelenideElement buttonCloseAdsInfo = $x( "//img[@alt='popup information']/parent::div/preceding-sibling::button");

    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Navigate to Homepage")
    public void openHomePage() {
        String URL = LanguageHelper.getLocalizedURL();
        open(URL);
        log.debug("Navigate to {}", URL);
        acceptCookie();
//        cancelAds();
    }

    @Step("Wait And Accept Cookie")
    public void acceptCookie() {
        buttonAcceptCookie.shouldBe(visible, Duration.ofSeconds(5));
        log.info("Cookie pop-up appears");
        buttonAcceptCookie.shouldBe(visible).click();
    }

    @Step("Wait And Accept Cookie")
    public void cancelAds() {
        buttonCancelAds.shouldBe(visible, Duration.ofSeconds(5));
        buttonCancelAds.shouldBe(visible).click();
        log.info("Close ads pop-up");
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
