/**
 * =================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * =================================================================
 *
 * Use Case 13: Performance Comparison of Palindrome Algorithms
 *
 * Description:
 * This class measures and compares execution performance of
 * different palindrome strategies.
 * It demonstrates:
 * - Stack-based strategy
 * - Recursive strategy
 * - Dynamic strategy selection (Strategy Pattern)
 * - Execution time measurement
 *
 * Author: Developer
 * Version: 13.0
 */
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String testInput = "A man a plan a canal Panama";

        // Array of strategies to benchmark
        PalindromeStrategy[] strategies = {
            new StackStrategy(),
            new RecursiveStrategy()
        };

        for (PalindromeStrategy strategy : strategies) {
            String strategyName = strategy.getClass().getSimpleName();

            // Capture start time
            long startTime = System.nanoTime();

            boolean result = strategy.isValid(testInput);

            // Capture end time
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            // Output benchmarking results
            System.out.println("Strategy: " + strategyName);
            System.out.println("Input: " + testInput);
            System.out.println("Is Palindrome? : " + result);
            System.out.println("Execution Time: " + duration + " ns");
            System.out.println("----------------------------------------");
        }
    }
}

/**
 * =================================================================
 * INTERFACE - PalindromeStrategy
 * =================================================================
 */
interface PalindromeStrategy {
    boolean isValid(String input);
}

/**
 * =================================================================
 * CLASS - StackStrategy
 * =================================================================
 */
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
}

/**
 * =================================================================
 * CLASS - RecursiveStrategy
 * =================================================================
 */
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        if (input == null) return false;
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursive(cleanInput, 0, cleanInput.length() - 1);
    }

    private boolean checkRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkRecursive(s, start + 1, end - 1);
    }
}