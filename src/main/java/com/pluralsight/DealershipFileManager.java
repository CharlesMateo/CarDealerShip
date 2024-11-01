
package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DealershipFileManager {
    private String filename;

    public DealershipFileManager(String filename) {
        this.filename = filename;
    }

    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            Scanner scanner = new Scanner(new File(this.filename));

            try {
                if (scanner.hasNextLine()) {
                    String[] dealershipInfo = scanner.nextLine().split("\\|");
                    dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

                    while(scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] vehicleInfo = line.split("\\|");
                        int vin = Integer.parseInt(vehicleInfo[0]);
                        int year = Integer.parseInt(vehicleInfo[1]);
                        String make = vehicleInfo[2];
                        String model = vehicleInfo[3];
                        String type = vehicleInfo[4];
                        String color = vehicleInfo[5];
                        int mileage = Integer.parseInt(vehicleInfo[6]);
                        double price = Double.parseDouble(vehicleInfo[7]);
                        Vehicle vehicle = new Vehicle(vin, make, model, year, color, mileage, type, price);
                        dealership.addVehicle(vehicle);
                    }
                }
            } catch (Throwable var17) {
                try {
                    scanner.close();
                } catch (Throwable var16) {
                    var17.addSuppressed(var16);
                }

                throw var17;
            }

            scanner.close();
        } catch (FileNotFoundException var18) {
            System.out.println("Error: Inventory file not found.");
        } catch (NumberFormatException var19) {
            NumberFormatException e = var19;
            System.out.println("Error: Invalid number format in inventory file.");
            e.printStackTrace();
        }

        return dealership;
    }
}
