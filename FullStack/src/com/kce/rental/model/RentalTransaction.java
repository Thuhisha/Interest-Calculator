package com.kce.rental.model;

public class RentalTransaction {
    private static int counter = 1;
    private int rentalId;
    private Customer customer;
    private Vehical vehical;
    private int days;
    private double cost;

    public RentalTransaction(Customer customer, Vehical vehical, int days) {
        this.rentalId = counter++;
        this.customer = customer;
        this.vehical = vehical;
        this.days = days;
        this.cost = calculateCost();
        vehical.rent();
    }

    private double calculateCost() {
        double baseRate = (vehical instanceof Car) ? 1000 : 500;
        double total = baseRate * days;
        total -= total * customer.getDiscountRate(); // discount for premium
        return total;
    }

    public int getRentalId() { return rentalId; }
    public Customer getCustomer() { return customer; }
    public Vehical getVehical() { return vehical; }
    public double getCost() { return cost; }

    @Override
    public String toString() {
        return "Rental ID: " + rentalId + " | " + customer.getName() +
               " rented " + vehical.getBrand() + " " + vehical.getModel() +
               " for " + days + " days | Cost: " + cost;
    }
}
