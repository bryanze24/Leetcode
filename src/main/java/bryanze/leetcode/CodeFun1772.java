package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class CodeFun1772 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int n = s.length();
        int i = n - 1;

        while (i >= 0 && s.charAt(i) == t.charAt(i)) {
            i--;
        }

        if (i < 0) {
            System.out.println(0);
        } else {
            int aok = 1, bok = 1;
            for (int j = 1; j <= i; j++) {
                if (s.charAt(0) != s.charAt(j)) {
                    aok = 0;
                }
                if (t.charAt(0) != t.charAt(j)) {
                    bok = 0;
                }
            }
            if (aok == 1) {
                System.out.println("1");
                System.out.println("2 " + (i + 1) + " " + s.charAt(0));
            } else if (bok == 1) {
                System.out.println("1");
                System.out.println("1 " + (i + 1) + " " + t.charAt(0));
            } else {
                System.out.println("2");
                System.out.println("1 " + n + " a");
                System.out.println("2 " + n + " a");
            }
        }
    }
}
