package com.auto.htt.page.vietjet;

import com.auto.htt.utils.LocatorHelper;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class ReservationInfo extends BasePage{

    @Getter
    private final LocatorHelper localeBundle = new LocatorHelper(ReservationInfo.class.getSimpleName());
    //Locator
    private final String labelFrom = "//img[@src='/static/media/departure-icon.25d3557e.svg']//following-sibling::p";
    private final String labelTo = "//img[@src='/static/media/arrival-icon.a05c5d78.svg']//following-sibling::p";
    private final String labelTypeAndPassenger = "//img[@src='/static/media/departure-icon.25d3557e.svg']//parent::div//preceding-sibling::p";
    private final String labelPrice ="//p[text()='%s']//following-sibling::div/h4";
    private final String labelReturnPrice ="//p[text()='%s']//following-sibling::div/h4";

    //Method
    public String getLabelFromText(){
        return  $x(labelFrom).getText();
    }

    public String getLabelToText(){
        return  $x(labelTo).getText();
    }


    public String getTypeOfFlightText(){
        String tmp_text=  $x(labelTypeAndPassenger).getText();
        return tmp_text.split("\\|")[0].trim();
    }

    public String getPassengerText(){
        String tmp_text=  $x(labelTypeAndPassenger).getText();
        return tmp_text.split("\\|")[1].trim();
    }
}
