# Taller Proxy en Trunk

Proyecto inicial para desarrollar el taller paso a paso con Java 17, Maven y JUnit 5.

## Requisitos

- JDK 17
- Apache Maven 3.9 o superior

## Ejecutar pruebas

```bash
mvn clean test
```

## Estado inicial

Este proyecto representa el Paso 0: tienda inicial con envío antiguo.
Todavía no se ha extraído la interfaz `ShippingCalculator`, no existe Proxy
y `Checkout` utiliza directamente el calculador heredado.
