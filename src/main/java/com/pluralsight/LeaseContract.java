package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LeaseFeeRate = 0.07;
    private static final int LeaseTermMonths = 36;

    private double expectedEndingValue; // 50% of the original price

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.50;
        calculateTotalPrice();
        calculateMonthlyPayment();
    }

    @Override
    public double calculateTotalPrice() {
        double vehiclePrice = getVehicleSold().getPrice();
        double leaseFee = vehiclePrice * LeaseFeeRate;

        double totalPrice = vehiclePrice + leaseFee;
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public double calculateMonthlyPayment() {
        double monthlyPayment = (calculateTotalPrice() * 4.0 / 100) / LeaseTermMonths;
        setMonthlyPayment(monthlyPayment);
        return monthlyPayment;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }
}
