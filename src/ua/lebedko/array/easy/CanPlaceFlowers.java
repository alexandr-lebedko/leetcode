package ua.lebedko.array.easy;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        var length = flowerbed.length;
        var placedFlowers = 0;
        int i = 0;

        while (i < length && placedFlowers != n) {
            if (canFitFlower(flowerbed, i, length)) {
                flowerbed[i] = 1;
                placedFlowers++;

                // skip one iteration
                i += 2;
            } else {
                i++;
            }
        }
        return placedFlowers >= n;
    }

    private boolean canFitFlower(int[] flowerbed, int index, int length) {
        if (flowerbed[index] != 0) {
            return false;
        }
        // is left side not empty
        if (index != 0 && flowerbed[index - 1] != 0) {
            return false;
        }
        // is right side not empty
        if (index + 1 != length && flowerbed[index + 1] != 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 0));
    }
}
