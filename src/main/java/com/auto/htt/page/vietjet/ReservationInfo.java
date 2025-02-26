package com.auto.htt.page.vietjet;

import com.auto.htt.utils.LocatorHelper;
import lombok.Getter;

public class ReservationInfo extends BasePage{

    @Getter
    private final LocatorHelper localeBundle = new LocatorHelper(ReservationInfo.class.getSimpleName());
    //Locator
    private final String labelFrom = "//img[@src='/static/media/departure-icon.25d3557e.svg']//following-sibling::p";
    private final String labelTo = "//img[@src='/static/media/arrival-icon.a05c5d78.svg']//following-sibling::p";
    private final String labelTypeAndPassenger = "//img[@src='/static/media/departure-icon.25d3557e.svg']//parent::div//preceding-sibling::p";
    private final String labelDeparturePrice ="//p[text()='%s']//following-sibling::div/h4";
    private final String labelReturnPrice ="//p[text()='%s']//following-sibling::div/h4";

    //Method
    public String getText(String ele){
        if(ele.contains("'%s'")){
            String newXpath = localeBundle.updateLocatorWithDynamicText(labelDeparturePrice, "text.DepartureFlight");
        }
        return null;
    }
}
