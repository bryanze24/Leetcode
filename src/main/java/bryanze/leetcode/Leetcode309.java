package bryanze.leetcode;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author lizelin
 * @date 2024/03/02
 */
public class Leetcode309 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];  // 买入股票
        dp[0][1] = 0;  // 保持卖出的状态(已经过了冷静期)
        dp[0][2] = 0;  // 卖出股票(卖出动作的第一个动作一定是买入，所以dp[i][2]只与dp[i - 1][0]有关)
        dp[0][3] = 0;  // 冷冻期

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(
                    Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]),
                    dp[i - 1][3] - prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);  //与注释的return配套
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];

        }

//        return dp[length - 1][2];
        return Math.max(dp[length - 1][2], Math.max(dp[length - 1][1], dp[length - 1][3]));
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(new Leetcode309().maxProfit(prices));
    }
}
