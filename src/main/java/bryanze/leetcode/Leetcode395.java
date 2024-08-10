package bryanze.leetcode;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
 * 要求该子串中的每一个字符出现次数都不少于 k 。返回这一子串的长度。
 * 如果不存在这样的子字符串，则返回 0。
 *
 * @author lizelin
 * @date 2024/08/10
 */
public class Leetcode395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int res = 0;
                String[] split = s.split(String.valueOf(s.charAt(i)));
                for (String str : split) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode395().longestSubstring("ababbc", 2));
    }
}
