package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode104_3 {

    /*
    思路：
        1. 使用层序遍历，层数即最大深度
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int depth = 0;

//        int c1 = 1; //记录每层有几个元素

        while (!queue.isEmpty()) {
//            int c2 = 0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
//                    c2++;
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
//                    c2++;
                }
            }
//            c1 = c2;
            depth++;

        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, new TreeNode(5)),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );
        System.out.println(new Leetcode104_3().maxDepth(root));
    }
}
