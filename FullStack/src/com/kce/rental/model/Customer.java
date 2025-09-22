package com.kce.rental.model;

public class Customer {
    private int id;
    private String name;
    private String phone;

    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public double getDiscountRate() { return 0.0; }

    @Override
    public String toString() {
        return "Customer ID: " + id + "  " + name + "  Phone: " + phone;
    }
}
