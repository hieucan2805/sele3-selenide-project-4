package com.auto.htt.listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListener implements TestLifecycleListener {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AllureListener.class);

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
//		if (result.getStatus().equals(Status.FAILED)) {
//			if (WebDriverRunner.hasWebDriverStarted()) {
//				Allure.addAttachment(result.getName() + "_Failed_Screenshot", new ByteArrayInputStream(Objects.requireNonNull(Selenide.screenshot(OutputType.BYTES))));
//			}
//		}
        if (result.getStatus() != null &&
                (result.getStatus().equals(Status.BROKEN) || result.getStatus().equals(Status.FAILED))) {
            log.info("Test case \"{}\" has been \"{}\". Take a screenshot", result.getFullName(),
                    result.getStatus().value());
            try {
                byte[] buf = Selenide.screenshot(OutputType.BYTES);
                if (buf != null) {
                    ByteArrayInputStream input = new ByteArrayInputStream(buf);
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
