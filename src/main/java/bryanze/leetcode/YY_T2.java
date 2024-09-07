package bryanze.leetcode;


import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class YY_T2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long k = sc.nextLong();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//
//        long count = 0;
//        for (int i = 0; i < n - 2; i++) {
//            for (int j = i + 1; j < n - 1; j++) {
//                for (int l = j + 1; l < n; l++) {
//                    long total = nums[i] + nums[j] + nums[l];
//                    if (total >= k) {
//                        count++;
//                    }
//
//                }
//            }
//
//        }
//
//        System.out.println(count);
//
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(dfs(n, k, nums));

    }

    private static long dfs(int n, int k, int[] nums) {
        long[] dp = new long[k + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }

        }

        long res = 0;
        for (int i = 0; i <= k; i++) {
            if (dp[i] > 0) {
                res += dp[i];
            }
        }
        return  res;
    }
}
