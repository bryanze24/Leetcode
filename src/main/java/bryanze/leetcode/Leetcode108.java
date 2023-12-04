package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树得高度差的绝对值不超过 1 」的二叉树。
 */

public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode doSortedArrayToBST(int[] nums, int low, int high){
        if(low > high){
            return null;
        }

        //无论数组是奇数个还是偶数个，每次都选择中间位置靠左的位置为根节点
        int middle = (low + high) / 2;
        TreeNode root = new TreeNode(nums[middle]);

        root.left = doSortedArrayToBST(nums, low, middle - 1);
        root.right = doSortedArrayToBST(nums, middle + 1, high);

        return root;
    }

}
