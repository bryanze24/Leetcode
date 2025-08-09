package bryanze.leetcode;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/25
 */
public class XL_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if ("".equals(str)) {
            System.out.println(0);

        } else {
            String[] split = str.split("\\s+");
            int[] array = new int[split.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(split[i]);
            }

            int ans = dfs(array);
            System.out.println(ans);
        }

    }

    private static int dfs(int[] array) {
        int n = array.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int currentLen = 1;
            int change = 0;
            for (int j = i + 1; j < n; j++) {
                if (array[j] == array[i]) {
                    currentLen++;
                } else if (change < 3) {
                    currentLen++;
                    change++;
                } else {
                    break;
                }

            }
            maxLen = Math.max(maxLen, currentLen);

        }
        return maxLen;
    }
}
