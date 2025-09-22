package com.kce.rental.model;

public class Bill {
    private RentalTransaction rentalTxn;
    private ReturnTransaction returnTxn;
    private double finalAmount;

    public Bill(RentalTransaction rentalTxn, ReturnTransaction returnTxn) {
        this.rentalTxn = rentalTxn;
        this.returnTxn = returnTxn;
        this.finalAmount = rentalTxn.getCost() + returnTxn.getPenalty();
    }

    @Override
    public String toString() {
        return " BILL\n" +
               rentalTxn + "\n" +
               returnTxn + "\n" +
               "Final Amount: " + finalAmount + "\n";
    }
}

