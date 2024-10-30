package com.example;
import java.util.Arrays;
import java.util.List;

/**
 * Represents ground coffee, a type of coffee that is sold in ground form,
 * with an additional attribute for the grind size.
 */
public class GroundCoffee extends Coffee {
    
    private String grindSize;
    private static final List<String> VALID_GRIND_SIZES = Arrays.asList("Fine", "Medium", "Coarse");

    /**
     * Constructs a {@code GroundCoffee} object with specified attributes.
     *
     * @param weight    the weight of the coffee in kilograms
     * @param price     the price of the coffee in currency units
     * @param quality   the quality rating of the coffee (on a scale)
     * @param brand     the brand name of the coffee
     * @param volume    the volume of the coffee in liters
     * @param grindSize the size of the grind of the coffee (e.g., "Fine", "Medium", "Coarse")
     * @throws IllegalArgumentException if the {@code grindSize} is invalid
     */
    public GroundCoffee(double weight, double price, double quality, String brand, double volume, String grindSize) {
        super(weight, price, quality, brand, volume);
        setGrindSize(grindSize);
    }

    /**
     * Returns the grind size of the ground coffee.
     *
     * @return the grind size of the ground coffee
     */
    public String getGrindSize() {
        return grindSize;
    }

    /**
     * Sets the grind size of the coffee.
     *
     * @param grindSize the grind size to set
     * @throws IllegalArgumentException if the specified grind size is not valid
     */
    private void setGrindSize(String grindSize) {
        if (!VALID_GRIND_SIZES.contains(grindSize)) {
            throw new IllegalArgumentException("Invalid grind size. Valid options are: " + VALID_GRIND_SIZES);
        }
        this.grindSize = grindSize;
    }

    /**
     * Returns the type of coffee, including the grind size.
     *
     * @return a string representation of the coffee type, including the grind size
     */
    @Override
    public String getType() {
        return "Ground (" + grindSize + ")";
    }
}
