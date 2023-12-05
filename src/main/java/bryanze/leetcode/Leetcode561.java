package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该最大总和 。
 * @author lizelin
 * @date 2023/12/05
 */
public class Leetcode561 {
    public int arrayPairSum(int[] nums) {

        //12ms
        Arrays.sort(nums);

        //25ms
//        shellSort(nums);

        int sum = 0;

        for (int i = 1; i < nums.length; i += 2) {

            sum += Math.min(nums[i - 1], nums[i]);
        }

        return sum;
    }

    private static void shellSort(int[] array) {
        for (int gap = array.length >> 1; gap >= 1; gap = gap >> 1) {

            for (int low = gap; low < array.length; low++) {

                int temp = array[low];
                int i = low - gap;

                while (i >= 0 && temp < array[i]) {
                    array[i + gap] = array[i];
                    i -= gap;
                }

                //找到插入位置
                if (i != low - gap) {
                    array[i + gap] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        System.out.println(new Leetcode561().arrayPairSum(nums));
    }
}
