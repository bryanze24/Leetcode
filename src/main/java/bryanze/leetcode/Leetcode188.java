package bryanze.leetcode;


/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author lizelin
 * @date 2024/03/01
 */
public class Leetcode188 {
    public int maxProfitByTwoDimensional(int k, int[] prices) {
        int length = prices.length;

        int[][] dp = new int[length][2 * k + 1];
        //初始化dp数组
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < length; i++) {

            for (int j = 0; j <= k * 2 - 2; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);

            }

        }

        return dp[length - 1][2 * k];

    }

    public int maxProfitByOneDimensional(int k, int[] prices) {
        int[] dp = new int[2 * k];

        for (int i = 0; i < 2 * k; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i <= prices.length; i++) {

            dp[0] = Math.max(dp[0], -prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);

            for (int j = 2; j < 2 * k; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i - 1]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i - 1]);

            }

        }

        return dp[2 * k - 1];

    }

    public static void main(String[] args) {
        int[] price = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(new Leetcode188().maxProfitByTwoDimensional(2, price));
    }
}
