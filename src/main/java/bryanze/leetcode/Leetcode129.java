package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * @author lizelin
 * @date 2024/01/09
 */
public class Leetcode129 {

    //广度优先搜索
    public int sumNumbers(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> tQueue = new LinkedList<>();
        Queue<Integer> vQueue = new LinkedList<>();

        tQueue.offer(root);
        vQueue.offer(root.val);

        while (!tQueue.isEmpty()) {
            int size = tQueue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = tQueue.poll();
                Integer value = vQueue.poll();

                if (node.left == null && node.right == null) {
                    sum += value;

                } else {

                    if (node.left != null) {
                        tQueue.offer(node.left);
                        vQueue.offer(value * 10 + node.left.val);
                    }

                    if (node.right != null) {
                        tQueue.offer(node.right);
                        vQueue.offer(value * 10 + node.right.val);
                    }

                }

            }
        }

        return sum;
    }

    //深度优先搜索
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }

    }
}
