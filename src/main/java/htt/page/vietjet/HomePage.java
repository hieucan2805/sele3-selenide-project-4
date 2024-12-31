package htt.page.vietjet;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{
    private final String radioReturnFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='roundTrip']";
    private final String radioOneWayFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='oneway']";
    private final String inputFrom = "//input[@class='MuiInputBase-input MuiOutlinedInput-input' and not(@id)]";
    private final String buttonDepartureDate = "";
    private final String inputDestination = "//input[@class='MuiInputBase-input MuiOutlinedInput-input' and @id]";
    private final String buttonReturnDate = "//img[@src='/static/media/switch.d8860013.svg']/following-sibling::div/following-sibling::div//p";
    private final String typeOfFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='%s']";
    private final String dropdownPassenger = "//input[starts-with(@id,'input-base-custom-')]";
    private final String buttonSearchFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/following-sibling::div//button/span[@class='MuiButton-label']";


    @Step("Select Type of Flight")
    public void clickTypeOfFlight(String type){
//        $x(String.format(typeOfFlight,type)).click();
        $x(radioOneWayFlight).click();
    }


}
