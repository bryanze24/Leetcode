package bryanze.leetcode;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * @author lizelin
 * @date 2024/03/26
 */
public class Leetcode363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] prifix = new int[rowLength + 1][colLength + 1];

        for (int i = 1; i <=rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                prifix[i][j] = prifix[i - 1][j] + prifix[i][j - 1] - prifix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {

                for (int p = i; p <= rowLength; p++) {
                    for (int q = j; q <= colLength; q++) {
                        int temp = prifix[p][q] - prifix[i - 1][q] - prifix[p][j - 1] + prifix[i - 1][j - 1];
                        if (temp <= k) {
                            ans = Math.max(ans, temp);
                        }
                    }

                }

            }

        }

        return ans;

    }

}
