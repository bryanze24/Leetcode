package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/08/28
 */
public class SQB_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Long> list = new ArrayList<>();
        while (t-- > 0) {
            long n = sc.nextLong();
            long d = sc.nextLong();
            long res = dfs(n, d);
            list.add(res);
        }
        for (Long num : list) {
            System.out.println(num);
        }
    }

    private static long dfs(Long n, Long d) {
        if (n < d) {
            return 0;
        }

//        long ans = 0;
//        for (long i = d; i <= n; i++) {
//            ans += (i / d);
//        }
        long ans = 0;
        long m = n / d;
        for (long i = 1; i <= m; i++) {
            long start = d * i;
            long end = Math.min(n, d * (i + 1) - 1);
            ans += i * (end - start + 1);
        }

        return ans;
    }
}
