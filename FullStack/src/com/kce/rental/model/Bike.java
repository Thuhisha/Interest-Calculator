package com.kce.rental.model;

public class Bike extends Vehical {
    private int cc;

    public Bike(int id, String brand, String model, int cc) {
        super(id, brand, model);
        this.cc = cc;
    }

    @Override
    public String toString() {
        return super.toString() + " | CC: " + cc;
    }
}
