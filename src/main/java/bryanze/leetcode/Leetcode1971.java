package bryanze.leetcode;

/**
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。
 * 图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。
 * 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，
 * 如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 *
 * @author lizelin
 * @date 2024/06/27
 */
public class Leetcode1971 {

    static class UnionFind {

        int[] father;
        int n;

        public UnionFind(int n) {
            father = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                father[i] = i;

            }
        }

        int find(int u) {
            if (u == father[u]) {
                return u;
            } else {
                return father[u] = find(father[u]);
            }
        }

        boolean isSame(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) {
                return;
            }
            father[v] = u;
        }
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.join(edge[0], edge[1]);
        }

        return uf.isSame(source, destination);
    }
}
