package bryanze.leetcode;

/**
 * 给定一个非负整数数组 nums，nums中 一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * @author lizelin
 * @date 2023/12/05
 */
public class Leetcode922 {
    public int[] sortArrayByParityII(int[] nums) {

        int odd = 1;
        int even = nums.length - 2;

        while (odd < nums.length && even >= 0) {

            while (odd < nums.length && nums[odd] % 2 == 1) {
                odd += 2;
            }

            while (even >= 0 && nums[even] % 2 == 0) {
                even -= 2;
            }

            if (even < 0) {
                break;
            }

            if (odd >= nums.length) {
                break;
            }

            swap(nums, odd, even);

//            System.out.printf("[%d,%d]", odd, even);
//            System.out.println();

        }

        return nums;
    }

    private void swap(int[] nums, int odd, int even) {
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }


    public int[] sortArrayByParityII1(int[] nums) {
        int n = nums.length;
        int odd = 1, even = 0;

        while (even < n && odd < n) {

            while (even < n && (nums[even] & 1) == 0) {
                even += 2;
            }

            while (odd < n && (nums[odd] & 1) == 1) {
                odd += 2;
            }

            if (even < n && odd < n) {
                swap(nums, even, odd);
            }

        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 2};
        int[] array = new Leetcode922().sortArrayByParityII1(nums);
        for (int num : array) {
            System.out.print(num + "\t");
        }
    }
}
