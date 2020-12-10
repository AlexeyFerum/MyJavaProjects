package com.alexferum.model;

import java.io.Serializable;

public class Book extends Product implements Serializable {
    private String publishingHouse;
    private String authors;

    public Book(String productName, int price, String publishingHouse, String authors) {
        super(productName, price);
        this.publishingHouse = publishingHouse;
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
