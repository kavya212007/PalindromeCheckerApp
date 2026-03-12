import java.util.LinkedList;
import java.util.Scanner;

/**
 * MAIN CLASS - PalindromeCheckerApp
 * ==========================================================================
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome using a LinkedList.
 * Characters are added to the list and then compared by removing elements
 * from both ends:
 * - removeFirst()
 * - removeLast()
 *
 * @author Developer
 * @version 8.0
 */

public class PalindromeCheckerApp {

    // Entry point
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Use Case 8: Palindrome Checker ===");
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();

        if (checkPalindrome(input)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }

    // Logic method
    public static boolean checkPalindrome(String text) {

        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (clean.isEmpty()) return true;

        LinkedList<Character> list = new LinkedList<>();

        for (char ch : clean.toCharArray()) {
            list.add(ch);
        }

        while (list.size() > 1) {
            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }
}