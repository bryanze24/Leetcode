package bryanze.leetcode;

import java.util.*;

/**
 * 小红定义一个字符串是“好串”，当且仅当该字符串的每个字符都相等。
 * 小红拿到了一个字符串，她想知道最多可以找到多少个互不重的、
 * 长度为k的相同的连续子串，满足这些子串都是好串？
 * <p>
 * 输入描述
 * 第一行输入两个正整数n，k，分别表示字符串长度以及你需要找到的子串的长度。
 * 第二行输入一个长度为n的、仅由小写字母组成的字符串str。
 * 2≤n≤2×100000，1≤k≤n
 * <p>
 * 输出描述
 * 输出一个整数表示小红可以取的最多子串数量。
 *
 * @author lizelin
 * @date 2024/09/03
 */
public class DW_T2 {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        for (int i = 0; i <= n - k; ) {
            boolean isFlag = true;
            char c = str.charAt(i);
            int j = 1;
            for (; j < k; j++) {
                if (str.charAt(i + j) != c) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                ans.add(str.substring(i, i + j));
                i += k;
            } else {
                i++;
            }

        }
        Collections.sort(ans);

        int count = 1;
        int result = 1;
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i).equals(ans.get(i - 1))) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
        System.out.println(result);
    }
}
