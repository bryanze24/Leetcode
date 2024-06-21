package bryanze.leetcode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author lizelin
 * @date 2024/03/08
 */
public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }

            if (dp[target] == target) {
                return true;
            }
        }

        return dp[target] == target;
    }

    public boolean canPartitionByDP(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ( (sum & 1) == 1) { //判断sum是否为奇数
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[length][target + 1];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }

        }

        return dp[length - 1][target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(new Leetcode416().canPartition(nums));
    }

}
