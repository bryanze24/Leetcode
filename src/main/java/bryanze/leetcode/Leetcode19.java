package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
public class Leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        recursion(s, n);
        return s.next;
    }


    private  int recursion(ListNode p, int n){
        if(p == null){
            return 0;
        }
        int nth = recursion(p.next,n);
//        System.out.println(p.val + " " + nth);
        if(nth == n){
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }

        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }


    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        int length = getLength(head);
        ListNode listNode = sentinel;
        for (int i = 1; i < length - n + 1; i++) {
            listNode = listNode.next;
        }
        listNode.next = listNode.next.next;
        return sentinel.next;
    }

    private int getLength(ListNode listNode){
        int length = 0;
        while (listNode != null){
            length++;
            listNode = listNode.next;
        }
        return length;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(listNode);
        System.out.println(new Leetcode19().removeNthFromEnd3(listNode, 5));
    }
}
