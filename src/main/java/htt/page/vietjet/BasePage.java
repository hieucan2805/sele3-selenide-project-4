package htt.page.vietjet;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.UIAssertionError;
import htt.utils.Constants;
import htt.utils.FileUtils;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BasePage.class);

    private final SelenideElement buttonAcceptCookie = $x("//div[@id='popup-dialog-description']//following-sibling::div//button");

    protected void waitForVisible(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Navigate to ")
    public void openHomePage (){
        open(Constants.VIETJET_VI);
        log.info("Navigate to {}", Constants.VIETJET_EN);
    }

    @Step("Wait And Accept Cookie")
    public void waitAndAcceptCookie() {
        if (isAcceptCookiePopUpAppear()) {
            log.info("Cookie pop-up appears");
            waitForVisible(buttonAcceptCookie);
            buttonAcceptCookie.click();
        }
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

    public boolean isAcceptCookiePopUpAppear() {
        return buttonAcceptCookie.exists();
    }
}
