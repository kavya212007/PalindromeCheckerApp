/**
 * =================================================================
 * MAIN CLASS - PalindromeCheckerApp
 * =================================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * Demonstrates how different palindrome validation algorithms
 * can be selected dynamically at runtime using the Strategy Design Pattern.
 * This example includes:
 * - Stack-based strategy
 * - Recursive strategy
 *
 * Author: Developer
 * Version: 12.0
 */
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String testInput = "A man a plan a canal Panama";

        // Choose strategy: Stack-based or Recursive
        PalindromeStrategy strategy;

        // Example 1: Stack-based
        strategy = new StackStrategy();
        boolean stackResult = strategy.isValid(testInput);
        System.out.println("Input: " + testInput);
        System.out.println("Is Palindrome (Stack Strategy): " + stackResult);

        // Example 2: Recursive-based
        strategy = new RecursiveStrategy();
        boolean recursiveResult = strategy.isValid(testInput);
        System.out.println("Is Palindrome (Recursive Strategy): " + recursiveResult);
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