package bryanze.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词
 * @author lizelin
 * @date 2023/11/26
 */
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
//            if (list == null){
//                list = new ArrayList<>();
//                map.put(key, list);
//            }

            list.add(str);

        }

        return new ArrayList<>(map.values());
    }
}
