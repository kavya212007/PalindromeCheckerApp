/**
 * ============================================================
 * MAIN CLASS - PalindromeCheckerApp
 * ============================================================
 *
 * Use Case : Recursive Palindrome Checker with Normalization
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string by removing spaces and symbols and converting
 * it to lowercase.
 *
 * Then, it checks palindrome recursively by comparing characters
 * from the outer positions moving inward.
 *
 * The recursion stops when:
 * - All characters are matched, or
 * - A mismatch is found.
 *
 * This example demonstrates a combination of normalization and
 * recursive palindrome check logic.
 *
 * Example:
 * "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 1.0
 */
public class PalindromeCheckerApp {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Example input
        String input = "A man a plan a canal Panama";

        // Normalize input by removing non-alphanumeric characters and converting to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Input : " + input);

        boolean result = check(normalized, 0, normalized.length() - 1);

        System.out.println("Is Palindrome? : " + result);
    }

    /**
     * Recursively checks whether a string is palindrome.
     *
     * @param s     Input string (already normalized)
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s, int start, int end) {

        // Base condition: if pointers meet or cross
        if (start >= end) {
            return true;
        }

        // If characters are not equal
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call moving towards the center
        return check(s, start + 1, end - 1);
    }
}