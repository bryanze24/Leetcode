package bryanze.leetcode;


import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/03
 */
public class CodeFun1739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//        String[] str = new String[T];

        for (int i = 0; i < T; i++) {
            String str = sc.next();

            System.out.println(dfs(str));

        }
    }

    public static int dfs(String str) {
        int length = str.length();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i][i] = 0;
            if (i < length) {
                dp[i + 1][i] = 0;
            }
        }

        for (int len = 2; len <= length; len++) {
            for (int l = 1, r; l + len - 1 <= length; l++) {
                r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                if (str.charAt(l - 1) == str.charAt(r - 1)) {
                    dp[l][r] = dp[l + 1][r - 1];
                }

                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[k + 1][r] + dp[l][k] + 1);
                }

            }

        }

        return dp[1][length] + 1;
    }

}
