package com.alexferum.model;

public class Client {
    private String clientName;
    private int clientAge;
    private String clientGender;

    public Client(String clientName, int clientAge, String clientGender) {
        this.clientName = clientName;
        this.clientAge = clientAge;
        this.clientGender = clientGender;
    }

    public String getClientGender() {
        return clientGender;
    }

    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
