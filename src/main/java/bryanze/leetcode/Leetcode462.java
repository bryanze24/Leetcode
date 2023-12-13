package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。
 * 在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * @author lizelin
 * @date 2023/12/13
 */
public class Leetcode462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int target = nums[length / 2];
        int result = 0;

        for (int num : nums) {
            result += Math.abs(num - target);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 10, 2, 9};
        System.out.println(new Leetcode462().minMoves2(nums));
    }
}
