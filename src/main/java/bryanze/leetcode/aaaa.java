package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/11/21
 */
public class aaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(i, i + k);
            list.add(substring);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : list) {
            if (word.length() >= k) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

        }
        String res = "-1";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            String word = entry.getKey();
            if (count > maxCount) {
                maxCount = count;
                res = word;
            } else if (count == maxCount) {
                if (word.length() < res.length()) {
                    res = word;
                } else if (word.length() == res.length() && word.compareTo(res) < 0) {
                    res = word;
                }
            }
        }
        System.out.println(res);
    }
}
