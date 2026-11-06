package com.tienda;

public class ShippingCalculatorProxy implements ShippingCalculator {

    private final ShippingCalculator calculator;

    public ShippingCalculatorProxy(ShippingCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public double calculate(Order order) {

        long startTime = System.nanoTime();

        double cost = calculator.calculate(order);

        long elapsedTime = System.nanoTime() - startTime;

        System.out.printf(
                "[Shipping Proxy] Calculador: %s | Tiempo: %d ns | Costo: %.2f%n",
                calculator.getClass().getSimpleName(),
                elapsedTime,
                cost
        );

        return cost;
    }
}