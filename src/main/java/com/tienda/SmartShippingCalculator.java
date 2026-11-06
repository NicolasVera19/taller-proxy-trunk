package com.tienda;

public class SmartShippingCalculator implements ShippingCalculator {

    @Override
    public double calculate(Order order) {
        double cost = order.weightKg() * 2.5;

        String city = order.city().trim();

        if (!city.equalsIgnoreCase("Bogota")
                && !city.equalsIgnoreCase("Bogotá")) {
            cost += 5.0;
        }

        return cost;
    }
}