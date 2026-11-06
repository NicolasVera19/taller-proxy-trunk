package com.tienda;

public class Checkout {

    private final ShippingCalculator shippingCalculator;

    public Checkout(ShippingCalculator shippingCalculator) {
        this.shippingCalculator = shippingCalculator;
    }

    public double total(Order order) {
        return order.subtotal() + shippingCalculator.calculate(order);
    }
}