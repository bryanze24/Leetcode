package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 * @author lizelin
 * @date 2023/12/03
 */
public class Leetcode324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        if (nums.length % 2 != 0) {
            mid += 1;
        }
        int[] a = new int[mid];
        System.arraycopy(nums, 0, a, 0, mid);
        reverse(a);
        int[] b = new int[nums.length - mid];
        System.arraycopy(nums, mid, b, 0, nums.length - mid);
        reverse(b);

        for (int k = 0, i = 0, j = 0; k < nums.length; i++, j++, k = k + 1) {
            if (i < a.length) {
                nums[k] = a[i];
                k = k + 1;

            }

            if (k < nums.length) {
                nums[k] = b[j];
            }

        }

    }

    private void reverse(int[] array) {
        int middle;

        for (int i = 0; i < array.length / 2; i++) {
            middle = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = middle;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort1(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int n = nums.length;

        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        new Leetcode324().wiggleSort(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }

    }
}
