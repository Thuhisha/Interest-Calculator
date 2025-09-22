package com.kce.rental.main;

import com.kce.rental.model.*;
import com.kce.rental.service.*;
import com.kce.rental.exception.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        VehicalRentalService service = new VehicalRentalService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n Vehical Rental System ");
            System.out.println("1. Add Vehical");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Vehical");
            System.out.println("4. Return Vehical");
            System.out.println("5. Display Vehical");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    System.out.println("1. Car  2. Bike");
                    int type = sc.nextInt();
                    System.out.print("Enter ID, Brand, Model: ");
                    int id = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    if (type == 1) {
                        System.out.print("Seats: ");
                        int seats = sc.nextInt();
                        service.addVehicle(new Car(id, brand, model, seats));
                    } else {
                        System.out.print("CC: ");
                        int cc = sc.nextInt();
                        service.addVehicle(new Bike(id, brand, model, cc));
                    }
                }
                case 2 -> {
                    System.out.println("1. Normal  2. Premium");
                    int type = sc.nextInt();
                    System.out.print("Enter ID, Name, Phone: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String phone = sc.next();
                    if (type == 1)
                        service.addCustomer(new Customer(id, name, phone));
                    else
                        service.addCustomer(new PremiumCustomer(id, name, phone, 0.1));
                }
                case 3 -> {
                    try {
                        System.out.print("Enter Customer ID, Vehicle ID, Days: ");
                        int cid = sc.nextInt();
                        int vid = sc.nextInt();
                        int days = sc.nextInt();
                        RentalTransaction rt = service.rentVehicle(cid, vid, days);
                        System.out.println("Rental Created: " + rt);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter Rental ID, Late Days: ");
                    int rid = sc.nextInt();
                    int late = sc.nextInt();
                    Bill bill = service.returnVehicle(rid, late);
                    if (bill != null) System.out.println(bill);
                    else System.out.println("Rental not found!");
                }
                case 5 -> service.displayVehicles();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

