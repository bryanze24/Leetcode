package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * @author lizelin
 * @date 2024/04/12
 */
public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1 && nums[0] != 1) {
            return 1;
        }

        int length = nums.length;
        Arrays.sort(nums);
        if (nums[length - 1] <= 0) {
            return 1;
        }

        int index = 1;
        for (int i = 0; i < length; i++) {
            while (nums[i] <= 0) {
                i++;
            }

            while (i + 1 <= length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

            if (nums[i] == index) {
                index++;
            } else {
                return index;
            }
        }

        return nums[length - 1] + 1;
    }

    public int firstMissingPositiveOn(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println(new Leetcode41().firstMissingPositiveOn(nums));
    }
}
