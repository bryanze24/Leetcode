package bryanze.leetcode;


import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/22
 */
public class CodeFun1028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int k = sc.nextInt();
        int length = str.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<Character, Integer>> comparator = Map.Entry.comparingByKey();

        Collections.sort(list, comparator);

        char res = '0';
        int size = list.size();
        if (k > length) {
            res = list.get(size - 1).getKey();
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getValue();
            if (count >= k) {
                res = list.get(i).getKey();
                break;
            }
        }

        for (int i = 0; i< length; i++) {
            if (str.charAt(i) == res) {
                System.out.println(i);
                break;
            }
        }

    }
}
