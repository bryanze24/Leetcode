package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/08/19
 */
public class WL_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();

        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (str.charAt(i) != '('){
                continue;
            }

            int j = i + 1;
            while (j < n) {
                if (str.charAt(j) == ')') {
                    count++;
                }
                if (count >= k) {
                    res++;
                }
                j++;
            }

        }

        System.out.println(res);
    }
}
