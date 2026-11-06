package com.tienda;

public class App {

    public static void main(String[] args) {
        Order order = new Order("o1", "c1", "Medellin", 100.0, 4.0);

        ShippingCalculator calculator = new LegacyShippingCalculator();
        Checkout checkout = new Checkout(calculator);

        System.out.printf("Total de la compra: %.2f%n", checkout.total(order));
    }
}