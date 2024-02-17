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

        int leftPointer = 0;
        int rightPointer = length - 1;

        do {
            var leftVowel = findNextForwardVowel(input, leftPointer, length);
            var rightVowel = findNextBackwardVowel(input, rightPointer);

            if (leftVowel == -1 || rightVowel == -1 || leftVowel > rightVowel || leftVowel == rightVowel) {
                break;
            }

            var tmp = input[leftVowel];
            input[leftVowel] = input[rightVowel];
            input[rightVowel] = tmp;

            leftPointer = leftVowel + 1;
            rightPointer = rightVowel - 1;

        } while (leftPointer < rightPointer);

        return new String(input);
    }

    private int findNextForwardVowel(char[] input, int start, int length) {
        for (int i = start; i < length; i++) {
            if (vowels.contains(input[i]))
                return i;
        }
        return -1;
    }

    private int findNextBackwardVowel(char[] input, int start) {
        for (int i = start; i > 0; i--) {
            if (vowels.contains(input[i]))
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverseVowels("hello"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("aA"));
        System.out.println(new ReverseVowelsOfString().reverseVowels("race car"));
    }

}
