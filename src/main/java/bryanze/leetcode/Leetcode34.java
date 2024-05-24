package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @author lizelin
 * @date 2024/05/24
 */
public class Leetcode34 {

    //方法一
    public int[] searchRange(int[] nums, int target) {

        int start = binarySearch(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        int end = binarySearch(nums, target + 1) - 1;

        return new int[]{start, end};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    //方法二
    public int[] searchRange2(int[] nums, int target) {
        int left = 0, right = nums.length;
        int first = -1, last = -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                first = mid;
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return new int[] {first, last};
    }

    public static void main(String[] args) {

//        int[] nums = new int[] {5,7,7,8,8,10};
        int[] nums = {1};
        System.out.println(Arrays.toString(new Leetcode34().searchRange2(nums, 1)));
    }
}
