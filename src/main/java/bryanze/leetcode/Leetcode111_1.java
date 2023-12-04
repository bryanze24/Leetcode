package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */

public class Leetcode111_1 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (rightDepth == 0) { //当右子树为null
            return leftDepth + 1; //返回左子树深度 + 1
        }

        if (leftDepth == 0) { //当左子树为null
            return rightDepth + 1; //返回右子树深度 + 1
        }

        return Integer.min(leftDepth, rightDepth) + 1;
    }


}
