package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */

public class Leetcode104_1 {

    //递归的方式
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

//        if (root.left == null && root.right == null) {
//            return 1;
//        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Integer.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );

        System.out.println(new Leetcode104_1().maxDepth(root));
    }
}
