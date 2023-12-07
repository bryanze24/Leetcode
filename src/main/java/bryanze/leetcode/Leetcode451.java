package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。
 * 一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * @author lizelin
 * @date 2023/12/07
 */
public class Leetcode451 {
    public String frequencySort(String s) {

        char[] array = s.toCharArray();

        List<Map.Entry<Character, Integer>> list = getEntryList(array);

//        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            Integer value = entry.getValue();
            while (value > 0) {
                sb.append(entry.getKey());
                value--;
            }
        }

        return sb.toString();

    }

    private static List<Map.Entry<Character, Integer>> getEntryList(char[] array) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : array) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

//        System.out.println(map);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return -(o1.getValue() - o2.getValue());
            }
        });
        return list;
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(new Leetcode451().frequencySort(str));
    }
}
