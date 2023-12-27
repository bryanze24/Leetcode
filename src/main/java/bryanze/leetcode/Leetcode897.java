package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * @author lizelin
 * @date 2023/12/27
 */
public class Leetcode897 {
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root);
            root = root.right;

        }

        TreeNode result = new TreeNode(-1);
        TreeNode p = result;

        for (TreeNode node : list) {
            p.right = node;
            node.left = null;
            p = p.right;
        }

        return result.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(1), 5, new TreeNode(7));
        TreeNode node = new Leetcode897().increasingBST(root);

        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

}
