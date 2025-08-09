package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizelin
 * @date 2024/11/11
 */


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param words string字符串一维数组 单词组
     * @param n     int整型 正整数
     * @return string字符串
     */
    public String lessNFrequent(String[] words, int n) {
        // write code here
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        // LinkedHashMap<String, Integer> orderCountMap = new LinkedHashMap<>();
        // for (String word : words) {
        //     if (!orderCountMap.containsKey(word)) {
        //         orderCountMap.put(word, countMap.get(word));
        //     }
        // }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return a.getKey().compareTo(b.getKey());
            } else {
                return a.getValue() - b.getValue();
            }
        });
        // List<String> result = new ArrayList<>();
        // for (int i = 0; i < Math.min(n, sortedList.size()); i++) {
        //     Map.Entry<String, Integer> entry = sortedList.get(i);
        //     result.add(entry.getKey() + "-" + entry.getValue());
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = Math.min(n, sortedList.size()) - 1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = sortedList.get(i);

            sb.append(entry.getKey()).append("-").append(entry.getValue()).append(",");
        }
        // for (int i = n - 1; i >= 0; i--) {
        //     sb.append(result.get(i) + ",");
        // }
        // HashSet<String> set = new HashSet<>();
        // for (String word : words) {
        //     if (orderCountMap.containsKey(word) && orderCountMap.get(word) <= sortedList.get(n - 1).getValue() && !set.contains(word)) {
        //         set.add(word);
        //         sb.append(word).append("-").append(orderCountMap.get(word)).append(",");
        //     }
        // }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
