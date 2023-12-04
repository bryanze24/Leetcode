package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */

public class Leetcode268 {
    //排序
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]){
                return i;
            }
        }

        return nums.length;
    }

    //位运算
    public int missingNumber1(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        for (int i = 0; i <= nums.length; i++) {
            result ^= i;
        }

        return result;
    }

    //数学
    public int missingNumber2(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int total = 0;
        for (int i = 0; i <= nums.length; i++) {
            total += i;
        }

        return total - sum;
    }

}
