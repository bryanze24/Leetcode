package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，
 * 所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。
 * 附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，
 * 用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 * @author lizelin
 * @date 2024/06/27
 */
public class Leetcode685 {

    int[] father = new int[1001];

    void init() {
        for (int i = 0; i < father.length; i++) {
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

    boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge) {
        init();
        for (int i = 0; i < edges.length; i++) {
            if (i == deleteEdge) continue;
            if (isSame(edges[i][0], edges[i][1])) { // 构成有向环了，一定不是树
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    int[] getRemoveEdge(int[][] edges) {
        init();
        for (int i = 0; i < father.length; i++) {
            if (isSame(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                list.add(i);
            }
        }


        if (!list.isEmpty()) {
            if (isTreeAfterRemoveEdge(edges, list.get(0))) {
                return new int[] {edges[list.get(0)][0], edges[list.get(0)][1]};
            } else {
                return new int[] {edges[list.get(1)][0], edges[list.get(1)][1]};
            }
        }

        return getRemoveEdge(edges);
    }
}
