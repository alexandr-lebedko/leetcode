package ua.lebedko.array.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Create a method that accepts two integer arrays and check weather all elements from second are present in the first.
 */
public class ContainsAll {
    public boolean solution(int[] nums1, int[] nums2) {
        var nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return nums1Set.containsAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
    }

    public static void main(String[] args) {
        System.out.println(new ContainsAll().solution(new int[]{1, 2, 2, 3}, new int[]{1, 2}));
        System.out.println(new ContainsAll().solution(new int[]{1, 2, 2, 3}, new int[]{1, 2, 1, 2}));
        System.out.println(new ContainsAll().solution(new int[]{1, 2, 3}, new int[]{2, 5}));
    }
}
