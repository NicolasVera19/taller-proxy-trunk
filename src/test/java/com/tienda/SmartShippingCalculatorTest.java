package com.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartShippingCalculatorTest {

    @Test
    void calculatesShippingByWeightInBogota() {
        ShippingCalculator calculator = new SmartShippingCalculator();

        Order order = new Order("o1", "c1", "Bogota", 100.0, 4.0);

        assertEquals(10.0, calculator.calculate(order), 0.0001);
    }

    @Test
    void addsSurchargeOutsideBogota() {
        ShippingCalculator calculator = new SmartShippingCalculator();

        Order order = new Order("o2", "c2", "Medellin", 100.0, 4.0);

        assertEquals(15.0, calculator.calculate(order), 0.0001);
    }
}