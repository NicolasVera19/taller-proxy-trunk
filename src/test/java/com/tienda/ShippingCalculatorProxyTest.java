package com.tienda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShippingCalculatorProxyTest {

    @Test
    void usesLegacyCalculatorWhenFlagIsOff() {
        System.setProperty("smart-shipping", "false");

        try {
            ShippingCalculator legacy = order -> 10.0;
            ShippingCalculator smart = order -> 15.0;

            ShippingCalculator proxy =
                    new ShippingCalculatorProxy(legacy, smart);

            Order order = new Order(
                    "o1", "c1", "Medellin", 100.0, 4.0
            );

            assertEquals(10.0, proxy.calculate(order), 0.0001);

        } finally {
            System.clearProperty("smart-shipping");
        }
    }

    @Test
    void usesSmartCalculatorWhenFlagIsOn() {
        System.setProperty("smart-shipping", "true");

        try {
            ShippingCalculator legacy = order -> 10.0;
            ShippingCalculator smart = order -> 15.0;

            ShippingCalculator proxy =
                    new ShippingCalculatorProxy(legacy, smart);

            Order order = new Order(
                    "o2", "c2", "Medellin", 100.0, 4.0
            );

            assertEquals(15.0, proxy.calculate(order), 0.0001);

        } finally {
            System.clearProperty("smart-shipping");
        }
    }
}