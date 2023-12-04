package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author lizelin
 */

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = null, tail = null;
        ListNode head = new ListNode(-1);
        ListNode node = head;

        int s = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + s;
            s = sum / 10;

//            if (head == null) {
//                head = new ListNode(sum % 10);
//                tail = head;
//            } else {
//                tail.next = new ListNode(sum % 10);
//                tail = tail.next;
//            }

            node.next = new ListNode(sum % 10);
            node = node.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (s != 0) {
            node.next = new ListNode(s);
        }

        return head.next;
    }
}
