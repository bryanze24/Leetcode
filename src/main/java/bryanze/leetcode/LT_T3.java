package bryanze.leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/27
 */
public class LT_T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 调用 （补全）delArr 方法，输出结果
        int result = delArr(nums);
        System.out.println(result);

        scanner.close();
    }

    private static int delArr(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> use = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (seen.contains(num) && !use.contains(num)) {
                sum += num;
                use.add(num);
            } else {
                seen.add(num);
            }
        }
        if (sum == 0) {
            return -1;
        } else {
            return sum;
        }
    }
}
