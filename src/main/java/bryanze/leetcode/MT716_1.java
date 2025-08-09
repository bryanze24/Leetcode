package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class MT716_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> res = new ArrayList<>();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            char[] chars = s.toCharArray();

            if (isSorted(chars)) {
                //System.out.println("YES");
                res.add("YES");
                continue;
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {
                if (chars[i] > chars[i + 1]) {
                    list.add(i);
                }
            }

            if (list.size() > 2) {
                res.add("NO");
                continue;
            }

            boolean cansort = false;
            int x = list.get(0);
            int y = list.get(list.size() - 1) + 1;
            swap(chars, x, y);
            if (isSorted(chars)) {
                cansort = true;
            }
            swap(chars, x, y);
            if (!cansort) {
                x = list.get(0) + 1;
                y = list.get(list.size() - 1);
                swap(chars, x, y);

            }
            if (cansort) {
                //System.out.println("YES");
                res.add("YES");
            } else {
                //System.out.println("NO");
                res.add("NO");
            }
        }
        for (String str : res) {
            System.out.println(str);
        }
    }

    public static boolean isSorted(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}
