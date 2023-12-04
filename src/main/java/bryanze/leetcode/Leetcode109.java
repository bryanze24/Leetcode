package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;
import bryanze.datastructure.queue.TreeNode;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树得高度差不超过 1。
 */

public class Leetcode109 {

    public TreeNode sortedListToBST(ListNode head) {

        return doSortedListToBST(head, null);
    }

    private TreeNode doSortedListToBST(ListNode left, ListNode right){

        if(left == right){
            return null;
        }

        ListNode middle = getMiddle(left, right);
        TreeNode root = new TreeNode(middle.val);
        root.left = doSortedListToBST(left, middle);
        root.right = doSortedListToBST(middle.next, right);

        return root;
    }

    private ListNode getMiddle(ListNode left, ListNode right){

        ListNode p1 = left;
        ListNode p2 = left;

        while(p2 != right && p2.next != right){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
