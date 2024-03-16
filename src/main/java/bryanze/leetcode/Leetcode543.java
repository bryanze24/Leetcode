package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * @author lizelin
 * @date 2024/03/16
 */
public class Leetcode543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ll = dfs(node.left);
        int rl = dfs(node.right);
        ans = Math.max(ans, ll + rl);
        return Math.max(ll, rl) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                        new TreeNode(new TreeNode(4),
                2,
                        new TreeNode(5)),
                1,
                new TreeNode(3));

        System.out.println(new Leetcode543().diameterOfBinaryTree(root));
    }

}
