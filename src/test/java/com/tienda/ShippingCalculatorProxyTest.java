package com.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {

    @Test
    void proxyDelegatesCalculationAndReturnsCost() {

        ShippingCalculator smart = order -> 15.0;

        ShippingCalculator proxy =
                new ShippingCalculatorProxy(smart);

        Order order = new Order(
                "o1", "c1", "Medellin", 100.0, 4.0
        );

        assertEquals(15.0, proxy.calculate(order), 0.0001);
    }
}