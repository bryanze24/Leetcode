package bryanze.datastructure.binarytree;

import bryanze.datastructure.queue.TreeNode;

public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),2,null),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6))
        );
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    /**
     * 前序遍历
     * @param node 节点
     */
    static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + "\t"); //值

        preOrder(node.left); //左
        preOrder(node.right); //右
    }

    /**
     * 中序遍历
     * @param node 节点
     */
    static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left); //左
        System.out.print(node.val + "\t"); //值
        inOrder(node.right); //右
    }

    /**
     * 后序遍历
     * @param node 节点
     */
    static void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left); //左
        postOrder(node.right); //右
        System.out.print(node.val + "\t"); //值
    }
}
