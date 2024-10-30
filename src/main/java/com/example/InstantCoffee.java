package com.example;
/**
 * Represents instant coffee, a type of coffee that is sold in instant form and packaged
 * in various types, such as cans or packets.
 */
public class InstantCoffee extends Coffee {
    
    private String packageType;

    /**
     * Constructs an {@code InstantCoffee} object with specified attributes.
     *
     * @param weight      the weight of the coffee in kilograms
     * @param price       the price of the coffee in currency units
     * @param quality     the quality rating of the coffee (on a scale)
     * @param brand       the brand name of the coffee
     * @param volume      the volume of the coffee in liters
     * @param packageType the type of package the coffee is sold in (e.g., "Can", "Packet")
     * @throws IllegalArgumentException if the {@code packageType} is null or empty
     */
    public InstantCoffee(double weight, double price, double quality, String brand, double volume, String packageType) {
        super(weight, price, quality, brand, volume);
        if (packageType == null || packageType.isEmpty()) {
            throw new IllegalArgumentException("Package type cannot be empty.");
        }
        this.packageType = packageType;
    }

    /**
     * Returns the package type of the instant coffee.
     *
     * @return the package type of the instant coffee
     */
    public String getPackageType() {
        return packageType;
    }

    /**
     * Returns the type of coffee, including the package type.
     *
     * @return a string representation of the coffee type, including the package type
     */
    @Override
    public String getType() {
        return "Instant (" + packageType + ")";
    }
}
