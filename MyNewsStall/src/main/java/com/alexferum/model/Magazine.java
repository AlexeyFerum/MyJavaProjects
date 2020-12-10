package com.alexferum.model;

import java.io.Serializable;

public class Magazine extends PeriodicalGood implements Serializable {
    public Magazine(String name, int price, String number) {
        super(name, price, number);
    }
}
