package bryanze.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/05
 */
public class CodeFun1741 {
    static final int mod = 1_000_000_007;

    public static int dfs(int x, int k) {
        int res = 1;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = (int) ((long) res * x % mod);
            }
            x = (int) ((long) x * x % mod);
            k >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            b[i] = scanner.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int key = a[i] + b[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (int val : map.values()) {
//            ans += (dfs(2, val) - 1 + mod) % mod;
            ans += (long) (Math.pow(2, val) - 1);
        }

        System.out.println(ans % mod);
    }
}
