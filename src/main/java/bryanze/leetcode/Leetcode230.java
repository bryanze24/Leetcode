package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;

public class Leetcode230 {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                count++;
                if(count == k){
                    return popped.val;
                }
                node = popped.right;
            }
        }
        return 0;
    }
}
