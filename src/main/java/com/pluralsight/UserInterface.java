
package com.pluralsight;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    private Dealership dealership;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.init();
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager("src/inventory.csv");
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        System.out.println("Welcome to the Car Dealership App!");
        System.out.println("********************************************");
        System.out.println("Please select an option from the menu below:");

        int choice;
        do {
            System.out.println("1. Find vehicles by price range");
            System.out.println("2. Find vehicles by make / model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7. List ALL vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Quit");
            System.out.println("********************************************");
            System.out.println("Enter your choice: ");
            choice = this.scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    this.processFindVehiclesByPriceRange();
                    break;
                case 2:
                    this.processFindVehiclesByMakeModel();
                    break;
                case 3:
                    this.processFindVehiclesByYearRange();
                    break;
                case 4:
                    this.processFindVehiclesByColor();
                    break;
                case 5:
                    this.processFindVehiclesByMileageRange();
                    break;
                case 6:
                    this.processFindVehiclesByType();
                    break;
                case 7:
                    this.processGetAllVehicles();
                    break;
                case 8:
                    this.processAddVehicle();
                    break;
                case 9:
                    this.processRemoveVehicle();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while(choice != 0);

    }

    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles != null && !vehicles.isEmpty()) {
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
            Iterator var2 = vehicles.iterator();

            while(var2.hasNext()) {
                Vehicle vehicle = (Vehicle)var2.next();
                System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s %-10d %-10.2f\n", vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getType(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice());
            }
        } else {
            System.out.println("No vehicles found.");
        }

    }

    public void processFindVehiclesByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = this.scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = this.scanner.nextDouble();
        List<Vehicle> vehicles = this.dealership.getVehiclesByPriceRange(minPrice, maxPrice);
        this.displayVehicles(vehicles);
    }

    public void processFindVehiclesByMakeModel() {
        System.out.print("Enter make: ");
        String make = this.scanner.next();
        System.out.print("Enter model: ");
        String model = this.scanner.next();
        List<Vehicle> vehicles = this.dealership.getVehiclesByMakeModel(make, model);
        this.displayVehicles(vehicles);
    }

    public void processFindVehiclesByYearRange() {
        System.out.print("Enter start year: ");
        int startYear = this.scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = this.scanner.nextInt();
        List<Vehicle> vehicles = this.dealership.getVehiclesByYearRange(startYear, endYear);
        this.displayVehicles(vehicles);
    }

    public void processFindVehiclesByColor() {
        System.out.print("Enter color: ");
        String color = this.scanner.next();
        List<Vehicle> vehicles = this.dealership.getVehiclesByColor(color);
        this.displayVehicles(vehicles);
    }

    public void processFindVehiclesByMileageRange() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = this.scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = this.scanner.nextInt();
        List<Vehicle> vehicles = this.dealership.getVehiclesByMileageRange(minMileage, maxMileage);
        this.displayVehicles(vehicles);
    }

    public void processFindVehiclesByType() {
        System.out.print("Enter type (car, truck, SUV, van): ");
        String type = this.scanner.next();
        List<Vehicle> vehicles = this.dealership.getVehiclesByType(type);
        this.displayVehicles(vehicles);
    }

    public void processGetAllVehicles() {
        List<Vehicle> vehicles = this.dealership.getAllVehicles();
        this.displayVehicles(vehicles);
    }

    public void processAddVehicle() {
        System.out.print("Enter vehicle ID: ");
        int id = this.scanner.nextInt();
        System.out.print("Enter vehicle make: ");
        String make = this.scanner.next();
        System.out.print("Enter vehicle model: ");
        String model = this.scanner.next();
        System.out.print("Enter vehicle year: ");
        int year = this.scanner.nextInt();
        System.out.print("Enter vehicle color: ");
        String color = this.scanner.next();
        System.out.print("Enter vehicle mileage: ");
        int mileage = this.scanner.nextInt();
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = this.scanner.next();
        System.out.print("Enter vehicle price: ");
        double price = this.scanner.nextDouble();
        Vehicle newVehicle = new Vehicle(id, make, model, year, color, mileage, type, price);
        this.dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicle() {
        System.out.print("Enter vehicle ID to remove: ");
        int vehicleId = this.scanner.nextInt();
        this.dealership.removeVehicle(vehicleId);
    }
}
