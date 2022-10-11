package main.java;

import java.util.UUID;

public class Broker {
    private UUID brokerId;
    private String name;
    private String company;
    private String address;
    private String phoneNumber;

    public Broker(String name, String company, String address, String phoneNumber){
        this.brokerId = UUID.randomUUID();
        this.name = name;
        this.company = company;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Broker(Broker b) {
        this.brokerId = b.brokerId;
        this.name = b.name;
        this.company = b.company;
        this.address = b.address;
        b. phoneNumber = b.phoneNumber;
    }

    public UUID getBrokerId() {
        return this.brokerId;
    }

    public String getName() {
        return this.name;
    }

    public String getCompany() {
        return this.company;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
