package bryanze.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * @author lizelin
 * @date 2024/04/18
 */
public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int index = binarySearch(nums, target);
            if (index != -1) {
                return  true;
            }
        }

        return false;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return  mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                         {6, 7, 8, 9, 10},
                         {11, 12, 13, 14, 15},
                         {16, 17, 18, 19, 20},
                         {21, 22, 23, 24, 25}};
        int[][] matrix1 = {{-1, 3}};

        System.out.println(new Leetcode240().searchMatrix(matrix, 19));
    }
}
