package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/13
 */
public class DD_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] power = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = sc.nextInt();
        }

        int res = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            if (power[right] > m){
                break;
            }
//            if (left > right){
//                System.out.println(res);
//                return;
//            }

            sum += power[right];
            if (sum > m) {
                sum -= power[left];
                left++;
            } else {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }

        System.out.println(res);

    }
}
