package bryanze.leetcode;

import java.util.Scanner;

/**
 * 薯条哥有一种锯齿状的积木，这种积木比较长，但是每个单位长度的高度是相等的高度为 1 或者 2。
 * 现在薯条哥拿出了两块长度分别为 n 和 m 的积木，她现在想把这两块积木拼接在起，即使中间有空隙也没有关系。
 * 但是拼接后的积木的高度要不超过 3，请你帮助薯条哥计算在满足这个前提下拼接后的积木的长度最短可以是多少。
 * <p>
 * 输入描述
 * 第一行给出两个正整数n,m(1≤n,m≤1000),代表第一块和第二块积木的长度
 * 第二行给出n个数字代表第一块积木每个单位的高度
 * 第三行给出 m 个数字代表第二块积木每个单位的高度
 * <p>
 * 输出描述
 * 一个整数，表示拼接后的积木的最短长度。
 *
 * @author lizelin
 * @date 2024/08/20
 */
public class JD817_2 {

    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        String t = sc.next();
        res = n + m;
        dfs(s, t, n, m);
        dfs(t, s, m, n);
        System.out.println(res);

    }

    private static void dfs(String s, String t, int n, int m) {
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; i + j < n && j < m; j++) {
                if (t.charAt(j) == '2' && s.charAt(i + j) == '2') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.min(res, i + Math.max(n - i, m));
            }
        }
    }
}
