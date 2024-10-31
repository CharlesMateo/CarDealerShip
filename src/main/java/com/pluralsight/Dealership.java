package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private final List<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.inventory = new ArrayList<>();
    }

    // Method to add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        System.out.println("Vehicle added to the inventory: " + vehicle);
    }

    // Method to remove a vehicle by ID
    public void removeVehicle(int id) {
        inventory.removeIf(vehicle -> vehicle.getId() == id);
    }

    // Method to retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory); // Return a copy to protect encapsulation
    }

    // Method to find vehicles by price range
    public List<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // Method to find vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) &&
                        vehicle.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    // Method to find vehicles by year range
    public List<Vehicle> getVehiclesByYearRange(int startYear, int endYear) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= startYear && vehicle.getYear() <= endYear)
                .collect(Collectors.toList());
    }

    // Method to find vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    // Method to find vehicles by mileage range
    public List<Vehicle> getVehiclesByMileageRange(int minMileage, int maxMileage) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMileage() >= minMileage && vehicle.getMileage() <= maxMileage)
                .collect(Collectors.toList());
    }

    // Method to find vehicles by type
    public List<Vehicle> getVehiclesByType(String type) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
}
