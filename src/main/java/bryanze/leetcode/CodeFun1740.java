package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/05
 */
public class CodeFun1740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] power = new int[n];

        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();

        }

        Arrays.sort(power);
        int ans = 2 * n + 1;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, power[i] + (n - i - 1) * 2);
        }

        System.out.println(ans);
    }
}
