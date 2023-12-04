package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;

/**
 * 给你一个二叉树的根节点 root,判断其是否是一个有效的二叉搜索树。
 * 有效二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */

public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                if(prev >= popped.val){
                    return false;
                }
                prev = popped.val;
                node = popped.right;
            }
        }
        return true;
    }

    public boolean isValidBSTByRecursion(TreeNode root){
        return doValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }

        return doValid(node.left, min, node.val) && doValid(node.right, node.val, max);

    }
}
