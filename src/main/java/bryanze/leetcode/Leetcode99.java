package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Stack;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。
 *
 * @author lizelin
 * @date 2024/01/02
 */
public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }

            pred = root;
            root = root.right;

        }

        swap(x, y);

    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    TreeNode first = null, second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree1(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (root.val < prev.val) {

            if(first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;
        traverse(root.right);

    }

}
