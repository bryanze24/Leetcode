package bryanze.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author lizelin
 * @date 2023/11/26
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int macLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                begin = Math.max(begin, map.get(ch) + 1);
                map.put(ch, end);
            } else {
                map.put(ch, end);
            }

            macLength = Math.max(macLength, end - begin + 1);
        }
        return macLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] last = new int[128];

        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
