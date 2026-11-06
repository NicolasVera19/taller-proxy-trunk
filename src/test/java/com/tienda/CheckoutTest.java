package com.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest {

    @Test
    void checkoutUsesInjectedShippingCalculator() {
        Order order = new Order("o1", "c1", "Medellin", 100.0, 4.0);

        ShippingCalculator calculator = new LegacyShippingCalculator();
        Checkout checkout = new Checkout(calculator);

        assertEquals(110.0, checkout.total(order), 0.0001);
    }
}