package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.*;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @author lizelin
 * @date 2024/01/07
 */
public class Leetcode113 {
    List<List<Integer>> list = new LinkedList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    LinkedList<Integer> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> valueNode = new LinkedList<>();

        queueNode.offer(root);
        valueNode.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int sum = valueNode.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    path(node);
                }
            } else {
                if (node.left != null) {
                    queueNode.offer(node.left);
                    valueNode.offer(sum);
                    map.put(node.left, node);
                }

                if (node.right != null) {
                    queueNode.offer(node.right);
                    valueNode.offer(sum);
                    map.put(node.right, node);
                }
            }
        }

        return list;
    }

    private void path(TreeNode node) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }

        Collections.reverse(temp);

        list.add(temp);
    }


    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return list;
    }

    private void dfs(TreeNode root, int sum) {

        if(root == null) {
            return;
        }

        sum = sum - root.val;
        ans.addLast(root.val);

        if(root.left == null && root.right == null && sum == 0) {
            list.add(new LinkedList<>(ans));
            ans.removeLast();
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        ans.removeLast();

    }
}
