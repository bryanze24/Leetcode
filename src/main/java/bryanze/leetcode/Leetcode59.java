package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * @author lizelin
 * @date 2024/07/28
 */
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int upper = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;

        while (true) {

            //从左到右
            for (int i = left; i <= right; i++) {
                res[upper][i] = count++;
            }
            upper++;
            if (upper > down) {
                break;
            }

            //从上到下
            for (int i = upper; i <= down; i++) {
                res[i][right] = count++;
            }
            right--;
            if (right < left) {
                break;
            }

            //从右到左
            for (int i = right; i >= left; i--) {
                res[down][i] = count++;
            }
            down--;
            if (down < upper) {
                break;
            }

            //从下到上
            for (int i = down; i >= upper; i--) {
                res[i][left] = count++;
            }
            left++;
            if (left > right) {
                break;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] res = new Leetcode59().generateMatrix(5);
        for (int[] temp : res) {
            System.out.println(Arrays.toString(temp));
        }
    }
}
