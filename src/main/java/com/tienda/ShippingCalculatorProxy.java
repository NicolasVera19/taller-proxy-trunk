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

        boolean smartEnabled = FeatureFlags.isSmartShippingEnabled();

        ShippingCalculator calculator = smartEnabled
                ? smartCalculator
                : legacyCalculator;

        String calculatorName = smartEnabled ? "Smart" : "Legacy";

        long startTime = System.nanoTime();

        double cost = calculator.calculate(order);

        long elapsedTime = System.nanoTime() - startTime;

        System.out.printf(
                "[Shipping Proxy] Calculador: %s | Tiempo: %d ns | Costo: %.2f%n",
                calculatorName,
                elapsedTime,
                cost
        );

        return cost;
    }
}