package bryanze.leetcode;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @author lizelin
 * @date 2024/05/23
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchFirstColumn(matrix, target);

        if (row < 0) {
            return false;
        }

        return binarySearchRow(matrix[row], target);
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int left = -1;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean binarySearchRow(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(new Leetcode74().searchMatrix(matrix, 13));
    }
}
