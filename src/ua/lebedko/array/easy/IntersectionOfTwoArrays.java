package ua.lebedko.array.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        var nums1Set = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toSet());
        var nums2Set = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.toSet());

        if(nums1Set.size() <= nums2Set.size()) {
            return nums1Set.stream()
                    .filter(nums2Set::contains)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } else {
            return nums2Set.stream()
                    .filter(nums1Set::contains)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[] {1,2,2,1}, new int[] {2,2})));
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
}
