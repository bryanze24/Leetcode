package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树
 *
 * @author lizelin
 * @date 2024/01/04
 */
public class Leetcode1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
