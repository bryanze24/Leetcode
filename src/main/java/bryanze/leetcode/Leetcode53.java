package bryanze.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。子数组 是数组中的一个连续部分。
 *
 * @author lizelin
 * @date 2024/03/04
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length];
        dp[0] = nums[0];
        int ans = nums[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Leetcode53().maxSubArray(nums));
    }
}
