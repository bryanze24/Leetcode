package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/01
 */
public class CodeFun1731 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] power = new int[n];
        int[] cooperate = new int[n];

        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cooperate[i] = sc.nextInt();
        }

        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && j - i + 1 <= k) {
                if (power[j] >= a && cooperate[j] >= b) {
                    j++;
                } else {
                    break;
                }
            }

            if( j - i == k) {
                ans++;
            } else {
                i = j;
                j++;
            }

        }

        System.out.println(ans);
    }
}
