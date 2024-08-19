package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美有一个长度为的数组每次操作可以选择两个下标和将ai减去1,将aj加上1,
 * 小美想知道最少需要多少次操作，可以使数组极差最小。
 * 极差：数组中最大值和最小值的差值
 * <p>
 * 输入描述
 * 第一行输入一个整数n，代表数组的长度
 * 第二行输入n个整数，代表数组的元素
 * <p>
 * 输出描述
 * 表示最少需要操作的步数
 *
 * @author lizelin
 * @date 2024/08/19
 */
public class MT817_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }

        Arrays.sort(array);

        long op1 = 0, op2 = 0;
        int avg = (int) (sum / n);
        for (int i = 0; i < n; i++) {
            if (array[i] < avg) {
                op1 += avg - array[i];
            } else if (array[i] > avg) {
                op2 += array[i] - avg;
            }

        }

        System.out.println(Math.min(op1, op2));
    }
}
