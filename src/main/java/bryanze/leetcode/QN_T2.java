package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class QN_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        if (a[0] * b[0] >= m) {
            System.out.println(1);
            return;
        }
        int count = 1;
        for (int i = 1; i < n; i++) {

            int[] tempA = new int[i + 1];
            int[] tempB = new int[i + 1];
            System.arraycopy(a, 0, tempA, 0, i + 1);
            System.arraycopy(b, 0, tempB, 0, i + 1);
            Arrays.sort(tempA);
            Arrays.sort(tempB);
            long sum = 0;
            for (int k = 0; k < i + 1; k++) {
                sum += (tempA[k] * tempB[k]);
            }
            if (sum >= m) {
                count = i + 1;
                break;
            }


        }
        if (count == 1) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }
}
