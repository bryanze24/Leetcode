package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */

public class Leetcode653 {

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (hashSet.contains(k - node.val)) {
                return true;
            }
            hashSet.add(node.val);

            if (node.left != null) {
                list.offer(node.left);
            }

            if (node.right != null) {
                list.offer(node.right);
            }
        }
        return false;
    }


    List<Integer> list = new ArrayList<Integer>();

    public boolean findTargetByRecursion(TreeNode root, int k) {
        recursion(root);
        int slow = 0;
        int fast = list.size() - 1;
        while (slow != fast) {
            if(list.get(slow) + list.get(fast) > k){
                fast--;
            }else if(list.get(slow) + list.get(fast) < k){
                slow++;
            }else {
                return true;
            }

        }
        return false;
    }

    private void recursion(TreeNode node) {
        if (node == null) {
            return;
        }

        recursion(node.left);

        list.add(node.val);

        recursion(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(1), 2, new TreeNode(3));
        TreeNode node = new TreeNode(1);
        boolean target = new Leetcode653().findTargetByRecursion(node, 2);
        System.out.println(target);
    }
}
