package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。
 */

public class Leetcode174 {

    //正常的中序遍历
    public int findTargetNode(TreeNode root, int cnt) {
        List<Integer> list = new ArrayList<>();

        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode popped = stack.pop();
                list.add(popped.val);

                node = popped.right;
            }
        }
//        System.out.println(list);
        return list.get(list.size() - cnt);

    }

    //反中序遍历
    public int findTargetNodeByAntiMiddleOrder(TreeNode root, int cnt){

        int count = 0;
        TreeNode node = root;

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.right;

            } else {
                TreeNode popped = stack.pop();
                count++;
                if(count == cnt){
                    return popped.val;
                }
                node = popped.left;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(new TreeNode(1), 3, new TreeNode(5)), 7, new TreeNode(9));
        System.out.println(new Leetcode174().findTargetNodeByAntiMiddleOrder(root, 2));

    }

}
