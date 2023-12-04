package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，
 * 在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * @author lizelin
 * @date 2023/11/22
 */

public class Leetcode140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        dfs(s, ans, 0, new LinkedList<>(), set);

        return ans;

    }

    private void dfs(String s, List<String> ans, int idx, Deque<String> path, Set<String> set) {
        if (idx == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);

            if (set.contains(str)) {
                path.add(str);
                dfs(s, ans, i + 1, path, set);
                path.removeLast();

            }

        }

    }

    public static void main(String[] args) {
        String s =  "catsanddog";
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");

        List<String> strings = new Leetcode140().wordBreak(s, list);
        System.out.println(strings);
    }
}
