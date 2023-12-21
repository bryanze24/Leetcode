package bryanze.leetcode;


/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * @author lizelin
 * @date 2023/12/21
 */
public class Leetcode747 {
    public int dominantIndex(int[] nums) {

        int length = nums.length;
        int max = nums[0], index = 0;

        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for (int num : nums) {
            if (num == 0 || num == max || max / num >= 2) {
                continue;
            } else {
                return -1;
            }
        }

        return index;
    }

    public int dominantIndex1(int[] nums) {
        int length = nums.length;
        int firstMax = -1, secondMax = -1, index = -1;

        for (int i = 0; i < length; i++) {

            if (nums[i] > firstMax) {
                secondMax = firstMax;
                firstMax = nums[i];
                index = i;

            } else if (nums[i] > secondMax) {
                secondMax = nums[i];

            }
        }

        return firstMax >= secondMax * 2 ? index : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Leetcode747().dominantIndex1(nums));
    }
}
