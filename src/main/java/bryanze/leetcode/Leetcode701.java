package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value,将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。输入数据保证新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。你可以返回任意有效的结果。
 */

public class Leetcode701 {

    //递归实现
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode insertIntoBST_1(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode parent = null;

        while (node != null) {
            parent = node;
            if (val < parent.val) {
                node = node.left;
            } else if (node.val < val) {
                node = node.right;
            } else {
                break;
            }
        }

        if (parent == null) {
            root = new TreeNode(val);
        } else if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }
}
