package bryanze.leetcode;

import com.sun.corba.se.impl.io.ValueHandlerImpl;
import com.sun.corba.se.impl.oa.toa.TOA;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class MT97_T2 {
//    static int[] sonCount;
//    static Map<Integer, Integer> sonMap;
//    static List<List<Integer>> tree;
//    static boolean[] visited;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while (T-- > 0) {
//            int n = sc.nextInt();
//            tree = new ArrayList<>();
//            for (int i = 0; i <= n; i++) {
//                tree.add(new ArrayList<>());
//            }
//            for (int i = 0; i < n - 1; i++) {
//                int u = sc.nextInt();
//                int v = sc.nextInt();
//                tree.get(u).add(v);
//                tree.get(v).add(u);
//            }
//
//            sonCount = new int[n + 1];
//            visited = new boolean[n + 1];
//            sonMap = new HashMap<>();
//            dfs(1);
//            long result = 0;
//            for (Integer value : sonMap.values()) {
//                if (value > 1) {
//                    result += ((long) value * (value - 1)) / 2;
//                }
//            }
//            System.out.println(result);
//        }
//    }
//
//    private static int dfs(int node) {
//        visited[node] = true;
//        int totalSons = 0;
//        for (Integer num : tree.get(node)) {
//            if (!visited[num]) {
//                totalSons += dfs(num) + 1;
//            }
//        }
//        sonCount[node] = totalSons;
//        sonMap.put(totalSons, sonMap.getOrDefault(totalSons, 0) + 1);
//        return totalSons;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<Long> ans = new ArrayList<>();
        while (T-- > 0) {
            int n = sc.nextInt();
            List<List<Integer>> children = buildTree(sc, n);
            long res = countSimilarPairs(children);
            ans.add(res);
        }
        for (Long num : ans) {
            System.out.println(num);
        }
    }

    private static long countSimilarPairs(List<List<Integer>> children) {
        HashMap<Integer, Long> childCountMap = new HashMap<>();
        long count = 0;
        for (int i = 1; i < children.size(); i++) {
            int sonCount = children.get(i).size();
            if (childCountMap.containsKey(sonCount)) {
                count += childCountMap.get(sonCount);
            }
            childCountMap.put(sonCount, childCountMap.getOrDefault(sonCount, 0L) + 1);

        }
        return count;
    }

    private static List<List<Integer>> buildTree(Scanner sc, int n) {
        List<List<Integer>> children = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            children.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            children.get(u).add(v);

        }
        return children;
    }
}
