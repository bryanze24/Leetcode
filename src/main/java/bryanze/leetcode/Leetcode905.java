package bryanze.leetcode;

/**
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一个数组作为答案。
 * @author lizelin
 * @date 2023/12/05
 */
public class Leetcode905 {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int odd = 0; //奇数指针
        int even = 0; //偶数指针

        while (even < nums.length) {

            while (even < nums.length && nums[even] % 2 != 0) {
                even++;
            }

            while (odd < nums.length && nums[odd] % 2 == 0) {
                odd++;
            }

            if (even == nums.length) {
                break;
            }

            if (odd == nums.length) {
                break;
            }

            if (even > odd) {
                swap(nums, odd, even);
                odd++;
                even++;
            } else {
                even = odd + 1;
            }

        }

        return nums;
    }

    private void swap(int[] nums, int odd, int even) {
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }


    public int[] sortArrayByParity1(int[] nums) {
        int[] result = new int[nums.length];

        int odd = nums.length - 1;
        int even = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                result[odd] = num;
                odd--;
            } else {
                result[even] = num;
                even++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        int[] array = new Leetcode905().sortArrayByParity(nums);

        for (int num : array) {
            System.out.print(num + "\t");
        }
    }
}
