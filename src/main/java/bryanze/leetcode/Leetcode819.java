package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 *
 * @author lizelin
 * @date 2023/11/26
 */
public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        //正则表达式截取段落
        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");

        HashSet<String> set = new HashSet<>(Arrays.asList(banned));

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : split) {
            if (!set.contains(str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

//        System.out.println(map);

        int max = 0;
        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }
        return result;

    }

    public String mostCommonWord1(String paragraph, String[] banned) {

        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");
        HashMap<String, Integer> map = new HashMap<>();

        char[] array = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();

        //手动截取
        for (char ch : array) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                String key = sb.toString();
                if (!set.contains(key)) {
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }

                sb.setLength(0);
            }
        }

        if(sb.length() > 0){
            String key = sb.toString();
            if (!set.contains(key)) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

        }

//        System.out.println(map);

        int max = 0;
        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(new Leetcode819().mostCommonWord1(str, new String[]{"hit"}));
    }
}
