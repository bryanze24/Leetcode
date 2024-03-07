package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * @author lizelin
 * @date 2024/03/07
 */
public class Leetcode337 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] leftDp = dfs(node.left);
        int[] rightDp = dfs(node.right);

        int val1 = node.val + leftDp[0] + rightDp[0];
        int val2 = Math.max(leftDp[0], leftDp[1]) + Math.max(rightDp[0], rightDp[1]);

        //返回的一维数组dp[0]为不偷这个节点所获得的最高金额
        //返回的一维数组dp[1]为偷这个节点所获得的最高金额
        return new int[]{val2, val1};
    }

    public static void main(String[] args) {

    }

}
