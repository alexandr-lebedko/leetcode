package ua.lebedko.array.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return getIntersection(Arrays.stream(nums1).boxed().collect(Collectors.toSet()), nums2);
        } else {
            return getIntersection(Arrays.stream(nums2).boxed().collect(Collectors.toSet()), nums1);
        }
    }

    private int[] getIntersection(Set<Integer> indexedNums, int[] nums) {
        var result = new HashSet<Integer>();
        for (int num : nums) {
            if (indexedNums.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
