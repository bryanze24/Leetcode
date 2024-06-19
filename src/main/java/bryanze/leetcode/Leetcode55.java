package bryanze.leetcode;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @author lizelin
 * @date 2024/06/19
 */
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= index - i) {
                index = i;
            } else {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
