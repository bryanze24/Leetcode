package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * @author lizelin
 * @date 2024/02/27
 */
public class Leetcode90 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return ans;
    }


    public List<List<Integer>> subsetsWithDup1(int[] nums) {

        Arrays.sort(nums);
        used = new boolean[nums.length];
        helper(0, nums);
        return ans;
    }

    private void helper(int start, int[] nums) {
        ans.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            helper(i + 1, nums);
            path.removeLast();
            used[i] = false;

        }
    }

    private void dfs(int index, int[] nums) {
        ans.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }

            path.add(nums[i]);
            dfs(i + 1, nums);
            path.removeLast();

        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums, 0);
        return ans;
    }

    private void backTracking(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));

        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> list = new Leetcode90().subsetsWithDup2(nums);
        for (List<Integer> integerList : list) {
            System.out.println(integerList);
        }
    }

}
