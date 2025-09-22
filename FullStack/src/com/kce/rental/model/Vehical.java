package com.kce.rental.model;

public abstract class Vehical {
    private int id;
    private String brand;
    private String model;
    private boolean available;

    public Vehical(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.available = true;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }

    public void rent() { this.available = false; }
    public void returnVehicle() { this.available = true; }

    @Override
    public String toString() {
        return "ID: " + id + " | " + brand + " " + model + " | Available: " + available;
    }
}

