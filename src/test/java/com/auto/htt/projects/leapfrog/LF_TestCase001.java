package com.auto.htt.projects.leapfrog;

import com.auto.htt.page.leapfrog.LFBasePage;
import com.auto.htt.projects.BaseTest;
import org.testng.annotations.Test;

public class LF_TestCase001 extends BaseTest {

    private final LFBasePage homePage = new LFBasePage();

    @Test
    public void testLeapfrogHomePage() {
        homePage.openHomePage();
    }
}
