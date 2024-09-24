package bryanze.leetcode;

import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class JD97_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<Boolean> res = new ArrayList<>();
        while (a-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int m = sc.nextInt();
            int b = sc.nextInt();
            int[] obstacles = new int[n];
            for (int i = 0; i < n; i++) {
                obstacles[i] = sc.nextInt();
            }
            boolean flag = canComplete(n, l, m, b, obstacles);
            res.add(flag);
        }

        for (Boolean t : res) {
            if (t) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean canComplete(int n, int L, int m, int b, int[] obstacles) {
        int jump = 0;
        int position = 0;
        for (int i = 0; i <= n; ) {
            int nextPosition = (i == n) ? L : obstacles[i];
            while (position + b < nextPosition && jump < m) {
                position += b;
                jump++;
                i++;
            }

            if (position + b == nextPosition) {
                position += b;
                jump++;
                i++;
            }

            if (jump > m || position > L) {
                return false;
            }

        }
        return position == L && jump == m;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        List<String> list = new ArrayList<>();
//        while (T-- > 0) {
//            int n = sc.nextInt();
//            int l = sc.nextInt();
//            int m = sc.nextInt();
//            long b = sc.nextLong();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = sc.nextInt();
//            }
//
//
//            double niuniu = 0;
//            int i = 0;
//            for (; i < n; i++) {
//                if (niuniu > a[i] + 0.5) {
//                    continue;
//                }
//                if (m == 0 && niuniu < l) {
//                    list.add("No");
//                    return;
//                }
//                m--;
//                niuniu = a[i] + 0.5 + b;
//
//            }
//            if (m == 0 && i == n) {
//                list.add("Yes");
//            } else if (i == n && m != 0) {
//                list.add("No");
//            }
//
//        }
//
//        for (String string : list) {
//            System.out.println(string);
//        }
//    }
}
