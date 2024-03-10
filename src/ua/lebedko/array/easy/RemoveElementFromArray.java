package ua.lebedko.array.easy;

import java.util.Arrays;

public class RemoveElementFromArray {
    public int[] removeElement(int element, int[] nums) {
        return removeElement(element, 0, nums.length - 1, nums);
    }

    public int[] removeElement(int elementToRemove, int index, int swapPosition, int[] nums) {
        if (index == nums.length || swapPosition < 0) {
            return nums;
        }
        var indexValue = nums[index];
        if (indexValue != elementToRemove) {
            return removeElement(elementToRemove, ++index, swapPosition, nums);
        }
        var swapPositionValue = nums[swapPosition];
        nums[index] = swapPositionValue;
        nums[swapPosition] = 0;
        if (swapPositionValue == elementToRemove) {
            return removeElement(elementToRemove, index, --swapPosition, nums);
        } else {
            return removeElement(elementToRemove, ++index, --swapPosition, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RemoveElementFromArray().removeElement(3, new int[]{1, 2, 3, 3, 4, 5, 3, -1})));
        System.out.println(Arrays.toString(new RemoveElementFromArray().removeElement(0, new int[]{0, 0, 0})));
        System.out.println(Arrays.toString(new RemoveElementFromArray().removeElement(1, new int[]{0, 2, 1})));
        System.out.println(Arrays.toString(new RemoveElementFromArray().removeElement(1, new int[]{1, 1, 1})));
    }
}
