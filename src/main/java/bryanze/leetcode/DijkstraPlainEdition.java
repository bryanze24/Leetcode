package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明是一位科学家，他需要参加一场重要的国际科学大会，以展示自己的最新研究成果。
 * 小明的起点是第一个车站，终点是最后一个车站。然而，途中的各个车站之间的道路状况、
 * 交通拥堵的程度以及可能的自然因素（如天气变化）等不同，这些因素都会影响每条路径的通行时间。
 * 小明希望能选择一条花费时间最少的路线，以确保他能够尽快到达目的地。
 * <p>
 * 【输入描述】
 * 第一行包含两个正整数，第一个正整数 N 表示一共有 N 个公共汽车站，第二个正整数 M 表示有 M 条公路。
 * 接下来为 M 行，每行包括三个整数，S、E 和 V，代表了从 S 车站可以单向直达 E 车站，并且需要花费 V 单位的时间。
 * <p>
 * 【输出描述】
 * 输出一个整数，代表小明从起点到终点所花费的最小时间。
 *
 * @author lizelin
 * @date 2024/07/02
 */
public class DijkstraPlainEdition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }

        while (m-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            grid[s][e] = v;
        }

        int start = 1;
        // 存储从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;

        // 记录每个节点是否被访问过
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) { // 遍历所有节点
            int minVal = Integer.MAX_VALUE;
            int cur = 1;

            // 1.选取距离源点最近且未被访问过的节点
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && minVal > minDist[j]) {
                    minVal = minDist[j];
                    cur = j;
                }
            }

            // 2.标记该节点已经被访问
            visited[cur] = true;

            // 3.更新非访问节点到源点的距离
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && grid[cur][j] != Integer.MAX_VALUE &&
                        minDist[cur] + grid[cur][j] < minDist[j]) {
                    minDist[j] = minDist[cur] + grid[cur][j];
                }
            }
        }

        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[n]);
        }
    }
}
