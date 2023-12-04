package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.Arrays;

/**
 *给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 */

public class Leetcode105 {
    /*
    preOrder = {1,2,4,3,6,7}
    inOrder = {4,2,1,6,3,7}

    根 1
       pre             in
    左 2,4             4,2
    右 3,6,7           6,3,7

    根 2
    左 4

    根 3
    左 6
    右 7

     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        //创建根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootValue){
                //0 ~ i-1 左子树
                //i + 1 ~ inorder.length - 1 右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i); // [4,2]
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length); // [6,3,7]

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1); //[2,4]
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);//[3,6,7]

                root.left = buildTree(preLeft, inLeft); //2
                root.right = buildTree(preRight, inRight); //3
                break;
            }
        }
        return root;
    }
}
