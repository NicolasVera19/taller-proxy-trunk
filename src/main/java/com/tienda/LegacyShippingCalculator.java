package com.tienda;

/**
 * Calculador de envío heredado: tarifa fija de 10.00.
 */
public class LegacyShippingCalculator {

    public double calculate(Order order) {
        return 10.0;
    }
}
