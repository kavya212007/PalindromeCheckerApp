import java.util.LinkedList;
import java.util.Scanner;

/**
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================================
 * Use Case 8: Linked List Based Palindrome Checker
 * * Description:
 * This class checks whether a string is a palindrome using a LinkedList.
 * Characters are added to the list and then compared by removing elements
 * from both ends:
 * - removeFirst()
 * - removeLast()
 */
public class PalindromeCheckerApp {

    // 1. Entry point method: All logic starts here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Use Case 8: Palindrome Checker ===");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        // Call the logic method
        if (checkPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    // 2. Logic method: Where the LinkedList operations happen
    public static boolean checkPalindrome(String text) {
        // Clean the input (remove spaces/punctuation and make lowercase)
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Edge case: empty string is technically symmetric
        if (clean.isEmpty()) return true;

        // Use a LinkedList to store characters
        LinkedList<Character> list = new LinkedList<>();

        // Populate the list
        for (char ch : clean.toCharArray()) {
            list.add(ch);
        }

        /* * Logic: Compare first and last until only 0 or 1 element remains.
         * If any pair doesn't match, it's not a palindrome.
         */

        while (list.size() > 1) {
            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                return false; // Mismatch found, exit early
            }
        }

        return true; // All pairs matched
    }
}
