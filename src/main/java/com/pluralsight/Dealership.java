package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;
    private String test;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getInventory() {
        return this.inventory;
    }

    public Dealership(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public List<Vehicle> getVehiclesByPriceRange(double minPrice, double maxPrice) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice;
        }).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model);
        }).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByYearRange(int startYear, int endYear) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getYear() >= startYear && vehicle.getYear() <= endYear;
        }).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getColor().equalsIgnoreCase(color);
        }).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByMileageRange(int minMileage, int maxMileage) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getMileage() >= minMileage && vehicle.getMileage() <= maxMileage;
        }).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByType(String type) {
        return (List)this.inventory.stream().filter((vehicle) -> {
            return vehicle.getType().equalsIgnoreCase(type);
        }).collect(Collectors.toList());
    }

    public void addVehicle(Vehicle vehicle) {
        //this.inventory.add(vehicle);
    }

    public void removeVehicle(int vehicleId) {
        this.inventory.removeIf((vehicle) -> {
            return vehicle.getId() == vehicleId;
        });
    }
}