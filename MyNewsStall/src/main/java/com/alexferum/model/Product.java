package com.alexferum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private Integer price;

    public Product(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }
    public Product()
    {}

    public String getProductName() {
        return productName;
    }

    public void setGoodName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"productName\":\"" + productName + '\"' +
                ", \"price\":\"" + price +
                "\"}";
    }
}
