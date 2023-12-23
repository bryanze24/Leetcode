package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 * @author lizelin
 * @date 2023/12/23
 */
public class Leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        List<String> list = new ArrayList<>();

        while(k > 0){
            list.add(queue.poll().getKey());
            k--;
        }

        return list;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(new Leetcode692().topKFrequent(words, 4));
    }
}
