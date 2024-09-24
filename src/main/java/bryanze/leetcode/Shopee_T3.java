package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/09/14
 */
public class Shopee_T3 {
    public int wiggleMaxLength(int[] nums) {
        // write code here
        if (nums.length == 1 || (nums.length == 2 && nums[0] != nums[1])) {
            return nums.length;
        }

        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]){
                down = up + 1;

            }

        }

        return Math.max(up, down);

    }
}
