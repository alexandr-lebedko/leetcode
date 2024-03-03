package ua.lebedko.array.easy;

import java.util.Arrays;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();

        int maxGcdLength = Math.min(str1Chars.length, str2Chars.length);

        return defineGcdOfStrings(str1Chars, str2Chars, maxGcdLength);
    }

    private String defineGcdOfStrings(char[] str1Chars, char[] str2Chars, int maxPrefixLength) {
        if(maxPrefixLength == 0) {
            return "";
        }

        var commonPrefix = getCommonPrefix(str1Chars, str2Chars, maxPrefixLength);
        if (commonPrefix.length == 0) {
            return "";
        }

        if (canDivideCompletely(str1Chars, commonPrefix) && canDivideCompletely(str2Chars, commonPrefix)) {
            return new String(commonPrefix);
        }

        return defineGcdOfStrings(str1Chars, str2Chars, commonPrefix.length - 1);
    }

    private boolean canDivideCompletely(char[] str1Chars, char[] commonPrefix) {
        if (str1Chars.length % commonPrefix.length != 0) {
            return false;
        }
        var numberOfPrefixes = str1Chars.length / commonPrefix.length;
        var result = new String(str1Chars);
        for(int i = 0; i < numberOfPrefixes; i++) {
            result = result.replace(new String(commonPrefix), "");
        }

        return result.isEmpty();
    }

    private char[] getCommonPrefix(char[] str1Chars, char[] str2Chars, int cdLimit) {
        int matchedChars = 0;
        for (int i = 0; i < cdLimit; i++) {
            if (str1Chars[i] == str2Chars[i]) {
                matchedChars++;
            } else {
                break;
            }
        }
        return Arrays.copyOf(str1Chars, matchedChars);
    }

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("LEET", "CODE"));
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABCDEF", "ABC"));
    }
}
