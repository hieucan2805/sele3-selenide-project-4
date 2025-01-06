package com.auto.htt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerModel {
    private int adults;
    private int child;
    private int baby;

    @Override
    public String toString() {
        return "Passenger{" +
                "adults=" + adults +
                ", child=" + child +
                ", baby=" + baby +
                '}';
    }
}
