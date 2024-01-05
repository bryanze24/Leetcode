package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来地树有着相同的节点值。
 * 如果有多种构造方法，请你返回任意一种。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * @author lizelin
 * @date 2024/01/05
 */
public class Leetcode1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return construct(list, 0, list.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode construct(List<Integer> list, int left, int right) {

        if(left > right) {
            return null;
        }

        int mid = left + ((right - left) >> 1);

        TreeNode node = new TreeNode(list.get(mid));
        node.left = construct(list, left, mid - 1);
        node.right = construct(list, mid + 1, right);

        return node;
    }
}
