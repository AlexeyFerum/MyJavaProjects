package com.alexferum.model;

public class Salesman {
    private String salesmanName;
    private int salesmanAge;
    private String salesmanGender;

    public Salesman(String salesmanName, int salesmanAge, String salesmanGender) {
        this.salesmanName = salesmanName;
        this.salesmanAge = salesmanAge;
        this.salesmanGender = salesmanGender;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public int getSalesmanAge() {
        return salesmanAge;
    }

    public void setSalesmanAge(int salesmanAge) {
        this.salesmanAge = salesmanAge;
    }

    public String getSalesmanGender() {
        return salesmanGender;
    }

    public void setSalesmanGender(String salesmanGender) {
        this.salesmanGender = salesmanGender;
    }
}
