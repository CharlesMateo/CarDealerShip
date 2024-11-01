package com.pluralsight;


    public class Contract {


        // Abstract class representing a generic contract
        //public abstract class Contract {
            private String date; // Date of contract
            private String customerName; // Customer's name
            private String customerEmail; // Customer's email
            private Vehicle vehicle; // Vehicle involved in the contract

            // Constructor to initialize common fields
            public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
                this.date = date;
                this.customerName = customerName;
                this.customerEmail = customerEmail;
                this.vehicle = vehicle;
            }

            // Getters for common fields
            public String getDate() { return date; }
            public String getCustomerName() { return customerName; }
            public String getCustomerEmail() { return customerEmail; }
            public Vehicle getVehicle() { return vehicle; }

        // Abstract methods that subclasses must implement
        public double getTotalPrice() // Calculate total price
        {
            return 0;
        }

        public double getMonthlyPayment() // Calculate monthly payment
        {
            return 0;
        }
    }
