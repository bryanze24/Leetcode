package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/03/23
 */
public class CodeFun1727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int res = 0;
        for (int i = 1; i < n; i++) {
            int count = 1;
            while (i < n) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            res = res + count - 1;
        }

        System.out.println(res);
    }
}
