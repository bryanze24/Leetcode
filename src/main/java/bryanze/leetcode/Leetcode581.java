package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * @author lizelin
 * @date 2023/12/19
 */
public class Leetcode581 {
    public int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int length = nums.length;
        int max = nums[0];
        int min = nums[length - 1];
        int begin = 0, end = -1;

        for (int i = 0; i < length; i++) {

            if (nums[i] < max){
                end = i;
            }else{
                max = nums[i];
            }

            if(nums[length - i - 1] > min) {
                begin = length - i - 1;
            }else{
                min = nums[length - i - 1];
            }

        }

        return end - begin + 1;
    }


    /*
    从左往右，一开始max是第一个数。如果数组符合要求，那么遍历的每一个数都只会相等或者越来越大，
    也就是我们只会不停地更新max的值。但是，一旦碰到一个小于max的数，就说明这个数字的位置不对，
    这个数字一定是在我们最终要重新sort的subarray里的，并且是右边界（因为我们在不断向右探索）。
    从右往左同理，只是大小关系反一反，我们能找到需要重新sort的subarray的左边界。
     */
    public int findUnsortedSubarray1(int[] nums) {
        int length = nums.length;
        int min = nums[length - 1];
        int max = nums[0];
        int begin = 0, end = -1;

        for (int i = 0; i < length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }else {
                end = i;
            }

            if(nums[length - 1 - i] < min) {
                min = nums[length - 1 - i];
            }else {
                begin = length - 1 - i;

            }
        }

        return end - begin + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        if(isSorted(nums)){
            return 0;
        }

        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);

        Arrays.sort(numsCopy);

        int left = 0;
        while(nums[left] == numsCopy[left]){
            left++;
        }

        int right = nums.length - 1;
        while(nums[right] == numsCopy[right]) {
            right--;
        }

        return right - left + 1;

    }

    private boolean isSorted(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Leetcode581().findUnsortedSubarray2(nums));
    }
}
