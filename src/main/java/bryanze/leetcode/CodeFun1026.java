package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/22
 */
public class CodeFun1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String c = sc.next();
        //int[] array = new int[124];

//        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int length = c.length();
        for (int i = 0; i < length; i += b) {

            for (int j = i; j < i + b && j < length; j++) {
                char ch = c.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    int ans = o2.getValue().compareTo(o1.getValue());
                    if (ans == 0) {
                        return o2.getKey().compareTo(o1.getKey());
                    }
                    return ans;
                }
            };

            Collections.sort(list, comparator);

            for (int k = 0; k < a; k++) {
                System.out.print(list.get(k).getKey());
            }
        }

    }
}
