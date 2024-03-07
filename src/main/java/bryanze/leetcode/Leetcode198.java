package bryanze.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
 * 就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author lizelin
 * @date 2024/03/07
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[length + 1];  // dp[i]表示盗窃第i - 1个房屋时所获得的最高金额
        dp[1] = nums[0];
        dp[2] = nums[1];

        int res = Math.max(dp[1], dp[2]);
        for (int i = 3; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
            res = Math.max(res, dp[i]);
        }

        return res;

    }

    public int robByDp(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];  // dp[i]表示盗窃第 i 个房屋时所获得的最高金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        int result = Math.max(dp[0], dp[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Leetcode198().rob(nums));
    }
}
