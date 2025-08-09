package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/10/12
 */
import java.util.*;

public class T2 {
    static class Road {
        int city, distance, cost;

        public Road(int city, int distance, int cost) {
            this.city = city;
            this.distance = distance;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int city, distance, cost;
        boolean crossedBorder;

        public State(int city, int distance, int cost, boolean crossedBorder) {
            this.city = city;
            this.distance = distance;
            this.cost = cost;
            this.crossedBorder = crossedBorder;
        }

        @Override
        public int compareTo(State other) {
            if (this.distance == other.distance) {
                return Integer.compare(this.cost, other.cost);
            }
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入城市数量和公路数量
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 读取换行符

        // 输入每个城市的归属信息
        String countryInfo = sc.nextLine();

        // 初始化图结构
        List<Road>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 输入每条公路的信息
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            int c = sc.nextInt();
            graph[u].add(new Road(v, w, c));
            graph[v].add(new Road(u, w, c));
        }

        // Dijkstra 算法初始化
        int[][] dist = new int[n + 1][2];  // 距离表 [城市编号][是否已跨国 0:未跨 1:已跨]
        int[][] cost = new int[n + 1][2];  // 花费表 [城市编号][是否已跨国]
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(1, 0, 0, false));
        dist[1][0] = 0;
        cost[1][0] = 0;

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int city = curr.city;
            int currDist = curr.distance;
            int currCost = curr.cost;
            boolean crossed = curr.crossedBorder;

            // 如果已经找到了最短路径并且到达了B国城市N
            if (city == n && curr.crossedBorder) {
                System.out.println(currDist + " " + currCost);
                return;
            }

            // 遍历当前城市的所有邻接公路
            for (Road road : graph[city]) {
                int nextCity = road.city;
                int nextDist = currDist + road.distance;
                int nextCost = currCost + road.cost;

                boolean nextCrossed = curr.crossedBorder;

                // 检查是否需要跨国
                if (countryInfo.charAt(city - 1) != countryInfo.charAt(nextCity - 1)) {
                    if (curr.crossedBorder) continue;  // 只能跨国一次
                    nextCrossed = true; // 如果两城市不在同一个国家，则跨国
                }

                int crossedFlag = nextCrossed ? 1 : 0;

                // 更新距离和花费
                if (nextDist < dist[nextCity][crossedFlag] || (nextDist == dist[nextCity][crossedFlag] && nextCost < cost[nextCity][crossedFlag])) {
                    dist[nextCity][crossedFlag] = nextDist;
                    cost[nextCity][crossedFlag] = nextCost;
                    pq.offer(new State(nextCity, nextDist, nextCost, nextCrossed));
                }
            }
        }

        // 如果无法到达城市N
        System.out.println(-1);
    }
}


