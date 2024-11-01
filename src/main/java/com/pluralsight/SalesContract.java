package com.pluralsight;

// Import necessary classes
//TODO import java.util.Objects; // In case you need to handle objects in future methods

        public class SalesContract extends Contract {
            private static final double SALES_TAX_RATE = 0.05; // 5% sales tax
            private static final double RECORDING_FEE = 100.0; // Fixed recording fee
            private static final double PROCESSING_FEE_UNDER_10K = 295.0; // Fee for vehicles under $10,000
            private static final double PROCESSING_FEE_ABOVE_10K = 495.0; // Fee for vehicles above $10,000
            private boolean finance; // Financing option
            private double salesPrice; // Price of the vehicle!

            // Constructor for SalesContract
            public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double salesPrice, boolean finance) {
                super(date, customerName, customerEmail, vehicle); // Call to parent constructor
                this.salesPrice = salesPrice; // Initialize sales price
                this.finance = finance; // Set finance option
            }

            @Override
            public double getTotalPrice() {
                double tax = salesPrice * SALES_TAX_RATE; // Calculate sales tax
                double processingFee = salesPrice < 10000 ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_ABOVE_10K; // Conditional processing fee
                return salesPrice + tax + RECORDING_FEE + processingFee; // Total price calculation
            }

            @Override
            public double getMonthlyPayment() {
                if (!finance) return 0; // If not financing, return 0
                double totalPrice = getTotalPrice(); // Get total price
                double interestRate = salesPrice >= 10000 ? 0.0425 : 0.0525; // Interest rate based on price
                int termMonths = salesPrice >= 10000 ? 48 : 24; // Loan term based on price
                double monthlyRate = interestRate / 12; // Monthly interest rate
                return (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termMonths)); // Monthly payment calculation
            }
        }