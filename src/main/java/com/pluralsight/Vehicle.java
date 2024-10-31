
package com.pluralsight;

public class Vehicle {
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private String type;
    private double price;

    public Vehicle(int id, String make, String model, int year, String color, int mileage, String type, double price) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public int getMileage() {
        return this.mileage;
    }

    public String getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return "ID: " + this.id + ", Year: " + this.year + ", Make: " + this.make + ", Model: " + this.model + ", Type: " + this.type + ", Color: " + this.color + ", Mileage: " + this.mileage + ", Price: $" + this.price;
    }
}