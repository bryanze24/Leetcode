package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/08
 */
public class XHS_T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 对数组进行排序
        Arrays.sort(arr);

        // 构造最优排列方式：交替将较小和较大的数分配在中间
        int[] newArr = new int[n];
        int left = 0, right = n - 1;
        boolean insertLeft = true; // 用来交替分配
        for (int i = n - 1; i >= 0; i--) {
            if (insertLeft) {
                newArr[left++] = arr[i];
            } else {
                newArr[right--] = arr[i];
            }
            insertLeft = !insertLeft;
        }

        // 计算所有子区间的和
        long result = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += newArr[j];
                result += sum;
            }
        }

        // 输出结果
        System.out.println(result);
    }
}
