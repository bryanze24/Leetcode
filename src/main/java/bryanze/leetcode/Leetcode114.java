package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author lizelin
 * @date 2024/01/05
 */
public class Leetcode114 {
    public void flatten(TreeNode root) {

        while (root != null) {
            if (root.left != null) {

                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
            }
            // 考虑下一个节点
            root = root.right;

        }
    }

    public void flatten1(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(pre != null) {
                pre.right = node;
                pre.left = null;
            }

            if (node.right!= null) {
                stack.push(node.right);
            }

            if (node.left!= null) {
                stack.push(node.left);
            }

            pre = node;
        }
    }
}
