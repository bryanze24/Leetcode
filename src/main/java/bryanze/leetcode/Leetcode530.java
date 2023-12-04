package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */

public class Leetcode530 {

    public int getMinimumDifference(TreeNode root) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                list.add(popped.val);
                node = popped.right;
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int j = i + 1;
            if (Math.abs(list.get(i) - list.get(j)) < answer) {
                answer = Math.abs(list.get(i) - list.get(j));
            }
            if (answer == 0) {
                break;
            }
        }
        return answer;
    }

    int prev = -1;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifferenceByRecursion(TreeNode root) {
        recursion(root);
        return result;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        recursion(root.left);

        if (prev != -1) {
            result = Math.min(result, Math.abs(root.val - prev));
        }

        prev = root.val;

        recursion(root.right);
    }
}
