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
        try (Scanner scanner = new Scanner(new File(filename))) {
            Dealership dealership = null;
            if (scanner.hasNextLine()) {
                String[] info = scanner.nextLine().split("\\|");
                dealership = new Dealership(info[0], info[1], info[2]);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] vehicleData = line.split("\\|");
                    Vehicle vehicle = new Vehicle(
                            Integer.parseInt(vehicleData[0]),
                            vehicleData[2], vehicleData[3], Integer.parseInt(vehicleData[1]),
                            vehicleData[5], Integer.parseInt(vehicleData[6]), vehicleData[4],
                            Double.parseDouble(vehicleData[7])
                    );
                    dealership.addVehicle(vehicle);
                }
            }
            return dealership;
        } catch (FileNotFoundException e) {
            System.out.println("Error: Inventory file not found.");
            return null;
        }
    }
}
