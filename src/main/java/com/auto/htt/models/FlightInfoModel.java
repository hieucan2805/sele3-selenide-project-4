package com.auto.htt.models;

import com.auto.htt.page.vietjet.enums.TypeFlight;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlightInfoModel {

    private String type;
    private String from;
    private String to;
    private String departureDate;
    private String duration;
    private PassengerModel passenger;

}
