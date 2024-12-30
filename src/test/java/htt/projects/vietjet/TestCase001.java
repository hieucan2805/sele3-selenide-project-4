package htt.projects.vietjet;


import com.codeborne.selenide.Selenide;
import htt.page.vietjet.BasePage;
import htt.page.vietjet.HomePage;
import htt.projects.BaseTest;
import htt.utils.Constants;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.refresh;

public class TestCase001 extends BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TestCase001.class);

    private final HomePage homePage = new HomePage();

    @Test
    public void vietJetTest() {
        homePage.openHomePage();

        Selenide.sleep(10000);
        executeJavaScript("localStorage.setItem('cookieConsent', 'true')");
        refresh();
        Assert.assertTrue(homePage.isAcceptCookiePopUpAppear(),"The Cookie Popup doesn't appear");

    }
}
