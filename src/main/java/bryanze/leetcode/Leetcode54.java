package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请
 * 按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author lizelin
 * @date 2024/04/18
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int upper = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {

            //从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[upper][i]);
            }
            upper++;
            if (upper > down) break;

            //从上到下
            for (int i = upper; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (right < left) break;

            //从右到左
            for (int i = right; i >= left ; i--) {
                ans.add(matrix[down][i]);
            }
            down--;
            if (down < upper) break;

            //从下到上
            for (int i = down; i >= upper; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }

        return ans;
    }

}
