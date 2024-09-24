package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/08
 */

public class XHS_T1 {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static boolean[][] inCycle;
    static boolean[][] outOfBounds;

    // DFS 寻找格子的最终状态
    static boolean dfs(int x, int y) {
        // 如果已经出界，返回 true
        if (x < 0 || y < 0 || x >= n || y >= m) return true;

        // 如果已经访问过，返回该位置是否会出界
        if (visited[x][y]) return outOfBounds[x][y];

        // 标记当前格子为已访问
        visited[x][y] = true;

        // 根据滑行带方向决定下一步
        int nextX = x, nextY = y;
        switch (grid[x][y]) {
            case 'L': nextY--; break;
            case 'R': nextY++; break;
            case 'U': nextX--; break;
            case 'D': nextX++; break;
        }

        // DFS 判断下一个格子的状态
        boolean result = dfs(nextX, nextY);

        // 如果下一格出界，则当前格子也出界，否则留在网格中
        outOfBounds[x][y] = result;

        // 如果不出界且当前格子和下一格处于一个环，则标记为环的一部分
        if (!result) {
            inCycle[x][y] = true;
        }

        return outOfBounds[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];
        visited = new boolean[n][m];
        inCycle = new boolean[n][m];
        outOfBounds = new boolean[n][m];

        // 读取网格信息
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        // 遍历所有格子并计算最终状态
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        // 统计还剩下的机器人数量（在环中的机器人不会出界）
        int remainingRobots = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!outOfBounds[i][j]) {
                    remainingRobots++;
                }
            }
        }

        // 输出结果
        System.out.println(remainingRobots);
    }
}

