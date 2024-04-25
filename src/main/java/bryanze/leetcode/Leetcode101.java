package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;


/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */

public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        //left right 不能同时为null
        if (right == null || left == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(
                new TreeNode(3), 2, new TreeNode(4)
        ),
                1,
                new TreeNode(
                        new TreeNode(4), 2, new TreeNode(3)
                )
        );

        System.out.println(new Leetcode101().isSymmetric(root));
    }
}
