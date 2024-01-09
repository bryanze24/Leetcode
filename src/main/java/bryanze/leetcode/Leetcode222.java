package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * @author lizelin
 * @date 2024/01/09
 */
public class Leetcode222 {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return count;
    }


    public int countNodes1(TreeNode root) {
        // 统计二叉树层数
        TreeNode node = root;
        int level = 0;

        while (node != null) {
            level++;
            node = node.left;
        }

        if (level <= 1) {
            // 层数小于等于1，直接返回节点个数
            return level;
        }

        // 二分查找节点个数，左闭右开[left, right)
        int left = 1 << (level - 1);    // 左边界为最少个数
        int right = 1 << level;         // 右边界为最多个数+1
        int ans = left;     // 最终结果
        int mid;

        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (check(root, mid, level)) {
                // 第mid个节点存在，说明最终结果一定大于等于mid，暂存mid并更新左边界以寻找编号更大的节点是否存在
                ans = mid;
                left = mid + 1;
            } else {
                // 第mid个节点不存在，说明结果小于mid，更新右边界查找编号更小的节点是否存在
                right = mid;
            }
        }

        return ans;
    }

    private boolean check(TreeNode root, int id, int level) {
        int bit = 1 << (level - 2);     // 初始化开始匹配的位

        while (bit > 0) {
            // 将节点编号的二进制看成从根节点到节点的路径编码，根据节点编号寻找节点
            if ((bit & id) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bit >>= 1;
        }

        return root != null;    // 节点不为空，说明编号为id的节点存在
    }

}
