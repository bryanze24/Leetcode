package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author lizelin
 * @date 2024/04/11
 */
public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }

        int length = nums.length;
        k = k % length;

        int[] temp = new int[length];


        for (int i = 0; i < length; i++) {
            int index = (i + k) % length;
            temp[index] = nums[i];

        }

        System.arraycopy(temp, 0, nums, 0, length);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Leetcode189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
