package ua.lebedko.array.easy;

public class LocateSubString {
    public int locateSubstring(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] == s2Chars[0] && containsSubString(i, s1Chars, s2Chars)) {
                return i;
            }
        }
        return -1;
    }

    private boolean containsSubString(int startIndex, char[] s1Chars, char[] s2Chars) {
        if (s1Chars.length - startIndex < s2Chars.length) {
            return false;
        }
        for (int i = 0; i < s2Chars.length; i++) {
            if (s1Chars[startIndex + i] != s2Chars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LocateSubString().locateSubstring("strsm", "sm"));
        System.out.println(new LocateSubString().locateSubstring("strsm", "st"));
        System.out.println(new LocateSubString().locateSubstring("strsm", "m"));
        System.out.println(new LocateSubString().locateSubstring("strsm", "t"));
        System.out.println(new LocateSubString().locateSubstring("abcdefg", "def"));
        System.out.println(new LocateSubString().locateSubstring("abcdefg", "fgh"));
    }
}
