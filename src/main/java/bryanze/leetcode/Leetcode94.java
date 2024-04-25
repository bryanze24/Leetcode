package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 (左，值，右)。
 */

public class Leetcode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; //代表当前节点
        TreeNode pop = null; //最近一次弹栈的元素
        List<Integer> result = new ArrayList<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {

                stack.push(curr); // 压入栈，记录回来时的路线
                //待处理左子树
                curr = curr.left;

            } else {
                TreeNode peek = stack.peek(); //栈顶元素

                // 没有右子树
                if (peek.right == null) {
                    result.add(peek.val);
                    pop = stack.pop();

                    // 右子树处理完成
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    // 待处理右子树
                } else {
                    result.add(peek.val);
                    curr = peek.right;
                }
            }

        }
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
                root = node.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(
                new TreeNode(2), 2, null
        ),
                1,
                new TreeNode(
                        new TreeNode(2), 2, null
                )
        );
        List<Integer> list = new Leetcode94().inorderTraversal1(root);
        System.out.println(list);
    }
}
