package bryanze.leetcode;

import java.util.*;

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
public class DijkstraHeapOptimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> grid = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            grid.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            // s 指向 e, 权值为 v
            grid.get(s).add(new Edge(e, v));
        }

        int start = 1; // 起点

        // 存储从源点到每个节点的最短距离
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // 记录顶点是否被访问过
        boolean[] visited = new boolean[n + 1];

        // 优先队列中存放 pair<节点，源点到该节点的权值>
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new cmp());
        // 初始化队列，源点到源点的距离为0，所以初始为0
        queue.offer(new Pair<>(start, 0));

        minDist[start] = 0; // 起始点到自身的距离为0

        while (!queue.isEmpty()) {
            // 1. 第一步，选源点到哪个节点近且该节点未被访问过 （通过优先级队列来实现）
            // <节点， 源点到该节点的距离>
            Pair<Integer, Integer> cur = queue.poll();

            if (visited[cur.first]) {
                continue;
            }

            // 2. 第二步，该最近节点被标记访问过
            visited[cur.first] = true;

            // 3. 第三步，更新非访问节点到源点的距离（即更新minDist数组）
            for (Edge edge : grid.get(cur.first)) { // 遍历 cur指向的节点，cur指向的节点为 edge
                // cur指向的节点edge.to，这条边的权值为 edge.val
                if (!visited[edge.to] && minDist[cur.first] + edge.value < minDist[edge.to]) {
                    minDist[edge.to] = minDist[cur.first] + edge.value;
                    queue.offer(new Pair<>(edge.to, minDist[edge.to]));
                }
            }
        }

        if (minDist[n] == Integer.MAX_VALUE) { // 不能到达终点
            System.out.println(-1);
        } else { // 到达终点最短路径
            System.out.println(minDist[n]);
        }
    }

}

// 定义一个类来表示带权重的边
class Edge {
    int to; // 邻接顶点
    int value; // 边的权重

    public Edge(int to, int value) {
        this.to = to;
        this.value = value;
    }
}

class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

// 小顶堆
class cmp implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return Integer.compare(o1.second, o2.second);
    }
}
