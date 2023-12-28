package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author lizelin
 * @date 2023/12/28
 */
public class Leetcode783 {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        dfs(root, list);

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i - 1));

            if(result == 0) {
                break;
            }
        }

        return result;
    }

    /*
    中序遍历
     */
    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);

    }
}
