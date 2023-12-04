package bryanze.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * @author lizelin
 * @date 2023/11/22
 */

public class Leetcode387 {
    public int firstUniqChar(String s) {
        if(s.length() == 1){
            return 0;
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return s.indexOf(entry.getKey());
            }
        }

        return -1;

    }

    public int firstUniqChar1(String s){

        int[] array = new int[26];
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            array[ch - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if(array[s.charAt(i) - 'a'] == 1){
                return i;
            }

        }
        return -1;

    }


    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Leetcode387().firstUniqChar(s));
    }
}
