package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/27
 */
public class exe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数组长度
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 输入数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 输入目标值
        int target = scanner.nextInt();

        // 调用（补全）三数之和最近的函数
        int result = threeSumClosest(nums, target);

        // 输出结果
        System.out.printf("%d",result);

        scanner.close();
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int resultSum = 0;
        for(int i = 0; i < nums.length -2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    resultSum = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    resultSum = sum;
                    break;
                }
            }
        }
        return resultSum;
    }
}
