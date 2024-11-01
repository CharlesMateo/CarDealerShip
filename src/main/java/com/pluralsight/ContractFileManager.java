package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private String filename;

    public ContractFileManager(String filename) {
        this.filename = filename;
    }
    // Test
    public void saveContract(Object contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            StringBuilder contractLine = new StringBuilder();
            // Handle both SalesContract and LeaseContract instances
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                contractLine.append("SALE|")
                        .append(salesContract.getDate()).append("|")
                        .append(salesContract.getCustomerName()).append("|")
                        .append(salesContract.getCustomerEmail()).append("|")
                        .append(salesContract.getVehicleSold().getId()).append("|")
                        .append(salesContract.getVehicleSold().getYear()).append("|")
                        .append(salesContract.getVehicleSold().getMake()).append("|")
                        .append(salesContract.getVehicleSold().getModel()).append("|")
                        .append(salesContract.getVehicleSold().getType()).append("|")
                        .append(salesContract.getVehicleSold().getColor()).append("|")
                        .append(salesContract.getVehicleSold().getMileage()).append("|")
                        .append(salesContract.getVehicleSold().getPrice()).append("|")
                        .append(salesContract.calculateTotalPrice()).append("|")
                        .append(salesContract.calculateMonthlyPayment()).append("|")
                        .append(salesContract.isFinance() ? "YES" : "NO").append("\n");
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                contractLine.append("LEASE|")
                        .append(leaseContract.getDate()).append("|")
                        .append(leaseContract.getCustomerName()).append("|")
                        .append(leaseContract.getCustomerEmail()).append("|")
                        .append(leaseContract.getVehicleSold().getId()).append("|")
                        .append(leaseContract.getVehicleSold().getYear()).append("|")
                        .append(leaseContract.getVehicleSold().getMake()).append("|")
                        .append(leaseContract.getVehicleSold().getModel()).append("|")
                        .append(leaseContract.getVehicleSold().getType()).append("|")
                        .append(leaseContract.getVehicleSold().getColor()).append("|")
                        .append(leaseContract.getVehicleSold().getMileage()).append("|")
                        .append(leaseContract.getVehicleSold().getPrice()).append("|")
                        .append(leaseContract.calculateTotalPrice()).append("|")
                        .append(leaseContract.calculateMonthlyPayment()).append("\n");
            }
            writer.write(contractLine.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
