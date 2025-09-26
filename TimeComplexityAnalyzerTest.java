import static org.junit.Assert.assertTrue; //Importing static assert methods from JUnit to allow using assertTrue without class prefix
import org.junit.Test; //Importing the Test annotation from JUnit
import java.util.Random; // Importing Random class for generating random numbers in tests

//Declaring test class
public class TimeComplexityAnalyzerTest {

    @Test
    public void testRunComputationWithZeros() {
        // Arrays filled with zeros and should always return 0
        int n = 10;
        int[] a = new int[n];
        int[] b = new int[n];
        
        // Call the method under test with these arrays
        long result = TimeComplexityAnalyzer.runComputation(n, a, b);
        
        // Check that the result is 0 because all elements are zero
        assertTrue("Sum should be 0 when all elements are zero", result == 0);
    }

    // Performing another test case, testing arrays filled with 1s
    @Test
    public void testRunComputationPositiveValues() {
        // Arrays filled with 1s: sum should be positive and non-zero
        int n = 20;
        int[] a = new int[n];
        int[] b = new int[n];

        // Fill both arrays with 1s
        for (int i = 0; i < n; i++) {
            a[i] = 1;
            b[i] = 1;
        }
        // Call the method under test
        long result = TimeComplexityAnalyzer.runComputation(n, a, b);
        // Checking that the result is positive (non-zero)
        assertTrue("Sum should be positive for arrays filled with 1s", result > 0);
    }

    @Test
    // Test case for small random arrays
    public void testRunComputationRandomSmallArrays() {
        // Random small arrays, just checking if it runs without exceptions
        int n = 100; // size of arrays
        int[] a = new int[n];
        int[] b = new int[n];
        Random rand = new Random(42); // fixed seed for reproducibility

        // Filling arrays with random integers between 0 and 9
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(10);
            b[i] = rand.nextInt(10);
        }
        
        // Call the method under test
        long result = TimeComplexityAnalyzer.runComputation(n, a, b);
        
        // Check that the sum is non-negative (basic sanity check)
        assertTrue("Sum should be non-negative", result >= 0);
    }
}
