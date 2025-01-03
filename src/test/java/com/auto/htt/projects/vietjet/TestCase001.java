package com.auto.htt.projects.vietjet;


import com.auto.htt.utils.FakerUtils;
import com.codeborne.selenide.Selenide;
import com.auto.htt.page.vietjet.HomePage;
import com.auto.htt.projects.BaseTest;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestCase001 extends BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TestCase001.class);

    private final HomePage homePage = new HomePage();

    @Test
    public void vietJetTest() {
//        homePage.openHomePage();
//        homePage.acceptCookie();
//        homePage.clickTypeOfFlight("roundTrip");
//        homePage.inputFromLocation("SGN");
//        homePage.clickOptionAirportName("SGN");
//        homePage.inputDestinationLocation("HAN");
//        homePage.clickOptionAirportName("HAN");
//
//        homePage.clickDepartureDateCalendar();
//        homePage.selectDateInCalendar("2025","January", "6");
//        homePage.selectDateInCalendar("2025","January", "11");


        System.out.println(FakerUtils.getFormatedCurrentDate());
        System.out.println(FakerUtils.getDate(3));
        Selenide.sleep(5000);
    }
}
