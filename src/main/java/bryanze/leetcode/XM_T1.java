package bryanze.leetcode;

import java.util.Scanner;

/**
 * 100%
 * @author lizelin
 * @date 2024/09/05
 */
public class XM_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, a[i] + b[i]);
        }

        int minAIndex = 0;
        int minBIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < a[minAIndex]) {
                minAIndex = i;
            }
            if (b[i] < b[minBIndex]) {
                minBIndex = i;
            }

        }

        if (minAIndex != minBIndex) {
            res = Math.min(res, Math.max(a[minAIndex], b[minBIndex]));
        } else {
            int secondMinA = Integer.MAX_VALUE;
            int secondMinB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i != minAIndex) {
                    secondMinA = Math.min(secondMinA, a[i]);
                }
                if (i != minBIndex) {
                    secondMinB = Math.min(secondMinB, b[i]);
                }

            }
            res = Math.min(res, Math.max(secondMinA, b[minBIndex]));
            res = Math.min(res, Math.max(secondMinB, a[minAIndex]));
        }

        System.out.println(res);

    }
}
