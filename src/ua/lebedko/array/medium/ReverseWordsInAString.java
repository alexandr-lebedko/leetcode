package ua.lebedko.array.medium;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Constraints:w
 * <p>
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 * <p>
 * <p>
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        char[] charArray = s.toCharArray();

        var wordStarted = false;
        var wordStart = charArray.length - 1;
        var wordEnd = charArray.length - 1;

        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                if (wordStarted) {
                    if (!result.isEmpty()) {
                        result.append(" ");
                    }
                    wordStarted = false;
                    result.append(new String(charArray, wordStart, wordEnd + 1 - wordStart));
                }
            } else {
                if (!wordStarted) {
                    wordStarted = true;
                    wordEnd = i;
                }

                wordStart = i;

                if (i == 0) {
                    if (!result.isEmpty()) {
                        result.append(" ");
                    }

                    result.append(new String(charArray, 0, wordEnd + 1));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String test1 = "the sky is blue";
        String test2 = "  hello world  ";
        String test3 = "EPY2giL";

        new ReverseWordsInAString().reverseWords(test1);
        System.out.println(STR."\{test1}: actual:'\{new ReverseWordsInAString().reverseWords(test1)}', matches: \{new ReverseWordsInAString().reverseWords(test1).equals("blue is sky the")}");
        System.out.println(STR."\{test2}: actual:'\{new ReverseWordsInAString().reverseWords(test2)}', matches: \{new ReverseWordsInAString().reverseWords(test2).equals("world hello")}");
        System.out.println(STR."\{test3}: actual:'\{new ReverseWordsInAString().reverseWords(test3)}', matches: \{new ReverseWordsInAString().reverseWords(test3).equals("EPY2giL")}");
    }

}
