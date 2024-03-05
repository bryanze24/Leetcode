package bryanze.leetcode;


/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 *
 * @author lizelin
 * @date 2024/03/05
 */
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {

        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = index; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count++;
                    index = j + 1;
                    break;
                }
            }
            continue;
        }

        return count == s.length();
    }

    public boolean isSubsequenceByDp(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        int l1 = s.length();
        int l2 = t.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (sCharArray[i - 1] == tCharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }

        }

        return dp[l1][l2] == l1;
    }

    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(new Leetcode392().isSubsequence(s, t));
    }
}
