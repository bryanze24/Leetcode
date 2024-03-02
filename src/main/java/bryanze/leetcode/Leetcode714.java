package bryanze.leetcode;

/**
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，
 * 在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * @author lizelin
 * @date 2024/03/02
 */
public class Leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;

        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[length - 1][1];
    }

    public int maxProfit1(int[] prices, int fee) {
        int dp1 = -prices[0];
        int dp2 = 0;

        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp2 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i] - fee);

        }

        return dp2;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        System.out.println(new Leetcode714().maxProfit1(prices, 3));
    }
}
