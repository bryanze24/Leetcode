package bryanze.leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/25
 */
public class XL_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(dfs(str1, str2));
    }

    private static boolean dfs(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i);
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) {
                    return false;
                }
            } else {
                map2.put(c2, c1);
            }

        }
        return true;
    }
}
