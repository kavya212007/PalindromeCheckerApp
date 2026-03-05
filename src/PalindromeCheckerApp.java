import java.util.Stack;

/**
 * ==========================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================
 * Use Case 5: Stack Based Palindrome Checker
 * * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Declare and initialize the input string
        String input = "noon";

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack
        // Because it's a stack, the last character pushed will be the first one out.
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string
        // We compare the current character with the character popped from the stack
        for (char c : input.toCharArray()) {
            char poppedChar = stack.pop();

            if (c != poppedChar) {
                isPalindrome = false;
                break; // No need to continue if a mismatch is found
            }
        }

        // Display the result
        System.out.println("Input String: " + input);
        if (isPalindrome) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }
    }
}