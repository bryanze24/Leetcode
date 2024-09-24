package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/22
 */
public class PDD_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long res = count(a);
            list.add(res);
        }
        for (long ans : list) {
            System.out.println(ans);
        }
    }

    private static long count(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum * 2 % n != 0) {
            return 0;
        } else {
            long temp = totalSum * 2 / n;
            HashMap<Long, Integer> map = new HashMap<>();
            long res = 0;
            for (int num : nums) {
                res += map.getOrDefault(temp - num, 0);
                map.put((long) num, map.getOrDefault((long) num, 0) + 1);

            }
            return res;
        }
    }
}
