package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/11
 */
public class WY_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long x = sc.nextLong();
        Long y = sc.nextLong();
        if (x.equals(y)) {
            System.out.println(x + 1);
            return;
        }
        System.out.println(getResult(x, y));
    }

    private static Long getResult(Long x, Long y) {
        return countColorSquares(x + 1, y + 1);
    }

    private static Long countColorSquares(Long x, Long y) {
        long total = 0L;
        Long gcd = great(x, y);
        total = x / gcd + y / gcd - 1;
        return total;
    }

    private static Long great(Long a, Long b) {
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Long x = sc.nextLong();
//        Long y = sc.nextLong();
//        System.out.println(dfs(x, y));
//    }
//
//    private static Long dfs(long x, long y) {
//        long count = 0L;
//        for (int i = 1; i < x + 1; i++) {
//            for (int j = 1; j < y + 1; j++) {
//                long point = 0L;
//                double k = 1.0 * y / x;
//                double x1 = i - 1, x2 = i;
//                double y1 = k * x1, y2 = k * x2;
//                if (j - 1 <= y2 && y2 <= j) {
//                    point++;
//                }
//                y1 = j - 1;
//                y2 = j;
//                if (i - 1 <= x1 && x1 <= i) {
//                    point++;
//                }
//                if (i - 1 <= x2 && x2 <= i) {
//                    point++;
//                }
//
//                if (point > 1) {
//                    count++;
//                }
//
//            }
//
//        }
//        return count;
//    }
}
