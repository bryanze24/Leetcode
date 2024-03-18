package bryanze.leetcode;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author lizelin
 * @date 2024/03/18
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {

        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        int longestBreak = 1;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentBreak = 1;
                int currentNum = num;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentBreak++;
                }

                longestBreak = Math.max(longestBreak, currentBreak);
            }
        }

        return longestBreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Leetcode128().longestConsecutive(nums));
    }

}
