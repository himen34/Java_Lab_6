package com.example;
/**
 * Abstract class Coffee represents a general type of coffee with attributes like weight,
 * price, quality, brand, and volume, and provides methods for calculating the price-to-weight ratio.
 */
public abstract class Coffee {
    private double weight;
    private double price;
    private double quality;
    private String brand;
    private double volume;

    /**
     * Constructs a Coffee object with specified weight, price, quality, brand, and volume.
     *
     * @param weight  The weight of the coffee in kilograms.
     * @param price   The price of the coffee in currency units.
     * @param quality The quality rating of the coffee, from 0 to 10.
     * @param brand   The brand name of the coffee.
     * @param volume  The volume of the coffee in cubic meters.
     * @throws IllegalArgumentException if the weight or price is non-positive,
     *                                  if the quality is not between 0 and 10,
     *                                  if the brand is null or empty,
     *                                  or if the volume is non-positive.
     */
    public Coffee(double weight, double price, double quality, String brand, double volume) {
        if (weight <= 0 || price <= 0) {
            throw new IllegalArgumentException("Weight and price must be positive.");
        }
        if (quality < 0 || quality > 10) {
            throw new IllegalArgumentException("Quality must be between 0 and 10.");
        }
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be positive.");
        }
        this.weight = weight;
        this.price = price;
        this.quality = quality;
        this.brand = brand;
        this.volume = volume;
    }

    /**
     * Returns the weight of the coffee.
     *
     * @return the weight of the coffee in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the price of the coffee.
     *
     * @return the price of the coffee in currency units.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the quality rating of the coffee.
     *
     * @return the quality rating of the coffee, from 0 to 10.
     */
    public double getQuality() {
        return quality;
    }

    /**
     * Returns the brand name of the coffee.
     *
     * @return the brand name of the coffee.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the volume of the coffee.
     *
     * @return the volume of the coffee in cubic meters.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Calculates the price-to-weight ratio of the coffee.
     *
     * @return the price-to-weight ratio.
     */
    public double getPriceToWeightRatio() {
        return price / weight;
    }

    /**
     * Returns the type of coffee as a string.
     * This method must be implemented by subclasses.
     *
     * @return a string representing the type of coffee.
     */
    public abstract String getType();
}
