package htt.page.vietjet;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class HomePage extends BasePage {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomePage.class);


    private final String radioReturnFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='roundTrip']";
    private final String radioOneWayFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='oneway']";
    private final String typeOfFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='%s']";
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
    private final String buttonSearchFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/following-sibling::div//button/span[@class='MuiButton-label']";

    //Actions block
    @Step("Select Type of Flight")
    public void clickTypeOfFlight(String type) {
        $x(String.format(typeOfFlight, type)).click();
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

    @Step("Input the Destination Location")
    public void inputDestinationLocation(String location) {
        $x(inputDestination).click();
        $x(inputDestination).setValue(location);
    }

    public void clickOptionAirportName(String destination) {
        String formatedOptionAirportName = String.format(optionAirportName, destination);
        $x(formatedOptionAirportName).shouldBe(visible, Duration.ofSeconds(5));
        $x(formatedOptionAirportName).click();
    }

    public void clickDepartureDateCalendar() {
        $x(buttonDepartureDate).shouldBe(visible, Duration.ofSeconds(5));
            $x(panelCalendar).shouldBe(visible,Duration.ofSeconds(5));

//        while (!($x(panelCalendar).isDisplayed())){
//            $x(buttonDepartureDate).click();
//            $x(panelCalendar).shouldBe(visible,Duration.ofSeconds(5));
//        }
    }

    public void selectDateInCalendar(String month, String date) {
        sleep(10);
        String departureDate = String.format(buttonDateAtCalendar, month, date);

        log.info(String.valueOf($x(departureDate).isDisplayed()));

        $x(departureDate).shouldBe(visible, Duration.ofSeconds(5));
        $x(departureDate).click();
    }


    public void clickReturnDateCale() {
        $x(buttonReturnDate).shouldBe(visible, Duration.ofSeconds(5));
        $x(buttonReturnDate).click();
    }


}
