package bryanze.leetcode;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 */

public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int num = 1;
        while (true) {
            if(isUgly(num)){
                n--;
            }
            if(n == 0){
                return num;
            }
            num++;
        }
    }

    private boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        int[] array = {2, 3, 5};
        for (int num : array) {
            while (n % num == 0) {
                n /= num;
            }
        }

        return n == 1;
    }

    public int nthUglyNumber1(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
