package bryanze.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/22
 */
public class PDD_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> list = new ArrayList<>();
        while (T-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();
            boolean flag = false;
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                set.add(val);
                if (val == 0) {
                    flag = true;
                }
                if (val > maxVal) {
                    maxVal = val;
                }

                if (val < minVal) {
                    minVal = val;
                }

            }
            boolean valid = true;
            for (int j = minVal; j <= maxVal; j++) {
                if (!set.contains(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid || (flag && set.size() == n)) {
                list.add("yes");
            } else {
                list.add("no");
            }


        }
        for (String temp : list) {
            System.out.println(temp);

        }

    }
}
