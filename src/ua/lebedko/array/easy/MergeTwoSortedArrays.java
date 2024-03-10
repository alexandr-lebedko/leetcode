package ua.lebedko.array.easy;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public int[] merge(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] solution = new int[nums1Length + nums2Length];

        int nums1Index = 0;
        int nums2Index = 0;
        int solutionIndex = 0;

        while (nums1Index < nums1Length && nums2Index < nums2Length) {
            var nums1Value = nums1[nums1Index];
            var nums2Value = nums2[nums2Index];

            if (nums1Value <= nums2Value) {
                solution[solutionIndex++] = nums1[nums1Index++];
            } else {
                solution[solutionIndex++] = nums2[nums2Index++];
            }
        }
        while (nums1Index < nums1Length) {
            solution[solutionIndex++] = nums1[nums1Index++];
        }
        while (nums2Index < nums2Length) {
            solution[solutionIndex++] = nums2[nums2Index++];
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeTwoSortedArrays().merge(new int[]{-1, 1, 2, 3, 5}, new int[]{0, 1, 4, 7, 77})));
    }
}
