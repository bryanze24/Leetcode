package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/05
 */
public class XC_T3 {
    static int n ,m ,k;
    static int[] digits;
    static boolean[] used;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        digits = new int[m];
        used = new boolean[n + 1];
        backTrack(0);
        System.out.println(count);
    }

    public static void backTrack(int id) {
        if (id == m) {
            check();
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (!used[i]){
                digits[id] = i;
                used[i] = true;
                backTrack(id + 1);
                used[i] = false;
            }

        }
    }

    private static void check() {
        if (digits[0] == 0) {
            return;
        }
        int number = 0;
        for (int i = 0; i < m; i++) {
            number = number * 10 + digits[i];

        }
        if (number > k) {
            count++;
        }
    }

}
