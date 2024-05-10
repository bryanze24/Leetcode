package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * @author lizelin
 * @date 2024/05/10
 */
public class Leetcode124 {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        ans = Math.max(ans, leftSum + rightSum + node.val);
        return Math.max(Math.max(leftSum, rightSum) + node.val, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(9),
                -10,
                new TreeNode(new TreeNode(15),
                        20,
                        new TreeNode(7)));
        System.out.println(new Leetcode124().maxPathSum(root));
    }
}
