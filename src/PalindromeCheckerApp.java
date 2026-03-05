import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 * Use Case 7: Deque Based Optimized Palindrome Checker
 * * Description:
 * This class validates a palindrome using a Deque (Double Ended Queue).
 * Characters are inserted and compared by removing elements from both ends.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "radar";

        // Use Deque for bidirectional traversal
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into the deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // Compare by removing elements from both ends simultaneously
        while (deque.size() > 1) {
            char first = deque.removeFirst(); // Front
            char last = deque.removeLast();   // Back

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        // Display the result
        System.out.println("Input String: " + input);
        if (isPalindrome) {
            System.out.println("Result: The string is confirmed as a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}