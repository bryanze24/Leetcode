package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */

public class Leetcode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (val < node.val) {
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }
}
