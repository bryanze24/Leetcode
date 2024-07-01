package bryanze.leetcode;

import java.util.*;

/**
 * * 最小生成树算法之Kruskal算法
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
 * @date 2024/07/01
 */
public class Kruskal {

    static int[] father = new int[10001];

    static void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    static int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            return father[u] = find(father[u]);
        }
    }

    static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    static class Edge {
        int l, r, val;

        public Edge(int l, int r, int val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        while (e-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            edges.add(new Edge(x, y ,k));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.val));

        int result = 0;
        init();
        for (Edge edge : edges) {
            int x = find(edge.l);
            int y = find(edge.r);
            if (x != y) {
                result += edge.val;
                join(x, y);
            }

        }

        System.out.println(result);
    }

}
