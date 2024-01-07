package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 *
 * @author lizelin
 * @date 2024/01/07
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> valueNode = new LinkedList<>();

        queueNode.offer(root);
        valueNode.offer(root.val);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            Integer value = valueNode.poll();

            if (node.left == null && node.right == null) {
                if (value == targetSum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                queueNode.offer(node.left);
                valueNode.offer(node.left.val + value);
            }

            if (node.right != null) {
                queueNode.offer(node.right);
                valueNode.offer(node.right.val + value);
            }

        }

        return false;
    }
}
