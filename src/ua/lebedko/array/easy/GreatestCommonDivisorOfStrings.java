package ua.lebedko.array.easy;

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
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int maxGcdLength = gcd(str1.length(), str2.length());

        return str2.substring(0, maxGcdLength);
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(".gcdOfStrings(ABCABC, ABC) :" + new GreatestCommonDivisorOfStrings().gcdOfStrings("ABCABC", "ABC").equals("ABC"));
        System.out.println(".gcdOfStrings(ABABAB, ABAB) :" + new GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB", "ABAB").equals("AB"));
        System.out.println(".gcdOfStrings(LEET, CODE) :" + new GreatestCommonDivisorOfStrings().gcdOfStrings("LEET", "CODE").isEmpty());
        System.out.println(".gcdOfStrings(ABCDEF, ABC) :" + new GreatestCommonDivisorOfStrings().gcdOfStrings("ABCDEF", "ABC").isEmpty());
    }
}
