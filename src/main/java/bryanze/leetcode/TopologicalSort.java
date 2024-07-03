package bryanze.leetcode;

import java.util.*;

/**
 * 某个大型软件项目的构建系统拥有 N 个文件，文件编号从 0 到 N - 1，
 * 在这些文件中，某些文件依赖于其他文件的内容，这意味着如果文件 A 依赖于文件 B，
 * 则必须在处理文件 A 之前处理文件 B （0 <= A, B <= N - 1）。
 * 请编写一个算法，用于确定文件处理的顺序。
 * <p>
 * 输入描述：
 * 第一行输入两个正整数 M, N。表示 N 个文件之间拥有 M 条依赖关系。
 * 后续 M 行，每行两个正整数 S 和 T，表示 T 文件依赖于 S 文件。
 * <p>
 * 输出描述：
 * 输出共一行，如果能处理成功，则输出文件顺序，用空格隔开。
 * 如果不能成功处理（相互依赖），则输出 -1。
 *
 * @author lizelin
 * @date 2024/07/01
 */
public class TopologicalSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] inDegree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        while (m-- > 0) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            inDegree[t]++;
            if (map.containsKey(s)) {
                map.get(s).add(t);
            } else {
                map.put(s, new ArrayList<>());
                map.get(s).add(t);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            List<Integer> files = map.get(cur);
            if (files != null && !files.isEmpty()) {
                for (Integer file : files) {
                    inDegree[file]--;
                    if (inDegree[file] == 0) {
                        queue.offer(file);
                    }
                }
            }
        }

        if (result.size() == n) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.print(result.get(n - 1));
        } else {
            System.out.println(-1);
        }

    }
}
