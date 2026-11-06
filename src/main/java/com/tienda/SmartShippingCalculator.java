package com.tienda;

public class SmartShippingCalculator implements ShippingCalculator {

    @Override
    public double calculate(Order order) {
        double cost = order.weightKg() * 2.5;

        if (!"Bogota".equalsIgnoreCase(order.city())) {
            cost += 5.0;
        }

        return cost;
    }
}