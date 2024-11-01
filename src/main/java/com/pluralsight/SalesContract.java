package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SalesTaxRate = 0.05;
    private static final double RecordingFee = 100.00;
    private static final double ProcessingFeeUnder10000 = 295.00;
    private static final double ProcessingFeeOver10000 = 495.00;

    private boolean finance; // true for financing, false otherwise

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
        calculateTotalPrice();
        calculateMonthlyPayment();
    }

    @Override
    public double calculateTotalPrice() {
        double vehiclePrice = getVehicleSold().getPrice();
        double salesTax = vehiclePrice * SalesTaxRate;
        double processingFee = vehiclePrice < 10000 ? ProcessingFeeUnder10000 : ProcessingFeeOver10000;

        double totalPrice = vehiclePrice + salesTax + RecordingFee + processingFee;
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public double calculateMonthlyPayment() {
        double vehiclePrice = getVehicleSold().getPrice();
        double monthlyPayment;

        if (finance) {
            if (vehiclePrice >= 10000) {
                monthlyPayment = (vehiclePrice + calculateTotalPrice()) * (4.25 / 100) / 48;
            } else {
                monthlyPayment = (vehiclePrice + calculateTotalPrice()) * (5.25 / 100) / 24;
            }
            setMonthlyPayment(monthlyPayment);
            return monthlyPayment;
        }

        setMonthlyPayment(0);
        return 0; // No monthly payment if not financed
    }

    public boolean isFinance() {
        return finance;
    }
}
