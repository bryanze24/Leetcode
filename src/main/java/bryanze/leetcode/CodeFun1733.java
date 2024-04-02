package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/01
 */
public class CodeFun1733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] price = new int[n];
        int[] coupon = new int[m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            price[i] = num;
            sum += num;
        }
        for (int i = 0; i < m; i++) {
            coupon[i] = sc.nextInt();
        }

        Arrays.sort(price);
        Arrays.sort(coupon);
        sum -= price[n - coupon[0]];
        System.out.println(sum);

    }
}
