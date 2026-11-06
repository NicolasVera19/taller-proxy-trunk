package com.tienda;

/**
 * Estado inicial: Checkout conoce y crea directamente el calculador heredado.
 */
public class Checkout {

    private final LegacyShippingCalculator shippingCalculator =
            new LegacyShippingCalculator();

    public double total(Order order) {
        return order.subtotal() + shippingCalculator.calculate(order);
    }
}
