package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class YY_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] tasks = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tasks[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        int[][] days = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                days[i][j] = sc.nextInt();
            }
        }

        System.out.println(dfs(N, K, tasks, days));

    }

    private static int dfs(int N, int K, int[][] tasks, int[][] days) {
        int[][] dp = new int[K][N];
        for (int i = 0; i < K; i++) {
            Arrays.fill(dp[i], 0);

        }
        for (int i = 0; i < N; i++) {
            dp[0][i] = days[i][0];
        }

        for (int a = 1; a < K; a++) {
            for (int i = 0; i < N; i++) {
                dp[a][i] = dp[a - 1][i] + days[i][a];

                for (int j = 0; j < N; j++) {
                    if (tasks[j][i] == 1) {
                        dp[a][i] = Math.max(dp[a][i], dp[a - 1][j] + days[i][a]);
                    }
                }
            }

        }

        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            maxDays = Math.max(maxDays, dp[K - 1][i]);

        }
        return maxDays;
    }

}
