package bryanze.leetcode;

/**
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
 *
 * @author lizelin
 * @date 2024/03/05
 */
public class Leetcode115 {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println(new Leetcode115().numDistinct(s, t));
    }

}
