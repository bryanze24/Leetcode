package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;
import org.w3c.dom.ls.LSException;

import java.util.LinkedList;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 */

public class LeetcodeLCR24 {

    public ListNode reverseList(ListNode head) {

        ListNode n1 = null;
        ListNode p = head;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;

    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new LeetcodeLCR24().reverseList(listNode));
    }
}
