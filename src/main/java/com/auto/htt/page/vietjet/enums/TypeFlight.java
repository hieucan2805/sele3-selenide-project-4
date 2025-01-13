package com.auto.htt.page.vietjet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeFlight {

    ROUND_TRIP("radio.roundTrip"),
    ONE_WAY("radio.oneWay");

    private final String key;

}
