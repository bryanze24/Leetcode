package bryanze.leetcode;


import bryanze.datastructure.queue.LinkedListQueue;
import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root,返回其节点值的 层序遍历.
 * (即逐层地，从左到右访问所有节点).
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; //当前层的节点数

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int c2 = 0;
            for (int i = 0; i < c1; i++) {

                TreeNode n = queue.poll();
                level.add(n.val);

                if(n.left != null){
                    queue.offer(n.left);
                    c2++;
                }

                if(n.right != null){
                    queue.offer(n.right);
                    c2++;
                }
            }

            result.add(level);
            c1 = c2;
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; //当前层的节点数

        while(!queue.isEmpty()){
            int c2 = 0;
            for (int i = 0; i < c1; i++) {

                TreeNode n = queue.poll();
                System.out.print(n + " ");

                if(n.left != null){
                    queue.offer(n.left);
                    c2++;
                }

                if(n.right != null){
                    queue.offer(n.right);
                    c2++;
                }
            }

            System.out.println();
            c1 = c2;
        }
    }
}
