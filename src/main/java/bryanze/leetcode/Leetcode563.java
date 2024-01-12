package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，计算并返回 整个树 的坡度 。
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * @author lizelin
 * @date 2024/01/12
 */
public class Leetcode563 {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        ans += Math.abs(leftSum - rightSum);

        //返回 左子树和 + 右子树和 + 节点值 给上一个节点
        return leftSum + rightSum + root.val;
    }


    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(0);
            return;
        }

        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(3), 2, new TreeNode(5)),
                4,
                new TreeNode(null, 9, new TreeNode(7)));

        List<Integer> list = new ArrayList<>();
        new Leetcode563().dfs(root, list);

        for (Integer i : list) {
            System.out.println(i);
        }

    }

}
