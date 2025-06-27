
package com.bankapp.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorInterestTest {

    private InterestCalculator calculator;

    @Before
    public void setUp() {
        calculator = new InterestCalculator();
    }

    @Test
    public void testCalculateInterest_ValidInputs() {
        double result = calculator.calculateInterest(10000, 5, 3);
        assertEquals(1500.0, result, 0.001);
    }

    @Test
    public void testCalculateInterest_ZeroPrincipal() {
        double result = calculator.calculateInterest(0, 5, 3);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCalculateInterest_NegativeValues() {
        double result = calculator.calculateInterest(-1000, 5, 2);
        assertEquals(-100.0, result, 0.001);
    }
}
