package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * @author lizelin
 * @date 2024/02/28
 */
public class Leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        int length = candidates.length;
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, 0, length, target, path, ans);
        return ans;
    }

    private void dfs(int[] candidates, int start, int end, int target,
                     Deque<Integer> path, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < end; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > start && candidates[i - 1] ==  candidates[i]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(candidates, i + 1, end, target- candidates[i], path, ans);
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,2,5,6,7,10};
        List<List<Integer>> list = new Leetcode40().combinationSum2(nums, 8);
        for (List<Integer> ans : list) {
            System.out.println(ans);
        }
    }
}
