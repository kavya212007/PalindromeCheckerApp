/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case : Recursive Palindrome Checker with Normalization using Object-Oriented Design
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string by removing spaces and symbols and converting
 * it to lowercase.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeService class that uses recursion.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 1.1.0
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Normalize input
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        PalindromeService service = new PalindromeService();

        boolean result = service.checkPalindrome(normalized);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome using recursion.
     *
     * @param input Input string (assumed normalized)
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        return checkRecursive(input, 0, input.length() - 1);
    }

    /**
     * Recursive helper method to check palindrome.
     *
     * @param s     Input string
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, false otherwise
     */
    private boolean checkRecursive(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return checkRecursive(s, start + 1, end - 1);
    }
}