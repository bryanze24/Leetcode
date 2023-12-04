package bryanze.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author lizelin
 * @date 2023/11/22
 */
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) {
                continue;
            }

            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }

        }

        return dp[length];
    }
}
