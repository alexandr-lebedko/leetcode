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
        calculateHalf(nums, 0, nums.length / 2, nums.length / 2, nums.length, result);
        calculateHalf(nums, nums.length / 2, nums.length, 0, nums.length / 2, result);

        return result;
    }

    private int calculateProductOfRange(int[] nums, int start, int end) {
        int result = 1;
        for (int i = start; i < end; i++) {
            result *= nums[i];
        }
        return result;
    }

    private int[] calculateHalf(int[] nums, int prefixStart, int prefixEnd, int halfStart, int halfEnd, int[] result) {
        var prefix = calculateProductOfRange(nums, prefixStart, prefixEnd);
        for (int i = halfStart; i < halfEnd; i++) {
            var suffix = calculateProductOfRange(nums, i + 1, halfEnd);
            result[i] = prefix * suffix;
            prefix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
