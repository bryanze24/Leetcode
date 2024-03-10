package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 * @author lizelin
 * @date 2024/03/10
 */
public class Leetcode491 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking1(nums, 0);
        return ans;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                continue;
            }

            path.add(nums[i]);
            set.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }

    }


    private void backTracking1(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if ((path.isEmpty() || nums[i] >= path.get(path.size() - 1)) && !set.contains(nums[i])) {
                path.add(nums[i]);
                set.add(nums[i]);
                backTracking1(nums, i + 1);
                path.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        System.out.println(new Leetcode491().findSubsequences(nums));
    }

}
