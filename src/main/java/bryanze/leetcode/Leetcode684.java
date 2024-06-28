package bryanze.leetcode;


/**
 * 树可以看成是一个连通且 无环 的 无向图。
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。
 * 添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。
 * 如果有多个答案，则返回数组 edges 中最后出现的那个。
 *
 * @author lizelin
 * @date 2024/06/27
 */
public class Leetcode684 {

    static class UnionFind {
        int[] father;

        public UnionFind(int n) {
            father = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                father[i] = i;
            }
        }

        void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) {
                return;
            }
            father[v] = u;
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

    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind union = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (union.isSame(edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            } else {
                union.join(edge[0], edge[1]);
            }
        }
        return new int[]{-1, -1};
    }
}
