package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/22
 */
public class PDD_T4 {
    static long[][][] function = new long[1010][101][8];
    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            temp.add(i);
        }
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            list.add(dfs(a));

        }

        for (Long l : list) {
            System.out.println(l);
        }

    }

    private static void op(int i, int j, int a, long b) {
        function[i][j][a] = Math.min(function[i][j][a], b);
    }

    private static long dfs(int[] a) {

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j < 100; j++) {
                Arrays.fill(function[i][j], Long.MAX_VALUE);
            }
        }
        function[0][0][0] = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 8; k++) {
                    if (function[i][j][k] == Long.MAX_VALUE) {
                        continue;
                    }

                    if ((k & 4) != 0) {
                        int newR = k & 3;
                        newR <<= 1;
                        op(i + 1, j, newR, function[i][j][k]);
                    }

                    if ((k & 2) != 0) {
                        int newR = k & 1;
                        newR <<= 1;
                        op(i + 1, j, newR, function[i][j][k]);
                    }

                    if ((k & 1) != 0) {
                        int newR = k & 2;
                        newR <<= 1;
                        op(i + 1, j, newR, function[i][j][k]);
                    }

                    int newR = k & 3;
                    newR <<= 1;
                    int newJ = j + a[i];
                    if (newJ >= 100) {
                        newJ -= 100;
                        newR |= 1;
                    }

                    op(i + 1, newJ, newR, function[i][j][k] + a[i]);

                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 8; j++) {
                res = Math.min(res, function[a.length][i][j]);

            }
        }
        return res;
    }
}
