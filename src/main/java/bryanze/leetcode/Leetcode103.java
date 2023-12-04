package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }


//        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int c1 = 1; //当前层的节点数

        boolean odd = true; //奇数层

        while(!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>(); //保存每一层结果
            int c2 = 0;
            for (int i = 0; i < c1; i++) {

                TreeNode n = queue.poll();
                if(odd){
                    level.offerLast(n.val);
                }else{
                    level.offerFirst(n.val);
                }

                if(n.left != null){
                    queue.offer(n.left);
                    c2++;
                }

                if(n.right != null){
                    queue.offer(n.right);
                    c2++;
                }
            }

            odd = !odd;
            result.add(level);
            c1 = c2;
        }

        return result;
    }
}
