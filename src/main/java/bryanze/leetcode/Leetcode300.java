package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author lizelin
 * @date 2023/12/06
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {

        int piles = 0;
        int[] top = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = piles;
            int poker = nums[i];

            while (left < right) {

                int mid = left + ((right - left) >> 1);

                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }

            if (left == piles) {
                piles++;
            }

            top[left] = poker;

        }

        return piles;

    }

    //动态规划
    public int lengthOfLISByDp(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length]; // dp[i]表示以nums[i]为结尾的最长递增子序列的长度
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 1; i < length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Leetcode300().lengthOfLISByDp(nums));
    }

}
