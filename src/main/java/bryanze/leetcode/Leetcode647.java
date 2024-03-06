package bryanze.leetcode;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * @author lizelin
 * @date 2024/03/06
 */
public class Leetcode647 {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Leetcode647().countSubstrings(s));
    }

}
