package htt.projects.vietjet;


import com.codeborne.selenide.Selenide;
import htt.page.vietjet.BasePage;
import htt.page.vietjet.HomePage;
import htt.projects.BaseTest;
import htt.utils.Constants;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestCase001 extends BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TestCase001.class);

    private final HomePage homePage = new HomePage();

    @Test
    public void vietJetTest() {
        homePage.openHomePage();
        homePage.acceptCookie();
        homePage.clickTypeOfFlight("roundTrip");
        homePage.inputFromLocation("SGN");
        homePage.clickOptionAirportName("SGN");
        homePage.inputDestinationLocation("HAN");
        homePage.clickOptionAirportName("HAN");

        homePage.clickDepartureDateCalendar();
        homePage.selectDateInCalendar("January 2025", "6");
        homePage.selectDateInCalendar("January 2025", "11");


        Selenide.sleep(5000);
    }
}
