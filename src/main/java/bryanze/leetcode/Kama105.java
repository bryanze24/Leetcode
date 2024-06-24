package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个有向图，包含 N 个节点，节点编号分别为 1，2，...，N。
 * 现从 1 号节点开始，如果可以从 1 号节点的边可以到达任何节点，则输出 1，否则输出 -1。
 * <p>
 * 输入描述：第一行包含两个正整数，表示节点数量 N 和边的数量 K。 后续 K 行，
 * 每行两个正整数 s 和 t，表示从 s 节点有一条边单向连接到 t 节点。
 * <p>
 * 输出描述：如果可以从 1 号节点的边可以到达任何节点，则输出 1，否则输出 -1。
 *
 * @author lizelin
 * @date 2024/06/24
 */

class Kama105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while (k-- > 0) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            if (map.containsKey(s)) {
                map.get(s).add(t);
            } else {
                map.put(s, new ArrayList<>());
                map.get(s).add(t);
            }
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int key = queue.poll();
            List<Integer> list = map.get(key);
            if (list != null) {
                for (int keys : list) {
                    if (!visit[keys]) {
                        queue.offer(keys);
                        visit[keys] = true;
                    }
                }
            }

        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                System.out.println("-1");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("1");
        }

    }
}
