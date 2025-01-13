package com.auto.htt.listeners;


import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.util.UUID;

@Log4j2
public class AllureListener implements TestLifecycleListener {

    @Override
    public void beforeTestSchedule(TestResult result) {
    }

    @Override
    public void afterTestSchedule(TestResult result) {
    }

    @Override
    public void beforeTestUpdate(TestResult result) {
    }

    @Override
    public void afterTestUpdate(TestResult result) {
    }

    @Override
    public void beforeTestStart(TestResult result) {
    }

    @Override
    public void afterTestStart(TestResult result) {
    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (result.getStatus() != null &&
                (result.getStatus().equals(Status.BROKEN) || result.getStatus().equals(Status.FAILED))) {
            log.info("Test case \"{}\" has been \"{}\". Take a screenshot", result.getFullName(),
                    result.getStatus().value());
            try {
                byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
                if (screenshot != null) {
                    ByteArrayInputStream input = new ByteArrayInputStream(screenshot);
                    Allure.attachment(UUID.randomUUID().toString(), input);
                }
            } catch (Exception e) {
                log.error("An error occurs when adding screenshot to report: \n{}", e.getMessage());
            }
        }
    }

    @Override
    public void afterTestStop(TestResult result) {
    }

    @Override
    public void beforeTestWrite(TestResult result) {
    }

    @Override
    public void afterTestWrite(TestResult result) {
    }

}
