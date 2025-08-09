package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/11/21
 */
public class aaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = 0;
        for (int bit = 30; bit >= 0; bit--) {
            int mask = 1 << bit;
            int count = 0;
            for (int num : arr) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count >= k) {
                result |= mask;
            }
        }
        System.out.println(result);
    }
}
