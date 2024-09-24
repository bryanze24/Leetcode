package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/07
 */
public class MT97_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] a = new int[n];
        int odd = 0;
        int event = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                event += (num + 1);
            } else {
                odd += (num + 1);
            }
        }


//        for (int i = 0; i < n; i++) {
//            int num = a[i];
//            if (num % 2 == 0) {
//                event += (num + 1);
//            } else {
//                odd += (num + 1);
//            }
//        }

        System.out.println(Math.min(odd, event));

    }
}
