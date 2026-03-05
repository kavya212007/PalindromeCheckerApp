import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 * * Use Case 6: Queue + Stack Fairness Check
 * * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 * * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 * * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 * * If all characters match, the input string is confirmed
 * as a palindrome.
 * * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "radar";

        // Initialize Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters into both structures
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        // Compare by removing from the front of the queue and the top of the stack
        while (!stack.isEmpty()) {
            char fromQueue = queue.remove(); // Gets first character (FIFO)
            char fromStack = stack.pop();    // Gets last character (LIFO)

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Display results
        System.out.println("Input: " + input);
        if (isPalindrome) {
            System.out.println("Result: The string is confirmed as a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}