package bryanze.leetcode;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @author lizelin
 * @date 2023/12/06
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {

        int piles = 0;
        int[] top = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = piles;
            int poker = nums[i];

            while (left < right) {

                int mid = left + ((right - left) >> 1);

                if (top[mid] >= poker) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }

            if(left == piles){
                piles++;
            }

            top[left] = poker;

        }

        return piles;

    }
}
