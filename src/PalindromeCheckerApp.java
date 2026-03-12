/**
 * =================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * =================================================================
 * * Use Case 13: Performance Comparison
 * * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 * * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 * * This use case focuses purely on performance
 * measurement and algorithm comparison.
 * * The goal is to introduce benchmarking concepts.
 * * @author Developer
 * @version 13.0
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     * * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "level";

        // Using the StackStrategy from the previous use case
        PalindromeStrategy strategy = new StackStrategy();

        // Capture Start Time in nanoseconds
        long startTime = System.nanoTime();

        // Execute algorithm
        boolean isPalindrome = strategy.isValid(input);

        // Capture End Time
        long endTime = System.nanoTime();

        // Calculate Duration
        long duration = endTime - startTime;

        // Output results in the requested format
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + duration + " ns");
    }
}

/**
 * Interface and Concrete Implementation included
 * for compilation completeness.
 */
interface PalindromeStrategy {
    boolean isValid(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        if (input == null) return false;
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return cleanInput.equals(reversed.toString());
    }
}q