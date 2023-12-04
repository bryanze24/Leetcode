package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

public class Leetcode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node.val < p.val && node.val < q.val || node.val > p.val && node.val > q.val) {
            if (node.val < p.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }
}
