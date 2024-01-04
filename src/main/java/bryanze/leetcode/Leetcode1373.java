package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * 二叉搜索树的定义如下：
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 * @author lizelin
 * @date 2024/01/04
 */
public class Leetcode1373 {
    private int ans;
    private final int inf = 1 << 30;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    int max;
    public int maxSumBST1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        max = 0;
        helper(root);

        return max;
    }

    private int[] helper(TreeNode root) {
        // [0] - sum, [1] - valid BST or not, [2] - min, [3] - max
        if(root == null) {
            return null;
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[4];
        res[0] = root.val;
        res[1] = 1;
        res[2] = root.val;
        res[3] = root.val;

        if(left != null) {
            if(left[1] == 1 && root.val > left[3]){
                res[0] += left[0];
                res[2] = left[2];
            }else {
                res[1] = 0;
            }
        }

        if(right != null) {
            if(right[1] == 1 && root.val < right[2]) {
                res[0] += right[0];
                res[3] = right[3];
            }else {
                res[1] = 0;
            }
        }

        if(res[1] == 1) {
            max = Math.max(max, res[0]);
        }

        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, inf, -inf, 0};
        }

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int v = root.val;

        if (l[0] == 1 && r[0] == 1 && l[2] < v && r[1] > v) {
            int s = v + l[3] +r[3];
            ans = Math.max(ans, s);
            return new int[]{1, Math.min(l[1], v), Math.max(r[2], v), s};
        }

        return new int[]{0, -inf, inf, 0};
    }
}
