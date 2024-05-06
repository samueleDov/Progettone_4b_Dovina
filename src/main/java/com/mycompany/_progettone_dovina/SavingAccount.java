/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progettone_dovina;

/**
 *
 * @author Studente
 */
public class SavingAccount {
    //public class SavingsAccount {
private static double annualInterestRate = 0.0; // Annual interest rate for all account holders
private double savingsBalance; // Current balance in the savings account

// Constructor to initialize savings balance
public SavingAccount(double savingsBalance) {
this.savingsBalance = savingsBalance;
}

// Method to set the savings balance
public void setSavingsBalance(double savingsBalance) {
this.savingsBalance = savingsBalance;
}

// Static method to modify the annual interest rate
public static void modifyInterestRate(double newInterestRate) {
if (newInterestRate >= 0.0) {
annualInterestRate = newInterestRate;
} else {
throw new IllegalArgumentException("Interest rate must be >= 0.0");
}
}

// Method to get the current savings balance
public double getSavingsBalance() {
return this.savingsBalance;
}

// Static method to get the annual interest rate
public static double getAnnualInterestRate() {
return annualInterestRate;
}

// Method to calculate and update the monthly interest
public void calculateMonthlyInterest() {
double monthlyInterest = (this.savingsBalance * annualInterestRate) / 12;
this.savingsBalance += monthlyInterest;
}

// Method to return the savings balance as a formatted string
@Override
public String toString() {
return String.format("$%.2f", getSavingsBalance());
}
}
