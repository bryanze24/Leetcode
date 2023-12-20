package bryanze.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，
 * 该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * @author lizelin
 * @date 2023/12/15
 */
public class Leetcode524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String string : dictionary) {

            int i = 0, j = 0;

            while (i < string.length() && j < s.length()) {
                if (string.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }

            if (i == string.length()) {
                if (string.length() > result.length() ||
                        (string.length() == result.length() && string.compareTo(result) < 0)) {
                    result = string;
                }
            }
        }

        return result;
    }

    public String findLongestWord1(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            } else {
                return o1.compareTo(o2);
            }
        });

        for (String str : dictionary) {
            int i = 0, j = 0;

            while (i < str.length() && j < s.length()) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }

            if (i == str.length()) {
                return str;
            }
        }
        return "";
    }

    public String findLongestWord2(String s, List<String> dictionary) {
        int n = s.length();
        int[][] dp = new int[n + 1][26];

        // 初始化结尾
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }

        // 初始化 dp 数组
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) - 'a' == j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        String result = "";

        for (String t : dictionary) {
            // count 记录相等字符的个数
            int count = 0, index = 0;
            for (char c : t.toCharArray()) {

                // 如果下一个字符的下标为 n，则表示该字符不存在
                if (dp[index][c - 'a'] == n) {
                    break;
                }

                count++;
                // 移动到下一个字符的后面
                index = dp[index][c - 'a'] + 1;

            }

            // 判断是否到了最后一个字符
            if (count == t.length()) {
                // 长度最长且字典顺序最小的字符串
                if (t.length() > result.length() ||
                    (t.length() == result.length() && result.compareTo(t) > 0)) {
                    result = t;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        String s = "abpcplea";
        System.out.println(new Leetcode524().findLongestWord2(s, dictionary));
    }
}
