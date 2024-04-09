package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class mayi1 {

    private static final int N = 3; // 矩阵大小
    private static int count = 0; // 放置方案数
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // 狗的数量
        int y = scanner.nextInt(); // 猫的数量
        scanner.close();

        // 初始化矩阵
        int[][] grid = new int[N][N];

        // 从(0,0)位置开始放置宠物
        placePets(grid, x, y, 0, 0);

        // 输出方案数
        System.out.println(count);

    }

        // 回溯放置宠物
    private static void placePets (int[][] grid, int x, int y, int row, int col){
        if (x == 0 && y == 0) {
            // 当放置完所有行，统计方案
            count++;
            return;
        }

        if (col == N) {
            // 当放置完一行的所有列，递归到下一行
            placePets(grid, x, y, row + 1, 0);
            return;
        }

        // 如果还有狗可以放置
        if (x > 0 && isValid(grid, row, col, 'D')) {
            grid[row][col] = 'D'; // 放置狗
            placePets(grid, x - 1, y, row, col + 1);
            grid[row][col] = 0; // 回溯
        }

        // 如果还有猫可以放置
        if (y > 0 && isValid(grid, row, col, 'C')) {
            grid[row][col] = 'C'; // 放置猫
            placePets(grid, x, y - 1, row, col + 1);
            grid[row][col] = 0; // 回溯
        }

        // 如果当前位置不放置宠物
        placePets(grid, x, y, row, col + 1);
    }

        // 检查当前位置是否可以放置宠物
    private static boolean isValid ( int[][] grid, int row, int col, int type){
        // 检查上方
        if (row > 0 && grid[row - 1][col] == type) return false;
        // 检查左方
        if (col > 0 && grid[row][col - 1] == type) return false;
        // 检查左上
        if (row > 0 && col > 0 && grid[row - 1][col - 1] == type) return false;
        // 检查左下
        if (row < N - 1 && col > 0 && grid[row + 1][col - 1] == type) return false;

        return true;
    }

}
