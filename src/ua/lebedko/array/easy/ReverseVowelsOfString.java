package ua.lebedko.array.easy;

import java.util.*;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * leetocode -> leotcede ->
 * Output: "leotcede"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */

public class ReverseVowelsOfString {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        var input = s.toCharArray();
        var length = input.length;

        Deque<Integer> vowelIndexes = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (vowels.contains(input[i])) {
                vowelIndexes.add(i);
            }
        }

        while (vowelIndexes.size() > 1) {
            var first = vowelIndexes.pollFirst();
            var last = vowelIndexes.pollLast();

            var tmp = input[first];
            input[first] = input[last];
            input[last] = tmp;
        }

        return new String(input);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("aA"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("race car"));
    }

}
