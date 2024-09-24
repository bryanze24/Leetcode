package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/14
 */
public class MT914_T3 {
    static int maxCoins;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] next = new int[n + 1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            next[i] = sc.nextInt();

        }
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int k = sc.nextInt();
            maxCoins = 0;
            int res = dfs(u, k, next, a, x, y, 0, maxCoins);
            list.add(res);
        }
        for (Integer temp : list) {
            System.out.println(temp);
        }
    }

    private static int dfs(int u, int k, int[] next, int[] a, int x, int y,
                            int currentStep, int currentCoins) {
        if (currentStep > k) {
            return currentCoins;
        }

        int nextValue = a[next[u]];
        int coinsToAdd = nextValue > a[u] ? x : y;
        currentCoins += coinsToAdd;
        dfs(next[u], k, next, a, x, y, currentStep + 1, currentCoins);
        if (next[u] != u) {
            dfs(u, k, next, a, x, y, currentStep + 1, currentCoins);
        }
        return 0;
    }
}
