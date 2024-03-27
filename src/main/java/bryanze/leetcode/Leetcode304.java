package bryanze.leetcode;

/**
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、
 * 右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 * @author lizelin
 * @date 2024/03/26
 */
public class Leetcode304 {

    private int[][] matrix;
    private int[][] prifix;
    public Leetcode304(int[][] matrix) {
        this.matrix = matrix;
        prifix = new int[matrix.length][];
        prifix = sum();
    }

    private int[][] sum() {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][]  array = new int[rowLength][colLength + 1];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                array[i][j + 1] = array[i][j] + matrix[i][j];
            }
        }

        return array;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int ans = 0;

        for (int i = row1; i <= row2; i++) {
            ans += prifix[i][col2 + 1] - prifix[i][col1];
        }

        return ans;
    }

}
