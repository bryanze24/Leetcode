package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111_2 {

    /*
    层序遍历，遇到的第一个叶子节点所在层就是最小深度
     */

    public int minDepth(TreeNode root){

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if(poll.right == null && poll.left == null){
                    return depth;
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

        }
        return depth;
    }
}
