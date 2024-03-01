package bryanze.leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author lizelin
 * @date 2024/03/01
 */
public class Leetcode123 {
    public int maxProfitDp(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][5];
        dp[0][0] = 0; // 不操作
        dp[0][1] = -prices[0]; // 第一次买入
        dp[0][2] = 0; // 第一次卖出
        dp[0][3] = -prices[0]; // 第二次买入
        dp[0][4] = 0; // 第二次卖出

        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

//            System.out.println(dp[i][0] + "\t" + dp[i][1] + "\t" +
//                    dp[i][2] + "\t" + dp[i][3] + "\t" + dp[i][4]);
//            System.out.println("---------------------------------");
        }

        return Math.max(dp[length - 1][2], dp[length - 1][4]);
    }


    public int maxProfitByDp(int[] prices) {
        int dp1 = -prices[0];  // 第一次买入
        int dp2 = 0;  // 第一次卖出
        int dp3 = -prices[0];  // 第二次买入
        int dp4 = 0;  // 第二次卖出

        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, -prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);

        }

        return dp4;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Leetcode123().maxProfitDp(prices));
    }

}
