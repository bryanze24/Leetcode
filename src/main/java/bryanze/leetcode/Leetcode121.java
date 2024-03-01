package bryanze.leetcode;


/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author lizelin
 * @date 2024/02/29
 */
public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            // 更新前 iii 天的最低价格，即最低买入成本 cost
            cost = Math.min(cost, price);

            //更新前i天的最高利润 profit ，即选择「前 i-1 天最高利润 profit 」
            // 和「第 i 天卖出的最高利润 price - cost 」中的最大值;
            profit = Math.max(profit, price - cost);

        }

        return profit;
    }

    public int maxProfitByDp(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

        }

        return dp[length - 1][1];
    }

}
