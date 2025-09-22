package com.kce.rental.model;

public class ReturnTransaction {
    private RentalTransaction rentalTxn;
    private int lateDays;
    private double penalty;

    public ReturnTransaction(RentalTransaction rentalTxn, int lateDays) {
        this.rentalTxn = rentalTxn;
        this.lateDays = lateDays;
        this.penalty = calculatePenalty();
        rentalTxn.getVehical().returnVehicle();
    }

    private double calculatePenalty() {
        return lateDays * 200; // penalty Rs.200/day
    }

    public double getPenalty() { return penalty; }

    @Override
    public String toString() {
        return "Returned Vehical: " + rentalTxn.getVehical().getModel() +
               " | Late Days: " + lateDays + " | Penalty: " + penalty;
    }
}

