package ua.lebedko.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums1Set = new int[1001];
        int[] nums2Set = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            var number = nums1[i];
            nums1Set[number] = ++nums1Set[number];
        }
        for (int i = 0; i < nums2.length; i++) {
            var number = nums2[i];
            nums2Set[number] = ++nums2Set[number];
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < 1001; i++) {
            var nums1Count = nums1Set[i];
            var nums2Count = nums2Set[i];

            var intersectionsNum = Math.min(nums1Count, nums2Count);
            while (intersectionsNum > 0) {
                result.add(i);
                intersectionsNum--;
            }
        }

        int[] resultInt = new int[result.size()];
        int resultCount = 0;
        for (Integer i : result) {
            resultInt[resultCount++] = i;
        }

        return resultInt;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
