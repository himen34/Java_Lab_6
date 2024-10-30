package com.example;
/**
 * Represents whole bean coffee, a type of coffee that is sold in its whole form.
 * This class includes an additional attribute for the country of origin of the coffee.
 * 
 * <p>Whole bean coffee can be ground at home or in a coffee shop, allowing for
 * a fresher taste and aroma compared to pre-ground coffee.</p>
 * 
 * <p>Inherits from the {@link Coffee} class, which provides basic properties
 * such as weight, price, quality, brand, and volume.</p>
 */
public class WholeBeanCoffee extends Coffee {
    private String countryOfOrigin;

    /**
     * Constructs a WholeBeanCoffee object with the specified weight, price, quality,
     * brand, volume, and country of origin.
     *
     * @param weight         the weight of the coffee in grams
     * @param price          the price of the coffee in currency units
     * @param quality        the quality rating of the coffee
     * @param brand          the brand name of the coffee
     * @param volume         the volume of the coffee in milliliters
     * @param countryOfOrigin the country where the coffee beans are sourced from
     * @throws IllegalArgumentException if the country of origin is null or empty
     */
    public WholeBeanCoffee(double weight, double price, double quality, String brand, double volume, String countryOfOrigin) {
        super(weight, price, quality, brand, volume);
        if (countryOfOrigin == null || countryOfOrigin.isEmpty()) {
            throw new IllegalArgumentException("Country of origin cannot be empty.");
        }
        this.countryOfOrigin = countryOfOrigin;
    }

    /**
     * Retrieves the country of origin of this whole bean coffee.
     *
     * @return the country of origin
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Returns the type of coffee, including the country of origin.
     *
     * @return a string representation of the coffee type
     */
    @Override
    public String getType() {
        return "Whole Bean (" + countryOfOrigin + ")";
    }
}
