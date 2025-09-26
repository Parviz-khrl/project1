import java.util.Random; // Importing random class to generate random numbers

/**
 * The objective of this code is to analyze the pseudocode given by instructor and create Java
 * implementation that allows experimentally confirm its time complexity
 * Author: Parviz Khairullaev
 */

// Declaring a public class TimeComplexityAnalyzer 
public class TimeComplexityAnalyzer {

    public static long runComputation(int n, int[] a, int[] b) {
        long sum = 0; // Initializing a long variable 'sum' to 0, it will accumulate the results
        int j = 2; // Initializing an integer 'j' to 2, it is a counter for the outer loop

        // Outer loop: runs while j < n
        while (j < n) {
            long k = j; // initializing a long variable for inner loop
            // Inner loop: continues while k < n
            while (k < n) { 

                sum += (long) a[(int) k] * b[(int) k]; // Accumulating the product of a[k] and b[k] into sum
                
                if (k > Math.sqrt(Long.MAX_VALUE)) break; // Prevents overflow for very large k values by breaking early

                k = k * k; // Exponential growth: k = k^2 (this causes very rapid growth)
            }

            double increment = Math.log(k); // Compute log(k) to determine how much to increment j
            j += (increment > 1) ? increment : 1; // Ensure at least j += 1 if log(k) is very small
        }

        return sum; // returning the computed sum
    }

    public static void main(String[] args) {
        // Defining an array of integers to be used as input 'n' values for testing
        int[] testValues = {10, 100, 500, 1000, 5000, 10000, 50000, 100000,
                           200000, 500000, 1000000, 2000000, 5000000};

        Random rand = new Random(); // Random number generator for populating arrays
        
        // Printing header in the output 
        System.out.printf("%-10s %-25s %-20s%n", "n", "Execution Time (ns)", "Sum Result");
        
        // A for-each loop that iterates through each value in the 'testValues' array
        for (int n : testValues) {
            int[] a = new int[n]; // Creating first input array of size n
            int[] b = new int[n]; // Create second input array of size n

            // Filling arrays a and b with random integers between 0 and 99
            for (int i = 0; i < n; i++) {
                a[i] = rand.nextInt(100); // Assigning random integer to a[i]
                b[i] = rand.nextInt(100); // // Assign random integer to b[i]
            }

            long start = System.nanoTime(); // records start time in nanoseconds
            long sum = runComputation(n, a, b); // runs the main computation
            long end = System.nanoTime(); // records end time in nanoseconds

            long timeNs = end - start; //calculates the execution time
            //Prints the input size, execution time, and resulting sum
            System.out.printf("%-10d %-25d %-20d%n", n, timeNs, sum);
        }
    }
}
