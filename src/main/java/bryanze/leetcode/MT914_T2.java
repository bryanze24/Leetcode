package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/14
 */
public class MT914_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Long> res = new ArrayList<>();
        while (T-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();
            long low = 0, high = a + b + c, ans = 0;
            while (low <= high) {
                long mid = (low + high) / 2;
                if (isPossible(mid, a, b, c, x, y)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            res.add(ans);
        }

        for (Long re : res) {
            System.out.println(re);
        }

    }

    private static boolean isPossible(long s, long a, long b, long c, long x, long y) {
        long blueNeedForGreen = Math.max(0L, y * (s - c));
        long totalBlueNeed = s + blueNeedForGreen;
        long redNeedForBlue = Math.max(0L, x * (totalBlueNeed - b));
        return redNeedForBlue <= a - s;
    }
}
