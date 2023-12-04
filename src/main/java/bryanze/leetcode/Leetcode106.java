package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Arrays;

/**
 *给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 */

public class Leetcode106 {

    /*
    inOrder = {4,2,1,6,3,7}
    postOrder = {4,2,6,7,3,1}

    根 1
        in            post
    左 4，2            4,2
    右 6,3,7           6,7,3

     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder.length == 0 || inorder.length == 0){
            return null;
        }

        //根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        //切分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if(rootValue == inorder[i]){
                int[] inLeft = Arrays.copyOfRange(inorder,0, i);
                int[] inRight = Arrays.copyOfRange(inorder,i + 1, inorder.length);

                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);

                root.left = buildTree(inLeft, postLeft);
                root.right = buildTree(inRight, postRight);
                break;
            }
        }
        return root;
    }

}
