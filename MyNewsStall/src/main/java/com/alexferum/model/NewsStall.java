package com.alexferum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class NewsStall implements Serializable {
    @JsonIgnore
    private Map<Product, Integer> products;

    private Salesman salesman;

    @Override
    public String toString() {
        return "NewsStall{" +
                "products=" + products +
                ", salesman=" + salesman +
                '}';
    }

    @JsonProperty("products")
    private List<KeyValueContainer<Product, Integer>> getTeamList() {
        return products.entrySet().stream()
                .map(e -> new KeyValueContainer<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    @JsonProperty("products")
    private void setTeamList(List<KeyValueContainer<Product, Integer>> list) {
        products = list.stream()
                .collect(Collectors.toMap(KeyValueContainer::getKey, KeyValueContainer::getValue));
    }

    public NewsStall(Map<Product, Integer> products) {
        this.products = products;
    }

    public NewsStall(Map<Product, Integer> products, Salesman salesman) {
        this.products = products;
        this.salesman = salesman;
    }
    public NewsStall()
    {}

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }
}
