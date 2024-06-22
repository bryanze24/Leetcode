package bryanze.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * @author lizelin
 * @date 2024/06/22
 */
public class Leetcode695 {

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int count = 0;
    int result = 0;

    public int maxAreaOfIslandByDFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] == 1) {
                    count = 1;
                    visit[i][j] = true;
                    DFS(grid, visit, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void DFS(int[][] grid, boolean[][] visit, int i, int j) {

        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                    && !visit[x][y] && grid[x][y] == 1) {
                count++;
                visit[x][y] = true;
                DFS(grid, visit, x, y);
            }
        }

    }

    public int maxAreaOfIslandByBFS(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && grid[i][j] == 1) {
                    count = 0;
                    BFS(grid, visit, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private void BFS(int[][] grid, boolean[][] visit, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        count++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = cur[0] + dir[k][0];
                int nextY = cur[1] + dir[k][1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && !visit[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.offer(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                    BFS(grid, visit, nextX, nextY);
                }

            }
        }
    }
}
