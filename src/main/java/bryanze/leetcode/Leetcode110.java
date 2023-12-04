package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */

public class Leetcode110 {

    public boolean isBalanced(TreeNode root) {
        return getTreeHeight(root) >= 0;
    }

    private int getTreeHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = getTreeHeight(node.left);

        int rightHeight = getTreeHeight(node.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else {
           return Math.max(leftHeight, rightHeight) + 1;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(null, 1, new TreeNode(null, 2, new TreeNode(null, 3, null)));
        boolean balanced = new Leetcode110().isBalanced(root);
        System.out.println(balanced);
    }

}
