package com.tienda;

public class FeatureFlags {

    public static boolean isSmartShippingEnabled() {
        return Boolean.parseBoolean(
                System.getProperty("smart-shipping", "false")
        );
    }
}