package ua.lebedko.array.easy;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Create a method that accepts two integer arrays and check weather all elements from second are present in the first. Repetitions does matter
 */
public class ExtendedContainsAll {

    public boolean solution(int[] nums1, int[] nums2) {
        Map<Integer, Long> nums1Count = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> nums2Count = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : nums2Count.entrySet()) {
            Long nums1NumberCount = nums1Count.get(entry.getKey());
            if (nums1NumberCount == null || nums1NumberCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 2, 2, 3}, new int[]{1, 2}));
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 2, 2, 3}, new int[]{1, 2, 1, 2}));
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 2, 3}, new int[]{2, 5}));
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 2}, new int[]{1, 1}));
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 1, 2, 2}, new int[]{1, 1, 2, 2}));
        System.out.println(new ExtendedContainsAll().solution(new int[]{1, 1, 2, 2}, new int[]{1, 1, 2}));
    }
}
