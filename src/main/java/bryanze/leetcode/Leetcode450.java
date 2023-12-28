package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Currency;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * @author lizelin
 * @date 2023/12/28
 */
public class Leetcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode node = root;
        TreeNode nodeParent = null;
        while (node != null && node.val != key) {
            nodeParent = node;
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }

        }

        if (node == null) {
            return root;
        }

        if (node.left == null && node.right == null) {
            node = null;
        } else if (node.right == null) {
            node = node.left;
        } else if (node.left == null) {
            node = node.right;
        } else {
            TreeNode successor = node.right;
            TreeNode successorParent = node;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            if (successorParent.val == node.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }

            successor.right = node.right;
            successor.left = node.left;
            node = successor;
//            node.val = successor.val;
//            successor = null;
        }

        if (nodeParent == null) {
            return node;
        } else {

            if (nodeParent.left != null && nodeParent.left.val == key) {
                nodeParent.left = node;
            } else {
                nodeParent.right = node;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(2), 3, new TreeNode(4)),
                5,
                new TreeNode(new TreeNode(), 6, new TreeNode(7)));

        new Leetcode450().deleteNode(node, 3);


//        TreeNode node1 = new TreeNode(new TreeNode(1), 2, new TreeNode(3));
//        TreeNode node2 = node1.right;
//        node1.right.val = 4;
//        node2 = null;
//
//        System.out.println(node1.right);
//        System.out.println(node2);

    }

}
