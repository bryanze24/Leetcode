package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;

/**
 * 给定二叉搜索树的根结点 root，返回 值位于范围 [low, high] 之间的所有结点的值的和。
 */

public class Leetcode938 {

    //中旬遍历的方式 4ms
    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();

        int sum = 0;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                if (popped.val > high) {
                    break;
                }

                if (popped.val >= low) {
                    sum += popped.val;
                }
                node = popped.right;
            }
        }

        return sum;
    }

    //递归，深度优先 0ms
    public int rangeSumBSTByRecursion(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBSTByRecursion(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSumBSTByRecursion(root.right, low, high);
        }

        return root.val + rangeSumBSTByRecursion(root.left, low, high) + rangeSumBSTByRecursion(root.right, low, high);
    }

}
