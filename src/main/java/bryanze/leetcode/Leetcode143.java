package bryanze.leetcode;

import bryanze.datastructure.linkedlist.ListNode;

import java.util.ArrayList;

/**
 * 给定一个单链表 L 的头节点 head ,单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯地改变节点内部的值，而是需要实际的进行节点交换
 */

public class Leetcode143 {
    public void reorderList(ListNode head) {
        ListNode node = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while(node != null){
            list.add(node);
            node = node.next;
        }

        int slow = 0;
        int fast = list.size() - 1;

        while (slow < fast){
            list.get(slow).next = list.get(fast);
            slow++;

            if(slow == fast){
                break;
            }

            list.get(fast).next = list.get(slow);
            fast--;
        }
        list.get(slow).next = null;
    }

    public void reorderList1(ListNode head){
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5, 6, 7);
        new Leetcode143().reorderList1(head);
        System.out.println(head);
    }
}
