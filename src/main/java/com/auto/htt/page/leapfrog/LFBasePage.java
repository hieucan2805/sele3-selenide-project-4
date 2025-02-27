package com.auto.htt.page.leapfrog;

import com.auto.htt.utils.URLHelper;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

public class LFBasePage {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LFBasePage.class);

    @Step("Navigate to Leapfrog Homepage")
    public void openHomePage() {
        String URL = URLHelper.getBaseURL();
        open(URL);
        System.out.println("Navigate to " + URL);
//        log.debug("Navigate to {}", URL);
    }
}
