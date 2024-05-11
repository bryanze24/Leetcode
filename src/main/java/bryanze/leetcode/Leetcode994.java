package bryanze.leetcode;


import java.util.LinkedList;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * @author lizelin
 * @date 2024/05/11
 */
public class Leetcode994 {

    LinkedList<int[]> queue = new LinkedList<>();
    int fresh, row, col;

    public int orangesRotting(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        fresh = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

            }
        }

        int ans = 0;
        while (fresh > 0 && !queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int rowIndex = orange[0];
                int colIndex = orange[1];
                dfs(rowIndex, colIndex, grid);
            }
        }

        return fresh == 0 ? ans : -1;
    }

    private void dfs(int rowIndex, int colIndex, int[][] grid) {
        if (rowIndex + 1 <= row - 1 && grid[rowIndex + 1][colIndex] == 1) {
            grid[rowIndex + 1][colIndex] = 2;
            queue.offer(new int[]{rowIndex + 1, colIndex});
            fresh--;
        }

        if (rowIndex - 1 >= 0 && grid[rowIndex - 1][colIndex] == 1) {
            grid[rowIndex - 1][colIndex] = 2;
            queue.offer(new int[]{rowIndex - 1, colIndex});
            fresh--;
        }

        if (colIndex + 1 <= col - 1 && grid[rowIndex][colIndex + 1] == 1) {
            grid[rowIndex][colIndex + 1] = 2;
            queue.offer(new int[]{rowIndex, colIndex + 1});
            fresh--;
        }

        if (colIndex - 1 >= 0 && grid[rowIndex][colIndex - 1] == 1) {
            grid[rowIndex][colIndex - 1] = 2;
            queue.offer(new int[]{rowIndex, colIndex - 1});
            fresh--;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        System.out.println(new Leetcode994().orangesRotting(grid));
    }
}
