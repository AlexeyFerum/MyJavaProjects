package com.alexferum.model;

import java.io.Serializable;

public class Newspaper extends PeriodicalGood implements Serializable {
    public Newspaper(String name, int price, String number) {
        super(name, price, number);
    }
}
