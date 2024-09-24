package bryanze.leetcode;

import java.util.Map;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class JD97_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int left = 1, right = n;
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            left = Math.max(left, l);
            right = Math.min(right, r);

        }
        System.out.println(Math.max(0, right - left + 1));
    }
}
