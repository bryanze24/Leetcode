package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.HashMap;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author lizelin
 * @date 2024/01/16
 */
public class Leetcode437 {
    public int pathSum(TreeNode root, int targetSum) {
        //key是前缀和，value是大小为key的前缀和出现的次数
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();

        //前缀和为0的一条路径
        prefixSumCount.put(0L, 1);

        //前缀和的递归回溯
        return dfs(root, prefixSumCount, targetSum, 0L);
    }

    /**
     * 前缀和的递归回溯
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，
     * 回到本层时去除，保证其不影响其他分支的结果
     *
     * @param root           节点
     * @param prefixSumCount 前缀和Map
     * @param targetSum      目标值
     * @param currSum        当前路径和
     * @return 满足题意的解
     */
    private int dfs(TreeNode root, HashMap<Long, Integer> prefixSumCount, int targetSum, long currSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        //当前路径和
        currSum += root.val;

        //核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,
        // 而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        //下一层
        res += dfs(root.left, prefixSumCount, targetSum, currSum);
        res += dfs(root.right, prefixSumCount, targetSum, currSum);
        //核心代码

        /*
           由于我们只能统计往下的路径，但是树的遍历会同时搜索两个方向的子树。
           因此我们应当在搜索完以某个节点为根的左右子树之后，应当回溯地将路径总和从哈希表中删除，
           防止统计到跨越两个方向的路径。
         */
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return res;
    }
}
