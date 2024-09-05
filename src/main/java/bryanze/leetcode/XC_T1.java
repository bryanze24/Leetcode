package bryanze.leetcode;

import javax.print.attribute.standard.PrinterURI;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/05
 */
public class XC_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dfs(n, k);

    }

    public static void dfs(int n, int k) {
        for (int i = 1; i <= k - 1; i++) {
            System.out.print(i + " ");

        }

        for (int i = n; i >= k; i--) {
            System.out.print(i + " ");
        }

    }
}
