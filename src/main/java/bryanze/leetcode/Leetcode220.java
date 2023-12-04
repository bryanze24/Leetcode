package bryanze.leetcode;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 找出满足下述条件的下标对 (i, j)：
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 true ；否则，返回 false 。
 * @author lizelin
 * @date 2023/12/01
 */
public class Leetcode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        int length = nums.length;

        for (int i = 0; i < length; i++) {

            Long t = set.ceiling((long) nums[i] - (long) valueDiff);

            if (t != null && t <= (long) nums[i] + (long) valueDiff) {
                return true;
            }

            set.add((long) nums[i]);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        System.out.println(new Leetcode220().containsNearbyAlmostDuplicate(nums, 1, 2));
    }
}
