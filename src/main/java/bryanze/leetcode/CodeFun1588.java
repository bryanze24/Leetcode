package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/10
 */
public class CodeFun1588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int t = sc.nextInt();

        int s = 0;
        for (int i = 1; i < n; i++) {
            if (array[i - 1] < array[i]) {
                s = i;
                break;
            }
        }

        int start = -1, end = -1;
        for (int i = 0; i < n; i++) {
            int index = (s + i) % n;

            if (array[index] == t) {
                if (start == -1) {
                    start = index;
                }
                end = index;
            }
        }

        System.out.println(start + " " + end);
    }
}
