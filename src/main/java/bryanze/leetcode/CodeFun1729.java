package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/03/30
 */
public class CodeFun1729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        String str = sc.next();
        String[] s = str.split("[()]");
        char[] ch = new char[s.length / 2];
        long[] nums = new long[ch.length];
        boolean[] vis = new boolean[26];
        long allDiff = 0;

        for (int i = 0; i < s.length; i+=2) {
            ch[i / 2] = s[i].charAt(0);
            allDiff += vis[ch[i / 2] - 'a'] ? 0 : 1;
            vis[ch[i / 2] - 'a'] = true;
            nums[i / 2] = Long.parseLong(s[i + 1]);
        }

        if (allDiff * n < k) {
            System.out.println(-1);
            return;
        }

        Arrays.fill(vis, false);
        long diff = 0;
        long m = 0;
        long ans = 0;

        for (int i = 0; i < ch.length; i++) {
            int c = ch[i] - 'a';
            long j = nums[i];

            if (!vis[c]) {
                vis[c] = true;
                diff++;
            }

            if (diff * (m + j) < k) {
                m += j;
                continue;
            }

            long low = m + 1, high = m + j, idx = m + j;
            while (low <= high) {
                long mid = (low + high) >>> 1L;
                if (diff * mid >= k) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans++;
            long last = m + j - idx;
            long cur = last / k;
            high = last % k;
            ans += cur;

            diff = 0;
            m = 0;


            if (high > 0) {
                vis[c] = true;
                m = high;
                diff = 1;
            }


        }

        System.out.println(ans);
    }
}
