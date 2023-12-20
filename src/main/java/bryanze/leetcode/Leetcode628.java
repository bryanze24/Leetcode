package bryanze.leetcode;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * @author lizelin
 * @date 2023/12/20
 */
public class Leetcode628 {
    public int maximumProduct(int[] nums) {

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);
        int length = nums.length;

        if (nums[length - 1] < 0) {
            return nums[length - 1] * nums[length - 2] * nums[length - 3];

        } else if (nums[length - 1] == 0) {
            return 0;

        } else {

            if (nums[0] * nums[1] > nums[length - 2] * nums[length - 3]) {
                return nums[length - 1] * nums[0] * nums[1];

            } else {
                return nums[length - 1] * nums[length - 2] * nums[length - 3];
            }

        }

    }

    public int maximumProduct1(int[] nums) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num < min1) {
                min2 = min1;
                min1 = num;

            } else if (num < min2) {
                min2 = num;

            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;

            } else if (num > max2) {
                max3 = max2;
                max2 = num;

            } else if (num > max3) {
                max3 = num;

            }

        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, 0, 2,};
        System.out.println(new Leetcode628().maximumProduct1(nums));
    }

}
