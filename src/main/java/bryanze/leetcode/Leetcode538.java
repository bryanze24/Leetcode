package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Stack;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * @author lizelin
 * @date 2023/12/27
 */
public class Leetcode538 {

    int sum = 0;

    /*
    反中序遍历
     */
    public TreeNode convertBST(TreeNode root) {

        if(root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;

        convertBST(root.left);
        return root;
    }

    /*
    中序遍历
     */
    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        dfs(root, stack);

        TreeNode popped = stack.pop();

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.val += popped.val;
            popped = node;
        }

        return root;
    }

    private void dfs(TreeNode node, Stack<TreeNode> stack) {

        if(node == null) {
            return;
        }

        dfs(node.left, stack);
        stack.push(node);
        dfs(node.right, stack);

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(null, 0, new TreeNode(1));
        TreeNode root = new Leetcode538().convertBST(node);
    }

}
