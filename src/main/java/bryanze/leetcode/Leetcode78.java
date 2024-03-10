package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author lizelin
 * @date 2024/02/27
 */
public class Leetcode78 {

    List<Integer> temp = new ArrayList<>();  // 存放符合条件的结果
    List<List<Integer>> ans = new ArrayList<>(); // 存放符合条件的结果集
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int index, int[] nums) {

        if (index == nums.length) { // 终止条件
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]); // 遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        dfs(index + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(index + 1, nums);

    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());

        for (int num : nums) {

            int size = list.size();

            for (int i = 0; i < size; i++) {
                List<Integer> res = new ArrayList<>(list.get(i));
                res.add(num);
                list.add(res);
            }

        }

        return list;
    }

    public List<List<Integer>> subsetsByBackTracking(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));

        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Leetcode78().subsetsByBackTracking(nums));
    }

}
