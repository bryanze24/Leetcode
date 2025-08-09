package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/28
 */

public class DecryptionWays {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 数字串长度
        String s = sc.next();  // 数字串

        // 动态规划数组，dp[i]表示长度为i的前缀的可能原串个数
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 空串有1种解码方式

        for (int i = 1; i <= n; i++) {
            // 单个数字有效
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            // 两个数字有效
            if (i > 1) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }

        // 输出可能的原串个数
        System.out.println(dp[n]);
    }
}








