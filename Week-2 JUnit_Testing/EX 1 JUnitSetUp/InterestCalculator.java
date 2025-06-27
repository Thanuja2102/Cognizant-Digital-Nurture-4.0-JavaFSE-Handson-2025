
package com.bankapp.services;

public class InterestCalculator {

    public double calculateInterest(double principal, double rate, int years) {
        return (principal * rate * years) / 100;
    }
}

