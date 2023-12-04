package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;
import javafx.scene.shape.VLineTo;

/**
 * 给定一个整数数组，它表示BST(即二叉搜索树)的 先序遍历,构造树并返回其根。
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val,
 * Node.right 的任何后代的值 严格大于 Node.val。
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * preorder 中的值 互不相同
 */

public class Leetcode1008 {

    //0ms
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int value) {
        TreeNode node = root;
        TreeNode parent = root;
        while (node != null) {
            parent = node;
            if (node.val > value) {
                node = node.left;
            } else if (node.val < value) {
                node = node.right;
            } else {
                break;
            }
        }

        if (parent.val < value) {
            parent.right = new TreeNode(value);
        } else {
            parent.left = new TreeNode(value);
        }
        return node;
    }

    int i = 0;

    private TreeNode insert(int[] preOder, int max) {
        if (i == preOder.length) {
            return null;
        }

        int value = preOder[i];
        if (value > max) {
            return null;
        }

        TreeNode node = new TreeNode(value);
        i++;
        node.left = insert(preOder, value);
        node.right = insert(preOder, max);

        return node;
    }

    public TreeNode bstFromPreorderByDivideAndConquer(int[] preorder) {
        return divideAndConquer(preorder, 0, preorder.length - 1);
    }

    private TreeNode divideAndConquer(int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[start]);

        int index = start + 1;
        while (index <= end) {
            if (preOrder[index] < preOrder[start]) {
                index++; //此时index就是左子树的终点
            }
        }
        root.left = divideAndConquer(preOrder, start + 1, index);
        root.right = divideAndConquer(preOrder, index + 1, end);

        return root;
    }
}
