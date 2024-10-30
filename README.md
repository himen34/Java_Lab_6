### Lab Work 6:  Working with Collection in Java programming language

#### Overview
The sixth lab work involves creating a custom collection class that implements the `List` interface, specifically designed for managing a collection of coffee objects. 

The lab work is done for Variant 24.

#### Features
- Implements a custom list collection called **CoffeeList** for storing various types of `Coffee` objects.
- Provides three constructors:
  - A default constructor for creating an empty list.
  - A constructor that initializes the list with a single `Coffee` object.
  - A constructor that accepts an existing collection of `Coffee` objects.
- Implements all methods of the `List` interface to manage coffee objects effectively. 
- Internal structure uses an array with an initial capacity of 15 elements, expanding capacity by 30% as needed.

#### Usage
1. Clone the repository.
2. Navigate to the project directory.
3. Compile and run the `CoffeeTruckApplication` file.
4. If you want to make certain changes, you may create and modify coffee objects in the `ListApplication` file, such as instances of **WholeBeanCoffee**, **GroundCoffee**, and **InstantCoffee**.
5. Use the provided constructors to initialize the `CoffeeList` with different coffee objects.
6. Call various methods from the CoffeeList class to manipulate the `CoffeeList`.
7. Recompile and run the `ListApplication` file to see the results in the command line interface (CLI).
8. Observe the effects of each method, such as adding or removing coffee objects, checking for containment, and clearing the collection.

For more details about the Coffee class and different coffee types, please refer to the prior lab documentation.

### 1. Clone the repository:

```bash
git clone https://github.com/himen34/Java_Lab_6.git
cd Java_Lab_6
```

### 2. Build the project:

```bash
mvn package
```

### 3. Run the project:

```bash
mvn clean compile exec:java
```
## Requirements

- Java 17 or higher
- Maven 3.6.0 or higher