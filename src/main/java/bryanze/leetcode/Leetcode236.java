package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先
 * 且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author lizelin
 * @date 2024/01/10
 */
public class Leetcode236 {
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }

        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }

            q = map.get(q.val);
        }

        return null;
    }

    private void dfs(TreeNode root) {

        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }

    }
}
