package com.auto.htt.projects.vietjet;


import com.auto.htt.models.FlightInfoModel;
import com.auto.htt.models.PassengerModel;
import com.auto.htt.page.vietjet.enums.TypeFlight;
import com.codeborne.selenide.Selenide;
import com.auto.htt.page.vietjet.HomePage;
import com.auto.htt.projects.BaseTest;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase001 extends BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TestCase001.class);

    private final HomePage homePage = new HomePage();

    @DataProvider(name = "flightSearchDataProvider")
    public Object[][] flightSearchDataProvider() {
        return new Object[][]{
                {new FlightInfoModel(
                        "Thành phố Hồ Chí Minh", "Hà Nội",
                        "Round trip", "tomorrow", "3",
                        new PassengerModel("2", "0", "0"))}
        };
    }

    @Test(dataProvider = "flightSearchDataProvider")
    public void vietJetTest() {
        homePage.openHomePage();
        homePage.clickTypeOfFlight(TypeFlight.ONE_WAY);
        homePage.inputFromLocation("SGN");
        homePage.clickOptionAirportName("SGN");
        homePage.selectDestinationAirport("HAN");
//
//        homePage.clickDepartureDateCalendar();
//        homePage.selectDateInCalendar("2025","January", "6");
//        homePage.selectDateInCalendar("2025","January", "11");


//        System.out.println(FakerUtils.getFormatedCurrentDate());
//        System.out.println(FakerUtils.getDate(3));
        Selenide.sleep(5000000);
    }
}
