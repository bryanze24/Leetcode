package bryanze.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。
 * 我们用这种形式来构造 数对链 。
 * 找出并返回能够形成的 最长数对链的长度 。
 * 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * @author lizelin
 * @date 2023/12/22
 */
public class Leetcode646 {

    /*
    动态规划
     */
    public int findLongestChain(int[][] pairs) {

//        if(pairs.length == 1){
//            return 1;
//        }

        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

//        System.out.println(Arrays.deepToString(pairs));

        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 0);

        int result = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i] += 1;
            result = Math.max(result, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        return result;

    }

    /*
    贪心
     */
    public int findLongestChain1(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        for (int[] p : pairs) {

            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(new Leetcode646().findLongestChain(pairs));
    }
}
