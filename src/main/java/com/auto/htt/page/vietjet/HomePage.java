package com.auto.htt.page.vietjet;

import com.auto.htt.page.vietjet.enums.TypeFlight;
import com.auto.htt.utils.Constants;
import com.auto.htt.utils.FakerUtils;
import com.auto.htt.utils.LanguageHelper;
import com.auto.htt.utils.LocatorHelper;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    private final String language = LanguageHelper.getLanguage();


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
    private final String buttonPrevMonth = "//button[@class='rdrNextPrevButton rdrPprevButton']";
    private final String buttonNextMonth = "//button[@class='rdrNextPrevButton rdrNextButton']";
    private final String dropdownPassenger = "//input[starts-with(@id,'input-base-custom-')]";
    private final String buttonDecreaseAdult = "//div[div[div[img[@alt='adults']]]]//button[1]";
    private final String buttonIncreaseAdult = "//div[div[div[img[@alt='adults']]]]//button[2]";
    private final String buttonDecreaseChild = "//div[div[div[img[@alt='children']]]]//button[1]";
    private final String buttonIncreaseChild= "//div[div[div[img[@alt='children']]]]//button[2]";
    private final String buttonDecreaseInfant = "//div[div[div[img[@alt='baby']]]]//button[1]";
    private final String buttonIncreaseInfant  = "//div[div[div[img[@alt='baby']]]]//button[2]";
    private final String buttonSearchFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/following-sibling::div//button/span[@class='MuiButton-label']";

    //Actions block
    @Step("Select Type of Flight")
    public void clickTypeOfFlight(TypeFlight type) {
    String a =    LocatorHelper.updateLocatorWithDynamicText(typeOfFlight,type.getKey());

        $x(a).click();
    }

    @Step("Select the One Way Flight")
    public void selectOneWayFlight() {
        $x(radioOneWayFlight).click();
    }

    @Step("Select the Return Flight")
    public void selectReturnFlight() {
        $x(radioReturnFlight).click();
    }

    @Step("Input the From Location")
    public void inputFromLocation(String location) {
        $x(inputFrom).click();
        $x(inputFrom).setValue(location);
    }

    @Step("Select the Destination Location")
    public void selectDestinationAirport(String location){
        inputDestinationLocation(location);
        clickOptionAirportName(location);
    }

    public void inputDestinationLocation(String location) {
        $x(inputDestination).click();
        $x(inputDestination).setValue(location);
    }

    public void clickOptionAirportName(String destination) {
        String formatedOptionAirportName = String.format(optionAirportName, destination);
        $x(formatedOptionAirportName).shouldBe(visible, Constants.SHORT_WAIT);
        $x(formatedOptionAirportName).click();
    }

    public void clickDepartureDateCalendar() {
        $x(buttonDepartureDate).shouldBe(visible, Constants.SHORT_WAIT);
            $x(panelCalendar).shouldBe(visible,Constants.SHORT_WAIT);

    }

    public void selectDateInCalendar(String year, String month, String date) {
        $x(panelCalendar).shouldBe(visible,Duration.ofSeconds(10));
        String strMonthYear = STR."\{month} \{year}";
        String departureDate = String.format(buttonDateAtCalendar, strMonthYear, date);
        $x(departureDate).shouldBe(visible, Constants.SHORT_WAIT);
        $x(departureDate).click();
    }

    public void selectDateInCalendar(Object date) {
//        $x(panelCalendar).shouldBe(visible,Duration.ofSeconds(10));

        String tmp_date = FakerUtils.getDate(date);

        System.out.println(tmp_date);

    }

    public void clickReturnDateCale() {
        $x(buttonReturnDate).shouldBe(visible, Constants.SHORT_WAIT);
        $x(buttonReturnDate).click();
    }


}
