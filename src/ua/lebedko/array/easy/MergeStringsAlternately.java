package ua.lebedko.array.easy;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 * <p>
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 * <p>
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        var hasDifferentLength = word1.length() != word2.length();
        var word1Length = word1.length();
        var word2Length = word2.length();

        var minLength = Math.min(word1Length, word2Length);
        var result = new StringBuilder();

        int charIndex = 0;
        for (; charIndex < minLength; charIndex++) {
            result.append(word1.charAt(charIndex));
            result.append(word2.charAt(charIndex));
        }
        if (hasDifferentLength) {
            var maxLength = Math.max(word1Length, word2Length);
            var word1Longer = word1Length > word2Length;
            for (; charIndex < maxLength; charIndex++) {
                if (word1Longer) {
                    result.append(word1.charAt(charIndex));
                } else {
                    result.append(word2.charAt(charIndex));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MergeStringsAlternately().mergeAlternately("abc", "pqr"));
        System.out.println(new MergeStringsAlternately().mergeAlternately("abc", "pqrzx"));
    }
}
