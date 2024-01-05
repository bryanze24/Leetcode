package bryanze.leetcode;


import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author lizelin
 * @date 2024/01/05
 */
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode p1 = queue.poll();
            TreeNode q1 = queue.poll();
            if (p1 == null && q1 == null) {
                continue;
            }

            if ((p1 == null || q1 == null) || (p1.val != q1.val)) {
                return false;
            }

            queue.offer(p1.left);
            queue.offer(q1.left);

            queue.offer(p1.right);
            queue.offer(q1.right);
        }

        return true;
    }
}
