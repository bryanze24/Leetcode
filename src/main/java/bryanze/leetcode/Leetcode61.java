package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */

public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k== 0 || head == null || head.next == null){
            return head;
        }

        int n = 0;
        ListNode p = head;
        ListNode tail = null;
        while(p != null){
            n++;
            tail = p;
            p = p.next;
        }

        k = k % n;
        p = head;
        for (int i = 0; i < n - k - 1; i++) {
            p = p.next;

        }
        tail.next = head;
        head = p.next;
        p.next = null;

        return head;

    }

    public ListNode rotateRight1(ListNode head, int k){
        if(k == 0 || head == null || head.next == null){
            return head;
        }

        ListNode node = head;
        ListNode tail = null;
        int length = 0;
        while(node != null){
            length++;
            tail = node;
            node = node.next;
        }

        tail.next = head;

        for (int i = 0; i < length - (k % length); i++) {
            tail = tail.next;

        }
        head = tail.next;
        tail.next = null;
        return head;

    }
}
