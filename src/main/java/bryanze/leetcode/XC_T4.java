package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/05
 */
public class XC_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = sc.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long res = dfs(n, k, sum, a);
        System.out.println(res);

    }

    private static long dfs(int n, int k, long sum, long[] a) {
        long totalOperations = 0;
        long currentWinSum = 0;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            currentWinSum += a[i];
            if (i >= k) {
                currentWinSum -= a[i - k] + diff[i - k];
            }

            if (currentWinSum > sum) {
                long ex = currentWinSum - sum;
                diff[i] -= ex;
                totalOperations += ex;
                currentWinSum -= ex;
            }

        }

        return totalOperations;
    }
}
