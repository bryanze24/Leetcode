package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MT716 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) > s.charAt(i + 1)) {
                    list.add(new int[]{i, i + 1});
                }
            }
            if (list.isEmpty() || list.size() == 1) {
                System.out.println("YES");
            } else if (list.size() == 2) {
                int[] fir = list.get(0);
                int[] sec = list.get(1);
                if ((fir[0] == sec[0] && fir[1] == sec[1] - 1) || (fir[0] == sec[0] - 1 && fir
                        [1] == sec[1])) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
