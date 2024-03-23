package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/03/22
 */
public class CodeFun1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder builder = new StringBuilder();
        int[] a = new int[100000];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < str.length(); i++) {
            a[i] = (a[i - 1] + a[i - 2] + a[i - 3]) % 26;
        }

        for (int i = 0; i < str.length(); i++) {
            char num = (char)a[i];
            char t = (char)((str.charAt(i) + num - 'a') % 26 + 'a');
            builder.append(t);
        }

        System.out.println(builder.toString());

    }
}
