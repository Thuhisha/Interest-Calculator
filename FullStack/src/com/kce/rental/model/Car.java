package com.kce.rental.model;

public class Car extends Vehical {
    private int seats;

    public Car(int id, String brand, String model, int seats) {
        super(id, brand, model);
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + " | Seats: " + seats;
    }
}

