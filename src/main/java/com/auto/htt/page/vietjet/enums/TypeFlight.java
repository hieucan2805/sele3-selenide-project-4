package com.auto.htt.page.vietjet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeFlight {

    ROUND_TRIP("Round Trip","Khứ hồi"),
    ONE_WAY("One Way", "Một chiều");

    private final String viName;
    private final String enName;

    public String getVietnameseName() {
        return viName;
    }

    public String getEnglishName() {
        return enName;
    }
}
