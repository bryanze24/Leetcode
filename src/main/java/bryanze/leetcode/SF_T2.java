package bryanze.leetcode;

import java.util.Scanner;

/**
 * 100%
 * @author lizelin
 * @date 2024/08/29
 */
public class SF_T2 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = sc.nextInt();
        }
        boolean[] visit = new boolean[n];
        int[] path = new int[n];
        backTrack(houses, visit, path, 0, n);
        System.out.println(count);

    }

    private static void backTrack(int[] houses, boolean[] visited,
                                  int[] path, int depth, int n) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (depth == 0 || path[depth - 1] % houses[i] == 0
                        || houses[i] % path[depth - 1] == 0) {
                    visited[i] = true;
                    path[depth] = houses[i];
                    backTrack(houses, visited, path, depth + 1, n);
                    visited[i] = false;
                }
            }

        }
    }
}
