package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在 唯一的答案 。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * @author lizelin
 * @date 2023/12/29
 */
public class Leetcode669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    public TreeNode trimBST1(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if (root == null) {
            return null;
        }

        TreeNode nodeByLeft = root;
        while (nodeByLeft.left != null) {

            if (nodeByLeft.left.val < low) {
                nodeByLeft.left = nodeByLeft.left.right;

            } else {
                nodeByLeft = nodeByLeft.left;
            }

        }

        TreeNode nodeByRight = root;
        while (nodeByRight.right != null) {

            if (nodeByRight.right.val > high) {
                nodeByRight.right = nodeByRight.right.left;
            } else {
                nodeByRight = nodeByRight.right;
            }

        }

        return root;
    }

}
