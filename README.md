# Asymptotic Analysis Simulation

This project is a Java-based simulation designed to experimentally verify the theoretical time complexity of a given algorithm. The target algorithm has a theoretical complexity of $O(\frac{n \log \log n}{\log n})$.

The program runs the algorithm for a predefined set of input sizes (`n`), measures the execution time in nanoseconds for each run, and outputs the results. This data can then be used to create a graph comparing the practical, experimental performance against the theoretical model.

## Files in this Repository

* `TimeComplexityAnalyzer.java`: The main Java source file containing the implementation of the algorithm and the `main` method to run the timing experiment.
* `TimeComplexityAnalyzerTest.java`: The JUnit 4 test file used to verify the correctness of the `runComputation` method under various conditions.

## How to Compile and Run

This project was developed using the Eclipse IDE.

### Running the Main Simulation
1.  Import the `.java` files into an Eclipse project.
2.  Open `TimeComplexityAnalyzer.java`.
3.  Right-click on the file and select **Run As > Java Application**.
4.  The program will execute and print a table of `n` values and their corresponding execution times to the console.

### Running the JUnit 4 Tests

This project uses **JUnit 4** for unit testing. To run the tests, the source file and the test file must be in the same directory or package within Eclipse.

1.  **Ensure JUnit 4 is in the Build Path**:
    * Right-click on your project in the Package Explorer.
    * Go to **Build Path > Configure Build Path**.
    * In the **Libraries** tab, make sure JUnit 4 is listed. If not, click **Add Library... > JUnit > JUnit 4**.
2.  **Run the Tests**:
    * Open `TimeComplexityAnalyzerTest.java`.
    * Right-click on the file and select **Run As > JUnit Test**.
3.  The JUnit view will open in Eclipse and show the test results. All tests should pass with a green bar.
