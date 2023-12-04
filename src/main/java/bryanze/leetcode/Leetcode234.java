package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你一个单链表的头节点 head，请你判断该链表是否为回文链表。
 * 如果是，返回 true；否则，返回 false。
 */
public class Leetcode234 {
    /*
    1.寻找中间点
    2.中间点后半个链表反转
    3.反转后链表与原链表逐一比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode node = middle(head);
        ListNode newHead = reverse(node);
        while(newHead != null){
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode o1){
        ListNode n1 = null;
        while(o1 != null){
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    private ListNode middle(ListNode head){
        ListNode p1 = head; //慢指针
        ListNode p2 = head; //快指针
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


    public boolean isPalindrome1(ListNode head) {
        ListNode p1 = head; //慢指针
        ListNode p2 = head; //快指针
        ListNode n1 = null; //新头
        ListNode o1 = head; //旧头
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

            //反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }

        if (p2 != null) { //链表有奇数个节点
            p1 = p1.next;
        }

        while(n1 != null){
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }



    public static void main(String[] args) {
        ListNode list = ListNode.of(1,2,3,2,1);
        System.out.println(new Leetcode234().isPalindrome1(list));
    }
}
