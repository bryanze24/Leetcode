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


    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; //记录字符出现最高的频率
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }

        //创建桶
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }

        //目的是把字符串中出现相同频率的字符拼接在同一个桶内
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }

        StringBuffer sb = new StringBuffer();

        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i]; //每个桶内的对象
            int size = bucket.length(); //桶内对象的长度，即字符串中所有出现i次的字符

            for (int j = 0; j < size; j++) { // 字符串中所有出现i次的字符

                for (int k = 0; k < i; k++) { //字母在第i个桶说明该字母重复i次，拼接i次
                    sb.append(bucket.charAt(j));
                }

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(new Leetcode451().frequencySort1(str));
    }
}
