package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有
 * nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]
 * 就是连续递增子序列。
 *
 * @author lizelin
 * @date 2024/03/03
 */
public class Leetcode674 {

    //动态规划
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];  // dp[i]表示以nums[i]为结尾的最长连续递增子序列的长度
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 1; i < length; i++) {

            if (nums[i] - nums[i - 1] > 0) {
                dp[i] = dp[i- 1] + 1;
                ans = Math.max(ans, dp[i]);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(new Leetcode674().findLengthOfLCIS(nums));
    }

}
