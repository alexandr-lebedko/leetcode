package ua.lebedko.array.medium;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        result[0] = right[1];
        result[nums.length - 1] = left[nums.length - 2];

        for (int i = 0; i < result.length - 1; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == result.length - 1) {
                result[i] = left[result.length - 2];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
