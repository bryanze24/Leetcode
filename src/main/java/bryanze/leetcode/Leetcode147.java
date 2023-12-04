package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

/**
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * @author lizelin
 * @date 2023/12/01
 */
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode lastSorted = head;
        ListNode curr = head.next;

        while (curr != null) {

            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;

            } else {

                ListNode prev = result;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }

                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }

            curr = lastSorted.next;
        }

        return result.next;
    }


    public ListNode insertionSortList1(ListNode head) {
        ListNode result = new ListNode(0, head);

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                ListNode temp = curr.next;
                curr.next = curr.next.next;

                ListNode prev = result;

                while (prev.next.val <= temp.val) {
                        prev = prev.next;
                }

                temp.next = prev.next;
                prev.next = temp;

            }
        }
        return result.next;

    }


    public static void main(String[] args) {
        ListNode head = ListNode.of(4, 2, 1, 3);
        ListNode listNode = new Leetcode147().insertionSortList1(head);
        System.out.println(listNode);
    }
}
