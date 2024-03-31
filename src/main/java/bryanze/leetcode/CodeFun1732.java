package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/03/30
 */
public class CodeFun1732 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean flag = false;
        for (int i = 1; i <= m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int desc = sc.nextInt();
            for (int j = start - 1; j < end; j++) {
                nums[j] -= desc;
                if (nums[j] <= 0) {
                    flag = true;
                    System.out.println(i);
                    break;
                }
            }

            if (flag) {
                break;
            }

        }
    }
}
