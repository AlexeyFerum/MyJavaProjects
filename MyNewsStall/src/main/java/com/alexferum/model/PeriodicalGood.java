package com.alexferum.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class PeriodicalGood extends Product implements Serializable {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PeriodicalGood(String name, int price, String number) {
        super(name, price);
        this.number = number;
    }

    @Override
    @JsonValue
    public String toString() {
        return super.toString() + ", Issue " + number;
    }
}
