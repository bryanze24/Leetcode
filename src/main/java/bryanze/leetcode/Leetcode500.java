package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * @author lizelin
 * @date 2023/11/21
 */
public class Leetcode500 {
    public String[] findWords(String[] words) {

        List<String> ans = new ArrayList<>();
        String str1 = "qwertyuiopQWERTYUIOP";
        String str2 = "asdfghjklASDFGHJKL";
        String str3 = "zxcvbnmZXCVBNM";

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            set1.add(str1.charAt(i));
        }

        for (int i = 0; i < str2.length(); i++) {
            set2.add(str2.charAt(i));
        }

        for (int i = 0; i < str3.length(); i++) {
            set3.add(str3.charAt(i));
        }

        for (String word : words) {
            int length = word.length();
            int n1 = 0;
            int n2 = 0;
            char c = word.charAt(0);

            if (set1.contains(c)) {
                n1 = 1;
                n2 = n1;
            } else if (set2.contains(c)) {
                n1 = 2;
                n2 = n1;
            } else if (set3.contains(c)) {
                n1 = 3;
                n2 = n1;
            }

            for (int i = 1; i < length && n1 == n2; i++) {
                char cc = word.charAt(i);
                if (set1.contains(cc)) {
                    n2 = 1;
                } else if (set2.contains(cc)) {
                    n2 = 2;
                } else if (set3.contains(cc)) {
                    n2 = 3;
                }
            }

            if (n1 == n2) {
                ans.add(word);
            }

        }

        return ans.toArray(new String[0]);
    }

    public String[] findWords1(String[] words) {
        String rowIdx = "12210111011122000010020202";
        List<String> list = new ArrayList<>();

        for (String word : words) {
            int id = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            boolean flag = true;

            for (int i = 1; i < word.length(); i++) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != id) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(word);
            }

        }

        return list.toArray(new String[0]);
    }

}
