package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/09/14
 */
public class Shopee_T1 {
    public int pickGoods(int[] goods_list, int balance) {
        // write code here
        int[] dp = new int[balance + 1];
        dp[0] = 0;
        for (int good : goods_list) {
            for (int j = balance; j >= good; j--) {
                dp[j] = Math.max(dp[j], dp[j - good] + good);

            }
        }

        return dp[balance];
    }
}
