package bryanze.leetcode;

import java.util.*;

/**
 * 题目描述
 * <p>
 * 某国为促进城市间经济交流，决定对货物运输提供补贴。共有 n 个编号为 1 到 n 的城市，
 * 通过道路网络连接，网络中的道路仅允许从某个城市单向通行到另一个城市，不能反向通行。
 * 网络中的道路都有各自的运输成本和政府补贴，道路的权值计算方式为：运输成本 - 政府补贴。
 * 权值为正表示扣除了政府补贴后运输货物仍需支付的费用；权值为负则表示政府的补贴超过了支出的运输成本，
 * 实际表现为运输过程中还能赚取一定的收益。
 * 请找出从城市 1 到城市 n 的所有可能路径中，综合政府补贴后的最低运输成本。
 * 如果最低运输成本是一个负数，它表示在遵循最优路径的情况下，运输过程中反而能够实现盈利。
 * 城市 1 到城市 n 之间可能会出现没有路径的情况，同时保证道路网络中不存在的任何负权回路。
 * 负权回路是指一系列道路的总权值为负，这样的回路使得通过反复经过回路中的道路，
 * 理论上可以无限地减少总成本或无限地增加总收益。
 * <p>
 * 输入描述
 * <p>
 * 第一行包含两个正整数，第一个正整数 n 表示该国一共有 n 个城市，第二个整数 m 表示这些城市中共有 m 条道路。
 * <p>
 * 接下来为 m 行，每行包括三个整数，s、t 和 v，表示 s 号城市运输货物到达 t 号城市，道路权值为 v（单向图）。
 * <p>
 * 输出描述
 * <p>
 * 如果能够从城市 1 到连通到城市 n， 请输出一个整数，表示运输成本。
 * 如果该整数是负数，则表示实现了盈利。如果从城市 1 没有路径可达城市 n，请输出 "unconnected"。
 *
 * @author lizelin
 * @date 2024/07/21
 */
public class SPFA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Table>> grid = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            grid.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int v = sc.nextInt();
            grid.get(s).add(new Table(t, v));
        }

        int start = 1;
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[start] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            List<Table> edge = grid.get(temp);
            for (Table table : edge) {
                int to = table.to;
                int value = table.value;
                if (minDist[to] > minDist[temp] + value) {
                    minDist[to] = minDist[temp] + value;
                    queue.offer(to);
                }
            }
        }

        if (minDist[n] != Integer.MAX_VALUE) {
            System.out.println(minDist[n]);
        } else {
            System.out.println("unconnected");
        }
    }

}

class Table {
    int to;
    int value;

    public Table(int to, int value) {
        this.to = to;
        this.value = value;
    }
}