package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，
 * 则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author lizelin
 * @date 2024/04/12
 */
public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] temp : list) {
            int row = temp[0];
            int col = temp[1];
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][col] = 0;
            }
        }

    }
}
