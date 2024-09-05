package bryanze.leetcode;

import java.util.Scanner;

/**
 * 20%
 * @author lizelin
 * @date 2024/09/05
 */
public class XM_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(dfs(nums, n, x));
    }

    private static int dfs(int[] nums, int n, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = sum;
            int opera = 0;
            cur -= nums[i];
            opera++;
            int remainder = cur % x;
            if (remainder != 0) {
                opera += x - remainder;
            }
            res = Math.min(res, opera);
            opera = 0;
            remainder = nums[i] % x;
            if (remainder != 0) {
                opera += remainder;
            }

            res = Math.min(res, opera);

        }

        res = Math.min(res, n);
        return res;
    }
}
