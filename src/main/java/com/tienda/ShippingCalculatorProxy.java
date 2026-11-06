package com.tienda;

public class ShippingCalculatorProxy implements ShippingCalculator {

    private final ShippingCalculator legacyCalculator;
    private final ShippingCalculator smartCalculator;

    public ShippingCalculatorProxy(
            ShippingCalculator legacyCalculator,
            ShippingCalculator smartCalculator) {
        this.legacyCalculator = legacyCalculator;
        this.smartCalculator = smartCalculator;
    }

    @Override
    public double calculate(Order order) {
        if (FeatureFlags.isSmartShippingEnabled()) {
            return smartCalculator.calculate(order);
        }

        return legacyCalculator.calculate(order);
    }
}