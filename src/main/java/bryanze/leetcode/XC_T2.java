package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/05
 */
public class XC_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.next();
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                int remain = n - i;
                count += (remain + 1) / 2;
            }

        }

        System.out.println(count);
    }
}
