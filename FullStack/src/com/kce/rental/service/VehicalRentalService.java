package com.kce.rental.service;

import com.kce.rental.model.*;
import com.kce.rental.exception.*;
import java.util.*;

public class VehicalRentalService {
    private List<Vehical> vehicles = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Map<Integer, RentalTransaction> rentals = new HashMap<>();

    public void addVehicle(Vehical v) {
        vehicles.add(v);
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public RentalTransaction rentVehicle(int custId, int vehId, int days) 
            throws VehicalNotAvailableException, CustomerNotFoundException {
        Customer c = customers.stream().filter(m -> m.getId() == custId).findFirst().orElse(null);
        if (c == null) throw new CustomerNotFoundException("Customer not found!");

        Vehical v = vehicles.stream().filter(veh -> veh.getId() == vehId).findFirst().orElse(null);
        if (v == null || !v.isAvailable()) throw new VehicalNotAvailableException("Vehical not available!");

        RentalTransaction rt = new RentalTransaction(c, v, days);
        rentals.put(rt.getRentalId(), rt);
        return rt;
    }

    public Bill returnVehicle(int rentalId, int lateDays) {
        RentalTransaction rt = rentals.get(rentalId);
        if (rt == null) return null;

        ReturnTransaction rtx = new ReturnTransaction(rt, lateDays);
        Bill bill = new Bill(rt, rtx);
        return bill;
    }

    public void displayVehicles() {
        vehicles.forEach(System.out::println);
    }
}

