package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * @author lizelin
 * @date 2024/01/10
 */
public class Leetcode404 {
    //广度优先，层序遍历
    public int sumOfLeftLeaves(TreeNode root) {

        int sum = 0;

        if (root == null || (root.left == null && root.right == null)) {
            return sum;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;

                if (leftNode != null) {
                    queue.offer(leftNode);
                    if (leftNode.left == null && leftNode.right == null) {
                        sum += leftNode.val;
                    }
                }

                if (rightNode != null) {
                    queue.offer(rightNode);
                }

            }

        }

        return sum;
    }

    //深度优先
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 检查左子节点是否为叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 如果是左叶子节点，累加其值
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        // 递归处理左右子树
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
