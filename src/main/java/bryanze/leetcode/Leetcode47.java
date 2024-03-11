package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author lizelin
 * @date 2024/03/11
 */
public class Leetcode47 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {

        int length = nums.length;
        used = new boolean[length];
        backTracking(nums, length);
        return ans;
    }

    private void backTracking(int[] nums, int length) {
        if (path.size() == length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        HashSet<Integer> set = new HashSet<>(); // 用来去重
        for (int i = 0; i < length; i++) {
            if (!used[i] && !set.contains(nums[i])) {
                set.add(nums[i]);
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums, length);
                path.removeLast();
                used[i] = false;

            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Leetcode47().permuteUnique(nums));
    }

}
