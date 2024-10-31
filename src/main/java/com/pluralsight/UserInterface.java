package com.pluralsight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Dealership dealership;
    private final ContractFileManager contractFileManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.dealership = new DealershipFileManager("src/inventory.csv").getDealership();
        this.contractFileManager = new ContractFileManager("src/contracts.txt");
    }

    public void display() {
        System.out.println("Welcome to the Car Dealership App!");
        System.out.println("********************************************");

        int choice;
        do {
            System.out.println("Please select an option from the menu below:");
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
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 0 -> System.out.println("Exiting...");
                case 1 -> processFindVehiclesByPriceRange();
                case 2 -> processFindVehiclesByMakeModel();
                case 3 -> processFindVehiclesByYearRange();
                case 4 -> processFindVehiclesByColor();
                case 5 -> processFindVehiclesByMileageRange();
                case 6 -> processFindVehiclesByType();
                case 7 -> processGetAllVehicles();
                case 8 -> processAddVehicle();
                case 9 -> processRemoveVehicle();
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "ID", "Year", "Make", "Model", "Type", "Color", "Mileage", "Price");
        vehicles.forEach(vehicle -> System.out.printf("%-10s %-10d %-10s %-10s %-10s %-10s %-10d %-10.2f\n",
                vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                vehicle.getType(), vehicle.getColor(), vehicle.getMileage(), vehicle.getPrice()));
    }

    public void processFindVehiclesByPriceRange() {
        try {
            System.out.print("Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            List<Vehicle> vehicles = dealership.getVehiclesByPriceRange(minPrice, maxPrice);
            displayVehicles(vehicles);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void processFindVehiclesByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine(); // Changed to nextLine()

        System.out.print("Enter model: ");
        String model = scanner.nextLine(); // Changed to nextLine()

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByYearRange() {
        System.out.print("Enter start year: ");
        int startYear = getIntInput();
        System.out.print("Enter end year: ");
        int endYear = getIntInput();
        List<Vehicle> vehicles = dealership.getVehiclesByYearRange(startYear, endYear);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByMileageRange() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = getIntInput();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = getIntInput();
        List<Vehicle> vehicles = dealership.getVehiclesByMileageRange(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    public void processFindVehiclesByType() {
        System.out.print("Enter type (car, truck, SUV, van): ");
        String type = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    public void processGetAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicle() {
        System.out.print("Enter vehicle ID: ");
        int id = getIntInput();

        // Use nextLine() for string inputs to capture full line
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine(); // Changed to nextLine()

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine(); // Changed to nextLine()

        System.out.print("Enter vehicle year: ");
        int year = getIntInput();

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine(); // Changed to nextLine()

        System.out.print("Enter vehicle mileage: ");
        int mileage = getIntInput();

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine(); // Changed to nextLine()

        System.out.print("Enter vehicle price: ");
        double price = scanner.nextDouble(); // Use nextDouble() for numeric input

        // Optionally consume the remaining newline after nextDouble()
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(id, make, model, year, color, mileage, type, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicle() {
        System.out.print("Enter vehicle ID to remove: ");
        int vehicleId = getIntInput();
        dealership.removeVehicle(vehicleId);
        System.out.println("Vehicle removed successfully!");
    }
}
