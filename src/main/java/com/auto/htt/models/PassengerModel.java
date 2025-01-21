package com.auto.htt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PassengerModel {
    private String adults;
    private String child;
    private String baby;

    @Override
    public String toString() {
        return STR."Passenger{adults=\{adults}, child=\{child}, baby=\{baby}}";
    }
}
