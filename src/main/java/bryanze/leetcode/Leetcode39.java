package bryanze.leetcode;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个
 */

public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //定义一个返回结果的集合
        List<List<Integer>> res = new ArrayList<>();
        //定义一个表示数组的长度的变量
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        //定义一个存储树路径上的节点值
        Deque<Integer> path = new ArrayDeque<>();
        //深度搜索
        dfs1(candidates, len, 0, target, path, res);
        //返回结果
        return res;
    }

    public void dfs1(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        //如果此时目标元素经过几次深度递归，减值，
        //就说明，数组中不存在能相加等于目标数组的元素集合
        if (target < 0) {
            return;
        }

        //如果刚好减到0，说明此时路径上的元素，相加等于目标元素。
        //此时路径上的元素就符合条件，将他们加入返回结果中，并退出此次递归
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //遍历元素，这里的i 必须要跟递归层数保持一致，要不要剪枝时，会照成重复元素
        for (int i = begin; i < len; i++) {
            //将路径上的元素加入结果集合中
            path.add(candidates[i]);
            //在进行一轮剪枝到根节点的时候，下一轮的搜索的启点就不能包括上一次搜索的下标了
            //此时在拼接重复元素的时候，起点只能是大于等于当前元素的下标。
            dfs1(candidates, len, i, target - candidates[i], path, res);
            //将元素进行删除，也叫剪枝，
            //这里必须从队列的尾部开始删除，这样才能达到从底层逐层删除
            path.removeLast();
        }
    }


    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        System.out.println(new Leetcode39().combinationSum1(nums, 7));
    }
}
