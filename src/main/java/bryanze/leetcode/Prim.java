package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小生成树算法之Prim算法
 * <p>
 * 在世界的某个区域，有一些分散的神秘岛屿，每个岛屿上都有一种珍稀的资源或者宝藏。
 * 国王打算在这些岛屿上建公路，方便运输。
 * 不同岛屿之间，路途距离不同，国王希望你可以规划建公路的方案，
 * 如何可以以最短的总公路距离将 所有岛屿联通起来（注意：这是一个无向图）。
 * 给定一张地图，其中包括了所有的岛屿，以及它们之间的距离。以最小化公路建设长度，确保可以链接到所有岛屿。
 * <p>
 * 输入描述：第一行包含两个整数V 和 E，V代表顶点数，E代表边数 。
 * 顶点编号是从1到V。例如：V=2，一个有两个顶点，分别是1和2。
 * 接下来共有 E 行，每行三个整数 v1，v2 和 val，v1 和 v2 为边的起点和终点，val代表边的权值。
 * <p>
 * 输出描述：输出联通所有岛屿的最小路径总距离
 *
 * @author lizelin
 * @date 2024/06/28
 */
public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] grid = new int[v + 1][v + 1];

        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(grid[i], 10001);
        }

        while (e-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            grid[x][y] = k;
            grid[y][x] = k;
        }

        int[] minDist = new int[v + 1];
        boolean[] isInTree = new boolean[v + 1];
        Arrays.fill(minDist, 10001);
        Arrays.fill(isInTree, false);

        for (int i = 1; i < v; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && minVal > minDist[j]) {
                    minVal = minDist[j];
                    cur = j;
                }

            }

            isInTree[cur] = true;

            for (int j = 1; j <= v; j++) {
                if (!isInTree[j] && grid[cur][j] < minDist[j]) {
                    minDist[j] = grid[cur][j];
                }
            }
        }

        int result = 0;
        for (int i = 2; i <= v; i++) {
            result += minDist[i];

        }

        System.out.println(result);
    }
}
