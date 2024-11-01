package com.pluralsight;


import java.time.LocalDate;


public class Contract {
    private String customerName;
    private String customerEmail;
    private Double totalPrice;
    private String VehicleSold;
    private LocalDate contractDate;
    private double monthlyPayment; // a new comment - Is this a good variable name

    public Contract(String customerName, String customerEmail, double totalPrice, String VehicleSold, LocalDate contractDate, double monthlyPayment){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
        this.VehicleSold = VehicleSold;
        this.contractDate = contractDate;
        this.monthlyPayment = monthlyPayment;

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getVehicleSold() {
        return VehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        VehicleSold = vehicleSold;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }


    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void getTotalPrice(){}

    public void getMonthlyPayment(){}

}
