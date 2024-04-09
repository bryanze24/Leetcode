package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class xhst2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
//        String[] array = new String[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = in.next();
            boolean flag = dfs(str);
            if (flag) {
                ans++;
            }
        }

        System.out.println(ans);

    }


    public static boolean dfs(String str) {

        char[] array = str.toCharArray();
        int iIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'i') {
                iIndex = i;
                break;
            }
        }

        int signal = 0;
        if (iIndex == -1) {
            return true;
        } else {
            for (int i = 0; i < iIndex; i++) {
                if (array[i] == '+' || array[i] == '-') {
                    signal = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = signal; i < iIndex; i++) {
            sb.append(array[i]);
        }

        String string = sb.toString();

        if (string.isEmpty() || Integer.parseInt(string) != 0) {
            return false;
        } else {
            return true;
        }

    }
}
