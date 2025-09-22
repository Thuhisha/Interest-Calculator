package com.kce.rental.model;

public class PremiumCustomer extends Customer {
    private double discountRate;

    public PremiumCustomer(int id, String name, String phone, double discountRate) {
        super(id, name, phone);
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public String toString() {
        return "[Premium] " + super.toString() + " | Discount: " + (discountRate * 100) + "%";
    }
}
