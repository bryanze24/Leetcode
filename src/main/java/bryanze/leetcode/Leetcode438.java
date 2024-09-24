package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @author lizelin
 * @date 2024/04/08
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int valid = 0, left = 0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }

            }

            while (right - left >= p.length()) {
                if (valid == p.length()) {
                    list.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }

                    window.put(d, window.get(d) - 1);
                }

            }

        }

        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        p = new String(charArray);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int j = i + p.length();
            String subString = s.substring(i, j);
            char[] temp = subString.toCharArray();
            Arrays.sort(temp);
            String t = new String(temp);
            if (t.equals(p)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(new Leetcode438().findAnagrams(s, p));
    }
}
