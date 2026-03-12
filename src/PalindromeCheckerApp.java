/**
 * =================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * =================================================================
 * * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 * * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 * * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 * * The goal is to teach extensible algorithm design.
 * * @author Developer
 * @version 12.0
 */
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String testInput = "racecar";

        // Inject the Stack-based strategy
        PalindromeStrategy strategy = new StackStrategy();

        boolean result = strategy.isValid(testInput);

        System.out.println("Input: " + testInput);
        System.out.println("Is Palindrome (Stack Strategy): " + result);
    }
}

/**
 * =================================================================
 * INTERFACE - PalindromeStrategy
 * =================================================================
 * * This interface defines a contract for all
 * palindrome checking algorithms.
 * * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {
    boolean isValid(String input);
}

/**
 * =================================================================
 * CLASS - StackStrategy
 * =================================================================
 * * A concrete implementation of PalindromeStrategy that uses
 * a Stack data structure to verify the string.
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isValid(String input) {
        if (input == null) return false;

        // Remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push all chars to stack
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return cleanInput.equals(reversed.toString());
    }
}:wq
`: