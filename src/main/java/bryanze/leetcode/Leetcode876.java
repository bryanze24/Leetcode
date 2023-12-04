package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 3, 4, 5, 6);
        ListNode list2 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new Leetcode876().middleNode(list1));
        System.out.println(new Leetcode876().middleNode(list2));
    }
}
