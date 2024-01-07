package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;
import com.sun.org.apache.xerces.internal.xs.LSInputList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
 * 即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @author lizelin
 * @date 2024/01/07
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            list.add(ans);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }

        return result;
    }
}
