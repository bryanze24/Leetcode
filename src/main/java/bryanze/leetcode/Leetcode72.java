package bryanze.leetcode;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数.
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * @author lizelin
 * @date 2024/03/06
 */
public class Leetcode72 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        // dp[i][j]表示以i-1为结尾的word1转成以j-1为结尾的Word2所需的最小步数
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1 + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < l2 + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < l1 + 1; i++) {

            for (int j = 1; j < l2 + 1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

            }
        }


        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new Leetcode72().minDistance(word1, word2));
    }

}
