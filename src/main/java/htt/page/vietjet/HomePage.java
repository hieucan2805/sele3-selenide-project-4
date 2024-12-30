package htt.page.vietjet;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{
    private final SelenideElement radioReturnFlight = $x("//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='roundTrip']");
    private final SelenideElement radioOneWayFlight = $x("//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='oneway']");
    private final String typeOfFlight = "//img[@src='/static/media/switch.d8860013.svg']/parent::div/preceding-sibling::div//input[@type='radio'and@value='%s']";


    @Step("Select Type of Flight")
    public void clickTypeOfFlight(String type){
        $x(String.format(typeOfFlight,type)).click();
    }


}
