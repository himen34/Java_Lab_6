package com.example;
import java.util.Arrays;

/**
 * The {@code ListApplication} class demonstrates the usage of the {@link CoffeeList} class
 * and its related operations, including adding, removing, and displaying coffee objects.
 * It serves as an entry point for the application, showcasing various functionalities
 * such as creating collections of coffee, performing bulk operations, and sorting.
 *
 * <p>This class includes a {@code main} method which creates instances of different types
 * of coffee, adds them to a collection, and performs various operations while handling
 * potential exceptions.</p>
 */
public class ListApplication {
    
    /**
     * The main method serves as the entry point for the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Creating instances of Coffee
            Coffee espresso = new WholeBeanCoffee(1.0, 10.0, 8.5, "Lavazza", 0.5, "Italy");
            Coffee americano = new GroundCoffee(0.5, 8.0, 6.0, "Nescafe", 0.3, "Fine");
            Coffee instantCoffee = new InstantCoffee(0.2, 7.0, 9.0, "Taster's Choice", 0.1, "Can");
            Coffee caribou = new GroundCoffee(0.5, 12.0, 4.5, "Caribou", 0.4, "Medium");
            Coffee latte = new GroundCoffee(0.7, 9.0, 5.5, "Starbucks", 0.35, "Coarse");
            
            // Displaying constructor uses
            System.out.println("Creating CoffeeList using default constructor:");
            CoffeeList coffeeCollection = new CoffeeList();
            coffeeCollection.add(espresso);
            coffeeCollection.add(americano);
            coffeeCollection.add(instantCoffee);
            coffeeCollection.add(caribou);
            displayCollection(coffeeCollection);

            System.out.println("\nCreating CoffeeList with a single Coffee object:");
            CoffeeList singleCoffeeCollection = new CoffeeList(espresso);
            displayCollection(singleCoffeeCollection);

            System.out.println("\nCreating CoffeeList with an existing collection of Coffee objects:");
            CoffeeList newCoffees = new CoffeeList(Arrays.asList(
                new WholeBeanCoffee(1.5, 15.0, 8.0, "Peet's", 2.0, "Colombia"),
                new InstantCoffee(1.5, 4.0, 6.0, "Taster's Choice", 2.3, "Can")
            ));
            displayCollection(newCoffees);

            // Additional operations
            System.out.println("\nSize of Coffee Collection: " + coffeeCollection.size());
            System.out.println("Contains Lavazza coffee: " + coffeeCollection.contains(espresso));
            System.out.println("Contains Starbucks coffee: " + coffeeCollection.contains(latte));

            // Remove a coffee and display
            coffeeCollection.remove(americano);
            System.out.println("\nAfter removing Nescafe coffee, Collection Size: " + coffeeCollection.size());
            displayCollection(coffeeCollection);

            CoffeeList additionalCoffees = new CoffeeList();
            additionalCoffees.add(americano);
            additionalCoffees.add(latte);

            // addAll operation
            coffeeCollection.addAll(additionalCoffees);
            System.out.println("\nAfter addAll(additionalCoffees): ");
            displayCollection(coffeeCollection);

            // containsAll operation
            boolean containsAll = coffeeCollection.containsAll(additionalCoffees);
            System.out.println("\nContains all additional coffees: " + containsAll);

            // retainAll operation
            coffeeCollection.retainAll(additionalCoffees);
            System.out.println("\nAfter retainAll(additionalCoffees): ");
            displayCollection(coffeeCollection);

            // Sort the collection by price-to-weight ratio
            Coffee[] coffeeArray = coffeeCollection.toArray(new Coffee[0]);
            Arrays.sort(coffeeArray, (c1, c2) -> {
                double ratio1 = c1.getPriceToWeightRatio();
                double ratio2 = c2.getPriceToWeightRatio();
                return Double.compare(ratio1, ratio2);
            });
            System.out.println("\nSorted Coffees by Price-to-Weight Ratio:");
            for (Coffee coffee : coffeeArray) {
                System.out.printf("Type: %s, Brand: %s, Price-to-Weight Ratio: %.2f, Price: %.2f, Weight: %.2f%n", 
                        coffee.getType(), coffee.getBrand(), coffee.getPriceToWeightRatio(), coffee.getPrice(), coffee.getWeight());
            }

            // clear operation
            coffeeCollection.clear();
            System.out.println("\nAfter clear(): Coffee Collection Size: " + coffeeCollection.size());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Displays the contents of the specified {@link CoffeeList} collection.
     *
     * @param coffeeList the coffee collection to be displayed
     */
    private static void displayCollection(CoffeeList coffeeList) {
        System.out.println("Displaying Coffee Collection:");
        for (Coffee coffee : coffeeList) {
            System.out.printf("Type: %s, Brand: %s, Quality: %.2f%n", 
                    coffee.getType(), coffee.getBrand(), coffee.getQuality());
        }
    }
}
