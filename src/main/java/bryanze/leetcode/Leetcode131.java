package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * @author lizelin
 * @date 2024/03/09
 */
public class Leetcode131 {
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {

        backTracking(s, 0);
        return ans;
    }

    private void backTracking(String s, int index) {
        if (index >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindromic(s, index, i)) {
                String substring = s.substring(index, i + 1);
                path.add(substring);
            } else {
                continue;
            }

            backTracking(s, i + 1);
            path.removeLast();
        }

    }

    private boolean isPalindromic(String s, int start, int end) {

        int i = start;
        int j = end;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode131().partition("aab"));
    }

}
