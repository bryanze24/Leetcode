package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/11/02
 */
public class MaxCircularSubarraySum {

    // 求非环形的最大子数组和（Kadane's Algorithm）
    public static int kadaneMax(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }

    // 求非环形的最小子数组和
    public static int kadaneMin(int[] nums) {
        int currentMin = nums[0];
        int globalMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            globalMin = Math.min(globalMin, currentMin);
        }
        return globalMin;
    }

    // 求环形数组的最大子数组和
    public static int maxCircularSum(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 非环形的最大子数组和
        int maxKadane = kadaneMax(nums);

        // 非环形的最小子数组和
        int minKadane = kadaneMin(nums);

        // 环形的最大子数组和 = 数组总和 - 非环形的最小子数组和
        int maxCircular = totalSum - minKadane;

        // 如果 maxCircular == 0，说明全是负数，直接返回 maxKadane
        if (maxCircular == 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, maxCircular);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 计算环形数组的最大子数组和
        int result = maxCircularSum(nums);
        System.out.println(result);
    }
}








