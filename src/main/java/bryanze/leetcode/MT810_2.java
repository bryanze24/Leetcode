package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美有一个长度为 n 的数组 a1,a2,....,an ，他可以对数组进行如下操作：
 * ● 删除第一个元素 a1，同时数组的长度减一，花费为 x。
 * ● 删除整个数组，花费为 k*MEX(a) （其中 MEX(a) 表示 a 中未出现过的最小非负整数。
 * 例如 [0,1,2,4] 的 MEX 为 3 ）。
 * 小美想知道将 a 数组全部清空的最小代价是多少，请你帮帮他吧。
 * <p>
 * 输入描述
 * 每个测试文件均包含多组测试数据。第一行输入一个整数 T(1<=T<=1000) 代表数据组数，每组测试数据描述如下：
 * 第一行输入三个正整数 n,k,x(1<=n<=2*10^5, 1<=k,x<=10^9)
 * 代表数组中的元素数量、删除整个数组的花费系数、删除单个元素的花费。
 * 第二行输入 n 个整数 a1,a2,....,an(0<=ai<=n)，表示数组元素。
 * 除此之外，保证所有的 n 之和不超过 2*10^5。
 * <p>
 * 输出描述
 * 对于每一组测试数据，在一行上输出一个整数表示将数组中所有元素全部删除的最小花费。
 *
 * @author lizelin
 * @date 2024/08/10
 */
public class MT810_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();
            long[] nums = new long[(int) n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }
            long res = dfs(nums, k, x);
            System.out.println(res);
        }
    }

    private static long dfs(long[] nums, long k, long x) {
        int length = nums.length;
        long[] mex = new long[length];

        long[] temp = new long[length];
        System.arraycopy(nums, 0, temp, 0, length);
        Arrays.sort(temp);

        long currentMex = length;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i) {
                currentMex = i;
                break;
            }
        }

        mex[0] = currentMex;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] < currentMex) {
                mex[i] = nums[i - 1];
                currentMex = nums[i - 1];
            } else {
                mex[i] = currentMex;
            }
        }

        // dp[i][0] 表示删除第i个元素的累计花费
        // dp[i][1] 表示从第i个位置删除整个数组的累计花费
        long[][] dp = new long[length][2];
        dp[0][0] = x;
        dp[0][1] = k * mex[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + x;
            dp[i][1] = dp[i - 1][0] + k * mex[i];
        }

        long res = Long.MAX_VALUE;
        for (long[] num : dp) {
            res = Math.min(res, num[1]);
        }

        return Math.min(res, dp[length - 1][0]);
    }
}
