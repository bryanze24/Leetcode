package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/24
 */
public class CodeFun1728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        String str = sc.next();
        char[] charArray = str.toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (charArray[i] == 'W' && array[i] != i + 1) {
                System.out.println(-1);
                return;
            }

            if (charArray[i] == 'W' && array[i] == i + 1) {
                continue;
            }

            while (array[i] != i + 1) {
                int temp = array[i];
                array[i] = array[temp - 1];
                array[temp - 1] = temp;
                count++;
            }
        }

        System.out.println(count);
    }
}
