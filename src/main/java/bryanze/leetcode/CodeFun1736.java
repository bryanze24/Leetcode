package bryanze.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lizelin
 * @date 2024/04/02
 */
public class CodeFun1736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String A = sc.next();
        String B = sc.next();

        Set<String> set = new HashSet<>();
        char[] temp = new char[n];

        for (int i = 0; i <= m - n; i++) {
            String sub = A.substring(i, n + i);
            for (int j = 0; j < n; j++) {
                temp[j] = sub.charAt(j) == B.charAt(j) ? '0' : '1';
            }

            if (isValid(temp)) {
                set.add(sub);
            }
        }

        System.out.println(set.size());
    }

    public static boolean isValid(char[] str) {
        int count = 0;
        for (char c : str) {
            if (c == '1') {
                count++;
            }
        }

        return count % 2 == 0;
    }
}
