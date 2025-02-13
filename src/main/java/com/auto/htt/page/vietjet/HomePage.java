package com.auto.htt.page.vietjet;

import com.auto.htt.models.FlightInfoModel;
import com.auto.htt.models.PassengerModel;
import com.auto.htt.page.vietjet.enums.Airport;
import com.auto.htt.page.vietjet.enums.TypeFlight;
import com.auto.htt.utils.Constants;
import com.auto.htt.utils.FakerUtils;
import com.auto.htt.utils.LanguageHelper;
import com.auto.htt.utils.LocatorHelper;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    private final String language = LanguageHelper.getLanguage();

    @Getter
    private final LocatorHelper localeBundle = new LocatorHelper(HomePage.class.getSimpleName());

    private final String radioReturnFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='roundTrip']";
    private final String radioOneWayFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='oneway']";
    private final String typeOfFlight = "//span[text()='%s']";
    private final String inputFrom = "//input[@class='MuiInputBase-input MuiOutlinedInput-input' and not(@id)]";
    private final String buttonDepartureDate = "//input[@class='MuiInputBase-input MuiOutlinedInput-input' and not(@id='arrivalPlaceDesktop')]//ancestor::div[.//div[@role='button']]/div[@role='button']";
    private final String inputDestination = "//input[@class='MuiInputBase-input MuiOutlinedInput-input' and @id]";
    private final String buttonReturnDate = "//img[@src='/static/media/switch.d8860013.svg']/following-sibling::div/following-sibling::div//p";
    private final String optionAirportName = "//div[@id='panel1a-content']//div[text()='%s']";
    private final String buttonDateAtCalendar = "//div[@class='rdrMonth' and contains(div,'%s')]//span[text()='%s']";
    private final String panelCalendar = "//div[@class='rdrCalendarWrapper rdrDateRangeWrapper']";
    private final String labelMonthInCalendar = "//div[@class='rdrMonthName']";
    private final String buttonPrevMonth = "//button[@class='rdrNextPrevButton rdrPprevButton']";
    private final String buttonNextMonth = "//button[@class='rdrNextPrevButton rdrNextButton']";
    private final String labelDateInCalendar = "//div[text()='%s']//following-sibling::div[@class='rdrDays']//span[text()='%s']";
    private final String dropdownPassenger = "//input[starts-with(@id,'input-base-custom-')]";
    private final String buttonDecreaseAdult = "//div[div[div[img[@alt='adults']]]]//button[1]";
    private final String buttonIncreaseAdult = "//div[div[div[img[@alt='adults']]]]//button[2]";
    private final String buttonDecreaseChild = "//div[div[div[img[@alt='children']]]]//button[1]";
    private final String buttonIncreaseChild = "//div[div[div[img[@alt='children']]]]//button[2]";
    private final String buttonDecreaseInfant = "//div[div[div[img[@alt='baby']]]]//button[1]";
    private final String buttonIncreaseInfant = "//div[div[div[img[@alt='baby']]]]//button[2]";
    private final String buttonDecreasePassenger = "//div[div[div[img[@alt='%s']]]]//button[1]";
    private final String labelPassenger = "//div[div[div[img[@alt='%s']]]]//button[1]//following-sibling::span[@weight]";
    private final String buttonIncreasePassenger = "//div[div[div[img[@alt='%s']]]]//button[2]";
    private final String buttonSearchFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/following-sibling::div//button/span[@class='MuiButton-label']";

    //Actions block
    @Step("Select Type of Flight")
    public void clickTypeOfFlight(String typeFlight) {
        String type_xpath = TypeFlight.fromName(typeFlight).getXPathKey();
        String typeFlight_newXpath = localeBundle.updateLocatorWithDynamicText(typeOfFlight, type_xpath);

        $x(typeFlight_newXpath).click();
    }

    @Step("Select the One Way Flight")
    public void selectOneWayFlight() {
        $x(radioOneWayFlight).click();
    }

    @Step("Select the Return Flight")
    public void selectReturnFlight() {
        $x(radioReturnFlight).click();
    }

    public void inputFromLocation(String location) {
        $x(inputFrom).click();
        $x(inputFrom).setValue(location);
    }

    public void inputDestinationLocation(String location) {
        $x(inputDestination).click();
        $x(inputDestination).setValue(location);
    }

    public void clickOptionAirportName(String airport) {
        String formatedOptionAirportName = String.format(optionAirportName, airport);
        $x(formatedOptionAirportName).shouldBe(visible, Constants.SHORT_WAIT);
        $x(formatedOptionAirportName).click();
    }

    @Step("Select the Location")
    public void selectAirport(String from, String to) {
        String fromPort = Airport.findByName(from);
        String toPort = Airport.findByName(to);

        inputFromLocation(fromPort);
        clickOptionAirportName(fromPort);

        inputDestinationLocation(toPort);
        clickOptionAirportName(toPort);
    }

    public void clickDepartureDateCalendar() {
        $x(buttonDepartureDate).shouldBe(visible, Constants.SHORT_WAIT);
        $x(panelCalendar).shouldBe(visible, Constants.SHORT_WAIT);
    }

    public void clickReturnDateCalendar() {
        $x(buttonReturnDate).shouldBe(visible, Constants.SHORT_WAIT);
        $x(buttonReturnDate).click();
    }

    public void selectDateInCalendar(String date) {
        String tmp_date = FakerUtils.parseSelectedDate(date);
        String targetMonth = tmp_date.split(",", 0)[1].trim();
        String targetDate = tmp_date.split(",", 0)[0].trim();
        String dateTmpXpath = String.format(labelDateInCalendar, targetMonth, targetDate);

        if (!$x(panelCalendar).isDisplayed())
            $x(buttonReturnDate).click();

        gotoMonth(targetMonth);
        $x(dateTmpXpath).click();
    }

    public void gotoMonth(String month) {
        $x(labelMonthInCalendar).shouldBe(visible, Constants.VERY_SHORT_WAIT);

        while (!($x(labelMonthInCalendar).getText().trim()).equalsIgnoreCase(month)) {
            $x(buttonNextMonth).click();
            $x(labelMonthInCalendar).shouldHave(visible, Constants.VERY_SHORT_WAIT);
        }
    }

    public void selectDepartureDateAndReturnDate(String deptDate, String returnDate) {
        selectDateInCalendar(deptDate);
        selectDateInCalendar(returnDate);
    }

    public void selectDepartureDateAndDuration(String deptDate, String duration) {
        selectDateInCalendar(deptDate);
        selectDateInCalendar(FakerUtils.getNewDate(FakerUtils.parseSelectedDate(deptDate),duration));
    }

    @Step("Select passenger")
    public void selectPassenger(PassengerModel passenger) {
        selectPassenger("adults", passenger.getAdults());
        selectPassenger("children", passenger.getChild());
        selectPassenger("baby", passenger.getBaby());
    }

    public void selectPassenger(String passenger, String number) {
        String labelXpath = String.format(labelPassenger, passenger);
        String buttonIncreaseXpath = String.format(buttonIncreasePassenger, passenger);
        String buttonDecreaseXpath = String.format(buttonDecreasePassenger, passenger);
        String currentCount = $x(labelXpath).shouldBe(visible, Constants.SHORT_WAIT).getText();

        if (!$x(labelXpath).isDisplayed())
            $x(dropdownPassenger).click();

        while (Integer.parseInt(currentCount) != Integer.parseInt(number)) {
            if (Integer.parseInt(currentCount) < Integer.parseInt(number)) {
                $x(buttonIncreaseXpath).click(); // Click "+" if less
            } else {
                $x(buttonDecreaseXpath).click(); // Click "-" if more
            }

            $x(labelXpath).shouldNotHave(text(currentCount), Constants.VERY_SHORT_WAIT);
            currentCount = $x(labelXpath).getText();
        }
    }

    @Step("Fill information to search")
    public void fillFlightInfo(FlightInfoModel flightInfoModel) {
        clickTypeOfFlight(flightInfoModel.getType());

        selectAirport(flightInfoModel.getFrom(), flightInfoModel.getTo());
        if(flightInfoModel.getDuration().isEmpty()){
            selectDateInCalendar(flightInfoModel.getDepartureDate());
        }else {
            selectDepartureDateAndDuration(flightInfoModel.getDepartureDate(),flightInfoModel.getDuration());
        }

        selectPassenger(flightInfoModel.getPassenger());

    }

    @Step("Search Flight with information")
    public void searchFlightWithInfo(FlightInfoModel flightInfoModel) {
        fillFlightInfo(flightInfoModel);

        $x(buttonSearchFlight).click();
    }


}
